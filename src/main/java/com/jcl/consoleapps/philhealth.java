/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.consoleapps;

import com.jcl.payroll.data.Philhealth;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kent
 */
public class philhealth {

    public List<Philhealth> philHealthList = new ArrayList<Philhealth>();
    
    public Philhealth getPhilhealthContibution(Double salary){
        
        Philhealth ph = null;
        
        for(Philhealth phe: philHealthList){
            if(salary >= phe.getRange1() && salary <=phe.getRange2()){
                ph = phe;
                break;
            }
        }
    
        return ph;    
    }
    
    public void init(){
        philHealthList.add(new Philhealth(0,4999.99,4000,100,50,50));
        philHealthList.add(new Philhealth(5000,5999.99,5000,125,62.5,62.5));
        philHealthList.add(new Philhealth());
    }
            
            
    public static void main(String[] args){
            System.out.println("philhealth contibution.");
            philhealth ph =new philhealth();
            ph.init();
            
            Philhealth phe = ph.getPhilhealthContibution(5001d);
            System.out.println(phe.getEr());
            
    }
    
}
