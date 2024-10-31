package game;

import java.io.IOException;

public class Pause {
	
	/**
	 * Pauses console till the user presses the enter key.
	 */
	public void pause() {

		System.out.println("Press \"ENTER\" to continue...");

		try {
			System.in.read(new byte[2]);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Pauses console for a set number of milliseconds.
	 * 
	 * @param time - The number of milliseconds to sleep.
	 */
	public void pause(long time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
