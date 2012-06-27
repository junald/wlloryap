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
        overTimeList.put("OT_RD", new OvertimeRate ("OT_RD",1d,1.250d,1.1d));
        overTimeList.put("OT_RSD", new OvertimeRate ("OT_RSD",1.3d,1.3d,1.1d));
        overTimeList.put("OT_LHRGD", new OvertimeRate ("OT_LHRGD",2d,1.3d,1.1d));
        overTimeList.put("OT_LHRTD", new OvertimeRate ("OT_LHRTD",2.3d,1.3d,1.1d));
        overTimeList.put("OT_SHRGD", new OvertimeRate ("OT_SHRGD",1.3d,1.3d,1.1));
        overTimeList.put("OT_SHRTD", new OvertimeRate ("OT_SHRTD",1.5d,1.8d,1.1d));
        
        //Monthly
        overTimeList.put("OT_RM", new OvertimeRate ("OT_RM",1d,1.250d,1.1d));
        overTimeList.put("OT_RSM", new OvertimeRate ("OT_RSM",1.3d,1.3d,1.1d));
        overTimeList.put("OT_LHRGM", new OvertimeRate ("OT_LHRGM",1d,1.3d,1.1d));
        overTimeList.put("OT_LHRTM", new OvertimeRate ("OT_LHRTM",2.3d,1.3d,1.1d));
        overTimeList.put("OT_SHRGM", new OvertimeRate ("OT_SHRGM",1.3d,1.3d,1.1));
        overTimeList.put("OT_SHRTM", new OvertimeRate ("OT_SHRTM",1.5d,1.8d,1.1d));
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