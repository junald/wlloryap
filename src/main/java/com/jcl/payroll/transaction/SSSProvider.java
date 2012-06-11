/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcl.payroll.transaction;

import com.jcl.payroll.data.SSS;
import java.util.ArrayList;
import java.util.List;

public class SSSProvider {

    private static List<SSS> sssList = null;
    

    public static SSS getSSSContribution(Double salary) {
        
        if(sssList == null){
            init();
        }

        SSS ss = null;

        for (SSS sse : sssList) {
            if (salary >= sse.getRange1() && salary <= sse.getRange2()) {
                ss = sse;
                break;
            }
        }
        return ss;
    }

    public static void init() {
        sssList = new ArrayList<SSS>();
        sssList.add(new SSS(1000, 1249.99, 1000, 70.7, 33.3));
        sssList.add(new SSS(1250, 1749.99, 1500, 106, 50));
        sssList.add(new SSS(1750, 2249.99, 2000, 141.3, 66.7));
        sssList.add(new SSS(2250, 2749.99, 2500, 176.7, 83.3));
        sssList.add(new SSS(2750, 3249.99, 3000, 212, 100));
        sssList.add(new SSS(3250, 3749.99, 3500, 247.3, 116.7));
        sssList.add(new SSS(3750, 4249.99, 4000, 282.7, 133.3));
        sssList.add(new SSS(4250, 4749.99, 4500, 318, 150));
        sssList.add(new SSS(4750, 5249.99, 5000, 353.3, 166.7));
        sssList.add(new SSS(5250, 5749.99, 5500, 388.7, 183.3));
        sssList.add(new SSS(5750, 6249.99, 6000, 424, 200));
        sssList.add(new SSS(6250, 6749.99, 6500, 459.3, 216.7));
        sssList.add(new SSS(6750, 7249.99, 7000, 494.7, 233.3));
        sssList.add(new SSS(7250, 7749.99, 7500, 530, 250));
        sssList.add(new SSS(7750, 8249.99, 8000, 565.3, 266.7));
        sssList.add(new SSS(8250, 8749.99, 8500, 600.7, 283.3));
        sssList.add(new SSS(8750, 9249.99, 9000, 636, 300));
        sssList.add(new SSS(9250, 9749.99, 9500, 671.3, 316.7));
        sssList.add(new SSS(9750, 10249.99, 10000, 706.7, 333.3));
        sssList.add(new SSS(10250, 10749.99, 10500, 742, 350));
        sssList.add(new SSS(10750, 11249.99, 11000, 777.3, 366.7));
        sssList.add(new SSS(11250, 11749.99, 11500, 812.7, 383.3));
        sssList.add(new SSS(11750, 12249.99, 12000, 848, 400));
        sssList.add(new SSS(12250, 12749.99, 12500, 883.3, 416.7));
        sssList.add(new SSS(12750, 13249.99, 1300, 918.7, 433.3));
        sssList.add(new SSS(13250, 13749.99, 13500, 954, 450));
        sssList.add(new SSS(13750, 14249.99, 14000, 989.3, 466.7));
        sssList.add(new SSS(14250, 14749.99, 14500, 1024.7, 483.3));
        sssList.add(new SSS(14750, 30000, 15000, 1060, 500));
   }

    /**
     *
     * @author Kent
     */
    public static void main(String[] args) {
        System.out.println("SSS contribution.");
        SSSProvider ss = new SSSProvider();
        ss.init();

        SSS sse = ss.getSSSContribution(4000d);

        System.out.println(sse.getEr());
    }
}