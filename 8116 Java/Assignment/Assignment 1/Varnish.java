/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: June 17, 2022.
 * Modified: June 08, 2022.
 * Description: Assignment - part 3 - class Varnish
 */


class Varnish {
	
	// declaration
	private int coatsNeeded;
	private int varnishCoverage;


	// non-arg constructor
	public Varnish() {

	}

	// constructor with arguments
	public Varnish(int coatsNeeded, int varnishCoverage) {
		this.coatsNeeded = coatsNeeded;
		this.varnishCoverage = varnishCoverage;
	}

	// setter of coatsNeeded
	public void setCoatsNeeded(int coatsNeeded) {
		this.coatsNeeded = coatsNeeded;
	}
	
	// getter of coatsNeeded
	public int getCoatsNeeded() {
		return coatsNeeded;
	}
	
	// setter of varnishCoverage
	public void setVarnishCoverage(int varnishCoverage) {
		this.varnishCoverage=varnishCoverage;
	}
	
	// getter of varnishCoverage
	public int getVarnishCoverage() {
		return varnishCoverage;
	}
	
	// calculate total area needed
	// total area = single area * number of coats
	// double singleArea is from class TableTop
	public double getTotalArea(double singleArea) {
		double totalArea = singleArea * coatsNeeded;
		return totalArea;
	}
	
	// calculate tables per one can
	// tables per one can = varnish coverage of one can / total area needed
	public double getTablesPerOneCan (double totalArea) {
		double tablesPerOneCan = varnishCoverage/totalArea;
		return tablesPerOneCan;
	}
	
	
}
