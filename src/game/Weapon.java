package game;

public class Weapon extends Item {
	
	// -------------------Variables-------------------

	protected int manaUsage;
	protected SpecialAttack specialAttack;

	// -------------------Constructors-------------------

	/**
	 * Default constructor
	 */
	public Weapon() {
		super('w');
		this.manaUsage = 0;
		this.specialAttack = new SpecialAttack();
	}

	/**
	 * Constructor that initializes all value s
	 * 
	 * @param inputName
	 * @param inputInfo
	 * @param inputRarity
	 * @param inputValue
	 * @param inputDamage
	 * @param inputDamageType
	 * @param inputIsSellable
	 * @param inputManaUsage
	 * @param inputSpecialAttack
	 */
	public Weapon(String key, String inputName, String inputInfo, int inputRarity, int inputValue, int inputDamage, int inputDamageType,
			Boolean inputIsSellable, int inputManaUsage, SpecialAttack inputSpecialAttack) {
		super(key, inputName, inputInfo, inputRarity, inputValue, inputDamage, inputDamageType, inputIsSellable, 'w');
		this.manaUsage = inputManaUsage;
		this.specialAttack = inputSpecialAttack;
	}

	/**
	 * Constructor that instantiates weapons that are not sellable. Sets IsSellable
	 * to False and Value to 0
	 * 
	 * @param inputName
	 * @param inputInfo
	 * @param inputRarity
	 * @param inputDamage
	 * @param inputDamageType
	 * @param inputManaUsage
	 * @param inputSpecialAttack
	 */
	public Weapon(String key, String inputName, String inputInfo, int inputRarity, int inputDamage, int inputDamageType,
			int inputManaUsage, SpecialAttack inputSpecialAttack) {
		super(key, inputName, inputInfo, inputRarity, inputDamage, inputDamageType, 'w');
		this.manaUsage = inputManaUsage;
		this.specialAttack = inputSpecialAttack;
	}

	/**
	 * Constructor that instantiates weapons that are not sellable and don't use
	 * mana. Sets IsSellable to False, Value to 0, and ManaUsage to 0
	 * 
	 * @param inputName
	 * @param inputInfo
	 * @param inputRarity
	 * @param inputDamage
	 * @param inputDamageType
	 * @param inputSpecialAttack
	 */
	public Weapon(String key, String inputName, String inputInfo, int inputRarity, int inputDamage, int inputDamageType,
			SpecialAttack inputSpecialAttack) {
		super(key, inputName, inputInfo, inputRarity, inputDamage, inputDamageType, 'w');
		this.manaUsage = 0;
		this.specialAttack = inputSpecialAttack;
	}

	/**
	 * Constructor that instantiates weapons that are not sellable, don't use mana,
	 * and dont have a special attack Sets IsSellable to False, Value to 0,
	 * ManaUsage to 0, and Special Attack to a default string
	 * 
	 * @param inputName
	 * @param inputInfo
	 * @param inputRarity
	 * @param inputDamage
	 * @param inputDamageType
	 */
	public Weapon(String key, String inputName, String inputInfo, int inputRarity, int inputDamage, int inputDamageType) {
		super(key, inputName, inputInfo, inputRarity, inputDamage, inputDamageType, 'w');
		this.manaUsage = 0;
		this.specialAttack = new SpecialAttack();
	}

	/**
	 * Constructor that instantiates weapons that are not sellable and dont use a
	 * special attack. Sets IsSellable to False, Value to 0, and SpecialAttack to a
	 * default string
	 * 
	 * @param inputName
	 * @param inputInfo
	 * @param inputRarity
	 * @param inputDamage
	 * @param inputDamageType
	 * @param inputManaUsage
	 */
	public Weapon(String key, String inputName, String inputInfo, int inputRarity, int inputDamage, int inputDamageType,
			int inputManaUsage) {
		super(key, inputName, inputInfo, inputRarity, inputDamage, inputDamageType, 'w');
		this.manaUsage = inputManaUsage;
		this.specialAttack = new SpecialAttack();
	}

	// -------------------Getters-------------------

	public int getManaUsage() {
		return this.manaUsage;
	}

	public SpecialAttack getSpecialAttack() {
		return this.specialAttack;
	}

	// -------------------Setters-------------------

	public void setManaUsage(int inputManaUsage) {
		this.manaUsage = inputManaUsage;
	}

	public void setSpecialAttack(SpecialAttack inputSpecialAttack) {
		this.specialAttack = inputSpecialAttack;
	}
	
	// -------------------Functions------------------
	
	public void displayInfo() {
		System.out.println("----------" + this.getName() + "----------\n" + 
					"Description : " + this.getInfo() + "\n" + 
					"Rarity: " + this.getRarity() + "\n" + 
					"Damage: " + this.getDamage() + "\n" + 
					"Damage Type : " + this.getDamageType() + "\n" + 
					"Mana Usage: "  + this.getManaUsage() + "\n" +
					this.getSpecialAttack().toString() +
					"--------------------\n");
	}

	// -------------------toString-------------------

	public String toString() {
		return super.toString() + 
				this.specialAttack.toString() + 
				"Mana Usage: " + this.manaUsage + "\n";
	}
}