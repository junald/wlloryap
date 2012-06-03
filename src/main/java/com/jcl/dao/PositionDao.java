/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dao;

import com.jcl.model.Branch;
import com.jcl.model.Position;
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
public class PositionDao {
     @PersistenceContext
    private EntityManager entityManager;

    public Position find(Long id) {
        return entityManager.find(Position.class, id);
    }

    @Transactional
    public void save(Position position) {
        if (position.getId() == null) {
            entityManager.persist(position);
        } else {
            entityManager.merge(position);
        }
    }
    
    public List<Position> getPositions(){
        return (List<Position>) entityManager.createQuery("from Position order by description").getResultList();
    }
}
