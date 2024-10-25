package game;

import java.util.ArrayList;

public class NPC extends Lootable {
	
	// -------------------Variables-------------------
	
	protected ArrayList<String> dialog;
	
	// -------------------Constructors-------------------
	
	/**
	 * Default Constructor
	 */
	NPC() {
		super();
		this.dialog = new ArrayList<String>();
	}
	
	/**
	 * Instantiates an NPC with a name, inventory, and an arraylist of dialog 
	 * 
	 * @param inputName
	 * @param inputInventory
	 * @param inputDialog
	 */
	NPC(String inputName, Inventory inputInventory, ArrayList<String> inputDialog) {
		super(inputName, inputInventory);
		this.dialog = inputDialog;
		
	}
	
	/**
	 * Instantiates NPCS that don't have shops
	 * 
	 * @param inputName
	 * @param inputDialog
	 */
	NPC(String inputName, ArrayList<String> inputDialog) {
		super(inputName);
		this.dialog = inputDialog;
	}
	
	/**
	 * Constructor for shopkeepers who dont have other dialog options
	 * only takes a name and an inventory
	 * 
	 * @param inputName
	 * @param inputInventory
	 */
	NPC(String inputName, Inventory inputInventory) {
		super(inputName, inputInventory);
		this.dialog = new ArrayList<String>();
		
	}
	
	// -------------------Getters-------------------
	
	public ArrayList<String> getDialog() {
		return this.dialog;
	}
	
	// -------------------Setters-------------------
	
	public void setDialog (ArrayList<String> inputDialog) {
		this.dialog = inputDialog;
	}
	
	// -------------------toString-------------------
	
	public String toString() {
		// For loop to convert Inventory into a string
		String tempDialog = "";
		
		if (dialog.size() > 0) {
			tempDialog = tempDialog + "-----Dialog-----\n";
		}
		
		for (int x = 0; x < dialog.size(); x++) {
			tempDialog = tempDialog + this.dialog.get(x) + "\n";
		}
		return super.toString() + tempDialog;
				
 	}
	
}
