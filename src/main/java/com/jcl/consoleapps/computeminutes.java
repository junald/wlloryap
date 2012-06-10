/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.consoleapps;

/**
 *
 * @author junald
 */
public class computeminutes {
    
    public static void main(String[] args){
        int totalMinutes = 125;
              int _tm = totalMinutes/60;
              int _rm = totalMinutes%60;
              
              System.out.println("tm: " + _tm);
    }
}
