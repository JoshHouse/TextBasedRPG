package game;

import java.util.Random;

public class Luck {

	private static Random rand = new Random(); // Create a random object.

	/**
	 * Set the max value for luckEvent to 101 because the counting for random
	 * numbers staets at 0. Setting it to 101 tells the random variable to get a
	 * number between 0 and 100, which is a tital of 101 possible choices
	 */
	private static final int MAX = 101;

	/**
	 * Performs a luck based event by calculating a random number between 0 and 100,
	 * then comparing it to the luck variable provided in its input.
	 * 
	 * @param baseLuck - The user's base luck status.
	 * @return If the generated number is lower or equal to the provided luck
	 *         integer, return true. If it is greater, return false
	 */
	public static boolean luckEvent(int baseLuck) {

		int luckyNumber = rand.nextInt(MAX); // Generates a random number between 0 and 100.

		// Determine which is higher, baseLuck or luckyNumber.
		if (baseLuck >= luckyNumber) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Returns a random integer within the range provided on function call.
	 * 
	 * @param range - The range that an integer can be generated. The generated
	 *              numbers will always be from 0 to range - 1.
	 * @return
	 */
	public static int getRandNum(int range) {

		return rand.nextInt(range);

	}

}
