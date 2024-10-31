package game;

import java.util.ArrayList;
import java.util.Random;

public class Shopkeeper extends NPC {

	private String enterShopDialog;
	private String exitShopDialog;
	private String saleDialog;
	private ArrayList<String> inShopDialog;

	// -------------------Constructors-------------------

	/**
	 * Base Constructor
	 */
	public Shopkeeper() {

		super();
		this.enterShopDialog = "null";
		this.saleDialog = "null";
		this.exitShopDialog = "null";
		this.inShopDialog = new ArrayList<String>();

	}

	/**
	 * Instantiates Shopkeepers with other dialog as well as shop dialog
	 * 
	 * @param inputName
	 * @param inputInventory
	 * @param inputDialog
	 * @param inputEnterShopDialog
	 * @param inputExitShopDialog
	 * @param inputSaleDialog
	 * @param inputInShopDialog
	 */
	public Shopkeeper(String inputName, Inventory inputInventory, ArrayList<String> inputDialog,
			String inputEnterShopDialog, String inputExitShopDialog, String inputSaleDialog, 
			ArrayList<String> inputInShopDialog) {

		super(inputName, inputInventory, inputDialog);
		this.enterShopDialog = inputEnterShopDialog;
		this.saleDialog = inputSaleDialog;
		this.exitShopDialog = inputExitShopDialog;
		this.inShopDialog = inputInShopDialog;

	}
	
	/**
	 * Instantiates Shopkeepers that only have shop dialog but no outside dialog
	 * 
	 * @param inputName
	 * @param inputInventory
	 * @param inputEnterShopDialog
	 * @param inputExitShopDialog
	 * @param inputSaleDialog
	 * @param inputInShopDialog
	 */
	public Shopkeeper(String inputName, Inventory inputInventory, String inputEnterShopDialog, 
			String inputExitShopDialog, String inputSaleDialog, ArrayList<String> inputInShopDialog) {

		super(inputName, inputInventory);
		this.enterShopDialog = inputEnterShopDialog;
		this.saleDialog = inputSaleDialog;
		this.exitShopDialog = inputExitShopDialog;
		this.inShopDialog = inputInShopDialog;

	}
	
	/**
	 * Instantiates Shopkeepers who only have shop event dialog and no in shop dialog
	 * 
	 * @param inputName
	 * @param inputInventory
	 * @param inputEnterShopDialog
	 * @param inputExitShopDialog
	 * @param inputSaleDialog
	 */
	public Shopkeeper(String inputName, Inventory inputInventory, String inputEnterShopDialog, 
			String inputExitShopDialog, String inputSaleDialog) {

		super(inputName, inputInventory);
		this.enterShopDialog = inputEnterShopDialog;
		this.saleDialog = inputSaleDialog;
		this.exitShopDialog = inputExitShopDialog;
		this.inShopDialog = new ArrayList<String>();

	}

	// -------------------Getters-------------------

	public String getEnterShopDialog() {
		return this.enterShopDialog;
	}

	public String getExitShopDialog() {
		return this.exitShopDialog;
	}
	
	public String getSaleDialog() {
		return this.saleDialog;
	}
	
	public ArrayList<String> getInShopDialog() {
		return this.inShopDialog;
	}
	
	// -------------------Setters-------------------

	public void setEnterShopDialog(String enterShopDialog) {
		this.enterShopDialog = enterShopDialog;
	}

	public void setExitShopDialog(String exitShopDialog) {
		this.exitShopDialog = exitShopDialog;
	}
	
	public void setSaleDialog(String saleDialog) {
		this.saleDialog = saleDialog;
	}
	
	public void setInShopDialog(ArrayList<String> inputInShopDialog) {
		this.inShopDialog = inputInShopDialog;
	}

	// -------------------Functions-------------------

	/**
	 * Adds dialog options to the inShopDialogs array.
	 * 
	 * @param msg - The message to add.
	 */
	public void addInShopDialog(String msg) {
		this.inShopDialog.add(msg);
	}

	/**
	 * Randomly chooses and displays one of the messages to be seen in shop from the
	 * array list. If the array is empty, it will display extended ellipses instead.
	 * 
	 * @return Returns a message from within the array, or extended ellipses.
	 */
	public String displayInShopDialog() {

		Random index = new Random();

		if (inShopDialog.size() < 1) {
			return ".........";
		}

		return "[" + this.getName() + "]\n"
				+ "\"" + inShopDialog.get(index.nextInt(inShopDialog.size())) + "\"";

	}
	
	// -------------------toString-------------------
	public String toString() {
		String tempDialog = "";
		for (int x = 0; x < inShopDialog.size(); x++) {
			tempDialog = tempDialog + inShopDialog.get(x) + "\n";
		}
		return super.toString() + 
				this.enterShopDialog + "\n" +
				this.saleDialog + "\n" +
				this.exitShopDialog + "\n" +
				tempDialog;
	}

}
