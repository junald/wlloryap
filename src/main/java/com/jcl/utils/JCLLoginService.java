/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcl.utils;

import org.jdesktop.swingx.auth.LoginService;

/**
 *
 * @author jlavador
 */
public class JCLLoginService extends LoginService{



    @Override
    public boolean authenticate(String name, char[] password, String server) throws Exception {
       
       String p = "";
       for(char c: password){
           p=p+c;
       }
        System.out.println(p);
       if(name.equals("junald") && p.equals("junald") ){
           return true;
       }
        return false;
    }

}
