/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.model;




import javax.persistence.*;
/**
 *
 * @author junald
 */
@Entity
public class ModuleRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private Integer code;
    
    @Column(length = 150, unique = true, nullable = false)
    private String description;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

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
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
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
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

  
}
