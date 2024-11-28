package game;

public class Consumable extends Item {

	// -------------------Variables-------------------
	
	private int count;
	private boolean usable;
	private char consumableType;

	// -------------------Constructors-------------------
	
	/**
	 * Base constructor
	 */
	public Consumable() {

		super('c');
		this.count = 0;
		this.usable = false;

	}

	/**
	 * Consumable items that do damage, and can be sold.
	 * 
	 * @param inputKey
	 * @param inputName
	 * @param inputInfo
	 * @param inputRarity
	 * @param inputValue
	 * @param inputDamage
	 * @param inputType
	 * @param inputIsSellable
	 * @param inputCount
	 * @param inputIsUsable
	 */
	public Consumable(String inputKey, String inputName, String inputInfo, int inputRarity, int inputValue, 
			int inputDamage, int inputType, boolean inputIsSellable, int inputCount, boolean inputIsUsable,
			char inputConsumableType) {

		super(inputKey, inputName, inputInfo, inputRarity, inputValue, inputDamage, inputType, inputIsSellable, 'c');
		this.count = inputCount;
		this.usable = inputIsUsable;
		this.consumableType = inputConsumableType;

	}

	/**
	 * Consumable items that do no damage, and can be sold.
	 * 
	 * @param inputKey
	 * @param inputName
	 * @param inputInfo
	 * @param inputRarity
	 * @param inputValue
	 * @param inputIsSellable
	 * @param inputCount
	 * @param inputIsUsable
	 */
	public Consumable(String inputKey, String inputName, String inputInfo, int inputRarity, int inputValue, 
			boolean inputIsSellable, int inputCount, boolean inputIsUsable, char inputConsumableType) {

		super(inputKey, inputName, inputInfo, inputRarity, inputValue, inputIsSellable, 'c');
		this.count = inputCount;
		this.usable = inputIsUsable;
		this.consumableType = inputConsumableType;
	}

	// ---------------------Getters---------------------

	public int getCount() {
		return this.count;
	}
	
	public boolean isUsable() {
		return this.usable;
	}
	
	public char getConsumableType() {
		return this.consumableType;
	}

	// ---------------------Setters---------------------

	public void setCount(int count) {
		this.count = count;
	}
	
	public void setConsumableType(char inputConsumableType) {
		this.consumableType = inputConsumableType;
	}

	// ---------------------Functions-------------------
	
	public void displayInfo() {
		System.out.println("----------" + this.getName() + "----------\n" + this.getInfo() + "\n" + 
					"Rarity: " + this.getRarity() + "\t\tDamage: " + this.getDamage() + "\t\tType: " + this.getDamageType()
					+ "\"Amount Held: "  + this.getCount() + "\n--------------------\n");
	}
	
	public boolean equals(Consumable consumable) {
		if (this.getKey() == consumable.getKey()) {
		if (this.getName() == consumable.getName()) {
		if (this.getInfo() == consumable.getInfo()) {
		if (this.getRarity() == consumable.getRarity() ) {
		if (this.getValue() == consumable.getValue()) {
		if (this.getDamage() == consumable.getDamage()) {
		if (this.getDamageType() == consumable.getDamageType()) {
		return true;
		}}}}}}}
		return false;
	}
	
	// ---------------------toString---------------------

	public String toString() {
		return super.toString() +
				"Amount: " + this.count + "\n" +
				"Is Sellable?:" + this.getIsSellable() + "\n";
	}

}
