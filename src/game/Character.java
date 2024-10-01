package game;

public class Character {
	
	/**
	 * 
	 * ----- Variables -----
	 * 
	 */
	
	String Name;
	int Health;
	int Level;
	int EXP;
	int Damage;
	String DamageType;
	int Currency;
	Item[] Inventory;
	
	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */
	
	// Default Constructor
	public Character() {
		this.Name = "No Name";
		this.Health = 1;
		this.Level = 1;
		this.EXP = 0;
		this.Damage = 0;
		this.DamageType = "No Damage Type";
		this.Currency = 0;
		this.Inventory = new Item[0];
	}
	// For Instantiating Characters With All Data types
	public Character(String InputName, int InputHealth, int InputLevel, int InputEXP, int InputDamage, 
			String InputDamageType, int InputCurrency, Item[] InputInventory) {
		this.Name = InputName;
		this.Health = InputHealth;
		this.Level = InputLevel;
		this.EXP = InputEXP;
		this.Damage = InputDamage;
		this.DamageType = InputDamageType;
		this.Currency = InputCurrency;
		this.Inventory = InputInventory;
	}
	// For Instantiating EXP enemies with no inventory but that give EXP and currency
	// Takes all data types besides the Inventory array
	public Character(String InputName, int InputHealth, int InputLevel, int InputEXP, int InputDamage, 
			String InputDamageType, int InputCurrency) {
		this.Name = InputName;
		this.Health = InputHealth;
		this.Level = InputLevel;
		this.EXP = InputEXP;
		this.Damage = InputDamage;
		this.DamageType = InputDamageType;
		this.Currency = InputCurrency;
		this.Inventory = new Item[0];
	}
	// For Instantiating NPCs with only a name and inventory (for sale of items)
	public Character(String InputName, Item[] InputInventory) {
		this.Name = InputName;
		this.Health = 1;
		this.Level = 1;
		this.EXP = 0;
		this.Damage = 0;
		this.DamageType = "No Damage Type";
		this.Currency = 0;
		this.Inventory = InputInventory;
	}
	
	/**
	 * 
	 * ----- Getters -----
	 * 
	 */
	
	public String getName() {
		return this.Name;
	}
	
	public int getHealth() {
		return this.Health;
	}
	
	public int getLevel() {
		return this.Level;
	}
	
	public int getEXP() {
		return this.EXP;
	}
	
	public int getDamage() {
		return this.Damage;
	}
	
	public String getDamageType() {
		return this.DamageType;
	}
	
	public int getCurrency() {
		return this.Currency;
	}
	
	public Item[] getInventory() {
		return this.Inventory;
	}
	
	/**
	 * 
	 * ----- Setters -----
	 * 
	 */
	
	public void setName(String InputName) {
		this.Name = InputName;
	}
	
	public void setHealth(int InputHealth) {
		this.Health = InputHealth;
	}
	
	public void setLevel(int InputLevel) {
		this.Level = InputLevel;
	}
	
	public void setEXP(int InputEXP) {
		this.EXP = InputEXP;
	}
	
	public void setDamage(int InputDamage) {
		this.Damage = InputDamage;
	}
	
	public void setDamageType(String InputDamageType) {
		this.DamageType = InputDamageType;
	}
	
	public void setCurrency(int InputCurrency) {
		this.Currency = InputCurrency;
	}
	
	public void setInventory(Item[] InputInventory) {
		this.Inventory = InputInventory;
	}
	
	/**
	 * 
	 * ----- ToString method -----
	 * 
	 */
	
	public String toString() {
		
		// For loop to convert Inventory into a string
		String TempInventory = "";
		for (int x = 0; x < Inventory.length; x++) {
			TempInventory = TempInventory + Inventory[x] + "-------" + "\n";
		}
		
		return "Name: " + this.Name + "\n" +
				"Health: " + this.Health + "\n" +
				"Level: " + this.Level + "\n" +
				"EXP: " + this.EXP + "\n" +
				"Damage: " + this.Damage + "\n" +
				"Damage Type: " + this.DamageType + "\n" +
				"Currency: " + this.Currency + "\n" +
				"Inventory: " + "\n" + "-------" + "\n" + TempInventory;
	}
}