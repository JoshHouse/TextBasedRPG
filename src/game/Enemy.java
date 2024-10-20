package game;

public class Enemy extends GameChar {
	
	// -------------------Variables-------------------
	
	protected SpecialAttack specialAttack;
	
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
	 * @param inputDamage
	 * @param inputDamageType
	 * @param inputSpecialAttack
	 */
	public Enemy(String inputName, Inventory inputInventory, int inputCurrency, int inputHealth, 
			int inputLevel, int inputExp, int inputDamage, int inputDamageType, SpecialAttack inputSpecialAttack) 
	{
		super(inputName, inputInventory, inputCurrency, inputHealth, inputLevel, inputExp, inputDamage, 
				inputDamageType);
		this.specialAttack = inputSpecialAttack;
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
	 * @param inputDamage
	 * @param inputDamageType
	 * @param inputSpecialAttack
	 */
	public Enemy(String inputName, int inputCurrency, int inputHealth, int inputLevel, int inputExp, 
			int inputDamage, int inputDamageType, SpecialAttack inputSpecialAttack) {
		super(inputName, inputCurrency, inputHealth, inputLevel, inputExp, inputDamage, inputDamageType);
		this.specialAttack = inputSpecialAttack;
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
	 * @param inputDamage
	 * @param inputDamageType
	 */
	public Enemy(String inputName, int inputCurrency, int inputHealth, int inputLevel, int inputExp, 
			int inputDamage, int inputDamageType) {
		super(inputName, inputCurrency, inputHealth, inputLevel, inputExp, inputDamage, inputDamageType);
		this.specialAttack = new SpecialAttack();
	}
	
	// -------------------Getters-------------------
	
	public SpecialAttack getSpecialAttack() {
		return this.specialAttack;
	}
	

	// -------------------Setters-------------------
	
	public void setSpecialAttack(SpecialAttack inputSpecialAttack) {
		this.specialAttack = inputSpecialAttack;
	}
	

	// -------------------toString-------------------
	
	public String toString() {
		return super.toString() +
				this.specialAttack.toString();
	}
}