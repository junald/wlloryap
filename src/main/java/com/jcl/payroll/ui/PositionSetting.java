/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProductInformation.java
 *
 * Created on Nov 3, 2010, 8:57:55 PM
 */
package com.jcl.payroll.ui;



import com.jcl.customizetable.NonEditableDefaultTableModel;
import com.jcl.dbms.dbms;
import com.jcl.hrm.Position;
import com.jcl.main.MainApp;
import com.jcl.observables.PanelMessage;
import com.jcl.verycommon.JOptionErrorMessage;
import com.jcl.verycommon.MLogger;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author junald
 */
public class PositionSetting extends javax.swing.JPanel {

    Position position;

    /** Creates new form ProductInformation */
    public PositionSetting() {
        initComponents();

        SetVisibleControlToFalse();
        initTableView();

        disableAllControls(false);


    }

    private void SetVisibleControlToFalse() {
        btnClose.setVisible(false);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelTop = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        panelMainCenter = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        panelLeft = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTrucks = new javax.swing.JTable();
        panelCenter = new javax.swing.JPanel();
        panelTruckInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        panelSubMaterial = new javax.swing.JPanel();
        panelBottom = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(panelTop, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRightLayout.setVerticalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        add(panelRight, java.awt.BorderLayout.LINE_END);

        panelMainCenter.setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(450);

        panelLeft.setLayout(new java.awt.GridBagLayout());

        tableTrucks.setAutoCreateRowSorter(true);
        tableTrucks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableTrucks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTrucksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTrucks);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        panelLeft.add(jScrollPane1, gridBagConstraints);

        jSplitPane1.setLeftComponent(panelLeft);

        panelCenter.setLayout(new java.awt.GridBagLayout());

        panelTruckInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelTruckInfo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelTruckInfo.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Position");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelTruckInfo.add(jLabel2, gridBagConstraints);

        txtCode.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelTruckInfo.add(txtCode, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelTruckInfo.add(txtDescription, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCenter.add(panelTruckInfo, gridBagConstraints);

        panelSubMaterial.setLayout(new java.awt.GridBagLayout());

        panelBottom.setLayout(new java.awt.GridBagLayout());

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelBottom.add(btnClose, gridBagConstraints);

        btnSave.setMnemonic('S');
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelBottom.add(btnSave, gridBagConstraints);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelBottom.add(jPanel5, gridBagConstraints);

        btnNew.setMnemonic('N');
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelBottom.add(btnNew, gridBagConstraints);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelBottom.add(btnCancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        panelSubMaterial.add(panelBottom, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelSubMaterial.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelCenter.add(panelSubMaterial, gridBagConstraints);

        jSplitPane1.setRightComponent(panelCenter);

        panelMainCenter.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        add(panelMainCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        MainApp.messagePanelObservable.callObserver(new PanelMessage("Truck Settings", "remove"));
}//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (position != null) {
            try {
                saveScreen();

                dbms.save(position);
                // TODO review the generated test code and remove the default call to fail.

                initTableView();
                JOptionPane.showMessageDialog(this, "Position information save.", "Position", JOptionPane.INFORMATION_MESSAGE);
            }   catch (Exception ex) {
                 JOptionErrorMessage.showErrorMessage(this.getClass().getCanonicalName(), ex);
            }
        }
}//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

        position = new Position();
        disableAllControls(true);
        initScreen();

}//GEN-LAST:event_btnNewActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnCancelActionPerformed

    private void tableTrucksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTrucksMouseClicked
        if (evt.getClickCount() > 1) {

            JTable jTable = (JTable) evt.getSource();
            if (jTable.getRowCount() > 0) {
                int row = jTable.getSelectedRow();
               Position p = (Position) jTable.getValueAt(row, 1);

                if (p != null) {
                    try {

                        position =Position.getPositionByTid(p.getId());
               //         dbms.getDBInstance().activate(position, 3);
                        initScreen();
                    } catch (Exception ex) {
                        Logger.getLogger(PositionSetting.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_tableTrucksMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelMainCenter;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelSubMaterial;
    private javax.swing.JPanel panelTop;
    private javax.swing.JPanel panelTruckInfo;
    private javax.swing.JTable tableTrucks;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables

    private void initTableView() {
        try {
            NonEditableDefaultTableModel dtm = new NonEditableDefaultTableModel();
            dtm.setColumnIdentifiers(new String[]{"Id", "Description"});
//            for (Position p : dbms.getDBInstance().query(Position.class)) {
//                Object[] o = new Object[]{p.getTid(), p};
//                dtm.addRow(o);
//            }
            tableTrucks.setModel(dtm);
        } catch (Exception ex) {
            Logger.getLogger(PositionSetting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    private void initScreen() {
        disableAllControls(true);
        txtCode.setText(position.getId()+"");
        txtDescription.setText(position.getDescription());


    }

    private void saveScreen() {


        position.setDescription(txtDescription.getText());


    }

    private void disableAllControls(boolean s) {

        for (Component c : panelTruckInfo.getComponents()) {
            c.setEnabled(s);
        }

    }
}
