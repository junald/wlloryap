/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.Employee;
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
public class EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Employee find(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public void save(Employee employee) {
        if (employee.getId() == null) {
            entityManager.persist(employee);
        } else {
            entityManager.merge(employee);
        }
    }

    public List<Employee> getAll() {
        return (List<Employee>) entityManager.createQuery("from Employee").getResultList();
    }

    public List<Employee> getSortedEmployee(String filterBy, String value) {

        String queryString = "from Employee order by lastName, firstName, middleName ";

        if (filterBy.equals("position")) {
            queryString = "where position.description = ?1 ";
        } else if (filterBy.equals("department")) {
            queryString = "where position.description = ?1 ";
        } else if (filterBy.equals("company")) {
            queryString = "where position.description = ?1 ";
        } else if (filterBy.equals("branch")) {
            queryString = "where position.description = ?1 ";
        }

        Query query = entityManager.createQuery(queryString);
        query.setParameter(1, value);

        return (List<Employee>) query.getResultList();
    }

    public List<Employee> getSortedEmployee() {
        return (List<Employee>) entityManager.createQuery("from Employee order by lastName, firstName, middleName ").getResultList();
    }

    public Employee getEmployeeByIdNumber(String idNumber) {
        Query query = entityManager.createQuery("from Employee where idNumber = ?1");
        query.setParameter(1, idNumber);
        Employee employee = (Employee) query.getSingleResult();
        return employee;
    }
}
