package game;

public class Enemy extends GameChar {
	
	// -------------------Variables-------------------
	
	protected SpecialAttack specialAttack;
	protected int damage;
	protected String damageType;
	
	// -------------------Constructors-------------------
	
	/**
	 * Default Constructor
	 */
	public Enemy() {
		super();
		this.specialAttack = new SpecialAttack();
	}
	
	/**
	 * Constructor that instantiates all values
	 * 
	 * @param inputName
	 * @param inputInventory
	 * @param inputCurrency
	 * @param inputHealth
	 * @param inputLevel
	 * @param inputExp
	 * @param inputDamage	-As an int (1-4 for "Melee", "Ranged", "Magic", "Rogue") *default is "null"*
	 * @param inputDamageType
	 * @param inputSpecialAttack
	 */
	public Enemy(String inputName, Inventory inputInventory, int inputCurrency, int inputHealth, 
			int inputLevel, int inputExp, int inputDamage, int inputDamageType, SpecialAttack inputSpecialAttack) 
	{
		super(inputName, inputInventory, inputCurrency, inputHealth, inputLevel, inputExp);
		this.specialAttack = inputSpecialAttack;
		this.damage = inputDamage;
		this.damageType = this.calculateDamageType(inputDamageType);
	}
	
	/**
	 * For Instantiating EXP enemies with no inventory but that give EXP and currency and have a special attack
	 * Takes all data types besides the Inventory
	 * 
	 * @param inputName
	 * @param inputCurrency
	 * @param inputHealth
	 * @param inputLevel
	 * @param inputExp
	 * @param inputDamage	-As an int (1-4 for "Melee", "Ranged", "Magic", "Rogue") *default is "null"*
	 * @param inputDamageType
	 * @param inputSpecialAttack
	 */
	public Enemy(String inputName, int inputCurrency, int inputHealth, int inputLevel, int inputExp, 
			int inputDamage, int inputDamageType, SpecialAttack inputSpecialAttack) {
		super(inputName, inputCurrency, inputHealth, inputLevel, inputExp);
		this.specialAttack = inputSpecialAttack;
		this.damage = inputDamage;
		this.damageType = this.calculateDamageType(inputDamageType);
	}
	
	/**
	 * For Instantiating EXP enemies with no inventory but that give EXP and currency but don't have a special attack
	 * Takes all data types besides the Inventory and Special Attack
	 * 
	 * @param inputName
	 * @param inputCurrency
	 * @param inputHealth
	 * @param inputLevel
	 * @param inputExp
	 * @param inputDamage	-As an int (1-4 for "Melee", "Ranged", "Magic", "Rogue") *default is "null"*
	 * @param inputDamageType
	 */
	public Enemy(String inputName, int inputCurrency, int inputHealth, int inputLevel, int inputExp, 
			int inputDamage, int inputDamageType) {
		super(inputName, inputCurrency, inputHealth, inputLevel, inputExp);
		this.specialAttack = new SpecialAttack();
		this.damage = inputDamage;
		this.damageType = this.calculateDamageType(inputDamageType);
	}
	
	// -------------------Getters-------------------
	
	public SpecialAttack getSpecialAttack() {
		return this.specialAttack;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public String getDamageType() {
		return this.damageType;
	}

	// -------------------Setters-------------------
	
	public void setSpecialAttack(SpecialAttack inputSpecialAttack) {
		this.specialAttack = inputSpecialAttack;
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
		return super.toString() +
				"Damage: " + this.damage + "\n" +
				"Damage Type: " + this.damageType + "\n" +
				this.specialAttack.toString() ;
	}
}