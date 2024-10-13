package game;

import java.util.ArrayList;

public class GameChar {
	
	/**
	 * 
	 * ----- Variables -----
	 * 
	 */
	
	private String Name;
	private int Health;
	private int Level;
	private int EXP;
	private int Damage;
	private String DamageType;
	private int Currency;
	private ArrayList<Item> Inventory = new ArrayList<Item>();
	
	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */
	
	/** Default Constructor
	 * 
	 */
	public GameChar() {
		this.Name = "No Name";
		this.Health = 1;
		this.Level = 1;
		this.EXP = 0;
		this.Damage = 0;
		this.DamageType = this.SetDamageType(0);
		this.Currency = 0;
	}
	/** For Instantiating Characters With All Data types
	 * 
	 * @param InputName
	 * @param InputHealth
	 * @param InputLevel
	 * @param InputEXP
	 * @param InputDamage
	 * @param InputDamageType
	 * @param InputCurrency
	 */
	public GameChar(String InputName, int InputHealth, int InputLevel, int InputEXP, int InputDamage, 
			int InputDamageType, int InputCurrency) {
		this.Name = InputName;
		this.Health = InputHealth;
		this.Level = InputLevel;
		this.EXP = InputEXP;
		this.Damage = InputDamage;
		this.DamageType = this.SetDamageType(InputDamageType);
		this.Currency = InputCurrency;
	}
	
	/** For Instantiating NPCs with only a name (for sale of items)
	 * 
	 * @param InputName
	 */
	public GameChar(String InputName) {
		this.Name = InputName;
		this.Health = 1;
		this.Level = 1;
		this.EXP = 0;
		this.Damage = 0;
		this.DamageType = this.SetDamageType(0);
		this.Currency = 0;
		this.Inventory = null;
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
	
	public ArrayList<Item> getInventory() {
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
	
	public String SetDamageType(int typeInt) {
		
		switch (typeInt) {
		
		case 1:
			return "Melee";
		case 2:
			return "Magic";
		case 3:
			return "Projectile";
		case 4:
			return "Throwable";
		default:
			return "None";
		
		}
		
	}
	
	public void setCurrency(int InputCurrency) {
		this.Currency = InputCurrency;
	}
	
	public void addToInventory(Item item) {
		this.getInventory().add(item);
	}
	
	/**
	 * 
	 * ----- ToString method -----
	 * 
	 */
	
	public String toString() {
		
		// For loop to convert Inventory into a string
		String TempInventory = "";
		for (int x = 0; x < this.getInventory().size(); x++) {
			TempInventory = TempInventory + this.getInventory().get(x) + "-------" + "\n";
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