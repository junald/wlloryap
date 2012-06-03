package com.jcl.wrollyap.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    
    static ApplicationContext context;
      
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
         context =   new ClassPathXmlApplicationContext("/applicationContext.xml");
    }
}
