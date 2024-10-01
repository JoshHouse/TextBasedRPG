package game;

public class Weapon extends Item {
	/**
	 * 
	 * ----- Variables -----
	 * 
	 */
	
	int ManaUsage;
	String SpecialAttack;
	
	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */
	
	// Default constructor
	public Weapon() {
		super();
		this.ManaUsage = 0;
		this.SpecialAttack = "No Special Attack";
	}
	
	// Constructor that initializes all values
	public Weapon(String InputName, String InputRarity, int InputValue, int InputDamage, String InputDamageType,
			Boolean InputIsSellable, int InputManaUsage, String InputSpecialAttack) 
	{
		super(InputName, InputRarity, InputValue, InputDamage, InputDamageType, 1, InputIsSellable);
		this.ManaUsage = InputManaUsage;
		this.SpecialAttack = InputSpecialAttack;
	}
	
	// Constructor that instantiates weapons that are not sellable
	// Sets IsSellable to False and Value to 0
	public Weapon(String InputName, String InputRarity, int InputDamage, String InputDamageType, 
			int InputManaUsage, String InputSpecialAttack) {
		super(InputName, InputRarity, InputDamage, InputDamageType, 1);
		this.ManaUsage = InputManaUsage;
		this.SpecialAttack = InputSpecialAttack;
	}
	
	// Constructor that instantiates weapons that are not sellable and don't use mana
	// Sets IsSellable to False, Value to 0, and ManaUsage to 0
	public Weapon(String InputName, String InputRarity, int InputDamage, String InputDamageType, 
			String InputSpecialAttack) {
		super(InputName, InputRarity, InputDamage, InputDamageType, 1);
		this.ManaUsage = 0;
		this.SpecialAttack = InputSpecialAttack;
	}
	
	// Constructor that instantiates weapons that are not sellable, don't use mana, and dont have a special attack
	// Sets IsSellable to False, Value to 0, ManaUsage to 0, and Special Attack to a default string
	public Weapon(String InputName, String InputRarity, int InputDamage, String InputDamageType) {
		super(InputName, InputRarity, InputDamage, InputDamageType, 1);
		this.ManaUsage = 0;
		this.SpecialAttack = "No Special Attack";
	}
	
	// Constructor that instantiates weapons that are not sellable and dont use a special attack
	// Sets IsSellable to False, Value to 0, and SpecialAttack to a default string
	public Weapon(String InputName, String InputRarity, int InputDamage, String InputDamageType, 
			int InputManaUsage) {
		super(InputName, InputRarity, InputDamage, InputDamageType, 1);
		this.ManaUsage = InputManaUsage;
		this.SpecialAttack = "No Special Attack";
	}
	
	/**
	 * 
	 * ----- Getters -----
	 * 
	 */
	
	public int getManaUsage() {
		return this.ManaUsage;
	}
	
	public String getSpecialAttack() {
		return this.SpecialAttack;
	}
	
	/**
	 * 
	 * ----- Setters -----
	 * 
	 */
	
	public void setManaUsage(int InputManaUsage) {
		this.ManaUsage = InputManaUsage;
	}
	
	public void setSpecialAttack(String InputSpecialAttack) {
		this.SpecialAttack = InputSpecialAttack;
	}
	
	/**
	 * 
	 * ----- ToString method -----
	 * 
	 */
	
	public String toString() {
		return super.toString() +
				"Special Attack: " + this.SpecialAttack + "\n" +
				"Mana Usage: " + this.ManaUsage + "\n";
	}
}