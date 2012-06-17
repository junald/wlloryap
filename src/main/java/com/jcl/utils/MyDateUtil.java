/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.utils;

import java.util.Date;
import org.joda.time.*;
import org.modeshape.graph.property.basic.JodaDateTime;

/**
 *
 * @author junald
 */
public class MyDateUtil {
    
    public static Boolean isSunday(Date today){
        boolean isSunday=false;
        DateTime dt = new DateTime(today);
        System.out.println(dt.getDayOfWeek() + " : " + dt.getDayOfMonth() +":"+ dt.getDayOfYear());
        if(dt.getDayOfWeek() == 7){
            isSunday = true;
        }
        
        return isSunday;
    }
    
    public static String timeDifferent(DateTime timeIn, DateTime timeOut){
        Interval interval = new Interval(timeIn, timeOut);
        Period period = interval.toPeriod();
        String hrs =period.getHours()+":"+period.getMinutes();
        System.out.println("hrs:" + hrs);
        return hrs;
    }
    
    public static Integer timeSection(DateTime timeIn, DateTime timeOut){
        Integer section = 1;
        System.out.println("----------------------");
        DateTime date10pm = new DateTime(timeIn.getYear(), 
                        timeIn.getMonthOfYear(), 
                        timeIn.getDayOfMonth(), 21,0, 0);
        
        System.out.println(date10pm);
        DateTime date6am = new DateTime(timeOut.getYear(), 
                        timeOut.getMonthOfYear(), 
                        timeOut.getDayOfMonth() , 7,0, 0);
        System.out.println(date6am);
        DateTime date6pm = new DateTime(timeIn.getYear(), 
                        timeIn.getMonthOfYear(), 
                        timeIn.getDayOfMonth(), 18,0, 0);
        System.out.println(date6pm);
        
        
        if( timeIn.isAfter( date10pm.getMillis()) && timeOut.isBefore(date6am.getMillis())){
            section = 3;
            
        }else if(timeOut.isBefore(date10pm.getMillis()) && timeOut.isAfter(date6pm)){
            section = 2;
        }
        System.out.println("section: " + section);
        System.out.println("----------------------");
        return section;
    }
    
    public static void main(String[] args){
        isSunday(new Date());
    }
}
