package game;

import java.io.Serial;
import java.io.Serializable;

public class Item implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	// -------------------Variables-------------------

	private String key;
	private String name;
	private String info;
	private String rarity;
	private int value;
	private double damage;
	private String damageType;
	private boolean sellable;
	private char itemType;

	// -------------------Constructors-------------------

	/**
	 * Default Constructor
	 */
	public Item() {
		this.key = "0_000";
		this.name = "No Name";
		this.info = "...";
		this.calculateRarityInt(0);
		this.value = 0;
		this.damage = 0;
		this.damageType = "No Damage Type";
		this.sellable = false;
		this.itemType = 'i';
	}
	
	/**
	 * Constructor for the use of super constructor in child classes
	 * 
	 * @param inputItemType
	 */
	public Item(char inputItemType) {
		this.key = "0_000";
		this.name = "No Name";
		this.info = "...";
		this.calculateRarityInt(0);
		this.value = 0;
		this.damage = 0;
		this.damageType = "No Damage Type";
		this.sellable = false;
		this.itemType = inputItemType;
	}

	/**
	 * Constructor that instantiates all values
	 * 
	 * @param inputKey
	 * @param inputName
	 * @param inputInfo
	 * @param inputRarity
	 * @param inputValue
	 * @param inputDamage
	 * @param inputDamagetype
	 * @param inputsellable
	 * @param inputItemType
	 */
	public Item(String inputKey, String inputName, String inputInfo, int inputRarity, int inputValue, int inputDamage, 
			int inputDamagetype, boolean inputsellable, char inputItemType) {
		this.key = inputKey;
		this.name = inputName;
		this.info = inputInfo;
		this.rarity = this.calculateRarityInt(inputRarity);
		this.value = inputValue;
		this.damage = inputDamage;
		this.damageType = this.calculateDamageTypeInt(inputDamagetype);
		this.sellable = inputsellable;
		this.itemType = inputItemType;
	}

	/**
	 * Constructor that instantiates Items that are not sellable
	 * sets sellable to False and Value to 0
	 * 
	 * @param inputKey
	 * @param inputName
	 * @param inputInfo
	 * @param inputRarity
	 * @param inputDamage
	 * @param inputDamagetype
	 * @param inputItemType
	 */
	public Item(String inputKey, String inputName, String inputInfo, int inputRarity, int inputDamage, 
			int inputDamagetype, char inputItemType) {
		this.key = inputKey;
		this.name = inputName;
		this.info = inputInfo;
		this.rarity = this.calculateRarityInt(inputRarity);
		this.value = 0;
		this.damage = inputDamage;
		this.damageType = this.calculateDamageTypeInt(inputDamagetype);
		this.sellable = false;
		this.itemType = inputItemType;
	}

	/**
	 * Constructor that instantiates items with no damage
	// sets Damage to 0 and Damagetype to default No Damage Type String
	 * 
	 * @param inputKey
	 * @param inputName
	 * @param inputInfo
	 * @param inputRarity
	 * @param inputValue
	 * @param inputsellable
	 * @param inputItemType
	 */
	public Item(String inputKey, String inputName, String inputInfo, int inputRarity, int inputValue,
			boolean inputsellable, char inputItemType) {
		this.key = inputKey;
		this.name = inputName;
		this.info = inputInfo;
		this.rarity = this.calculateRarityInt(inputRarity);
		this.value = inputValue;
		this.damage = 0;
		this.damageType = this.calculateDamageTypeInt(0);
		this.sellable = inputsellable;
		this.itemType = inputItemType;
		
	}

	/**
	 * Constructor that instantiates non-sellable items with no damage
	 *  sets Value and Damage to 0, sellable to false, and Damagetype to default No 
	 * Damage Type string
	 * 
	 * @param key
	 * @param inputName
	 * @param info
	 * @param inputRarity
	 * @param inputItemType
	 */
	public Item(String inputKey, String inputName, String inputInfo, int inputRarity, char inputItemType) {
		this.key = inputKey;
		this.name = inputName;
		this.info = inputInfo;
		this.rarity = this.calculateRarityInt(inputRarity);
		this.value = 0;
		this.damage = 0;
		this.damageType = "No Damage Type";
		this.sellable = false;
		this.itemType = inputItemType;
	}

	// -------------------Getters-------------------
	
	public String getKey() {
		return this.key;
	}

	public String getName() {
		return this.name;
	}

	public String getInfo() {
		return this.info;
	}

	public String getRarity() {
		return this.rarity;
	}

	public int getValue() {
		return this.value;
	}

	public double getDamage() {
		return this.damage;
	}

	public String getDamageType() {
		return this.damageType;
	}

	public Boolean getIsSellable() {
		return this.sellable;
	}
	
	public char getItemType() {
		return this.itemType;
	}

	// -------------------Setters-------------------

	public void setKey(String inputKey) {
		this.key = inputKey;
	}
	
	public void setName(String inputName) {
		this.name = inputName;
	}
	
	public void setInfo(String inputInfo) {
		this.info = inputInfo;
	}

	public void setRarity(String inputRarity) { 
		this.rarity = inputRarity; 
	}
	
	public void setRarityInt(int inputRarityInt) {
		this.rarity = this.calculateRarityInt(inputRarityInt);
	}

	public void setValue(int inputValue) {
		this.value = inputValue;
	}

	public void setDamage(double inputDamage) {
		this.damage = inputDamage;
	}

	public void setDamageType(String inputDamageType) {
		this.damageType = inputDamageType;
	}
	
	public void setDamageTypeInt(int inputDamageTypeInt) {
		this.damageType = this.calculateDamageTypeInt(inputDamageTypeInt);
	}

	public void setIsSellable(boolean inputsellable) {
		this.sellable = inputsellable;
	}
	
	public void setItemType(char inputItemType) {
		this.itemType = inputItemType;
	}

	// -------------------Functions-------------------
	
	/**
	 * Takes an int and returns the pre-set rarity strings based on input
	 * 1: "Common", 2: "Uncommon", 3: "Rare", 4: "Epic", 5: "Legendary", Default: "null"
	 * 
	 * @param intRare
	 * @return Rarity string
	 */
	public String calculateRarityInt(int intRare) {

		switch (intRare) {

		case 1:
			return "Common";
		case 2:
			return "Uncommon";
		case 3:
			return "Rare";
		case 4:
			return "Epic";
		case 5:
			return "Legendary";
		default:
			return "null";

		}

	}
	
	/**
	 * Takes an int and returns the pre-set damage type strings based on input
	 * 1: "Melee", 2: "Ranged", 3: "Magic", 4: "Rogue", Default: "null"
	 * 
	 * @param typeInt
	 * @return DamageType string
	 */
	public String calculateDamageTypeInt(int typeInt) {

		switch (typeInt) {

		case 1:
			return "Melee";
		case 2:
			return "Ranged";
		case 3:
			return "Magic";
		case 4:
			return "Rogue";
		default:
			return null;

		}

	}
	
	// -------------------toString-------------------

	public String toString() {
		return "Name: " + this.name + "\n" + 
				"Description: " + this.info + "\n" + 
				"Rarity: " + this.rarity + "\n" + 
				"Value: " + this.value + "\n" + 
				"Damage: " + this.damage + "\n" + 
				"Damage Type: " + this.damageType + "\n" + 
				"Is Sell-able?: "+ this.sellable + "\n";
	}
}