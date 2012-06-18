/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

/**
 *
 * @author junald
 */
public class OvertimeRate {
    private String name;
    private Double first8Hrs;
    private Double before10Pm;
    private Double from10pmTo6am;
    
    public OvertimeRate(String name, Double f8, Double b10, Double f10){
        this.name = name;
        this.first8Hrs = f8;
        this.before10Pm = b10;
        this.from10pmTo6am = f10;
    }
}
