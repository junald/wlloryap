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
    private Long id;
    private String idNumber;
    private transient String name;
    private String lastName = "";
    private String firstName = "";
    private String middleName;
    private Date dateOfBirth;
    private char gender;
    private String address ="";
    
    private String telephoneNo;
    private String mobileNo;
    
    private String maritalStatus = "Single";  //   MaritalStatus.  Single,Married,Widowed
    private Integer numberOfDependents;
    
    //company info
    private Position position;
    private Department department;
    private Company company;    
    private Branch branch;
    private String status = "Probationary"; // EmploymentStatus. Contractual,Regular,Resigned,Probationary,Terminated
    private String payType = "SemiMonthly";//Variable, Monthly, SemiMonthly, Weekly, Daily, PerHour
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

    private transient ArrayList<DailyTimeRecord> dtrList;
    private transient PaySlipReportObject payslipReport;
    private transient PaySlip payslip;

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
        return name;
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
     * @return the numberOfDependents
     */
    public Integer getNumberOfDependents() {
        return numberOfDependents;
    }

    /**
     * @param numberOfDependents the numberOfDependents to set
     */
    public void setNumberOfDependents(Integer numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
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
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return the branch
     */
    public Branch getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(Branch branch) {
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
     * @return the dtrList
     */
    public ArrayList<DailyTimeRecord> getDtrList() {
        return dtrList;
    }

    /**
     * @param dtrList the dtrList to set
     */
    public void setDtrList(ArrayList<DailyTimeRecord> dtrList) {
        this.dtrList = dtrList;
    }

    /**
     * @return the payslipReport
     */
    public PaySlipReportObject getPayslipReport() {
        return payslipReport;
    }

    /**
     * @param payslipReport the payslipReport to set
     */
    public void setPayslipReport(PaySlipReportObject payslipReport) {
        this.payslipReport = payslipReport;
    }

    /**
     * @return the payslip
     */
    public PaySlip getPayslip() {
        return payslip;
    }

    /**
     * @param payslip the payslip to set
     */
    public void setPayslip(PaySlip payslip) {
        this.payslip = payslip;
    }

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

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

      public static Employee getEmployeeByTid(Long key) throws Exception {
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
        return getLastName() +", " + getFirstName();
        //return "Employee{id= " + getId() + " tid=" + tid + "idNumber=" + idNumber + "name=" + name + "dateOfBirth=" + dateOfBirth + "emergencyContactName=" + emergencyContactName + "position=" + position + '}';
    }

 

     
}
