package com.jcl.model;

import java.util.Date;
import javax.persistence.*;

/**
 * @author junald
 */
@Entity
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date specialDate;
    @Column(length = 150)
    private String description;
    @Column
    private Double rates;  // in percent
    @Column(length=15)
    private String holidayType; // Legel,Special

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
     * @return the specialDate
     */
    public Date getSpecialDate() {
        return specialDate;
    }

    /**
     * @param specialDate the specialDate to set
     */
    public void setSpecialDate(Date specialDate) {
        this.specialDate = specialDate;
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
     * @return the rates
     */
    public Double getRates() {
        return rates;
    }

    /**
     * @param rates the rates to set
     */
    public void setRates(Double rates) {
        this.rates = rates;
    }

    /**
     * @return the holidayType
     */
    public String getHolidayType() {
        return holidayType;
    }

    /**
     * @param holidayType the holidayType to set
     */
    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType;
    }
    
    
}
