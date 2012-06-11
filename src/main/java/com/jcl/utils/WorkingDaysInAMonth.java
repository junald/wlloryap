/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.utils;
import org.joda.time.LocalDate;
import java.util.Iterator;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

/**
 *
 * @author JLavador
 */
 


public class WorkingDaysInAMonth implements Iterator<LocalDate>{
    private final LocalDate end;
    private LocalDate nextDate;

    public WorkingDaysInAMonth(LocalDate start, LocalDate end, int dayOfWeekToIterate){
        this.end = end;
        nextDate = start.withDayOfWeek(dayOfWeekToIterate);
        if (start.getDayOfWeek() > dayOfWeekToIterate) {
            nextDate = nextDate.plusWeeks(1);
        }
    }

    public boolean hasNext() {
        return !nextDate.isAfter(end);
    }

    public LocalDate next() {
        LocalDate result = nextDate;
        nextDate = nextDate.plusWeeks(1);
        return result;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
    
   

//    public static void main(String[] args) {
//
//        LocalDate startDate = new LocalDate(2012, 6, 1);//1st Dec 2010
//        LocalDate endDate = new LocalDate(2012, 6, 30);//31st Dec 2010
//        WorkingDaysInAMonth it = new WorkingDaysInAMonth(startDate, endDate, DateTimeConstants.FRIDAY);
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//
//    }
    
     public static void main(String[] args) {

        DateTime startDt = new DateTime(2012,6,1,0,0,0,0);//1st Dec 2010
        DateTime endDt = new DateTime(2012,6,30,0,0,0,0);//31st Dec 2010
        DateTime tempDate = new DateTime(startDt.getMillis());
        while(tempDate.compareTo(endDt) <=0 ){
            if(tempDate.getDayOfWeek() !=  DateTimeConstants.SATURDAY && tempDate.getDayOfWeek() !=  DateTimeConstants.SUNDAY){
                System.out.println(""+tempDate);
            }
            tempDate = tempDate.plusDays(1);

        }


    }

 

 }
