/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

import com.jcl.payroll.data.WithHoldingTax;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kentimport com.jcl.payroll.data.Philhealth;
import java.util.ArrayList;
import java.util.Li
 */
public class WithHoldingTaxProvider {

    private static List<WithHoldingTax> withHoldingTaxList = null;
    
    public static WithHoldingTax getWithHoldingTaxContribution(Double salary){
        
        if(withHoldingTaxList == null){
            init();
        }
        
        WithHoldingTax wht = null;
        
//        for(WithHoldingTax whte: withHoldingTaxList){
//            if(salary >= whte.getRange1() && salary <= whte.getRange2()){
//                wht = whte;
//                break;
//            }
//        }
        
        return wht;    
    }
    
    public static void init(){
        withHoldingTaxList = new ArrayList<WithHoldingTax>();
//        withHoldingTaxList.add(new WithHoldingTax(0,4999.99,4000,100,50,50));
        
        
    }
            
            
    public static void main(String[] args){
            System.out.println("withholdingtax contribution.");
            WithHoldingTaxProvider wht =new WithHoldingTaxProvider();
            wht.init();
            
            WithHoldingTax whte = wht.getWithHoldingTaxContribution(4000d);
         
//            System.out.println(whte.getEr());
            
    }
    
}
