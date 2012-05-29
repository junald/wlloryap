/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.hrm;



//import com.jcl.dbms.dbms;
import com.jcl.payroll.enumtypes.EmploymentStatus;
import com.jcl.payroll.enumtypes.FamilyRelationship;
import com.jcl.payroll.enumtypes.MaritalStatus;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlavador
 */
public class EmployeeMyTest {

    public static void main(String[] args) {
        java.util.Date start = new java.util.Date();

        System.out.println("start: " + start.toString());
        EmployeeMyTest emt = new EmployeeMyTest();
//        emt.testGetAllEmployees();
//        //emt.testUpdate();
         emt.createPosition();
        //  emt.testSaveMore();
        // emt.testQuery();
        //emt.testQueryEmployeeWithSalary();
       // dbms.close();
//        int d = 0;
//        Random r =new Random();
//        while(d!=4){
//            d = r.nextInt(4) + 1;
//
//        System.out.println(d);
//        }
        java.util.Date end = new java.util.Date();
        System.out.println("end: " + end.toString());

        long ti = end.getTime() - start.getTime();
        System.out.println(ti);
    }

    public void testQuery() throws Exception {


//        long tidTotal = 0;
//        SumPredicate sum = new SumPredicate();
//
//
//        ObjectSet<Employee> result = dbms.getDBInstance().query(sum);
//
//
//        System.out.println("result sum count: " + result.size() + "  total: " + sum.sum);
    }

//    public void testQueryEmployeeWithSalary() {
//
//
//
//        EmployeeWithSalary list = new EmployeeWithSalary();
//
//        double sum = 0.0;
//
//        ObjectSet<Employee> result = dbms.getDBInstance().query(list);
//        for (Employee e : result) {
//            sum += e.getSalary();
//        }
//
//        System.out.println("result list count: " + list.list.size() + "  total salary: " + sum);
//    }

    public void testGetAllEmployees() throws Exception {
//        System.out.println("getAllEmployees");
//
//        List<Employee> result = dbms.getDBInstance().query(Employee.class);
//        int count = 0;
//        for (Employee e : result) {
//            //  System.out.println(e.toString());
//            count++;
//        }
//        System.out.println("employeeSize: " + result.size());

        // TODO review the generated test code and remove the default call to fail.

    }

    public void testSave() {
//        System.out.println("save");
//
//        Position pp = new Position("Driver");
//        Person p = new Person("lavador1", "junald1", "conde1", Date.valueOf("1976-03-29"), 'M');
//        Employee instance = new Employee("10001", p.getLastName(), p.getFirstName(), p.getMiddleName(), EmploymentStatus.Probationary.name());
//        ArrayList<Dependents> d = new ArrayList<Dependents>();
//
//        d.add(new Dependents("lavador11", "junald11", "conde11", Date.valueOf("1981-04-26"), 'M', FamilyRelationship.Son.name()));
//        d.add(new Dependents("lavador12", "junald12", "conde12", Date.valueOf("1982-03-27"), 'M', FamilyRelationship.Son.name()));
//        instance.setDependents(d);
//        // int kye = Math.rint(3)
//        //  instance.setPosition(Position.getPosition("Driver"));
//        instance.setPosition(pp);
//        try {
//            //instance.save();
//            dbms.save(instance);
//            // TODO review the generated test code and remove the default call to fail.
//        } catch (UniqueFieldValueConstraintViolationException ex) {
//            Logger.getLogger(EmployeeMyTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(EmployeeMyTest.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public void testSaveMore() throws Exception {
//        System.out.println("save");
//        Random r = new Random();
//        int h = 0;
//             Position pp = new Position("Helper");
//        String[] pro = new String[]{"Contractual", "Regular", "Resigned", "Probationary", "Terminated"};
//        Object[] pos = Position.getAllPosition().toArray();
//        for (int i = 0; i < 1000; i++) {
//
//            // System.out.println(i);
//            Person p = new Person("lavador" + i, "junald" + i, "conde" + i, Date.valueOf("1976-03-29"), 'M');
//            Employee instance = new Employee("2" + i, p.getLastName(), p.getFirstName(), p.getMiddleName(), pro[r.nextInt(5)]);
//            ArrayList<Dependents> d = new ArrayList<Dependents>();
//
//            d.add(new Dependents("lavadorA" + i, "junaldA" + i, "condeA" + i, Date.valueOf("1981-04-26"), 'M', FamilyRelationship.values()[r.nextInt(10)].name()));
//            d.add(new Dependents("lavadorB" + i, "junaldB" + i, "condeB" + i, Date.valueOf("1982-03-27"), 'f', FamilyRelationship.values()[r.nextInt(10)].name()));
//            instance.setDependents(d);
//            // int kye = Math.rint(3)
//            instance.setMaritalStatus(MaritalStatus.values()[r.nextInt(3)].name());
//            //instance.setPosition((Position) pos[r.nextInt(4)]);
//            instance.setPosition(pp);
//            try {
//                //instance.save();
//                dbms.save(instance);
//                // TODO review the generated test code and remove the default call to fail.
//            } catch (UniqueFieldValueConstraintViolationException ex) {
//                Logger.getLogger(EmployeeMyTest.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (Exception ex) {
//                Logger.getLogger(EmployeeMyTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//        System.out.println("done....");
//        // TODO review the generated test code and remove the default call to fail.

    }

    public void testSaveMore2() throws Exception {
//        System.out.println("save");
//        Random r = new Random();
//        int h = 0;
//        Position pp = new Position("Helper");
//        String[] pro = new String[]{"Contractual", "Regular", "Resigned", "Probationary", "Terminated"};
//        Object[] pos = Position.getAllPosition().toArray();
//        for (int i = 0; i < 100000; i++) {
//
//            // System.out.println(i);
//            Person p = new Person("lavador" + i, "junald" + i, "conde" + i, Date.valueOf("1976-03-29"), 'M');
//            Employee instance = new Employee("4" + i, p.getLastName(), p.getFirstName(), p.getMiddleName(), "Contractual");
////            ArrayList<Dependents> d = new ArrayList<Dependents>();
////
////            d.add(new Dependents("lavadorA" + i, "junaldA" + i, "condeA" + i, Date.valueOf("1981-04-26"), 'M', FamilyRelationship.values()[r.nextInt(10)].name()));
////            d.add(new Dependents("lavadorB" + i, "junaldB" + i, "condeB" + i, Date.valueOf("1982-03-27"), 'f', FamilyRelationship.values()[r.nextInt(10)].name()));
////            instance.setDependents(d);
//            // int kye = Math.rint(3)
//            instance.setMaritalStatus("Single");
//            instance.setPosition(pp);
//            try {
//                //instance.save();
//                dbms.save(instance);
//                // TODO review the generated test code and remove the default call to fail.
//            } catch (UniqueFieldValueConstraintViolationException ex) {
//                Logger.getLogger(EmployeeMyTest.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (Exception ex) {
//                Logger.getLogger(EmployeeMyTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        System.out.println("done....");
//        // TODO review the generated test code and remove the default call to fail.
//        dbms.getDBInstance().commit();
    }

    public void testUpdate() throws Exception {
//        System.out.println("save");
//     Position pp = new Position("Cashier");
//
//        Employee instance = Employee.getEmployee("10004"); // Resigned
//
//        System.out.println(instance.getTid() + " : " + instance.getIdNumber() + " : " + instance.getStatus());
//
//        // instance.setStatus("Contractual");
//        instance.setPosition(pp);
//        try {
//            //instance.save();
//            dbms.save(instance);
//            // TODO review the generated test code and remove the default call to fail.
//        } catch (UniqueFieldValueConstraintViolationException ex) {
//            Logger.getLogger(EmployeeMyTest.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(EmployeeMyTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(instance.toString());
//        // TODO review the generated test code and remove the default call to fail.

    }

    public void createPosition() {
        new Position("Loader").save();
        new Position("Helper").save();
        new Position("Cashier").save();
        new Position("Driver").save();
    }

//    private static class SumPredicate extends Predicate<Employee> {
//
//        private long sum = 0;
//
//        public boolean match(Employee emp) {
//
//            sum += emp.getSalary();
//            return true;
//        }
//    }

//    private static class EmployeeWithSalary extends Predicate<Employee> {
//
//        List<Employee> list = new ArrayList<Employee>();
//
//        @Override
//        public boolean match(Employee et) {
//            if (et.getSalary() > 0) {
//                list.add(et);
//            }
//            return true;
//        }
//    }

//    public void fixedEmployee(){
//        Employee e = Employee.getEmployee(null)
//    }
}
