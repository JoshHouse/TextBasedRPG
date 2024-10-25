package game;

public class Consumable extends Item {

	// -------------------Variables-------------------
	
	protected int count;
	protected boolean isUsable;

	// -------------------Constructors-------------------
	
	/**
	 * Base constructor
	 */
	public Consumable() {

		super('c');
		this.count = 0;
		this.isUsable = false;

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
			int inputDamage, int inputType, boolean inputIsSellable, int inputCount, boolean inputIsUsable) {

		super(inputKey, inputName, inputInfo, inputRarity, inputValue, inputDamage, inputType, inputIsSellable, 'c');
		this.count = inputCount;
		this.isUsable = inputIsUsable;

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
			boolean inputIsSellable, int inputCount, boolean inputIsUsable) {

		super(inputKey, inputName, inputInfo, inputRarity, inputValue, inputIsSellable, 'c');
		this.count = inputCount;
		this.isUsable = inputIsUsable;

	}

	// ---------------------Getters---------------------

	public int getCount() {
		return this.count;
	}

	// ---------------------Setters---------------------

	public void setCount(int count) {
		this.count = count;
	}

	// ---------------------Functions-------------------
	
	public void displayInfo() {
		System.out.println("----------" + this.getName() + "----------\n" + 
					"Description : " + this.getInfo() + "\n" + 
					"Rarity: " + this.getRarity() + "\n" + 
					"Damage: " + this.getDamage() + "\n" + 
					"Damage Type : " + this.getDamageType() + "\n" + 
					"Count: "  + this.getCount() + "\n" +
					"--------------------\n");
	}
	
	// ---------------------toString---------------------

	public String toString() {

		return super.toString() +
				"Amount: " + this.count + "\n" +
				"Is Usable?:" + this.isSellable + "\n";

	}

}
