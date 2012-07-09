/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Date;
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
public class PaySlipDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PaySlip find(Long id) {
        return entityManager.find(PaySlip.class, id);
    }

    @Transactional
    public void save(PaySlip payslip) {
        if (payslip.getId() == null) {
            entityManager.persist(payslip);
        } else {
            entityManager.merge(payslip);
        }
    }
    
     public void save2(PaySlip payslip) {
        if (payslip.getId() == null) {
            entityManager.persist(payslip);
        } else {
            entityManager.merge(payslip);
        }
    }     
    
    @Transactional
    public PaySlip getPayslipByPayPeriodAndEmployee(Employee employee, Long payrollPeriodId) {
        Query query = entityManager.createQuery("select s from PaySlip s where s.employee.id = ?1 and s.payrollPeriod.id = ?2 ");
        query.setParameter(1, employee.getId());
        query.setParameter(2, payrollPeriodId);
        PaySlip paySlip = null;
         List<PaySlip> list = (List<PaySlip>) query.getResultList();
        if (list.size() > 0) {
            paySlip = (PaySlip) list.get(0);
        }

        return paySlip;
    }


    public List<Employee> getAllPayslipBaseOnEmployee(PayrollPeriod pp) {
        Query query = entityManager.createQuery("select s.employee from PaySlip s where s.payrollPeriod.id = ?1 ");
        query.setParameter(1, pp.getId());

        List<Employee> list = (List<Employee>) query.getResultList();
        return list;
    }

    
    public List<PaySlipDetail> getAllPayslipByDateFromAndTo(Date dateFrom, Date dateTo){
        String queryString = "from PaySlipDetail where paySlip.payrollPeriod.dateFrom >= ?1 and paySlip.payrollPeriod.dateTo <= ?2  and process = true";
        Query query = entityManager.createQuery(queryString);        
        query.setParameter(1, dateFrom);
        query.setParameter(2, dateTo);
        

        return (List<PaySlipDetail>) query.getResultList();    
    }
  
    
    //not used
     public PaySlip getPayslipByPayPeriodAndEmployee(Employee employee, String payperiodCode) {
        Query query = entityManager.createQuery("select s from PaySlip s where s.employee.id = ?1 and s.payrollPeriod.payrollPeriodCode = ?2 ");
        query.setParameter(1, employee.getId());
        query.setParameter(2, payperiodCode);

         PaySlip paySlip = null;
         List<PaySlip> list = (List<PaySlip>) query.getResultList();
        if (list.size() > 0) {
            paySlip = (PaySlip) list.get(0);
        }
        return paySlip;
    }
     
       public List<PaySlip> getAllPayslipByPayrollPeriod(PayrollPeriod pp) {
        Query query = entityManager.createQuery("select s from PaySlip s where s.payrollPeriod.id = ?1 ");
        query.setParameter(1, pp.getId());

        List<PaySlip> list = (List<PaySlip>) query.getResultList();
        return list;
    }
       
        public PaySlip getOpenedPayslipByEmployee(Employee employee) {
        Query query = entityManager.createQuery("select s from PaySlip s where s.employee.id = ?1 and s.status = ?2 ");
        query.setParameter(1, employee.getId());
        query.setParameter(2, "open");

          PaySlip paySlip = null;
         List<PaySlip> list = (List<PaySlip>) query.getResultList();
        if (list.size() > 0) {
            paySlip = (PaySlip) list.get(0);
        }
        return paySlip;
    }
     //not used
}
