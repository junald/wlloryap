/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.reports;

import com.jcl.dbms.dbms;
import com.jcl.model.*;
import com.jcl.payroll.enumtypes.PayrollPeriodCode;
import com.jcl.payroll.enumtypes.PayrollPeriodStatus;
import com.jcl.payroll.enumtypes.PayrollPeriodType;
import com.jcl.payroll.transaction.PaySlipProcess;
import com.jcl.payroll.transaction.PaySlipReportObject;
import com.jcl.payroll.transaction.PaySlipReportRow;
import com.jcl.utilities.MyDateFormatter;
import com.jcl.utilities.MyNumberFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author junald
 */
@Service
public class PayslipReports {

//    public static ArrayList<Employee> processPayslip(Long payrollPeriodID, Employee eep) throws Exception {
//
//        System.out.println("processPayslip: " + payrollPeriodID + " employee: " + eep);
//        ArrayList<Employee> employeeList = new ArrayList<Employee>();
//
//        PayrollPeriod pp = PayrollPeriod.getPayrollPeriodByTid(payrollPeriodID);
//        LinkedHashMap<Long, Employee> emplist = new LinkedHashMap<Long, Employee>();
//        System.out.println("payslipinformation x.1");
//        if (pp.getStatus().equals(PayrollPeriodStatus.Generated.name())) {
//            //note: if the status of the payroll period is generated, make sure the process will not run
//            //just retrieve al payslip from the data base, this is not tested 03-02-2011
//            System.out.println("payslipinformation x.1.1");
//            List<Employee> empList2 = Employee.getEmployees(PayrollPeriodType.valueOf(pp.getPayrollPeriodType()));
//            LinkedHashMap<Long, PaySlip> paySlipList = PaySlip.getPayslipByEmployee(pp, null);
//            for (Employee e : empList2) {
//                e.setPayslip(paySlipList.get(e.getId()));
//                emplist.put(e.getId(), e);
//            }
//
//        } else {
//            System.out.println("payslipinformation x.1.2");
//            emplist = PaySlipProcess.processPayslip(pp, eep);
//        }
//
////        SimpleDateFormat sdf = MyDateFormatter.getSimpleDateTimeFormatter2();
////
////
////        HashMap parameters = new HashMap();
////        CompanySetting cs = CompanySetting.companySetting();
////
////        parameters.put("REPORT_TITLE", cs.getCompanyName());
////        String payroll_period = pp.getPayrollPeriodCode() + " - [" + sdf.format(pp.getDateFrom()) + "-" + sdf.format(pp.getDateTo()) + "]";
////        parameters.put("PAYROLL_PERIOD", "Payroll Period: " + payroll_period);
////        parameters.put("DATE_GENERATED", sdf.format(pp.getDatePrepared()));
////        parameters.put("PREPARED_BY", dbms.user.getFullName());
////        parameters.put("SUBREPORT_DIR", dbms.codebaseReports);
//
//        for (Employee emp : emplist.values()) {
//
////                if (emp.payslip.getPayslipDetails().size() == 0) {
////                    continue;
////                }
//
//            PaySlipReportObject psro = new PaySlipReportObject();
//            psro.setEmployeeTid(emp.getId());
//
//            System.out.println(emp.getPayslip().getPayrollPeriod().getPayrollPeriodCode());
//
//            double totalAdd = 0;
//            int row = 1;
////            for (PaySlipDetail psd : emp.getPayslip().getPayables()) {
////                PaySlipReportRow psrr = new PaySlipReportRow();
////                psrr.setRow(row++);
////                String psdString = psd.getDescription() + " (" + 0 + " X " + MyNumberFormatter.formatAmount(psd.getAmount()) + ") / " + 1;
////                psrr.setDescription(psdString);
////                psrr.setEmployeeName("Name: " + emp.getName());
////
////                psrr.setPosition(emp.getPosition().getDescription());
////                psrr.setAmount(psd.getTotal());
////                psro.getList().add(psrr);
////                totalAdd = totalAdd + psd.getTotal();
////                System.out.println(psd.getRowNumber() + "     " + psd.getDescription() + " " + psd.getTotal());
////            }
//
//            double totalLess = 0;
////            for (PaySlipDetail psd : emp.getPayslip().getReceivables()) {
////
////                PaySlipReportRow psrr = new PaySlipReportRow();
////                psrr.setRow(row++);
////                psrr.setDescription(psd.getDescription());
////                psrr.setEmployeeName(emp.getName());
////                psrr.setPosition(emp.getPosition().getDescription());
////                psrr.setAmount(psd.getTotal());
////                psro.getList().add(psrr);
////
////                totalLess = totalLess + psd.getTotal();
////
////                System.out.println(psd.getRowNumber() + "     " + psd.getDescription() + " " + psd.getTotal());
////            }
//            psro.setNetTotal(totalAdd - totalLess);
//            emp.setPayslipReport(psro);
//
//            employeeList.add(emp);
//
//        }
//
//
//
//        return employeeList;
//    }
    public static List<Employee> processPayslip(List<Employee> employeeList, PayrollPeriod pp) throws Exception {


        SimpleDateFormat sdf = MyDateFormatter.getSimpleDateTimeFormatter2();

        for (Employee emp : employeeList) {

            if (emp.getPayslip() == null || emp.getPayslip().getPayslipDetails().size() == 0) {
                continue;
            }

            PaySlipReportObject psro = new PaySlipReportObject();
            psro.setEmployeeTid(emp.getId());
            System.out.println(emp.getPayslip().getPayrollPeriod().getPayrollPeriodCode());

            double totalAdd = 0;
            int row = 1;
            for (PaySlipDetail psd : emp.getPayslip().getCompensations()) {
                PaySlipReportRow psrr = new PaySlipReportRow();
                psrr.setRow(row++);
                String psdString = psd.getDescription();
                if(psd.getDtr()){
                    if(emp.getPayCode().equals(PayrollPeriodCode.Daily)){
                        psdString = psd.getDescription() + " (" + MyNumberFormatter.formatAmount(psd.getQuantity()) + " X " + MyNumberFormatter.formatAmount(psd.getAmount()) + ")";
                    }else{
                        psdString = psd.getDescription() + " ("+ MyNumberFormatter.formatAmount(psd.getQuantity()) + ")";
                    }
                }

                psrr.setDescription(psdString);
                psrr.setEmployeeName("Name: " + emp.getName());

                psrr.setPosition(emp.getPosition().getDescription());
                psrr.setAmount(psd.getTotal());
                psro.getList().add(psrr);
                totalAdd = totalAdd + psd.getTotal();
                System.out.println(psd.getRowNumber().toString() + "  "+psd.getPaySlipDetailType() +"     " + psd.getDescription() + " " + psd.getTotal());
            }
//
            double totalLess = 0;
            for (PaySlipDetail psd : emp.getPayslip().getDeductions()) {

                PaySlipReportRow psrr = new PaySlipReportRow();
                psrr.setRow(row++);

                String psdString = psd.getDescription();
                if (psd.getPaySlipDetailType().equals("WorkedHours")
                        || psd.getPaySlipDetailType().equals("VL")
                        || psd.getPaySlipDetailType().equals("SL")
                        || psd.getPaySlipDetailType().equals("Overtime")
                        || psd.getPaySlipDetailType().equals("Undertime")
                        || psd.getPaySlipDetailType().equals("Holiday")
                        || psd.getPaySlipDetailType().equals("Absent")) {
                    psdString = psd.getDescription() + " (" + MyNumberFormatter.formatAmount(psd.getQuantity()) + " X " 
                            + MyNumberFormatter.formatAmount(psd.getAmount()) + ")";

                }
                psrr.setDescription(psdString);

                psrr.setEmployeeName(emp.getName());
                psrr.setPosition(emp.getPosition().getDescription());
                psrr.setAmount(psd.getTotal() * -1);
                psro.getList().add(psrr);

                totalLess = totalLess + psd.getTotal();
                System.out.println(psd.getRowNumber().toString() + "  "+psd.getPaySlipDetailType() +"     " +
                        psd.getDescription() + " " + psd.getTotal());
                
            }

            psro.setNetTotal(Double.valueOf(totalAdd - totalLess));
            emp.setPayslipReport(psro);
        }


        return employeeList;
    }
}
