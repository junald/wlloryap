/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author junald
 */
public class OvertimeRateProvider {
    
    private static HashMap<String, OvertimeRate> overTimeList = null;
    
    private HashMap<String, OvertimeRate > getOverTimeList(){
        if(overTimeList == null){
            overTimeList = new  HashMap<String,  OvertimeRate >() ;
            init();
        }
        
        return overTimeList;
    }
    
    private void init(){
        //Daily
        overTimeList.put("R_D", new OvertimeRate ("R_D",1d,1.250d,1.1d));
        overTimeList.put("RS_D", new OvertimeRate ("RS_D",1.3d,1.3d,1.1d));
        overTimeList.put("LHRG_D", new OvertimeRate ("LHRG_D",2d,1.3d,1.1d));
        overTimeList.put("LHRT_D", new OvertimeRate ("LHRT_D",2.3d,1.3d,1.1d));
        overTimeList.put("SHRG_D", new OvertimeRate ("SHRG_D",1.3d,1.3d,1.1));
        overTimeList.put("SHRT_D", new OvertimeRate ("SHRT_D",1.5d,1.8d,1.1d));
        
        //Monthly
        overTimeList.put("R_M", new OvertimeRate ("R_M",1d,1.250d,1.1d));
        overTimeList.put("RS_M", new OvertimeRate ("RS_M",1.3d,1.3d,1.1d));
        overTimeList.put("LHRG_M", new OvertimeRate ("LHRG_M",1d,1.3d,1.1d));
        overTimeList.put("LHRT_M", new OvertimeRate ("LHRT_M",2.3d,1.3d,1.1d));
        overTimeList.put("SHRG_M", new OvertimeRate ("SHRG_M",1.3d,1.3d,1.1));
        overTimeList.put("SHRT_M", new OvertimeRate ("SHRT_M",1.5d,1.8d,1.1d));
    }
    
    public static OvertimeRate getRate(String code, Integer section){
        return overTimeList.get(code);
    }
}