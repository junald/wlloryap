/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.Branch;
import com.jcl.model.PayrollPeriod;
import com.jcl.model.Position;
import com.jcl.payroll.enumtypes.DTRDisplayTypeStatus;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author junald
 */
@Repository
public class PayrollPeriodDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PayrollPeriod find(Long id) {
        return entityManager.find(PayrollPeriod.class, id);
    }

    @Transactional
    public void save(PayrollPeriod payrollPeriod) {
        if (payrollPeriod.getId() == null) {
            entityManager.persist(payrollPeriod);
        } else {
            entityManager.merge(payrollPeriod);
        }
    }
    
    public void save2(PayrollPeriod payrollPeriod) {
        if (payrollPeriod.getId() == null) {
            entityManager.persist(payrollPeriod);
        } else {
            entityManager.merge(payrollPeriod);
        }
    }

    public ArrayList<PayrollPeriod> getPayrollPeriods() {
        return (ArrayList<PayrollPeriod>) entityManager.createQuery("from PayrollPeriod order by datePrepared").getResultList();
    }

    public ArrayList<PayrollPeriod> getPayrollPeriods(boolean status) {

        String queryString = "from PayrollPeriod ";
        if (status) {
            queryString = queryString + "  order by datePrepared ";
        } else  {
            queryString = queryString + " where process = false order by datePrepared ";
        }

        Query query = entityManager.createQuery(queryString);
        ArrayList<PayrollPeriod> list = (ArrayList<PayrollPeriod>)  query.getResultList();
        return list;
    }
    
    public ArrayList<PayrollPeriod> getProcessPayrollPeriods() {

        String queryString = "from PayrollPeriod where process = true order by datePrepared ";        
        Query query = entityManager.createQuery(queryString);
        ArrayList<PayrollPeriod> list = (ArrayList<PayrollPeriod>)  query.getResultList();
        return list;
    }
}
