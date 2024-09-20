package game;

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
	}
	
	/**
	 * 
	 * ----- Getters -----
	 * 
	 */
	
	public int GetMeleelvl() {
		return this.Meleelvl;
	}
	
	public int GetRangedlvl() {
		return this.Rangedlvl;
	}
	
	public int GetRoguelvl() {
		return this.Roguelvl;
	}
	
	public int GetMagelvl() {
		return this.Magelvl;
	}
	
	public int GetLucklvl() {
		return this.Lucklvl;
	}
	
	public int GetMana() {
		return this.Mana;
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