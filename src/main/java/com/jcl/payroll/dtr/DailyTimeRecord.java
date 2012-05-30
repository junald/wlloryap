/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.dtr;

import com.jcl.hrm.Employee;
import com.jcl.hrm.WorkShift;
import com.jcl.utilities.MyDateFormatter;
import com.jcl.utilities.TransactionException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junald
 */
public class DailyTimeRecord {

    private Long id;
    private Employee employee;
    private String dtrType;//DTRType. Present, Leave, Absence, Overtime, Undertime , Deliveries
    private Date date;
    // all source on this field are manually entered in the UI
    // for absence this fields are empty;
    private Date timeIn1;
    private Date timeOut1;
    private Date timeIn2;
    private Date timeOut2;
    // during the DTR process, dtr is process and set working hours/minutes to workHours
    // base on the WorkShift data.
    // the system will process and compute lateHours, underTimeHours automatically base on
    // employee working hours.
    // if timein and timeout, is not on his/her working shift hours, overtime form is check if found
    // overtimeHours is set to total timein and timeout of the DTR
    // if no timeIn and timeOut on working day of the employee, the system will check for
    // leave form on the date if found (type of leave: sick, vacation, overtime, other, the form will determine if
    // the leave is paid or unpaid) the leave hour is set to total working days hours. if no form is found
    // on that particular date the absenthour is set to daily working hours of the employee.
    // if Date falls on holidays or special day. the number of hours is computed also.
    private int workHours;
    private int lateHours;
    private int underTimeHours;
    private int overTimeHours;
    private int absentHours;
    private int leaveHours;
    private int holidayHours;
    private String status;
    private String notes =""; // this will contain if the DTR is special or company unique day.
    private boolean process = false; // this will be set to true of PayrollPeriod is finalized
    private boolean isDTR = true;
    private int sourceTid = -1; //trucking id if generated, -1 if not
    private boolean withPay = true;
    private String reference ="";
    private double quantity; // number of case, number of deliveries
    private double amount; // current share per case, current rate per delivery
    private int noOfEmployeeSharing;
    private double netAmount; //

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

    @Override
    public String toString() {
        return getDtrType();
    }

    public DailyTimeRecord() {
    }

    public DailyTimeRecord(Employee employee) {
        this.employee = employee;
        setDefualtTime(new Date());
    }

    
 

    /**
     * @return the dtrType
     */
    public String getDtrType() {
        return dtrType;
    }

    /**
     * @param dtrType the dtrType to set
     */
    public void setDtrType(String dtrType) {
        this.dtrType = dtrType;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the timeIn1
     */
    public Date getTimeIn1() {
        return timeIn1;
    }

    /**
     * @param timeIn1 the timeIn1 to set
     */
    public void setTimeIn1(Date timeIn1) {
        this.timeIn1 = timeIn1;
    }

    /**
     * @return the timeOut1
     */
    public Date getTimeOut1() {
        return timeOut1;
    }

    /**
     * @param timeOut1 the timeOut1 to set
     */
    public void setTimeOut1(Date timeOut1) {
        this.timeOut1 = timeOut1;
    }

    /**
     * @return the timeIn2
     */
    public Date getTimeIn2() {
        return timeIn2;
    }

    /**
     * @param timeIn2 the timeIn2 to set
     */
    public void setTimeIn2(Date timeIn2) {
        this.timeIn2 = timeIn2;
    }

    /**
     * @return the timeOut2
     */
    public Date getTimeOut2() {
        return timeOut2;
    }

    /**
     * @param timeOut2 the timeOut2 to set
     */
    public void setTimeOut2(Date timeOut2) {
        this.timeOut2 = timeOut2;
    }

    /**
     * @return the workHours
     */
    public int getWorkHours() {
        return workHours;
    }

    /**
     * @param workHours the workHours to set
     */
    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    /**
     * @return the lateHours
     */
    public int getLateHours() {
        return lateHours;
    }

    /**
     * @param lateHours the lateHours to set
     */
    public void setLateHours(int lateHours) {
        this.lateHours = lateHours;
    }

    /**
     * @return the underTimeHours
     */
    public int getUnderTimeHours() {
        return underTimeHours;
    }

    /**
     * @param underTimeHours the underTimeHours to set
     */
    public void setUnderTimeHours(int underTimeHours) {
        this.underTimeHours = underTimeHours;
    }

    /**
     * @return the overTimeHours
     */
    public int getOverTimeHours() {
        return overTimeHours;
    }

    /**
     * @param overTimeHours the overTimeHours to set
     */
    public void setOverTimeHours(int overTimeHours) {
        this.overTimeHours = overTimeHours;
    }

    /**
     * @return the absentHours
     */
    public int getAbsentHours() {
        return absentHours;
    }

    /**
     * @param absentHours the absentHours to set
     */
    public void setAbsentHours(int absentHours) {
        this.absentHours = absentHours;
    }

    /**
     * @return the leaveHours
     */
    public int getLeaveHours() {
        return leaveHours;
    }

    /**
     * @param leaveHours the leaveHours to set
     */
    public void setLeaveHours(int leaveHours) {
        this.leaveHours = leaveHours;
    }

    /**
     * @return the holidayHours
     */
    public int getHolidayHours() {
        return holidayHours;
    }

    /**
     * @param holidayHours the holidayHours to set
     */
    public void setHolidayHours(int holidayHours) {
        this.holidayHours = holidayHours;
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
     * @return the process
     */
    public boolean isProcess() {
        return process;
    }

    /**
     * @param process the process to set
     */
    public void setProcess(boolean process) {
        this.process = process;
    }

   
    /**
     * @return the sourceTid
     */
    public int getSourceTid() {
        return sourceTid;
    }

    /**
     * @param sourceTid the sourceTid to set
     */
    public void setSourceTid(int sourceTid) {
        this.sourceTid = sourceTid;
    }

    /**
     * @return the isDTR
     */
    public boolean isIsDTR() {
        return isDTR;
    }

    /**
     * @param isDTR the isDTR to set
     */
    public void setIsDTR(boolean isDTR) {
        this.isDTR = isDTR;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
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
     * @return the noOfEmployeeSharing
     */
    public int getNoOfEmployeeSharing() {
        return noOfEmployeeSharing;
    }

    /**
     * @param noOfEmployeeSharing the noOfEmployeeSharing to set
     */
    public void setNoOfEmployeeSharing(int noOfEmployeeSharing) {
        this.noOfEmployeeSharing = noOfEmployeeSharing;
    }

    /**
     * @return the netAmount
     */
    public double getNetAmount() {
        return netAmount;
    }

    /**
     * @param netAmount the netAmount to set
     */
    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public String computationString() {
        return " (" + getQuantity() + " * " + getAmount() + ")/ " + getNoOfEmployeeSharing() + "=" + getNetAmount();
    }

    /**
     * @return the withPay
     */
    public boolean isWithPay() {
        return withPay;
    }

    /**
     * @param withPay the withPay to set
     */
    public void setWithPay(boolean withPay) {
        this.withPay = withPay;
    }

    public void businessRuleDelete() throws Exception {


        if (isProcess()) {
            throw new TransactionException("Cannot delete this DTR payslip has been generated: " + getSourceTid() );
        }

        if (sourceTid != -1) {
            throw new TransactionException("Cannot delete generated DTR: " + getNotes() );
        }

    }
    
     public void setDefualtTime(Date theDate) {
        try {
            SimpleDateFormat sdf2 = MyDateFormatter.getDateTimeFormatter();

            String wdate = MyDateFormatter.getDateDataFormatter().format(theDate);

            Date t1 = sdf2.parse(wdate + " " + WorkShift.TIME_IN1);
            Date t2 = sdf2.parse(wdate + " " + WorkShift.TIME_OUT1);
            Date t3 = sdf2.parse(wdate + " " + WorkShift.TIME_IN2);
            Date t4 = sdf2.parse(wdate + " " + WorkShift.TIME_OUT2);



            setDate(theDate);
            setTimeIn1(t1);
            setTimeOut1(t2);
            setTimeIn2(t3);
            setTimeOut2(t4);

        } catch (ParseException ex) {
            Logger.getLogger(DailyTimeRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
