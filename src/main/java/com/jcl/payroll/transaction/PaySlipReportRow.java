/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.payroll.transaction;

import java.util.Date;

/**
 *
 * @author jlavador
 */
public class PaySlipReportRow {

    private long employeeId; 
    private String employeeName;    
    private String employeeNumber;    
    private String paySlipDetailType;
    private String position;
    private int row;
    private String description;    
    private Date date;
    private String reference;
    private double quantity;
    private double amount;
    private int noOfEmployeeSharing;
    private double netAmount;

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return the employeeNumber
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * @param employeeNumber the employeeNumber to set
     */
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
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
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
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
     * @return the employeeId
     */
    public long getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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
                             //helper/loader = (quantity * amount) / noOfEmployeeSharing

    

}
