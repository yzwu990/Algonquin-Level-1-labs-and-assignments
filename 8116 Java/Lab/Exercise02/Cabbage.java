/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: June 10, 2022.
 * Modified: June 09, 2022.
 * Description: Exercise02 - part 2 - class Cabbage
 */


// Cabbage class 

class Cabbage {// start class body

	/*Declaring variables*/
	private double weight; 
	private double costPerKilogram;

	/* Constructor */
	public Cabbage() {

	}
	/* Constructor with arguments */
	public Cabbage(double weight, double costPerKilogram) {
		this.weight = weight;
		this.costPerKilogram = costPerKilogram;
	}

	/* get-set method weight */
	public double getWeight() {// start method getWeight
		return weight; //return value of weight
	}// stop method getWeight

	public void setWeight(double weight) {
		this.weight = weight;
	}

	/* get-set method CostPerKilogram */
	public double getCostPerKilogram() {
		return costPerKilogram;
	}

	public void setCostPerKilogram(double costPerKilogram) {
		this.costPerKilogram = costPerKilogram;
	}

	// calculate total price
	// total price = weight * cost per kilogram
	public double calculatePrice() {
		double price = weight * costPerKilogram;//declaration and initiation price
		return price;
	}

	/* print report */
	public void printReport() {
		System.out.println("Cabbage: weight: " + weight + ", " + "cost per kilogram " + costPerKilogram);
	}
}// end class body
