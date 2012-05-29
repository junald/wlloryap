/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.reports;

import java.util.List;
import java.util.Map;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author junald
 */
public class ReportGenerator implements IReportViewer{

    @Override
    public JRViewer createReport(String filename, Map parameters, List list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
