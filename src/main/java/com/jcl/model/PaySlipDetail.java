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
    private Boolean taxable = false;
    @Column
    private Boolean deduction = false;
  
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
    private Boolean generated = true;
    @Column
    private Boolean process = false;
    @Column
    private Boolean dtr = false;
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
    public Boolean getTaxable() {
        return taxable;
    }

    /**
     * @param isTaxable the isTaxable to set
     */
    public void setTaxable(Boolean isTaxable) {
        this.taxable = isTaxable;
    }

    /**
     * @return the isDeduction
     */
    public Boolean getDeduction() {
        return deduction;
    }

    /**
     * @param isDeduction the isDeduction to set
     */
    public void setDeduction(Boolean isDeduction) {
        this.deduction = isDeduction;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the rowNumber
     */
    public Integer getRowNumber() {
        return rowNumber;
    }

    /**
     * @param rowNumber the rowNumber to set
     */
    public void setRowNumber(Integer rowNumber) {
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
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
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
    public Boolean getGenerated() {
        return generated;
    }

    /**
     * @param isGenerated the isGenerated to set
     */
    public void setGenerated(Boolean isGenerated) {
        this.generated = isGenerated;
    }

    /**
     * @return the isProcess
     */
    public Boolean getProcess() {
        return process;
    }

    /**
     * @param isProcess the isProcess to set
     */
    public void setProcess(Boolean isProcess) {
        this.process = isProcess;
    }

    /**
     * @return the dtr
     */
    public Boolean getDtr() {
        return dtr;
    }

    /**
     * @param dtr the dtr to set
     */
    public void setDtr(Boolean dtr) {
        this.dtr = dtr;
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
        this.modifiedDate = new Date();
    }

    public PaySlipDetail(PaySlip paySlip, String psdt, boolean isGen) {
        this.paySlip = paySlip;
        this.paySlipDetailType = psdt;
        //   this.businessRule = BusinessRuleFactory.getBusinessRuleType(this.paySlipDetailType, this.paySlip.getEmployee());
        this.description = this.paySlipDetailType.toString();
        this.generated = isGen;
        this.modifiedDate = new Date();

    }

    public String toString(){
        return this.paySlipDetailType;
    }
  
}
