package game;

public class Weapon extends Item {

	// -------------------Variables-------------------

	private int manaUsage;
	private SpecialAttack specialAttack;
	private String manaElement;

	// -------------------Constructors-------------------

	/**
	 * Default constructor
	 */
	public Weapon() {
		super('w');
		this.manaUsage = 0;
		this.specialAttack = new SpecialAttack();
	}
	
	public Weapon(Weapon inputWeapon) {
		this.setKey(inputWeapon.getKey());
		this.setName(inputWeapon.getName());
		this.setInfo(inputWeapon.getInfo());
		this.setRarity(inputWeapon.getRarity());
		this.setValue(inputWeapon.getValue());
		this.setDamage(inputWeapon.getDamage());
		this.setDamageType(inputWeapon.getDamageType());
		this.setIsSellable(inputWeapon.getIsSellable());
		this.setManaUsage(inputWeapon.getManaUsage());
		this.setSpecialAttack(new SpecialAttack(inputWeapon.getSpecialAttack()));
	}

	/**
	 * Constructor that initializes all values
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
	 * @param inputManaElement
	 */
	public Weapon(String key, String name, String info, int rarity, int inputValue, int damage, int dmgType,
			Boolean inputIsSellable, int manaUsage, SpecialAttack spAtk, char inputManaElement) {
		super(key, name, info, rarity, inputValue, damage, dmgType, inputIsSellable, 'w');
		this.manaUsage = manaUsage;
		this.specialAttack = spAtk;
		this.setManaElementChar(inputManaElement);

	}
	
	/**
	 * Constructor that initializes all values except manaElement so other constructors dont need to be
	 * changed
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
		this.setManaElementChar('b');

	}
	
	/**
	 * Constructor that initializes all values except manaElement so other constructors dont need to be
	 * changed
	 * 
	 * @param name
	 * @param info
	 * @param rarity
	 * @param inputValue
	 * @param damage
	 * @param dmgType
	 * @param inputIsSellable
	 * @param spAtk
	 */
	public Weapon(String key, String name, String info, int rarity, int inputValue, int damage, int dmgType,
			Boolean inputIsSellable, SpecialAttack spAtk) {
		super(key, name, info, rarity, inputValue, damage, dmgType, inputIsSellable, 'w');
		this.manaUsage = 0;
		this.specialAttack = spAtk;
		this.setManaElementChar('b');

	}


	/**
	 * Constructor that initializes weapons that are sellable, but use no mana and
	 * have no special attacks.
	 * 
	 * @param name
	 * @param info
	 * @param rarity
	 * @param inputValue
	 * @param damage
	 * @param dmgType
	 * @param inputIsSellable
	 */
	public Weapon(String key, String name, String info, int rarity, int inputValue, int damage, int dmgType,
			Boolean inputIsSellable) {
		super(key, name, info, rarity, inputValue, damage, dmgType, inputIsSellable, 'w');
		this.manaUsage = 0;
		this.specialAttack = new SpecialAttack();

	}

	/**
	 * Constructor that initializes weapons that are sellable, but use no mana and
	 * have special attacks.
	 * 
	 * @param name
	 * @param info
	 * @param rarity
	 * @param inputValue
	 * @param damage
	 * @param dmgType
	 * @param inputIsSellable
	 * @param inputManaElement
	 */
	public Weapon(String key, String name, String info, int rarity, int inputValue, int damage, int dmgType,
			Boolean inputIsSellable, SpecialAttack spAtk, char inputManaElement) {
		super(key, name, info, rarity, inputValue, damage, dmgType, inputIsSellable, 'w');
		this.manaUsage = 0;
		this.specialAttack = spAtk;
		this.setManaElementChar(inputManaElement);

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
	 * @param inputManaElement
	 */
	public Weapon(String key, String name, String info, int rarity, int damage, int dmgType, int manaUsage,
			SpecialAttack spAtk, char inputManaElement) {
		super(key, name, info, rarity, damage, dmgType, 'w');
		this.manaUsage = manaUsage;
		this.specialAttack = spAtk;
		this.setManaElementChar(inputManaElement);
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
	public Weapon(String key, String name, String info, int rarity, int damage, int dmgType, SpecialAttack spAtk) {
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
	 * @param inputManaElement
	 */
	public Weapon(String key, String name, String info, int rarity, int damage, int dmgType, int manaUsage, 
			char inputManaElement) {
		super(key, name, info, rarity, damage, dmgType, 'w');
		this.manaUsage = manaUsage;
		this.specialAttack = new SpecialAttack();
		this.setManaElementChar(inputManaElement);

	}

	// -------------------Getters-------------------

	public int getManaUsage() {
		return this.manaUsage;
	}

	public SpecialAttack getSpecialAttack() {
		return this.specialAttack;
	}
	
	public String getManaElement() {
		return this.manaElement;
	}

	// -------------------Setters-------------------

	public void setManaUsage(int manaUsage) {
		this.manaUsage = manaUsage;
	}

	public void setSpecialAttack(SpecialAttack spAtk) {
		this.specialAttack = spAtk;
	}
	
	public void setManaElement(String inputManaElement) {
		this.manaElement = inputManaElement;
	}
	
	public void setManaElementChar(char inputManaElement) {
		this.manaElement = this.calculateManaElementOnChar(inputManaElement);
	}

	// -------------------Functions------------------

	/**
	 * Displays the basic information about a weapon, omitting some information when
	 * it does not need to be shown.
	 */
	public void displayInfo() {

		// Bae information
		String info = "\n------------" + this.getName() + "------------\n" + this.getInfo() + "\nRarity: "
				+ this.getRarity() + "\t\tDamage: " + this.getDamage() + "\t\tType: " + this.getDamageType()
				+ "\nMana Usage: " + this.manaUsage + "\n";

		// If the weapon is sellable, the value is added on.
		if (this.getIsSellable()) {
			info = info + "Value: " + this.getValue() + " Gold\n";
		}

		// If the weapon has a special attack, it is added on
		if (this.getSpecialAttack().getAtkMultiplier() != 1.0) { // 1.0 = no damage multiplied
			info = info + this.getSpecialAttack().displayInfo();
		}

		// Print the info
		Dialogue.infoDialogue(info + "\n--------------------\n", 5);

	}
	
	public String calculateManaElementOnChar(char inputManaElement) {
		switch (inputManaElement) {
		case 'b':
			return "Basic";
		case 'f':
			return "Fire";
		case 'i':
			return "Ice";
		case 'l':
			return "Lightning";
		case 'e':
			return "Earth";
			default:
				return "Basic";
			
		}
	}

	// -------------------toString-------------------

	@Override
	public String toString() {
		return super.toString() + this.specialAttack.toString() + "Mana Usage: " + this.manaUsage + "\n";
	}
}