/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.customizetable;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author junald
 */
public class NonEditableDefaultTableModel extends DefaultTableModel {

//            @Override
//            public Class getColumnClass(int c) {
//                Object o = getValueAt(0, c);
//
//                if (o == null) {
//                    return String.class;
//                } else if (c > 4) {
//                    return Double.class;
//                } else {
//                    return getValueAt(0, c).getClass();
//                }
//            }
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
