	/*
	 * Dialogue is printed using a for-loop that displays it one character at a
	 * time, and the display time is controlled by a speed variable, given when the
	 * methods are called.
	 */

	/**
	 * Prints the dialogue whenever a character is speaking, identifying them with
	 * their name at the top of each dialogue printed.
	 * 
	 * @param name  - The character's name
	 * @param text  - The dialogue to print
	 * @param speed - The speed at which each letter is printed to the console
	 */
	public static void characterDialogue(String name, String text, long speed) {

		System.out.println("[ " + name + " ]");
		for (char ch : text.toCharArray()) {
			System.out.print(ch);
			Pause.pause(speed);
		}
	}

	/**
	 * Prints regular dialogue that is not being spoken by any specific character.
	 * 
	 * @param text  - The dialogue to print
	 * @param speed - The speed at which each letter is printed to the console
	 */
	public static void infoDialogue(String text, long speed) {

		for (char ch : text.toCharArray()) {
			System.out.print(ch);
			Pause.pause(speed);
		}
	}

}