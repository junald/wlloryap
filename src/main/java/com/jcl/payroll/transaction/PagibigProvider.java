/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

import com.jcl.payroll.data.PagIbig;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kentimport com.jcl.payroll.data.Philhealth;
 */
public class PagibigProvider {

    private static List<PagIbig> pagibigList = null;

    private static PagIbig getPagIbigContribution(Double salary) {

        if (pagibigList == null) {
            init();
        }

        PagIbig pi = null;

        for (PagIbig pie : pagibigList) {

            if (salary >= pie.getRange1() && salary <= pie.getRange2()) {
                pi = pie;
                break;
            }
        }
        
        if(pi == null){
            pi = pagibigList.get(1);
        }

        return pi;
    }

    private static void init() {
        pagibigList = new ArrayList<PagIbig>();
        pagibigList.add(new PagIbig(0, 1500, 1500, 0.01, 0.02));
        pagibigList.add(new PagIbig(1501, 4999, 5000, 0.02, 0.02));       
    }

    public static PagIbig pagIbigContribution(Double salary) {
        PagIbig pagIbig = getPagIbigContribution(salary);

        double ers = 0.0d;
        double ees = 0.0d;

        double pagibigErShare;
        double pagibigEeShare;

        if (salary < 5000) {

            ers = pagIbig.getErS();
            ees = pagIbig.getEeS();
            pagibigErShare = ers * salary;
            pagibigEeShare = ees * salary;            
        } else {
            pagibigErShare = 100d;
            pagibigEeShare = 100d;
        }
        
        PagIbig pagibigContribution = new PagIbig(pagIbig.getRange1(), pagIbig.getRange2(), salary, pagibigEeShare,pagibigErShare);
        
        return pagibigContribution;
    }

    public static void main(String[] args) {
        System.out.println("pagibig contribution.");
        PagIbig pagibigValue = PagibigProvider.pagIbigContribution(1000d);
        System.out.println(pagibigValue.getEeS());
                System.out.println(pagibigValue.getErS());

    }
}
