
/*
 * Author: Stanley Pieda
 * Date: March 16, 2022
 * Modified by: Yanzhang Wu
 * Modified Date: 2022-07-29
 * Due Date: 2022-08-05
 * Description: Starter Code / Sample Solution Exercise 05
 * Starter Code Note: Use the pseudocode and complete the inputString method
 */
import java.util.Scanner;

/* This class is used to receive inputs from the user */
public class User {

	private Scanner keyboard = new Scanner(System.in);

	/* This method is used to receive integer input */
	public int inputInteger() {
		int value = keyboard.nextInt();
		keyboard.nextLine();
		return value;
	}

	/* This method is used to output message first, then call inputInteger() */
	public int inputInteger(String message) {
		System.out.println(message);
		int value = inputInteger();
		return value;
	}

	/* This method is used to receive double input */
	public double inputDouble() {
		double value = keyboard.nextDouble();
		keyboard.nextLine();
		return value;
	}

	/* This method is used to output message firstly, then call inputDouble() */
	public double inputDouble(String message) {
		System.out.println(message);
		double value = inputDouble();
		return value;
	}

	/* This method is used to receive String input */
	public String inputString() {
		String input = keyboard.nextLine();
		return input;
	}

	/* This method is used to output message firstly, then call inputString() */
	public String inputString(String message) {
		System.out.println(message);
		String input = inputString();
		return input;

	}

}