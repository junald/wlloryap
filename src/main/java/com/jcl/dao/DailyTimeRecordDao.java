/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.DailyTimeRecord;
import com.jcl.model.Employee;
import com.jcl.model.PayrollPeriod;
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

    public List<DailyTimeRecord> getDailyTimeRecords() {
        return (List<DailyTimeRecord>) entityManager.createQuery("from DailyTimeRecord order by transactionDate").getResultList();
    }

    public List<DailyTimeRecord> getDailyTimeRecordsByDateAndEmployee(Employee employee, PayrollPeriod pp, Boolean process) {

        //DateTime lastNDays = DateTime.now().minusDays(HISTORY_LENGTH);
        String queryString = "from DailyTimeRecord where employee.id = ?1 and transactionDate >= ?2 and transactionDate <= ?3 order by transactionDate ";
        Query query = entityManager.createQuery(queryString);
        query.setParameter(1, employee.getId());
        query.setParameter(2, pp.getDateFrom());
        query.setParameter(3, pp.getDateTo());

        return (List<DailyTimeRecord>) query.getResultList();
    }

    public List<DailyTimeRecord> getMonthlyDailyTimeRecordsByEmployee(Employee employee, Integer month) {

        //DateTime lastNDays = DateTime.now().minusDays(HISTORY_LENGTH);
        String queryString = "from DailyTimeRecord where employee.id = ?1 and transactionDate >= ?2 and transactionDate <= ?3 order by transactionDate ";
        Query query = entityManager.createQuery(queryString);
        query.setParameter(1, employee.getId());
        
//         em.createQuery("SELECT e " +
//                       "FROM Professor e " +
//                       "WHERE e.startDate BETWEEN :start AND :end")
//          .setParameter("start", start, TemporalType.DATE)
//          .setParameter("end", end, TemporalType.DATE)
//          .getResultList();


        return (List<DailyTimeRecord>) query.getResultList();
    }
    
    
}
