/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: June 17, 2022.
 * Modified: June 08, 2022.
 * Description: Assignment - part 1 - class Assignment1
 */

import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {

		// declaration and initialization
		double diameter;// diameter of the table top
		int coatsNeeded;// numbers of coats needed
		double singleArea;// area of one table top
		double totalArea;// total area for the needed coats
		double tablesPerOneCan;// numbers of tables that one can of varnish can paint
		final int VARNISH_COVERAGE = 46800;// constant, area that one can varnish can paint

		// output instructions
		System.out.println("Please enter diameter (inches):");

		// input diameter should be a positive number
		while (true) {
			Scanner input = new Scanner(System.in);
			if (input.hasNextDouble() && (diameter = input.nextDouble()) > 0) {// if the input is a positive number,
																				// program will proceed
				break;// terminate this loop
			} else {// if input is not a positive number, let user input diameter again
				System.out.println("Invalid input.");
				System.out.print("Please enter diameter (inches):");
			}
		}

		// output instructions
		System.out.println("Please enter coats needed:");

		// input coatsNeeded should be a positive integer
		while (true) {
			Scanner input = new Scanner(System.in);
			if (input.hasNextInt() && (coatsNeeded = input.nextInt()) > 0) {// if the input is a positive integer,
																			// program will proceed
				input.close();// close Scanner
				break;// terminate this loop
			} else {// if input is not a positive integer, let user input coats needed again
				System.out.println("Invalid input.");
				System.out.print("Please enter coats needed:");
			}
		}

		TableTop top = new TableTop();// create a top object
		top.setDiameter(diameter);// set the diameter
		singleArea = top.getSingleArea();// get area of one table top

		Varnish varnish = new Varnish();// create a varnish object
		varnish.setCoatsNeeded(coatsNeeded);// set coatsNeeded
		varnish.setVarnishCoverage(VARNISH_COVERAGE);// set varnishCoverage
		totalArea = varnish.getTotalArea(singleArea);// calculate total area needed
		tablesPerOneCan = varnish.getTablesPerOneCan(totalArea); // calculate numbers of tables that can one can paint

		// call tablesPerOneCan() and output the number
		System.out.println("Tables per one can: " + tablesPerOneCan);

		// output my name
		System.out.println("Program by Yanzhang Wu");

	}

}
