/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hrm;



import com.jcl.utilities.TrackingIdGenerator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junald
 */
public class Position {

    private int tid = -1;
    private String description;

    public Position(String description) {
        this.description = description;
    }

     public Position(String description,int t) {
        this.description = description;
        this.tid = t;
    }

    public Position() {
    }

    /**
     * @return the tid
     */
    public int getTid() {
        return tid;
    }

    /**
     * @param tid the tid to set
     */
    public void setTid(int tid) {
        this.tid = tid;
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

       /**
     * @return the id
     */
    public long getId() throws Exception {

      //  return dbms.getDBInstance().ext().getID(this);
        return 1l;
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

    public static Position getPositionByTid(int id) throws Exception {
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

    @Override
    public String toString() {
        return description;
    }
}
