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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the first8Hrs
     */
    public Double getFirst8Hrs() {
        return first8Hrs;
    }

    /**
     * @param first8Hrs the first8Hrs to set
     */
    public void setFirst8Hrs(Double first8Hrs) {
        this.first8Hrs = first8Hrs;
    }

    /**
     * @return the before10Pm
     */
    public Double getBefore10Pm() {
        return before10Pm;
    }

    /**
     * @param before10Pm the before10Pm to set
     */
    public void setBefore10Pm(Double before10Pm) {
        this.before10Pm = before10Pm;
    }

    /**
     * @return the from10pmTo6am
     */
    public Double getFrom10pmTo6am() {
        return from10pmTo6am;
    }

    /**
     * @param from10pmTo6am the from10pmTo6am to set
     */
    public void setFrom10pmTo6am(Double from10pmTo6am) {
        this.from10pmTo6am = from10pmTo6am;
    }
}
