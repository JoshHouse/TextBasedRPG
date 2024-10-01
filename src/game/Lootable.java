package game;

public class Lootable {
	/**
	 * 
	 * ----- Variables -----
	 * 
	 */
	
	Item[] Inventory;
	String Name;
	
	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */
	
	// Default constructor
	public Lootable() {
		this.Inventory = new Item[0];
		this.Name = "No Name";
	}
	
	// Constructor that initializes inventory and name
	public Lootable(Item[] InputInventory, String InputName) {
		this.Inventory = InputInventory;
		this.Name = InputName;
	}
	
	// Constructor that initializes Name and makes Inventory an empty Item array
	public Lootable(String InputName) {
		this.Inventory = new Item[0];
		this.Name = InputName;
	}
	
	// Constructor that initializes Inventory and makes Name a default string
	public Lootable(Item[] InputInventory) {
		this.Inventory = InputInventory;
		this.Name = "No Name";
	}
	
	/**
	 * 
	 * ----- Getters -----
	 * 
	 */
	
	public Item[] getInventory() {
		return this.Inventory;
	}
	
	public String getName() {
		return this.Name;
	}
	
	/**
	 * 
	 * ----- Setters -----
	 * 
	 */
	
	public void setInventory(Item[] InputInventory) {
		this.Inventory = InputInventory;
	}
	
	public void setName(String InputName) {
		this.Name = InputName;
	}
	
	/**
	 * 
	 * ToString method
	 * 
	 */
	public String toString() {
		
		// For loop to convert Inventory into a string
		String TempInventory = "";
		for (int x = 0; x < Inventory.length; x++) {
			TempInventory = TempInventory + Inventory[x] + "-------" + "\n";
		}
		
		return "Name: " + this.Name + "\n" +
				"Inventory: " + "\n" + "-------" + "\n" + TempInventory;
		
	}
}