/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.customizetable;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author junald
 */
public class NumberTableCellRenderer extends DefaultTableCellRenderer {


    NumberFormat nf;

    public NumberTableCellRenderer(String pattern){
        super();
        setHorizontalAlignment( SwingConstants.RIGHT );
          nf = new DecimalFormat(pattern);
    }

    public NumberTableCellRenderer(){
        super();
        setHorizontalAlignment( SwingConstants.RIGHT );
        nf = new DecimalFormat("0.00");
    }
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                JLabel l = new JLabel(nf.format(value));
//                l.setOpaque(true);
//                l.setHorizontalAlignment(JLabel.RIGHT);
//                return l;
//
//
//            }
//
            @Override
            public void setValue(Object value) {
                
                value = (value == null) ? "" : nf.format(value);
                super.setValue(value);
            }
}
