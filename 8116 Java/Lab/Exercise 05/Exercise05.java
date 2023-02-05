/*
 * Author: Stanley Pieda
 * Date: March 16, 2022
 * Modified by: Yanzhang Wu	
 * Modified Date: 2022-07-29
 * Due Date: 2022-08-05
 * Description: Starter Code / Sample Solution Exercise 05
 * Starter Code Note: Use the pseudocode and complete the main method
 */

/*
 * This class only contains method main, to drive the application.
 */
public class Exercise05 {
 
	/*
	 * Program will run do loop once before the user chooses to play the game again
	 * or not. 
	 * When user choose to play again, user needs to enter "Y" or "y", then
	 * the program goes into the do loop. 
	 * When user choose to end the game, user needs to enter "N" or "n", then the 
	 * program outputs my name and ends. 
	 * The do loop verifies shouldContinue first, if shouldContinue = "Y", program calls
	 * game.reset(). Then it calls game.run() and the final step is to let the user
	 * choose to play game again.
	 */
	public static void main(String[] args) {

		User user = new User();

		HighLowGame game = new HighLowGame();

		String CONTINUE_GAME = "Y";
		String EXIT_GAME = "N";
		String shouldContinue = EXIT_GAME;

		do {
			if (shouldContinue.equalsIgnoreCase(CONTINUE_GAME)) {
				game.reset();
			}
			game.run();
			shouldContinue = user.inputString("Would you like to play again? (Y/N)");

		} while (shouldContinue.equalsIgnoreCase(CONTINUE_GAME));

		System.out.println("Program by Yanzhang Wu");

	}
}
