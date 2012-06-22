/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.data;

/**
 *
 * @author junald
 */
public class PagIbig {

    private int pagibigKey;
    private double contribution;
    private double range1;
    private double range2;
    private double ers;
    private double ees;

     public PagIbig(double range1,double range2, double ees, double ers){
            this.range1 = range1;
            this.range2 = range2;
            this.ers = ers;
            this.ees = ees;
        }
    /**
     * @return the pagibigKey
     */
    public int getPagibigKey() {
        return pagibigKey;
    }

    /**
     * @param pagibigKey the pagibigKey to set
     */
    public void setPagibigKey(int pagibigKey) {
        this.pagibigKey = pagibigKey;
    }

    /**
     * @return the contribution
     */
    public double getContribution() {
        return contribution;
    }

    /**
     * @param contribution the contribution to set
     */
    public void setContribution(double contribution) {
        this.contribution = contribution;
    }
    
    public double getEeS() {
        return ees;
    }
    public double getErS() {
        return ers;
    }
    public void setEeS(double d) {
        ees = d;
    }
    public void setErS(double d) {
        ers = d;
    }
    public double getRange1() {
        return range1;
    }
    public double getRange2() {
        return range2;
    }
    public void setRange1(double d) {
        range1 = d;
    }
    public void setRange2(double d) {
        range2 = d;
    }
}
