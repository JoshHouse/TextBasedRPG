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
		this.weapons = new ArrayList<Weapon>();
		this.consumables = new ArrayList<Consumable>();
		this.keyItems = new ArrayList<KeyItem>();
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

		this.weapons = ((enableWeapons == true) ? new ArrayList<Weapon>() : null);
		this.consumables = ((enableConsumables == true) ? new ArrayList<Consumable>() : null);
		this.keyItems = ((enableKeyItems == true) ? new ArrayList<KeyItem>() : null);

	}
	
	/**
	 * Allows for the creation of an inventory with items already in it
	 * 
	 * @param inputWeapons
	 * @param inputConsumables
	 * @param inputKeyItems
	 */
	public Inventory(ArrayList<Weapon> inputWeapons, ArrayList<Consumable> inputConsumables, 
			ArrayList<KeyItem> inputKeyItems) {
		this.weapons = inputWeapons;
		this.consumables = inputConsumables;
		this.keyItems = inputKeyItems;	
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
	
	// ------------------------------Setters-------------------------------
	
	public void setWeapons(ArrayList<Weapon> inputWeapons) {
		this.weapons = inputWeapons;
	}
	
	public void setConsumables(ArrayList<Consumable> inputConsumables) {
		this.consumables = inputConsumables;
	}
	
	public void setKeyItems(ArrayList<KeyItem> inputKeyItems) {
		this.keyItems = inputKeyItems;
	}
	
	// ------------------------------Functions------------------------------
	
	public void add(Item item) {
		
		switch (item.getItemType()) {
		
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
	
	// ------------------------------ToString------------------------------
	public String toString() {
		String returnString = "";
		returnString = returnString + "-----Weapons-----\n";
		for (int x = 0; x < weapons.size(); x++) {
			returnString = returnString + weapons.get(x) + "---------------\n"; 
		}
		returnString = returnString + "-----Consumables-----\n";
		for (int x = 0; x < consumables.size(); x++) {
			returnString = returnString + consumables.get(x) + "---------------\n"; 
		}
		returnString = returnString + "-----KeyItems-----\n";
		for (int x = 0; x < weapons.size(); x++) {
			returnString = returnString + keyItems.get(x) + "---------------\n"; 
		}
		return returnString;
	}
 
}