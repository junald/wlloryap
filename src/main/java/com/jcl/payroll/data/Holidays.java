
package com.jcl.payroll.data;

import java.util.Date;

/**
 * @author junald
 */

public class Holidays  {

	private Date specialDate;
        private String holiday; // regular / special
        private double specialRates;  // in percent
        private String description;

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return
	 */
	public String getHoliday() {
		return holiday;
	}

	/**
	 * @return
	 */
	public Date getSpecialDate() {
		return specialDate;
	}

	/**
	 * @return
	 */
	public double getSpecialRates() {
		return specialRates;
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @param string
	 */
	public void setHoliday(String string) {
		holiday = string;
	}

	/**
	 * @param date
	 */
	public void setSpecialDate(Date date) {
		specialDate = date;
	}

	/**
	 * @param d
	 */
	public void setSpecialRates(double d) {
		specialRates = d;
	}

}
