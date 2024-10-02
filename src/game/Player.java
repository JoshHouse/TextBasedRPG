package game;
import java.util.Scanner;

public class Player extends Character {
	
	/**
	 * 
	 * ----- Variables -----
	 * 
	 */
	
	int Meleelvl;
	int Rangedlvl;
	int Roguelvl;
	int Magelvl;
	int Lucklvl;
	int Mana;
	double EXPThreshold;
	
	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */
	
	// Default Constructor
	public Player() {
		super();
		this.Meleelvl = 1;
		this.Rangedlvl = 1;
		this.Roguelvl = 1;
		this.Magelvl = 1;
		this.Lucklvl = 1;
		this.Mana = 0;
		this.EXPThreshold = 100;
	}
	
	// Constructor that instantiates all values
	public Player(String InputName, int InputHealth, int InputLevel, int InputEXP, int InputDamage, 
			String InputDamageType, int InputCurrency, Item[] InputInventory, int InputMeleelvl,
			int InputRangedlvl, int InputRoguelvl, int InputMagelvl, int InputLucklvl, int InputMana) 
	{
		super(InputName, InputHealth, InputLevel, InputEXP, InputDamage, InputDamageType, InputCurrency,
				InputInventory);
		this.Meleelvl = InputMeleelvl;
		this.Rangedlvl = InputRangedlvl;
		this.Roguelvl = InputRoguelvl;
		this.Magelvl = InputMagelvl;
		this.Lucklvl = InputLucklvl;
		this.Mana = InputMana;
		this.EXPThreshold = 100;
		for(int x = 1; x < this.Level; x++) {
			this.EXPThreshold = EXPThreshold * 1.2;
		}
	}
	
	/**
	 * 
	 * ----- Getters -----
	 * 
	 */
	
	public int getMeleelvl() {
		return this.Meleelvl;
	}
	
	public int getRangedlvl() {
		return this.Rangedlvl;
	}
	
	public int getRoguelvl() {
		return this.Roguelvl;
	}
	
	public int getMagelvl() {
		return this.Magelvl;
	}
	
	public int getLucklvl() {
		return this.Lucklvl;
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
	
	public void setMeleelvl(int InputMeleelvl) {
		this.Meleelvl = InputMeleelvl;
	}
	
	public void setRangedlvl(int InputRangedlvl) {
		this.Rangedlvl = InputRangedlvl;
	}
	
	public void setRoguelvl(int InputRoguelvl) {
		this.Roguelvl = InputRoguelvl;
	}
	
	public void setMagelvl(int InputMagelvl) {
		this.Magelvl = InputMagelvl;
	}
	
	public void setLucklvl(int InputLucklvl) {
		this.Lucklvl = InputLucklvl;
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
	
	// Function to level up the player. Takes the overflow EXP amount as an int value. Sets EXP to overflow amount,
	// increments the level of the player, increases the EXPThreshold, and prompts the player to upgrade a class
	// level with the skill point gained by the level up
	public void levelUp(int Overflow) {
		
		this.Level++;
		this.EXP = Overflow;
		this.EXPThreshold = this.EXPThreshold * 1.2;
		Boolean SkillPointUsed = false;					// Used to ensure player doesn't waste their skill point
		Scanner Keyboard = new Scanner(System.in);
		
		// Original prompt for the player to choose what level they would like to upgrade
		System.out.println("You have leveled up! What would you like to use your skillpoint on? \n"
				+ "1) Melee Level: Your current Melee Level is " + this.Meleelvl + "\n"
				+ "2) Ranged Level: Your current Ranged Level is " + this.Rangedlvl + "\n"
				+ "3) Rogue Level: Your current Rogue Level is " + this.Roguelvl + "\n"
				+ "4) Mage Level: Your current Mage Level is " + this.Magelvl + "\n"
				+ "5) Luck Level: Your current Luck Level is " + this.Lucklvl + "\n"
				+ "Tip) To choose what you would like to level up, type either the number or class. Ex. '1' or 'melee'");
		
		// While loop to ensure the player uses their skill point
		while (SkillPointUsed == false) {
			
			String Choice = Keyboard.nextLine();
			Choice.toLowerCase();		//ensures choice is not case sensitive
			
			// Based on choice, increments the chosen level and prints a message with their updated level. Sets 
			// SkillPointUsed to true if a class level is upgraded
			switch(Choice) {
			case "1":
			case "melee": {
				this.Meleelvl++;
				System.out.println("You have upgraded your melee level. Your new melee level is: " + this.Meleelvl);
				SkillPointUsed = true;
				break;
			}
			case "2":
			case "ranged": {
				this.Rangedlvl++;
				System.out.println("You have upgraded your ranged level. Your new ranged level is: " + this.Rangedlvl);
				SkillPointUsed = true;
				break;
			}
			case "3":
			case "rogue": {
				this.Roguelvl++;
				System.out.println("You have upgraded your rogue level. Your new rogue level is: " + this.Roguelvl);
				SkillPointUsed = true;
				break;
			}
			case "4":
			case "mage": {
				this.Magelvl++;
				System.out.println("You have upgraded your mage level. Your new mage level is: " + this.Magelvl);
				SkillPointUsed = true;
				break;
			}
			case "5":
			case "luck": {
				this.Lucklvl++;
				System.out.println("You have upgraded your luck level. Your new luck level is: " + this.Lucklvl);
				SkillPointUsed = true;
				break;
			}
			default: 		// Error message for improper format. Reprints choices and takes their choice again
				System.out.println("Your inputted choice does not match any of the options or is not in the propper format. \n"
						+ "Your choices are: \n"
						+ "1) Melee Level: Your current Melee Level is " + this.Meleelvl + "\n"
						+ "2) Ranged Level: Your current Ranged Level is " + this.Rangedlvl + "\n"
						+ "3) Rogue Level: Your current Rogue Level is " + this.Roguelvl + "\n"
						+ "4) Mage Level: Your current Mage Level is " + this.Magelvl + "\n"
						+ "5) Luck Level: Your current Luck Level is " + this.Lucklvl + "\n"
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
		return super.toString() +
				"Melee Level: " + this.Meleelvl + "\n" +
				"Ranged Level: " + this.Rangedlvl + "\n" +
				"Rogue Level: " + this.Roguelvl + "\n" +
				"Mage Level: " + this.Magelvl + "\n" +
				"Luck Level: " + this.Lucklvl + "\n" +
				"Mana: " + this.Mana + "\n";
	}
	
}