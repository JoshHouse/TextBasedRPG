package game;


public class GameChar extends Lootable {
	
	// -------------------Variables-------------------
	
	private int health;
	private int level;
	private int exp;
	private int currHP; // Current HP. Used for battles.

	
	// -------------------Constructors-------------------
	
	/** 
	 * Default Constructor
	 */
	public GameChar() {
		
		super();
		this.health = 1;
		this.level = 1;
		this.exp = 0;
		this.currHP = this.getHealth();
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
	 */
	public GameChar(String inputName, Inventory inputInventory, int inputCurrency, int inputHealth, 
			int inputLevel, int inputExp) {
		
		super(inputName, inputInventory, inputCurrency); 
		this.health = inputHealth;
		this.level = inputLevel;
		this.exp = inputExp;
		this.currHP = this.getHealth();
	}
	
	/** 
	 * For Instantiating Characters with no inventory
	 * 
	 * @param inputName
	 * @param inputCurrency
	 * @param inputHealth
	 * @param inputLevel
	 * @param inputExp
	 */
	public GameChar(String inputName, int inputCurrency, int inputHealth, int inputLevel, int inputExp) {
		
		super(inputName, inputCurrency); 
		this.health = inputHealth;
		this.level = inputLevel;
		this.exp = inputExp;
		this.currHP = this.getHealth();
	}
	
	/** 
	 * Instantiates a character with all values except an inventory and currency
	 * 
	 * @param inputName
	 * @param inputHealth
	 * @param inputLevel
	 * @param inputExp	
	 */
	public GameChar(String inputName, int inputHealth, int inputLevel, int inputExp) {
		
		super(inputName);
		this.health = inputHealth;
		this.level = inputLevel;
		this.exp = inputExp;
		this.currHP = this.getHealth();
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
		this.currHP = this.getHealth();
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
		this.currHP = this.getHealth();
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
	
	public int getCurrHP() {
		return this.currHP;
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
	
	public void setCurrHP(int currHP) {
		this.currHP = currHP;
	}

	// -------------------toString-------------------
	
	public String toString() {
		
		return	super.toString() +
				"Health: " + this.health + "\n" +
				"Level: " + this.level + "\n" +
				"Exp: " + this.exp + "\n";
	}
}