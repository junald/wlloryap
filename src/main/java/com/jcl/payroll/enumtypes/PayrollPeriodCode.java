/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.enumtypes;

/**
 *
 * @author JLavador
 */
 //use for getting the salary of the employee
//if monthly the computation of it's payslip is base on the half of its salary (for semi monthly payslip)
//if daily the computation of its payslip is base on number of days * rate (for semi monthly payslip)
public enum PayrollPeriodCode {

    Monthly, Daily
    //  Variable, Monthly, SemiMonthly, Weekly, Daily, PerHour
}