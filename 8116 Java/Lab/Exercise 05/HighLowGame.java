/*
 * Author: Stanley Pieda
 * Date: March 16, 2022
 * Modified by: Yanzhang Wu
 * Modified Date: 2022-07-29
 * Due Date: 2022-08-05
 * Description: Starter Code / Sample Solution Exercise 05
 * Starter Code Note: Use the pseudocode and complete the reset and run methods
 */

import java.util.Random;

/*
 * Supervisor wants a comment here overviewing the class
 */
public class HighLowGame {
	private User user = new User(); // internal only, no get/set
	private Random random = new Random(); // internal only, no get/set
	private int fuelAvailable;
	private int numberToGuess;
	private static final int MIN = 1; // internal only, no get/set
	private static final int MAX = 10; // internal only, no get/set

	/*
	 * No argument constructor, calls method reset to initialize the game
	 */
	public HighLowGame() {
		reset();
	}

	/*
	 * Accessor for fuelAvailable
	 */
	public int getFuelAvailable() {
		return fuelAvailable;
	}

	/*
	 * Mutator for fuelAvailable
	 */
	public void setFuelAvailable(int fuelAvailable) {
		this.fuelAvailable = fuelAvailable;
	}

	/*
	 * Access for numberToGuess
	 */
	public int getNumberToGuess() {
		return numberToGuess;
	}

	/*
	 * Mutator for numberToGuess
	 */
	public void setNumberToGuess(int numberToGuess) {
		this.numberToGuess = numberToGuess;
	}

	/*
	 * This method resets the game. At first, it creates a new number to guess Then
	 * it calculate the sum from 1 to 10 and the fuel is sum / 2
	 */
	public void reset() {
		int sum = 0;
		// random.nextInt(MAX) returns a value from 0 to (MAX - 1)
		// so add 1 to get a number between 1 to MAX inclusive
		numberToGuess = random.nextInt(MAX) + 1;

		for (int value = MIN; value <= MAX; value++) {
			sum = sum + value;
		}
		fuelAvailable = sum / 2;
		return;

	}

	/*
	 * When fuelAvailable > 0 and isWon == false, this method receives user's input
	 * and for each input, guessCount + 1. And fuelAvailable is fuelAvailable minus
	 * the number of user entered. If fuelAvailable < 0, the program keeps this play
	 * but set fuelAvailable to 0. For each input, the entered number will be passed
	 * to checkGuessResult and variable isWon and message will be updated by
	 * checkGuessResult.isWin() and checkGuessResult.getMessage(). Then the message
	 * will be printed out. When fuelAvailable <= 0 or isWon == true, the program
	 * will jump out of the while loop. message will be updated by
	 * reportGameResult(isWon, guessCount) and be printed out.
	 */
	public void run() {
		CheckGuessResult checkGuessResult = null;
		String message;
		boolean isWon = false;
		int guessCount = 0;
		int userNumber;

		System.out.println("Guess the number from " + MIN + " to " + MAX);
		System.out.println("You have " + fuelAvailable + " guess-fuel remaining.");

		while (fuelAvailable > 0 && isWon == false) {
			guessCount = guessCount + 1;
			userNumber = user.inputInteger("guess: ");

			// first loop control variable adjustment
			fuelAvailable = fuelAvailable - userNumber;
			// let them have this last play, but prevent negative
			// fuel values in the output
			if (fuelAvailable < 0) {
				fuelAvailable = 0;
			}

			checkGuessResult = checkGuess(userNumber);

			// second loop control variable adjustment
			isWon = checkGuessResult.isWin();
			message = checkGuessResult.getMessage();
			System.out.println(message);

		}
		message = reportGameResult(isWon, guessCount);
		System.out.println(message);// after game report

		return;

	}

	/*
	 * This method examines the guess to see if it matches the numberToGuess value.
	 * To report win or no-win, with a message as well a CheckGuessResult instance
	 * is created with these results, and the reference to the CheckGuessResult
	 * object is returned.
	 */
	private CheckGuessResult checkGuess(int guess) {
		boolean isWin = false;
		String message;

		if (guess == numberToGuess) {
			message = "You guessed the number";
			isWin = true;
		} else {
			if (guess < numberToGuess) {
				message = "too low, ";
			} else {
				message = "too high, ";
			}
			message = message + String.format("%d guess-fuel remaining", fuelAvailable);
		}
		CheckGuessResult checkGuessResult = new CheckGuessResult(message, isWin);
		return checkGuessResult;
	}

	/*
	 * This method writes out a final result of the game (win or lose) as well as
	 * the number of guesses used by the player (i.e. the user).
	 */
	private String reportGameResult(boolean isWon, int guessCount) {
		String message;
		if (isWon) {
			message = "You win! It took you ";
		} else {
			message = "You did not win, you used ";
		}
		message = String.format(message + "%d guesses", guessCount);
		return message;
	}
}
