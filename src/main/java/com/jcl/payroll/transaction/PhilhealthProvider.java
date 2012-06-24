/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

import com.jcl.payroll.data.Philhealth;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kentimport com.jcl.payroll.data.Philhealth;
import java.util.ArrayList;
import java.util.Li
 */
public class PhilhealthProvider {

    private static List<Philhealth> philHealthList = null;
    
    public static Philhealth getPhilhealthContribution(Double salary){
        
        if(philHealthList == null){
            init();
        }
        
        Philhealth ph = null;
        
        for(Philhealth phe: philHealthList){
            if(salary >= phe.getRange1() && salary <=phe.getRange2()){
                ph = phe;
                break;
            }
        }
        
        return ph;    
    }
    
    public static void init(){
        philHealthList = new ArrayList<Philhealth>();
        philHealthList.add(new Philhealth(0,4999.99,4000,100,50,50));
        philHealthList.add(new Philhealth(5000,5999.99,5000,125,62.5,62.5));
        philHealthList.add(new Philhealth(6000,6999.99,6000,150,75,75));
        philHealthList.add(new Philhealth(7000,7999.99,7000,175,87.5,87.5));
        philHealthList.add(new Philhealth(8000,8999.99,8000,200,100,100));
        philHealthList.add(new Philhealth(9000,9999.99,9000,225,112.5,112.5));
        philHealthList.add(new Philhealth(10000,1999.99,10000,250,125,125));
        philHealthList.add(new Philhealth(11000,11999.99,11000,275,137.5,137.5));
        philHealthList.add(new Philhealth(12000,12999.99,12000,300,150,150));
        philHealthList.add(new Philhealth(13000,13999.99,13000,325,162.5,162.5));
        philHealthList.add(new Philhealth(14000,14999.99,14000,350,175,175));
        philHealthList.add(new Philhealth(15000,15999.99,15000,375,187.5,187.5));
        philHealthList.add(new Philhealth(16000,16999.99,16000,400,200,200));
        philHealthList.add(new Philhealth(17000,17999.99,17000,425,212.5,212.5));
        philHealthList.add(new Philhealth(18000,18999.99,18000,450,225,225));
        philHealthList.add(new Philhealth(19000,19999.99,19000,475,237.5,237.5));
        philHealthList.add(new Philhealth(20000,20999.99,20000,500,250,250));
        philHealthList.add(new Philhealth(21000,21999.99,21000,525,262.5,262.5));
        philHealthList.add(new Philhealth(22000,22999.99,22000,550,275,275));
        philHealthList.add(new Philhealth(23000,23999.99,23000,575,287.5,287.5));
        philHealthList.add(new Philhealth(24000,24999.99,24000,600,300,300));
        philHealthList.add(new Philhealth(25000,25999.99,25000,625,312.5,312.5));
        philHealthList.add(new Philhealth(26000,26999.99,26000,650,325,325));
        philHealthList.add(new Philhealth(27000,27999.99,27000,675,337.5,337.5));
        philHealthList.add(new Philhealth(28000,28999.99,28000,700,350,350));
        philHealthList.add(new Philhealth(29000,29999.99,29000,725,362.5,362.5));
        philHealthList.add(new Philhealth(30000,30000,30000,750,375,375));
    }
            
            
    public static void main(String[] args){
            System.out.println("philhealth contribution.");
       
            Philhealth phe = PhilhealthProvider.getPhilhealthContribution(4000d);
         
            System.out.println(phe.getEr());
            
    }
    
}
