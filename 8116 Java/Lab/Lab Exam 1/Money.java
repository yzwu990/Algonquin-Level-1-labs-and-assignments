/*
 * Student Name: Leanne Seaward
 * Lab Professor: Leanne Seaward
 * Due Date: October 6, 2021
 * Modified: October 6, 2021
 * Description: This class stores the amount of loonies, toonies,
 * quarters, dimes and nickels and computes the total amount
 * of money
 * 
 */

public class Money {
	
	//private data members to hold the number of each coin
	private int numToonie;
	private int numLoonie;
	private int numQuarter;
	private int numDime;
	private int numNickel;
	
	//no-arg constructor
	public Money() {
		
	}
	
	//getter for numToonie
	public int getNumToonie() {
		return numToonie;
	}
	
	//getter for numLoonie
	public int getNumLoonie() {
		return numLoonie;
	}
	
	//getter for numQuarter
	public int getNumQuarter() {
		return numQuarter;
	}
	
	//getter for numDime
	public int getNumDime() {
		return numDime;
	}
	
	//getter for numNickel
	public int getNumNickel() {
		return numNickel;
	}
	
	//setter for numToonie
	public void setNumToonie(int numToonie) {
		this.numToonie = numToonie;
	}
	
	//setter for numLoonie
	public void setNumLoonie(int numLoonie) {
		this.numLoonie = numLoonie;
	}
	
	//setter for numQuarter
	public void setNumQuarter(int numQuarter) {
		this.numQuarter = numQuarter;
	}
	
	//setter for numDime
	public void setNumDime(int numDime) {
		this.numDime = numDime;
	}
	
	//setter for numNickel
	public void setNumNickel(int numNickel) {
		this.numNickel = numNickel;
	}
	
	//this method multiplies each type of coin
	//by the monetary value of the coin to get 
	//the total amount of money
	public double computeMoneyTotal() {
		double total = 0;
		
		total += 2.0*numToonie;
		total += 1.0*numLoonie;
		total += 0.25*numQuarter;
		total += 0.10*numDime;
		total += 0.05*numNickel;
		
		return total;
	}
	


}
