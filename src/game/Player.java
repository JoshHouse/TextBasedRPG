package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends GameChar {

	// -------------------Variables-------------------

	private int mana;
	private double expThreshold;
	private int lvlMelee;
	private int lvlRanged;
	private int lvlMage;
	private int lvlRogue;
	private int lvlLuck;
	private int sklPt = 4;
	private int currHP; // Current HP. Used for battles.

	// -------------------Constructors-------------------

	/**
	 * Default Constructor
	 */
	public Player() {
		super();
		this.mana = 0;
		this.expThreshold = 100;
		this.lvlMelee = 1;
		this.lvlRanged = 1;
		this.lvlMage = 1;
		this.lvlRogue = 1;
		this.lvlLuck = 1;
		this.currHP = this.getHealth();
	}

	/**
	 * Used to instantiate a new character object with all pre-set values
	 * 
	 * @param inputName
	 * @param inputInventory
	 * @param inputCurrency
	 * @param inputHealth
	 * @param inputLevel
	 * @param inputExp
	 * @param inputEquipped
	 * @param inputMana
	 * @param inputlvlMelee
	 * @param inputlvlRanged
	 * @param inputlvlMage
	 * @param inputlvlRogue
	 * @param inputlvlLuck
	 */
	public Player(String inputName, Inventory inputInventory, int inputCurrency, int inputHealth, int inputLevel,
			int inputExp, int inputMana, int inputlvlMelee, int inputlvlRanged, int inputlvlMage, int inputlvlRogue,
			int inputlvlLuck) {

		super(inputName, inputInventory, inputCurrency, inputHealth, inputLevel, inputExp);
		this.mana = inputMana;
		this.expThreshold = 100;
		for (int x = 1; x < this.getLevel(); x++) {
			this.expThreshold *= 1.2;
		}
		this.lvlMelee = inputlvlMelee;
		this.lvlRanged = inputlvlRanged;
		this.lvlRogue = inputlvlRogue;
		this.lvlMage = inputlvlMage;
		this.lvlLuck = inputlvlLuck;
		this.currHP = this.getHealth();
	}

	/**
	 * For creating a level 1 player only taking a name as input.
	 * 
	 * @param inputName
	 */
	public Player(String inputName) {
		super(inputName);
		this.mana = 100;
		this.expThreshold = 100;
		this.lvlMelee = 1;
		this.lvlRanged = 1;
		this.lvlMage = 1;
		this.lvlRogue = 1;
		this.lvlLuck = 1;
		this.currHP = this.getHealth();

	}

	// -------------------Getters-------------------

	public int getMana() {
		return this.mana;
	}

	public double getExpThreshold() {
		return this.expThreshold;
	}

	public int getlvlMelee() {
		return this.lvlMelee;
	}

	public int getlvlRanged() {
		return this.lvlRanged;
	}

	public int getlvlMage() {
		return this.lvlMage;
	}

	public int getlvlRogue() {
		return this.lvlRogue;
	}

	public int getlvlLuck() {
		return this.lvlLuck;
	}

	public int getSklPt() {
		return this.sklPt;
	}

	public int getCurrHP() {
		return this.currHP;
	}

	// -------------------Setters-------------------

	public void setMana(int mana) {
		this.mana = mana;
	}

	public void setExpThreshold(Double expThreshold) {
		this.expThreshold = expThreshold;
	}

	public void setlvlMelee(int lvlMelee) {
		this.lvlMelee = lvlMelee;
	}

	public void setlvlRanged(int lvlRanged) {
		this.lvlRanged = lvlRanged;
	}

	public void setlvlMage(int lvlMage) {
		this.lvlMage = lvlMage;
	}

	public void setlvlRogue(int lvlRogue) {
		this.lvlRogue = lvlRogue;
	}

	public void setlvlLuck(int lvlLuck) {
		this.lvlLuck = lvlLuck;
	}

	public void setSklPt(int sklPt) {
		this.sklPt = sklPt;
	}

	public void setCurrHP(int currHP) {
		this.currHP = currHP;
	}

	// -------------------Functions-------------------

	/**
	 * A basic profile that will be displayed to the player from the main menu. It
	 * contains the player's name, their level, the amount of EXP needed in order to
	 * level up, and their stats (health, mana, luck, currency, melee, ranged,
	 * rogue, mage).
	 * 
	 * The profile is all text that will be printed out when the function is called.
	 * It accepts no values and returns no value. Any variables used can be accessed
	 * within the Player class.
	 */
	public void profile() {

		System.out.println("-----------------------YOUR PROFILE-----------------------------\nName: " + this.getName()
				+ "\nLevel: " + this.getLevel() + "\nEXP till next level: " + (int) (this.expThreshold - this.getExp())
				+ "\nMax HP: " + this.getHealth() + "\t\tMana: " + this.mana + "\nLuck: " + this.lvlLuck
				+ "\t\t\tMoney: " + this.getCurrency() + "\n\t\t\t-----Levels-----\n" + "Melee Lv: " + this.lvlMelee
				+ "\tRanged Lv: " + this.lvlRanged + "\tRouge Lv: " + this.lvlRogue + "\tMage Lv: " + this.lvlMage
				+ "\nEquipped Weapon: " + this.getInventory().getWeapons().getFirst().getName()
				+ "\n----------------------------------------------------------------\n");

	}

	/**
	 * Helper method used to print out the player's inventories. If the player is
	 * calling this function via selectMainhandWeapon(), the first item in the array
	 * of weapons will be omitted, as that is the currently equipped weapon.
	 * 
	 * @param key    - Tells the method with array to print out; the consumable or
	 *               the weapon array.
	 * @param start  - Tells the method what position in the array to start printing
	 *               from.
	 * @param arrlen - Tells the method what the max length of the array it will be
	 *               printing is.
	 */
	private void printInventory(char key, int start, int arrlen) {

		String query; // String to be sent to the dialogue class.

		switch (key) {

		case 'c':
			// Loop through the array and print out the names of each consumable.
			for (int i = start; i < arrlen; i++) {
				query = (i + 1) + ") " + this.getInventory().getConsumables().get(i).getName();
				Dialogue.infoDialogue(query, 6);
				if ((i + 1) % 3 == 0) {
					System.out.print("\n");
				} else {
					System.out.print("\t\t");
				}
			}

			query = (arrlen + 1) + ") Cancel\nYour Choice: "; // Cancel option
			Dialogue.infoDialogue(query, 6);
			break;
		case 'w':
			// Loop through the array and print out the names of each weapon.
			for (int i = start; i < arrlen; i++) {
				if (start == 0) { // Prints the inventory regularly.
					query = (i + 1) + ") " + this.getInventory().getWeapons().get(i).getName();
					Dialogue.infoDialogue(query, 6);
					if ((i + 1) % 3 == 0) {
						System.out.print("\n");
					} else {
						System.out.print("\t\t");
					}
				} else { // Omits the first item in the inventory. Used for selectMainhandWeapon().
					query = i + ") " + this.getInventory().getWeapons().get(i).getName();
					Dialogue.infoDialogue(query, 6);
					if (i % 3 == 0) {
						System.out.print("\n");
					} else {
						System.out.print("\t\t");
					}
				}

			}

			// Cancel option
			if (start == 0) {
				query = (arrlen + 1) + ") Cancel\nYour Choice: ";
			} else {
				query = arrlen + ") Cancel\nYour Choice: ";
			}
			Dialogue.infoDialogue(query, 6);
			break;
		default:
			System.err.println("Error with displaying the array: Invalid Key.");
			break;

		}

	}

	/**
	 * Allows the player to view their inventories. The player will be either taken
	 * to their inventory of weapons or consumables, and can get more information
	 * about each item while viewing them.
	 * 
	 * @param key - Determines which inventory the player has decided to open.
	 * @param scn - Scanner object
	 */
	public void showInventory(char key, Scanner scn) {

		int arrlen, input;
		boolean viewing = true;

		switch (key) { // Using the key, we determine with inventory to view.

		case 'c':

			// Leave the inventory if there are no consumables.
			if (this.getInventory().getConsumables().isEmpty()) {
				System.out.println("---You have no consumables.---");
				viewing = false;
				Pause.pause();
			} else {
				Dialogue.infoDialogue("Type the number to read more about the item, or to return to the menu.\n", 6);
			}

			while (viewing) {

				arrlen = this.getInventory().getConsumables().size(); // Get the array's size
				this.printInventory(key, 0, arrlen); // Call the helper method to display the array.

				// Tries user input, and catches two exceptions
				try {
					input = scn.nextInt();

					if (input == arrlen + 1) {
						viewing = false;
					} else {
						this.getInventory().getConsumables().get(input - 1).displayInfo();
						Pause.pause();
					}

				} catch (IndexOutOfBoundsException | InputMismatchException e) {
					System.err.println("[---Invalid Option. Try Again.--]\n");
					Pause.pause(350);
					scn.nextLine(); // Prevents scanner from re-reading the invalid input.
				}
			}

			break;
		case 'w':

			Dialogue.infoDialogue("Type the number to read more about the weapon, or to return to the menu.\n", 6);

			while (viewing) {

				arrlen = this.getInventory().getWeapons().size(); // Get the array's size

				this.printInventory(key, 0, arrlen); // Call the helper method to display the array.

				// Tries user input, and catches two exceptions
				try {
					input = scn.nextInt();

					if (input == arrlen + 1) {
						viewing = false;
					} else {
						this.getInventory().getWeapons().get(input - 1).displayInfo();
						Pause.pause();
					}

				} catch (IndexOutOfBoundsException | InputMismatchException e) {
					System.err.println("[---Invalid Option. Try Again.--]\n");
					Pause.pause(350);
					scn.nextLine(); // Prevents scanner from re-reading the invalid input.
				}
			}
			break;
		default:
			System.err.println("There was an error.\nThe wrong key has been provided.");
			return;

		}

	}

	/**
	 * Changes the mainhand weapon of the player, based on the weapons in their
	 * inventory.
	 * 
	 * @param scn - Scanner object
	 */
	public void selectMainhandWeapon(Scanner scn) {

		int index = 0, arrlen = this.getInventory().getWeapons().size();
		boolean selecting = true;

		Dialogue.infoDialogue("\nSelect the weapon you want to equip.\n", 10);

		while (selecting) {

			this.printInventory('w', 1, arrlen); // Call the helper method to display the array.

			// Tries user input, and catches two exceptions
			try {
				index = scn.nextInt();

				if (index == arrlen) {
					selecting = false;
				} else {

					if (this.getInventory().getWeapons().get(index) != null) {

						Weapon temp = this.getInventory().getWeapons().get(index);
						Weapon first = this.getInventory().getWeapons().getFirst();
						this.getInventory().getWeapons().set(0, temp);
						this.getInventory().getWeapons().set(index, first);

						Dialogue.infoDialogue(temp.getName() + " has been equipped.\n\n", 10);

					}

					selecting = false;
				}

			} catch (IndexOutOfBoundsException | InputMismatchException e) {
				System.err.println("[---Invalid Option. Try Again.--]\n");
				Pause.pause(350);
				scn.nextLine(); // Prevents scanner from re-reading the invalid input.
			}

		}

		Pause.pause();

	}

	/**
	 * A void method that allows the player to spend skill points to upgrade their
	 * various stats. Each level up lets the player earn a skill point, which can be
	 * spent here to upgrade stats, one point at a time. However, the method exits
	 * immediately if the player runs out of skill points, or they attempt to spend
	 * non-existent skill points.
	 * 
	 * @param scn - The scanner object. Used for handling user input within the
	 *            method.
	 */
	public void increaseStats(Scanner scn) {

		String input; // Holds user input

		if (this.sklPt <= 0) { // Exit the method if it is called when there's no skill points
			System.out.println("You don't have any skill points to use.");
			Pause.pause(500);
			return;
		}

		while (this.sklPt > 0) { // Allow user to keep spending till their skill points are gone, or they cancel

			// Menu
			System.out.println("-----------------------------------");
			System.out.println("Available Skill Points: " + this.sklPt);
			System.out.println("Which stat do you want to level up?\n");
			System.out.println("1) Melee (Lvl: " + this.lvlMelee + ")");
			System.out.println("2) Ranged (Lvl: " + this.lvlRanged + ")");
			System.out.println("3) Rogue (Lvl: " + this.lvlRogue + ")");
			System.out.println("4) Mage (Lvl: " + this.lvlMage + ")");
			System.out.println("5) Luck (Lvl: " + this.lvlLuck + ")");
			System.out.println("6) Cancel\n");
			System.out.println("-----------------------------------");

			System.out.print("Type the number or the name of the stat: ");
			input = scn.nextLine();
			input = input.toLowerCase(); // Convert any letters to lower case

			switch (input) {

			case "1", "melee":
				this.lvlMelee++;
				this.sklPt--;
				break;
			case "2", "ranged":
				this.lvlRanged++;
				this.sklPt--;
				break;
			case "3", "rogue":
				this.lvlRogue++;
				this.sklPt--;
				break;
			case "4", "mage":
				this.lvlMage++;
				this.sklPt--;
				break;
			case "5", "luck":
				this.lvlLuck++;
				this.sklPt--;
				break;
			case "6", "cancel": // Cancels spending and exits the method
				return;
			default:
				System.out.println("Invalid Input\n");
				break;

			}
		}

	}

	/**
	 * Void method to handle the player leveling up, and increase the exp needed to
	 * level up. It also adds 1 skill point per level up for the player to use when
	 * they are ready.
	 */
	public void lvlUp() {

		if (this.getExp() < this.expThreshold) { // The player can't level up to begin with, so it exits the method
			return;
		}

		int count = 0; // Counts the number of level ups in one call of this method

		while (this.getExp() >= this.expThreshold) { // Loops as long as their exp is above the threshold
			this.setLevel(this.getLevel() + 1); // Increments level by one
			setHealth(getHealth() + (int) (getHealth() * 0.2)); // Increase health
			mana += (int) (mana * 0.2); // Increase mana
			this.sklPt++; // Adds a skill point on each loop.
			this.setExp(this.getExp() - (int) this.expThreshold); // Subtracts exp needed for current threshold
			this.expThreshold *= 1.2; // Increase the threshold
			count++;
		}

		if (count == 1) { // Only leveled up once in one sitting
			System.out.println("Your level has increased to " + this.getLevel() + "! You've earned a skill point!");
		} else { // Leveled up multiple times in one sitting
			System.out.println(
					"Your level has increased to " + this.getLevel() + "! You've earned " + count + " skill points!");
		}

	}

	// -------------------toString-------------------

	public String toString() {
		return super.toString() + "Luck Level: " + this.lvlLuck + "\n" + "Mana: " + this.mana + "\n"
				+ "-----Class Levels-----\n" + "Melee Level: " + this.lvlMelee + "\n" + "Ranged Level: "
				+ this.lvlRanged + "\n" + "Rogue Level: " + this.lvlRogue + "\n" + "Mage Level: " + this.lvlMage + "\n";
	}

}