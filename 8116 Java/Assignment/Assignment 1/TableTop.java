/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: June 17, 2022.
 * Modified: June 08, 2022.
 * Description: Assignment - part 2 - class TableTop
 */


import static java.lang.Math.*;

class TableTop {

	// declaration
	private double diameter;
	
	// non-arg constructor
	public TableTop() {

	}
	// constructor with arguments
	public TableTop(double diameter) {
		this.diameter = diameter;
	}

	// setter of diameter
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	// getter of diameter
	public double getDiameter() {
		return diameter;
	}

	//calculate area of one table
	// area = 1/4 * PI * diameter^2
	public double getSingleArea() {
		double singleArea = PI * Math.pow(diameter, 2) / 4;
		return singleArea;
	}

}
