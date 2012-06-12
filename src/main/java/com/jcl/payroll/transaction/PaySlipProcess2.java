/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

//import com.jcl.dbms.dbms;
import com.jcl.dao.DailyTimeRecordDao;
import com.jcl.dao.EmployeeDao;
import com.jcl.dao.PaySlipDao;
import com.jcl.dao.PayrollPeriodDao;
import com.jcl.model.PayrollPeriod;
import com.jcl.model.PaySlip;
import com.jcl.model.PaySlipDetail;
import com.jcl.model.Employee;
import com.jcl.model.DailyTimeRecord;
import com.jcl.payroll.data.Philhealth;
import com.jcl.payroll.data.SSS;
import com.jcl.payroll.enumtypes.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jlavador
 */
@Service
public class PaySlipProcess2 {

    @Autowired
    PayrollPeriodDao ppDao;
    @Autowired
    EmployeeDao eDao;
    @Autowired
    PaySlipDao psDao;
    @Autowired
    DailyTimeRecordDao dtrDao;

     private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_EVEN;
     
    @Transactional
    public List<Employee> employeeListForPayslip(Long payrollPeriodID) {
        PayrollPeriod pp = ppDao.find(payrollPeriodID);
        List<Employee> list = new ArrayList<Employee>();
//        System.out.println(PayrollPeriodStatus.Closed.name());
//        if (pp.getStatus().equals(PayrollPeriodStatus.Closed.name())) {           //BEFORE: generated.
//            list = psDao.getAllPayslipBaseOnEmployee(pp);             
//        } else {
//        
//        }
        list = eDao.getAllActiveEmployes();
        processPaySlip(list,pp);
        return list;
    }
   
    public void processPaySlip(List<Employee> employeeList, PayrollPeriod pp) {
        for (Employee emp : employeeList) {
            
            PaySlip ps = psDao.getPayslipByPayPeriodAndEmployee(emp, pp.getId());
            if (ps == null) {
                ps = new PaySlip(emp, pp);
                psDao.save2(ps);
                
            }else{
                if(ps.getPayslipDetails() == null){
                    ps.setPayslipDetails(new ArrayList<PaySlipDetail>());
                }
            }
            emp.setPayslip(ps);
        }
        processDTRs(employeeList, pp);
        processPayslipDTR(employeeList, pp);
        processPayslipGoverment(employeeList, pp);
        for(Employee eep: employeeList){
            eep.getPayslip().getPayslipDetails().size();
        }
    }

    public void processDTRs(List<Employee> employeeList, PayrollPeriod pp) {
        for (Employee emp : employeeList) {
            processIndividualDTR(emp, pp, DTRDisplayTypeStatus.Opened);            
        }
    }

    public void processIndividualDTR(Employee employee, PayrollPeriod pp, DTRDisplayTypeStatus dtdts) {

        List<DailyTimeRecord> dtrList = dtrDao.getDailyTimeRecordsByDateAndEmployee(employee, pp.getDateFrom(), pp.getDateTo(), dtdts);
        System.out.println(employee.getName() + " : dtr counts: " + dtrList.size());
        LinkedHashMap<String, List<DailyTimeRecord>> dtrTypeList = new LinkedHashMap<String, List<DailyTimeRecord>>();
        for (DailyTimeRecord dtr : dtrList) {
            List<DailyTimeRecord> _list = new ArrayList<DailyTimeRecord>();
            if (!dtrTypeList.containsKey(dtr.getDtrType())) {
                dtrTypeList.put(dtr.getDtrType(), _list);
            } else {
                _list = dtrTypeList.get(dtr.getDtrType());
            }
            _list.add(dtr);
        }
        employee.setDtrTypeList(dtrTypeList);
    }

    private void processPayslipDTR(List<Employee> employeeList, PayrollPeriod pp) {
        //create payslip detail from dtr
        for (Employee emp : employeeList) {
            LinkedHashMap<String, List<DailyTimeRecord>> dtrTypeList = emp.getDtrTypeList();
            int rowNumber = 1;
            for (DTRType dtrType : DTRType.values()) {
                if (dtrTypeList.containsKey(dtrType.toString())) {
                    List<DailyTimeRecord> dtrs = dtrTypeList.get(dtrType.toString());
                    String totalHours = computeTotalHoursInString(dtrs);
                    
                    
                    BigDecimal timeToDecimal = computeTimeToDecimal(totalHours);
                    
                    PayslipDetailType psdt = PayslipDetailType.valueOf(dtrType.toString());
                    
                    PaySlip ps = emp.getPayslip();
                    
                    PaySlipDetail psd = new PaySlipDetail(ps, psdt.toString());
                    psd.setDescription(psdt.toString() +" " + totalHours);                         
                    psd.setOtherDescription(timeToDecimal.toString());
                    
                    BigDecimal totalAmount =timeToDecimal.multiply(new BigDecimal(emp.getHourRate())) ;
                    psd.setQuantity(Double.valueOf(timeToDecimal.toPlainString()));
                  
                    System.out.println("totalAmount: " + totalAmount.toPlainString());
                    psd.setAmount(emp.getHourRate());
                    psd.setTotal(Double.valueOf(totalAmount.toPlainString()));
                    System.out.println("psd.description: " + psd.getDescription());
                    psd.setTaxable(true);
                    if(dtrType == DTRType.Absent || dtrType == DTRType.Undertime){
                        psd.setDeduction(true);
                    }else if(dtrType == DTRType.SL && emp.getSickLeave() >=0) {                        
                        psd.setDeduction(true);                       
                    }else if(dtrType == DTRType.VL && emp.getVacationLeave() >=0) {                        
                        psd.setDeduction(true);                       
                    }else{
                        psd.setDeduction(false);                       
                    }     
                   
//                    if(ps.getPayslipDetails()!= null ){
//                        rowNumber = ps.getPayslipDetails().size() + 1 ;
//                    }
                    psd.setRowNumber(Integer.valueOf(rowNumber++));     
                    psd.setGenerated(true);
                    ps.getPayslipDetails().add(psd);
                    
                }

            }
        }

        //create payslip form goverment contributions.         
        //if pp is generated or closed, don't generated goverment contributions and deductions.
    }
    
    public boolean isDeductionDTR(String name){
        
        boolean status = false;
        DTRType dtrt = DTRType.valueOf(name);
        if(dtrt == DTRType.Absent){
            status = true;
        }else if(dtrt == DTRType.Undertime){
            status = true;
        } 
        return status;
    }
    
    public BigDecimal computeTimeToDecimal(String totalHours){
        
        String[] splitTime = totalHours.split(":");
        BigDecimal splitMinute = new BigDecimal(splitTime[1]);
        BigDecimal minutes = new BigDecimal("60");
        BigDecimal decimalMinute =  splitMinute.divide(minutes, 2, RoundingMode.HALF_UP);
        BigDecimal splitHour = new BigDecimal(splitTime[0]);
        return splitHour.add(decimalMinute);
    }
    //not used
    public BigDecimal computeHotalHours(int time, double hourlyRate){
      //  DecimalFormat df = new DecimalFormat("#,##0.00;(#,##0.00)");
       // BigDecimal hourRate = new BigDecimal(df.format(hourlyRate).toString());
        BigDecimal hourRate = new BigDecimal(hourlyRate);
        System.out.println(hourRate);
        BigDecimal minutes = new BigDecimal("60");
        System.out.println(minutes);
        BigDecimal minuteRate =  hourRate.divide(minutes, 2, RoundingMode.HALF_UP);
        System.out.println(minuteRate);
        BigDecimal totalMinute = new BigDecimal(time);
        System.out.println(totalMinute);
        BigDecimal netAmount = minuteRate.multiply(totalMinute);
        return  netAmount;
    }
    //not used
    public Integer computeTotalHoursInMinutes(String totalHours){
        String[] splitTime = totalHours.split(":");
        Integer minutes = Integer.valueOf(splitTime[0]) * 60;
        minutes = minutes + Integer.valueOf(splitTime[1]);        
        return minutes;
    }

    public String computeTotalHoursInString(List<DailyTimeRecord> list) {
        int totalHours = 0;
        int totalMinutes = 0;

        for (DailyTimeRecord v : list) {
            totalHours = totalHours + v.getActualHours();
            totalMinutes = totalMinutes + v.getActualMins();
        }

        String tm = "0:0";
        if (totalMinutes >= 60) {
            int _hm = totalMinutes >= 60 ? (totalMinutes / 60) : totalMinutes;
            int _rm = totalMinutes % (totalMinutes >= 60 ? 60 : totalMinutes);
            tm = (totalHours + _hm) + ":" + _rm;
        } else {
            tm = totalHours + ":" + totalMinutes;
        }

        return tm;
    }

    private void processPayslipGoverment(List<Employee> employeeList, PayrollPeriod pp) {
        
        for (Employee emp : employeeList) {
              Integer row = 1;
              PaySlipDetail psdSSS = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.SSS.toString());
              psdSSS.setDescription("SSS");
              psdSSS.setQuantity(0d);
              psdSSS.setAmount(0d);
              SSS sss = SSSProvider.getSSSContribution(emp.getSalary());
              psdSSS.setTotal(sss.getEe());
              psdSSS.setDeduction(true);
              psdSSS.setEmployeeContribution(sss.getEr());
              psdSSS.setGenerated(true);
              psdSSS.setRowNumber(row++);
              emp.getPayslip().getPayslipDetails().add(psdSSS);
              
              PaySlipDetail psdPH = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.PhilHealth.toString());
              psdPH.setDescription("PhilHealth");
              psdPH.setQuantity(0d);
              psdPH.setAmount(0d);
              psdPH.setRowNumber(row++);
              psdPH.setDeduction(true);
              Philhealth ph = PhilhealthProvider.getPhilhealthContribution(emp.getSalary());
              psdPH.setTotal(ph.getEe());
              psdPH.setEmployeeContribution(ph.getEr());
              psdPH.setGenerated(true);
              psdPH.setRowNumber(row++);
              emp.getPayslip().getPayslipDetails().add(psdPH);
              
              PaySlipDetail psdPag = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.PagIbig.toString());
              psdPag.setDescription("Pag-ibig");
              psdPag.setQuantity(0d);
              psdPag.setAmount(0d);
              //SSS sss = SSSProvider.getSSSContribution(emp.getSalary());
              psdPag.setRowNumber(row++);
              psdPag.setTotal(10d);
              psdPag.setDeduction(true);
              psdPag.setEmployeeContribution(10d);
              psdPag.setGenerated(true);
              emp.getPayslip().getPayslipDetails().add(psdPag);
              
              PaySlipDetail psdTax = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.WTax.toString());
              psdTax.setDescription("Withholding Tax");
              psdTax.setQuantity(0d);
              psdTax.setAmount(0d);
              psdTax.setDeduction(true);
              psdTax.setRowNumber(row++);
              //Philhealth ph = PhilhealthProvider.getPhilhealthContribution(emp.getSalary());
              psdTax.setTotal(10d);
              psdTax.setEmployeeContribution(10d);
              psdTax.setGenerated(true);
              emp.getPayslip().getPayslipDetails().add(psdTax);
              
              
          }
    }
}
