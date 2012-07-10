/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.utils;

/**
 *
 * @author JLavador
 */
public class FilterMaker {
    
    public static String makeFilter(String[] filter){
        String newFilter = "";
        
        if(filter.length == 1){
            newFilter = "'"+filter[0]+"'";
        }else{
            for(String s: filter){
                newFilter = newFilter+"'"+s+"',";
            }
            newFilter = newFilter.substring(0, newFilter.length()-1);
        }
        
        return newFilter;
    }
    
    public static void main(String[] args){
           System.out.println(FilterMaker.makeFilter(new String[]{"junald"}));
        System.out.println(FilterMaker.makeFilter(new String[]{"junald","lavador"}));
    }
}
