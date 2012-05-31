/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 *
 * @author junald
 */
@Entity
public class PayrollPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
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
    private String payrollPeriodType = "SemiMonthly"; //monthly, semi monthly, weekly, daily
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

    public static PayrollPeriod getPayrollPeriodByTid(Long id) throws Exception {
        PayrollPeriod emp = null;
//        Query query = dbms.getDBInstance().query();
//        query.constrain(PayrollPeriod.class);
//        query.descend("tid").constrain(id);
//
//        ObjectSet result = query.execute();
//        if (result.hasNext()) {
//            emp = (PayrollPeriod) result.next();
//        }
        return emp;
    }

    public static List<PayrollPeriod> getAllPayrollPeriod(boolean includeOthers) throws Exception {
        List<PayrollPeriod> list = new ArrayList<PayrollPeriod>();
//         Query query = dbms.getDBInstance().query();
//        query.constrain(PayrollPeriod.class);
//        if(!includeOthers){
//               query.descend("status").constrain("Opened");
//        }
//
//        list = query.execute();

        return list;

    }

    /**
     * format N-DDMMYY
     */
    public void createPayrollPeriodCode() {
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
}
