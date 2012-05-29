/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.utilities;

 
 
import com.jcl.dbms.dbms;

/**
 *
 * @author jlavador
 */
public class TrackingIdGenerator {

    private int accountId;
    private String className;
    private int counter;
    
    public TrackingIdGenerator(int acctid, String className ){
        this.accountId = acctid;
        this.className = className;
    }

    public TrackingIdGenerator(){
        
    }

    /*
     * Id format
     * year month-counter;
     * yymm-ccc;
     */
//    public static String generateNewCustomerId() {
//
//        TrackingIdGenerator ang = getTrackingIdGenerator();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyMM-");
//        NumberFormat nf = new DecimalFormat("0000");
//        Date d = new Date();
//
//
//        String yymm = sdf.format(d);
//
//        String id = yymm + nf.format(++ang.customerNumber);
//        dbms.getDBInstance().store(ang);
//        return id;
//    }

    /*
     * Id format     
     */
//    public static int generateEmployeeTid() {
//
//        TrackingIdGenerator ang = getTrackingIdGenerator();
//        int id = ++ang.employeeTid;
//        dbms.getDBInstance().store(ang);
//        return id;
//    }
//
//     public static int generateCustomerTid() {
//        TrackingIdGenerator ang = getTrackingIdGenerator();
//        int id = ++ang.customerTid;
//        dbms.getDBInstance().store(ang);
//        return id;
//    }


    public static int generatedNewTrackingId(String className) throws Exception{
        TrackingIdGenerator  tid = getTrackingIdGenerator(className);
        int newTid =  tid.getCounter();
        tid.setCounter(++newTid);
      //  dbms.getDBInstance().store(tid);
        return newTid;
    }


    public static TrackingIdGenerator getTrackingIdGenerator(String clName) throws Exception{

//        TrackingIdGenerator  tid = new TrackingIdGenerator(1,clName);
//        ObjectSet result = dbms.getDBInstance().queryByExample(tid);
//        TrackingIdGenerator ang = null;
//        if (result.hasNext()) {
//            ang = (TrackingIdGenerator) result.next();
//        } else {
//            ang = new TrackingIdGenerator(1,clName);
//        }
//        return ang;
        return null;
    }
//     public static TrackingIdGenerator getTrackingIdGenerator(String clName, ObjectContainer oc) throws Exception{
//
//        TrackingIdGenerator  tid = new TrackingIdGenerator(1,clName);
//        ObjectSet result = oc.queryByExample(tid);
//        TrackingIdGenerator ang = null;
//        if (result.hasNext()) {
//            ang = (TrackingIdGenerator) result.next();
//        } else {
//            ang = new TrackingIdGenerator(1,clName);
//        }
//        return ang;
//    }


    //DR - delivery - out
    //TR - trust receipt in
    //RT - return
    //NSTyymm0001
    //ATCyymm0001
    //DIRyymm0001


    /**
     * @return the accountId
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }




}
