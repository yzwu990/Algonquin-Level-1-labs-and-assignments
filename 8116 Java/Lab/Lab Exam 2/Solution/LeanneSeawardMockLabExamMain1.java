/*
 * Student Name: Leanne Seaward
 * Lab Professor: Leanne Seaward
 * Due Date: July 18, 2022
 * Modified: July 18, 2022
 * Description:This program runs a menu and allows the user to change and print data from the TunaFish class
 */


import java.util.Scanner;

public class LeanneSeawardMockLabExamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		final int EDIT_TUNA_FISH_PROTEIN = 1;
		final int EDIT_TUNA_FISH_OUNCES = 2;
		final int PRINT_TUNA_FISH = 3;
		final int EXIT_TUNA_FISH = 4;
		double proteinPerOunce, ounces;
		int choice = 1;
		TunaFish t1 = new TunaFish();
		Scanner input = new Scanner(System.in);
		
		//loop which prints the menu choices and gets user choice

		while (choice != EXIT_TUNA_FISH) {
			
			
			System.out.println("Enter Option: ");
			System.out.println("1 to edit tuna fish protein");
			System.out.println("2 to edit tuna fish ounces");
			System.out.println("3 to show tuna fish values");
			System.out.println("4 to exit program");
			System.out.println("Program by Stanley Pieda");

			choice = input.nextInt();
			
			//this if block executes the choice give above
			
			if (choice == EDIT_TUNA_FISH_PROTEIN) {
				//change protein per ounce
				System.out.println("Enter the protein per ounces in the Tuna Fish: ");
				proteinPerOunce = input.nextDouble();
				t1.setProteinPerOunce(proteinPerOunce);
				
			}
			else if (choice == EDIT_TUNA_FISH_OUNCES) {
				//change ounces
				System.out.println("Enter the number of ounces of Tuna Fish: ");
				ounces = input.nextDouble();
				t1.setOunces(ounces);
			}
			else if (choice == PRINT_TUNA_FISH) {
				//print report
				System.out.println(t1.printReport());
			}
			else if (choice == EXIT_TUNA_FISH) {
				//exit
				System.out.println("Program exits");
			}
			else {
				//choice is not valid
				System.out.println("Invaoid output");
			}
		}
 



	}

}
