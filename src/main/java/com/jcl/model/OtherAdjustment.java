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
public class OtherAdjustment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 150)
    private String description;
    @Column(length = 15)
    private String adjustmentType; //less, deduction
    @Column
    private Boolean taxable;    
    @Column
    private Boolean everyPayroll;    
    @Column
    private Double amount;
    
    

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
    public String toString() {
        return description;
    }
    /**
     * @return the adjustmentType
     */
    public String getAdjustmentType() {
        return adjustmentType;
    }

    /**
     * @param adjustmentType the adjustmentType to set
     */
    public void setAdjustmentType(String adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    /**
     * @return the taxable
     */
    public Boolean getTaxable() {
        return taxable;
    }

    /**
     * @param taxable the taxable to set
     */
    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    /**
     * @return the everyPayroll
     */
    public Boolean getEveryPayroll() {
        return everyPayroll;
    }

    /**
     * @param everyPayroll the everyPayroll to set
     */
    public void setEveryPayroll(Boolean everyPayroll) {
        this.everyPayroll = everyPayroll;
    }
    
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    
    
}
