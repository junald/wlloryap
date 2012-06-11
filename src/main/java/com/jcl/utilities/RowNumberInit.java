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

        rowNumbers.put("WorkedHours", 1);
        rowNumbers.put("Absent", 100);

        rowNumbers.put("Overtime", 200);
        rowNumbers.put("Undertime", 300);
        rowNumbers.put("Holiday",400);
        rowNumbers.put("VL", 500);
        rowNumbers.put("SL", 600);

        rowNumbers.put("Adjustment", 700);
        rowNumbers.put("SSS", 800);
        rowNumbers.put("PagIbig", 900);
        rowNumbers.put("PhilHealth", 1000);
        rowNumbers.put("WTax", 1100);

        rowNumbers.put("Loans", 1200);
        rowNumbers.put("CashAdvanced", 1300);
        rowNumbers.put("Others", 1400);

    }
    
    //WorkedHours, VL, SL, Overtime, Undertime, Holiday, Absent,
    //Adjustment,WTax,PagIbig,PhilHealth,SSS,
    //Others, Loans, CashAdvanced
}
