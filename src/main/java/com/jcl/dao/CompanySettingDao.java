/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.Branch;
import com.jcl.model.Company;
import com.jcl.model.CompanySetting;
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
public class CompanySettingDao {
     @PersistenceContext
    private EntityManager entityManager;

    public CompanySetting find(Long id) {

        CompanySetting  company = entityManager.find(CompanySetting.class, id);
        if(company!=null){
            System.out.println(company);
        }
        return company;
    }

    @Transactional
    public void save(CompanySetting company) {
        if (company.getId() == null) {
            entityManager.persist(company);
        } else {
            entityManager.merge(company);
        }
        
        System.out.println("save." + company.getId());
    }
    
    public List<CompanySetting> getCompanies(){
        return (List<CompanySetting>) entityManager.createQuery("from CompanySetting order by description").getResultList();
    }
}
