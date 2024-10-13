package game;

import java.util.ArrayList;
import java.util.Random;

public class Shopkeeper extends GameChar {

	private String enterMsg;
	private String saleMsg;
	private String exitMsg;
	private ArrayList<String> inShopMsgs;

	// -------------------Constructors-------------------

	/**
	 * Base Constructor
	 */
	public Shopkeeper() {

		super();
		this.enterMsg = "";
		this.saleMsg = "";
		this.exitMsg = "";
		this.inShopMsgs = null;

	}

	/**
	 * Constructor for initializing shopkeepers with a name, and various dialog.
	 * 
	 * @param name     - Shopkeeper's name
	 * @param enterMsg - Message for when you enter the shop
	 * @param saleMsg  - Message for a complete sale
	 * @param exitMsg  - Message for when you exit the shop
	 */
	public Shopkeeper(String name, String enterMsg, String saleMsg, String exitMsg) {

		super(name);
		this.setEnterMsg(enterMsg);
		this.setSaleMsg(saleMsg);
		this.setExitMsg(exitMsg);
		this.inShopMsgs = new ArrayList<String>();

	}

	// -------------------Getters-------------------

	public String getEnterMsg() {
		return "[" + getName() + "]\n"
				+ "\"" + this.enterMsg + "\"";
	}

	public String getSaleMsg() {
		return "[" + getName() + "]\n"
				+ "\"" + this.saleMsg + "\"";
	}

	public String getExitMsg() {
		return "[" + getName() + "]\n"
				+ "\"" + this.exitMsg + "\"";
	}

	// -------------------Setters-------------------

	public void setEnterMsg(String enterMsg) {
		this.enterMsg = enterMsg;
	}

	public void setSaleMsg(String saleMsg) {
		this.saleMsg = saleMsg;
	}

	public void setExitMsg(String exitMsg) {
		this.exitMsg = exitMsg;
	}

	// -------------------Functions-------------------

	/**
	 * Adds dialog options to the inShopMsgs array.
	 * 
	 * @param msg - The message to add.
	 */
	public void addInShopMsg(String msg) {
		this.inShopMsgs.add(msg);
	}

	/**
	 * Randomly chooses and displays one of the messages to be seen in shop from the
	 * array list. If the array is empty, it will display extended ellipses instead.
	 * 
	 * @return Returns a message from within the array, or extended ellipses.
	 */
	public String displayInShopMsg() {

		Random index = new Random();

		if (inShopMsgs.size() < 1) {
			return ".........";
		}

		return "[" + getName() + "]\n"
				+ "\"" + inShopMsgs.get(index.nextInt(inShopMsgs.size())) + "\"";

	}

}
