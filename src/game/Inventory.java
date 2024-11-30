package game;

import java.util.ArrayList;

import indexes.WeaponList;

import java.io.Serial;
import java.io.Serializable;

public class Inventory implements Serializable {
	@Serial
	private static final long serialVersionUID = 4L;
	private static WeaponList wList = new WeaponList();

	private ArrayList<Weapon> weapons;
	private ArrayList<Consumable> consumables;
	private int specialArrows = 0;

	/**
	 * Base constructor
	 */
	public Inventory() {
		this.weapons = new ArrayList<Weapon>();
		this.consumables = new ArrayList<Consumable>();
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
	public Inventory(boolean enableWeapons, boolean enableConsumables) {

		this.weapons = ((enableWeapons == true) ? new ArrayList<Weapon>() : null);
		this.consumables = ((enableConsumables == true) ? new ArrayList<Consumable>() : null);

	}
	
	/**
	 * Allows for the creation of an inventory with items already in it
	 * 
	 * @param inputWeapons
	 * @param inputConsumables
	 * @param inputKeyItems
	 */
	public Inventory(ArrayList<Weapon> inputWeapons, ArrayList<Consumable> inputConsumables) {
		this.weapons = inputWeapons;
		this.consumables = inputConsumables;
	}

	// ------------------------------Getters------------------------------

	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	public ArrayList<Consumable> getConsumables() {
		return consumables;
	}
	
	public Weapon getEquipped() {
		if(this.getWeapons().size() == 0) {
			return wList.nullWeapon;
		} else {
		return weapons.get(0);
		}
	}
	
	
	
	public Weapon getWeaponOnKey(String inputKey) {
		for (int x = 0; x < weapons.size(); x++) {
			if (inputKey.equals(weapons.get(x).getKey())) {
				return weapons.get(x);
			}
		}
		return null;
	}
	
	public int getSpecialArrows() {
		return specialArrows;
	}
	
	
	
	// ------------------------------Setters-------------------------------
	
	public void setWeapons(ArrayList<Weapon> inputWeapons) {
		this.weapons = inputWeapons;
	}
	
	
	
	public void setConsumables(ArrayList<Consumable> inputConsumables) {
		this.consumables = inputConsumables;
	}
	
	public void setSpecialArrows(int count) {
		this.specialArrows = Math.max(0, count);
	}
	
	
	// ------------------------------Functions------------------------------
	
	/**
	 * Adds a single item to the correct inventory based on the item's type.
	 * 
	 * @param item - The item to add.
	 */
	public void add(Item item) {

		switch (item.getItemType()) {

		case 'w':
			this.getWeapons().add((Weapon) item);
			break;
		case 'c':
			this.getConsumables().add((Consumable) item);
			break;
		default:
			System.err.println("Error: Item is corrupted. Cannot be added.");
			break;

		}

	}

	/**
	 * Takes an array of items and adds them to the inventory through the add
	 * function.
	 * 
	 * @param items - The array of items
	 */
	public void addMulti(Item[] items) {

		for (int i = 0; i < items.length; i++) {
			this.add(items[i]);
		}

	}

	// ------------------------------ToString------------------------------

	@Override
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
		return returnString;
	}
 
}