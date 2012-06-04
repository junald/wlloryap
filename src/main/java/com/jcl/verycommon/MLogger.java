/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.verycommon;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author junald
 */
public class MLogger {

    public static final Logger logger = Logger.getLogger("MainApplication");
    static FileHandler fh;

    public static void init() {


         try {
                // This block configure the logger with handler and formatter
                Date n = new Date();
                SimpleDateFormat  sdf = new SimpleDateFormat("yyyyMM");
                //String flogfilename = sdf.format(n) +".log";
                String flogfilename = "test062012.log";
                fh = new FileHandler(flogfilename, true);
                logger.addHandler(fh);
                logger.setLevel(Level.ALL);

                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);

                 
                logger.log(Level.WARNING, "Application started: {0}", n);
            } catch (SecurityException ex) {
                Logger.getLogger(MLogger.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MLogger.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void logged(Level level, String className, Throwable ex){
     
       // logger.log(level, className, ex);
         //logger.logp(level , className,sourceMethod,ex.getMessage());
    }
}
