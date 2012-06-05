/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.utilities;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.Interval;
import org.joda.time.JodaTimePermission;
import com.jcl.model.DailyTimeRecord;
import com.jcl.payroll.enumtypes.DTRType;

/**
 *
 * @author jlavador
 */
public class MyDateFormatter {

    /**
     * format: yyyyMMdd
     */
    public static SimpleDateFormat getDateKeyFormatter() {
        return new SimpleDateFormat("yyyyMMdd");
    }

    /**
     * format: yyyy-MM-dd
     */
    public static SimpleDateFormat getDateDataFormatter() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * format: yyMM
     */
    public static SimpleDateFormat getYearDateKeyFormatter() {
        return new SimpleDateFormat("yyMM");
    }

    /**
     * format: yyyy-MM-dd hh:ss:mm a
     */
    public static SimpleDateFormat getDateTimeFormatter() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
    }

      /**
     * format: h:mm
     */
    public static SimpleDateFormat getTimeFormatter() {
        return new SimpleDateFormat("h:mm");
    }

    public static SimpleDateFormat getTimeFormatter2() {
        return new SimpleDateFormat("h:mm a");
    }

    /**
     * format: MM/dd/yyyy
     */
    public static SimpleDateFormat getSimpleDateTimeFormatter() {
        return new SimpleDateFormat("MM/dd/yyyy");
    }

    /**
     * format: MM/dd/yy
     */
    public static SimpleDateFormat getSimpleDateTimeFormatter2() {
        return new SimpleDateFormat("MM/dd/yy");
    }

    public static String getStartAndEndDateOfADate(Date datef) {
        SimpleDateFormat sdfS = new SimpleDateFormat("MM/dd/yy");
        SimpleDateFormat sdf2 = MyDateFormatter.getSimpleDateTimeFormatter();
        String dates = "";
        try {

            String mdate = sdf2.format(datef);
            Date date = sdf2.parse(mdate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));
            java.util.Date firstDayOfTheWeek = cal.getTime();
            //System.out.println(firstDayOfTheWeek);
            dates = sdfS.format(firstDayOfTheWeek);
            cal.add(Calendar.DAY_OF_MONTH, 6);
            java.util.Date lastDayofTheWeek = cal.getTime();
            dates = dates + "-" + sdfS.format(lastDayofTheWeek);
            //System.out.println(lastDayofTheWeek);

        } catch (ParseException ex) {
            Logger.getLogger(MyDateFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dates;
    }

    public static java.util.Date getStartDateofWeekOfADate(Date datef) {
        SimpleDateFormat sdfS = new SimpleDateFormat("MM/dd/yy");
        SimpleDateFormat sdf2 = MyDateFormatter.getSimpleDateTimeFormatter();
        java.util.Date dates = null;
        try {

            String mdate = sdf2.format(datef);
            Date date = sdf2.parse(mdate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));

            dates = cal.getTime();
        } catch (ParseException ex) {
            Logger.getLogger(MyDateFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dates;
    }

    public static Time transformTime(String t, String ampm){
        Time time = null;

        return time;
    }

//    public static int getNumberOfHours(DailyTimeRecord dtr){
//        int hours;
//        System.out.println(dtr.getTimeIn1() + " : " + dtr.getTimeOut1());
//        System.out.println(dtr.getTimeIn2() + " : " + dtr.getTimeOut2());
//        Interval morning = new Interval(dtr.getTimeIn1().getTime(), dtr.getTimeOut1().getTime());
//        Interval afternoon = new Interval(dtr.getTimeIn2().getTime(), dtr.getTimeOut2().getTime());
//        hours = morning.toPeriod().getHours() + afternoon.toPeriod().getHours() ;
//        System.out.println(morning.toPeriod().getHours()  + " : " +afternoon.toPeriod().getHours() );
//
//        return hours;
//    }
}
