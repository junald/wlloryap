/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.model;

//import com.db4o.ObjectSet;
//import com.db4o.query.Query;
//import com.jcl.dbms.dbms;
//import com.jcl.payroll.businessRule.IBusinessRule;
//import com.jcl.payroll.businessRule.BusinessRuleFactory;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author junald
 */
@Entity
public class PaySlipDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(optional = true)    
    private PaySlip paySlip;
    
    @Column(length = 15)
    private String paySlipDetailType; // WorkedHours, VL, SL, Overtime, Undertime, Holiday, Absent, OthersDtr, Adjustment,IncomeTax,
                                      // PagIbig,PhilHealth,SSS, Others, Loans, CashAdvanced
                                      //from dtr: WorkedHours, VL, SL, Overtime, Undertime, Holiday, Absent, OthersDtr 
    @Column(length = 150)
    private String description;
    @Column
    private Boolean isTaxable = false;
    @Column
    private Boolean isDeduction = false;
  
    @Column
    private Integer rowNumber;
    @Column
    private String modifiedBy;
    @Column
    private String preparedBy;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column(length = 15)
    private String otherDescription;
    @Column
    private Double quantity;  //time  to decimal
    @Column
    private Double amount;   //rate
    @Column
    private Double total;
    @Column
    private boolean isGenerated = true;
    @Column
    private boolean isProcess = false;
    @Column
    private Double employeeContribution;
    

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
     * @return the otherDescription
     */
    public String getOtherDescription() {
        return otherDescription;
    }

    /**
     * @param otherDescription the otherDescription to set
     */
    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
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
     * @return the quantity
     */
    public Double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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

    /**
     * @return the employeeContribution
     */
    public Double getEmployeeContribution() {
        return employeeContribution;
    }

    /**
     * @param employeeContribution the employeeContribution to set
     */
    public void setEmployeeContribution(Double employeeContribution) {
        this.employeeContribution = employeeContribution;
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

    public String toString(){
        return this.paySlipDetailType;
    }
  
}
