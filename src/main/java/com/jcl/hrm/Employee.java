/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hrm;

 
//import com.jcl.dbms.dbms;
import com.jcl.payroll.dtr.DailyTimeRecord;
import com.jcl.payroll.enumtypes.PayrollPeriodType;
import com.jcl.payroll.transaction.PaySlip;
import com.jcl.payroll.transaction.PaySlipReportObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author junald
 */
public class Employee {

    //personal info
    private int tid = -1; //tracking id;
    private String idNumber;
    private transient String name;
    private String lastName = "";
    private String firstName = "";
    private String middleName;
    private Date dateOfBirth;
    private char gender;
    private String street = "";
    private String city ="";
    private String province="";
    private String country ="";
    private String telephoneNo;
    private String mobileNo;
    private String emailAdd;
    private String maritalStatus = "Single";  //   MaritalStatus.  Single,Married,Widowed
    private List<Dependents> dependents = new ArrayList<Dependents>();
    private String emergencyContactName; // name of the person
    private String emergencyContactNo;
    private String emergencyAddress;
    //company info
    private Position position;
    private Department department;
    private String branch;
    private String status = "Probationary"; // EmploymentStatus. Contractual,Regular,Resigned,Probationary,Terminated
    private String payType = "Variable";//Variable, Monthly, SemiMonthly, Weekly, Daily, PerHour
    private Boolean active = true;
    private Date dateHired;
    private Date dateEnd;
    private WorkShift workShift;
    //payroll info
    private String bankAccountNumber;
    private double allowance;
    private double salary;
    private double dailyRate;
    private double hourRate;
    private double minuteRate;
    //Goverment numbers
    private String taxID;
    private String sssNo;
    private String tinNo;
    private String pagibigNo;
    private String philhealthNo;
    private double taxWithheld;
    private double sssD;
    private double pagibigD;
    private double philhealthD;
    private double loan1;
    private double loan2;

    public transient ArrayList<DailyTimeRecord> dtrList;
    public transient PaySlipReportObject payslipReport;
    public transient PaySlip payslip;

    public Employee(String idNumber, String lastName, String firstName, String middleName, String status) {
        this.idNumber = idNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.status = status;
    }

    public Employee(String idNumber, String lastName, String firstName, String middleName, Position p) {
        this.idNumber = idNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.position = p;
    }

    public Employee(String idNumber) {
        this.idNumber = idNumber;
    }

    public Employee() {

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
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return lastName + ", " + firstName;

    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(char gender) {
        this.gender = gender;
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
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the dependents
     */
    public List<Dependents> getDependents() {
        return dependents;
    }

    /**
     * @param dependents the dependents to set
     */
    public void setDependents(List<Dependents> dependents) {
        this.dependents = dependents;
    }

    /**
     * @return the emergencyContactName
     */
    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    /**
     * @param emergencyContactName the emergencyContactName to set
     */
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    /**
     * @return the emergencyContactNo
     */
    public String getEmergencyContactNo() {
        return emergencyContactNo;
    }

    /**
     * @param emergencyContactNo the emergencyContactNo to set
     */
    public void setEmergencyContactNo(String emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
    }

    /**
     * @return the emergencyAddress
     */
    public String getEmergencyAddress() {
        return emergencyAddress;
    }

    /**
     * @param emergencyAddress the emergencyAddress to set
     */
    public void setEmergencyAddress(String emergencyAddress) {
        this.emergencyAddress = emergencyAddress;
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the dateHired
     */
    public Date getDateHired() {
        return dateHired;
    }

    /**
     * @param dateHired the dateHired to set
     */
    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    /**
     * @return the dateEnd
     */
    public Date getDateEnd() {
        return dateEnd;
    }

    /**
     * @param dateEnd the dateEnd to set
     */
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * @return the workShift
     */
    public WorkShift getWorkShift() {
        return workShift;
    }

    /**
     * @param workShift the workShift to set
     */
    public void setWorkShift(WorkShift workShift) {
        this.workShift = workShift;
    }

    /**
     * @return the bankAccountNumber
     */
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * @param bankAccountNumber the bankAccountNumber to set
     */
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    /**
     * @return the allowance
     */
    public double getAllowance() {
        return allowance;
    }

    /**
     * @param allowance the allowance to set
     */
    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return the dailyRate
     */
    public double getDailyRate() {
        return dailyRate;
    }

    /**
     * @param dailyRate the dailyRate to set
     */
    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    /**
     * @return the hourRate
     */
    public double getHourRate() {
        return hourRate;
    }

    /**
     * @param hourRate the hourRate to set
     */
    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    /**
     * @return the minuteRate
     */
    public double getMinuteRate() {
        return minuteRate;
    }

    /**
     * @param minuteRate the minuteRate to set
     */
    public void setMinuteRate(double minuteRate) {
        this.minuteRate = minuteRate;
    }

    /**
     * @return the taxID
     */
    public String getTaxID() {
        return taxID;
    }

    /**
     * @param taxID the taxID to set
     */
    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    /**
     * @return the sssNo
     */
    public String getSssNo() {
        return sssNo;
    }

    /**
     * @param sssNo the sssNo to set
     */
    public void setSssNo(String sssNo) {
        this.sssNo = sssNo;
    }

    /**
     * @return the tinNo
     */
    public String getTinNo() {
        return tinNo;
    }

    /**
     * @param tinNo the tinNo to set
     */
    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    /**
     * @return the pagibigNo
     */
    public String getPagibigNo() {
        return pagibigNo;
    }

    /**
     * @param pagibigNo the pagibigNo to set
     */
    public void setPagibigNo(String pagibigNo) {
        this.pagibigNo = pagibigNo;
    }

    /**
     * @return the philhealthNo
     */
    public String getPhilhealthNo() {
        return philhealthNo;
    }

    /**
     * @param philhealthNo the philhealthNo to set
     */
    public void setPhilhealthNo(String philhealthNo) {
        this.philhealthNo = philhealthNo;
    }

    /**
     * @return the taxWithheld
     */
    public double getTaxWithheld() {
        return taxWithheld;
    }

    /**
     * @param taxWithheld the taxWithheld to set
     */
    public void setTaxWithheld(double taxWithheld) {
        this.taxWithheld = taxWithheld;
    }

    /**
     * @return the sssD
     */
    public double getSssD() {
        return sssD;
    }

    /**
     * @param sssD the sssD to set
     */
    public void setSssD(double sssD) {
        this.sssD = sssD;
    }

    /**
     * @return the pagibigD
     */
    public double getPagibigD() {
        return pagibigD;
    }

    /**
     * @param pagibigD the pagibigD to set
     */
    public void setPagibigD(double pagibigD) {
        this.pagibigD = pagibigD;
    }

    /**
     * @return the philhealthD
     */
    public double getPhilhealthD() {
        return philhealthD;
    }

    /**
     * @param philhealthD the philhealthD to set
     */
    public void setPhilhealthD(double philhealthD) {
        this.philhealthD = philhealthD;
    }

    /**
     * @return the loan1
     */
    public double getLoan1() {
        return loan1;
    }

    /**
     * @param loan1 the loan1 to set
     */
    public void setLoan1(double loan1) {
        this.loan1 = loan1;
    }

    /**
     * @return the loan2
     */
    public double getLoan2() {
        return loan2;
    }

    /**
     * @param loan2 the loan2 to set
     */
    public void setLoan2(double loan2) {
        this.loan2 = loan2;
    }

    /**
     * @return the id
     */
    public long getId() throws Exception {

        //return dbms.getDBInstance().ext().getID(this);
        return 1;
    }


     public String completeAddress1() {

        String add = getStreet()==null?"":street + ", " + getCity()==null?"":city;

        return add;
    }
     public String completeAddress2() {
        String add =  getProvince()==null?"":province + " " + getMobileNo()==null?"":mobileNo   ;

        return add;
    }


    ///Employee
    public static Employee getEmployee(String employeeId) throws Exception {
        Employee emp = null;
//        Query query = dbms.getDBInstance().query();
//        query.constrain(Employee.class);
//        query.descend("idNumber").constrain(employeeId);
//
//        ObjectSet result = query.execute();
//        if (result.hasNext()) {
//            emp = (Employee) result.next();
//        }
        return emp;

    }

      public static Employee getEmployeeByTid(int key) throws Exception {
        Employee emp = null;
//        Query query = dbms.getDBInstance().query();
//        query.constrain(Employee.class);
//        query.descend("tid").constrain(key);
//
//        ObjectSet result = query.execute();
//        if (result.hasNext()) {
//            emp = (Employee) result.next();
//        }
        return emp;
    }

    public static List<Employee> getSortedEmployees() throws Exception {
//        Query query = dbms.getDBInstance().query();
//        query.constrain(Employee.class);
//        query.descend("position").descend("description").orderDescending();
//
//        List<Employee> result = query.execute();
//
//        LinkedList<Employee> list = new LinkedList<Employee>(result);
//
//        return result;
        return null;
    }

     public static List<Employee> getSortedEmployees(Position pos) throws Exception {
//        Query query = dbms.getDBInstance().query();
//        query.constrain(Employee.class);
//        query.descend("position").constrain(pos);
//       // query.descend("position").orderDescending();
//
//        List<Employee> result = query.execute();
//
//        return result;
         return null;
    }

      public static List<Employee> getEmployees(PayrollPeriodType ppt) throws Exception {
//        Query query = dbms.getDBInstance().query();
//        query.constrain(Employee.class);
//        query.descend("payType").constrain(ppt.name());
//
//        List<Employee> result = query.execute();
//
//        return result;
          return null;
    }

    public static List<Employee> getEmployeesForDelivery() throws Exception {
//        Query query = dbms.getDBInstance().query();
//        query.constrain(Employee.class);
//        Constraint constraint1 = query.descend("position").descend("tid").constrain(1);
//        Constraint constraint2 = query.descend("position").descend("tid").constrain(2).or(constraint1);
//        query.descend("position").descend("tid").constrain(3).or(constraint2);
//
//        List<Employee> result = query.execute();
//
//        return result;
        return null;
    }

    @Override
    public String toString() {
        return lastName +", " + firstName;
        //return "Employee{id= " + getId() + " tid=" + tid + "idNumber=" + idNumber + "name=" + name + "dateOfBirth=" + dateOfBirth + "emergencyContactName=" + emergencyContactName + "position=" + position + '}';
    }

    /**
     * @return the payType
     */
    public String getPayType() {
        return payType;
    }

    /**
     * @param payType the payType to set
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

     
}
