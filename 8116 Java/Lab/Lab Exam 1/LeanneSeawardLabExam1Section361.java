/*
 * Student Name: Leanne Seaward
 * Lab Professor: Leanne Seaward
 * Due Date: October 6, 2021
 * Modified: October 6, 2021
 * Description: This class is used to test the Money class
 * 
 */
public class LeanneSeawardLabExam1Section361 {

	public static void main(String[] args) {
		
		int numToonie = 2;
		int numLoonie = 4;
		int numQuarter = 1;
		int numDime = 3;
		int numNickel = 5;
		
		Money m1 = new Money();
		
		m1.setNumToonie(numToonie);
		m1.setNumLoonie(numLoonie);
		m1.setNumQuarter(numQuarter);
		m1.setNumDime(numDime);
		m1.setNumNickel(numNickel);
		
		System.out.print("Change is " + m1.getNumToonie() + " toonies, ");
		System.out.print(m1.getNumLoonie() + " loonies, ");
		System.out.print(m1.getNumQuarter() + " quarters, ");
		System.out.print(m1.getNumDime() + " dimes and  ");
		System.out.println(m1.getNumNickel() + " nickels");
		
		System.out.println(m1.getNumToonie());
		System.out.println(m1.getNumLoonie());
		System.out.println(m1.getNumQuarter());
		System.out.println(m1.getNumDime());
		System.out.println(m1.getNumNickel());
		
		double total = m1.computeMoneyTotal();
		
		System.out.println("Testing work method: " + total);
		System.out.println("Program by Leanne Seaward");
		
		
		
		
		


	}

}
