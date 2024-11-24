package game;

import java.io.Serial;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lootable implements Serializable {
	@Serial
	private static final long serialVersionUID = 2L;

	// -------------------Variables-------------------
	
	private Inventory inventory;
	private String name;
	private int currency;
	
	// -------------------Constructors-------------------
	
	/**
	 * Default constructor
	 */
	public Lootable() {
		this.name = "null";
		this.inventory = new Inventory();
		this.currency = 0;
	}
	
	/**
	 * Constructor that initializes inventory, name, and currency
	 * 
	 * @param inputName
	 * @param inputInventory
	 * @param inputCurrency
	 */
	public Lootable(String inputName, Inventory inputInventory, int inputCurrency) {
		this.name = inputName;
		this.inventory = inputInventory;
		this.currency = inputCurrency;
	}
	
	/**
	 * Constructor that initializes name and inventory but sets currency to 0
	 * 
	 * @param inputName
	 * @param inputInventory
	 */
	public Lootable(String inputName, Inventory inputInventory) {
		this.name = inputName;
		this.inventory = inputInventory;
		this.currency = 0;
	}
	
	/**
	 * Constructor that initializes name and currency but creates a default inventory
	 * 
	 * @param inputName
	 * @param inputCurrency
	 */
	public Lootable(String inputName, int inputCurrency) {
		this.name = inputName;
		this.inventory = new Inventory();
		this.currency = inputCurrency;
	}
	
	/**
	 * Constructor that initializes Name, but sets currency to 0 and creates a default Inventory
	 * 
	 * @param inputName
	 */
	public Lootable(String inputName) {
		this.name = inputName;
		this.inventory = new Inventory();
		this.currency = 0;
	}
	
	// -------------------Getters-------------------
	
	public String getName() {
		return this.name;
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
	public int getCurrency() {
		return this.currency;
	}
	
	// -------------------Setters-------------------
	
	public void setName(String inputName) {
		this.name = inputName;
	}
	
	public void setInventory(Inventory inputInventory) {
		this.inventory = inputInventory;
	}
	
	public void setCurrency(int inputCurrency) {
		this.currency = inputCurrency;
	}
	
	// -------------------Functions-------------------

	/**
	 * Allows the user to loot weapons and consumables from the enemy after a battle, provided they have said items to loot.
	 * @param enemy
	 * @param scn
	 */
	public void loot(Enemy enemy, Scanner scn) {

		int speed = 10, // Dialogue box speed
				arrlen; // array length
		String printStr; // For dialogue function
		Inventory items = enemy.getInventory(); // Inventory
		Weapon selWep; // Selected weapon
		Consumable selCon; // Selected consumable

		// booleans for controlling menus
		boolean isLooting = true, lootWeapons = false, lootConsumables = false, lootAll = false;

		// variables for user input
		char menuInput;
		int lootInput = 0;

		// ----------------------------Main Looting Menu----------------------------
		while (isLooting) {

			if (items.getWeapons().size() == 0 && items.getConsumables().size() == 0) {
				isLooting = false;
				return; // The enemy has no items to loot, so the function is exited
			}

			// Choose what sub-menu to access
			Dialogue.infoDialogue("Choose what to take from " + enemy.getName() + "\n", speed);
			Dialogue.infoDialogue("1) Weapons\n2) Consumables\n3) Take All\n4) Finish\nSelect: ", speed);
			menuInput = scn.next().charAt(0);
			System.out.println();

			switch (menuInput) {

			case '1': // Loot weapons
				lootWeapons = true;
				break;
			case '2': // Loot consumables
				lootConsumables = true;
				break;
			case '3': // Loot everything
				lootAll = true;
				break;
			case '4': // Leave loot function
				isLooting = false;
				break;
			default: // Invalid input
				System.err.println("[Invalid Input. Try Again]\n");
				Pause.pause(350);
				break;
			}

			// ----------------------------Loot Weapons----------------------------
			while (lootWeapons) {

				arrlen = items.getWeapons().size();
				if (arrlen == 0) { // Initial check for an empty array
					Dialogue.infoDialogue("No weapons available.\n", speed);
					Pause.pause();
					lootWeapons = false;
					break; // Exit while-loop
				}

				// Print all the weapons the enemy has in their inventory
				Dialogue.infoDialogue(enemy.getName() + "'s Weapons\n------------------------------\n\n", speed);

				for (int i = 0; i < arrlen; i++) {

					printStr = i + 1 + ") " + items.getWeapons().get(i).getName();
					printStr += ((i + 1) % 3 == 0) ? "\n" : "\t";
					Dialogue.infoDialogue(printStr, speed);

				}
				Dialogue.infoDialogue((arrlen + 1) + ") Cancel\nSelect: ", speed);

				// Make your selection
				try {
					lootInput = scn.nextInt();

					if (lootInput < 1 || lootInput > arrlen + 1) {
						throw new IndexOutOfBoundsException(); // Throw exception for invalid input
					} else if (lootInput == arrlen + 1) {
						lootWeapons = false; // Cancel
					} else {

						System.out.println();

						// Print info about weapon and ask for confirmation
						selWep = items.getWeapons().get(lootInput - 1);
						printStr = selWep.getName() + "\nPrice: " + selWep.getValue()
								+ "\n\nTake this?\nY) Yes\t\tN) No\nSelect: ";
						Dialogue.infoDialogue(printStr, speed);
						menuInput = scn.next().charAt(0); // Get confirmation

						switch (menuInput) {

						case 'Y', 'y':
							this.getInventory().add(selWep); // add weapon to your inventory
							items.getWeapons().remove(lootInput - 1); // remove from enemy's inventory

							// Secondary check for empty array
							if (items.getWeapons().size() == 0) {
								lootWeapons = false;
							}
							break;
						case 'N', 'n': // Do nothing if selecting no
							break;
						default: // Invalid input
							System.err.println("[Invalid Input. Try Again]");
							Pause.pause(350);
							break;

						}
						System.out.println();

					}

					/*
					 * InputMismatchException catches non-integer inputs IndexOutOfBoundsException
					 * catches integers not within the selection bounds
					 */
				} catch (InputMismatchException | IndexOutOfBoundsException e) {
					System.err.println("[Invalid Input. Try Again]\n");
					Pause.pause(350);
				}

			}

			// ----------------------------Loot Consumables----------------------------
			while (lootConsumables) {

				arrlen = items.getConsumables().size();
				if (arrlen == 0) { // Initial check for an empty array
					Dialogue.infoDialogue("No consumables available.\n", speed);
					Pause.pause();
					lootConsumables = false;
					break; // exit while-loop
				}

				// Print all the consumables the enemy has in their inventory
				Dialogue.infoDialogue(enemy.getName() + "'s Consumables\n------------------------------\n\n", speed);

				for (int i = 0; i < arrlen; i++) {

					printStr = i + 1 + ") " + items.getConsumables().get(i).getName();
					printStr += ((i + 1) % 3 == 0) ? "\n" : "\t";
					Dialogue.infoDialogue(printStr, speed);

				}
				Dialogue.infoDialogue((arrlen + 1) + ") Cancel\nSelect: ", speed);

				try {

					lootInput = scn.nextInt();

					if (lootInput < 1 || lootInput > arrlen + 1) {
						throw new IndexOutOfBoundsException();
					} else if (lootInput == arrlen + 1) {
						lootConsumables = false;
					} else {

						System.out.println();

						// Print info about consumable and ask for confirmation
						selCon = items.getConsumables().get(lootInput - 1);
						printStr = selCon.getName() + "\nPrice: " + selCon.getValue() + "\nAmount: " + selCon.getCount()
								+ "\n\nTake this?\nY) Yes\t\tN) No\nSelect: ";
						Dialogue.infoDialogue(printStr, speed);
						menuInput = scn.next().charAt(0); // Get confirmation

						switch (menuInput) {

						case 'Y', 'y':
							this.getInventory().add(selCon); // Add consumable to your inventory
							items.getConsumables().remove(lootInput - 1); // Remove from enemy's inventory

							// Secondary check for empty array
							if (items.getConsumables().size() == 0) {
								lootConsumables = false;
							}
							break;
						case 'N', 'n': // Do nothing if selecting no
							break;
						default: // Invalid input
							System.err.println("[Invalid Input. Try Again]");
							Pause.pause(350);
							break;

						}
						System.out.println();

					}

					/*
					 * InputMismatchException catches non-integer inputs IndexOutOfBoundsException
					 * catches integers not within the selection bounds
					 */
				} catch (InputMismatchException | IndexOutOfBoundsException e) {
					System.err.println("[Invalid Input. Try Again]\n");
					Pause.pause(350);
				}

			}

			// ----------------------------Loot Everything----------------------------
			while (lootAll) {

				// Get the sizes of both the arrayLists
				int weplen = items.getWeapons().size(), conlen = items.getConsumables().size();

				if (weplen > 0) { // If the weapons array isn't empty, the code below runs

					Item[] weapons = new Item[weplen]; // Create an item array with length of the weapons array
					for (int i = 0; i < weplen; i++) {
						weapons[i] = items.getWeapons().get(i); // Add each weapon to the item array
					}

					this.getInventory().addMulti(weapons); // add all the weapons to your inventory

				}

				if (conlen > 0) { // If the consumables array isn't empty, the code below runs

					Item[] consumables = new Item[conlen]; // Create an item array with length of the consumables array
					for (int i = 0; i < conlen; i++) {
						consumables[i] = items.getWeapons().get(i); // Add each consumable to the item array
					}

					this.getInventory().addMulti(consumables); // add all the consumables to your inventory

				}

				// There's no more items left to take, so these are set to false to exit the
				// loot function
				lootAll = false;
				isLooting = false;

			}

		}

	}

	@Override
	/**
	 * Classic toString method. Returns the name, currency, and inventory of the
	 * object when called.
	 */
	public String toString() {
		return "Name: " + this.name + "/n" + "Currency: " + this.currency + "/n" + "Inventory: /n"
				+ inventory.toString();

	}
}