/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.dbms;



import com.jcl.model.Employee;
import com.jcl.model.PaySlipDetail;
import com.jcl.model.PayrollPeriod;
import com.jcl.model.User;
import com.jcl.utilities.TrackingIdGenerator;
import com.jcl.utilities.TransactionException;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;

/**
 *
 * @author jlavador
 */
public class dbms  implements ServerSetup {

    //final static String DB4OFILENAME = System.getProperty("user.home") + "c:/testdb/mydb.db4o";
    public final static String DB4OFILENAME = "c:/testdb/mydb2.db4o";
    public final static String PROPERTYNAME = "application.properties";
    public static String LOCALFILENAE = "db4odb.db4o";
    public static String LOCALHOST = "localhost";
    public static String BACKUPLOCATION = "backup/";
    public static String MAINDIRECTORY = "c:/testdb/";
    public static int LOCALPORT = 4488;
    public static String codebase;
    public static String codebaseReports;
    public static Properties properties = new Properties();    
    private static boolean isRemote = true;
    public static User user;   
    public static boolean useNewDB = false;

  

    public static void useNewDBInstance() {

//        newDB = Db4oClientServer.openClient(
//                getClientConfiguration(), LOCALHOST,
//                LOCALPORT, user.getUsername(), user.getPassword());

        useNewDB = true;
    }

    public static void login(String username, String password) throws Exception {

//        if (isRemote) {
//            setProperties();
//            try {
//                db = Db4oClientServer.openClient(
//                        getClientConfiguration(), LOCALHOST,
//                        LOCALPORT, username, password);
//                user = User.getUser(username);
//            } catch (Exception ex) {
//                throw ex;
//            }
//        }

    }

    public static void setProperties() {
        try {
            properties.load(new FileInputStream(PROPERTYNAME));
            System.out.println("localhost: " + properties.getProperty("localhost"));
            LOCALHOST = properties.getProperty("localhost");
            LOCALPORT = Integer.parseInt(properties.getProperty("port"));


            MAINDIRECTORY = properties.getProperty("maindirectory");
            BACKUPLOCATION = MAINDIRECTORY + properties.getProperty("backuplocation");
            LOCALFILENAE = MAINDIRECTORY + properties.getProperty("filename");
            dbms.codebase = System.getProperty("user.dir");
            dbms.codebaseReports = dbms.codebase + "/Reports/";

            System.out.println("dbms.codebase: " + dbms.codebase);
            System.out.println("dbms.codebaseReports: " + dbms.codebaseReports);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void close() {
//        if (db != null) {
//            db.close();
//            db = null;
//        }
    }

    public static void closeNewDB() {
//        if (newDB != null) {
//            newDB.close();
//            newDB = null;
//        }
//        useNewDB = false;
//        System.out.println("useNewDB");
    }

//this code set the activation depth,
//Configuration config = Db4o.configure();
//ObjectClass oc = config.objectClass("com.tedneward.model.Person");
//oc.minimumActivationDepth(10);
//Db4o.configure().objectClass(Person.class).cascadeOnUpdate(true);
//Db4o.configure().objectClass(Person.class).cascadeOnDelete(true);
//    public static void save(Invoice o, boolean isCommit) throws UniqueFieldValueConstraintViolationException, Exception {
//
//        try {
//
//            o.businessRule();
//            o.setModifiedDate(new Date());
//            o.setModifiedBy(dbms.user.getUsername());
//
//            if (o.getTid() == -1) {
//                int tid = TrackingIdGenerator.generatedNewTrackingId(o.getClass().getCanonicalName());
//                o.setTid(tid);
//                int gen = TrackingIdGenerator.generatedNewTrackingId(o.getInvoiceType());
//                o.setGeneratedNumber(gen);
//                o.setPreparedBy(dbms.user.getUsername());
//                //DR - delivery - out
//                //TR - trust receipt in
//                //RT - return
//                //NSTyymm0001
//                //ATCyymm0001
//                //DIRyymm0001
//
//                SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
//                NumberFormat nf = new DecimalFormat("0000");
//                String prefix = "";
//                if (o.getInvoiceType().equals(InvoiceType.Deliveries.name())) {
//                    prefix = "DR";
//                } else if (o.getInvoiceType().equals(InvoiceType.Receiving.name())) {
//                    prefix = "TR";
//                } else if (o.getInvoiceType().equals(InvoiceType.Billing.name())) {
//                    prefix = "INV";
//                } else if (o.getInvoiceType().equals(InvoiceType.Trucking.name())) {
//
//                    Client supplier = o.getSupplier();
//                    getDBInstance().ext().activate(supplier);
//                    System.out.println("supplier: " + supplier.getCompanyName() + " : " + supplier.getSupplierType());
//                    prefix = supplier.getSupplierType();
//                } else if (o.getInvoiceType().equals(InvoiceType.Returns.name())) {
//                    prefix = "DRR";
//                } else if (o.getInvoiceType().equals(InvoiceType.OnHand.name())) {
//                    prefix = "DRO";
//                } else if (o.getInvoiceType().equals(InvoiceType.Adjustment.name())) {
//                    prefix = "DRA";
//                }
//
//                String key = prefix + sdf.format(o.getTransactionDate());
//                int genKey = TrackingIdGenerator.generatedNewTrackingId(key);
//                String invNumber = key + "-" + nf.format(genKey);
//                o.setNumber(invNumber);
//
//                for (InvoiceDetail id : o.getDetails()) {
//                    id.setMtid(tid);
//                }
//
//            }
//
//            if (o.getStatus().equals(InvoiceStatus.Cancelled.name())
//                    && (o.getInvoiceType().equals(InvoiceType.Billing.name())
//                    || o.getInvoiceType().equals(InvoiceType.Trucking.name()))) {
//                BillingProcessor.cancelBilling(o);
//            }
//
//            dbms.getDBInstance().store(o);
//            if (isCommit) {
//                dbms.getDBInstance().commit();
//                //this will refresh data from database.
//                //because any changes is still in the memory what's being rollback is from the database
//                dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            }
//        } catch (UniqueFieldValueConstraintViolationException ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            dbms.getDBInstance().rollback();
//            throw ex;
//        } catch (TransactionException ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            throw ex;
//        } catch (Exception ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            dbms.getDBInstance().rollback();
//            throw ex;
//        }
//    }

//    public static void save(com.jcl.business.transaction.Transaction o, boolean isCommit) throws UniqueFieldValueConstraintViolationException, TransactionException, Exception {
//
//        try {
//
//
//            o.businessRule();
//
//            o.setModifiedDate(new Date());
//            o.setModifiedBy(dbms.user.getUsername());
//
//            if (o.getTid() == -1) {
//                int tid = TrackingIdGenerator.generatedNewTrackingId(o.getClass().getCanonicalName());
//                o.setTid(tid);
//                int gen = TrackingIdGenerator.generatedNewTrackingId(o.getTransactionType());
//                o.setGeneratedNumber(gen);
//                o.setPreparedBy(dbms.user.getUsername());
//
//
//                SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
//                NumberFormat nf = new DecimalFormat("0000");
//                String prefix = "";
//
//                if (o.getShowWhat().equals(ShowWhat.grower.name()) && !o.isIsGenerated()) {
//                    prefix = "ACG";
//                    // A transaction in which the client is grower. example:
//                    // Cash Advanced, Loans other accounting transaction that is entered
//                } else if (o.getShowWhat().equals(ShowWhat.employee.name())) {
//                    prefix = "ACE";
//                    // cash advanced, loans, others.
//                } else if (o.getShowWhat().equals(ShowWhat.accounting.name())) {
//                    prefix = "ACA";
//                    // all transaction that involved the company.
//                } else if (o.getShowWhat().equals(ShowWhat.grower.name()) && o.isIsGenerated()) {
//                    prefix = "ACGG";
//                    // a generated transaction that is comming from trucking typical transaction
//                    //are charges.
//                } else if (o.getShowWhat().equals(ShowWhat.growerpayable.name())) {
//                    prefix = "ACPG";
//                    //A transaction generated comming from Trucking.
//                }else if (o.getShowWhat().equals(ShowWhat.billing.name())) {
//                    prefix = "B";
//                    //A transaction generated comming from Trucking.
//                }
//
//                if(o.getTransactionType().equals(TransactionType.CashAdvanced.name())){
//                    prefix = "CA";
//                }
//
//                String key = prefix + sdf.format(o.getTransactionDate());
//                int genKey = TrackingIdGenerator.generatedNewTrackingId(key);
//                String invNumber = key + "-" + nf.format(genKey);
//                o.setNumber(invNumber);
//
//                for (TransactionDetail td : o.getTransactionDetails()) {
//                    td.setMtid(tid);
//                }
//
//            }
//
//            if (o.getStatus().equals(InvoiceStatus.Cancelled.name())
//                    && (o.getTransactionType().equals(InvoiceType.Billing.name())
//                    || o.getTransactionType().equals(InvoiceType.Trucking.name()))) {
//                //   BillingProcessor.cancelBilling(o);
//            }
//
//            dbms.getDBInstance().store(o);
//            if (isCommit) {
//                dbms.getDBInstance().commit();
//                //this will refresh data from database.
//                //because any changes is still in the memory what's being rollback is from the database
//                dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            }
//        } catch (UniqueFieldValueConstraintViolationException ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            dbms.getDBInstance().rollback();
//            throw ex;
//        } catch (TransactionException ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            throw ex;
//        } catch (Exception ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            dbms.getDBInstance().rollback();
//            throw ex;
//        }
//    }
//
//    public static void save(Trucking o, boolean isCommit) throws UniqueFieldValueConstraintViolationException, TransactionException, Exception {
//
//        try {
//
//            o.businessRule();
//            o.setModifiedDate(new Date());
//            o.setModifiedBy(dbms.user.getUsername());
//            if (o.getTid() == -1) {
//                int tid = TrackingIdGenerator.generatedNewTrackingId(o.getClass().getCanonicalName());
//                o.setTid(tid);
//                int gen = TrackingIdGenerator.generatedNewTrackingId(o.getInvoiceType());
//                o.setGeneratedNumber(gen);
//                o.setPreparedBy(dbms.user.getUsername());
//                //DR - delivery - out
//                //TR - trust receipt in
//                //RT - return
//                //NSTyymm0001
//                //ATCyymm0001
//                //DIRyymm0001
//
//                SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
//                NumberFormat nf = new DecimalFormat("0000");
//                String prefix = "DR";
//
//                String key = prefix + sdf.format(o.getTransactionDate());
//                int genKey = TrackingIdGenerator.generatedNewTrackingId(key);
//                String invNumber = key + "-" + nf.format(genKey);
//                o.setNumber(invNumber);
//
//                for (TruckingDetail td : o.getDetails()) {
//                    td.setMtid(tid);
//                }
//
//            }
//
//            dbms.getDBInstance().store(o);
//            if (isCommit) {
//                dbms.getDBInstance().commit();
//                //this will refresh data from database.
//                //because any changes is still in the memory what's being rollback is from the database
//                dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            }
//        } catch (UniqueFieldValueConstraintViolationException ex) {
//
//            dbms.getDBInstance().rollback();
//            throw ex;
//        } catch (TransactionException ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            throw ex;
//        } catch (Exception ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            dbms.getDBInstance().rollback();
//            throw ex;
//        }
//    }
//
//    public static void save(Billing o, boolean isCommit) throws UniqueFieldValueConstraintViolationException, TransactionException, Exception {
//
//        try {
//
//
//            o.businessRule();
//
//            o.setModifiedDate(new Date());
//            o.setModifiedBy(dbms.user.getUsername());
//
//            if (o.getTid() == -1) {
//                int tid = TrackingIdGenerator.generatedNewTrackingId(o.getClass().getCanonicalName());
//                o.setTid(tid);
//                int gen = TrackingIdGenerator.generatedNewTrackingId(o.getTransactionType());
//                o.setGeneratedNumber(gen);
//                o.setPreparedBy(dbms.user.getUsername());
//
//                //DR - delivery - out
//                //TR - trust receipt in
//                //RT - return
//                //NSTyymm0001
//                //ATCyymm0001
//                //DIRyymm0001
//
//                SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
//                NumberFormat nf = new DecimalFormat("0000");
//                String prefix = "OR";
//                if(o.getTransactionType().equals(PaymentType.Billing.name())){
//                    prefix = "BIL";
//                }
//
//                String key = prefix + sdf.format(o.getTransactionDate());
//                int genKey = TrackingIdGenerator.generatedNewTrackingId(key);
//                String invNumber = key + "-" + nf.format(genKey);
//                o.setNumber(invNumber);
//
//                for (BillingDetail bd : o.getTransactionDetails()) {
//                    bd.setMtid(tid);
//                }
//
//            }
//
//            if (o.getStatus().equals(InvoiceStatus.Cancelled.name())
//                    && (o.getTransactionType().equals(InvoiceType.Billing.name())
//                    || o.getTransactionType().equals(InvoiceType.Trucking.name()))) {
//                //   BillingProcessor.cancelBilling(o);
//            }
//
//            dbms.getDBInstance().store(o);
//            if (isCommit) {
//                dbms.getDBInstance().commit();
//                //this will refresh data from database.
//                //because any changes is still in the memory what's being rollback is from the database
//                dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            }
//        } catch (UniqueFieldValueConstraintViolationException ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            dbms.getDBInstance().rollback();
//            throw ex;
//        } catch (TransactionException ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            throw ex;
//        } catch (Exception ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            dbms.getDBInstance().rollback();
//            throw ex;
//        }
//    }

     public static void save(PayrollPeriod o, boolean isCommit) throws  TransactionException, Exception {

//        try {
//
//
//            o.businessRule();
//
//            o.setModifiedDate(new Date());
//            o.setModifiedBy(dbms.user.getUsername());
//
//            if (o.getTid() == -1) {
//                int tid = TrackingIdGenerator.generatedNewTrackingId(o.getClass().getCanonicalName());
//                o.setTid(tid);
//
//                o.setPreparedBy(dbms.user.getUsername());
//                //first letter + yymm + counter
//                //Variable, Monthly, SemiMonthly, Weekly, Daily, PerHour
//
//                SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
//                NumberFormat nf = new DecimalFormat("00");
//                String prefix = o.getPayrollPeriodType().substring(0, 1);
//                String key = prefix + sdf.format(o.getDatePrepared());
//                int genKey = TrackingIdGenerator.generatedNewTrackingId(key);
//                String ppCode = key + "-" + nf.format(genKey);
//                o.setPayrollPeriodCode(ppCode);
//
//            }
//
//
//            dbms.getDBInstance().store(o);
//            if (isCommit) {
//                dbms.getDBInstance().commit();
//                //this will refresh data from database.
//                //because any changes is still in the memory what's being rollback is from the database
//                dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            }
//         
//        } catch (TransactionException ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            throw ex;
//        } catch (Exception ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            dbms.getDBInstance().rollback();
//            throw ex;
//        }
    }

    public static void save(Object o) throws    TransactionException, Exception {

//        try {
//
//            modifyData(o);
//            dbms.getDBInstance().store(o);
//            dbms.getDBInstance().commit();
//            //this will refresh data from database.
//            //because any changes is still in the memory what's being rollback is from the database
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//        }  catch (Exception ex) {
//            dbms.getDBInstance().rollback();
//            throw ex;
//        }
    }

    public static void save(Object o, boolean isCommit) throws  TransactionException, Exception {

//        try {
//
//            modifyData(o);
//            dbms.getDBInstance().store(o);
//            if (isCommit) {
//                dbms.getDBInstance().commit();
//                //this will refresh data from database.
//                //because any changes is still in the memory what's being rollback is from the database
//                dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            }
//        }  catch (Exception ex) {
//            dbms.getDBInstance().ext().refresh(o, Integer.MAX_VALUE);
//            dbms.getDBInstance().rollback();
//            throw ex;
//        }
    }

    public static void saveNoCommit(Object o) throws  Exception {

//        try {
//
//            modifyData(o);
//            dbms.getDBInstance().store(o);
//        }   catch (Exception ex) {
//            dbms.getDBInstance().rollback();
//            throw ex;
//        }
    }

    public static void modifyData(Object o) throws IllegalAccessException, InvocationTargetException, Exception {
//        Class c = o.getClass();
//        System.out.println(c.getCanonicalName());
//
//        boolean isTidIsFound = true;
//        int tid = -1;
//        try {
//
//            Method m1 = c.getDeclaredMethod("getTid", null);
//            tid = (Integer) m1.invoke(o, null);
//
//        } catch (IllegalAccessException ex) {
//            throw ex;
//        } catch (IllegalArgumentException ex) {
//            throw ex;
//        } catch (InvocationTargetException ex) {
//            throw ex;
//        } catch (NoSuchMethodException ex) {
//            System.out.println(ex.getMessage());
//            isTidIsFound = false;
//        } catch (SecurityException ex) {
//            throw ex;
//        }
//
//        Method[] m = c.getDeclaredMethods();
//        for (int i = 0; i < m.length; i++) {
//            Method mm = m[i];
//            //    System.out.println(mm.getName());
//            try {
//                if (mm.getName().equals("setModifiedDate")) {
//                    mm.invoke(o, new Date());
//                }
//                if (mm.getName().equals("setModifiedBy")) {
//                    mm.invoke(o, dbms.user.getUsername());
//                }
//                if (mm.getName().equals("setTid") && isTidIsFound && tid == -1) {
//                    int counter = TrackingIdGenerator.generatedNewTrackingId(c.getName());
//                    mm.invoke(o, counter);
//                    if(o instanceof PaySlipDetail){
//                        ((PaySlipDetail)o).setRowNumber(counter);
//                    }
//                }
//
//            } catch (IllegalAccessException ex) {
//                System.out.println(ex.getMessage());
//                throw ex;
//            } catch (IllegalArgumentException ex) {
//                System.out.println(ex.getMessage());
//                throw ex;
//            } catch (InvocationTargetException ex) {
//                System.out.println(ex.getMessage());
//                throw ex;
//            }
//        }

    }

   
}
