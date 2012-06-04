/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.Employee;
import com.jcl.model.PaySlip;
import com.jcl.model.PaySlipDetail;
import com.jcl.model.PayrollPeriod;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    
    public PaySlip getPayslipByPayPeriodAndEmployee(Employee employee, String payperiodCode){
        Query query = entityManager.createQuery("select s from PaySlip s where s.employee.id = ?1 and s.payrollPeriod.payrollPeriodCode = ?2 ");
        query.setParameter(1, employee.getId());
        query.setParameter(2, payperiodCode);
        
        PaySlip paySlip = (PaySlip) query.getSingleResult();
        return paySlip;
    }
    
      public PaySlip getOpenedPayslipByEmployee(Employee employee){
        Query query = entityManager.createQuery("select s from PaySlip s where s.employee.id = ?1 and s.status = ?2 ");
        query.setParameter(1, employee.getId());
        query.setParameter(2, "open");
        
        PaySlip paySlip = (PaySlip) query.getSingleResult();
        return paySlip;
    }

 

    //TODO: please check it is using payrollperiodtid as a key
    // in which it should use payslip id.
    public static LinkedHashMap<Integer, PaySlip> getPayslipByPaySlip(PayrollPeriod pp, Employee eep) throws Exception {

        LinkedHashMap<Integer, PaySlip> paySlipList = new LinkedHashMap<Integer, PaySlip>();
//        Query query = dbms.getDBInstance().query();
//        query.constrain(PaySlip.class);
//        if (eep == null) {
//            query.descend("payrollPeriodTid").constrain(pp.getTid());
//        } else {
//            Constraint c1 = query.descend("employeeTid").constrain(eep.getTid());
//            query.descend("payrollPeriodTid").constrain(pp.getTid()).and(c1);
//        }
//
//        List<PaySlip> result = query.execute();
//        if (result != null && !result.isEmpty()) {
//            for (PaySlip ps : result) {
//                paySlipList.put(ps.getPayrollPeriodTid(), ps);
//            }
//        }
//        retreivePayslipDetail(paySlipList,pp.getTid());

        return paySlipList;
    }

  
 

//    public List<PaySlipDetail> getPayables() {
//        List<PaySlipDetail> list = new ArrayList<PaySlipDetail>();
//        for (PaySlipDetail psd : payslipDetails) {
//            if (!psd.isIsDeduction()) {
//                list.add(psd);
//            }
//        }
//        return list;
//    }
//
//    public List<PaySlipDetail> getReceivables() {
//        List<PaySlipDetail> list = new ArrayList<PaySlipDetail>();
//        for (PaySlipDetail psd : payslipDetails) {
//            if (psd.isIsDeduction()) {
//                list.add(psd);
//            }
//        }
//        return list;
//    }
}
