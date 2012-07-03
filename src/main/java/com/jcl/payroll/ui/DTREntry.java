/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Dependents.java
 *
 * Created on Oct 31, 2010, 3:21:47 PM
 */
package com.jcl.payroll.ui;

import com.jcl.model.Employee;
import com.jcl.model.DailyTimeRecord;
import com.jcl.payroll.enumtypes.DTRType;
import com.jcl.payroll.transaction.OvertimeRateProvider;
import com.jcl.utilities.MyDateFormatter;
import com.jcl.utilities.TransactionException;
import com.jcl.utils.MyDateUtil;
import com.jcl.utils.SelectedButton;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.joda.time.DateTime;

/**
 *
 * @author junald
 */
public class DTREntry extends javax.swing.JDialog {

    public SelectedButton selectedButton = SelectedButton.Cancel;
    public DailyTimeRecord dtr;
    public SimpleDateFormat sdf2;
    Date lastEnteredDate;

    /**
     * Creates new form Dependents
     */
    public DTREntry(java.awt.Frame parent, boolean modal, DailyTimeRecord dtr, Date lastEnteredDate) {
        super(parent, modal);
        this.dtr = dtr;
        initComponents();
        this.lastEnteredDate = lastEnteredDate;

        sdf2 = MyDateFormatter.getDateTimeFormatter();

        txtWorkingDate.setFormats("MM/dd/yyyy");

        ComboBoxModel cbm = new DefaultComboBoxModel(DTRType.values());
        comboDTRType.setModel(cbm);
        labelCompleteName.setText(dtr.getEmployee().getName());
        initScreen();


    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        panelDTR = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtWorkingDate = new org.jdesktop.swingx.JXDatePicker();
        comboDTRType = new javax.swing.JComboBox();
        labelName = new javax.swing.JLabel();
        labelCompleteName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNotes = new javax.swing.JTextField();
        labelHours = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHours = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMinutes = new javax.swing.JFormattedTextField();
        chkRestDay = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTimeIn = new javax.swing.JFormattedTextField();
        txtTimeOut = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        chkBoxDeduction = new javax.swing.JCheckBox();
        chkBoxWithPay = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dependents");
        setMaximumSize(new java.awt.Dimension(300, 340));
        setMinimumSize(new java.awt.Dimension(300, 340));
        setPreferredSize(new java.awt.Dimension(300, 340));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMaximumSize(new java.awt.Dimension(250, 35));
        jPanel2.setMinimumSize(new java.awt.Dimension(250, 35));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 35));
        jPanel2.setRequestFocusEnabled(false);
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel);

        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(65, 23));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        panelDTR.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDTR.setMaximumSize(new java.awt.Dimension(250, 290));
        panelDTR.setMinimumSize(new java.awt.Dimension(250, 290));
        panelDTR.setPreferredSize(new java.awt.Dimension(250, 290));
        panelDTR.setLayout(new java.awt.GridBagLayout());

        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Type");
        jLabel5.setToolTipText("WorkedHours\nVL_WP = Vacation With Pay\nVL_WOP = Vacation With Out Pay\nSL_WP = Sick Leave With Pay\nSL_WOP = Sick Leave With Out Pay\nUndertime\nHL = Holiday Legal\nHS = Holiday Special\nAbsent \nOT_RD = Overtime Regular Day DAILY\nOT_RSD = Overtime Rest Day\nOT_LHRGD = Overtime Legal Holiday Regular Day\nOT_LHRTD = Overtime Legal Holiday Rest Day\nOT_SHRGD = Overtime Special Holiday Regular Day\nOT_SHRTD = Overtime Special Holiday Rest Day\nOT_RM = Overtime Regular Day MONTHLY\nOT_RSM = Overtime Rest Day\nOT_LHRGM = Overtime Legal Holiday Regular Day\nOT_LHRTM = Overtime Legal Holiday Rest Day\nOT_SHRGM = Overtime Special Holiday Regular Day\nOT_SHRTM = Overtime Special Holiday Rest Day\n");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDTR.add(jLabel5, gridBagConstraints);

        jLabel4.setText("Date");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDTR.add(jLabel4, gridBagConstraints);

        txtWorkingDate.setNextFocusableComponent(comboDTRType);
        txtWorkingDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtWorkingDateFocusLost(evt);
            }
        });
        txtWorkingDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtWorkingDatePropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        panelDTR.add(txtWorkingDate, gridBagConstraints);

        comboDTRType.setNextFocusableComponent(txtHours);
        comboDTRType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDTRTypeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        panelDTR.add(comboDTRType, gridBagConstraints);

        labelName.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 3, 5);
        panelDTR.add(labelName, gridBagConstraints);

        labelCompleteName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelCompleteName.setForeground(java.awt.Color.blue);
        labelCompleteName.setText("Lavador, Junald Conde");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 5);
        panelDTR.add(labelCompleteName, gridBagConstraints);

        jLabel7.setText("Notes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelDTR.add(jLabel7, gridBagConstraints);

        txtNotes.setText(" ");
        txtNotes.setNextFocusableComponent(btnSave);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        panelDTR.add(txtNotes, gridBagConstraints);

        labelHours.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelDTR.add(labelHours, gridBagConstraints);

        jLabel8.setText("Hours");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDTR.add(jLabel8, gridBagConstraints);

        txtHours.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0"))));
        txtHours.setNextFocusableComponent(txtMinutes);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        panelDTR.add(txtHours, gridBagConstraints);

        jLabel9.setText("Minutes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        panelDTR.add(jLabel9, gridBagConstraints);

        txtMinutes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0"))));
        txtMinutes.setNextFocusableComponent(txtNotes);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        panelDTR.add(txtMinutes, gridBagConstraints);

        chkRestDay.setText("Rest Day");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        panelDTR.add(chkRestDay, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Time In");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Time Out");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel1.add(jLabel2, gridBagConstraints);

        txtTimeIn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd h:mm a"))));
        txtTimeIn.setToolTipText("YYYY-MM-DD hh:mm a");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(txtTimeIn, gridBagConstraints);

        txtTimeOut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd h:mm a"))));
        txtTimeOut.setToolTipText("YYYY-MM-DD hh:mm a");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(txtTimeOut, gridBagConstraints);

        jButton2.setForeground(java.awt.Color.blue);
        jButton2.setText("Compute Hours and minutes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 4);
        jPanel1.add(jButton2, gridBagConstraints);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("First 8hrs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jRadioButton1, gridBagConstraints);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Before 10PM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jRadioButton2, gridBagConstraints);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("10PM to 6AM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jRadioButton3, gridBagConstraints);

        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("( YYYY-MM-DD hh:mm am)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jLabel3, gridBagConstraints);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Regular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jRadioButton4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelDTR.add(jPanel1, gridBagConstraints);

        chkBoxDeduction.setText("Deduction");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        panelDTR.add(chkBoxDeduction, gridBagConstraints);

        chkBoxWithPay.setText("With Pay");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        panelDTR.add(chkBoxWithPay, gridBagConstraints);

        getContentPane().add(panelDTR, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            selectedButton = SelectedButton.Save;
            saveScreen();
            this.setVisible(false);
        } catch (TransactionException ex) {
            Logger.getLogger(DTREntry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DTREntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        selectedButton = SelectedButton.Cancel;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void comboDTRTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDTRTypeActionPerformed
        // TODO add your handling code here:
        String s = (String) comboDTRType.getSelectedItem();
        DTRType selectedDTRType = DTRType.valueOf(s);

     
        chkBoxDeduction.setSelected(false);
        if (selectedDTRType == DTRType.Absent || selectedDTRType == DTRType.Undertime) {
     
            chkBoxDeduction.setSelected(true);
        } else if (selectedDTRType == DTRType.SL_WP && dtr.getEmployee().getSickLeave() >= 0) {
            chkBoxDeduction.setSelected(false);
     
            chkBoxWithPay.setSelected(true);
        } else if (selectedDTRType == DTRType.VL_WP && dtr.getEmployee().getVacationLeave() >= 0) {
            chkBoxDeduction.setSelected(false);
     
            chkBoxWithPay.setSelected(true);
        } else if (selectedDTRType == DTRType.SL_WOP && dtr.getEmployee().getSickLeave() >= 0) {
            chkBoxDeduction.setSelected(true);
     
            chkBoxWithPay.setSelected(false);
        } else if (selectedDTRType == DTRType.VL_WOP && dtr.getEmployee().getVacationLeave() >= 0) {
            chkBoxDeduction.setSelected(true);
     
            chkBoxWithPay.setSelected(false);
        }
    }//GEN-LAST:event_comboDTRTypeActionPerformed

    private void txtWorkingDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtWorkingDatePropertyChange
        // System.out.println("name: " + evt.getPropertyName());
        //System.out.println(evt.getOldValue().toString());
        System.out.println(evt.getNewValue().toString());
        checkDay();
    }//GEN-LAST:event_txtWorkingDatePropertyChange

    private void txtWorkingDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtWorkingDateFocusLost
        if (dtr != null && dtr.getId() == null) {
            checkDay();
        }
    }//GEN-LAST:event_txtWorkingDateFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        computeHrs();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DTREntry dialog = new DTREntry(new javax.swing.JFrame(), true, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkBoxDeduction;
    private javax.swing.JCheckBox chkBoxWithPay;
    private javax.swing.JCheckBox chkRestDay;
    private javax.swing.JComboBox comboDTRType;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JLabel labelCompleteName;
    private javax.swing.JLabel labelHours;
    private javax.swing.JLabel labelName;
    private javax.swing.JPanel panelDTR;
    private javax.swing.JFormattedTextField txtHours;
    private javax.swing.JFormattedTextField txtMinutes;
    private javax.swing.JTextField txtNotes;
    private javax.swing.JFormattedTextField txtTimeIn;
    private javax.swing.JFormattedTextField txtTimeOut;
    private org.jdesktop.swingx.JXDatePicker txtWorkingDate;
    // End of variables declaration//GEN-END:variables

    private void initScreen() {

        comboDTRType.setSelectedItem("Regular");
        if (dtr.getId() == null) {
            txtWorkingDate.setDate(lastEnteredDate);
            checkDay();
        } else {
            txtWorkingDate.setDate(dtr.getTransactionDate());
        }

        txtNotes.setText(dtr.getNotes());
        txtMinutes.setValue(dtr.getActualMins());
        txtHours.setValue(dtr.getActualHours());
        chkRestDay.setSelected(dtr.getRestDay());

        txtTimeIn.setValue(dtr.getTimeIn1() != null ? dtr.getTimeIn1() : dtr.getTransactionDate());
        txtTimeOut.setValue(dtr.getTimeOut1() != null ? dtr.getTimeOut1() : dtr.getTransactionDate());

        initCheckBox(DTRType.valueOf(dtr.getDtrType()));

        Integer section = dtr.getSection();
        if (dtr.getSection() == 3) {
            jRadioButton3.setSelected(true);
        } else if (dtr.getSection() == 2) {
            jRadioButton2.setSelected(true);
        } else if(dtr.getSection() == 1 ){
            jRadioButton1.setSelected(true);
        } else {
            jRadioButton4.setSelected(true);
        }

        if (dtr.getProcess()) {
            btnSave.setEnabled(false);
        }
        
        chkBoxDeduction.setEnabled(false);
        chkBoxWithPay.setEnabled(false);
    }

    private void saveScreen() throws TransactionException, Exception {

        dtr.setTransactionDate(txtWorkingDate.getDate());
        dtr.setDtrType(comboDTRType.getSelectedItem().toString());
        dtr.setNotes(txtNotes.getText());
        dtr.setActualMins(Integer.valueOf(txtMinutes.getText()));
        dtr.setActualHours(Integer.valueOf(txtHours.getText()));

        Date t1 = sdf2.parse(txtTimeIn.getText());
        Date t2 = sdf2.parse(txtTimeOut.getText());
        dtr.setTimeIn1(t1);
        dtr.setTimeOut1(t2);
        dtr.setRestDay(chkRestDay.isSelected());
        dtr.setWithPay(chkBoxWithPay.isSelected());
        dtr.setDeduction(chkBoxDeduction.isSelected());
        Integer section = 0;
        if (buttonGroup1.isSelected(jRadioButton1.getModel())) {
            section = 1;
        } else if (buttonGroup1.isSelected(jRadioButton2.getModel())) {
            section = 2;
        } else if (buttonGroup1.isSelected(jRadioButton3.getModel())) {
            section = 3;
        } else if (buttonGroup1.isSelected(jRadioButton4.getModel())) {
            section = 0;
        }
        dtr.setSection(section);

    }

    private void checkDay() {
        if (dtr.getId() == null) {
            try {
                txtWorkingDate.commitEdit();
            } catch (ParseException ex) {
                Logger.getLogger(DTREntry.class.getName()).log(Level.SEVERE, null, ex);
            }
            Date today = txtWorkingDate.getDate();

            boolean isSunday = MyDateUtil.isSunday(today);
            if (isSunday) {
                chkRestDay.setSelected(true);
            }

        }

    }

    private void computeHrs() {
        if (txtTimeIn.getValue() != null && txtTimeOut.getValue() != null) {
            try {
                txtTimeIn.commitEdit();
                txtTimeOut.commitEdit();
            } catch (ParseException ex) {
                Logger.getLogger(DTREntry.class.getName()).log(Level.SEVERE, null, ex);
            }

            DateTime timeStart = new DateTime(txtTimeIn.getValue());
            DateTime timeEnd = new DateTime(txtTimeOut.getValue());
            System.out.println(timeStart);
            System.out.println(timeEnd);
            String hoursAndMinutes = MyDateUtil.timeDifferent(timeStart, timeEnd);
            String[] hAndm = hoursAndMinutes.split(":");
            txtHours.setText(hAndm[0]);
            txtMinutes.setText(hAndm[1]);

            Integer section = MyDateUtil.timeSection(timeStart, timeEnd);
            if (section == 3) {
                jRadioButton3.setSelected(true);
            } else if (section == 2) {
                jRadioButton2.setSelected(true);
            } else if(section == 1){
                jRadioButton1.setSelected(true);
            }
            
        }
    }

    private void initCheckBox(DTRType selectedDTRType) {

        if (selectedDTRType == DTRType.Absent || selectedDTRType == DTRType.Undertime) {        
            chkBoxDeduction.setSelected(dtr.getDeduction());
        } else {            
            chkBoxDeduction.setSelected(false);            
        }
        
        if (selectedDTRType == DTRType.VL_WP || selectedDTRType == DTRType.SL_WP ||
                selectedDTRType == DTRType.VL_WOP && selectedDTRType == DTRType.SL_WOP) {            
            
            chkBoxWithPay.setSelected(dtr.getWithPay());
            chkBoxDeduction.setSelected(!dtr.getWithPay());
        } else {
            chkBoxDeduction.setSelected(false);
            chkBoxWithPay.setSelected(false);
            chkBoxWithPay.setSelected(false);
        }
        
        if(!OvertimeRateProvider.isOvertime(dtr.getDtrType().toString())){
            jRadioButton4.setSelected(true);
        }
    }
}
