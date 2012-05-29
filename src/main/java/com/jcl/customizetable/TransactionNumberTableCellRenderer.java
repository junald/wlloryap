/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.customizetable;

import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author junald
 */
public class TransactionNumberTableCellRenderer extends DefaultTableCellRenderer {

    int sourceObjectIndex = -1;
    NumberFormat nf = new DecimalFormat("#,##0.##;(#,##0.##)");

    public TransactionNumberTableCellRenderer(int soi) {
        super();
        setHorizontalAlignment(SwingConstants.RIGHT);
        this.sourceObjectIndex = soi;


    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(false);
        label.setHorizontalAlignment(JLabel.RIGHT);
          label.setText(nf.format(value));
        Double amount = Double.parseDouble(value.toString());
        if(amount < 0 ){
               label.setForeground(Color.red);
        }else{
               label.setForeground(Color.black);
        }


        return label;


    }

    @Override
    public void setValue(Object value) {

        value = (value == null) ? "" : nf.format(value);
        super.setValue(value);
    }
}
