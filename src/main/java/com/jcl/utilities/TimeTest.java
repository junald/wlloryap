/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.utilities;

import java.util.Calendar;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.DurationField;

/**
 *
 * @author junald
 */
public class TimeTest {

    public static void main(String[] args) {
        org.joda.time.DateTime dt = new DateTime();
        System.out.println(dt);
        System.out.println(dt.dayOfWeek());
        System.out.println(dt.getWeekOfWeekyear());
        System.out.println(dt.getDayOfWeek());
        System.out.println(dt.getDayOfMonth());
        int dd = dt.toGregorianCalendar().getFirstDayOfWeek();

//        System.out.println(dt.getChronology().weeks().getName());
//System.out.println(" ========");
//        Calendar c = Calendar.getInstance();
//int i = c.get(Calendar.DAY_OF_WEEK);
//System.out.println(i);
//c.add(Calendar.DAY_OF_MONTH, -(i-1));
//System.out.println(c.getTime());

        System.out.println(" ========");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));
        java.util.Date firstDayOfTheWeek = cal.getTime();
        System.out.println(firstDayOfTheWeek);
        cal.add(Calendar.DAY_OF_MONTH, 6);
        java.util.Date lastDayofTheWeek = cal.getTime();
        System.out.println(lastDayofTheWeek);
    }
}
