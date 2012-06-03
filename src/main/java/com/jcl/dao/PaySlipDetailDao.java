/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.PaySlipDetail;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author junald
 */
public class PaySlipDetailDao {
    
    
      @PersistenceContext
    private EntityManager entityManager;

    public PaySlipDetail find(Long id) {
        return entityManager.find(PaySlipDetail.class, id);
    }

    @Transactional
    public void save(PaySlipDetail payslipDetail) {
        if (payslipDetail.getId() == null) {
            entityManager.persist(payslipDetail);
        } else {
            entityManager.merge(payslipDetail);
        }
    }
}
