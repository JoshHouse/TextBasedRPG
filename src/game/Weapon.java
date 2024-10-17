package game;

public class Weapon extends Item {
	/**
	 * 
	 * ----- Variables -----
	 * 
	 */

	private int ManaUsage;
	private SpecialAttack SpecialAttack;

	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */

	/**
	 * Default constructor
	 */
	public Weapon() {
		super();
		this.ManaUsage = 0;
		this.SpecialAttack = new SpecialAttack();
	}

	/**
	 * Constructor that initializes all value s
	 * 
	 * @param InputName
	 * @param info
	 * @param InputRarity
	 * @param InputValue
	 * @param InputDamage
	 * @param InputDamageType
	 * @param InputIsSellable
	 * @param InputManaUsage
	 * @param InputSpecialAttack
	 */
	public Weapon(String key, String InputName, String info, int InputRarity, int InputValue, int InputDamage, int InputDamageType,
			Boolean InputIsSellable, int InputManaUsage, SpecialAttack InputSpecialAttack) {
		super(key, InputName, info, InputRarity, InputValue, InputDamage, InputDamageType, InputIsSellable);
		this.ManaUsage = InputManaUsage;
		this.SpecialAttack = InputSpecialAttack;
	}

	/**
	 * Constructor that instantiates weapons that are not sellable. Sets IsSellable
	 * to False and Value to 0
	 * 
	 * @param InputName
	 * @param info
	 * @param InputRarity
	 * @param InputDamage
	 * @param InputDamageType
	 * @param InputManaUsage
	 * @param InputSpecialAttack
	 */
	public Weapon(String key, String InputName, String info, int InputRarity, int InputDamage, int InputDamageType,
			int InputManaUsage, SpecialAttack InputSpecialAttack) {
		super(key, InputName, info, InputRarity, InputDamage, InputDamageType);
		this.ManaUsage = InputManaUsage;
		this.SpecialAttack = InputSpecialAttack;
	}

	/**
	 * Constructor that instantiates weapons that are not sellable and don't use
	 * mana. Sets IsSellable to False, Value to 0, and ManaUsage to 0
	 * 
	 * @param InputName
	 * @param info
	 * @param InputRarity
	 * @param InputDamage
	 * @param InputDamageType
	 * @param InputSpecialAttack
	 */
	public Weapon(String key, String InputName, String info, int InputRarity, int InputDamage, int InputDamageType,
			SpecialAttack InputSpecialAttack) {
		super(key, InputName, info, InputRarity, InputDamage, InputDamageType);
		this.ManaUsage = 0;
		this.SpecialAttack = InputSpecialAttack;
	}

	/**
	 * Constructor that instantiates weapons that are not sellable, don't use mana,
	 * and dont have a special attack Sets IsSellable to False, Value to 0,
	 * ManaUsage to 0, and Special Attack to a default string
	 * 
	 * @param InputName
	 * @param info
	 * @param InputRarity
	 * @param InputDamage
	 * @param InputDamageType
	 */
	public Weapon(String key, String InputName, String info, int InputRarity, int InputDamage, int InputDamageType) {
		super(key, InputName, info, InputRarity, InputDamage, InputDamageType);
		this.ManaUsage = 0;
		this.SpecialAttack = new SpecialAttack();
	}

	/**
	 * Constructor that instantiates weapons that are not sellable and dont use a
	 * special attack. Sets IsSellable to False, Value to 0, and SpecialAttack to a
	 * default string
	 * 
	 * @param InputName
	 * @param info
	 * @param InputRarity
	 * @param InputDamage
	 * @param InputDamageType
	 * @param InputManaUsage
	 */
	public Weapon(String key, String InputName, String info, int InputRarity, int InputDamage, int InputDamageType,
			int InputManaUsage) {
		super(key, InputName, info, InputRarity, InputDamage, InputDamageType);
		this.ManaUsage = InputManaUsage;
		this.SpecialAttack = new SpecialAttack();
	}

	/**
	 * 
	 * ----- Getters -----
	 * 
	 */

	public int GetManaUsage() {
		return this.ManaUsage;
	}

	public SpecialAttack GetSpecialAttack() {
		return this.SpecialAttack;
	}

	/**
	 * 
	 * ----- Setters -----
	 * 
	 */

	public void SetManaUsage(int InputManaUsage) {
		this.ManaUsage = InputManaUsage;
	}

	public void SetSpecialAttack(SpecialAttack InputSpecialAttack) {
		this.SpecialAttack = InputSpecialAttack;
	}

	/**
	 * 
	 * ----- ToString method -----
	 * 
	 */

	public String toString() {
		return super.toString() + "Special Attack: " + this.SpecialAttack + "\n" + "Mana Usage: " + this.ManaUsage
				+ "\n";
	}
}