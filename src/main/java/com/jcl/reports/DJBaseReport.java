/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.reports;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.core.layout.LayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.util.SortUtils;
import com.jcl.utils.ObjectDataSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author junald
 */
public abstract class DJBaseReport {

    protected JasperPrint jp;
    protected JasperReport jr;
    protected Map params = new HashMap();
    protected DynamicReport dr;
    protected List dataList;

    public DJBaseReport(List list) {
        this.dataList = list;
    }

    public abstract DynamicReport buildReport() throws Exception;

    public void createReport() throws Exception {
        dr = buildReport();
        ObjectDataSource ds = getObjectDataSource();
        jr = DynamicJasperHelper.generateJasperReport(dr, getLayoutManager(), params);
        if (ds != null) {
            jp = JasperFillManager.fillReport(jr, params, ds);
        } else {
            jp = JasperFillManager.fillReport(jr, params);
        }
 

    }

    protected LayoutManager getLayoutManager() {
        return new ClassicLayoutManager();
    }

    protected void exportToJRXML() throws Exception {
        if (this.jr != null) {
            DynamicJasperHelper.generateJRXML(this.jr, "UTF-8", System.getProperty("user.dir") + "/target/reports/" + this.getClass().getName() + ".jrxml");

        } else {
            DynamicJasperHelper.generateJRXML(this.dr, this.getLayoutManager(), this.params, "UTF-8", System.getProperty("user.dir") + "/target/reports/" + this.getClass().getName() + ".jrxml");
        }
    }

    protected ObjectDataSource getObjectDataSource() {

        ObjectDataSource ods = new ObjectDataSource(dataList, true);

        return ods;
    }

    public JasperPrint getJasperReport() {
        return jp;

    }

    public DynamicReport getDynamicReport() {
        return dr;
    }
}
