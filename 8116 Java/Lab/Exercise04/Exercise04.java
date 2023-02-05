/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: July 22, 2022.
 * Modified: July 11, 2022.
 * Description: Exercise04 - part 1 - class Exercise04
 */

import java.util.Scanner;


/*
 * This class will be used to receive the user's inputs 
 * and output information the user chooses
 */

/* 
 * This program will adopt Java regular expression to regulate the user's inputs.
 * However, to follow the template's structure, the input Sting will be converted to int.
 * This is discussed and approved by professor Fedor Ilitchev in lab class.
 */


public class Exercise04 {

	
	public static void main(String[] args) {

		double userLength; // the length from user input		
		int option; // the option from user
		String output; // output of menu
		

		/* Choices of the menu (constants) */
		final int validateMeterStick = 1;
		final int showInCentimeters = 2;
		final int showInMillimeters = 3;
		final int showReport = 4;
		
		
		/* This is the menu */
		output = "Please select from one of the following:\n" 
				+ validateMeterStick + " to validate meter stick\n"
				+showInCentimeters + " to show meter stick length in centimeters\n"
				+showInMillimeters + " to show meter stick length in millimeters\n"
				+showReport + " to show meter stick report";
		
		
		Scanner keyboard = new Scanner(System.in);
		
		
		// Enter length of stick
		System.out.println("Meter stick checker program.");
		System.out.print("Enter measured length in meters: ");
		
		
		/* 
		* This loop is used to make sure the input is a positive double.
		* If the input is not correct, the program will ask
		* the user to input again.
		*/
		while (true) {

			if (keyboard.hasNextDouble() && (userLength = keyboard.nextDouble()) > 0) {
				keyboard.nextLine();
				break;

			} else {// If the input is not a positive number (negative number or 0 or string)
				keyboard.nextLine();
				/* Ask user to enter the length again */
				System.out.println("Invalid input. Please enter the correct length:");
			}
		}
		
		
		// Output the menu
		System.out.println(output);

		
		// Create a MeterStick object
		MeterStick stick = new MeterStick();
		// Set the length
		stick.setLength(userLength);
		
		
		/* 
		 * This loop is used to regulate the user's choice.
		 * If the input is not correct, the program will ask
		 * the user to input again
		 */
		while (true) {
			
			String optionStr = keyboard.nextLine();
			
			// This is Java regular expression for 1, 2, 3, and 4
			String regexOption = "^[1-4]*$";
			
			// Validate the input of option
			boolean flagOption = optionStr.matches(regexOption);

			if (flagOption == true) {// If the input is valid, proceed with the switch structure
				/* convert the input from String to int */
				option = Integer. parseInt(optionStr);
				
				switch (option) {
				case validateMeterStick:
					stick.verify(userLength);
					break;
				case showInCentimeters:
					System.out.printf("Centimeters: %.5f\n", stick.toCentimeters());
					break;
				case showInMillimeters:
					System.out.printf("Millimeters: %.5f\n", stick.toMillimeters());
					break;
				case showReport:
					System.out.println(stick.toString());
					break;
				}

				// Output my name
				System.out.println("Program by Yanzhang Wu");

				break;// Terminate the while loop

			} else {// If the input is not valid, ask user to enter the option again
				System.out.println("Invalid menu option selected. Please enter the correct option again:");

			}
		}
	}
}
