/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

/**
 *
 * @author Kent
 */
public class TaxData {
    
    private double exemption;
    private double range1;
    private double range2;
    private double over;
    private double due;
    
    public TaxData(double exemption, double range1, double range2, double due, double over)
    {
        this.exemption = exemption;
        this.range1 = range1;
        this.range2 = range2;
        this.over = over;
        this.due = due;           
    }
    
    
    public double getExemption() {
        return exemption;
    }
    
    public void setExemption(double d) {
        exemption = d;
    }
    
    public double getRange1() {
        return range1;
    }
    
    public void setRange1(double d){
        range1 = d;
    }
    
    public double getRange2() {
        return range2;
    }
    
    public void setRange2(double d) {
        range2 = d;
    }
    
    public double getOver() {
        return over;
    }
    
    public void setOver(double d) {
        over = d;
    }
    
    public double getDue() {
        return due;
    }
    
    public void setDue(double d) {
        due = d;
    }
}
