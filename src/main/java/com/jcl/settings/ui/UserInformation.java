/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProductInformation.java
 *
 * Created on Nov 3, 2010, 8:57:55 PM
 */
package com.jcl.settings.ui;


import com.jcl.customizetable.NonEditableDefaultTableModel;

import com.jcl.main.MainApp;
import com.jcl.observables.PanelMessage;
import com.jcl.dbms.dbms;
import com.jcl.model.User;
import com.jcl.verycommon.JOptionErrorMessage;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author junald
 */
public class UserInformation extends javax.swing.JPanel {

    User user;

    /** Creates new form ProductInformation */
    public UserInformation() {
        initComponents();

        initTableView();

        disableAllControls(false);
        disableSubMaterialControl(false);
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
        panelBottom = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        panelRight = new javax.swing.JPanel();
        panelMainCenter = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        panelLeft = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        panelCenter = new javax.swing.JPanel();
        panelProductInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        panelSubMaterial = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSubMaterials = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelTopLayout = new javax.swing.GroupLayout(panelTop);
        panelTop.setLayout(panelTopLayout);
        panelTopLayout.setHorizontalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
        );
        panelTopLayout.setVerticalGroup(
            panelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(panelTop, java.awt.BorderLayout.PAGE_START);

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

        add(panelBottom, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRightLayout.setVerticalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );

        add(panelRight, java.awt.BorderLayout.LINE_END);

        panelMainCenter.setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(250);

        panelLeft.setLayout(new java.awt.GridBagLayout());

        tableProducts.setAutoCreateRowSorter(true);
        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProducts);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        panelLeft.add(jScrollPane1, gridBagConstraints);

        jSplitPane1.setLeftComponent(panelLeft);

        panelCenter.setLayout(new java.awt.GridBagLayout());

        panelProductInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelProductInfo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("User name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelProductInfo.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelProductInfo.add(jLabel2, gridBagConstraints);

        jLabel8.setText("Confirm password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        panelProductInfo.add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelProductInfo.add(txtUsername, gridBagConstraints);

        txtPassword.setText("jPasswordField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelProductInfo.add(txtPassword, gridBagConstraints);

        txtConfirmPassword.setText("jPasswordField2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelProductInfo.add(txtConfirmPassword, gridBagConstraints);

        jLabel3.setText("Full name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelProductInfo.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelProductInfo.add(txtFullName, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        panelCenter.add(panelProductInfo, gridBagConstraints);

        panelSubMaterial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelSubMaterial.setLayout(new java.awt.GridBagLayout());

        tableSubMaterials.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableSubMaterials.setFillsViewportHeight(true);
        tableSubMaterials.setMaximumSize(new java.awt.Dimension(32767, 32767));
        tableSubMaterials.setMinimumSize(new java.awt.Dimension(350, 64));
        tableSubMaterials.setPreferredSize(new java.awt.Dimension(350, 64));
        tableSubMaterials.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSubMaterialsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableSubMaterials);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        panelSubMaterial.add(jScrollPane2, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel1.add(btnInsert, gridBagConstraints);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(btnRemove, gridBagConstraints);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        panelSubMaterial.add(jPanel1, gridBagConstraints);

        jPanel3.setMinimumSize(new java.awt.Dimension(109, 25));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Roles");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel3.add(jLabel10, gridBagConstraints);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(jPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelSubMaterial.add(jPanel3, gridBagConstraints);

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
        MainApp.getMessagePanelObservable().callObserver(new PanelMessage("Product Settings", "remove"));
}//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (user != null) {
            try {
                saveScreen();

                dbms.save(user);
                // TODO review the generated test code and remove the default call to fail.

                initTableView();
                JOptionPane.showMessageDialog(this, "User information save.", "User", JOptionPane.INFORMATION_MESSAGE);
             
            } catch (Exception ex) {
                 JOptionErrorMessage.showErrorMessage(this.getClass().getCanonicalName(), ex);
            }
        }
}//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

        user = new User();
        disableSubMaterialControl(true);
        initScreen();


}//GEN-LAST:event_btnNewActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnCancelActionPerformed

    private void tableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductsMouseClicked
        if (evt.getClickCount() > 1) {

            JTable jTable = (JTable) evt.getSource();
            if (jTable.getRowCount() > 0) {
                int row = jTable.getSelectedRow();
                User u = (User) jTable.getValueAt(row, 1);

                System.out.println(u);
                
                if (u != null && !u.getUsername().equals("admin")) {
//                    cp = dbms.getDBInstance().ext().getByID(p.getId());
//                    dbms.getDBInstance().activate(cp, 5);

                    user = u;
                    initScreen();
                }
            }
        }
    }//GEN-LAST:event_tableProductsMouseClicked

    private void tableSubMaterialsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSubMaterialsMouseClicked
//        if (evt.getClickCount() > 1) {
//
//            JTable jTable = (JTable) evt.getSource();
//            if (jTable.getRowCount() > 0) {
//                int row = jTable.getSelectedRow();
//               com.jcl.inventory.Material m = (com.jcl.inventory.Material) jTable.getValueAt(row, 0);
//                if (m != null) {
//                    openSubMaterialDialog(m);
//                }
//            }
//        }
    }//GEN-LAST:event_tableSubMaterialsMouseClicked

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
//        com.jcl.inventory.Material m = new Material();
     //   openSubMaterialDialog(m);
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

//        if (tableSubMaterials.getRowCount() > 0) {
//            int row = tableSubMaterials.getSelectedRow();
//            if (row > 0) {
//                com.jcl.inventory.Material m = (com.jcl.inventory.Material) tableSubMaterials.getModel().getValueAt(row, 0);
//
//                int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this sub material.", "Confirm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
//                if (result == JOptionPane.YES_OPTION) {
//                    user.getMaterials().remove(m);
//                }
//                initSubMaterials();
//            } else {
//                JOptionPane.showMessageDialog(this, "Plese select sub materials");
//            }
//
//        }
    }//GEN-LAST:event_btnRemoveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelMainCenter;
    private javax.swing.JPanel panelProductInfo;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelSubMaterial;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTable tableSubMaterials;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void initTableView() {
        try {
            NonEditableDefaultTableModel dtm = new NonEditableDefaultTableModel();
            // dtm.setColumnIdentifiers(new String[]{"Code", "Description", "UOM", "Level", "Price", "Selling Price", "Shipping", "Loading"});
            dtm.setColumnIdentifiers(new String[]{"Id", "User Name", "Name"});
//            for (User u : dbms.getDBInstance().query(User.class)) {
//                Object[] o = new Object[]{u.getTid(), u, u.getFullName()};
//                dtm.addRow(o);
//            }
            tableProducts.setModel(dtm);
        } catch (Exception ex) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private void initScreen() {
        disableAllControls(true);

        txtUsername.setText(user.getUsername());
        txtPassword.setText(user.getPassword());
        txtFullName.setText(user.getFullName());
        txtConfirmPassword.setText("");
        if(user.getId() != -1){
            txtUsername.setEditable(false);
        }else{
            txtUsername.setEditable(true);
        }

        initSubMaterials();

    }

    private void saveScreen() {

        if (user.getId() == -1) {
            user.setUsername(txtUsername.getText());
        }
        boolean isEqual = txtPassword.getText().equals(txtConfirmPassword.getText());
        if (isEqual) {
            user.setPassword(txtPassword.getText());
        }
        user.setFullName(txtFullName.getText());


    }

    private void initSubMaterials() {

//        if (user.getId() != 0) {
//            if (user.getProductLevel().equals("Main")) {
//                disableSubMaterialControl(true);
//            } else {
//                disableSubMaterialControl(false);
//            }
//        }
//        DefaultTableModel dtm = new DefaultTableModel() {
//
//            @Override
//            public boolean isCellEditable(int row, int col) {
//                return false;
//            }
//        };
//        dtm.setColumnIdentifiers(new String[]{"Code-Description", "UOM", "Quantity"});
//
//        for (Material m : user.getMaterials()) {
//            Object[] o = new Object[]{m, m.getMaterial().getUom(), m.getQuantity()};
//            dtm.addRow(o);
//        }
//
//        tableSubMaterials.setModel(dtm);

    }

//    private void openSubMaterialDialog(com.jcl.inventory.Material m) {
//
//        SubMaterial sm = new SubMaterial(null, true, m, user);
//        sm.setLocationRelativeTo(this);
//        sm.setVisible(true);
//
//        if (sm.selectedButton == SelectedButton.Save) {
//            System.out.println(sm.material.getId());
//
//            if (sm.material.getId() == 0) {
//
//                System.out.println("ms.meterial.toString() :" + sm.material.toString());
//                sm.material.setMainProduct(user);
//                user.getMaterials().add(sm.material);
//            }
//            initSubMaterials();
//        }
//
//    }

    private void disableSubMaterialControl(boolean s) {
        this.tableSubMaterials.setEnabled(s);
        this.jScrollPane2.setEnabled(s);
        this.btnInsert.setEnabled(s);
        this.btnRemove.setEnabled(s);

    }

    private void disableAllControls(boolean s) {

        for (Component c : panelProductInfo.getComponents()) {
            c.setEnabled(s);
        }

    }
}
