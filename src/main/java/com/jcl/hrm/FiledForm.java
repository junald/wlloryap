/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.hrm;

import com.jcl.payroll.enumtypes.FiledFormType;
import java.util.Date;

/**
 *
 * @author junald
 */
public class FiledForm {

    private Date dateFiled;
    private FiledFormType formType;
    private Employee employee;
    private boolean withPay;
    private int numberOfDays;
    private Date fromDate;
    private Date toDate;
    private String description;
    private boolean approved;
    private Date dateApproved;
    private Employee approvedBy;
    private String notes;
}
