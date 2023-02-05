/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Date: June 13, 2022.
 * Description: Lab Exam 01 - class YanzhangWuLabExam1Section323
 */

public class YanzhangWuLabExam1Section323 {

	public static void main(String[] args) {

		// declaration and initiation
		double weight = 19.5;
		double costPrOunce = 1.25;

		// create a sweater object
		Sweater sweater = new Sweater();

		sweater.setWeight(weight);// set weight
		sweater.setCostPerOunce(costPrOunce);// set costPrOunce

		// output the retrieved values
		System.out.println("getWeight() is " + sweater.getWeight());
		System.out.println("getCostPerOunce() is " + sweater.getCostPerOunce());

		// test the worker method
		sweater.calculateTotalCost();

		// output my name
		System.out.println("Program by Yanzhang Wu");

	}

}
