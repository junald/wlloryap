
package com.jcl.payroll.data;

/**
 * @author junald
 *
 */
public class WithHoldingTax {
        
	private String taxID;
	private int tableColumn;
	private double value;
	private double over;
	private double exemption;

	/**
	 * @return
	 */
	public double getExemption() {
		return exemption;
	}

	/**
	 * @return
	 */
	public double getOver() {
		return over;
	}

	/**
	 * @return
	 */
	public int getTableColumn() {
		return tableColumn;
	}

	/**
	 * @return
	 */
	public String getTaxID() {
		return taxID;
	}

	/**
	 * @return
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param d
	 */
	public void setExemption(double d) {
		exemption = d;
	}

	/**
	 * @param d
	 */
	public void setOver(double d) {
		over = d;
	}

	/**
	 * @param i
	 */
	public void setTableColumn(int i) {
		tableColumn = i;
	}

	/**
	 * @param string
	 */
	public void setTaxID(String string) {
		taxID = string;
	}

	/**
	 * @param d
	 */
	public void setValue(double d) {
		value = d;
	}

}
