/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hrm;


import com.jcl.security.User;
import java.util.Date;

/**
 *
 * @author junald
 */
public class RateHistory {

    private Employee employee;
    private double allowance;
    private double salary;
    private double dailyRate;
    private double hourRate;
    private double minuteRate;
    private User updatedBy;
    private Date dateModified;

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
     * @return the allowance
     */
    public double getAllowance() {
        return allowance;
    }

    /**
     * @param allowance the allowance to set
     */
    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return the dailyRate
     */
    public double getDailyRate() {
        return dailyRate;
    }

    /**
     * @param dailyRate the dailyRate to set
     */
    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    /**
     * @return the hourRate
     */
    public double getHourRate() {
        return hourRate;
    }

    /**
     * @param hourRate the hourRate to set
     */
    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    /**
     * @return the minuteRate
     */
    public double getMinuteRate() {
        return minuteRate;
    }

    /**
     * @param minuteRate the minuteRate to set
     */
    public void setMinuteRate(double minuteRate) {
        this.minuteRate = minuteRate;
    }
}
