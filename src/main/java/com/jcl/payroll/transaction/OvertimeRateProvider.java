/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author junald
 */
public class OvertimeRateProvider {
    
    private static HashMap<String, OvertimeRate> overTimeList = null;
    
    private static HashMap<String, OvertimeRate > getOverTimeList(){
        if(overTimeList == null){
            overTimeList = new  HashMap<String,  OvertimeRate >() ;
            init();
        }
        
        return overTimeList;
    }
    
    
    //_D - daily type - _M monthly
    //regular
    //rest day
    //legal holiday regular
    //legal holiday rest day
    //special holiday regular
    //special holiday rest day 
        
    //OR_D,ORS_D,OLHRG_D,OLHRT_D,OSHRG_D,OSHRT_D,OR_M,ORS_M,OLHRG_M,OLHRT_M,OSHRG_M,OSHRT_M
    private static void init(){
        //Daily
        overTimeList.put("OR_D", new OvertimeRate ("R_D",1d,1.250d,1.1d));
        overTimeList.put("ORS_D", new OvertimeRate ("RS_D",1.3d,1.3d,1.1d));
        overTimeList.put("OLHRG_D", new OvertimeRate ("LHRG_D",2d,1.3d,1.1d));
        overTimeList.put("OLHRT_D", new OvertimeRate ("LHRT_D",2.3d,1.3d,1.1d));
        overTimeList.put("OSHRG_D", new OvertimeRate ("SHRG_D",1.3d,1.3d,1.1));
        overTimeList.put("OSHRT_D", new OvertimeRate ("SHRT_D",1.5d,1.8d,1.1d));
        
        //Monthly
        overTimeList.put("OR_M", new OvertimeRate ("R_M",1d,1.250d,1.1d));
        overTimeList.put("ORS_M", new OvertimeRate ("RS_M",1.3d,1.3d,1.1d));
        overTimeList.put("OLHRG_M", new OvertimeRate ("LHRG_M",1d,1.3d,1.1d));
        overTimeList.put("OLHRT_M", new OvertimeRate ("LHRT_M",2.3d,1.3d,1.1d));
        overTimeList.put("OSHRG_M", new OvertimeRate ("SHRG_M",1.3d,1.3d,1.1));
        overTimeList.put("OSHRT_M", new OvertimeRate ("SHRT_M",1.5d,1.8d,1.1d));
    }
    
    public  static  OvertimeRate getRate(String code, Integer section){
        return overTimeList.get(code);
    }
    
    public  static  BigDecimal getDecimalRate(String code, Integer section){
        double rate = 0.0d;
        if(section == 1){
         rate =    overTimeList.get(code).getFirst8Hrs();
        }else if(section == 2){
           rate = overTimeList.get(code).getBefore10Pm();
        }else if(section == 3){
          rate =  overTimeList.get(code).getFrom10pmTo6am();
        }
        return new BigDecimal(rate);
    }
    
    public static boolean isOvertime(String key){
        boolean status = false;
        if(getOverTimeList().containsKey(key)){
            status = true;
        }
        return status;
    }
}