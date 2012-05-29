/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.utilities;

 
import com.jcl.payroll.transaction.TransactionType;
import com.jcl.dbms.dbms;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlavador
 */
public class SetupDB {

    public static void main(String[] args) {
//        try {
//            dbms.login("admin", "password");
//            dbms.setProperties();
//
//            SetupDB sdb = new SetupDB();
//            sdb.createAccountingProduct(dbms.getDBInstance());
//
//            dbms.close();
//        } catch (Exception ex) {
//            Logger.getLogger(SetupDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

//      public void createAccountingProduct(ObjectContainer db) {
//        db.store(new Product("ACT001", "Loan", ProductLevel.Accounting.name(), TransactionType.Loans.name(), "ACT",true));
//        db.store(new Product("ACT002", "Cash Advanced - Employee", ProductLevel.Accounting.name(), TransactionType.CashAdvanced.name(), "ACT",true));
//        db.store(new Product("ACT003", "Cash Advanced - Grower", ProductLevel.Accounting.name(), TransactionType.CashAdvanced.name(), "ACT",true));
//        db.store(new Product("ACT004", "Expense", ProductLevel.Accounting.name(), TransactionType.Expenses.name(), "ACT",true));
//        db.store(new Product("ACT005", "Charges", ProductLevel.Accounting.name(), TransactionType.Charges.name(), "ACT",true));
//        db.store(new Product("ACT006", "Cash on hand", ProductLevel.Accounting.name(), TransactionType.CashOnHand.name(), "ACT",true));
//        db.store(new Product("ACT007", "Payables", ProductLevel.Accounting.name(), TransactionType.Payable.name(), "ACT",true));
//        db.store(new Product("ACT008", "Receivable", ProductLevel.Accounting.name(), TransactionType.Receivable.name(), "ACT",true));
//        db.store(new Product("ACT009", "Others", ProductLevel.Accounting.name(), TransactionType.Others.name(), "ACT",true));
//    }
}
