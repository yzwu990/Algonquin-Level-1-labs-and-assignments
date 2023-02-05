/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: June 24, 2022.
 * Modified: June 22, 2022.
 * Description: Exercise03 - part 2 - class RightAngleTriangle
 */

import static java.lang.Math.*;

/* 
 * This class is used to hold properties of a right angle triangle
 * This class will be tested by class Exercise03 
 */

class RightAngleTriangle {

	private double adjacent;
	private double opposite;

	/* non-argu constructor */
	public RightAngleTriangle() {

	}

	/* constructor with arguments */
	public RightAngleTriangle(double adjacent, double opposite) {
		this.adjacent = adjacent;
		this.opposite = opposite;
	}

	/* setter of adjacent */
	public void setAdjacent(double adjacent) {
		this.adjacent = adjacent;
	}

	/* getter of adjacent */
	public double getAdjacent() {
		return adjacent;
	}

	/* setter of opposite */
	public void setOpposite(double opposite) {
		this.opposite = opposite;
	}

	/* getter of opposite */
	public double getOpposite() {
		return opposite;
	}

	/* calculate hypotenuse
	* hypotenuse = square root of (adjacent^2+opposite^2)
	*/
	public double calculateHypotenuse() {
		double hypotenuse = Math.sqrt((Math.pow(adjacent, 2) + Math.pow(opposite, 2)));
		return hypotenuse;
	}

	/* perimeter = adjacent + opposite + hypotenuse */
	public double calculatePerimeter() {
		double perimeter = adjacent + opposite + calculateHypotenuse();
		return perimeter;
	}

	/* area = 0.5*adjacent*opposite */
	public double calculateArea() {
		double area = 0.5 * adjacent * opposite;
		return area;
	}

	/* use String report to format the output*/
	public String createReport() {
		String report = String.format("adjacent %.4f, ", adjacent) + String.format("opposite %.4f, ", opposite)
				+ String.format("hypotenuse %.4f", calculateHypotenuse());
		return report;
	}

}
