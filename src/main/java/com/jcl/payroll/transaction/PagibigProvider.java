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
    
    public static PagIbig getPagIbigContribution(Double salary){
        
        if(pagibigList == null){
            init();
        }
        
        PagIbig pi = null;
        
        for(PagIbig pie: pagibigList){
                   
           if(salary >= pie.getRange1() && salary <=pie.getRange2()){
                pi = pie;
                break;
            }
        }
            
     
        return pi;    
    }
    
    public static void init(){
        pagibigList = new ArrayList<PagIbig>();
        pagibigList.add(new PagIbig(0, 1500, 1500, 0.01, 0.02));
        pagibigList.add(new PagIbig(1501, 30000, 5000, 0.02, 0.02));
    }
            
            
    public static void main(String[] args){
            System.out.println("pagibig contribution.");
            PagibigProvider pi =new PagibigProvider();
            pi.init();
            
            PagIbig pie = pi.getPagIbigContribution(00d);
         
            System.out.println(pie.getEeS());
            
    }
    
    public static PagIbig getContribution(Double salary){
        PagIbig pagIbig =new PagIbig(0d, 0, salary, 500d, 500d);
        
        
        return pagIbig;
    }
    
}
