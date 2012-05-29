/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.reports;

import com.jcl.hrm.Employee;
import com.jcl.payroll.enumtypes.PayrollPeriodStatus;
import com.jcl.payroll.enumtypes.PayrollPeriodType;
import com.jcl.payroll.transaction.PaySlip;
import com.jcl.payroll.transaction.PaySlipDetail;
import com.jcl.payroll.transaction.PaySlipProcess;
import com.jcl.payroll.transaction.PaySlipReportObject;
import com.jcl.payroll.transaction.PaySlipReportRow;
import com.jcl.payroll.transaction.PayrollPeriod;
import com.jcl.utilities.MyNumberFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author junald
 */
public class PayslipReports {

    public static ArrayList<Employee> processPayslip(int payrollPeriodID, Employee eep) throws Exception {

        System.out.println("processPayslip: " + payrollPeriodID + " employee: " + eep);
        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        PayrollPeriod pp = PayrollPeriod.getPayrollPeriodByTid(payrollPeriodID);
        LinkedHashMap<Integer, Employee> emplist = new LinkedHashMap<Integer, Employee>();
        System.out.println("payslipinformation x.1");
        if (pp.getStatus().equals(PayrollPeriodStatus.Generated.name())) {
            //note: if the status of the payroll period is generated, make sure the process will not run
            //just retrieve al payslip from the data base, this is not tested 03-02-2011
            System.out.println("payslipinformation x.1.1");
            List<Employee> empList2 = Employee.getEmployees(PayrollPeriodType.valueOf(pp.getPayrollPeriodType()));
            LinkedHashMap<Integer, PaySlip> paySlipList = PaySlip.getPayslipByEmployee(pp, null);
            for (Employee e : empList2) {
                e.payslip = paySlipList.get(e.getTid());
                emplist.put(e.getTid(), e);
            }

        } else {
            System.out.println("payslipinformation x.1.2");
            emplist = PaySlipProcess.processPayslip(pp, eep);
        }

//        SimpleDateFormat sdf = MyDateFormatter.getSimpleDateTimeFormatter2();
//
//
//        HashMap parameters = new HashMap();
//        CompanySetting cs = CompanySetting.companySetting();
//
//        parameters.put("REPORT_TITLE", cs.getCompanyName());
//        String payroll_period = pp.getPayrollPeriodCode() + " - [" + sdf.format(pp.getDateFrom()) + "-" + sdf.format(pp.getDateTo()) + "]";
//        parameters.put("PAYROLL_PERIOD", "Payroll Period: " + payroll_period);
//        parameters.put("DATE_GENERATED", sdf.format(pp.getDatePrepared()));
//        parameters.put("PREPARED_BY", dbms.user.getFullName());
//        parameters.put("SUBREPORT_DIR", dbms.codebaseReports);

        for (Employee emp : emplist.values()) {

//                if (emp.payslip.getPayslipDetails().size() == 0) {
//                    continue;
//                }

            PaySlipReportObject psro = new PaySlipReportObject();
            psro.setEmployeeTid(emp.getTid());

            System.out.println(emp.payslip.getPayrollPeriod().getPayrollPeriodCode());

            double totalAdd = 0;
            int row = 1;
            for (PaySlipDetail psd : emp.payslip.getPayables()) {
                PaySlipReportRow psrr = new PaySlipReportRow();
                psrr.setRow(row++);
                String psdString = psd.getDescription() + " (" + psd.getQuantity() + " X " + MyNumberFormatter.formatAmount(psd.getAmount()) + ") / " + psd.getNoOfLoader();
                psrr.setDescription(psdString);
                psrr.setEmployeeName("Name: " + emp.getName());

                psrr.setPosition(emp.getPosition().getDescription());
                psrr.setAmount(psd.getTotal());
                psro.getList().add(psrr);
                totalAdd = totalAdd + psd.getTotal();
                System.out.println(psd.getRowNumber() + "     " + psd.getDescription() + " " + psd.getTotal());
            }

            double totalLess = 0;
            for (PaySlipDetail psd : emp.payslip.getReceivables()) {

                PaySlipReportRow psrr = new PaySlipReportRow();
                psrr.setRow(row++);
                psrr.setDescription(psd.getDescription());
                psrr.setEmployeeName(emp.getName());
                psrr.setPosition(emp.getPosition().getDescription());
                psrr.setAmount(psd.getTotal());
                psro.getList().add(psrr);

                totalLess = totalLess + psd.getTotal();

                System.out.println(psd.getRowNumber() + "     " + psd.getDescription() + " " + psd.getTotal());
            }
            psro.setNetTotal(totalAdd - totalLess);
            emp.payslipReport = psro;

            employeeList.add(emp);

        }



        return employeeList;
    }
}
