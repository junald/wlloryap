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
        rowNumbers.put("Undertime", 21);

        rowNumbers.put("Overtime", 30);
        rowNumbers.put("OT_RD", 31);
        rowNumbers.put("OT_RSD", 32);
        rowNumbers.put("OT_LHRGD", 33);
        rowNumbers.put("OT_LHRTD", 34);
        rowNumbers.put("OT_SHRGD", 35);
        rowNumbers.put("OT_SHRTD", 36);
        rowNumbers.put("OT_RM", 37);
        rowNumbers.put("OT_RSM", 38);
        rowNumbers.put("OT_LHRGM", 39);
        rowNumbers.put("OT_LHRTM", 40);
        rowNumbers.put("OT_SHRGM", 41);
        rowNumbers.put("OT_SHRTM", 42);
        
        rowNumbers.put("HL", 60);
        rowNumbers.put("HS", 61);
        
        rowNumbers.put("VL_WP", 70);
        rowNumbers.put("VL_WOP", 75);
        rowNumbers.put("SL_WP", 80);
        rowNumbers.put("SL_WOP", 80);
        
        rowNumbers.put("SSS", 200);
        rowNumbers.put("PagIbig", 210);
        rowNumbers.put("PhilHealth", 220);
        rowNumbers.put("WTax", 230);

        rowNumbers.put("Adjustment", 240);
        rowNumbers.put("Loans", 250);
        rowNumbers.put("CashAdvanced", 260);
        rowNumbers.put("PagIbigLoans", 261);
        rowNumbers.put("SSSLoans", 262);
        rowNumbers.put("Others", 270);

    }
    //WorkedHours, VL, SL, Overtime, Undertime, Holiday, Absent,
    //Adjustment,WTax,PagIbig,PhilHealth,SSS,
    //Others, Loans, CashAdvanced
}
