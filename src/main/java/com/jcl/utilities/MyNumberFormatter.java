/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.utilities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author junald
 */
public class MyNumberFormatter {

    public static String negativeFormatAmount(double v){
      NumberFormat nf = new DecimalFormat("#,##0.00;(#,##0.00)");
      return nf.format(v);
    }

    public static String formatAmount(double v) {
        NumberFormat nf = new DecimalFormat("#0.00");
        return nf.format(v);
    }
      public static String formatAmount2(double v) {
        NumberFormat nf = new DecimalFormat("#,##0.00;(#,##0.00)");
        return nf.format(v);
    }

    public static String formatQuantity(double v) {
        NumberFormat nf = new DecimalFormat("##,###,###.##");
        return nf.format(v);
    }
}
