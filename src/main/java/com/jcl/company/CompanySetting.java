/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.company;
 

//import com.jcl.dbms.dbms;

/**
 *
 * @author junald
 */
public class CompanySetting {

    private Long id;
    private String name ;        
    private boolean autoComputeHoliday;
    private boolean autoComputeOvertime;
    private boolean autoComputeIncomeTax;
    private boolean autoComputeSSS;
    private boolean autoComputePagIbig;
    private boolean autoComputePhilHealth;
    private String address;    
    private String telephoneNo;  
    private String zipcode;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the autoComputeHoliday
     */
    public boolean isAutoComputeHoliday() {
        return autoComputeHoliday;
    }

    /**
     * @param autoComputeHoliday the autoComputeHoliday to set
     */
    public void setAutoComputeHoliday(boolean autoComputeHoliday) {
        this.autoComputeHoliday = autoComputeHoliday;
    }

    /**
     * @return the autoComputeOvertime
     */
    public boolean isAutoComputeOvertime() {
        return autoComputeOvertime;
    }

    /**
     * @param autoComputeOvertime the autoComputeOvertime to set
     */
    public void setAutoComputeOvertime(boolean autoComputeOvertime) {
        this.autoComputeOvertime = autoComputeOvertime;
    }

    /**
     * @return the autoComputeIncomeTax
     */
    public boolean isAutoComputeIncomeTax() {
        return autoComputeIncomeTax;
    }

    /**
     * @param autoComputeIncomeTax the autoComputeIncomeTax to set
     */
    public void setAutoComputeIncomeTax(boolean autoComputeIncomeTax) {
        this.autoComputeIncomeTax = autoComputeIncomeTax;
    }

    /**
     * @return the autoComputeSSS
     */
    public boolean isAutoComputeSSS() {
        return autoComputeSSS;
    }

    /**
     * @param autoComputeSSS the autoComputeSSS to set
     */
    public void setAutoComputeSSS(boolean autoComputeSSS) {
        this.autoComputeSSS = autoComputeSSS;
    }

    /**
     * @return the autoComputePagIbig
     */
    public boolean isAutoComputePagIbig() {
        return autoComputePagIbig;
    }

    /**
     * @param autoComputePagIbig the autoComputePagIbig to set
     */
    public void setAutoComputePagIbig(boolean autoComputePagIbig) {
        this.autoComputePagIbig = autoComputePagIbig;
    }

    /**
     * @return the autoComputePhilHealth
     */
    public boolean isAutoComputePhilHealth() {
        return autoComputePhilHealth;
    }

    /**
     * @param autoComputePhilHealth the autoComputePhilHealth to set
     */
    public void setAutoComputePhilHealth(boolean autoComputePhilHealth) {
        this.autoComputePhilHealth = autoComputePhilHealth;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the telephoneNo
     */
    public String getTelephoneNo() {
        return telephoneNo;
    }

    /**
     * @param telephoneNo the telephoneNo to set
     */
    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    
    public static CompanySetting companySetting() throws Exception {

        CompanySetting cs = null;
//        ObjectSet result = dbms.getDBInstance().query(CompanySetting.class);
//        if (result.hasNext()) {
//            cs = (CompanySetting) result.next();
//        } else {
//            cs = new CompanySetting();
//        }
        return cs;
    }

    public void save() throws Exception {

//        try {
//            dbms.getDBInstance().store(this);
//            dbms.getDBInstance().commit();
//            dbms.getDBInstance().ext().refresh(this, Integer.MAX_VALUE);
//        } catch (Exception ex) {
//            dbms.getDBInstance().rollback();
//
//        }
    }

   
}
