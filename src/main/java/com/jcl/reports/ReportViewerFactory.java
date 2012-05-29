/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.reports;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import com.jcl.dbms.dbms;
import com.jcl.utilities.MyDateFormatter;
import com.jcl.utilities.MyNumberFormatter;
import com.jcl.utilities.TransactionException;
import com.jcl.utils.ObjectDataSource;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author junald
 */
public class ReportViewerFactory {

    String filename;
    private HashMap parameters;
    private List dataList;

    /**
     *
     * @param filename = filename of the report *.jasper and the string coming
     * from the
     *
     * @param parameters
     * @param list
     */
    public ReportViewerFactory(String filename, HashMap parameters, List list) {
        this.filename = filename;
        this.parameters = parameters;
        this.dataList = list;
    }

    /**
     *
     * if checkForDynamic Report if it is true;
     * @param checkForDJ = boolean
     *
     * @return
     */
    public JRViewer getReport(boolean checkForDJ) {
        JRViewer jrv = null;

        try {
            DynamicReport dr = null;
            String jasper = checkJasperReportFile();
            boolean continueReport = false;
            if (jasper == null && checkForDJ) {
                //if jasper file is not found this will create the dynamic report jrxml
                System.out.println("checkForDJ: " + checkForDJ);
//                if (filename.equals("InventoryBalance")) {
//                    DJRInventory djrinventory = new DJRInventory(filename, "Inventory on hand");
//                    dr = djrinventory.generateDynamicReport();
//                } else if (filename.equals("InventoryBalanceSupplier")) {
//                    DJRInventory djrinventory = new DJRInventory(filename, "Inventory on hand");
//                    dr = djrinventory.generateDynamicReport();
//                }

                exportToJRXML(dr);
                continueReport = true;
            } else {
                continueReport = true;
            }

            if (continueReport) {
                jrv = generateReport(parameters, dataList);
            }

        } catch (JRException ex) {
            Logger.getLogger(ReportViewerFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ReportViewerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jrv;
    }

    private String checkJasperReportFile() throws JRException {

        String reportfile = null;
        String jrxml = dbms.codebaseReports + filename + ".jrxml";
        String jasper = dbms.codebaseReports + filename + ".jasper";
        System.out.println(jrxml);
        System.out.println(jasper);
        File jasperf = new File(jasper);
        File jrxmlf = new File(jrxml);
        //if jasper file not found try to compile jrxml file
        if (!jasperf.exists()) {
            System.out.println("jasper file not found try to compile jrxml file");
            //if jrxml file is found it will generate the jasper file
            //else throw excepion
            if (jrxmlf.exists()) {
                JasperCompileManager.compileReportToFile(jrxml, jasper);
                reportfile = jasper;
            }
        } else {
            reportfile = jasper;
        }

        return reportfile;
    }

    protected JRViewer generateReport(Map parameters, List list) throws FileNotFoundException, JRException {

        JRViewer jrw = null;

        ObjectDataSource ods = new ObjectDataSource(list, false);
        
//        System.out.println("============================");
//        for(Object ib: list){
//            InventoryBalance iib = (InventoryBalance) ib;
//            System.out.println(iib.asOfDate);
//        }
        // JasperDesign jd = JRXmlLoader.load("D:\\javatemplate\\ReportingSample\\src\\report1.jrxml");

        String jrxml = dbms.codebaseReports + filename + ".jrxml";
        String jasper = dbms.codebaseReports + filename + ".jasper";


        File f = new File(jasper);
        if (!f.exists()) {
            System.out.println("jasper file not found, compiling jrxml");
            JasperCompileManager.compileReportToFile(jrxml, jasper);
        } else {
            System.out.println("jasper found");
            // throw new FileNotFoundException("cannot find " + jasper);
        }

        System.out.println("loading jasper");
        JasperReport jr = (JasperReport) JRLoader.loadObjectFromLocation(jasper);
        System.out.println("creating jasper print");
        JasperPrint jp = JasperFillManager.fillReport(jr, parameters, ods);
        System.out.println("jasper print created");
        jrw = new JRViewer(jp);

        return jrw;
    }

    public JRViewer generateReportDirect() throws FileNotFoundException, JRException {

        JRViewer jrw = null;

        JRDataSource jrsource = new JRBeanCollectionDataSource(dataList);
        String jrxml = dbms.codebaseReports + filename + ".jrxml";
        String jasper = dbms.codebaseReports + filename + ".jasper";


        File f = new File(jasper);
        if (!f.exists()) {
            System.out.println("jasper file not found, compiling jrxml");
            JasperCompileManager.compileReportToFile(jrxml, jasper);
        } else {
            System.out.println("jasper found");
            // throw new FileNotFoundException("cannot find " + jasper);
        }

        System.out.println("loading jasper");
        JasperReport jr = (JasperReport) JRLoader.loadObjectFromLocation(jasper);
        System.out.println("creating jasper print");
        JasperPrint jp = JasperFillManager.fillReport(jr, parameters, jrsource);
        System.out.println("jasper print created");
        jrw = new JRViewer(jp);

        return jrw;
    }

    protected void exportToJRXML(DynamicReport dr) throws Exception {

        String fname = dbms.codebaseReports + filename + ".jrxml";
        Map params = new HashMap();
        DynamicJasperHelper.generateJRXML(dr, new ClassicLayoutManager(), params, "UTF-8", fname);

    }

    public void showReport(JRViewer jrv) {
        System.out.println("showing jframe");
        JFrame jf = new JFrame();
        jf.setTitle("Report Viewer");
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setLayout(new BorderLayout());
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.add(jrv);
        jf.getContentPane().add(jp);
        jf.setSize(700, 400);
        jf.setVisible(true);
        System.out.println("showing jframe done");
    }

//    public static void main2(String[] args) {
//        try {
//            dbms.setProperties();
//            JFrame jf = new JFrame();
//            jf.setLayout(new BorderLayout());
//            JPanel jp = new JPanel();
//            jp.setLayout(new BorderLayout());
//            ReportViewerFactory rv = new ReportViewerFactory("InventoryBalanceAllGrowerCrossTab", null, null);
//            // HashMap<String, InventoryBalance> hmap = Inventory.getInventoryBalance();
//            HashMap<String, InventoryBalance> hmap = Inventory.getInventoryBalanceAllGrower(new Date(), null);
//            List<InventoryBalance> list = new ArrayList<InventoryBalance>(hmap.values());
//            JRViewer jrv = null;
//            try {
//                //jrv = rv.generateInventoryReport("InventoryBalance", new HashMap(), list);
//                //  jrv = rv.generateInventoryReport("InventoryBalanceAllGrower", new HashMap(), list);
//                jrv = rv.generateReport(new HashMap(), list);
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(ReportViewerFactory.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (JRException ex) {
//                Logger.getLogger(ReportViewerFactory.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            jp.add(jrv);
//            jf.getContentPane().add(jp);
//            jf.setSize(300, 300);
//            jf.setVisible(true);
//        } catch (Exception ex) {
//            Logger.getLogger(ReportViewerFactory.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

//    public static void main(String[] args) {
//        try {
//            dbms.setProperties();
//            SimpleDateFormat sdf = MyDateFormatter.getSimpleDateTimeFormatter();
//
//
//            HashMap parameters = new HashMap();
//            //  CompanySetting cs = CompanySetting.companySetting();
//
//            parameters.put("REPORT_TITLE", "REPORT_TITLE");
//            parameters.put("ADDRESS_1", "ADDRESS_1");
//            parameters.put("ADDRESS_2", "ADDRESS_2");
//            parameters.put("TELEPHONE_1", "TELEPHONE_1");
//            parameters.put("BILL_NO", "1234567890");
//            parameters.put("BILL_TO", "ABCDEFGHJIKL");
//            parameters.put("BILL_ADDRESS_1", "AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//            parameters.put("BILL_ADDRESS_2", "VVVVVVVVVVVVVVVVVVVVVVVVVVVV");
//            parameters.put("TRANSACTION_DATE", sdf.format(new Date()));
//            parameters.put("PREPARED_BY", "xxxxxxxxxxxxxxxxxxxxxxx");
//
//            //       BillingProcessor bp = new BillingProcessor();
//            Double netTotal = 0.0;
//
//            //BillingReportObject bro  = bp.createBillingPrintout(v );
//            BillingReportObject bro = new BillingReportObject();
//            BillingReportRow brr = new BillingReportRow();
//            brr.setRow("1");
//            brr.setDescription("test");
//            brr.setPrice("12.23");
//            brr.setQty("123");
//            brr.setUom("box");
//            brr.setQty135("123");
//            brr.setType("add");
//            brr.setAmount(123.45);
//            BillingReportRow brr1 = new BillingReportRow();
//            brr1.setRow("2");
//            brr1.setDescription("test");
//            brr1.setUom("box");
//            brr1.setPrice("12.23");
//            brr1.setQty("123");
//            brr1.setQty135("123");
//            brr1.setType("add");
//            brr1.setAmount(123.45);
//            BillingReportRow brr2 = new BillingReportRow();
//            brr2.setRow("3");
//            brr2.setDescription("test");
//            brr2.setUom("box");
//            brr2.setPrice("12.23");
//            brr2.setQty("123");
//            brr2.setQty135("123");
//            brr2.setType("minus");
//            brr2.setAmount(123.45);
//            ArrayList<BillingReportRow> brrlist = new ArrayList<BillingReportRow>();
//            brrlist.add(brr);
//            brrlist.add(brr1);
//            brrlist.add(brr2);
//            bro.setList(brrlist);
//            List list = new ArrayList();
//            list.add(bro);
//            parameters.put("NET_TOTAL", MyNumberFormatter.formatAmount(1000.5));
//            parameters.put("SUBREPORT_DIR", "D:/javatemplate/JCLApps/Reports/");
//
//            ReportViewerFactory rvf = new ReportViewerFactory("BillingWithSubreports", parameters, list);
//            //  ReportViewerFactory rvf = new ReportViewerFactory("Billing1", parameters, bro.list);
//            JRViewer jrv = rvf.getReport(false);
//            rvf.showReport(jrv);
//
//        } catch (Exception ex) {
//        }
//
//    }
}
// JRViewer generateInventoryReportOld(Map parameters, List<InventoryBalance> list) throws FileNotFoundException, JRException {
//
//        JRViewer jrw = null;
//
//
//        ObjectDataSource ods = new ObjectDataSource(list, false);
//        // JasperDesign jd = JRXmlLoader.load("D:\\javatemplate\\ReportingSample\\src\\report1.jrxml");
//
//        String jrxml = dbms.codebaseReports + filename + ".jrxml";
//        String jasper = dbms.codebaseReports + filename + ".jasper";
//
//
//        File f = new File(jasper);
//        if (!f.exists()) {
//            System.out.println("jasper file not found");
//            JasperCompileManager.compileReportToFile(jrxml, jasper);
//        } else {
//            System.out.println("jasper found");
//            // throw new FileNotFoundException("cannot find " + jasper);
//        }
//
//
//        System.out.println("loading jasper");
//        JasperReport jr = (JasperReport) JRLoader.loadObjectFromLocation(jasper);
//
//        //jasperreport, maps, jrdatasource
//        System.out.println("fill data");
//        parameters.put("REPORT_TITLE", "RGB Inventory Report");
//
//        JasperPrint jp = JasperFillManager.fillReport(jr, parameters, ods);
//
//        System.out.println("jrviewer");
//        jrw = new JRViewer(jp);
//
//        return jrw;
//    }
//
//    JRViewer generateDynamicInventoryReport(Map parameters, List<InventoryBalance> list) {
//        JRViewer jrw = null;
//        try {
//
//            DJInventoryReport djir = new DJInventoryReport(list);
//
//            JasperPrint jp = djir.createReport();
//
//            jrw = new JRViewer(jp);
//
//        } catch (Exception ex) {
//            Logger.getLogger(ReportViewerAndGenerator.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return jrw;
//    }
//
//

