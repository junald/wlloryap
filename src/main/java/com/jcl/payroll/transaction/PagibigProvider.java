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
    
    private static PagIbig getPagIbigContribution(Double salary){
        
        if(pagibigList == null){
            init();
        }
        
        PagIbig pi = null;
        
        for(PagIbig pie: pagibigList){
                   
           if(salary >= pie.getRange1() && salary <= pie.getRange2()){
                pi = pie;
                break;
            }
        }
            
        return pi;    
    }
    
    private static void init(){
        pagibigList = new ArrayList<PagIbig>();
        pagibigList.add(new PagIbig(0, 1500, 1500, 0.01, 0.02));
        pagibigList.add(new PagIbig(1501, 4999, 5000, 0.02, 0.02));
        
    }
             
    
    public static Double pagIbigContribution(Double salary){
        PagIbig pagIbig = getPagIbigContribution(salary);
                
        //continue here
        //compute the exact pagibig contributin not what in the init()
        double ers = 0.0d;// compute employee contribution
        double ees = 0.0d;//compute  employer contribution
        Double pagIbigContribution = 0.0d;
        
        
        double pagibigErShare;
        double pagibigEeShare;
        
        if (salary < 5000) {
        
        ers =  pagIbig.getErS();
        ees =  pagIbig.getEeS();
        pagibigErShare = ers * salary;
        pagibigEeShare = ees * salary;
        pagIbigContribution = pagibigErShare + pagibigEeShare;
        }
        else
        {
        pagIbigContribution = 200d;    
        }
        
        return pagIbigContribution;
    }
    
      public static void main(String[] args){
            System.out.println("pagibig contribution.");
            PagibigProvider pi = new PagibigProvider();
            pi.init();
            Double pagibigValue = PagibigProvider.pagIbigContribution(6999d);
            System.out.println(pagibigValue);
            
    }
}    