package game;

import java.util.Scanner;

public class Player extends GameChar {

	/**
	 * 
	 * ----- Variables -----
	 * 
	 */

	private int lvlMelee;
	private int lvlRanged;
	private int lvlRogue;
	private int lvlMage;
	private int lvlLuck;
	private int Mana;
	private double EXPThreshold;

	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */

	// Default Constructor
	public Player() {
		super();
		this.lvlMelee = 1;
		this.lvlRanged = 1;
		this.lvlRogue = 1;
		this.lvlMage = 1;
		this.lvlLuck = 1;
		this.Mana = 0;
		this.EXPThreshold = 100;
	}

	// Constructor that instantiates all values
	public Player(String InputName, int InputHealth, int InputLevel, int InputEXP, int InputDamage, int InputDamageType,
			int InputCurrency, int InputlvlMelee, int InputlvlRanged, int InputlvlRogue,
			int InputlvlMage, int InputlvlLuck, int InputMana) {
		super(InputName, InputHealth, InputLevel, InputEXP, InputDamage, InputDamageType, InputCurrency);
		this.lvlMelee = InputlvlMelee;
		this.lvlRanged = InputlvlRanged;
		this.lvlRogue = InputlvlRogue;
		this.lvlMage = InputlvlMage;
		this.lvlLuck = InputlvlLuck;
		this.Mana = InputMana;
		this.EXPThreshold = 100;
		for (int x = 1; x < this.getLevel(); x++) {
			this.EXPThreshold = EXPThreshold * 1.2;
		}
	}

	/**
	 * 
	 * ----- Getters -----
	 * 
	 */

	public int getlvlMelee() {
		return this.lvlMelee;
	}

	public int getlvlRanged() {
		return this.lvlRanged;
	}

	public int getlvlRogue() {
		return this.lvlRogue;
	}

	public int getlvlMage() {
		return this.lvlMage;
	}

	public int getlvlLuck() {
		return this.lvlLuck;
	}

	public int getMana() {
		return this.Mana;
	}

	public double getEXPThreshold() {
		return this.EXPThreshold;
	}

	/**
	 * 
	 * ----- Setters -----
	 * 
	 */

	public void setlvlMelee(int InputlvlMelee) {
		this.lvlMelee = InputlvlMelee;
	}

	public void setlvlRanged(int InputlvlRanged) {
		this.lvlRanged = InputlvlRanged;
	}

	public void setlvlRogue(int InputlvlRogue) {
		this.lvlRogue = InputlvlRogue;
	}

	public void setlvlMage(int InputlvlMage) {
		this.lvlMage = InputlvlMage;
	}

	public void setlvlLuck(int InputlvlLuck) {
		this.lvlLuck = InputlvlLuck;
	}

	public void setMana(int InputMana) {
		this.Mana = InputMana;
	}

	public void setEXPThreshold(Double InputEXPThreshold) {
		this.EXPThreshold = InputEXPThreshold;
	}

	/**
	 * 
	 * ----- Functions -----
	 * 
	 */

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

		System.out.println("-----------------------YOUR PROFILE-----------------------------");
		System.out.println("Name: " + this.getName());
		System.out.println("Level: " + this.getLevel());
		System.out.println("EXP till next level: " + (int) (EXPThreshold - this.getEXP()) + "\n");
		System.out.println("Max HP: " + this.getHealth() + "\tMana: " + Mana + "\tLuck: " + lvlLuck + "\t\tMoney: "
				+ this.getCurrency());
		System.out.println("Melee Lv: " + lvlMelee + "\tRanged Lv: " + lvlRanged + "\t Rouge Lv: " + lvlRogue
				+ "\tMage Lv: " + lvlMage);
		System.out.println("----------------------------------------------------------------");

	}

	/**
	 * Function to level up the player. Takes the overflow EXP amount as an int
	 * value. Sets EXP to overflow amount, increments the level of the player,
	 * increases the EXPThreshold, and prompts the player to upgrade a class level
	 * with the skill point gained by the level up
	 * 
	 * @param Overflow
	 */
	public void levelUp(int Overflow) {

		this.setLevel(this.getLevel() + 1);
		this.setEXP(Overflow);
		this.EXPThreshold = this.EXPThreshold * 1.2;
		Boolean SkillPointUsed = false; // Used to ensure player doesn't waste their skill point
		Scanner Keyboard = new Scanner(System.in);

		// Original prompt for the player to choose what level they would like to
		// upgrade
		System.out.println("You have leveled up! What would you like to use your skillpoint on? \n"
				+ "1) Melee Level: Your current Melee Level is " + this.lvlMelee + "\n"
				+ "2) Ranged Level: Your current Ranged Level is " + this.lvlRanged + "\n"
				+ "3) Rogue Level: Your current Rogue Level is " + this.lvlRogue + "\n"
				+ "4) Mage Level: Your current Mage Level is " + this.lvlMage + "\n"
				+ "5) Luck Level: Your current Luck Level is " + this.lvlLuck + "\n"
				+ "Tip) To choose what you would like to level up, type either the number or class. Ex. '1' or 'melee'");

		// While loop to ensure the player uses their skill point
		while (SkillPointUsed == false) {

			String Choice = Keyboard.nextLine();
			Choice.toLowerCase(); // ensures choice is not case sensitive

			// Based on choice, increments the chosen level and prints a message with their
			// updated level. Sets
			// SkillPointUsed to true if a class level is upgraded
			switch (Choice) {
			case "1":
			case "melee": {
				this.lvlMelee++;
				System.out.println("You have upgraded your melee level. Your new melee level is: " + this.lvlMelee);
				SkillPointUsed = true;
				break;
			}
			case "2":
			case "ranged": {
				this.lvlRanged++;
				System.out.println("You have upgraded your ranged level. Your new ranged level is: " + this.lvlRanged);
				SkillPointUsed = true;
				break;
			}
			case "3":
			case "rogue": {
				this.lvlRogue++;
				System.out.println("You have upgraded your rogue level. Your new rogue level is: " + this.lvlRogue);
				SkillPointUsed = true;
				break;
			}
			case "4":
			case "mage": {
				this.lvlMage++;
				System.out.println("You have upgraded your mage level. Your new mage level is: " + this.lvlMage);
				SkillPointUsed = true;
				break;
			}
			case "5":
			case "luck": {
				this.lvlLuck++;
				System.out.println("You have upgraded your luck level. Your new luck level is: " + this.lvlLuck);
				SkillPointUsed = true;
				break;
			}
			default: // Error message for improper format. Reprints choices and takes their choice
						// again
				System.out.println(
						"Your inputted choice does not match any of the options or is not in the propper format. \n"
								+ "Your choices are: \n" + "1) Melee Level: Your current Melee Level is "
								+ this.lvlMelee + "\n" + "2) Ranged Level: Your current Ranged Level is "
								+ this.lvlRanged + "\n" + "3) Rogue Level: Your current Rogue Level is " + this.lvlRogue
								+ "\n" + "4) Mage Level: Your current Mage Level is " + this.lvlMage + "\n"
								+ "5) Luck Level: Your current Luck Level is " + this.lvlLuck + "\n"
								+ "Remember, you can either type the number or the class of your choice. Ex. '1' or 'Melee' \n"
								+ "What would you like to upgrade?");
			}
		}
		Keyboard.close();
	}

	/**
	 * 
	 * ----- ToString method -----
	 * 
	 */

	public String toString() {
		return super.toString() + "Melee Level: " + this.lvlMelee + "\n" + "Ranged Level: " + this.lvlRanged + "\n"
				+ "Rogue Level: " + this.lvlRogue + "\n" + "Mage Level: " + this.lvlMage + "\n" + "Luck Level: "
				+ this.lvlLuck + "\n" + "Mana: " + this.Mana + "\n";
	}

}