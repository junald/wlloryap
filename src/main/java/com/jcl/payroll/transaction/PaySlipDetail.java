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
import com.jcl.dbms.dbms;
import com.jcl.payroll.enumtypes.PayslipDetailType;
import java.util.Date;

/**
 *
 * @author junald
 */
public class PaySlipDetail {

    private Long id;
    private PaySlip paySlip;    
    private String paySlipDetailType; //// Absent, Adjustment,Holiday,IncomeTax,Lates,Leave,OverTime,PagIbig,PhilHealth,SSS,UnderTime,WorkedHours,Others
    private String description;
    private boolean isTaxable = false;
    private boolean isDeduction = false;
    private double total;
    private int rowNumber;
    private String modifiedBy;
    private String preparedBy;
    private Date modifiedDate;    
    private double amount;    
    private boolean isGenerated = true;
    private boolean isProcess = false;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
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
  

    public PaySlipDetail() {
    }

    public PaySlipDetail(PaySlip paySlip, String psdt) {
        this.paySlip = paySlip;
        this.paySlipDetailType = psdt;
    //    this.businessRule = BusinessRuleFactory.getBusinessRuleType(this.paySlipDetailType, this.paySlip.getEmployee());
        this.description = this.paySlipDetailType.toString();        
    }

    public PaySlipDetail(PaySlip paySlip, String psdt, boolean isGen) {
        this.paySlip = paySlip;
        this.paySlipDetailType = psdt;
     //   this.businessRule = BusinessRuleFactory.getBusinessRuleType(this.paySlipDetailType, this.paySlip.getEmployee());
        this.description = this.paySlipDetailType.toString();       
        this.isGenerated = isGen;

    }
    
      public static PaySlipDetail getPaySlipDetailByTid(Long key) throws Exception {
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

    
}
