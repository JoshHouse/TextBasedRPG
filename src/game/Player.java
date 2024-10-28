package game;

import java.util.Scanner;

public class Player extends GameChar {

	// -------------------Variables-------------------

	private Weapon equipped;
	private int mana;
	private double expThreshold;
	private int lvlMelee;
	private int lvlRanged;
	private int lvlMage;
	private int lvlRogue;
	private int lvlLuck;
	private int sklPt = 4;

	// -------------------Constructors-------------------

	/**
	 * Default Constructor
	 */
	public Player() {
		super();
		this.equipped = new Weapon();
		this.mana = 0;
		this.expThreshold = 100;
		this.lvlMelee = 1;
		this.lvlRanged = 1;
		this.lvlMage = 1;
		this.lvlRogue = 1;
		this.lvlLuck = 1;
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
			int inputExp, Weapon inputEquipped, int inputMana, int inputlvlMelee, int inputlvlRanged, int inputlvlMage,
			int inputlvlRogue, int inputlvlLuck) {

		super(inputName, inputInventory, inputCurrency, inputHealth, inputLevel, inputExp);
		this.equipped = inputEquipped;
		this.mana = inputMana;
		this.expThreshold = 100;
		for (int x = 1; x < this.level; x++) {
			this.expThreshold = expThreshold * 1.2;
		}
		this.lvlMelee = inputlvlMelee;
		this.lvlRanged = inputlvlRanged;
		this.lvlRogue = inputlvlRogue;
		this.lvlMage = inputlvlMage;
		this.lvlLuck = inputlvlLuck;
	}

	/**
	 * For creating a level 1 player only taking a name as input.
	 * 
	 * @param inputName
	 */
	public Player(String inputName) {
		super(inputName);
		this.equipped = new Weapon();
		this.mana = 100;
		this.expThreshold = 100;
		this.lvlMelee = 1;
		this.lvlRanged = 1;
		this.lvlMage = 1;
		this.lvlRogue = 1;
		this.lvlLuck = 1;

	}

	// -------------------Getters-------------------

	public Weapon getEquipped() {
		return this.equipped;
	}

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

	// -------------------Setters-------------------

	public void setEquipped(Weapon equipped) {
		this.equipped = equipped;
	}

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

		System.out.println("-----------------------YOUR PROFILE-----------------------------\n" + "Name: " + this.name
				+ "\n" + "Level: " + this.level + "\n" + "EXP till next level: " + (int) (this.expThreshold - this.exp)
				+ "\n" + "Max HP: " + this.health + "\t\t" + "Mana: " + this.mana + "\n" + "Luck: " + this.lvlLuck
				+ "\t\t" + "Money: " + this.currency + "\n" + "\t\t\t-----Levels-----\n" + "Melee Lv: " + this.lvlMelee
				+ "\t" + "Ranged Lv: " + this.lvlRanged + "\t" + "Rouge Lv: " + this.lvlRogue + "\t" + "Mage Lv: "
				+ this.lvlMage + "\n" + "----------------------------------------------------------------\n");

	}

	/**
	 * Changes the mainhand weapon of the player, based on the weapons in their
	 * inventory.
	 * 
	 * @param index - The index of the weapon in inventory.
	 */
	public void selectMainhandWeapon(int index) {

		if (this.inventory.getWeapons().get(index) != null) {
			this.equipped = this.inventory.getWeapons().get(index);
		}

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

		if (this.exp < this.expThreshold) { // The player can't level up to begin with, so it exits the method
			return;
		}

		int count = 0; // Counts the number of level ups in one call of this method

		while (this.exp >= this.expThreshold) { // Loops as long as their exp is above the threshold
			this.level++; // Increments level by one
			this.sklPt++; // Adds a skill point on each loop.
			this.exp -= (int) this.expThreshold; // Subtracts exp needed for current threshold
			this.expThreshold *= 1.2; // Increase the threshold
			count++;
		}

		if (count == 1) { // Only leveled up once in one sitting
			System.out.println("Your level has increased to " + this.level + "! You've earned a skill point!");
		} else { // Leveled up multiple times in one sitting
			System.out.println(
					"Your level has increased to " + this.level + "! You've earned " + count + " skill points!");
		}

	}

	// -------------------toString-------------------

	public String toString() {
		return super.toString() + "Luck Level: " + this.lvlLuck + "\n" + "Mana: " + this.mana + "\n"
				+ "-----Class Levels-----\n" + "Melee Level: " + this.lvlMelee + "\n" + "Ranged Level: "
				+ this.lvlRanged + "\n" + "Rogue Level: " + this.lvlRogue + "\n" + "Mage Level: " + this.lvlMage + "\n";
	}

}