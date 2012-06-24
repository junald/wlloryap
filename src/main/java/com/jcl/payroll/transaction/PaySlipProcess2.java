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
import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.jcl.payroll.data.PagIbig;

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
        List<Employee> list =eDao.getAllActiveEmployes();
        processPaySlip(list, pp);
        return list;
    }
    
    
    public List<PaySlipReportRow> employeeListForPayslipReports(Date dateFrom, Date dateTo, String[] filters) {        
        List<PaySlipDetail> list = psDao.getAllPayslipByDateFromAndTo(dateFrom, dateTo);
        // loop through the list
        LinkedHashMap< String, PaySlipReportRow> psrList = new LinkedHashMap<String, PaySlipReportRow>();
        
        for(PaySlipDetail psd: list){
            PaySlipReportRow psr = new PaySlipReportRow();
            
            String key = psd.getPaySlip().getEmployee().getId() +"-"+psr.getPaySlipDetailType();
            
            if(psrList.containsKey(key)){
                psr = psrList.get(key);               
            }else{
                psr.setEmployeeId(psd.getPaySlip().getEmployee().getId());
                psr.setEmployeeName(psd.getPaySlip().getEmployee().getName());
                psr.setEmployeeNumber(psd.getPaySlip().getEmployee().getIdNumber());                                
                psr.setPaySlipDetailType(psr.getPaySlipDetailType());
                psr.setPosition(psd.getPaySlip().getEmployee().getPosition().getDescription());
                psr.setPayrollPeriodCode(psd.getPaySlip().getPayrollPeriod().getPayrollPeriodCode());
                psr.setDate(psd.getPaySlip().getModifiedDate());
                psrList.put(key,psr);
            }
            
            double total = psr.getAmount();
            double amount = 0.0d;
            if(psd.getDeduction()){
                amount = (psd.getTotal()*-1);                
            }
            total = total + amount;
            psr.setAmount(total);                                    
        }
        
        List<PaySlipReportRow> paySlipReportList = new ArrayList<PaySlipReportRow>(psrList.values());
        
        return paySlipReportList;
    }
    
    

    public void processPaySlip(List<Employee> employeeList, PayrollPeriod pp) {
        for (Employee emp : employeeList) {

            PaySlip ps = psDao.getPayslipByPayPeriodAndEmployee(emp, pp.getId());
            if (ps == null) {
                ps = new PaySlip(emp, pp);
                psDao.save2(ps);

            } else {
                if (ps.getPayslipDetails() == null) {
                    ps.setPayslipDetails(new ArrayList<PaySlipDetail>());
                }
            }
            emp.setPayslip(ps);
        }
        processDTRs(employeeList, pp);
        createPayslipDetailFromDTR(employeeList);
        createPayslipForGovernment(employeeList, pp);
        for (Employee eep : employeeList) {
            eep.getPayslip().getPayslipDetails().size();
        }
    }
    // use in individual payslip processing and generate all payslip
    public void processDTRs(List<Employee> employeeList, PayrollPeriod pp) {
        for (Employee emp : employeeList) {
            processIndividualDTR(emp, pp.getDateFrom(),pp.getDateTo(), DTRDisplayTypeStatus.Opened);
        }
    }

    public void processIndividualDTR(Employee employee, Date dateFrom, Date dateTo, DTRDisplayTypeStatus dtdts) {

        List<DailyTimeRecord> dtrList = dtrDao.getDailyTimeRecordsByDateAndEmployee(employee, dateFrom, dateTo, dtdts);
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

    private void createPayslipDetailFromDTR(List<Employee> employeeList) {
        //create payslip detail from dtr
        for (Employee emp : employeeList) {
            LinkedHashMap<String, List<DailyTimeRecord>> dtrTypeList = emp.getDtrTypeList();
            int rowNumber = 1;
            for (DTRType dtrType : DTRType.values()) {
                if (dtrTypeList.containsKey(dtrType.toString())) {
                    List<DailyTimeRecord> dtrs = dtrTypeList.get(dtrType.toString());

                    if (!OvertimeRateProvider.isOvertime(dtrType.toString())) {
                        String totalHours = computeTotalHoursInString(dtrs);

                        BigDecimal timeToDecimal = computeTimeToDecimal(totalHours);

                        PaySlip ps = emp.getPayslip();

                        PaySlipDetail psd = new PaySlipDetail(ps, dtrType.toString());
                        psd.setDescription(dtrType.toString() + " " + totalHours);
                        psd.setOtherDescription(timeToDecimal.toString());

                        BigDecimal totalAmount = timeToDecimal.multiply(new BigDecimal(emp.getHourRate()));
                        psd.setQuantity(Double.valueOf(timeToDecimal.toPlainString()));
                     
                        psd.setAmount(emp.getHourRate());
                        psd.setTotal(Double.valueOf(totalAmount.toPlainString()));
                        psd.setTaxable(true);

                        psd.setRowNumber(Integer.valueOf(rowNumber++));
                        psd.setGenerated(true);
                        ps.getPayslipDetails().add(psd);
                    } else {

                        BigDecimal totalSum = new BigDecimal(0d);
                        StringBuilder description = new StringBuilder();
                        for (DailyTimeRecord dtr : dtrs) {
                            String totalHours = dtr.getActualHours() + ":" + dtr.getActualMins();
                            BigDecimal timeToDecimal = computeTimeToDecimal(totalHours);
                            BigDecimal otr = OvertimeRateProvider.getDecimalRate(dtr.getDtrType(), dtr.getSection());
                            BigDecimal otrRate = new BigDecimal(emp.getHourRate()).multiply(otr);
                            BigDecimal totalAmount = timeToDecimal.multiply(otrRate);                            
                            description.append(timeToDecimal.toPlainString() +"x"+ otrRate.toPlainString()+" ");                                    
                            totalSum.add(totalAmount);
                        }
                        String totalHours = computeTotalHoursInString(dtrs);
                        BigDecimal timeToDecimal = computeTimeToDecimal(totalHours);

                        PaySlip ps = emp.getPayslip();

                        PaySlipDetail psd = new PaySlipDetail(ps, dtrType.toString());

                        psd.setDescription(description.toString());
                        psd.setOtherDescription(totalHours);
                        psd.setQuantity(Double.valueOf(timeToDecimal.toPlainString()));
                   
                        psd.setAmount(emp.getHourRate());
                        psd.setTotal(Double.valueOf(totalSum.toPlainString()));
                        psd.setTaxable(true);

                        psd.setRowNumber(Integer.valueOf(rowNumber++));
                        psd.setGenerated(true);
                        ps.getPayslipDetails().add(psd);

                    }                    
                    
                }

            }
        }
       
    }

    public boolean isDeductionDTR(String name) {

        boolean status = false;
        DTRType dtrt = DTRType.valueOf(name);
        if (dtrt == DTRType.Absent) {
            status = true;
        } else if (dtrt == DTRType.Undertime) {
            status = true;
        }
        return status;
    }

    public BigDecimal computeTimeToDecimal(String totalHours) {

        String[] splitTime = totalHours.split(":");
        BigDecimal splitMinute = new BigDecimal(splitTime[1]);
        BigDecimal minutes = new BigDecimal("60");
        BigDecimal decimalMinute = splitMinute.divide(minutes, 2, RoundingMode.HALF_UP);
        BigDecimal splitHour = new BigDecimal(splitTime[0]);
        return splitHour.add(decimalMinute);
    }

    public Integer computeTotalHoursInMinutes(String totalHours) {
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

    private void createPayslipForGovernment(List<Employee> employeeList, PayrollPeriod pp) {

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
            psdPag.setRowNumber(row++);
            PagIbig pagIbig=  PagibigProvider.pagIbigContribution(emp.getSalary());
            psdPag.setTotal( pagIbig.getEeS() );
            psdPag.setEmployeeContribution(pagIbig.getErS());
            psdPag.setDeduction(true);
            psdPag.setGenerated(true);
            emp.getPayslip().getPayslipDetails().add(psdPag);

            PaySlipDetail psdTax = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.WTax.toString());
            psdTax.setDescription("Withholding Tax");
            psdTax.setQuantity(0d);
            psdTax.setAmount(0d);
            psdTax.setDeduction(true);
            psdTax.setRowNumber(row++);            
            psdTax.setTotal(WithHoldingTaxProvider.taxWithHeld(emp.getTaxCode(), emp.getSalary()));
            psdTax.setEmployeeContribution(0.0d);
            psdTax.setGenerated(true);
            emp.getPayslip().getPayslipDetails().add(psdTax);


        }
    }
    
    
    //not used
    public BigDecimal computeHotalHours(int time, double hourlyRate) {
        //  DecimalFormat df = new DecimalFormat("#,##0.00;(#,##0.00)");
        // BigDecimal hourRate = new BigDecimal(df.format(hourlyRate).toString());
        BigDecimal hourRate = new BigDecimal(hourlyRate);
        System.out.println(hourRate);
        BigDecimal minutes = new BigDecimal("60");
        System.out.println(minutes);
        BigDecimal minuteRate = hourRate.divide(minutes, 2, RoundingMode.HALF_UP);
        System.out.println(minuteRate);
        BigDecimal totalMinute = new BigDecimal(time);
        System.out.println(totalMinute);
        BigDecimal netAmount = minuteRate.multiply(totalMinute);
        return netAmount;
    }
    //not used
}
