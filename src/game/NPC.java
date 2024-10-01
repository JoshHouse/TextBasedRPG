package game;

public class NPC extends Character {
	
	/**
	 * 
	 * ----- Variables -----
	 * 
	 */
	
	String EnterShopDialog;
	String ExitShopDialog;
	String SaleDialog;
	String[] Dialog;
	
	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */
	
	// Default Constructor
	NPC() {
		super();
		this.EnterShopDialog = "No Dialog";
		this.ExitShopDialog = "No Dialog";
		this.SaleDialog = "No Dialog";
		this.Dialog = new String[0];
	}
	
	// NPC constructor that instantiates name, inventory, and all values special to the NPC class
	NPC(String InputName, Item[] InputInventory, String InputEnterShopDialog, String InputExitShopDialog,
			String InputSaleDialog, String[] InputDialog) {
		super(InputName, InputInventory);
		this.EnterShopDialog = InputEnterShopDialog;
		this.ExitShopDialog = InputExitShopDialog;
		this.SaleDialog = InputSaleDialog;
		this.Dialog = InputDialog;
	}
	
	// NPC constructor that instantiates NPCS that don't have shops
	NPC(String InputName, Item[] InputInventory, String[] InputDialog) {
		super(InputName, InputInventory);
		this.EnterShopDialog = "No Dialog";
		this.ExitShopDialog = "No Dialog";
		this.SaleDialog = "No Dialog";
		this.Dialog = InputDialog;
	}
	
	// NPC constructor that instantiates Shop NPCs with no other Dialog options
	NPC(String InputName, Item[] InputInventory, String InputEnterShopDialog, String InputExitShopDialog,
			String InputSaleDialog) {
		super(InputName, InputInventory);
		this.EnterShopDialog = InputEnterShopDialog;
		this.ExitShopDialog = InputExitShopDialog;
		this.SaleDialog = InputSaleDialog;
		this.Dialog = new String[0];
	}
	
	/**
	 * 
	 * ----- Getters -----
	 * 
	 */
	
	public String getEnterShopDialog() {
		return this.EnterShopDialog;
	}
	
	public String getExitShopDialog() {
		return this.ExitShopDialog;
	}
	
	public String getSaleDialog() {
		return this.SaleDialog;
	}
	
	public String[] getDialog() {
		return this.Dialog;
	}
	
 	/**
	 * 
	 * ----- Setters -----
	 * 
	 */
	
	public void setEnterShopDialog (String InputEnterShopDialog) {
		this.EnterShopDialog = InputEnterShopDialog;
	}
	
	public void setExitShopDialog (String InputExitShopDialog) {
		this.ExitShopDialog = InputExitShopDialog;
	}
	
	public void setSaleDialog (String InputSaleDialog) {
		this.SaleDialog = InputSaleDialog;
	}
	
	public void setDialog (String[] InputDialog) {
		this.Dialog = InputDialog;
	}
	
 	/**
	 * 
	 * ----- To-String -----
	 * 
	 */
	
	public String toString() {
		// For loop to convert Inventory into a string
		String TempDialog = "";
		for (int x = 0; x < Dialog.length; x++) {
			TempDialog = TempDialog + Inventory[x] + "\n";
		}
		return super.toString() + "\n" +
				"Enter Shop Dialog: " + this.EnterShopDialog + "\n" +
				"Exit Shop Dialog: " + this.ExitShopDialog + "\n" +
				"Sale Dialog: " + this.SaleDialog + "\n" + 
				"Dialog: " + "\n" +  TempDialog;
				
 	}
	
}
