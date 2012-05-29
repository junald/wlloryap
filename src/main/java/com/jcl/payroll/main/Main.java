/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.payroll.main;

import com.jcl.interfaces.ModuleApps;
import com.jcl.interfaces.PanelInterface;
import java.util.LinkedList;

/**
 *
 * @author jlavador
 */
public class Main implements PanelInterface{

    private String title = "Payroll";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public LinkedList<ModuleApps> getModuleList(String name) {
        LinkedList<ModuleApps> list = new LinkedList<ModuleApps> ();
        ModuleApps m = new ModuleApps();
        m.setName("Employee Info");
        m.setClassName("com.jcl.payroll.ui.EmployeeInformation");
        m.setActivate(true);
        m.setModuleId("3001");
        m.setDescription("Employee Information");
        list.add(m);
        ModuleApps m1 = new ModuleApps();
        m1.setName("DTR");
        m1.setClassName("com.jcl.payroll.ui.DTR");
        m1.setActivate(true);
        m1.setModuleId("3002");
        m1.setDescription("Employee DTR");
        list.add(m1);
        ModuleApps m2 = new ModuleApps();
        m2.setName("separator");
        m2.setClassName("com.jcl.payroll.ui.separator");
        m2.setActivate(true);
        m2.setModuleId("0000");
        m2.setDescription("separator");
        list.add(m2);
        ModuleApps m3 = new ModuleApps();
        m3.setName("PaySlip");
        m3.setClassName("com.jcl.payroll.ui.PaySlip");
        m3.setActivate(true);
        m3.setModuleId("3003");
        m3.setDescription("PaySlip");
        list.add(m3);
 
//        ll.add("com.jcl.payroll.ui.PaySlip");
//        ll.add("com.jcl.payroll.ui.PayDetail");
//        ll.add("com.jcl.payroll.ui.PayrollPeriod");
//        ll.add("com.jcl.payroll.ui.DTR");

        return list;
    }

    @Override
    public String getModulePanel(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getTitle(){
        return this.title;
    }

}
