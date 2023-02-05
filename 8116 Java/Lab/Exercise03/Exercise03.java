/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: June 24, 2022.
 * Modified: June 22, 2022.
 * Description: Exercise03 - part 1 - class Exercise03
 */

import java.util.Scanner;

/* This class is for Exercise 03 to test class RightAngleTriangle */
public class Exercise03 {

	public static void main(String[] args) {

		double adjacent;
		double opposite;

		System.out.println("Please enter adjacent:");

		/* input adjacent should be a positive number */
		while (true) {
			Scanner input = new Scanner(System.in);
			/* if the input is a positive number, program will proceed */
			if (input.hasNextDouble() && (adjacent = input.nextDouble()) > 0) {
				/* terminate this loop */
				break;
			} else {
				/* if input is not a positive number, let user input adjacent again */
				System.out.println("Invalid input.");
				System.out.print("Please enter adjacent:");
			}
		}

		System.out.println("Please enter opposite:");

		/* input opposite should be a positive number */
		while (true) {
			Scanner input = new Scanner(System.in);
			/* if the input is a positive number, program will proceed */
			if (input.hasNextDouble() && (opposite = input.nextDouble()) > 0) {
				/* close input */
				input.close();
				/* terminate this loop */
				break;
			} else {
				/* if input is not a positive number, let user input adjacent again */
				System.out.println("Invalid input.");
				System.out.print("Please enter opposite:");
			}
		}

		/* create new object */
		RightAngleTriangle triangle = new RightAngleTriangle();

		/* set adjacent */
		triangle.setAdjacent(adjacent);
		/* set opposite */
		triangle.setOpposite(opposite);

		/* create report and print out */
		System.out.println(triangle.createReport());

		/* format and output hypotenus */
		System.out.printf("Hypotenuse: %.4f\n", triangle.calculateHypotenuse());
		/* format and output perimeter */
		System.out.printf("Perimeter: %.4f\n", triangle.calculatePerimeter());
		/* format and output area */
		System.out.printf("Area: %.4f\n", triangle.calculateArea());

		/* output name */
		System.out.println("Program by Yanzhang Wu");

	}

}
