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
import java.util.ArrayList;
import java.util.Li
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
        pagibigList.add(new PagIbig(0, 1500, 1500, 15, 30));
        pagibigList.add(new PagIbig(1501, 30000, 5000, 100, 100));
    }
             
    
    public static PagIbig getContribution(Double salary){
        PagIbig pagIbig =getPagIbigContribution(salary);
                
        //continue here
        //compute the exact pagibig contributin not what in the init()
        double ers = 0.0d;// compute employee contribution
        double ees = 0.0d;//compute  employee contribution
        
        PagIbig pagIbigContribution  = new PagIbig(pagIbig.getRange1(), pagIbig.getRange2(), salary, ers, ees);
        
        return pagIbigContribution;
    }
    
      public static void main(String[] args){
            System.out.println("pagibig contribution.");
            
            PagIbig pie = PagibigProvider.getPagIbigContribution(5000d);
            
            
         
            System.out.println(pie.getEeS());
            
    }
    
}
