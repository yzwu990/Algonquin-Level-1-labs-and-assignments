/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: July 22, 2022.
 * Modified: July 08, 2022.
 * Description: Assignment02 - part 1 - class Assignment02
 */

import java.util.Scanner;

/* 
 * This class is where main method locates. 
 * It will be used to test call working methods and output the information
 */
public class Assignment02 {

	// ToDo: Supervisor wants programmer comments (use /* */ comment)
	public static void main(String[] args) {

		/* Declarations and initiations */
		int size; // size of the bag
		double weight; // weight of the bag
		int goodBags = 0; // number of good bags
		int badBags = 0; // number of bad bags
		String choice = "yes"; // choice of continuing the program or not

		Scanner keyboard = new Scanner(System.in);

		/*
		 * Using while loop to keep the program running if the user choose "yes" (not
		 * case sensitive) to continue
		 */
		while (choice.equalsIgnoreCase("yes")) {

			PotatoChipBag bag = new PotatoChipBag();
			User user = new User();

			/* Call user.inputInteger(String message) to output the menu and enter size */
			size = user.inputInteger("Enter bag size:\n1 for regular size\n2 for large size");

			/* If the user input 1 or 2, the program continue with next steps normally */
			if (size == 1 || size == 2) {
				/* Call user.inputDouble(String message) to output the menu and enter weight */
				weight = user.inputDouble("Enter weight: ");

				/* Set size and weight of the bag */
				bag.setSize(size);
				bag.setWeight(weight);

				/*
				 * Verify the bag is good or bad. If the difference is within the tolerance, the
				 * bag is a good bag. Return true and the number of good bags will +1. 
				 * If the difference is not within the tolerance, the bag is a bad bag. Return false
				 * and the number of bad bags will +1.
				 */
				if (bag.isBagCorrectWeight() == true) {
					goodBags++;
				} else {
					badBags++;
				}

				/* Counting bags */
				System.out.println("Good bags:" + goodBags);
				System.out.println("Bad bags:" + badBags);
				System.out.println("Total bags:" + (goodBags + badBags));
				System.out.println("Program by Yanzhang Wu");

				/* Let user choose to continue the program or not */
				System.out.println("Continue Program? (yes/no)");
				choice = keyboard.nextLine();

				/*
				 * If the user input is not 1 or 2, the program will let the user to choose
				 * continue or not
				 */
			} else {
				System.out.println("Program by Yanzhang Wu");
				System.out.println("Continue Program? (yes/no)");
				choice = keyboard.nextLine();
			}

			/*
			 * Use this loop to ask user to enter the right option "yes" or "no" (not case
			 * sensitive)
			 */
			while ((!choice.equalsIgnoreCase("yes")) && (!choice.equalsIgnoreCase("no"))) {
				System.out.println("Invalid input. Please enter \"yes\" or \"no\"");
				choice = keyboard.nextLine();
			}

		}

		/*
		 * Use this loop to terminate the program if the user enter "no" (not case
		 * sensitive)
		 */
		while (choice.equalsIgnoreCase("no")) {
			System.out.println("Program has shut down");
			break;
		}

	}
}