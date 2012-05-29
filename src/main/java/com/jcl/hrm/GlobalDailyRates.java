/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.hrm;


import com.jcl.dbms.dbms;

/**
 *
 * @author junald
 */
public class GlobalDailyRates {

    public transient static String EMPLOYEE= "employee";
    public transient static String CHARGES="charges";

    private int tid =-1;
    private String type;
    private String description;
    private double rates;

    public GlobalDailyRates(){
        
    }

    public GlobalDailyRates(String type, String description, double rates) {
        this.type = type;
        this.description = description;
        this.rates = rates;
    }

    public GlobalDailyRates(int id, String type, String description, double rates) {
        this.tid = id;
        this.type = type;
        this.description = description;
        this.rates = rates;
    }

    /**
     * @return the tid
     */
    public int getTid() {
        return tid;
    }

    /**
     * @param tid the tid to set
     */
    public void setTid(int tid) {
        this.tid = tid;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the rates
     */
    public double getRates() {
        return rates;
    }

    /**
     * @param rates the rates to set
     */
    public void setRates(double rates) {
        this.rates = rates;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

     public static GlobalDailyRates getGlobalDailyRatesByName(String pCode) throws Exception {
        GlobalDailyRates p = null;
//        Query query = dbms.getDBInstance().query();
//        query.constrain(GlobalDailyRates.class);
//        query.descend("description").constrain(pCode);
//
//        ObjectSet result = query.execute();
//        if (result.hasNext()) {
//            p = (GlobalDailyRates) result.next();
//        }
        return p;
    }
}
