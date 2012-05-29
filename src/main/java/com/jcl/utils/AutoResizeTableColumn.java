/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.utils;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author junald
 */
public class AutoResizeTableColumn {
 public static void adjustColumnPreferredWidths(JTable table) {
        if (table == null || table.getColumnCount() == 0) {
            return;
        }

        // strategy - get max width for cells in column and
        // make that the preferred width
        TableColumnModel columnModel = table.getColumnModel();

        for (int col = 0; col < table.getColumnCount(); col++) {
            try {
                int maxwidth = 0;
                for (int row = 0; row < table.getRowCount(); row++) {
                    TableCellRenderer rend = table.getCellRenderer(row, col);
                    Object value = table.getValueAt(row, col);
                    Component comp = rend.getTableCellRendererComponent(table, value, false, false, row, col);
                    maxwidth = Math.max(comp.getPreferredSize().width, maxwidth);
                }

                TableColumn column = columnModel.getColumn(col);
                TableCellRenderer headerRenderer = column.getHeaderRenderer();
                if (headerRenderer == null) {
                    headerRenderer = table.getTableHeader().getDefaultRenderer();
                }
                Object headerValue = column.getHeaderValue();
                Component headerComp = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, 0, col);
                maxwidth = Math.max(maxwidth, headerComp.getPreferredSize().width);

                column.setPreferredWidth(maxwidth);

            } catch (Exception e) {
            }
        }
    }

    public static void adjustColumnPreferredWidths(JTable table, int columnIndex) {
        if (table == null || table.getColumnCount() == 0) {
            return;
        }

        // strategy - get max width for cells in column and
        // make that the preferred width
        TableColumnModel columnModel = table.getColumnModel();

        try {
            int maxwidth = 0;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer rend = table.getCellRenderer(row, columnIndex);
                Object value = table.getValueAt(row, columnIndex);
                Component comp = rend.getTableCellRendererComponent(table, value, false, false, row, columnIndex);
                maxwidth = Math.max(comp.getPreferredSize().width, maxwidth);
            }

            TableColumn column = columnModel.getColumn(columnIndex);
            TableCellRenderer headerRenderer = column.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = table.getTableHeader().getDefaultRenderer();
            }
            Object headerValue = column.getHeaderValue();
            Component headerComp = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, 0, columnIndex);
            maxwidth = Math.max(maxwidth, headerComp.getPreferredSize().width);

            column.setPreferredWidth(maxwidth);

        } catch (Exception e) { }
    }
}
