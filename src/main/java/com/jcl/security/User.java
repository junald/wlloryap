/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.security;

 
import com.jcl.security.ModuleRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junald
 * this class represent the user of the account or company
 */
public class User {

    private int tid = -1;
    private String username;
    private String password;
    private String fullName ="";
    private List<ModuleRole> moduleRoles = new ArrayList<ModuleRole>();

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
    public void setModuleRoles(ArrayList<ModuleRole> moduleRoles) {
        this.moduleRoles = moduleRoles;
    }

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

    @Override
    public String toString() {
        return this.username;
    }
}
