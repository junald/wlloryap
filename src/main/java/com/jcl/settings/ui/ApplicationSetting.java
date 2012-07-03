/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ApplicationSetting.java
 *
 * Created on Nov 5, 2010, 8:22:04 PM
 */
package com.jcl.settings.ui;

import com.jcl.main.MainApp;
import com.jcl.observables.PanelMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author junald
 */
@Component
public class ApplicationSetting extends javax.swing.JPanel {

    @Autowired
    CompanySettingInformation csi;
  //  @Autowired
  //  BranchSetting bs;
    @Autowired
    PositionSetting ps;
    @Autowired
    DepartmentSetting depts;
    @Autowired
    HolidaySetting hs;
    @Autowired
    CompanySetting cs;
    @Autowired
    OtherAdjustmentSetting as;
    

    /**
     * Creates new form ApplicationSetting
     */
    public ApplicationSetting() {
        initComponents();

    }

    public void setup() {
        panelUser.add(new UserInformation());
        csi.initScreen();
    //    bs.setup();
        ps.setup();
        depts.setup();
        cs.setup();
        as.setup();
        hs.setup();
        panelSetting.add(csi);
   //     panelBranch.add(bs);
        panelPosition.add(ps);
        panelDepartment.add(depts);
        panelAdjustment.add(as);
        panelCompanies.add(cs);
        panelHolidays.add(hs);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelData = new javax.swing.JPanel();
        panelBranch = new javax.swing.JPanel();
        panelPosition = new javax.swing.JPanel();
        panelDepartment = new javax.swing.JPanel();
        panelCompanies = new javax.swing.JPanel();
        panelAdjustment = new javax.swing.JPanel();
        panelHolidays = new javax.swing.JPanel();
        panelUser = new javax.swing.JPanel();
        panelSetting = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        panelData.setLayout(new javax.swing.BoxLayout(panelData, javax.swing.BoxLayout.LINE_AXIS));
        jTabbedPane1.addTab("Data", panelData);

        panelBranch.setLayout(new javax.swing.BoxLayout(panelBranch, javax.swing.BoxLayout.LINE_AXIS));
        jTabbedPane1.addTab("Branch", panelBranch);

        panelPosition.setLayout(new javax.swing.BoxLayout(panelPosition, javax.swing.BoxLayout.LINE_AXIS));
        jTabbedPane1.addTab("Position", panelPosition);

        panelDepartment.setLayout(new javax.swing.BoxLayout(panelDepartment, javax.swing.BoxLayout.LINE_AXIS));
        jTabbedPane1.addTab("Department", panelDepartment);

        panelCompanies.setLayout(new javax.swing.BoxLayout(panelCompanies, javax.swing.BoxLayout.LINE_AXIS));
        jTabbedPane1.addTab("Companies", panelCompanies);

        panelAdjustment.setLayout(new javax.swing.BoxLayout(panelAdjustment, javax.swing.BoxLayout.LINE_AXIS));
        jTabbedPane1.addTab("Adjustment", panelAdjustment);

        panelHolidays.setLayout(new javax.swing.BoxLayout(panelHolidays, javax.swing.BoxLayout.LINE_AXIS));
        jTabbedPane1.addTab("Holidays", panelHolidays);

        panelUser.setLayout(new javax.swing.BoxLayout(panelUser, javax.swing.BoxLayout.LINE_AXIS));
        jTabbedPane1.addTab("User", panelUser);

        panelSetting.setLayout(new javax.swing.BoxLayout(panelSetting, javax.swing.BoxLayout.LINE_AXIS));
        jTabbedPane1.addTab("System", panelSetting);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        MainApp.messagePanelObservable.callObserver(new PanelMessage("Settings", "remove"));
    }//GEN-LAST:event_btnCloseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelAdjustment;
    private javax.swing.JPanel panelBranch;
    private javax.swing.JPanel panelCompanies;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelDepartment;
    private javax.swing.JPanel panelHolidays;
    private javax.swing.JPanel panelPosition;
    private javax.swing.JPanel panelSetting;
    private javax.swing.JPanel panelUser;
    // End of variables declaration//GEN-END:variables
}
