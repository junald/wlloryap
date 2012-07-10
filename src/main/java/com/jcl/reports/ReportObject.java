/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.reports;

 
import com.jcl.utils.KeyValue;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author JLavador
 */
public class ReportObject {
    
    private String name;
    private String key; // it could payslip detail types
    private String reportTemplate;
    
    public ReportObject(String name, String reportTemplate,String key ){
        this.name = name;
        this.key = key;
        this.reportTemplate = reportTemplate;
    }
    
    public static List<ReportObject> getGovermentsContribution(){
        //SSS,PhilHealth,PagIbig, WTax, Adjustment, Loans, CashAdvanced,PagIbigLoans,SSSLoans,Others          
        //WorkedHours, VL_WP, VL_WOP, SL_WP, SL_WOP , Undertime, HL, HS, Absent ,OT_RD,OT_RSD,OT_LHRGD,OT_LHRTD,OT_SHRGD,OT_SHRTD,OT_RM,OT_RSM,OT_LHRGM,OT_LHRTM,OT_SHRGM,OT_SHRTM
        
        List<ReportObject> list = new ArrayList<ReportObject>();
        list.add(new ReportObject("SSS", "PayslipDetailList","SSS"));
        list.add(new ReportObject("PHIL-HEALTH", "PayslipDetailList","PhilHealth"));
        list.add(new ReportObject("WITH HOLDING TAX", "PayslipDetailList","WTax"));
        list.add(new ReportObject("PAG-IBIG", "PayslipDetailList","PagIbig"));
        list.add(new ReportObject("-----------------", "Separator","Separator"));
        list.add(new ReportObject("PAY SLIP LIST", "PayslipDetailList","All"));
        list.add(new ReportObject("Goverment Contribution", "PayslipDetailList","SSS,PhilHealth,PagIbig"));
        
        
        return list;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the reportTemplate
     */
    public String getReportTemplate() {
        return reportTemplate;
    }

    /**
     * @param reportTemplate the reportTemplate to set
     */
    public void setReportTemplate(String reportTemplate) {
        this.reportTemplate = reportTemplate;
    }
    
    public String toString(){
        return this.name;
    }
}
