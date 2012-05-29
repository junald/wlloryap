/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hrm;

//import com.jcl.dbms.dbms;
import java.util.Date;

/**
 *
 * @author junald
 */
public class Dependents {

    private Employee dependentsEmployee;
    private String relationship = "Spouse"; //FamilyRelationship. Wife,Husband,Father,Mother,Brother,Sister,Son,Daughter,Spouse,Others
    private transient String name;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date dateOfBirth;
    private char gender;

    public Dependents() {
    }

    public Dependents(String lastName, String firstName, String middleName, Date dateOfBirth, char gender, String relationship) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return getName();
    }

    /**
     * @return the relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * @param relationship the relationship to set
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.lastName + ", " + this.firstName;
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
     * @return the id
     */
    public long getId() throws Exception {
//        return dbms.getDBInstance().ext().getID(this);
        return 1;
    }

    /**
     * @return the dependentsEmployee
     */
    public Employee getDependentsEmployee() {
        return dependentsEmployee;
    }

    /**
     * @param dependentsEmployee the dependentsEmployee to set
     */
    public void setDependentsEmployee(Employee dependentsEmployee) {
        this.dependentsEmployee = dependentsEmployee;
    }
}
