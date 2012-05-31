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
import com.jcl.model.Position;
import com.jcl.main.MainApp;
import com.jcl.observables.PanelMessage;
import com.jcl.payroll.enumtypes.PayrollPeriodStatus;
import com.jcl.payroll.enumtypes.PayrollPeriodType;
import com.jcl.payroll.transaction.PaySlipProcess;
import com.jcl.payroll.transaction.PaySlipStatus;
import com.jcl.model.PayrollPeriod;
import com.jcl.utilities.MyDateFormatter;
import com.jcl.utilities.TransactionException;
import com.jcl.verycommon.JOptionErrorMessage;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author junald
 */
public class PayrollPeriodInformation extends javax.swing.JPanel {

    PayrollPeriod pp;
    SimpleDateFormat sdf;

    /** Creates new form ProductInformation */
    public PayrollPeriodInformation() {
        initComponents();
        sdf = MyDateFormatter.getSimpleDateTimeFormatter2();

        initTableView();
        initComboBox();

        disableAllControls(false);


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
        tablePayrollPeriod = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnPreparePayslip = new javax.swing.JButton();
        panelCenter = new javax.swing.JPanel();
        panelPayrollPeriod = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTid = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDateTo = new org.jdesktop.swingx.JXDatePicker();
        txtDateFrom = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox();
        comboType = new javax.swing.JComboBox();
        txtNotes = new javax.swing.JTextField();
        txtDatePrepared = new javax.swing.JTextField();
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

        tablePayrollPeriod.setAutoCreateRowSorter(true);
        tablePayrollPeriod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablePayrollPeriod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePayrollPeriodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePayrollPeriod);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        panelLeft.add(jScrollPane1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnPreparePayslip.setText("Prepare Payslip For This PayrollPeriod");
        btnPreparePayslip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreparePayslipActionPerformed(evt);
            }
        });
        jPanel2.add(btnPreparePayslip);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelLeft.add(jPanel2, gridBagConstraints);

        jSplitPane1.setLeftComponent(panelLeft);

        panelCenter.setLayout(new java.awt.GridBagLayout());

        panelPayrollPeriod.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelPayrollPeriod.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelPayrollPeriod.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Code");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelPayrollPeriod.add(jLabel2, gridBagConstraints);

        txtTid.setEditable(false);
        txtTid.setFont(new java.awt.Font("Tahoma", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        panelPayrollPeriod.add(txtTid, gridBagConstraints);

        txtCode.setEditable(false);
        txtCode.setFont(new java.awt.Font("Tahoma", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelPayrollPeriod.add(txtCode, gridBagConstraints);

        jLabel3.setText("From");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelPayrollPeriod.add(jLabel3, gridBagConstraints);

        txtDateTo.setFont(new java.awt.Font("Verdana", 1, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelPayrollPeriod.add(txtDateTo, gridBagConstraints);

        txtDateFrom.setFont(new java.awt.Font("Verdana", 1, 12));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelPayrollPeriod.add(txtDateFrom, gridBagConstraints);

        jLabel4.setText("To");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelPayrollPeriod.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Date Prepared");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelPayrollPeriod.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Notes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelPayrollPeriod.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelPayrollPeriod.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        panelPayrollPeriod.add(jLabel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelPayrollPeriod.add(comboStatus, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelPayrollPeriod.add(comboType, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelPayrollPeriod.add(txtNotes, gridBagConstraints);

        txtDatePrepared.setEditable(false);
        txtDatePrepared.setFont(new java.awt.Font("Tahoma", 1, 11));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        panelPayrollPeriod.add(txtDatePrepared, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelCenter.add(panelPayrollPeriod, gridBagConstraints);

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
            .addGap(0, 198, Short.MAX_VALUE)
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
        MainApp.messagePanelObservable.callObserver(new PanelMessage("Payroll Period", "remove"));
}//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (pp != null) {
            try {

                saveScreen();
                dbms.save(pp, true);
                // TODO review the generated test code and remove the default call to fail.

                initTableView();
                JOptionPane.showMessageDialog(this, "Payroll Period information save.", "Payroll Period", JOptionPane.INFORMATION_MESSAGE);
            
            } catch (TransactionException ex) {
                JOptionErrorMessage.showErrorMessage(this.getClass().getCanonicalName(), ex.getSimpleMessage());
            } catch (Exception ex) {
                JOptionErrorMessage.showErrorMessage(this.getClass().getCanonicalName(), ex);
            }
        }
}//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed

        pp = new PayrollPeriod();

        pp.setDatePrepared(new Date());

        disableAllControls(true);
        initScreen();

}//GEN-LAST:event_btnNewActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnCancelActionPerformed

    private void tablePayrollPeriodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePayrollPeriodMouseClicked
       // if (evt.getClickCount() > 1) {

            JTable jTable = (JTable) evt.getSource();
            if (jTable.getRowCount() > 0) {
                int row = jTable.getSelectedRow();
                if(row < 0)
                    return;
                
                PayrollPeriod p = (PayrollPeriod) jTable.getValueAt(row, 1);

                if (p != null) {
                    try {
                        pp = PayrollPeriod.getPayrollPeriodByTid(p.getId());
                    //    dbms.getDBInstance().activate(pp, 3);
                        initScreen();
                    } catch (Exception ex) {
                        Logger.getLogger(PayrollPeriod.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
      //  }
    }//GEN-LAST:event_tablePayrollPeriodMouseClicked

    private void btnPreparePayslipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreparePayslipActionPerformed


            if (tablePayrollPeriod.getRowCount() > 0) {
                int row = tablePayrollPeriod.getSelectedRow();
                if(row<0){
                     JOptionPane.showMessageDialog(this, "Please Select Payroll Period.", "Payroll Period", JOptionPane.INFORMATION_MESSAGE);
                }
                PayrollPeriod p = (PayrollPeriod) tablePayrollPeriod.getModel().getValueAt(row, 1);

                if (p != null) {
                    try {
                        pp = PayrollPeriod.getPayrollPeriodByTid(p.getId());
                   //     dbms.getDBInstance().activate(pp, 3);
                        int counter =  PaySlipProcess.createPayslipForPayrollPeriod(pp,null);
                          JOptionPane.showMessageDialog(this, "Done, creating Payslip("+counter+") for Pay Type: "+ pp.getPayrollPeriodType(), "Payroll Period", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        Logger.getLogger(PayrollPeriod.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

    }//GEN-LAST:event_btnPreparePayslipActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPreparePayslip;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JComboBox comboType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelMainCenter;
    private javax.swing.JPanel panelPayrollPeriod;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelSubMaterial;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTable tablePayrollPeriod;
    private javax.swing.JTextField txtCode;
    private org.jdesktop.swingx.JXDatePicker txtDateFrom;
    private javax.swing.JTextField txtDatePrepared;
    private org.jdesktop.swingx.JXDatePicker txtDateTo;
    private javax.swing.JTextField txtNotes;
    private javax.swing.JTextField txtTid;
    // End of variables declaration//GEN-END:variables

    private void initTableView() {
        try {
            NonEditableDefaultTableModel dtm = new NonEditableDefaultTableModel();
            dtm.setColumnIdentifiers(new String[]{"Id", "Code", "From", "To", "Prepared", "Status"});

//            for (PayrollPeriod p : dbms.getDBInstance().query(PayrollPeriod.class)) {
//
//                try {
//                    Object[] o = new Object[]{p.getTid(), p,
//                        sdf.format(p.getDateFrom()), sdf.format(p.getDateTo()),
//                        sdf.format(p.getDatePrepared()), p.getStatus()};
//                    dtm.addRow(o);
//                } catch (Exception ex) {
//                }
//
//            }
            tablePayrollPeriod.setModel(dtm);
        } catch (Exception ex) {
            Logger.getLogger(PayrollPeriodInformation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initComboBox() {
        for (PayrollPeriodStatus pps : PayrollPeriodStatus.values()) {
            comboStatus.addItem(pps.name());
        }

        for (PayrollPeriodType ppt : PayrollPeriodType.values()) {
            comboType.addItem(ppt.name());
        }
    }

    private void initScreen() {
        if(pp.getStatus().equals(PayrollPeriodStatus.Generated.name())){
            disableAllControls(false);
        }else{
        disableAllControls(true);
        }
        txtTid.setText(pp.getId() + "");
        txtCode.setText(pp.getPayrollPeriodCode());
        txtDatePrepared.setText(sdf.format(pp.getDatePrepared()));
        txtDateTo.setDate(pp.getDateTo());
        txtDateFrom.setDate(pp.getDateFrom());
        txtNotes.setText(pp.getNotes());
        comboStatus.setSelectedItem(pp.getStatus());
        comboType.setSelectedItem(pp.getPayrollPeriodType());



    }

    private void saveScreen() {


        pp.setNotes(txtNotes.getText());
        pp.setDateFrom(txtDateFrom.getDate());
        pp.setDateTo(txtDateTo.getDate());
        pp.setStatus(comboStatus.getSelectedItem().toString());
        pp.setPayrollPeriodType(comboType.getSelectedItem().toString());


    }

    private void disableAllControls(boolean s) {

        for (Component c : panelPayrollPeriod.getComponents()) {
            c.setEnabled(s);
        }

    }
}
