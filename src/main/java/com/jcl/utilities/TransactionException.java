/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.utilities;

/**
 *
 * @author junald
 */
public class TransactionException extends Exception {
    
     String message ;

     public TransactionException(String msg){
         super(msg);
         this.message = msg;
     }

     public String getSimpleMessage(){
         return message;
     }
}
