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

    private String companyName ;
   
     
    private boolean autoComputeHoliday;
    private boolean autoComputeOvertime;
    private boolean autoComputeIncomeTax;
    private boolean autoComputeSSS;
    private boolean autoComputePagIbig;
    private boolean autoComputePhilHealth;
    private String street;
    private String city;
    private String province;
    private String country;
    private String telephoneNo;
    private String mobileNo;
    private String emailAdd;
    private String zipcode;

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
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
     * @return the mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo the mobileNo to set
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * @return the emailAdd
     */
    public String getEmailAdd() {
        return emailAdd;
    }

    /**
     * @param emailAdd the emailAdd to set
     */
    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
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

    public String completeAddress() {
        String add = getStreet() + ", " + getCity() + ",\n" + getZipcode() + " " + getProvince() + " PH";

        return add;
    }
}
