package game;

public class Consumable extends Item {

	private int count;

	/**
	 * Base constructor
	 */
	public Consumable() {

		super();
		this.setCount(0);

	}

	/**
	 * Consumable items that do damage, and can be sold.
	 * 
	 * @param name
	 * @param info
	 * @param rarity
	 * @param value
	 * @param damage
	 * @param type
	 * @param sellable
	 * @param count
	 */
	public Consumable(String key, String name, String info, int rarity, int value, int damage, int type, boolean sellable,
			int count) {

		super(key, name, info, rarity, value, damage, type, sellable);
		this.setCount(count);

	}

	/**
	 * Consumable items that do no damage, and can be sold.
	 * 
	 * @param name
	 * @param info
	 * @param rarity
	 * @param value
	 * @param damage
	 * @param type
	 * @param sellable
	 * @param count
	 */
	public Consumable(String key, String name, String info, int rarity, int value, boolean sellable, int count) {

		super(key, name, info, rarity, value, sellable);
		this.setCount(count);

	}

	// ---------------------Getters---------------------

	public int getCount() {
		return count;
	}

	// ---------------------Setters---------------------

	public void setCount(int count) {
		this.count = count;
	}

	// ---------------------Functions---------------------

	public String toString() {

		return this.GetName() + "\n" + this.getInfo() + "\nRarity: " + this.GetRarity() + "\nValue per Item: "
				+ this.GetValue() + "\nNo. Held: " + this.getCount();

	}

}
