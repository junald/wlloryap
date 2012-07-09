package com.jcl.wrollyap.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    
    static ApplicationContext context;
    static JFrame jf;
      
    public static void main( String[] args )
    {         
         context =   new ClassPathXmlApplicationContext("/applicationContext.xml");
         jf = new JFrame();         
         employeeReport();         
    }
    
    public static void employeeReport(){
         jf.setTitle("EmployeeReport");
         jf.setExtendedState(JFrame.MAXIMIZED_BOTH);     
         com.jcl.reports.EmployeeReport er =  context.getBean(com.jcl.reports.EmployeeReport .class);
         er.setup();
         jf.getContentPane().add(er);
         jf.setVisible(true);
    }
}
