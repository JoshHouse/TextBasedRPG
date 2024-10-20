package game;

import java.util.Scanner;

public class Player extends GameChar {

	// -------------------Variables-------------------

	protected Weapon equipped;
	protected int mana;
	protected double expThreshold;
	protected int lvlMelee;
	protected int lvlRanged;
	protected int lvlMage;
	protected int lvlRogue;
	protected int lvlLuck;

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
	 * @param inputDamage
	 * @param inputDamageType
	 * @param inputEquipped
	 * @param inputMana
	 * @param inputlvlMelee
	 * @param inputlvlRanged
	 * @param inputlvlMage
	 * @param inputlvlRogue
	 * @param inputlvlLuck
	 */
	public Player(String inputName, Inventory inputInventory, int inputCurrency, int inputHealth, 
			int inputLevel, int inputExp, int inputDamage, int inputDamageType, Weapon inputEquipped, int inputMana,
			int inputlvlMelee,int inputlvlRanged, int inputlvlMage, int inputlvlRogue, int inputlvlLuck) {
		
		super(inputName, inputInventory, inputCurrency, inputHealth, inputLevel, inputExp, inputDamage, 
				inputDamageType);
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

	// -------------------Setters-------------------

	public void setEquipped(Weapon inputEquipped) {
		this.equipped = inputEquipped;
	}
	
	public void setMana(int inputMana) {
		this.mana = inputMana;
	}
	
	public void setExpThreshold(Double inputExpThreshold) {
		this.expThreshold = inputExpThreshold;
	}
	
	public void setlvlMelee(int inputlvlMelee) {
		this.lvlMelee = inputlvlMelee;
	}

	public void setlvlRanged(int inputlvlRanged) {
		this.lvlRanged = inputlvlRanged;
	}

	public void setlvlMage(int inputlvlMage) {
		this.lvlMage = inputlvlMage;
	}
	
	public void setlvlRogue(int inputlvlRogue) {
		this.lvlRogue = inputlvlRogue;
	}

	public void setlvlLuck(int inputlvlLuck) {
		this.lvlLuck = inputlvlLuck;
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

		System.out.println("-----------------------YOUR PROFILE-----------------------------\n" + 
							"Name: " + this.name + "\n" + 
							"Level: " + this.level + "\n" +
							"EXP till next level: " + (int) (this.expThreshold - this.exp) + "\n" +
							"Max HP: " + this.health + "\n" + 
							"Mana: " + this.mana + "\n" + 
							"Luck: " + this.lvlLuck + "\n" + 
							"Money: "+ this.currency + "\n" + 
							"-----Levels-----\n" +
							"Melee Lv: " + this.lvlMelee + "\n" + 
							"Ranged Lv: " + this.lvlRanged + "\n" + 
							"Rouge Lv: " + this.lvlRogue + "\n" + 
							"Mage Lv: " + this.lvlMage + "\n" +
							"----------------------------------------------------------------\n");

	}

	/**
	 * Changes the mainhand weapon of the player, based on the weapons in their inventory.
	 * @param index - The index of the weapon in inventory.
	 */
	public void selectMainhandWeapon(int index) {

		if (this.inventory.getWeapons().get(index) != null) {
			this.equipped = this.inventory.getWeapons().get(index);
		}

	}

	/**
	 * Function to level up the player. Takes the overflow EXP amount as an int
	 * value. Sets EXP to overflow amount, increments the level of the player,
	 * increases the EXPThreshold, and prompts the player to upgrade a class level
	 * with the skill point gained by the level up
	 * 
	 * @param Overflow
	 */
	public void levelUp(int overflow) {

		this.level = this.level + 1;
		this.exp = overflow;
		this.expThreshold = this.expThreshold * 1.2;
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

			String choice = Keyboard.nextLine();
			choice.toLowerCase(); // ensures choice is not case sensitive

			// Based on choice, increments the chosen level and prints a message with their
			// updated level. Sets
			// SkillPointUsed to true if a class level is upgraded
			switch (choice) {
			case "1", "melee": {
				this.lvlMelee++;
				System.out.println("You have upgraded your melee level. Your new melee level is: " + this.lvlMelee);
				SkillPointUsed = true;
				break;
			}
			case "2", "ranged": {
				this.lvlRanged++;
				System.out.println("You have upgraded your ranged level. Your new ranged level is: " + this.lvlRanged);
				SkillPointUsed = true;
				break;
			}
			case "3", "rogue": {
				this.lvlRogue++;
				System.out.println("You have upgraded your rogue level. Your new rogue level is: " + this.lvlRogue);
				SkillPointUsed = true;
				break;
			}
			case "4", "mage": {
				this.lvlMage++;
				System.out.println("You have upgraded your mage level. Your new mage level is: " + this.lvlMage);
				SkillPointUsed = true;
				break;
			}
			case "5", "luck": {
				this.lvlLuck++;
				System.out.println("You have upgraded your luck level. Your new luck level is: " + this.lvlLuck);
				SkillPointUsed = true;
				break;
			}
			default: // Error message for improper format. Reprints choices and takes their choice
						// again
				System.out.println("Your inputted choice does not match any of the options or is not in the propper format. \n" + 
									"Your choices are: \n" + 
									"1) Melee Level: Your current Melee Level is " + this.lvlMelee + "\n" + 
									"2) Ranged Level: Your current Ranged Level is " + this.lvlRanged + "\n" + 
									"3) Rogue Level: Your current Rogue Level is " + this.lvlRogue + "\n" + 
									"4) Mage Level: Your current Mage Level is " + this.lvlMage + "\n" + 
									"5) Luck Level: Your current Luck Level is " + this.lvlLuck + "\n" + 
									"Remember, you can either type the number or the class of your choice. Ex. '1' or 'Melee' \n"+ 
									"What would you like to upgrade?");
			}
		}
		Keyboard.close();
	}

	// -------------------toString-------------------

	public String toString() {
		return super.toString() + 
				"Luck Level: " + this.lvlLuck + "\n" + 
				"Mana: " + this.mana + "\n" +
				"-----Class Levels-----\n" + 
				"Melee Level: " + this.lvlMelee + "\n" + 
				"Ranged Level: " + this.lvlRanged + "\n" + 
				"Rogue Level: " + this.lvlRogue + "\n" + 
				"Mage Level: " + this.lvlMage + "\n";
	}

}