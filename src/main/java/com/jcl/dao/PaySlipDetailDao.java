/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.PaySlipDetail;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author junald
 */
@Repository
public class PaySlipDetailDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PaySlipDetail find(Long id) {
        return entityManager.find(PaySlipDetail.class, id);
    }

    @Transactional
    public void save(PaySlipDetail payslipDetail) {
        
        System.out.println("saving payslipDetail");
        if (payslipDetail.getId() == null) {
            entityManager.persist(payslipDetail);
        } else {
            entityManager.merge(payslipDetail);
        }
    }
    
    @Transactional
    public void delete(PaySlipDetail payslipDetail) {
        
       entityManager.remove(payslipDetail);
    }
    
    
    public void save2(PaySlipDetail payslipDetail) {
        
        System.out.println("saving payslipDetail");
        if (payslipDetail.getId() == null) {
            entityManager.persist(payslipDetail);
        } else {
            entityManager.merge(payslipDetail);
        }
    }
}
