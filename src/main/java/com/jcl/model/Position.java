/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.model;



import com.jcl.utilities.TrackingIdGenerator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.*;
/**
 *
 * @author junald
 */

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 150, unique = true)
    private String description;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

   
    public static ArrayList<Position> getAllPosition() throws Exception {
        ArrayList<Position> list = new ArrayList<Position>();
//
//        ObjectSet<Position> result = dbms.getDBInstance().query(Position.class);
//        while (result.hasNext()) {
//            list.add(result.next());
//        }
        return list;
    }

    public static Position getPosition(String desc) throws Exception {
        Position emp = null;
//        Query query = dbms.getDBInstance().query();
//        query.constrain(Position.class);
//        query.descend("description").constrain(desc);
//
//        ObjectSet result = query.execute();
//        if (result.hasNext()) {
//            emp = (Position) result.next();
//        }
        return emp;
    }

    public static Position getPositionByTid(Long id) throws Exception {
        Position emp = null;
//        Query query = dbms.getDBInstance().query();
//        query.constrain(Position.class);
//        query.descend("tid").constrain(id);
//
//        ObjectSet result = query.execute();
//        if (result.hasNext()) {
//            emp = (Position) result.next();
//        }
        return emp;
    }

    public void save() {
//        try {
//            dbms.save(this);
//           
//        } catch (UniqueFieldValueConstraintViolationException ex) {
//            Logger.getLogger(Position.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(Position.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

   
}
