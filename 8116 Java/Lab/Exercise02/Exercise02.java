/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: June 10, 2022.
 * Modified: June 09, 2022.
 * Description: Exercise02 - part 1 - class Exercise02
 */


import java.util.Scanner; //import Scanner


public class Exercise02 {// start class body
	/* This is the entry point for the program*/
	public static void main(String[] args) {  // start method main	
		/*Declaring variables*/
		double inputWeight;
		double inputCost;
		
		System.out.println("Please enter weight:");//this message shows on console
			
		
		/*Using while loop to make sure input of weight is a positive number*/
		while(true) {
			 	//create new "iuputValue" object
				Scanner inputValue = new Scanner (System.in);				
				if(inputValue.hasNextDouble()&& (inputWeight=inputValue.nextDouble())>0) {//if the input is a positive number,
																						  //program will proceed
					break;//terminate this loop 
				}else {//if input is not a positive number, let user input weight again
					System.out.println("Invalid input.");
					System.out.print("Please enter weight:");
				}
			}
		
		System.out.println("Please enter cost:");//this message shows on console
		
		/*Using while loop to make sure input of weight is a positive number*/
		while(true) {
				Scanner inputValue = new Scanner (System.in);
				if(inputValue.hasNextDouble()&& (inputCost = inputValue.nextDouble())>0) {//if the input is a positive number
																						  //program will proceed
					inputValue.close();//close input
					break;//terminate this loop 
				}else {//if input is not a number
					System.out.println("Invalid input.");
					System.out.print("Please enter cost:");//let user input cost again
				}
			}
				
		Cabbage cabbage1 = new Cabbage();//create "cabbage1" object
		cabbage1.setWeight(inputWeight);//use setWeight method to set the weight
		cabbage1.setCostPerKilogram(inputCost);//use setCostPerKilogram method to set the cost
		
		/*Declaring and initializing variables*/
		double weight1 = cabbage1.getWeight(); //variable "weight1" receives the return of the getWeight method
		double costPerKilogram1 = cabbage1.getCostPerKilogram();//variable "costPerKilogram1" receives the return of the getCostPerKilogram method
		double price1 = cabbage1.calculatePrice();//variable "price1" receives the return of the calculatePrice method
		
		/*Check the output by vision*/
		System.out.println("Input Weight = " + inputWeight);//show the input weight
		System.out.println("Input Cost = " + inputCost);// show the input cost

		System.out.println("cabbage1.getWeight() is: " + weight1);//check getWeight method returns the right value
		System.out.println("cabbage1.getCostPerKilogram() is: " + costPerKilogram1);//check getCostPerKilogram method returns the right value
		System.out.println("cabbage.calculatePrice() is: " + price1);//check calculatePrice method returns the right value
		
		/*Checking printReport method returns the right value*/
		System.out.println("Cabbage1.printReport() is");//this messages shows on console
		cabbage1.printReport();//call printReport method

		System.out.println("Testing overloaded constructor with Cabbage2");//this messages shows on console
		
		/*Testing overloaded constructor*/
		Cabbage cabbage2 = new Cabbage(5, 10);//create "cabbage2" object with weight: 5, cost per kilogram: 10

		/*Declaring and initializing variables*/
		double weight2 = cabbage2.getWeight();
		double getCostPerKilogram2 = cabbage2.getCostPerKilogram();
		
		/*Check the output by vision*/
		System.out.println("Weight " + weight2 + ", " + "cost per kilogram " + getCostPerKilogram2);

		System.out.println("Cabbage2.printReport() is");
		cabbage2.printReport();

		System.out.println("Program by Yanzhang Wu");	// output the name
		
	}// stop method main
}// end class body