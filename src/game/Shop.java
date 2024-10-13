package game;

import java.util.ArrayList;

public class Shop {

	private String name;
	private Shopkeeper shopkeeper;
	private ArrayList<Item> shopInventory = new ArrayList<Item>();

	// ----------------------------------Constructors---------------------------------

	/**
	 * Base Constructor
	 */
	public Shop() {
		this.setName("");
		this.setShopkeeper(null);

	}

	/**
	 * Constructor for shops that only sell weapons
	 * 
	 * @param name       - Shop name
	 * @param shopkeeper - The shopkeeper, from the Shopkeeper class
	 */
	public Shop(String name, Shopkeeper shopkeeper) {
		this.setName(name);
		this.setShopkeeper(shopkeeper);
	}

	// ----------------------------------Getters---------------------------------

	public String getName() {
		return name;
	}

	public Shopkeeper getShopkeeper() {
		return shopkeeper;
	}
	
	public ArrayList<Item> getInventory() {
		return shopInventory;
	}

	// ----------------------------------Setters---------------------------------

	public void setName(String name) {
		this.name = name;
	}

	public void setShopkeeper(Shopkeeper shopkeeper) {
		this.shopkeeper = shopkeeper;
	}

	// ----------------------------------Functions---------------------------------

	/**
	 * Adds an item to the various array lists, based on the item's type provided.
	 * 
	 * @param item - The item to be added. Will be casted to another Object type
	 *             when necessary.
	 */
	public void addItem(Item item) {
		shopInventory.add(item);
	}

}
