/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hrm;



import java.sql.Time;

/**
 *
 * @author junald
 */
public class WorkShift {

    public static String TIME_IN1 = "8:00:00 AM";
    public static String TIME_OUT1 = "12:00:00 PM";
    public static String TIME_IN2 = "1:00:00 PM";
    public static String TIME_OUT2 = "5:00:00 PM";


    private String code;  //"001"
    private String description; //Morning Shift
    private Time timeIn1; //8:00 am
    private Time timeOut1; //12:00 am
    private Time timeIn2; //1:00 pm
    private Time timeOut2; //5:00 pm

   

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return the timeIn1
     */
    public Time getTimeIn1() {
        return timeIn1;
    }

    /**
     * @param timeIn1 the timeIn1 to set
     */
    public void setTimeIn1(Time timeIn1) {
        this.timeIn1 = timeIn1;
    }

    /**
     * @return the timeOut1
     */
    public Time getTimeOut1() {
        return timeOut1;
    }

    /**
     * @param timeOut1 the timeOut1 to set
     */
    public void setTimeOut1(Time timeOut1) {
        this.timeOut1 = timeOut1;
    }

    /**
     * @return the timeIn2
     */
    public Time getTimeIn2() {
        return timeIn2;
    }

    /**
     * @param timeIn2 the timeIn2 to set
     */
    public void setTimeIn2(Time timeIn2) {
        this.timeIn2 = timeIn2;
    }

    /**
     * @return the timeOut2
     */
    public Time getTimeOut2() {
        return timeOut2;
    }

    /**
     * @param timeOut2 the timeOut2 to set
     */
    public void setTimeOut2(Time timeOut2) {
        this.timeOut2 = timeOut2;
    }
}
