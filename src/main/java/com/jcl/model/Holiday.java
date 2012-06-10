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
public class Holiday {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 10, unique = true, nullable = false)
    private String code;
    
    @Column(length = 150, unique = true, nullable = false)
    private String description;

    
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
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
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
    
    public String toString(){
        return this.description;
    }
    
}
