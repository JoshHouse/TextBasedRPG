package game;

import java.util.ArrayList;

public class Inventory {

	private ArrayList<Weapon> weapons;
	private ArrayList<Consumable> consumables;
	private ArrayList<KeyItem> keyItems;

	/**
	 * Base constructor
	 */
	public Inventory() {
		weapons = null;
		consumables = null;
		keyItems = null;
	}

	/**
	 * Based on the values provided, it will enable the creation of certain
	 * inventories.
	 * 
	 * @param enableWeapons     - Enables the inventory of weapons.
	 * @param enableConsumables - Enables the inventory of consumables.
	 * @param enableArrows      - Enables the inventory of arrows.
	 * @param enableKeyItems    - Enables the inventory of key items.
	 */
	public Inventory(boolean enableWeapons, boolean enableConsumables, boolean enableKeyItems) {

		weapons = ((enableWeapons == true) ? new ArrayList<Weapon>() : null);
		consumables = ((enableConsumables == true) ? new ArrayList<Consumable>() : null);
		keyItems = ((enableKeyItems == true) ? new ArrayList<KeyItem>() : null);

	}

	// ------------------------------Getters------------------------------

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	public ArrayList<Consumable> getConsumables() {
		return consumables;
	}

	public ArrayList<KeyItem> getKeyItems() {
		return keyItems;
	}
	
	// ------------------------------Functions------------------------------
	
	public void add(Item item) {
		
		switch (item.getKey().charAt(0)) {
		
		case 'w':
			this.getWeapons().add((Weapon) item);
			break;
		case 'c':
			this.getConsumables().add((Consumable) item);
			break;
		case 'k':
			this.getKeyItems().add((KeyItem) item);
			break;
		default:
			System.err.println("Error: Item is corrupted. Cannot be added.");
			break;
		
		}
		
	}

}