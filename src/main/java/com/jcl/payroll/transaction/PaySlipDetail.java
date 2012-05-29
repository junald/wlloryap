/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

//import com.db4o.ObjectSet;
//import com.db4o.query.Query;
//import com.jcl.dbms.dbms;
//import com.jcl.payroll.businessRule.IBusinessRule;
//import com.jcl.payroll.businessRule.BusinessRuleFactory;
import com.jcl.payroll.enumtypes.PayslipDetailType;
import java.util.Date;

/**
 *
 * @author junald
 */
public class PaySlipDetail {

    private int tid = -1;
    private transient PaySlip paySlip;
    private int paySlipId;
    private int employeeTid;
    private int payrollPeriodTid;
    private String paySlipDetailType; //// Absent, Adjustment,Holiday,IncomeTax,Lates,Leave,OverTime,PagIbig,PhilHealth,SSS,UnderTime,WorkedHours,Others
    private String description;
    private boolean isTaxable = false;
    private boolean isDeduction = false;
    private double total;
    private int rowNumber;
    private String modifiedBy;
    private String preparedBy;
    private Date modifiedDate;
    private double quantity;
    private double amount;
    private int noOfLoader;
    private boolean isGenerated = true;
    private int accountingTid = -1;
    private int billingTid = -1;
    private boolean isProcess = false;
  //  private transient IBusinessRule businessRule;

    public PaySlipDetail() {
    }

    public PaySlipDetail(PaySlip paySlip, String psdt) {
        this.paySlip = paySlip;
        this.paySlipDetailType = psdt;
    //    this.businessRule = BusinessRuleFactory.getBusinessRuleType(this.paySlipDetailType, this.paySlip.getEmployee());
        this.description = this.paySlipDetailType.toString();
        this.paySlipId = paySlip.getTid();
        this.employeeTid = paySlip.getEmployeeTid();
        this.payrollPeriodTid = paySlip.getPayrollPeriodTid();

    }

    public PaySlipDetail(PaySlip paySlip, String psdt, boolean isGen) {
        this.paySlip = paySlip;
        this.paySlipDetailType = psdt;
     //   this.businessRule = BusinessRuleFactory.getBusinessRuleType(this.paySlipDetailType, this.paySlip.getEmployee());
        this.description = this.paySlipDetailType.toString();
        this.paySlipId = paySlip.getTid();
        this.employeeTid = paySlip.getEmployeeTid();
        this.payrollPeriodTid = paySlip.getPayrollPeriodTid();
        this.isGenerated = isGen;

    }

    public void ComputeAmount() {
     //   this.setTotal(this.getBusinessRule().compute());
    }

    /**
     * @return the paySlip
     */
    public PaySlip getPaySlip() {
        return paySlip;
    }

    /**
     * @param paySlip the paySlip to set
     */
    public void setPaySlip(PaySlip paySlip) {
        this.paySlip = paySlip;
    }

    /**
     * @return the mtid
     */
    public int getMtid() {
        return paySlipId;
    }

    /**
     * @param mtid the mtid to set
     */
    public void setMtid(int mtid) {
        this.paySlipId = mtid;
    }

    /**
     * Absent, Adjustment,Holiday,IncomeTax,Lates,Leave,OverTime,
     * PagIbig,PhilHealth,SSS,UnderTime,WorkedHours,Others,Regular,Deliveries,Loading
     * @return the paySlipDetailType
     */
    public String getPaySlipDetailType() {
        return paySlipDetailType;
    }

    /**
     * @param paySlipDetailType the paySlipDetailType to set
     */
    public void setPaySlipDetailType(String paySlipDetailType) {
        this.paySlipDetailType = paySlipDetailType;
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
     * @return the isTaxable
     */
    public boolean isIsTaxable() {
        return isTaxable;
    }

    /**
     * @param isTaxable the isTaxable to set
     */
    public void setIsTaxable(boolean isTaxable) {
        this.isTaxable = isTaxable;
    }

    /**
     * @return the amount
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param amount the amount to set
     */
    public void setTotal(double amount) {
        this.total = amount;
    }

    /**
     * @return the rowNumber
     */
    public int getRowNumber() {
        return rowNumber;
    }

    /**
     * @param rowNumber the rowNumber to set
     */
    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    /**
     * @return the businessRule
     */
//    public IBusinessRule getBusinessRule() {
//        return businessRule;
//    }
//
//    /**
//     * @param businessRule the businessRule to set
//     */
//    public void setBusinessRule(IBusinessRule businessRule) {
//        this.businessRule = businessRule;
//    }

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
     * @return the isDeduction
     */
    public boolean isIsDeduction() {
        return isDeduction;
    }

    /**
     * @param isDeduction the isDeduction to set
     */
    public void setIsDeduction(boolean isDeduction) {
        this.isDeduction = isDeduction;
    }

    /**
     * @return the accountingTid
     */
    public int getAccountingTid() {
        return accountingTid;
    }

    /**
     * @param accountingTid the accountingTid to set
     */
    public void setAccountingTid(int accountingTid) {
        this.accountingTid = accountingTid;
    }

    /**
     * @return the billingTid
     */
    public int getBillingTid() {
        return billingTid;
    }

    /**
     * @param billingTid the billingTid to set
     */
    public void setBillingTid(int billingTid) {
        this.billingTid = billingTid;
    }

    /**
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the noOfLoader
     */
    public int getNoOfLoader() {
        return noOfLoader;
    }

    /**
     * @param noOfLoader the noOfLoader to set
     */
    public void setNoOfLoader(int noOfLoader) {
        this.noOfLoader = noOfLoader;
    }

    public String toString2() {
        return "PaySlipDetail{" + "mtid=" + paySlipId + "description=" + description + "accountingTid=" + accountingTid + "billingTid=" + billingTid + '}';
    }

    @Override
    public String toString() {
        return paySlipDetailType;
    }

    /**
     * @return the isGenerated
     */
    public boolean isIsGenerated() {
        return isGenerated;
    }

    /**
     * @param isGenerated the isGenerated to set
     */
    public void setIsGenerated(boolean isGenerated) {
        this.isGenerated = isGenerated;
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

    public static PaySlipDetail getPaySlipDetailByTid(int key) throws Exception {
        PaySlipDetail ps = null;
//        Query query = dbms.getDBInstance().query();
//        query.constrain(PaySlipDetail.class);
//        query.descend("tid").constrain(key);
//
//        ObjectSet result = query.execute();
//        if (result.hasNext()) {
//            ps = (PaySlipDetail) result.next();
//        }
        return ps;
    }

    /**
     * @return the isProcess
     */
    public boolean isIsProcess() {
        return isProcess;
    }

    /**
     * @param isProcess the isProcess to set
     */
    public void setIsProcess(boolean isProcess) {
        this.isProcess = isProcess;
    }
}
