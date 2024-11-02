package game;

public class Weapon extends Item {
	
	// -------------------Variables-------------------

	private int manaUsage;
	private SpecialAttack specialAttack;

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
	 * @param name
	 * @param info
	 * @param rarity
	 * @param inputValue
	 * @param damage
	 * @param dmgType
	 * @param inputIsSellable
	 * @param manaUsage
	 * @param spAtk
	 */
	public Weapon(String key, String name, String info, int rarity, int inputValue, int damage, int dmgType,
			Boolean inputIsSellable, int manaUsage, SpecialAttack spAtk) {
		super(key, name, info, rarity, inputValue, damage, dmgType, inputIsSellable, 'w');
		this.manaUsage = manaUsage;
		this.specialAttack = spAtk;
		
	}

	/**
	 * Constructor that instantiates weapons that are not sellable. Sets IsSellable
	 * to False and Value to 0
	 * 
	 * @param name
	 * @param info
	 * @param rarity
	 * @param damage
	 * @param dmgType
	 * @param manaUsage
	 * @param spAtk
	 */
	public Weapon(String key, String name, String info, int rarity, int damage, int dmgType,
			int manaUsage, SpecialAttack spAtk) {
		super(key, name, info, rarity, damage, dmgType, 'w');
		this.manaUsage = manaUsage;
		this.specialAttack = spAtk;
	}

	/**
	 * Constructor that instantiates weapons that are not sellable and don't use
	 * mana. Sets IsSellable to False, Value to 0, and ManaUsage to 0
	 * 
	 * @param name
	 * @param info
	 * @param rarity
	 * @param damage
	 * @param dmgType
	 * @param spAtk
	 */
	public Weapon(String key, String name, String info, int rarity, int damage, int dmgType,
			SpecialAttack spAtk) {
		super(key, name, info, rarity, damage, dmgType, 'w');
		this.manaUsage = 0;
		this.specialAttack = spAtk;
	}

	/**
	 * Constructor that instantiates weapons that are not sellable, don't use mana,
	 * and dont have a special attack Sets IsSellable to False, Value to 0,
	 * ManaUsage to 0, and Special Attack to a default string
	 * 
	 * @param name
	 * @param info
	 * @param rarity
	 * @param damage
	 * @param dmgType
	 */
	public Weapon(String key, String name, String info, int rarity, int damage, int dmgType) {
		super(key, name, info, rarity, damage, dmgType, 'w');
		this.manaUsage = 0;
		this.specialAttack = new SpecialAttack();
	}

	/**
	 * Constructor that instantiates weapons that are not sellable and dont use a
	 * special attack. Sets IsSellable to False, Value to 0, and SpecialAttack to a
	 * default string
	 * 
	 * @param name
	 * @param info
	 * @param rarity
	 * @param damage
	 * @param dmgType
	 * @param manaUsage
	 */
	public Weapon(String key, String name, String info, int rarity, int damage, int dmgType,
			int manaUsage) {
		super(key, name, info, rarity, damage, dmgType, 'w');
		this.manaUsage = manaUsage;
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

	public void setManaUsage(int manaUsage) {
		this.manaUsage = manaUsage;
	}

	public void setSpecialAttack(SpecialAttack spAtk) {
		this.specialAttack = spAtk;
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