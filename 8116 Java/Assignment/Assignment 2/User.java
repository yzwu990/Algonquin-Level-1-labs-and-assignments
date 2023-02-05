/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: July 22, 2022.
 * Modified: July 08, 2022.
 * Description: Assignment02 - part 3 - class User
 */


import java.util.Scanner;

/* This class is used to receive inputs from the user */
public class User {

	private Scanner keyboard = new Scanner(System.in);

	/* This method is used to receive the bag size (integer) */
	public int inputInteger() {

		/* Set default size = 0 */
		int size = 0;

		String option = keyboard.nextLine();
		/* Regular expression. The input should be 1 or 2 */
		String regexOption = "^[1-2]*$";
		/* Check if the input matches the regular expression */
		boolean flagOption = option.matches(regexOption);

		/*
		 * If the input is 1 or 2, convert the String to int and pass the value to size.
		 * If the input is not 1 or 2, output the message and do not alter size.
		 */
		if (flagOption == true) {
			size = Integer.parseInt(option);
		} else {
			System.out.println("Invalid bag size entered.");
		}
		/* Return the current value of size */
		return size;
	}

	/*
	 * This method is used to output the message first, then call inputInteger() method
	 */
	public int inputInteger(String message) {
		System.out.println(message);
		int value = inputInteger();
		return value;
	}

	/* This method is used to receive the weight */
	public double inputDouble() {
		double weight;

		/*
		 * This loop is used to make sure the input weight is a positive double, not
		 * negative numbers or 0 or strings.
		 */
		while (true) {
			if (keyboard.hasNextDouble() && (weight = keyboard.nextDouble()) > 0) {
				return weight;
			} else {
				/*
				 * There is 'enter' left in the input. Must add .nestline() here; otherwise
				 * there will be a dead loop
				 */
				keyboard.nextLine();
				System.out.println("Invalid input. Please enter the correct weight:");
			}
		}
	}

	/*
	 * This method is used to output the message first, then call inputDouble() method
	 */
	public double inputDouble(String message) {
		System.out.print(message);
		double value = inputDouble();
		return value;
	}
}