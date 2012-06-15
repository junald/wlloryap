
package com.jcl.payroll.data;

/**
 * @author junald
 *
 */
public class Philhealth {

        private double range1;
	private double range2;
        private double salaryBase;
        private double totalMonthlyContribution; // total monthly contribution
        private double er;
        private double ee;
           
                
        public Philhealth(double range1, double range2, double salaryBase, double tmc, double er, double ee){
            this.range1 = range1;
            this.range2 = range2;
            this.salaryBase = salaryBase;
            this.totalMonthlyContribution = tmc;
            this.er = er;
            this.ee = ee;          
        }

	/**
	 * @return
	 */
	public double getEe() {
		return ee;
	}

	/**
	 * @return
	 */
	public double getEr() {
		return er;
	}

	/**
	 * @return
	 */
	public double getRange1() {
		return range1;
	}

	/**
	 * @return
	 */
	public double getRange2() {
		return range2;
	}

	/**
	 * @return
	 */
	public double getSalaryBase() {
		return salaryBase;
	}

	/**
	 * @return
	 */
	public double getTotalMonthlyContribution() {
		return totalMonthlyContribution;
	}

	/**
	 * @param d
	 */
	public void setEe(double d) {
		ee = d;
	}

	/**
	 * @param d
	 */
	public void setEr(double d) {
		er = d;
	}

	/**
	 * @param d
	 */
	public void setRange1(double d) {
		range1 = d;
	}

	/**
	 * @param d
	 */
	public void setRange2(double d) {
		range2 = d;
	}

	/**
	 * @param d
	 */
	public void setSalaryBase(double d) {
		salaryBase = d;
	}

	/**
	 * @param d
	 */
	public void setTotalMonthlyContribution(double d) {
		totalMonthlyContribution = d;
	}
     
}
