/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

 
//import com.jcl.dbms.dbms;
import com.jcl.utilities.TransactionException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author junald
 */
public class PayrollPeriod {

    private int tid = -1;
    private String payrollPeriodCode;
    private Date dateFrom;
    private Date dateTo;
    private Date datePrepared;
    private String notes;
    private String status = "Prepared"; // prepared, generated, updated, closed, cancelled
    private List<Integer> truckingTids;
    private String payrollPeriodType = "Variable"; //monthly, semi monthly, weekly, daily

    private String modifiedBy;
    private String preparedBy;
    private Date modifiedDate;

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
     * @return the truckingTids
     */
    public List<Integer> getTruckingTids() {
        return truckingTids;
    }

    /**
     * @param truckingTids the truckingTids to set
     */
    public void setTruckingTids(List<Integer> truckingTids) {
        this.truckingTids = truckingTids;
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

    @Override
    public String toString() {
        return   payrollPeriodCode ;
    }

     public void businessRule() throws Exception {
        if (this.dateFrom == null || this.dateTo == null) {
            throw new TransactionException("To and From date cannot be empty");
        } else if (this.dateFrom.compareTo(this.dateTo) > 0) {
            throw new TransactionException("(from) date must be less than (to)");
        }
    }


     public static PayrollPeriod getPayrollPeriodByTid(int id) throws Exception {
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

     public static List<PayrollPeriod> getAllPayrollPeriod(boolean includeOthers) throws Exception{
         List<PayrollPeriod> list = new ArrayList<PayrollPeriod>();
//         Query query = dbms.getDBInstance().query();
//        query.constrain(PayrollPeriod.class);
//        if(!includeOthers){
//               query.descend("status").constrain("Opened");
//        }
//
//        list = query.execute();

         return  list;
         
     }

     /**
      * format
      * N-DDMMYY
      */
     public void createPayrollPeriodCode(){

     }

}
