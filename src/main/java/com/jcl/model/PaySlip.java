/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.model;

//import com.jcl.dbms.dbms;
import com.jcl.model.Employee;
import com.jcl.payroll.enumtypes.PayrollPeriodType;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author junald
 */
@Entity
public class PaySlip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne    
    private Employee employee;
    @ManyToOne    
    private PayrollPeriod payrollPeriod;
    @Column(length = 150)
    private String description;
    @Column(length = 150)
    private String others;
    
    @OneToMany(mappedBy="paySlip")
    private List<PaySlipDetail> payslipDetails;
    @Column(length = 15)
    private String status;   //open, close
    @Column
    private String modifiedBy;
    @Column
    private String preparedBy;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column
    private Long rowCounter;
    
     

    public PaySlip() {
    }

    public PaySlip(Employee emp, PayrollPeriod pp) {
        this.employee = emp;
        this.payrollPeriod = pp;      
        this.payslipDetails = new ArrayList<PaySlipDetail>();
    }
 
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
     * @return the rowCounter
     */
    public Long getRowCounter() {
        return rowCounter;
    }

    /**
     * @param rowCounter the rowCounter to set
     */
    public void setRowCounter(Long rowCounter) {
        this.rowCounter = rowCounter;
    }
    
    
     public List<PaySlipDetail> getCompensations() {
        List<PaySlipDetail> list = new ArrayList<PaySlipDetail>();
        for (PaySlipDetail psd : payslipDetails) {
            if (!psd.getDeduction()) {
                list.add(psd);
            }
        }
        return list;
    }

    public List<PaySlipDetail> getDeductions() {
        List<PaySlipDetail> list = new ArrayList<PaySlipDetail>();
        for (PaySlipDetail psd : payslipDetails) {
            if (psd.getDeduction()) {
                list.add(psd);
            }
        }
        return list;
    }
    
   
    public Double netTotal(){
        double totalCompensations = 0.0d;
        double totalDeductions =0.0d;
        for(PaySlipDetail psd: getCompensations() ){
            totalCompensations = totalCompensations + psd.getTotal();
        }
        for(PaySlipDetail psd: getDeductions() ){
            totalDeductions = totalDeductions + psd.getTotal();
        }
        
        return totalCompensations - totalDeductions;
    }
}
