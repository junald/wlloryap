/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

import java.util.ArrayList;

/**
 *
 * @author junald
 */
public class PaySlipReportObject {

    private int employeeTid;
    private ArrayList<PaySlipReportRow> list;
    private double netTotal;

    public PaySlipReportObject() {
        list = new ArrayList<PaySlipReportRow>();
    }

    /**
     * @return the list
     */
    public ArrayList<PaySlipReportRow> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<PaySlipReportRow> list) {
        this.list = list;
    }

    /**
     * @return the employeeTid
     */
    public int getEmployeeTid() {
        return employeeTid;
    }

    /**
     * @param employeeTid the employeeTid to set
     */
    public void setEmployeeTid(int employeeTid) {
        this.employeeTid = employeeTid;
    }

    /**
     * @return the netTotal
     */
    public double getNetTotal() {
        return netTotal;
    }

    /**
     * @param netTotal the netTotal to set
     */
    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }
}
