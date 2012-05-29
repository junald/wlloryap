/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.verycommon;

import java.util.logging.Level;
import com.jcl.verycommon.MLogger;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author jlavador
 */
public class JOptionErrorMessage {

    public static void showErrorMessage(String className, Exception ex) {
        MLogger.logged(Level.ALL, className, ex);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, sw.toString());
    }

    public static void showErrorMessage(String canonicalName, String simpleMessage) {
           JOptionPane.showMessageDialog(null,simpleMessage);
    }
}
