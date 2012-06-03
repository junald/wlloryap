/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

 
import com.jcl.model.Department;
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
public class DepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Department find(Long id) {
        return entityManager.find(Department.class, id);
    }

    @Transactional
    public void save(Department department) {
        if (department.getId() == null) {
            entityManager.persist(department);
        } else {
            entityManager.merge(department);
        }
    }
    
    public List<Department> getDepartments(){
        return (List<Department>) entityManager.createQuery("from Department order by description").getResultList();
    }
}
