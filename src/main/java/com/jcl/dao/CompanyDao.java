/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.Branch;
import com.jcl.model.Company;
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
public class CompanyDao {
     @PersistenceContext
    private EntityManager entityManager;

    public Company find(Long id) {
        System.out.println("finding company with id:=" + id);
        Company  company = entityManager.find(Company.class, id);
        if(company!=null){
            System.out.println(company);
        }
        return company;
    }

    @Transactional
    public void save(Company company) {
        if (company.getId() == null) {
            entityManager.persist(company);
        } else {
            entityManager.merge(company);
        }
        
        System.out.println("save." + company.getId());
    }
    
    public List<Company> getCompanies(){
        return (List<Company>) entityManager.createQuery("from Company order by description").getResultList();
    }
}
