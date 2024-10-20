package game;


public class GameChar extends Lootable {
	
	// -------------------Variables-------------------
	
	protected int health;
	protected int level;
	protected int exp;
	protected int damage;
	protected String damageType;
	
	// -------------------Constructors-------------------
	
	/** 
	 * Default Constructor
	 */
	public GameChar() {
		
		super();
		this.health = 1;
		this.level = 1;
		this.exp = 0;
		this.damage = 0;
		this.damageType = this.calculateDamageType(0);
	}
	/** 
	 * For Instantiating Characters With All Data Types
	 * 
	 * @param inputName
	 * @param inputInventory
	 * @param inputCurrency
	 * @param inputHealth
	 * @param inputLevel
	 * @param inputExp
	 * @param inputDamage
	 * @param inputDamageType	-As an int (1-4 for "Melee", "Ranged", "Magic", "Rogue") *default is "null"*
	 */
	public GameChar(String inputName, Inventory inputInventory, int inputCurrency, int inputHealth, 
			int inputLevel, int inputExp, int inputDamage, int inputDamageType) {
		
		super(inputName, inputInventory, inputCurrency); 
		this.health = inputHealth;
		this.level = inputLevel;
		this.exp = inputExp;
		this.damage = inputDamage;
		this.damageType = this.calculateDamageType(inputDamageType);
	}
	
	/** 
	 * For Instantiating Characters with no inventory
	 * 
	 * @param inputName
	 * @param inputCurrency
	 * @param inputHealth
	 * @param inputLevel
	 * @param inputExp
	 * @param inputDamage
	 * @param inputDamageType	-As an int (1-4 for "Melee", "Ranged", "Magic", "Rogue") *default is "null"*
	 */
	public GameChar(String inputName, int inputCurrency, int inputHealth, 
			int inputLevel, int inputExp, int inputDamage, int inputDamageType) {
		
		super(inputName, inputCurrency); 
		this.health = inputHealth;
		this.level = inputLevel;
		this.exp = inputExp;
		this.damage = inputDamage;
		this.damageType = this.calculateDamageType(inputDamageType);
	}
	
	/** 
	 * Instantiates a character with all values except an inventory and currency
	 * 
	 * @param inputName
	 * @param inputHealth
	 * @param inputLevel
	 * @param inputExp
	 * @param inputDamage
	 * @param inputDamageType	-As an int (1-4 for "Melee", "Ranged", "Magic", "Rogue") *default is "null"*
	 */
	public GameChar(String inputName, int inputHealth, int inputLevel, int inputExp, int inputDamage, 
			int inputDamageType) {
		
		super(inputName);
		this.health = inputHealth;
		this.level = inputLevel;
		this.exp = inputExp;
		this.damage = inputDamage;
		this.damageType = this.calculateDamageType(inputDamageType);
	}
	
	/**
	 * For instantiating characters with only a name and an invetory but the rest with default values
	 * 
	 * @param inputName
	 * @param inputInventory
	 */
	public GameChar(String inputName, Inventory inputInventory) {
		
		super(inputName, inputInventory);
		this.health = 1;
		this.level = 1;
		this.exp = 0;
		this.damage = 0;
		this.damageType = this.calculateDamageType(0);
	}
	
	/**
	 * For instantiating a default character with level 1 values that only takes a name as input
	 * 
	 * @param inputName
	 */
	public GameChar(String inputName) {
		super(inputName);
		this.health = 100;
		this.level = 1;
		this.exp = 0;
		this.damage = 1;
		this.damageType = this.calculateDamageType(0);
	}
	
	// -------------------Getters-------------------
	
	public int getHealth() {
		return this.health;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getExp() {
		return this.exp;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public String getDamageType() {
		return this.damageType;
	}
	
	// -------------------Setters-------------------
	
	public void setHealth(int inputHealth) {
		this.health = inputHealth;
	}
	
	public void setLevel(int inputLevel) {
		this.level = inputLevel;
	}
	
	public void setExp(int inputExp) {
		this.exp = inputExp;
	}
	
	public void setDamage(int inputDamage) {
		this.damage = inputDamage;
	}
	
	public void setDamageType(String inputDamageType) {
		this.damageType = inputDamageType;
	}
	
	public void setDamageTypeInt(int inputDamageType) {
		this.damageType = this.calculateDamageType(inputDamageType);
	}
	
	// -------------------Functions-------------------
	/**
	 * Calculates damage type based on inputted int and returns damage type string
	 * 1: "Melee", 2: "Ranged", 3: "Magic", 4: "Rogue", Default: "null"
	 * 
	 * @param typeInt
	 * @return damageType string
	 */
	public String calculateDamageType(int typeInt) {
		
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
			return "null";
		
		}
		
	}
	// -------------------toString-------------------
	
	public String toString() {
		
		return	super.toString() +
				"Health: " + this.health + "\n" +
				"Level: " + this.level + "\n" +
				"Exp: " + this.exp + "\n" +
				"Damage: " + this.damage + "\n" +
				"Damage Type: " + this.damageType + "\n";
	}
}