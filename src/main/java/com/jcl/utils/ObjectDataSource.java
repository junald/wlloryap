package com.jcl.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/** */
/**
 * ObjectDataSource class is used to extract object field values for the report.
 * <br><br>
 * usage:<br>
 * List pilots =  <br>
 * ObjectDataSource dataSource = new ObjectDataSource(pilots);<br>
 * In the report (*.jrxml) you will need to define fields. For example: <br>
 *   <field name="Name" class="java.lang.String"/><br>
 *   where field name should correspond to  your getter method:<br>
 *   "Name" - for getName()<br>
 *   "Id" - for getId()<br>
 *
 */
public class ObjectDataSource implements JRDataSource {

    private Iterator iterator;
    private Object currentValue;
    private boolean isDynamic = false;

    public ObjectDataSource(List list, boolean idc) {
        this.iterator = list.iterator();
        this.isDynamic = idc;
    }
    // end ObjectDataSource

    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;
        try {
            // getter method signature is assembled from "get" + field name
            // as specified in the report
            if (isDynamic) {
              //  System.out.println("isDynamic: " + isDynamic);
                Field faccessor = currentValue.getClass().getField(field.getName());
                value = faccessor.get(currentValue);
            } else {

               //  System.out.println("isDynamic: " + isDynamic);
                Method fieldAccessor = currentValue.getClass().getMethod("get" + field.getName(), null);
                value = fieldAccessor.invoke(currentValue, null);
            }
            //System.out.println(faccessor.getName() + " : " + value);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ObjectDataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ObjectDataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ObjectDataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(ObjectDataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ObjectDataSource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException iae) {
            iae.printStackTrace();
        }
        return value;
    }
    // end getFieldValue

    public boolean next() throws JRException {
        currentValue = iterator.hasNext() ? iterator.next() : null;
        return (currentValue != null);
    }
    // end next
}
