/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

//import com.jcl.dbms.dbms;
import com.jcl.dao.*;
import com.jcl.model.*;
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
    PaySlipDetailDao psdDao;
    @Autowired
    DailyTimeRecordDao dtrDao;
    @Autowired
    OtherAdjustmentDao oaDao;
    private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_EVEN;

    @Transactional
    public List<Employee> employeeListForPayslip(Long payrollPeriodID, boolean finalized) {
        PayrollPeriod pp = ppDao.find(payrollPeriodID);
        List<Employee> list = eDao.getAllActiveEmployes();
        processPaySlip(list, pp, finalized);
        if(finalized){
            pp.setProcess(finalized);
            ppDao.save2(pp);
        }
        return list;
    }

    public List<PaySlipReportRow> employeeListForPayslipReports(Date dateFrom, Date dateTo, String[] filters) {
        List<PaySlipDetail> list = psDao.getAllPayslipByDateFromAndTo(dateFrom, dateTo);
        // loop through the list
        LinkedHashMap< String, PaySlipReportRow> psrList = new LinkedHashMap<String, PaySlipReportRow>();

        for (PaySlipDetail psd : list) {
            PaySlipReportRow psr = new PaySlipReportRow();

            String key = psd.getPaySlip().getEmployee().getId() + "-" + psr.getPaySlipDetailType();

            if (psrList.containsKey(key)) {
                psr = psrList.get(key);
            } else {
                psr.setEmployeeId(psd.getPaySlip().getEmployee().getId());
                psr.setEmployeeName(psd.getPaySlip().getEmployee().getName());
                psr.setEmployeeNumber(psd.getPaySlip().getEmployee().getIdNumber());
                psr.setPaySlipDetailType(psr.getPaySlipDetailType());
                psr.setPosition(psd.getPaySlip().getEmployee().getPosition().getDescription());
                psr.setPayrollPeriodCode(psd.getPaySlip().getPayrollPeriod().getPayrollPeriodCode());
                psr.setDate(psd.getPaySlip().getModifiedDate());
                psrList.put(key, psr);
            }

            double total = psr.getAmount();
            double amount = 0.0d;
            if (psd.getDeduction()) {
                amount = (psd.getTotal() * -1);
            }
            total = total + amount;
            psr.setAmount(total);
        }

        List<PaySlipReportRow> paySlipReportList = new ArrayList<PaySlipReportRow>(psrList.values());

        return paySlipReportList;
    }

    public void processPaySlip(List<Employee> employeeList, PayrollPeriod pp,boolean finalized) {
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
        processDTRs(employeeList, pp,finalized);
        createPayslipDetailFromDTR(employeeList,finalized);
        createPayslipForGovernment(employeeList, pp,finalized);
        createPayslipAutoAdjustment(employeeList,finalized);
        computeTaxWithHolding(employeeList,pp,finalized);
        
        for (Employee eep : employeeList) {          
            eep.getPayslip().getPayslipDetails().size();           
        }
    }
    // use in individual payslip processing and generate all payslip

    public void processDTRs(List<Employee> employeeList, PayrollPeriod pp, boolean finalized) {
        for (Employee emp : employeeList) {
            processIndividualDTR(emp, pp.getDateFrom(), pp.getDateTo(), DTRDisplayTypeStatus.Opened, finalized);
        }
    }

    public void processIndividualDTR(Employee employee, Date dateFrom, Date dateTo, DTRDisplayTypeStatus dtdts, boolean finalized) {

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
            dtr.setProcess(finalized);
            _list.add(dtr);
            if(finalized){
                dtrDao.save2(dtr);
            }
        }
        employee.setDtrTypeList(dtrTypeList);

    }

    private void createPayslipDetailFromDTR(List<Employee> employeeList, boolean finalized) {
        //create payslip detail from dtr
        for (Employee emp : employeeList) {
            LinkedHashMap<String, List<DailyTimeRecord>> dtrTypeList = emp.getDtrTypeList();
            int rowNumber = 1;
            for (DTRType dtrType : DTRType.values()) {
                if (dtrTypeList.containsKey(dtrType.toString())) {
                    List<DailyTimeRecord> dtrs = dtrTypeList.get(dtrType.toString());

                    PaySlip ps = emp.getPayslip();
                    PaySlipDetail psd = new PaySlipDetail(ps, dtrType.toString());

                    if (!OvertimeRateProvider.isOvertime(dtrType.toString())) {
                        String totalHours = computeTotalHoursInString(dtrs);

                        BigDecimal timeToDecimal = computeTimeToDecimal(totalHours);

                        psd.setDescription(dtrType.toString() + " " + totalHours);
                        psd.setOtherDescription(timeToDecimal.toString());

                        BigDecimal totalAmount = timeToDecimal.multiply(new BigDecimal(emp.getHourRate()));
                        psd.setQuantity(Double.valueOf(timeToDecimal.toPlainString()));

                        psd.setAmount(emp.getHourRate());
                        psd.setTotal(Double.valueOf(totalAmount.toPlainString()));
                        
                        psd.setTaxable(emp.getTax());

                        psd.setRowNumber(Integer.valueOf(rowNumber++));
                        psd.setGenerated(true);
                        psd.setDtr(true);
                        //TODO: need further thinking in SL_WP and VL_WP                        
                        if (dtrType == DTRType.Absent || dtrType == DTRType.Undertime || dtrType == DTRType.SL_WOP || dtrType == DTRType.VL_WOP) {
                            psd.setDeduction(Boolean.TRUE);
                            psd.setTaxable(Boolean.FALSE);                            
                            
                        } else if (dtrType == DTRType.SL_WP || dtrType == DTRType.VL_WP) {
                            psd.setDeduction(Boolean.FALSE);
                        }

                    } else {

                        BigDecimal totalSum = new BigDecimal(0d);
                        StringBuilder description = new StringBuilder();
                        for (DailyTimeRecord dtr : dtrs) {
                            String totalHours = dtr.getActualHours() + ":" + dtr.getActualMins();
                            BigDecimal timeToDecimal = computeTimeToDecimal(totalHours);
                            BigDecimal otr = OvertimeRateProvider.getDecimalRate(dtr.getDtrType(), dtr.getSection());
                            BigDecimal otrRate = new BigDecimal(emp.getHourRate()).multiply(otr);
                            BigDecimal totalAmount = timeToDecimal.multiply(otrRate);
                            description.append(timeToDecimal.toPlainString() + "x" + otrRate.toPlainString() + ",");
                            totalSum.add(totalAmount);
                        }

                        String totalHours = computeTotalHoursInString(dtrs);
                        BigDecimal timeToDecimal = computeTimeToDecimal(totalHours);

                        psd.setDescription(description.toString());
                        psd.setOtherDescription(totalHours);
                        psd.setQuantity(Double.valueOf(timeToDecimal.toPlainString()));
                        psd.setDtr(true);
                        psd.setAmount(emp.getHourRate());
                        psd.setTotal(Double.valueOf(totalSum.toPlainString()));
                        psd.setTaxable(emp.getTax());
                        psd.setRowNumber(Integer.valueOf(rowNumber++));
                        psd.setGenerated(true);

                    }
                    // this will reset WorkedHours payslip detail into Monthly or Daily paycode.
                    //workedhours psd.total is set to semi monthly amount.
                    if (psd.getPaySlipDetailType().toString().equals(DTRType.WorkedHours.toString())) {
                        if (emp.getPayCode().equals(PayrollPeriodCode.Monthly.toString())
                                && emp.getPayType().equals(PayrollPeriodType.SemiMonthly.toString())) {
                            BigDecimal salaryBig = new BigDecimal(emp.getSalary());
                            BigDecimal semiDiv = new BigDecimal("2");
                            BigDecimal semiSalary = salaryBig.divide(semiDiv, 2, RoundingMode.HALF_UP);
                            psd.setTotal(Double.valueOf(semiSalary.toPlainString()));
                        }
                    }
                    psd.setProcess(finalized);           
                    if(finalized){
                        psdDao.save2(psd);
                    }
                    ps.getPayslipDetails().add(psd);
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

    private void createPayslipForGovernment(List<Employee> employeeList, PayrollPeriod pp,boolean finalized) {

        for (Employee emp : employeeList) {
            Integer row = emp.getPayslip().getPayslipDetails().size();
            if (emp.getSss()) {
                PaySlipDetail psdSSS = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.SSS.toString());
                psdSSS.setDescription("SSS");
                psdSSS.setQuantity(0d);
                psdSSS.setAmount(0d);
                SSS sss = SSSProvider.getSSSContribution(emp.getSalary());
                psdSSS.setTotal(new BigDecimal(sss.getEe()).doubleValue());
                psdSSS.setDeduction(true);
                psdSSS.setTaxable(false);                
                psdSSS.setEmployeeContribution(sss.getEr());
                psdSSS.setGenerated(true);
                psdSSS.setRowNumber(row++);
                psdSSS.setProcess(finalized);
                if(finalized){
                        psdDao.save2(psdSSS);
                }
                emp.getPayslip().getPayslipDetails().add(psdSSS);
            }
            if (emp.getPhilhealth()) {
                PaySlipDetail psdPH = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.PhilHealth.toString());
                psdPH.setDescription("PhilHealth");
                psdPH.setQuantity(0d);
                psdPH.setAmount(0d);
                psdPH.setRowNumber(row++);
                psdPH.setTaxable(false);
                psdPH.setDeduction(true);
                Philhealth ph = PhilhealthProvider.getPhilhealthContribution(emp.getSalary());
                psdPH.setTotal(ph.getEe());
                psdPH.setEmployeeContribution(ph.getEr());
                psdPH.setGenerated(true);
                psdPH.setRowNumber(row++);
                psdPH.setProcess(finalized);
                if(finalized){
                        psdDao.save2(psdPH);
                }
                emp.getPayslip().getPayslipDetails().add(psdPH);
            }
            if (emp.getPagibig()) {
                PaySlipDetail psdPag = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.PagIbig.toString());
                psdPag.setDescription("Pag-ibig");
                psdPag.setQuantity(0d);
                psdPag.setAmount(0d);
                psdPag.setTaxable(false);
                psdPag.setRowNumber(row++);
                PagIbig pagIbig = PagibigProvider.pagIbigContribution(emp.getSalary());
                psdPag.setTotal(pagIbig.getEeS());
                psdPag.setEmployeeContribution(pagIbig.getErS());
                psdPag.setDeduction(true);
                psdPag.setGenerated(true);
                psdPag.setProcess(finalized);
                if(finalized){
                   psdDao.save2(psdPag);
                }
                emp.getPayslip().getPayslipDetails().add(psdPag);
            }
            
//            if (emp.getTax() ) {
//                PaySlipDetail psdTax = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.WTax.toString());
//                psdTax.setDescription("Withholding Tax");
//                psdTax.setQuantity(0d);
//                psdTax.setAmount(0d);
//                psdTax.setDeduction(true);
//                psdTax.setRowNumber(row++);
//                psdTax.setTotal(WithHoldingTaxProvider.taxWithHeld(emp.getTaxCode(), emp.getSalary()));
//                psdTax.setEmployeeContribution(0.0d);
//                psdTax.setGenerated(true);
//                emp.getPayslip().getPayslipDetails().add(psdTax);
//            }

        }


    }
    
    private void computeTaxWithHolding(List<Employee> employeeList, PayrollPeriod pp,boolean finalized) {

        for (Employee emp : employeeList) {
            Integer row = emp.getPayslip().getPayslipDetails().size();
            //need to loop through all payslipdetail and add all taxable amount
            // base on total amount  that will used to compute the tax withheld.
            if (emp.getTax()) {
                
                Double totalTaxableAmount =emp.getTotalTaxableIncome();
                
                PaySlipDetail psdTax = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.WTax.toString());
                psdTax.setDescription("Taxable amount: " + totalTaxableAmount);
                psdTax.setQuantity(0d);
                psdTax.setAmount(0d);
                psdTax.setDeduction(true);
                psdTax.setRowNumber(row++);
                psdTax.setTaxable(false);
                System.out.println("employee: " + emp.getName());
                if(emp.getTaxWithheld()>0d){
                    psdTax.setTotal(emp.getTaxWithheld());
                }else{
                    psdTax.setTotal(WithHoldingTaxProvider.taxWithHeld(emp.getTaxCode(), totalTaxableAmount));
                }
                psdTax.setEmployeeContribution(0.0d);
                psdTax.setGenerated(true);
                psdTax.setProcess(finalized);
                if(finalized){
                    psdDao.save2(psdTax);
                }
                emp.getPayslip().getPayslipDetails().add(psdTax);
            }

        }
    }

    private void createPayslipAutoAdjustment(List<Employee> employeeList,boolean finalized) {

        for (Employee emp : employeeList) {
            Integer row = emp.getPayslip().getPayslipDetails().size();
            for (OtherAdjustment oa : oaDao.getAdjustments()) {

                if (oa.getEveryPayroll()) {
                    PaySlipDetail payslip = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.Adjustment.toString());
                    payslip.setDescription(oa.getDescription());
                    payslip.setQuantity(0d);
                    payslip.setAmount(0d);
                    if (oa.getAdjustmentType().equals("less")) {
                        payslip.setTotal(oa.getAmount());
                        payslip.setDeduction(true);

                    } else {
                        payslip.setDeduction(false);
                        payslip.setTotal(oa.getAmount());
                    }
                    payslip.setTaxable(oa.getTaxable());
                    payslip.setEmployeeContribution(0d);
                    payslip.setGenerated(true);
                    payslip.setRowNumber(row++);
                    payslip.setProcess(finalized);
                    if(finalized){
                        psdDao.save2(payslip);
                    }
                    emp.getPayslip().getPayslipDetails().add(payslip);
                }
            }

            //benefits and others in semi monthly or per payroll period rates
            if (emp.getAllowance() > 0) {
                PaySlipDetail payslipAllowance = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.Others.toString());
                payslipAllowance.setDescription("Allowance");
                payslipAllowance.setQuantity(0d);
                payslipAllowance.setAmount(0d);

                payslipAllowance.setDeduction(false);
                payslipAllowance.setTotal(emp.getAllowance());
                payslipAllowance.setTaxable(true);
                payslipAllowance.setEmployeeContribution(0d);
                payslipAllowance.setGenerated(true);
                payslipAllowance.setRowNumber(row++);
                payslipAllowance.setProcess(finalized);
                    if(finalized){
                        psdDao.save2(payslipAllowance);
                    }
                emp.getPayslip().getPayslipDetails().add(payslipAllowance);
            }
            if (emp.getBenefits() > 0) {
                PaySlipDetail payslipAllowance = new PaySlipDetail(emp.getPayslip(), PayslipDetailType.Others.toString());
                payslipAllowance.setDescription("Benefits");
                payslipAllowance.setQuantity(0d);
                payslipAllowance.setAmount(0d);

                payslipAllowance.setDeduction(false);
                payslipAllowance.setTotal(emp.getBenefits());
                payslipAllowance.setTaxable(true);
                payslipAllowance.setEmployeeContribution(0d);
                payslipAllowance.setGenerated(true);
                payslipAllowance.setRowNumber(row++);
                payslipAllowance.setProcess(finalized);
                    if(finalized){
                        psdDao.save2(payslipAllowance);
                    }
                emp.getPayslip().getPayslipDetails().add(payslipAllowance);
            }

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
