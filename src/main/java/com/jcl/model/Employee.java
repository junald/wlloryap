/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.model;

//import com.jcl.dbms.dbms;
import com.jcl.payroll.enumtypes.PayrollPeriodType;
import com.jcl.payroll.transaction.PaySlipReportObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author junald
 */
@Entity
public class Employee {

    //personal info
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 15, unique = true, nullable = false)
    private String idNumber;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50)
    private String middleName;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;
    @Column(length = 1)
    private String gender = "M";
    @Column(length = 150)
    private String address;
    @Column(length = 15)
    private String telephoneNo;
    @Column(length = 15)
    private String mobileNo;
    @Column(length = 15)
    private String maritalStatus = "Single";  //   MaritalStatus.  Single,Married,Widowed
    @Column
    private Integer numberOfDependents;
    //company info
    @OneToOne
    private Position position;
    @OneToOne
    private Department department;
    @OneToOne
    private Company company;
    @OneToOne
    private Branch branch;
    @Column
    private String status = "Regular"; // EmploymentStatus. Contractual,Regular,Resigned,Probationary,Terminated
    @Column
    private String payCode = "Monthly";//Monthly, Daily
    @Column
    private String payType = "SemiMonthly";//  Monthly, SemiMonthly, Weekly, Daily, 
    @Column
    @Temporal(TemporalType.DATE)
    private Date dateHired;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    //payroll info
    @Column(length = 15)
    private String bankAccountNumber;
    @Column
    private Double allowance =0d;
    @Column
    private Double salary=0d;
    @Column
    private Double dailyRate=0d;
    @Column
    private Double hourRate=0d;
    @Column
    private Double minuteRate=0d;
    @Column
    private Double benefits=0d;
    
    //Goverment numbers
    @Column
    private String taxID;
    @Column
    private String sssNo;
    @Column
    private String tinNo;
    @Column
    private String pagibigNo;
    @Column
    private String philhealthNo;
    @Column
    private Double taxWithheld=0d;
    @Column
    private Double sssD=0d;
    @Column
    private Double pagibigD=0d;
    @Column
    private Double philhealthD=0d;
    @Column
    private Boolean active = true;
    @Column
    private Boolean sss = true;
    @Column
    private Boolean pagibig = true;
    @Column
    private Boolean philhealth = true;
    @Column
    private Boolean tax = true;
    @Column
    private Integer sickLeave=0;
    @Column
    private Integer vacationLeave=0;
    
    private transient String name;
    private transient ArrayList<DailyTimeRecord> dtrList;
    private transient PaySlipReportObject payslipReport;
    private transient PaySlip payslip;

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

    @Override
    public String toString() {
        return getLastName() + ", " + getFirstName();
        //return "Employee{id= " + getId() + " tid=" + tid + "idNumber=" + idNumber + "name=" + name + "dateOfBirth=" + dateOfBirth + "emergencyContactName=" + emergencyContactName + "position=" + position + '}';
    }

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
        return lastName + ", " + firstName + " " + middleName;
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
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
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
     * @return the payCode
     */
    public String getPayCode() {
        return payCode;
    }

    /**
     * @param payCode the payCode to set
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode;
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
    public Double getAllowance() {
        return allowance;
    }

    /**
     * @param allowance the allowance to set
     */
    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    /**
     * @return the salary
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * @return the dailyRate
     */
    public Double getDailyRate() {
        return dailyRate;
    }

    /**
     * @param dailyRate the dailyRate to set
     */
    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }

    /**
     * @return the hourRate
     */
    public Double getHourRate() {
        return hourRate;
    }

    /**
     * @param hourRate the hourRate to set
     */
    public void setHourRate(Double hourRate) {
        this.hourRate = hourRate;
    }

    /**
     * @return the minuteRate
     */
    public Double getMinuteRate() {
        return minuteRate;
    }

    /**
     * @param minuteRate the minuteRate to set
     */
    public void setMinuteRate(Double minuteRate) {
        this.minuteRate = minuteRate;
    }

    /**
     * @return the benefits
     */
    public Double getBenefits() {
        return benefits;
    }

    /**
     * @param benefits the benefits to set
     */
    public void setBenefits(Double benefits) {
        this.benefits = benefits;
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
    public Double getTaxWithheld() {
        return taxWithheld;
    }

    /**
     * @param taxWithheld the taxWithheld to set
     */
    public void setTaxWithheld(Double taxWithheld) {
        this.taxWithheld = taxWithheld;
    }

    /**
     * @return the sssD
     */
    public Double getSssD() {
        return sssD;
    }

    /**
     * @param sssD the sssD to set
     */
    public void setSssD(Double sssD) {
        this.sssD = sssD;
    }

    /**
     * @return the pagibigD
     */
    public Double getPagibigD() {
        return pagibigD;
    }

    /**
     * @param pagibigD the pagibigD to set
     */
    public void setPagibigD(Double pagibigD) {
        this.pagibigD = pagibigD;
    }

    /**
     * @return the philhealthD
     */
    public Double getPhilhealthD() {
        return philhealthD;
    }

    /**
     * @param philhealthD the philhealthD to set
     */
    public void setPhilhealthD(Double philhealthD) {
        this.philhealthD = philhealthD;
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

    /**
     * @return the sss
     */
    public Boolean getSss() {
        return sss;
    }

    /**
     * @param sss the sss to set
     */
    public void setSss(Boolean sss) {
        this.sss = sss;
    }

    /**
     * @return the pagibig
     */
    public Boolean getPagibig() {
        return pagibig;
    }

    /**
     * @param pagibig the pagibig to set
     */
    public void setPagibig(Boolean pagibig) {
        this.pagibig = pagibig;
    }

    /**
     * @return the philhealth
     */
    public Boolean getPhilhealth() {
        return philhealth;
    }

    /**
     * @param philhealth the philhealth to set
     */
    public void setPhilhealth(Boolean philhealth) {
        this.philhealth = philhealth;
    }

    /**
     * @return the tax
     */
    public Boolean getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(Boolean tax) {
        this.tax = tax;
    }

    /**
     * @return the sickLeave
     */
    public Integer getSickLeave() {
        return sickLeave;
    }

    /**
     * @param sickLeave the sickLeave to set
     */
    public void setSickLeave(Integer sickLeave) {
        this.sickLeave = sickLeave;
    }

    /**
     * @return the vacationLeave
     */
    public Integer getVacationLeave() {
        return vacationLeave;
    }

    /**
     * @param vacationLeave the vacationLeave to set
     */
    public void setVacationLeave(Integer vacationLeave) {
        this.vacationLeave = vacationLeave;
    }
}
