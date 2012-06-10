/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.DailyTimeRecord;
import com.jcl.model.Employee;
import com.jcl.model.PayrollPeriod;
import com.jcl.payroll.enumtypes.DTRDisplayTypeStatus;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author junald
 */
@Repository
public class DailyTimeRecordDao {

    @PersistenceContext
    private EntityManager entityManager;

    public DailyTimeRecord find(Long id) {
        return entityManager.find(DailyTimeRecord.class, id);
    }

    @Transactional
    public void save(DailyTimeRecord dtr) {
        if (dtr.getId() == null) {
            entityManager.persist(dtr);
        } else {
            entityManager.merge(dtr);
        }
    }
    
    
    @Transactional  
     public List<DailyTimeRecord> getDailyTimeRecordsByEmployeeAndUprocess(Long employeeId, Boolean process) {

        //DateTime lastNDays = DateTime.now().minusDays(HISTORY_LENGTH);
        String queryString = "select d from DailyTimeRecord d where d.employee.id = ?1 and d.process = ?2 order by transactionDate ";
        Query query = entityManager.createQuery(queryString);
        query.setParameter(1, employeeId);
        query.setParameter(2, process);
        System.out.println(query.getResultList().size());
        if(query.getResultList().size() >0){
            DailyTimeRecord dtr = (DailyTimeRecord) query.getResultList().get(0);
              System.out.println("xxxxxxxxxxxxxx: " + dtr.getDtrType());
        }
        List<DailyTimeRecord> list = (List<DailyTimeRecord>) query.getResultList();

        return list;
    }

    public List<DailyTimeRecord> getDailyTimeRecords() {
        return (List<DailyTimeRecord>) entityManager.createQuery("from DailyTimeRecord order by transactionDate").getResultList();
    }
    
      public List<DailyTimeRecord> getDailyTimeRecordsByDateAndEmployee(Employee employee, Date from, Date to, DTRDisplayTypeStatus process) {

        //DateTime lastNDays = DateTime.now().minusDays(HISTORY_LENGTH);
          String queryString = "from DailyTimeRecord where employee.id = ?1 and transactionDate >= ?2 and transactionDate <= ?3 ";
          if(process == DTRDisplayTypeStatus.Closed){
              queryString= queryString + " and process = true order by transactionDate ";
          }else if(process == DTRDisplayTypeStatus.Opened){
              queryString= queryString + " and process = false order by transactionDate ";
          }else{
              queryString= queryString + " order by transactionDate ";
          }
             
        Query query = entityManager.createQuery(queryString);
        query.setParameter(1, employee.getId());
        query.setParameter(2, from);
        query.setParameter(3, to);

        return (List<DailyTimeRecord>) query.getResultList();
    }
      
//
//    public List<DailyTimeRecord> getDailyTimeRecordsByDateAndEmployee(Employee employee, PayrollPeriod pp, Boolean process) {
//
//        //DateTime lastNDays = DateTime.now().minusDays(HISTORY_LENGTH);
//        String queryString = "from DailyTimeRecord where employee.id = ?1 and transactionDate >= ?2 and transactionDate <= ?3 order by transactionDate ";
//        Query query = entityManager.createQuery(queryString);
//        query.setParameter(1, employee.getId());
//        query.setParameter(2, pp.getDateFrom());
//        query.setParameter(3, pp.getDateTo());
//
//        return (List<DailyTimeRecord>) query.getResultList();
//    }

//    public List<DailyTimeRecord> getMonthlyDailyTimeRecordsByEmployee(Employee employee, Integer month) {
//
//        //DateTime lastNDays = DateTime.now().minusDays(HISTORY_LENGTH);
//        String queryString = "from DailyTimeRecord where employee.id = ?1 and transactionDate >= ?2 and transactionDate <= ?3 order by transactionDate ";
//        Query query = entityManager.createQuery(queryString);
//        query.setParameter(1, employee.getId());
//        
////         em.createQuery("SELECT e " +
////                       "FROM Professor e " +
////                       "WHERE e.startDate BETWEEN :start AND :end")
////          .setParameter("start", start, TemporalType.DATE)
////          .setParameter("end", end, TemporalType.DATE)
////          .getResultList();
//
//
//        return (List<DailyTimeRecord>) query.getResultList();
//    }
    
    
}
