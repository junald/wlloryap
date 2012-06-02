/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.model;

 
import com.jcl.model.ModuleRole;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 *
 * @author junald
 * this class represent the user of the account or company
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    @Column(length = 15, unique = true)
    private String username;
    @Column
    private String password;
    
    @Column(length = 150)
    private String fullName;
     
    
    @OneToMany(mappedBy="user")
    private List<ModuleRole> moduleRoles;

    
    public static List<User> getUsers() throws Exception {
//        Query query = dbms.getDBInstance().query();
//        query.constrain(User.class);
//
//        List<User> result = query.execute();
//
//        return result;
        return null;
    }

    public static User getUser(String name) throws Exception {
//        User emp = null;
//        Query query = dbms.getDBInstance().query();
//        query.constrain(User.class);
//        query.descend("username").constrain(name);
//
//        ObjectSet result = query.execute();
//        if (result.hasNext()) {
//            emp = (User) result.next();
//        }
//        return emp;
        return null;
    }

    

    @Override
    public String toString() {
        return this.getUsername();
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the moduleRoles
     */
    public List<ModuleRole> getModuleRoles() {
        return moduleRoles;
    }

    /**
     * @param moduleRoles the moduleRoles to set
     */
    public void setModuleRoles(List<ModuleRole> moduleRoles) {
        this.moduleRoles = moduleRoles;
    }
}
