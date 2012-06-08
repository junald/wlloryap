/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;
 
import com.jcl.model.OtherAdjustment;
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
public class OtherAdjustmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public OtherAdjustment find(Long id) {
        return entityManager.find(OtherAdjustment.class, id);
    }

    @Transactional
    public void save(OtherAdjustment adjustment) {
        if (adjustment.getId() == null) {
            entityManager.persist(adjustment);
        } else {
            entityManager.merge(adjustment);
        }
    }
    
    public List<OtherAdjustment> getAdjustments(){
        return (List<OtherAdjustment>) entityManager.createQuery("from OtherAdjustment").getResultList();
    }
}
