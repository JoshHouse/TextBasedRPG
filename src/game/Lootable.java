package game;

public class Lootable {
	
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
	
	// -------------------toString-------------------
	
	public String toString() {
		return "Name: " + this.name + "/n" + 
				"Currency: " + this.currency + "/n" + 
				"Inventory: /n" + inventory.toString();
		
	}
}