/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.customizetable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author junald
 */
public class DateTableCellRenderer extends DefaultTableCellRenderer {


    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");


    public DateTableCellRenderer(String format){
        super();
        df = new SimpleDateFormat(format);
        setHorizontalAlignment( SwingConstants.CENTER );
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

                value = (value == null) ? "" : df.format(value);
                super.setValue(value);
            }
}
