package game;

public class Enemy extends Character{
	
	/**
	 * 
	 * ----- Variables -----
	 * 
	 */
	
	String SpecialAttack;
	int SpecialAttackMultiplier;
	
	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */
	
	// Default Constructor
	public Enemy() {
		super();
		this.SpecialAttack = "No Special Attack";
		this.SpecialAttackMultiplier = 1;
	}
	
	// Constructor that instantiates all values
	public Enemy(String InputName, int InputHealth, int InputLevel, int InputEXP, int InputDamage, 
			int InputDamageType, int InputCurrency, Item[] InputInventory, String InputSpecialAttack,
			int InputSpecialAttackMultiplier) 
	{
		super(InputName, InputHealth, InputLevel, InputEXP, InputDamage, InputDamageType, InputCurrency,
				InputInventory);
		this.SpecialAttack = InputSpecialAttack;
		this.SpecialAttackMultiplier = InputSpecialAttackMultiplier;
	}
	
	// For Instantiating EXP enemies with no inventory but that give EXP and currency and have a special attack
	// Takes all data types besides the Inventory array
	public Enemy(String InputName, int InputHealth, int InputLevel, int InputEXP, int InputDamage, 
			int InputDamageType, int InputCurrency, String InputSpecialAttack, int InputSpecialAttackMultiplier) {
		super(InputName, InputHealth, InputLevel, InputEXP, InputDamage, InputDamageType, InputCurrency);
		this.SpecialAttack = InputSpecialAttack;
		this.SpecialAttackMultiplier = InputSpecialAttackMultiplier;
	}
	
	// For Instantiating EXP enemies with no inventory but that give EXP and currency but don't have a special attack
	// Takes all data types besides the Inventory array, Special Attack string, and special attack multiplier
	public Enemy(String InputName, int InputHealth, int InputLevel, int InputEXP, int InputDamage, 
			int InputDamageType, int InputCurrency) {
		super(InputName, InputHealth, InputLevel, InputEXP, InputDamage, InputDamageType, InputCurrency);
		this.SpecialAttack = "No Special Attack";
		this.SpecialAttackMultiplier = 1;
	}
	
	/**
	 * 
	 * ----- Getters ------
	 * 
	 */
	
	public String getSpecialAttack() {
		return this.SpecialAttack;
	}
	
	public int getSpecialAttackMultipler() {
		return this.SpecialAttackMultiplier;
	}
	
	/**
	 * 
	 * ----- Setters -----
	 * 
	 */
	
	public void setSpecialAttack(String InputSpecialAttack) {
		this.SpecialAttack = InputSpecialAttack;
	}
	
	public void setSpecialAttackMultiplier(int InputSpecialAttackMultiplier) {
		this.SpecialAttackMultiplier = InputSpecialAttackMultiplier;
	}
	
	/**
	 * 
	 * ----- ToString method -----
	 * 
	 */
	
	public String toString() {
		return super.toString() +
				"Special Attack: " + this.SpecialAttack + "\n" +
				"Special Attack Multiplier: " + this.SpecialAttackMultiplier + "\n";
	}
}