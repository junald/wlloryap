/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

import com.jcl.model.PaySlipDetail;
import com.jcl.payroll.enumtypes.PayslipDetailType;
import com.jcl.utilities.RowNumberInit;
import java.util.*;

/**
 *
 * @author JLavador
 */
public class PaySlipDetailSort implements Comparator {
  
    @Override
     public int compare(Object o1, Object o2) {
        PaySlipDetail other1 = (PaySlipDetail) o1;
        PaySlipDetail other2 = (PaySlipDetail) o2;
        Integer row1 = RowNumberInit.getRowNumbers(other1.getPaySlipDetailType());
        Integer row2 = RowNumberInit.getRowNumbers(other2.getPaySlipDetailType());
        int c = row1.compareTo(row2);
        if( c == 0){
            
            c = ((Integer)other1.getRowNumber()).compareTo(other2.getRowNumber());
        }
        return c;
    }

  
    public static void main(String[] args){
        List<PaySlipDetail> list = new ArrayList<PaySlipDetail>();
        PaySlipDetail psd1 = new PaySlipDetail(null, "WorkedHours");
        psd1.setRowNumber(1);
        PaySlipDetail psd2 = new PaySlipDetail(null, "Absent");
        psd2.setRowNumber(2);
        PaySlipDetail psd3 = new PaySlipDetail(null, "Loans");
        psd3.setRowNumber(3);
        PaySlipDetail psd4 = new PaySlipDetail(null, "SL");
        psd4.setRowNumber(4);
         PaySlipDetail psd5 = new PaySlipDetail(null, "WorkedHours");
        psd5.setRowNumber(5);
        
        list.add(psd1);
        list.add(psd2);
        list.add(psd3);
        list.add(psd4);
        list.add(psd5);
        Collections.sort(list, new PaySlipDetailSort());
        
        for(PaySlipDetail p: list){
            System.out.println(p.getPaySlipDetailType() +":" + p.getRowNumber());
        }
        
        
    }
}
   

 