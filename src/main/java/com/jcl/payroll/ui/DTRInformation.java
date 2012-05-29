/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EmployeeInformation.java
 *
 * Created on Sep 27, 2010, 1:13:42 PM
 */
package com.jcl.payroll.ui;



import com.jcl.customizetable.DateTableCellRenderer;
import com.jcl.customizetable.NonEditableDefaultTableModel;
import com.jcl.customizetable.NumberTableCellRenderer;
//import com.jcl.dbms.dbms;
import com.jcl.hrm.Employee;
import com.jcl.hrm.GlobalDailyRates;
import com.jcl.hrm.Position;
import com.jcl.main.MainApp;
import com.jcl.observables.PanelMessage;
import com.jcl.payroll.dtr.DailyTimeRecord;
import com.jcl.payroll.enumtypes.DTRDisplayType;
import com.jcl.payroll.enumtypes.DTRType;
import com.jcl.payroll.enumtypes.EmploymentStatus;
import com.jcl.payroll.enumtypes.MaritalStatus;
import com.jcl.payroll.enumtypes.PayrollPeriodType;
import com.jcl.payroll.transaction.PaySlipDetail;
import com.jcl.payroll.transaction.PaySlipProcess;
import com.jcl.payroll.transaction.PayrollPeriod;
import com.jcl.utilities.MyDateFormatter;
import com.jcl.utilities.TransactionException;
import com.jcl.utils.KeyValue;
import com.jcl.verycommon.JOptionErrorMessage;
import com.jcl.utils.SelectedButton;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import org.apache.poi.ss.usermodel.ExcelStyleDateFormatter;

/**
 *
 * @author jlavador
 */
public class DTRInformation extends javax.swing.JPanel {

    private Employee ce;
    private boolean isSelectionMade = false;
    private SimpleDateFormat sdf;
    private SimpleDateFormat stf;

    /** Creates new form EmployeeInformation */
    public DTRInformation() {
        try {
            initComponents();
            sdf = MyDateFormatter.getSimpleDateTimeFormatter();
            stf = MyDateFormatter.getTimeFormatter();
            initTableView();

            GlobalDailyRates gdr = GlobalDailyRates.getGlobalDailyRatesByName("Loading");

            if (gdr == null) {
                gdr = new GlobalDailyRates(GlobalDailyRates.EMPLOYEE, "Loading", 2.5);
              //  dbms.save(gdr);
            }

            txtLoaderRates.setValue(gdr.getRates());

            double loadingRates = Double.valueOf(txtLoaderRates.getText());
            gdr.setRates(loadingRates);
        //    dbms.save(gdr);

            disabledComponents(false);
            disabledComponents();
            //initTreeView();
            initComboBoxes();
            txtDateTo.setFormats("MM/dd/yyyy");
            txtDateFrom.setFormats("MM/dd/yyyy");
            txtDateTo.setDate(new Date());
            txtDateFrom.setDate(new Date());
        } catch (Exception ex) {
            Logger.getLogger(DTRInformation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initTableView() throws Exception {

        List<Employee> employeeList = new ArrayList<Employee>();

        NonEditableDefaultTableModel dtm = new NonEditableDefaultTableModel();
        DateTableCellRenderer dtcr = new DateTableCellRenderer("MM/dd/yyyy");


        dtm.setColumnIdentifiers(new String[]{"ID", "Position", "Name"});

        try {
   //         dbms.useNewDBInstance();
            employeeList = Employee.getSortedEmployees();

            for (Employee e : employeeList) {

                if (e != null) {
                    Object[] o = new Object[]{e.getIdNumber(), e.getPosition(), e};
                    dtm.addRow(o);
                }
            }

        } finally {
  //          dbms.closeNewDB();
        }


        tableEmployees.setModel(dtm);
//        tableEmployees.getColumn("DateOfBirth").setCellRenderer(dtcr);
        tableEmployees.getColumn("ID").setMaxWidth(50);
        tableEmployees.getColumn("ID").setMinWidth(50);
        tableEmployees.getColumn("Position").setMaxWidth(70);
        tableEmployees.getColumn("Position").setMinWidth(70);

    }

    private void disabledComponents() {


        this.jLabel40.setVisible(false);
        this.jLabel41.setVisible(false);
        //    this.jLabel42.setVisible(false);
        //  this.textAllowance.setVisible(false);
        this.textMinuteRate.setVisible(false);
        this.textHourlyRate.setVisible(false); //dailyRate

    }

    private void disabledComponents(boolean s) {
        for (Component c : panelEmployeeInfo.getComponents()) {
            c.setEnabled(s);
        }

        for (Component c : panelContactInfo4.getComponents()) {
            c.setEnabled(s);
        }

        for (Component c : jPanel1.getComponents()) {
            c.setEnabled(s);
        }

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelTop = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        panelBottom = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        panelLeft = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmployees = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        txtLoaderRates = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        panelEmployeeInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEmployeeID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        labelCompleteName = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        panelContactInfo4 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        textBasicSalary = new javax.swing.JFormattedTextField();
        textDailyRate = new javax.swing.JFormattedTextField();
        textHourlyRate = new javax.swing.JFormattedTextField();
        textMinuteRate = new javax.swing.JFormattedTextField();
        textAllowance = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        labelPayType = new javax.swing.JLabel();
        labelPostion = new javax.swing.JLabel();
        panelOthers = new javax.swing.JPanel();
        panelDTR = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnInsertDetail = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        txtDateTo = new org.jdesktop.swingx.JXDatePicker();
        jLabel19 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        comboDisplayType = new javax.swing.JComboBox();
        jPanel15 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        txtDateFrom = new org.jdesktop.swingx.JXDatePicker();
        btnRefreshDTR = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableDTR = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new java.awt.BorderLayout());

        panelTop.setBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.inactiveTitleGradient"));
        panelTop.setMinimumSize(new java.awt.Dimension(0, 25));
        panelTop.setPreferredSize(new java.awt.Dimension(750, 25));
        panelTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText("Daily Time Record");
        panelTop.add(jLabel8);

        add(panelTop, java.awt.BorderLayout.PAGE_START);

        panelBottom.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelBottom.setMinimumSize(new java.awt.Dimension(0, 32));
        panelBottom.setPreferredSize(new java.awt.Dimension(750, 40));
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

        jSplitPane1.setDividerLocation(350);

        panelLeft.setLayout(new java.awt.BorderLayout());

        tableEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableEmployees.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmployees);

        panelLeft.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel18.setMaximumSize(new java.awt.Dimension(32767, 32));
        jPanel18.setMinimumSize(new java.awt.Dimension(0, 32));
        jPanel18.setPreferredSize(new java.awt.Dimension(349, 32));

        txtLoaderRates.setEditable(false);
        txtLoaderRates.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.##"))));
        txtLoaderRates.setFont(new java.awt.Font("Tahoma", 1, 12));

        jLabel46.setText("Loader rate per box");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel46)
                .addGap(5, 5, 5)
                .addComponent(txtLoaderRates, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel46))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtLoaderRates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelLeft.add(jPanel18, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setLeftComponent(panelLeft);

        panelCenter.setLayout(new java.awt.GridBagLayout());

        panelEmployeeInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelEmployeeInfo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Employee ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(11, 5, 0, 0);
        panelEmployeeInfo.add(jLabel1, gridBagConstraints);

        txtEmployeeID.setEditable(false);
        txtEmployeeID.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtEmployeeID.setMinimumSize(new java.awt.Dimension(2, 22));
        txtEmployeeID.setPreferredSize(new java.awt.Dimension(55, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 5, 0, 0);
        panelEmployeeInfo.add(txtEmployeeID, gridBagConstraints);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelEmployeeInfo.add(jPanel1, gridBagConstraints);

        labelName.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelEmployeeInfo.add(labelName, gridBagConstraints);

        labelCompleteName.setForeground(java.awt.Color.blue);
        labelCompleteName.setText("Juan Dela Cruz");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelEmployeeInfo.add(labelCompleteName, gridBagConstraints);

        jLabel38.setText("Position");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelEmployeeInfo.add(jLabel38, gridBagConstraints);

        panelContactInfo4.setBorder(javax.swing.BorderFactory.createTitledBorder("Salary Rates"));
        panelContactInfo4.setLayout(new java.awt.GridBagLayout());

        jLabel32.setText("Basic Pay");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelContactInfo4.add(jLabel32, gridBagConstraints);

        jLabel39.setText("Daily Rate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelContactInfo4.add(jLabel39, gridBagConstraints);

        jLabel40.setText("Hourly Rate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelContactInfo4.add(jLabel40, gridBagConstraints);

        jLabel41.setText("Minute Rate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelContactInfo4.add(jLabel41, gridBagConstraints);

        jLabel42.setText("Helper Rate");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelContactInfo4.add(jLabel42, gridBagConstraints);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weighty = 1.0;
        panelContactInfo4.add(jPanel9, gridBagConstraints);

        textBasicSalary.setEditable(false);
        textBasicSalary.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.##"))));
        textBasicSalary.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelContactInfo4.add(textBasicSalary, gridBagConstraints);

        textDailyRate.setEditable(false);
        textDailyRate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.##"))));
        textDailyRate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelContactInfo4.add(textDailyRate, gridBagConstraints);

        textHourlyRate.setEditable(false);
        textHourlyRate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.##"))));
        textHourlyRate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelContactInfo4.add(textHourlyRate, gridBagConstraints);

        textMinuteRate.setEditable(false);
        textMinuteRate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.##"))));
        textMinuteRate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelContactInfo4.add(textMinuteRate, gridBagConstraints);

        textAllowance.setEditable(false);
        textAllowance.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.##"))));
        textAllowance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelContactInfo4.add(textAllowance, gridBagConstraints);

        jLabel16.setText("Pay Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelContactInfo4.add(jLabel16, gridBagConstraints);

        labelPayType.setForeground(java.awt.Color.blue);
        labelPayType.setText("position");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelContactInfo4.add(labelPayType, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelEmployeeInfo.add(panelContactInfo4, gridBagConstraints);

        labelPostion.setForeground(java.awt.Color.blue);
        labelPostion.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        panelEmployeeInfo.add(labelPostion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        panelCenter.add(panelEmployeeInfo, gridBagConstraints);

        panelOthers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelOthers.setLayout(new java.awt.GridBagLayout());

        panelDTR.setLayout(new java.awt.GridBagLayout());

        jPanel7.setMaximumSize(new java.awt.Dimension(150, 33));
        jPanel7.setMinimumSize(new java.awt.Dimension(100, 33));
        jPanel7.setPreferredSize(new java.awt.Dimension(150, 33));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        btnInsertDetail.setMnemonic('I');
        btnInsertDetail.setText("Insert DTR");
        btnInsertDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertDetailActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(21, 5, 0, 5);
        jPanel7.add(btnInsertDetail, gridBagConstraints);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        jPanel7.add(btnDelete, gridBagConstraints);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        jPanel7.add(jPanel12, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        panelDTR.add(jPanel7, gridBagConstraints);

        jPanel13.setLayout(new java.awt.GridBagLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel17.setText("total Hours Work");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.8;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        jPanel13.add(jLabel17, gridBagConstraints);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 12));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        jPanel13.add(txtTotal, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        panelDTR.add(jPanel13, gridBagConstraints);

        jPanel14.setLayout(new java.awt.GridBagLayout());

        txtDateTo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel14.add(txtDateTo, gridBagConstraints);

        jLabel19.setText("To");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel14.add(jLabel19, gridBagConstraints);

        jLabel35.setText("Display");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel14.add(jLabel35, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel14.add(comboDisplayType, gridBagConstraints);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel14.add(jPanel15, gridBagConstraints);

        jLabel44.setText("From");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel14.add(jLabel44, gridBagConstraints);

        txtDateFrom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel14.add(txtDateFrom, gridBagConstraints);

        btnRefreshDTR.setText("Refresh");
        btnRefreshDTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshDTRActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel14.add(btnRefreshDTR, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelDTR.add(jPanel14, gridBagConstraints);

        tableDTR.setAutoCreateRowSorter(true);
        tableDTR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableDTR.setFillsViewportHeight(true);
        tableDTR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDTRMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableDTR);

        jTabbedPane2.addTab("Time Entries", jScrollPane4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        panelDTR.add(jTabbedPane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelOthers.add(panelDTR, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelCenter.add(panelOthers, gridBagConstraints);

        jSplitPane1.setRightComponent(panelCenter);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        MainApp.messagePanelObservable.callObserver(new PanelMessage("Daily Time Record", "remove"));
    }//GEN-LAST:event_btnCloseActionPerformed

    private void openDependentDialog(com.jcl.hrm.Dependents d) {
        Dependents dui = new Dependents(null, true, d);
        dui.setLocationRelativeTo(this);
        dui.setVisible(true);
        if (dui.selectedButton == SelectedButton.Save) {
            try {
                if (dui.dependent.getId() == 0) {
                    if (ce.getDependents() == null) {
                        ce.setDependents(new ArrayList<com.jcl.hrm.Dependents>());
                    }
                    System.out.println("dependent: " + dui.dependent);
                    ce.getDependents().add(dui.dependent);
                }

            } catch (Exception ex) {
                Logger.getLogger(DTRInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        ce = new Employee();
        initScreen();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (ce != null) {

            try {


                JOptionPane.showMessageDialog(this, "Employee information save.", "Employee", JOptionPane.INFORMATION_MESSAGE);
//            } catch (UniqueFieldValueConstraintViolationException ex) {
//                JOptionErrorMessage.showErrorMessage(this.getClass().getCanonicalName(), ex);
            } catch (Exception ex) {
                JOptionErrorMessage.showErrorMessage(this.getClass().getCanonicalName(), ex);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tableEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeesMouseClicked
        if (evt.getClickCount() > 1) {

            JTable jTable = (JTable) evt.getSource();
            if (jTable.getRowCount() > 0) {
                int row = jTable.getSelectedRow();
                Employee v = (Employee) jTable.getValueAt(row, 2);

                if (v != null) {
                    try {
                        ce = Employee.getEmployeeByTid(v.getTid());
//                        dbms.getDBInstance().ext().refresh(ce, Integer.MAX_VALUE);
                        initScreen();
                    } catch (Exception ex) {
                        Logger.getLogger(DTRInformation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_tableEmployeesMouseClicked

    private void btnRefreshDTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshDTRActionPerformed
        initDTR();
}//GEN-LAST:event_btnRefreshDTRActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this transaction.", "Confirm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {

            if (tableDTR.getRowCount() > 0) {



                if (tableDTR.getRowCount() > 0) {
                    int row = tableDTR.getSelectedRow();
                    DailyTimeRecord dtr = (DailyTimeRecord) tableDTR.getValueAt(row, 2);

                    if (dtr != null) {
                        try {
                            dtr.businessRuleDelete();
                         //   dbms.getDBInstance().delete(dtr);
                            initDTR();
                        } catch (TransactionException ex) {
                            JOptionErrorMessage.showErrorMessage("Daily Time Record", ex.getSimpleMessage());
                        } catch (Exception ex) {
                            Logger.getLogger(DTRInformation.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
}//GEN-LAST:event_btnDeleteActionPerformed

    private void btnInsertDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertDetailActionPerformed
        DailyTimeRecord dtr = new DailyTimeRecord(ce.getTid());
        openDTREntryDialog(dtr);
}//GEN-LAST:event_btnInsertDetailActionPerformed

    private void tableDTRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDTRMouseClicked
        if (evt.getClickCount() > 1) {

            JTable jTable = (JTable) evt.getSource();
            if (jTable.getRowCount() > 0) {
                int row = jTable.getSelectedRow();
                DailyTimeRecord dtr = (DailyTimeRecord) jTable.getValueAt(row, 2);

                if (dtr != null) {
                    try {
                        openDTREntryDialog(dtr);
                    } catch (Exception ex) {
                        Logger.getLogger(DTRInformation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
}//GEN-LAST:event_tableDTRMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsertDetail;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRefreshDTR;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboDisplayType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelCompleteName;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPayType;
    private javax.swing.JLabel labelPostion;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelContactInfo4;
    private javax.swing.JPanel panelDTR;
    private javax.swing.JPanel panelEmployeeInfo;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelOthers;
    private javax.swing.JPanel panelTop;
    private javax.swing.JTable tableDTR;
    private javax.swing.JTable tableEmployees;
    private javax.swing.JFormattedTextField textAllowance;
    private javax.swing.JFormattedTextField textBasicSalary;
    private javax.swing.JFormattedTextField textDailyRate;
    private javax.swing.JFormattedTextField textHourlyRate;
    private javax.swing.JFormattedTextField textMinuteRate;
    private org.jdesktop.swingx.JXDatePicker txtDateFrom;
    private org.jdesktop.swingx.JXDatePicker txtDateTo;
    private javax.swing.JTextField txtEmployeeID;
    private javax.swing.JFormattedTextField txtLoaderRates;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void initComboBoxes() throws Exception {

        for (DTRDisplayType ddt : DTRDisplayType.values()) {
            comboDisplayType.addItem(ddt.name());
        }

    }

    private void initEmployee(Employee ce) {
        this.ce = ce;
        if (this.ce != null) {
            initScreen();
        }
    }

    private void initScreen() {
        disabledComponents(true);
        txtEmployeeID.setText(ce.getIdNumber());

        labelCompleteName.setText(ce.getName());

        labelPostion.setText(ce.getPosition().getDescription());

        labelPayType.setText(ce.getPayType() == null ? "please defined" : ce.getPayType());

        textBasicSalary.setValue(ce.getSalary());
        textDailyRate.setValue(ce.getDailyRate());
        textHourlyRate.setValue(ce.getHourRate());
        textMinuteRate.setValue(ce.getMinuteRate());
        textAllowance.setValue(ce.getAllowance());

//        txtDateTo.setDate(new Date());
//        txtDateFrom.setDate(new Date());

        initDTR();
        initJOB();

//comboDepartment
//comboBranch

    }

    private void initDTR() {
        try {

            NonEditableDefaultTableModel dtm = new NonEditableDefaultTableModel();
            DateTableCellRenderer dtcr = new DateTableCellRenderer("MM/dd/yy");
            dtm.setColumnIdentifiers(new String[]{"#", "Date", "Type", "In 1", "Out 1", "In 2", "Out 2", "Notes", "Process", "DTR"});


            List<DailyTimeRecord> list = new ArrayList<DailyTimeRecord>();

            Date fDate = txtDateFrom.getDate();
            Date tDate = txtDateTo.getDate();

            boolean withDate = false;

            if (fDate != null && tDate != null) {
                withDate = true;
            } else if (fDate != null || tDate != null) {
                JOptionPane.showMessageDialog(null, "Please enter both date or remove both date");
                System.out.println(fDate);
                System.out.println(tDate);
            }

            list = PaySlipProcess.retreiveDTR(fDate, tDate, ce);

            int rowCounter = 1;

            for (DailyTimeRecord v : list) {

                if (v != null && v.getEmployeeId() == ce.getTid()) {

                    Object[] o = new Object[]{rowCounter++, v.getDate(), v,
                        stf.format(v.getTimeIn1()), stf.format(v.getTimeOut1()),
                        stf.format(v.getTimeIn2()), stf.format(v.getTimeOut2()),
                        v.getNotes(), v.isProcess(), v.isIsDTR()};
                    dtm.addRow(o);
                }
            }


            tableDTR.setModel(dtm);
            NumberTableCellRenderer ntcr = new NumberTableCellRenderer();
            tableDTR.getColumn("Date").setCellRenderer(dtcr);


            tableDTR.getColumn("Type").setMaxWidth(110);
            tableDTR.getColumn("Date").setMaxWidth(80);
            tableDTR.getColumn("#").setMaxWidth(30);
            tableDTR.getColumn("In 1").setMaxWidth(50);
            tableDTR.getColumn("Out 1").setMaxWidth(50);
            tableDTR.getColumn("In 2").setMaxWidth(50);
            tableDTR.getColumn("Out 2").setMaxWidth(50);
            tableDTR.getColumn("Process").setMaxWidth(50);
            tableDTR.getColumn("DTR").setMaxWidth(50);


        } catch (Exception ex) {
            Logger.getLogger(DTRInformation.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private void initJOB() {
        //read job from trucking or box deliveries
    }

    private void openDTREntryDialog(DailyTimeRecord d) {
        DTREntry dui = new DTREntry(null, true, d, ce);
        dui.setLocationRelativeTo(this);
        dui.setVisible(true);
        if (dui.selectedButton == SelectedButton.Save) {
            try {
//                if (dui.dependent.getId() == 0) {
//                    if (ce.getDependents() == null) {
//                        ce.setDependents(new ArrayList<com.jcl.hrm.Dependents>());
//                    }
//                    System.out.println("dependent: " + dui.dependent);
//                    ce.getDependents().add(dui.dependent);
//                }
                initDTR();
            } catch (Exception ex) {
                Logger.getLogger(DTRInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
