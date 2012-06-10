/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.Holiday;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author junald
 */
@Repository
public class HolidayDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Holiday find(Long id) {
        return entityManager.find(Holiday.class, id);
    }

    @Transactional
    public void save(Holiday holiday) {
        if (holiday.getId() == null) {
            entityManager.persist(holiday);
        } else {
            entityManager.merge(holiday);
        }
    }
    
    public List<Holiday> getHolidays(){
        return (List<Holiday>) entityManager.createQuery("from Holiday").getResultList();
    }
}
