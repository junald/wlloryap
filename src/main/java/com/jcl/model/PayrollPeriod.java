/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.model;

import com.jcl.utilities.TransactionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.joda.time.DateTime;
import org.modeshape.graph.property.basic.JodaDateTime;

/**
 *
 * @author junald
 */
@Entity
public class PayrollPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String payrollPeriodCode;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @Column
    @Temporal(TemporalType.DATE)
    private Date datePrepared;
    @Column(length = 150)
    private String notes;
    @Column(length = 15)
    private String status = "Prepared"; // prepared, generated, updated, closed, cancelled
    @Column(length = 15)
    private String payrollPeriodType = "SemiMonthly"; //monthly, semi monthly, weekly, daily
    @Column
    private Boolean process = false;
    
    @Column
    private String modifiedBy;
    @Column
    private String preparedBy;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Override
    public String toString() {
        return getPayrollPeriodCode();
    }

    public PayrollPeriod(){
        this.datePrepared = new Date();       
    }
    

    /**
     * format YYYYMM-NN
     */
    public void createPayrollPeriodCode() {
        DateTime jdt = new DateTime(this.datePrepared);
        int number = 1;
        if(jdt.getDayOfMonth()<=15){
            number =1;
        }else{
            number =2;            
        }
       
        String pcode = jdt.toString("yyyyMM") + "-" + number;
        this.payrollPeriodCode = pcode;
        System.out.println("pcode: " + pcode);
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
     * @return the payrollPeriodCode
     */
    public String getPayrollPeriodCode() {
        return payrollPeriodCode;
    }

    /**
     * @param payrollPeriodCode the payrollPeriodCode to set
     */
    public void setPayrollPeriodCode(String payrollPeriodCode) {
        this.payrollPeriodCode = payrollPeriodCode;
    }

    /**
     * @return the dateFrom
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    /**
     * @param dateFrom the dateFrom to set
     */
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * @return the dateTo
     */
    public Date getDateTo() {
        return dateTo;
    }

    /**
     * @param dateTo the dateTo to set
     */
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * @return the datePrepared
     */
    public Date getDatePrepared() {
        return datePrepared;
    }

    /**
     * @param datePrepared the datePrepared to set
     */
    public void setDatePrepared(Date datePrepared) {
        this.datePrepared = datePrepared;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
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
     * @return the payrollPeriodType
     */
    public String getPayrollPeriodType() {
        return payrollPeriodType;
    }

    /**
     * @param payrollPeriodType the payrollPeriodType to set
     */
    public void setPayrollPeriodType(String payrollPeriodType) {
        this.payrollPeriodType = payrollPeriodType;
    }

    /**
     * @return the process
     */
    public Boolean getProcess() {
        return process;
    }

    /**
     * @param process the process to set
     */
    public void setProcess(Boolean process) {
        this.process = process;
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
    
      public void businessRule() throws Exception {
        if (this.dateFrom == null || this.dateTo == null) {
            throw new TransactionException("To and From date cannot be empty");
        } else if (this.dateFrom.compareTo(this.dateTo) > 0) {
            throw new TransactionException("(from) date must be less than (to)");
        }
    }
}
