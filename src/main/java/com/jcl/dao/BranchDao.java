/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.Branch;
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
public class BranchDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Branch find(Long id) {
        return entityManager.find(Branch.class, id);
    }

    @Transactional
    public void save(Branch branch) {
        if (branch.getId() == null) {
            entityManager.persist(branch);
        } else {
            entityManager.merge(branch);
        }
    }
    
    public List<Branch> getBranches(){
        return (List<Branch>) entityManager.createQuery("from Branch").getResultList();
    }
}
