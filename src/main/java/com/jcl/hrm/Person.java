/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hrm;

import java.util.Date;

/**
 *
 * @author junald
 */
public class Person {

    private transient String name;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date dateOfBirth;
    private char gender; //M,F

    public Person(String lastName, String firstName, String middleName, Date dateOfBirth, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" + "lastName=" + lastName + "firstName=" + firstName + "middleName=" + middleName + "dateOfBirth=" + dateOfBirth + "gender=" + gender + '}';
    }

    public Person() {
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
     * @return the name
     */
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
