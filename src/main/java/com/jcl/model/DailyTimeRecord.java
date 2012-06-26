/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.model;

import com.jcl.model.Employee;
import com.jcl.utilities.MyDateFormatter;
import com.jcl.utilities.TransactionException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author junald
 */
@Entity
public class DailyTimeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne    
    private Employee employee;
    @Column(length = 15)
    private String dtrType;//DTRType.  WorkedHours, VL, SL, Overtime, Undertime, Holiday, Absent, Others 
    @Column
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeIn1;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOut1;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeIn2;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeOut2;
    // all source on this field are manually entered in the UI
    // for absence this fields are empty;
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
    @Column
    private Integer actualHours= 0;
    @Column
    private Integer actualMins = 0;
    
    @Column
    private Integer workHours;
    @Column
    private Integer workMins;
    @Column
    private Integer holidayHours;
    @Column
    private Integer holidayMins;
    @Column
    private Integer lateHours;
    @Column
    private Integer lateMins;
    @Column
    private Integer underTimeHours;
    @Column
    private Integer underTimeMins;
    @Column
    private Integer overTimeHours;
    @Column
    private Integer overTimeMins;
    @Column
    private Integer absentHours;
    @Column
    private Integer absentMins;
    @Column
    private Integer leaveHours;
    @Column
    private Integer leaveMins;
    
    @Column(length = 15)
    private String status ="Opened";
    @Column(length = 150)
    private String notes = ""; // this will contain if the DTR is special or company unique day.
    @Column
    private Boolean process = false; // this will be set to true of PayrollPeriod is finalized
    @Column
    private Boolean isDTR = true;
    @Column
    private Boolean withPay = true;   //if vl or sl, loop through dtr, separate payslipdetail for with pay and no pay
    @Column    
    private Boolean deduction = false;
    @Column(length = 150)
    private String reference = "";
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @Column
    private Boolean restDay = false;
    
    @Column
    private Integer section = 1; // used in computing overtime rates.
    
    public DailyTimeRecord() {
    }

    public DailyTimeRecord(Employee employee) {
        this.employee = employee;
        this.transactionDate = new Date();
        this.modifiedDate = new Date();
       //setDefualtTime(new Date());
    }

    public void businessRuleDelete() throws Exception {
//        if (isProcess()) {
//            throw new TransactionException("Cannot delete this DTR payslip has been generated: "  );
//        }
//
//        if (sourceTid != -1) {
//            throw new TransactionException("Cannot delete generated DTR: " );
//        }
    }

    public void setDefualtTime(Date theDate) {
//        try {
//            SimpleDateFormat sdf2 = MyDateFormatter.getDateTimeFormatter();
//
//            String wdate = MyDateFormatter.getDateDataFormatter().format(theDate);
//
//            Date t1 = sdf2.parse(wdate + " " + WorkShift.TIME_IN1);
//            Date t2 = sdf2.parse(wdate + " " + WorkShift.TIME_OUT1);
//            Date t3 = sdf2.parse(wdate + " " + WorkShift.TIME_IN2);
//            Date t4 = sdf2.parse(wdate + " " + WorkShift.TIME_OUT2);
//
//
//
//            setDate(theDate);
//            setTimeIn1(t1);
//            setTimeOut1(t2);
//            setTimeIn2(t3);
//            setTimeOut2(t4);
//
//        } catch (ParseException ex) {
//            Logger.getLogger(DailyTimeRecord.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
     * @return the transactionDate
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
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
     * @return the actualHours
     */
    public Integer getActualHours() {
        return actualHours;
    }

    /**
     * @param actualHours the actualHours to set
     */
    public void setActualHours(Integer actualHours) {
        this.actualHours = actualHours;
    }

    /**
     * @return the actualMins
     */
    public Integer getActualMins() {
        return actualMins;
    }

    /**
     * @param actualMins the actualMins to set
     */
    public void setActualMins(Integer actualMins) {
        this.actualMins = actualMins;
    }

    /**
     * @return the workHours
     */
    public Integer getWorkHours() {
        return workHours;
    }

    /**
     * @param workHours the workHours to set
     */
    public void setWorkHours(Integer workHours) {
        this.workHours = workHours;
    }

    /**
     * @return the workMins
     */
    public Integer getWorkMins() {
        return workMins;
    }

    /**
     * @param workMins the workMins to set
     */
    public void setWorkMins(Integer workMins) {
        this.workMins = workMins;
    }

    /**
     * @return the holidayHours
     */
    public Integer getHolidayHours() {
        return holidayHours;
    }

    /**
     * @param holidayHours the holidayHours to set
     */
    public void setHolidayHours(Integer holidayHours) {
        this.holidayHours = holidayHours;
    }

    /**
     * @return the holidayMins
     */
    public Integer getHolidayMins() {
        return holidayMins;
    }

    /**
     * @param holidayMins the holidayMins to set
     */
    public void setHolidayMins(Integer holidayMins) {
        this.holidayMins = holidayMins;
    }

    /**
     * @return the lateHours
     */
    public Integer getLateHours() {
        return lateHours;
    }

    /**
     * @param lateHours the lateHours to set
     */
    public void setLateHours(Integer lateHours) {
        this.lateHours = lateHours;
    }

    /**
     * @return the lateMins
     */
    public Integer getLateMins() {
        return lateMins;
    }

    /**
     * @param lateMins the lateMins to set
     */
    public void setLateMins(Integer lateMins) {
        this.lateMins = lateMins;
    }

    /**
     * @return the underTimeHours
     */
    public Integer getUnderTimeHours() {
        return underTimeHours;
    }

    /**
     * @param underTimeHours the underTimeHours to set
     */
    public void setUnderTimeHours(Integer underTimeHours) {
        this.underTimeHours = underTimeHours;
    }

    /**
     * @return the underTimeMins
     */
    public Integer getUnderTimeMins() {
        return underTimeMins;
    }

    /**
     * @param underTimeMins the underTimeMins to set
     */
    public void setUnderTimeMins(Integer underTimeMins) {
        this.underTimeMins = underTimeMins;
    }

    /**
     * @return the overTimeHours
     */
    public Integer getOverTimeHours() {
        return overTimeHours;
    }

    /**
     * @param overTimeHours the overTimeHours to set
     */
    public void setOverTimeHours(Integer overTimeHours) {
        this.overTimeHours = overTimeHours;
    }

    /**
     * @return the overTimeMins
     */
    public Integer getOverTimeMins() {
        return overTimeMins;
    }

    /**
     * @param overTimeMins the overTimeMins to set
     */
    public void setOverTimeMins(Integer overTimeMins) {
        this.overTimeMins = overTimeMins;
    }

    /**
     * @return the absentHours
     */
    public Integer getAbsentHours() {
        return absentHours;
    }

    /**
     * @param absentHours the absentHours to set
     */
    public void setAbsentHours(Integer absentHours) {
        this.absentHours = absentHours;
    }

    /**
     * @return the absentMins
     */
    public Integer getAbsentMins() {
        return absentMins;
    }

    /**
     * @param absentMins the absentMins to set
     */
    public void setAbsentMins(Integer absentMins) {
        this.absentMins = absentMins;
    }

    /**
     * @return the leaveHours
     */
    public Integer getLeaveHours() {
        return leaveHours;
    }

    /**
     * @param leaveHours the leaveHours to set
     */
    public void setLeaveHours(Integer leaveHours) {
        this.leaveHours = leaveHours;
    }

    /**
     * @return the leaveMins
     */
    public Integer getLeaveMins() {
        return leaveMins;
    }

    /**
     * @param leaveMins the leaveMins to set
     */
    public void setLeaveMins(Integer leaveMins) {
        this.leaveMins = leaveMins;
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
     * @return the isDTR
     */
    public Boolean getIsDTR() {
        return isDTR;
    }

    /**
     * @param isDTR the isDTR to set
     */
    public void setIsDTR(Boolean isDTR) {
        this.isDTR = isDTR;
    }

    /**
     * @return the withPay
     */
    public Boolean getWithPay() {
        return withPay;
    }

    /**
     * @param withPay the withPay to set
     */
    public void setWithPay(Boolean withPay) {
        this.withPay = withPay;
    }

    /**
     * @return the deduction
     */
    public Boolean getDeduction() {
        return deduction;
    }

    /**
     * @param deduction the deduction to set
     */
    public void setDeduction(Boolean deduction) {
        this.deduction = deduction;
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
     * @return the restDay
     */
    public Boolean getRestDay() {
        return restDay;
    }

    /**
     * @param restDay the restDay to set
     */
    public void setRestDay(Boolean restDay) {
        this.restDay = restDay;
    }

    /**
     * @return the section
     */
    public Integer getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(Integer section) {
        this.section = section;
    }
    
    public String toString(){
        return dtrType;
    }
}
