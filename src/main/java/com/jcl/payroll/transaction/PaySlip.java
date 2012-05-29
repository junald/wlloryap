/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

 
//import com.jcl.dbms.dbms;
import com.jcl.hrm.Employee;
import com.jcl.payroll.enumtypes.PayrollPeriodType;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author junald
 */
public class PaySlip {

    private int tid = -1;
    private transient Employee employee;
    private transient PayrollPeriod payrollPeriod;
    private int employeeTid;
    private int payrollPeriodTid;
    private String description;
    private String others;
    private transient List<PaySlipDetail> payslipDetails = new ArrayList<PaySlipDetail>();
    private String status;
    private String modifiedBy;
    private String preparedBy;
    private Date modifiedDate;
    private int rowCounter = 0;

    public PaySlip() {
    }

    public PaySlip(Employee emp, PayrollPeriod pp) {
        this.employee = emp;
        this.payrollPeriod = pp;
        this.payrollPeriodTid = pp.getTid();
        this.employeeTid = emp.getTid();
        payslipDetails = new ArrayList<PaySlipDetail>();
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the payrollPeriod
     */
    public PayrollPeriod getPayrollPeriod() {
        return payrollPeriod;
    }

    /**
     * @param payrollPeriod the payrollPeriod to set
     */
    public void setPayrollPeriod(PayrollPeriod payrollPeriod) {
        this.payrollPeriod = payrollPeriod;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the others
     */
    public String getOthers() {
        return others;
    }

    /**
     * @param others the others to set
     */
    public void setOthers(String others) {
        this.others = others;
    }

    /**
     * @return the payslipDetails
     */
    public List<PaySlipDetail> getPayslipDetails() {
        return payslipDetails;
    }

    /**
     * @param payslipDetails the payslipDetails to set
     */
    public void setPayslipDetails(List<PaySlipDetail> payslipDetails) {
        this.payslipDetails = payslipDetails;
    }

    /**
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the preparedBy
     */
    public String getPreparedBy() {
        return preparedBy;
    }

    /**
     * @param preparedBy the preparedBy to set
     */
    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    /**
     * @return the modifiedDate
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the tid
     */
    public int getTid() {
        return tid;
    }

    /**
     * @param tid the tid to set
     */
    public void setTid(int tid) {
        this.tid = tid;
    }

    public List<PaySlipDetail> getPayables() {
        List<PaySlipDetail> list = new ArrayList<PaySlipDetail>();
        for (PaySlipDetail psd : payslipDetails) {
            if (!psd.isIsDeduction()) {
                list.add(psd);
            }
        }
        return list;
    }

    public List<PaySlipDetail> getReceivables() {
        List<PaySlipDetail> list = new ArrayList<PaySlipDetail>();
        for (PaySlipDetail psd : payslipDetails) {
            if (psd.isIsDeduction()) {
                list.add(psd);
            }
        }
        return list;
    }

    /**
     * @return the rowCounter
     */
    public int getRowCounter() {
        return rowCounter;
    }

    /**
     * @param rowCounter the rowCounter to set
     */
    public void setRowCounter(int rowCounter) {
        this.rowCounter = rowCounter;
    }

    /**
     * @return the payrollPeriodTid
     */
    public int getPayrollPeriodTid() {
        return payrollPeriodTid;
    }

    /**
     * @param payrollPeriodTid the payrollPeriodTid to set
     */
    public void setPayrollPeriodTid(int payrollPeriodTid) {
        this.payrollPeriodTid = payrollPeriodTid;
    }

    /**
     * @return the employeeTid
     */
    public int getEmployeeTid() {
        return employeeTid;
    }

    /**
     * @param employeeTid the employeeTid to set
     */
    public void setEmployeeTid(int employeeTid) {
        this.employeeTid = employeeTid;
    }

    public static LinkedHashMap<Integer, PaySlip> getPayslipByEmployee(PayrollPeriod pp, Employee eep) throws Exception {
  System.out.println("payslipinformation x.3");
        LinkedHashMap<Integer, PaySlip> paySlipList = new LinkedHashMap<Integer, PaySlip>();
//        Query query = dbms.getDBInstance().query();
//        query.constrain(PaySlip.class);
//
//        if (eep == null) {
//            query.descend("payrollPeriodTid").constrain(pp.getTid());
//        } else {
//            Constraint c1 = query.descend("employeeTid").constrain(eep.getTid());
//            query.descend("payrollPeriodTid").constrain(pp.getTid()).and(c1);
//        }
//
//        List<PaySlip> result = query.execute();
//        System.out.println("Payslip count: " + result.size() + " payrollperiod id: " + pp.getTid());
//        if (result != null && !result.isEmpty()) {
//               System.out.println("payslipinformation x.3.1");
//            for (PaySlip ps : result) {
//                System.out.println("payslipinformation x.3.1.1 "+ ps.getTid() + " " + ps.getEmployeeTid());
//                ps.setPayslipDetails(new ArrayList<PaySlipDetail>());
//                ps.setPayrollPeriod(pp);
//                paySlipList.put(ps.getEmployeeTid(), ps);
//            }
//        }
//        System.out.println("payslipinformation x.3.2");
//        retreivePayslipDetail(paySlipList,pp.getTid());

        return paySlipList;
    }

    //TODO: please check it is using payrollperiodtid as a key
    // in which it should use payslip id.
    public static LinkedHashMap<Integer, PaySlip> getPayslipByPaySlip(PayrollPeriod pp, Employee eep) throws Exception {

        LinkedHashMap<Integer, PaySlip> paySlipList = new LinkedHashMap<Integer, PaySlip>();
//        Query query = dbms.getDBInstance().query();
//        query.constrain(PaySlip.class);
//        if (eep == null) {
//            query.descend("payrollPeriodTid").constrain(pp.getTid());
//        } else {
//            Constraint c1 = query.descend("employeeTid").constrain(eep.getTid());
//            query.descend("payrollPeriodTid").constrain(pp.getTid()).and(c1);
//        }
//
//        List<PaySlip> result = query.execute();
//        if (result != null && !result.isEmpty()) {
//            for (PaySlip ps : result) {
//                paySlipList.put(ps.getPayrollPeriodTid(), ps);
//            }
//        }
//        retreivePayslipDetail(paySlipList,pp.getTid());

        return paySlipList;
    }

    public static void retreivePayslipDetail(LinkedHashMap<Integer, PaySlip> paySlipList,int pp) throws Exception {
          //======================payslipdetails
//        System.out.println("payslipinformation x.3.2.1 payrollperiod id: " + pp);
//          Query queryd = dbms.getDBInstance().query();
//          queryd.constrain(PaySlipDetail.class);
//          queryd.descend("payrollPeriodTid").constrain(pp);
//          List<PaySlipDetail> resultd = queryd.execute();
//
//            System.out.println("payslipinformation x.3.2.1 resultd count: " + resultd.size());
//          for(PaySlipDetail psd : resultd){
//              System.out.println("psd id: " + psd.getEmployeeTid());
//              PaySlip ps = paySlipList.get(psd.getEmployeeTid());
//              if(ps == null){
//                   System.out.println("ps is null");
//              }else{
//                 ps.getPayslipDetails().add(psd);
//              }
//          }
 
    }

    public static PaySlip getPaySlipByTid(int key) throws Exception {
        PaySlip ps = null;
//        Query query = dbms.getDBInstance().query();
//        query.constrain(PaySlip.class);
//        query.descend("tid").constrain(key);
//
//        ObjectSet result = query.execute();
//        if (result.hasNext()) {
//            ps = (PaySlip) result.next();
//        }
        return ps;
    }
}
