/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Kentimport com.jcl.payroll.data.Philhealth;

 */
/*
public class WithHoldingTaxProvider {

  // privata static List<TaxData> taxTable = null;
   
   public static TaxData getWHT(Double salary) {
       if (taxTable == null) {
           init();
       }
       TaxData td = null;
       
       for (TaxData tde : taxTable) {
           if (salary >= tde.getRange1() && salary <= tde.getRange2()) {
               td = tde;
               break;
           }
       }
       return td;
   }
   
  
    public static HashMap<String, ArrayList<TaxData>> taxTable ;
  
   public static void init(){
       
       taxTable  = new LinkedHashMap<String, ArrayList<TaxData>>();
       
       ArrayList<TaxData>  zList = new ArrayList<TaxData>();
            zList.add(new TaxData(0, 0, 1, 0.0, 0.0));
            zList.add(new TaxData(0, 0, 416, 0.0, 0.05));
            zList.add(new TaxData(0, 417, 1249, 20.83, 0.1));
            zList.add(new TaxData(0, 1250, 2916, 104.17, 0.15));
            zList.add(new TaxData(0, 2917, 5832, 354.17, 0.2));
            zList.add(new TaxData(0, 5833, 10416, 937.5, 0.25));
            zList.add(new TaxData(0, 10417, 20832, 2083.33, 0.3));
            zList.add(new TaxData(0, 20833, 50000, 5208.33, 0.32));
       taxTable.put("Z", zList);
        
       ArrayList<TaxData> smeList = new ArrayList<TaxData>();
            smeList.add(new TaxData(50, 1, 2082, 0.0, 0.0));
            smeList.add(new TaxData(50, 2083, 2499, 0.0, 0.05));
            smeList.add(new TaxData(50, 2500, 3332, 20.83, 0.1));
            smeList.add(new TaxData(50, 3333, 4999, 104.17, 0.15));
            smeList.add(new TaxData(50, 5000, 7916, 345.17, 0.2));
            smeList.add(new TaxData(50, 7917, 12499, 937.5, 0.25));
            smeList.add(new TaxData(50, 12500, 22916, 2083.33, 0.3));
            smeList.add(new TaxData(50, 22917, 50000, 5208.33, 0.32));
       taxTable.put("S_ME", smeList);
        
        //taxTable.get("S_ME");
        
       ArrayList<TaxData> me1hf1List = new ArrayList<TaxData>();
           me1hf1List.add(new TaxData(75, 1, 3124, 0.0, 0.0));
            me1hf1List.add(new TaxData(75, 3125, 3541, 0.0, 0.05));
            me1hf1List.add(new TaxData(75, 3542, 4374, 20.83, 0.1));
            me1hf1List.add(new TaxData(75, 4375, 6041, 104.17, 0.15));
            me1hf1List.add(new TaxData(75, 6042, 8957, 354.17, 0.2));
            me1hf1List.add(new TaxData(75, 8958, 13541, 937.5, 0.25));
            me1hf1List.add(new TaxData(75, 13542, 23957, 2083.33, 0.3));
            me1hf1List.add(new TaxData(75, 23958, 50000, 5208.33, 0.32));
       taxTable.put("ME1_S1", me1hf1List);
        
       ArrayList<TaxData> me2hf2List = new ArrayList<TaxData>();
       
          me2hf2List.add(new TaxData(100, 1, 4166, 0.0, 0.0));
          me2hf2List.add(new TaxData(100, 4167, 4582, 0.0, 0.05));
          me2hf2List.add(new TaxData(100, 4583, 5416, 20.83, 0.1));
          me2hf2List.add(new TaxData(100, 5417, 7082, 104.17, 0.15));
          me2hf2List.add(new TaxData(100, 7083, 9999, 354.17, 0.2));
          me2hf2List.add(new TaxData(100, 10000, 14582, 937.5, 0.25));
          me2hf2List.add(new TaxData(100, 14583, 24999, 2083.33, 0.30));
          me2hf2List.add(new TaxData(100, 25000, 50000, 5208.33, 0.32));
       taxTable.put("ME2_S2", me2hf2List);
       
       ArrayList<TaxData> me3hf3List = new ArrayList<TaxData>();
       
          me3hf3List.add(new TaxData(125, 1, 5207, 0.0, 0.0));
          me3hf3List.add(new TaxData(125, 5208, 5624, 0.0, 0.05));
          me3hf3List.add(new TaxData(125, 5625, 6457, 20.83, 0.1));
          me3hf3List.add(new TaxData(125, 6458, 8124, 104.17, 0.15));
          me3hf3List.add(new TaxData(125, 8125, 11041, 354.17, 0.2));
          me3hf3List.add(new TaxData(125, 11042, 15624, 937.5, 0.25));
          me3hf3List.add(new TaxData(125, 15625, 26041, 2083.33, 0.3));
          me3hf3List.add(new TaxData(125, 26042, 50000, 5208.33, 0.32));
       taxTable.put("ME3_S3", me3hf3List);
       
       ArrayList<TaxData> me4hf4List = new ArrayList<TaxData>();
        
          me4hf4List.add(new TaxData(150, 1, 6249, 0.0, 0.0));
          me4hf4List.add(new TaxData(150, 6250, 6666, 0.0, 0.05));
          me4hf4List.add(new TaxData(150, 6667, 7499, 20.83, 0.1));
          me4hf4List.add(new TaxData(150, 7500, 9166, 104.17, 0.15));
          me4hf4List.add(new TaxData(150, 9167, 12082, 354.17, 0.2));
          me4hf4List.add(new TaxData(150, 12083, 16666, 937.5, 0.25));
          me4hf4List.add(new TaxData(150, 16667, 27082, 2083.33, 0.3));
          me4hf4List.add(new TaxData(150, 27083, 50000, 5208.33, 0.32));
       taxTable.put("ME4_S4", me4hf4List);
    }
   public static void main(String[] args){
            System.out.println("withholdingtax contribution.");
            WithHoldingTaxProvider td =new WithHoldingTaxProvider();
            td.init();
            
            TaxData tde = td.getWHT(4000d);
         
            System.out.println(tde.getDue());
            
    }
}

*/