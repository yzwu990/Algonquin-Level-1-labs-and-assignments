/*
 * Student Name: Yanzhang Wu
 * Lab Professor: Professor Fedor Ilitchev
 * Due Date: Aug 05, 2022.
 * Modified: Aug 02, 2022.
 * Description: Assignment03
 */

/*This program rolls a 16 sided dice 1000 times and records the number of even rolls and the number of odd rolls*/
public class Assignment03YanzhangWu {

	public static void main(String[] args) {
		// declarations
		int roll = 0;
		int totalRolls = 0;
		int evenRolls = 0; // number of even rolls
		int oddRolls = 0; // number of odd rolls

		// sample the rolls
		for (int count = 0; count < 1000; count++) { // roll 1000 times
			roll = (int) (Math.random() * 16) + 1; // 16 sided dice, add 1 to get correct range
			if (roll % 2 == 0) { // integer that can be divided exactly by 2 is an even number
				evenRolls++;
			} else {
				oddRolls++;
			}
			totalRolls++;
		}

		// run a report
		System.out.println("even rolls:" + evenRolls);
		System.out.println("odd rolls:" + oddRolls);
		System.out.println("total rolls:" + totalRolls);
		System.out.println("Program by Yanzhang Wu");

	}

}
