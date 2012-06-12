/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.utilities;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author JLavador
 */
public class RowNumberInit {

    private static HashMap<String, Integer> rowNumbers = null;
    
   
    public static int getRowNumbers(String stype) {

        if (rowNumbers == null) {
            init();
        }

        return rowNumbers.get(stype);
    }

    private static void init() {
        rowNumbers = new LinkedHashMap<String, Integer>();

        rowNumbers.put("WorkedHours", 10);
        rowNumbers.put("Absent", 20);

        rowNumbers.put("Overtime", 30);
        rowNumbers.put("Undertime", 40);
        rowNumbers.put("Holiday",50);
        rowNumbers.put("VL", 60);
        rowNumbers.put("SL", 70);

        
        rowNumbers.put("SSS", 90);
        rowNumbers.put("PagIbig", 100);
        rowNumbers.put("PhilHealth", 110);
        rowNumbers.put("WTax", 120);

        rowNumbers.put("Adjustment", 130);
        rowNumbers.put("Loans", 140);
        rowNumbers.put("CashAdvanced", 150);
        rowNumbers.put("Others", 160);

    }
    
    //WorkedHours, VL, SL, Overtime, Undertime, Holiday, Absent,
    //Adjustment,WTax,PagIbig,PhilHealth,SSS,
    //Others, Loans, CashAdvanced
}
