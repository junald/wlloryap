/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.model;


import java.util.Date;
import javax.persistence.*; 
/**
 *
 * @author junald
 */
@Entity
public class RateHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    @Column
    private Double allowance;
    
    @Column
    private Double salary;
    
    @Column
    private Double dailyRate;
    
    @Column
    private Double hourRate;
    
    @Column
    private Double minuteRate;
    
    @Column
    private String updatedBy;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

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
     * @return the allowance
     */
    public Double getAllowance() {
        return allowance;
    }

    /**
     * @param allowance the allowance to set
     */
    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    /**
     * @return the salary
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * @return the dailyRate
     */
    public Double getDailyRate() {
        return dailyRate;
    }

    /**
     * @param dailyRate the dailyRate to set
     */
    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }

    /**
     * @return the hourRate
     */
    public Double getHourRate() {
        return hourRate;
    }

    /**
     * @param hourRate the hourRate to set
     */
    public void setHourRate(Double hourRate) {
        this.hourRate = hourRate;
    }

    /**
     * @return the minuteRate
     */
    public Double getMinuteRate() {
        return minuteRate;
    }

    /**
     * @param minuteRate the minuteRate to set
     */
    public void setMinuteRate(Double minuteRate) {
        this.minuteRate = minuteRate;
    }

    /**
     * @return the updatedBy
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the dateModified
     */
    public Date getDateModified() {
        return dateModified;
    }

    /**
     * @param dateModified the dateModified to set
     */
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

  
}
