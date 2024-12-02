package game;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serial;
import java.io.Serializable;

public class Shop implements Serializable {
	@Serial
	private static final long serialVersionUID = 5L;

	private String name;
	private Player player;
	private Shopkeeper shopkeeper;
	private int txtSpd = 25;

	// ----------------------------------Constructors---------------------------------

	/**
	 * Constructor that creates a shop with a player and a shopkeeper
	 * 
	 * @param inputPlayer
	 * @param inputShopkeeper
	 */
	public Shop(Player inputPlayer, Shopkeeper inputShopkeeper, String inputName) {
		this.setPlayer(inputPlayer);
		this.setShopkeeper(inputShopkeeper);
		this.setName(inputName);
	}

	// ----------------------------------Getters---------------------------------

	public Player getPlayer() {
		return this.player;
	}

	public Shopkeeper getShopkeeper() {
		return this.shopkeeper;
	}
	
	public String getName() {
		return this.name;
	}

	// ----------------------------------Setters---------------------------------

	public void setPlayer(Player inputPlayer) {
		this.player = inputPlayer;
	}

	public void setShopkeeper(Shopkeeper inputShopkeeper) {
		this.shopkeeper = inputShopkeeper;
	}
	
	public void setName(String inputName) {
		this.name = inputName;
	}

	// ----------------------------------Functions---------------------------------
	
	/*
	 * 
	 * ---------------------Formatting and Display Functions-------------------------
	 * 
	 */
	
	/**
	 * Prints a line break to improve readability between menus
	 */
	public static void breakLine() {  
	    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
	} 
	
	/**
	 * Prints the players current currency throughout the shop function
	 */
	public void printPlayerCurrency() {
		Dialogue.infoDialogue("Your currency: " + this.getPlayer().getCurrency() + "\n", txtSpd);
	}
	
	/**
	 * Prints weapon array in order with name and value
	 * *List is 1 based. Any user choice made in the menu based on this print statement will 
	 * also be 1 based and therefore will need to be converted to 0 based in calculations*
	 * 
	 * @param arrayList		-weapons array to be printed
	 */
	private void printInventoryWeaponsArray(ArrayList<Weapon> arrayList) {
		for(int x = 0; x < arrayList.size(); x++) {
			Dialogue.infoDialogue(x+1 + ") " + arrayList.get(x).getName() + 
					"\n\t -Type: " + arrayList.get(x).getDamageType() +
					"\n\t -Value: " + arrayList.get(x).getValue() + "\n", 10);
		}
		
	}
	
	/**
	 * Prints consumable array in order with name and value
	 * *List is 1 based. Any user choice made in the menu based on this print statement will 
	 * also be 1 based and therefore will need to be converted to 0 based in calculations*
	 * 
	 * @param arrayList		-consumable array to be printed
	 */
	private void printInventoryConsumableArray(ArrayList<Consumable> arrayList) {
		for(int x = 0; x < arrayList.size(); x++) {
			Dialogue.infoDialogue(x+1 + ") " + arrayList.get(x).getName() + 
					"\t Value: " + arrayList.get(x).getValue() + "\n", 1);
		}
	}
	
	/*
	 * 
	 * 
	 * ---------------------Start Shop functionality-------------------------
	 * 
	 * 
	 */
	
	/**
	 * Starts the shop functionality, handling all menus, buying, and selling functionality
	 */
	public void startShop(Scanner scn) {

		char shopMenu; // Handles shop menu choice
		boolean isShopping = true; // When player finishes shopping, it will be set to false
		
		
		// Print statements for entering the shop
		System.out.println("-------------Entering: " + this.getName() + "-------------\n");
		Dialogue.characterDialogue(this.getShopkeeper().getName(), this.getShopkeeper().getEnterShopDialog() + "\n", txtSpd);
		breakLine();
		
		
		// While loop for main shop menu
		while (isShopping) {
			// Displays menu and gets player menu choice
			Dialogue.infoDialogue("What would you like to do?\n" + 
					"1) Buy\n" + 
					"2) Sell\n" + 
					"3) Leave" + "\n", txtSpd);
			shopMenu = scn.next().charAt(0);
			
			// Switch statement for player menu choice
			switch (shopMenu) {
			
			case '1': // Buy
				this.BuyMenu(scn);	// Handles buy menu functionality. Passes scn scanner into the buy menu
				breakLine();
				break;
				
			case '2': // Sell
				this.SellMenu(scn); // Handles sell menu functionality. Passes scn scanner into the sell menu
				breakLine();
				break;
				
			case '3': // Leave
				isShopping = false;	// Exits shop
				break;
				
			default: // Handles invalid input
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
				break;

			}

		}
		
		Dialogue.characterDialogue(this.getShopkeeper().getName(), this.getShopkeeper().getExitShopDialog() + "\n", txtSpd);
		System.out.println("-------------Leaving: " + this.getName() + "-------------\n");

	}

	/*
	 * 
	 * ---------------------Buy Menu Functionality-------------------------
	 * 
	 */
	
	/**
	 * Handles all buy menu functionality
	 * 
	 * @param scn	- For user input
	 */
	private void BuyMenu(Scanner scn) {
		boolean isBuying = true;	// Keeps user in the buy menu while buying. Is set to false based on user menu choice
		char pMainMenuChoice = 0;	// Holds user menu choice
		
		
		// Formatting print statements and displays Shopkeeper in shop dialog
		breakLine();
		Dialogue.characterDialogue(this.getShopkeeper().getName(), this.getShopkeeper().displayInShopDialog() + "\n", txtSpd);
		
		// While loop to keep user in the buy menu
		while (isBuying) {
			
			// Print statement for menu options and obtains user menu choice
			Dialogue.characterDialogue(this.getShopkeeper().getName(), "What are you in the market for today?\n" + 
					"1) Weapons\n" + 
					"2) Consumables\n" + 
					"3) Special Arrows\n" +
					"4) Cancel" + "\n", txtSpd);
			pMainMenuChoice = scn.next().charAt(0);
			
			// Switch statement to process user choice
			switch (pMainMenuChoice) {
			
			case '1':	// Weapons buy menu
				this.weaponsBuyMenu(scn);	// Handles the weapons buy menu functionality
				break;
			
			case '2': // Consumables buy menu
				this.consumablesBuyMenu(scn); // Handles the consumables buy menu functionality
				break;
				
			case '3': //Special Arrows buy menu
				
				this.buySpArrows(scn);
				
				break;
			
			case '4': // Back to main menu
				isBuying = false;	// exits the buy menu
				break;
			default: // Handles invalid choice
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
				break;
			}
		}
	}
	
	
	
	/*
	 * ----------------Weapons Buy Menu Functionality-------------------
	 */
	
	/**
	 * Handles weapon buy menu functionality
	 * 
	 * @param scn	- For taking user input
	 */
	public void weaponsBuyMenu(Scanner scn) {
		ArrayList<Weapon> tempWeaponsArray = this.getShopkeeper().getInventory().getWeapons(); // For storing weapon purchase options. Prevents repeating get statements
		boolean isBuyingWeapons;	// Keeps player in buying weapons menu. Set to false based on user choice
		char pMenuChoice;
		String pItemChoice;	// pMenuChoice processes user decision for menu. pItemChoice processes user decision for inspecting items
		int selection;
		
		
		// Displays initial purchasable weapon options
		breakLine();
		Dialogue.characterDialogue(this.getShopkeeper().getName(), 
				"We've got a great selection of weapons for you today. Heres what we got:" + "\n", txtSpd);
		this.printInventoryWeaponsArray(tempWeaponsArray);
		this.printPlayerCurrency();
		Dialogue.characterDialogue(this.getShopkeeper().getName(), 
				"Now that you have seen what we have in stock," + "\n", txtSpd);
		
		// While loop for buying weapons menu
		isBuyingWeapons = true;
		while (isBuyingWeapons) {
			// Print statements for displaying menu and getting user menu choice
			Dialogue.characterDialogue(this.getShopkeeper().getName(), "What would you like to do?\n" +
					"1) Ready to purchase!\n" +
					"2) I want more details on an item\n" +
					"3) I would like to look at my other options" + "\n", txtSpd);
			pMenuChoice = scn.next().charAt(0);
			
			// Switch statement for processing user's menu choice
			switch (pMenuChoice) {
			
			case '1': // Make a purchase
				breakLine();
				this.attemptWeaponPurchase(scn, tempWeaponsArray);	// Processes weapons purchase functionality. Takes scn scanner and weapons array
				break;
			
			case '2': // More details on an item
				// Reprints weapon options and prompts user for what item they would like more details on. Then takes the user's choice
				breakLine();
				this.printInventoryWeaponsArray(tempWeaponsArray);
				Dialogue.characterDialogue(this.getShopkeeper().getName(), 
						"What is the number of the item you would like to hear more about?" + "\n", txtSpd);
				pItemChoice = scn.next();	// Will be one based. printInventoryWeaponsArray function prints list as one based list
				if (isNumeric(pItemChoice)) {
					selection = Integer.parseInt(pItemChoice);
				} else {
					selection = -1;
				}
				// If statement to ensure that player's choice is in the array. Player choice is 1 based so must be converted to 0 based in calculations
				if (selection - 1 < tempWeaponsArray.size() && selection - 1 >= 0) {
					
					// Prints info on the chosen weapon. Reprints inventory & currency for the buying weapons menu
					breakLine();
					Dialogue.characterDialogue(this.getShopkeeper().getName(), 
							"Absolutely! Here is the information about that weapon!" + "\n", txtSpd);
					tempWeaponsArray.get(selection - 1).displayInfo();
					this.printInventoryWeaponsArray(tempWeaponsArray);
					this.printPlayerCurrency();
					
				} else { // Invalid choice handling
					// Prints an error message and reprints inventory & currency for the buying weapons menu
					breakLine();
					System.err.println("(Invalid choice. Please try again.)");
					this.printInventoryWeaponsArray(tempWeaponsArray);
					this.printPlayerCurrency();
				}
				break;
			
			case '3': // Escape Weapons buy menu
				breakLine();
				Dialogue.characterDialogue(this.getShopkeeper().getName(), "Alright you can always look at the weapons again if you would like!" + "\n", txtSpd);
				isBuyingWeapons = false; // Breaks out of the weapons buy menu, returning to buy menu
				break;
			default: // Invalid input handling
				// Prints an error and reprints weapons array & currency for the buying weapons menu
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
				this.printInventoryWeaponsArray(tempWeaponsArray);
				this.printPlayerCurrency();
				break;
			}
		}
	}
	
	/**
	 * Handles Weapons Purchase functionality
	 * 
	 * @param scn		-For handling user input
	 * @param arrayList		-For displaying weapons options and calculations on user purchase choices
	 */
	public void attemptWeaponPurchase(Scanner scn, ArrayList<Weapon> arrayList) {
		boolean successfulPurchase;  	// Tracks whether the purchase was successful
		boolean isPurchacing;			// Used to keep user in the purchasing menu
		String pItemChoice;			// Stores user item purchase choice
		int selection;
		
		
		// Print for entering the purchase menu
		Dialogue.characterDialogue(this.getShopkeeper().getName(), "Good to hear!" + "\n", txtSpd);
		
		// While loop to keep user in the purchase menu. Is set to false based on user choice
		isPurchacing = true;
		while (isPurchacing) {
			
			// Prints purchasable weapons list, with an extra option to cancel purchase. 
			this.printInventoryWeaponsArray(arrayList);
			Dialogue.infoDialogue(arrayList.size()+1 + ") Cancel " + "\n", txtSpd);
			
			// Prints player's currency, prompts the user for what item they would like to purchase, and stores user's choice.
			this.printPlayerCurrency();
			Dialogue.characterDialogue(this.getShopkeeper().getName(), "What is the number of the item you would like to buy?" + "\n", txtSpd);
			pItemChoice = scn.next();
			if (isNumeric(pItemChoice)) {
				selection = Integer.parseInt(pItemChoice);
			} else {
				selection = -1;
			}
			
			// If statement to ensure players choice is on the list. pItemChoice - 1 <= arrayList.size() is to include cancel as the last option
			if (selection - 1 <= arrayList.size() && selection - 1 >= 0) {
				// Checks to see if user has selected cancel
				
				if (selection - 1 == arrayList.size()) {
					isPurchacing = false; 	// breaks out of the purchasing menu
					// Prints weapons list and currency for buy weapons menu
					breakLine();
					this.printInventoryWeaponsArray(arrayList);
					this.printPlayerCurrency();
					
				} else {	// Handle's purchase choice because choice is not to cancel
					successfulPurchase = this.buyingWeapons(arrayList.get(selection - 1));	// attempts to buy selected item. Buying Weapons function returns a boolean
			
					if (successfulPurchase) {	// Handles if the purchase was successful
						breakLine();
						// Prints confirmation message and shopkeeper's sale dialog
						Dialogue.infoDialogue("You have a new weapon in your inventory! Your updated currency: " 
						+ this.getPlayer().getCurrency() + "\n", txtSpd);
						Dialogue.characterDialogue(this.getShopkeeper().getName(), 
								this.getShopkeeper().getSaleDialog() + "\n", txtSpd);
						
						isPurchacing = false;	// Breaks out of the is purchasing menu
						
						// reprints weapons list & player currency for buy menu
						this.printInventoryWeaponsArray(arrayList);
						this.printPlayerCurrency();
						
					} else { 	// Handles failed purchase. Purchases only fail if the player does not have enough currency
						breakLine();
						// Informs the player they don't have enough currency and lists their currency & the price of the item
						Dialogue.infoDialogue("You don't have enough currency to buy this item.\n" + 
								"Your currency is: " + this.getPlayer().getCurrency() + "\n" +
								"The cost of that item is: " + arrayList.get(selection - 1).getValue() + "\n", txtSpd);
					}
				}
			
			} else {	// Handles invalid input
				breakLine();
				// Prints an error message informing the player their choice was not on the list
				System.err.println("(Invalid choice. Please try again.)");
			}
		}
	}
	
	/**
	 * Handles the buying of a weapon. Only returns false if the player does not have enough currency
	 * 
	 * @param product			- The item the user is attempting to purchase
	 * @return true or false	- Whether the purchase was successful
	 */
	public boolean buyingWeapons(Weapon product) {
		if (product.getValue() <= this.getPlayer().getCurrency()) {
			this.getPlayer().setCurrency(this.getPlayer().getCurrency() - product.getValue());
			this.getPlayer().getInventory().add(product);
			return true;
		} 
		return false;
	}
	
	/*
	 * -------------------------Buy Consumables Menu Functionality-------------------------
	 */
	
	/**
	 * Handles consumables buy menu functionality
	 * 
	 * @param scn		- for processing user input
	 */
	public void consumablesBuyMenu(Scanner scn) {
		ArrayList<Consumable> tempConsumablesArray = this.getShopkeeper().getInventory().getConsumables(); // Stores shopkeepers consumable options. Prevents repeating get calls
		boolean isBuyingConsumables = true;	// Keeps user in the consumables buy menu. Is set to false based on user's choice
		char pMenuChoice;
		String pItemChoice;	// pMenuChoice stores user menu choice. pItemChoice stores user's consumable choice for inspect functionality
		int selection;
		
		
		// Entering the consumables buy menu print statements.  Prints consumable purchase options and player currency
		breakLine();
		Dialogue.characterDialogue(this.getShopkeeper().getName(), 
				"We've got a great selection of consumables for you today. Heres what we got:" + "\n", txtSpd);
		this.printInventoryConsumableArray(tempConsumablesArray);
		this.printPlayerCurrency();
		Dialogue.characterDialogue(this.getShopkeeper().getName(), 
				"Now that you have seen what we have in stock," + "\n", txtSpd);
		
		// While loop to keep user in the buying consumables menu. 
		while (isBuyingConsumables) {
			
			// Prints the buy consumables menu and stores player choice
			Dialogue.characterDialogue(this.getShopkeeper().getName(), "What would you like to do?\n" +
					"1) Ready to purchase!\n" +
					"2) I want more details on an item\n" +
					"3) I would like to look at my other options" + "\n", txtSpd);
			pMenuChoice = scn.next().charAt(0);
			
			// Switch statement for processing player's menu choice
			switch (pMenuChoice) {
			
			case '1': // Make a purchase
				breakLine();
				this.attemptConsumablePurchase(scn, tempConsumablesArray);	// Handles consumable purchase functionality
				break;
			
			case '2': // More details on an item
				breakLine();
				
				// Prints purchasable consumables array and prompts the user for what item they would like to know more about. Then stores user's choice
				this.printInventoryConsumableArray(tempConsumablesArray);
				Dialogue.characterDialogue(this.getShopkeeper().getName(), 
						"What is the number of the item you would like to hear more about?" + "\n", txtSpd);
				pItemChoice = scn.next();
				if (isNumeric(pItemChoice)) {
					selection = Integer.parseInt(pItemChoice);
				} else {
					selection = -1;
				}
				
				// If statement to ensure user's choice is in the consumables array. user's choice will always be 1 based so needs to be converted to 0 based in calculations
				if (selection - 1 < tempConsumablesArray.size() && selection - 1 >= 0) {
					// Prints info on the user's selected item, then reprints consumable array and currency for the buying consumables menu
					breakLine();
					Dialogue.characterDialogue(this.getShopkeeper().getName(), 
							"Absolutely! Here is the information about that consumable!" + "\n", txtSpd);
					tempConsumablesArray.get(selection - 1).displayInfo();
					this.printInventoryConsumableArray(tempConsumablesArray);
					this.printPlayerCurrency();
					
				} else { // Invalid input handling
					// prints error message for invalid input then reprints consumable array and player currency for the buying consumables menu
					breakLine();
					System.err.println("(Invalid choice. That is not an item on the list)");
					this.printInventoryConsumableArray(tempConsumablesArray);
					this.printPlayerCurrency();
				}
				break;

			case '3': // Escape consumables buy menu
				breakLine();
				Dialogue.characterDialogue(this.getShopkeeper().getName(), 
						"Alright you can always look at the consumables again if you would like!" + "\n", txtSpd);
				isBuyingConsumables = false; // Breaks out of the buying consumables menu, going to the buy menu
				break;
			
			default: // Invalid input handling
				breakLine();
				// Prints invalid input error message, then reprints consumable array and currency for the consumables buy menu
				System.err.println("(Invalid choice. Please try again.)");
				this.printInventoryConsumableArray(tempConsumablesArray);
				this.printPlayerCurrency();
			}
		}
	}
	
	/**
	 * Handles consumable purchase functionality
	 * 
	 * @param scn		- For processing user input
	 * @param arrayList		- Consumable array for printing and calculations
	 */
	public void attemptConsumablePurchase(Scanner scn, ArrayList<Consumable> arrayList) {
		boolean successfulPurchase; 	// Variable for storing whether the purchase was successful
		boolean isPurchacing = true;	// Variable for keeping user in the purchasing menu
		String pItemChoice;			// Variable for storing user's consumable purchase choice
		int selection;
		
		
		// Print statement for entering purchasing menu
		Dialogue.characterDialogue(this.getShopkeeper().getName(), "Good to hear!" + "\n", txtSpd);
		
		// while loop for keeping the user in the purchasing menu. isPurchasing set to false based on user choice
		while (isPurchacing) {
			
			//Prints purchasable consumable options with an option to cancel at the end.
			this.printInventoryConsumableArray(arrayList);
			Dialogue.infoDialogue(arrayList.size()+1 + ") Cancel" + "\n", txtSpd);
			
			// Prints player's current currency, then prompts the user to select an item they would like to purchase. Then stores that choice in pItemChoice
			this.printPlayerCurrency();
			Dialogue.characterDialogue(this.getShopkeeper().getName(), 
					"What is the number of the item you would like to buy?" + "\n", txtSpd);
			pItemChoice = scn.next();
			if (isNumeric(pItemChoice)) {
				selection = Integer.parseInt(pItemChoice);
			} else {
				selection = -1;
			}
			
			// If statement to ensure pItemChoice is in the consumable array. pItemChoice - 1 <= arrayList.size() to account for the cancel option
			if (selection - 1 <= arrayList.size() && selection - 1 >= 0) {
				
				// If statement to account for user selecting cancel
				if (selection - 1 == arrayList.size()) {
					isPurchacing = false;	// Breaks out of the isPurchacing menu
					// Reprints consumable array and player currency for the consumable buy menu
					breakLine();
					this.printInventoryConsumableArray(arrayList);
					this.printPlayerCurrency();
					
				} else { // For processing user purchase when they did not decide to cancel
					// Attempts to purchase consumable with special considerations for the count variable. returns a boolean if purchase was successful
					successfulPurchase = this.buyingConsumables(scn, arrayList.get(selection - 1), this.getPlayer().getInventory().getConsumables());
					
					// Due to the special considerations of the count variable, error messages for why they could or could not purchase the item vary
					// so the print statements are handled in the buyingConsumables function
					if (successfulPurchase) {
						isPurchacing = false; // Breaks out of the isPurchasing menu
					}
				}
			} else { // Invalid input handling
				breakLine();
				// Prints an error message for invalid input of item to purchase
				System.err.println("(Invalid choice. Please try again.)");
			}
		}
	}
	
	/**
	 * Handles the buying functionality of consumables with special considerations for the count variable
	 * Handles print statements based on the various outcomes of an attempt to purchase consumables
	 * 
	 * @param scn			- For processing user input
	 * @param product			- The consumable the user is trying to purchase
	 * @param playerInv			- The players inventory to see if the player already has one of this item
	 * @return true or false	- Returns a boolean for whether the purchase was successful
	 */
	public boolean buyingConsumables(Scanner scn, Consumable product, ArrayList<Consumable> playerInv) {
		boolean matchesInv = false;	// Boolean to track whether the item they are trying to purchase is already in the players inventory
		int matchesInvIndex = 0; 	// Stores the index of the item if it matches an item in the player's inventory
		String pCountChoice;			// Stores the user's choice of the amount of the consumable they would like to purchase
		int selection;
		
		
		// If statement to ensure the player has at least enough currency to buy one of the item
		if (product.getValue() <= this.getPlayer().getCurrency()) {
			
			// Loops through the player's inventory to see if the item they are trying to purchase exists in their inventory.
			for (int x = 0; x < playerInv.size(); x++) {
				// If the item exists in the players inventory, it sets matchesInv to true and stores the index of that item
				if (product.equals(playerInv.get(x))) {
					matchesInv = true;
					matchesInvIndex = x;
				}
			}
			
			// If statement for handling if it found a match in the inventory
			if (matchesInv) {
				
				// Prints a message telling the player how many of this item they have and how much each one costs. Then prompts the user for 
				// how many they would like to buy and stores the users decision. It tells the user to enter 0 if they do not wish to purchase any
				breakLine();
				Dialogue.infoDialogue("You have " + this.getPlayer().getInventory().getConsumables().get(matchesInvIndex).getCount() + 
						" of these consumables and they are worth " + product.getValue() + " a piece. "
						+ "How many would you like to buy?" + "\n", txtSpd);
				Dialogue.infoDialogue("*Hint* Enter 0 if you decided against buying any" + "\n", txtSpd);
				pCountChoice = scn.next();
				if (isNumeric(pCountChoice)) {
					selection = Integer.parseInt(pCountChoice);
				} else {
					selection = -1;
				}
					
				// If the user's choice is 0, it returns false as the user decided not to buy any
				if (selection == 0) {
					breakLine();
					return false;
					
				// If the user's choice is greater than 0, it continues attempting to purchase
				} else if (selection > 0) {
					// Checks to see if the user has enough currency to purchase their selected amount of the item
					if (product.getValue() * selection <= this.getPlayer().getCurrency()) {
						// Removes product value * amount they purchase from the player's currency
						this.getPlayer().setCurrency(this.getPlayer().getCurrency() - (product.getValue() * selection));
						// Goes to the players consumables inventory, to the index where this item is stored, and adds the amount they purchased to the item count
						this.getPlayer().getInventory().getConsumables().get(matchesInvIndex).setCount(this.getPlayer().getInventory().getConsumables().get(matchesInvIndex).getCount() + selection);
						breakLine();
						// Prints a confirmation message and tells the user how many they have now. Then returns true
						Dialogue.infoDialogue("The consumables have been added to your inventory! You now have " + 
						this.getPlayer().getInventory().getConsumables().get(matchesInvIndex).getCount() + 
						" of these consumables" + "\n", txtSpd);
						Dialogue.infoDialogue("Your updated currency is: " + this.getPlayer().getCurrency() + "\n", txtSpd);
						return true;
						
					} else { // Handles if the user does not have enough currency
						breakLine();
						// Prints a message telling the user they dont have enough currency. Then tells the user how much currency they have as well as 
						// how much would be required to make their desired purchase. Then returns false
						Dialogue.infoDialogue("You do not have enough currency to buy that many of this consumable! \n" +
								"You have " + this.getPlayer().getCurrency() + "currency\n" +
								"It would cost " + (product.getValue() * selection) + " currency to buy " 
								+ selection + "of these items" + "\n", txtSpd);
						return false;
					}
				} else { // Invalid input handling
					breakLine();
					// Prints an error message and returns false
					System.err.println("(Invalid choice.)");
					return false;
				}
			// Handles if a match in the inventory is not found
			} else {
				breakLine();
				// Prints a message for how much the item is and prompts them for how many they would like to buy. It gives the user a hint telling them to
				// enter 0 if they decided not to buy anything, then stores the player's choice
				Dialogue.characterDialogue(this.getShopkeeper().getName(), 
					"These consumables are worth " + product.getValue() + " a piece. How many would you like to buy?" + "\n", txtSpd);
				Dialogue.infoDialogue("*Hint* Enter 0 if you decided against buying any" + "\n", txtSpd);
				pCountChoice = scn.next();
				if (isNumeric(pCountChoice)) {
					selection = Integer.parseInt(pCountChoice);
				} else {
					selection = -1;
				}
				
				// If statement to check if the player entered 0 to cancel the purchase. if so, returns false
				if (selection == 0) {
					breakLine();
					return false;
					
				// If statement to check that the players choice is greater than 0, if so proceeds with attempted purchase
				} else if (selection > 0) {
					// If statement to check whether the player has enough currency to buy the amount they requested
					if (product.getValue() * selection <= this.getPlayer().getCurrency()) {
						// Subtracts product value * amount chosen from the players currency
						this.getPlayer().setCurrency(this.getPlayer().getCurrency() - (product.getValue() * selection));
						// Adds the item to their inventory
						this.getPlayer().getInventory().getConsumables().add(product);
						// Item will always be added to the end of the arrayList, so it goes to that location and sets the count equal to the player's choice
						this.getPlayer().getInventory().getConsumables().get(this.getPlayer().getInventory().getConsumables().size()-1).setCount(selection);
						breakLine();
						// Prints a confirmation message telling the player how many of the item they have and their updated currency. Then returns true
						Dialogue.infoDialogue("The consumables have been added to your inventory! You now have " 
						+ selection + " of these consumables" + "\n", txtSpd);
						Dialogue.infoDialogue("Your updated currency is: " + this.getPlayer().getCurrency() + "\n", txtSpd);
						return true;
					
					} else { // Handles insufficient funds
						breakLine();
						// Prints a message informing the player they do not have enough currency to buy the chosen amount of the selected item. Prints their
						// current currency and how much it would cost to buy the chosen amount of that item. then returns false
						Dialogue.infoDialogue("You do not have enough currency to buy that many of this consumable! \n" +
								"You have " + this.getPlayer().getCurrency() + "currency\n" +
								"It would cost " + (product.getValue() * selection) + " currency to buy " 
								+ selection + "of these items" + "\n", txtSpd);
						return false;
					}
				} else { // Invalid input Handling
					breakLine();
					// Prints an error message and returns false
					System.err.println("(Invalid choice.)");
					return false;
				}
			}
			
		} else { // Handles insufficient funds
			breakLine();
			// Informs the player they don't have enough currency to buy this item, then prints their current currency and the value of the item. Then returns false
			Dialogue.infoDialogue("You don't have enough currency to buy this item.\n" + 
					"Your currency is: " + this.getPlayer().getCurrency() + "\n" +
					"The cost of that item is: " + product.getValue() + "\n", txtSpd);
			return false;
		}
	}
	
	/**
	 * Handles buying special arrows functionality
	 */
	
	public void buySpArrows(Scanner scn) {
		boolean buyingSpecialArrows;
		String spArrowCount;
		int selection;
		
		buyingSpecialArrows = true;
		while (buyingSpecialArrows) {
			breakLine();
			Dialogue.characterDialogue(this.getShopkeeper().getName(), "How many Special Arrows would you like to buy? They "
					+ "are worth 10 currency a piece. \n", txtSpd);
			Dialogue.infoDialogue("You currently have " + player.getCurrency() + " currency.\n", txtSpd);
			Dialogue.infoDialogue("*Tip: Enter 0 to cancel*\n", txtSpd);
			spArrowCount = scn.next();
			if (isNumeric(spArrowCount)) {
				selection = Integer.parseInt(spArrowCount);
			} else {
				selection = -1;
			}
			
			if (selection > 0) {
				if (player.getCurrency() > selection * 10) {
					player.getInventory().setSpecialArrows(player.getInventory().getSpecialArrows() + selection);
					player.setCurrency(player.getCurrency() - (selection * 10));
					Dialogue.characterDialogue(this.getShopkeeper().getName(), "Enjoy your arrows\n!", txtSpd);
					Dialogue.infoDialogue("Your updated Special Arrow Count is: " + player.getInventory().getSpecialArrows() + "\n", txtSpd);
					Dialogue.infoDialogue("Your updated Currency is: " + player.getCurrency() + "\n", txtSpd);
					buyingSpecialArrows = false;
				} else {
					Dialogue.characterDialogue(this.getShopkeeper().getName(), "You don't have enough currency to buy that many arrows!", txtSpd);
					Dialogue.infoDialogue("Your Currency is: " + player.getCurrency() + "\n", txtSpd);
					Dialogue.infoDialogue("It would cost " + (selection * 10) + " currency to buy that many arrows.\n", txtSpd);
				}
			} else if (selection == 0) {
				buyingSpecialArrows = false;
			} else {
				System.err.println("(Invalid choice. Please try again)");
			}
		}
		
	}
	
	/*
	 * 
	 * ----------------Sell Menu Functionality-------------------
	 * 
	 */
	/**
	 * Handles the sell menu functionality
	 * 
	 * @param scn		-for user input
	 */
	public void SellMenu(Scanner scn) {
		boolean isSelling = true;	// Keeps the player in the sell menu. Is set to false based on user input
		char pSellMenuChoice;	// Stores user's menu choice
		
		
		breakLine();
		
		// While loop for the isSelling menu
		while (isSelling) {
			// Prints the menu options and prompts user for their choice
			Dialogue.characterDialogue(this.getShopkeeper().getName(), 
					"What do you want to sell?" + "\n", txtSpd);
			Dialogue.infoDialogue("1) Weapons\n" + 
					"2) Consumables\n" + 
					"3) Cancel" + "\n", txtSpd);
			pSellMenuChoice = scn.next().charAt(0);
			
			// switch statement to handle user's choice
			switch (pSellMenuChoice) {

			case '1': // Weapons sell menu
				breakLine();
				this.SellWeaponsMenu(scn);
				break;
				
			case '2': // Consumables sell menu
				breakLine();
				this.SellConsumablesMenu(scn);
				break;
				
			case '3': // Escape sell menu
				isSelling = false; // Breaks out of the sell menu
				break;
				
			default: // Invalid input handling
				breakLine();
				// Prints an error message
				System.err.println("(Invalid choice. Please try again.)");
				break;
			}
		
		}
	}
	
	/*
	 * ----------------Weapons Sell Menu Functionality-------------------
	 */
	
	/**
	 * Handles the selling weapons menu functionality
	 * 
	 * @param scn	- For user input
	 */
	public void SellWeaponsMenu(Scanner scn) {
		ArrayList<Weapon> tempWeaponsArray = this.getPlayer().getInventory().getWeapons(); // For storing the weapons array and avoiding overuse of the get methods
		boolean isSellingWeapons = true;	// boolean to keep the player in the selling weapons menu
		int pMenuChoice;
		String pItemChoice;	// pMenuChoice for storing user menu choice, pItemChoice for storing user weapon inspect choice
		int selection;
		
		
		// Entering selling weapons menu print statements. Prints player inventory selling options and currency
		Dialogue.characterDialogue(this.getShopkeeper().getName(), 
				"I'm always looking for some new stuff to sell. Lets see what Weapons you have:" + "\n", txtSpd);
		this.printInventoryWeaponsArray(tempWeaponsArray);
		this.printPlayerCurrency();
		Dialogue.characterDialogue(this.getShopkeeper().getName(), 
				"Looks like you've got some pretty good stuff," + "\n", txtSpd);
		
		// While loop for the selling weapons menu
		while (isSellingWeapons) {
			// Print statement for selling weapons menu and stores player's menu choice
			Dialogue.characterDialogue(this.getShopkeeper().getName(), "What would you like to do?\n" +
					"1) I think I know what I would like to sell\n" +
					"2) I want more details on an item before I sell it\n" +
					"3) I would like to see what other items I could sell" + "\n", txtSpd);
			pMenuChoice = scn.next().charAt(0);
			
			// Switch statement for handling user's menu choice
			switch (pMenuChoice) {
			
			case '1': // Sell an Item
				breakLine();
				this.attemptWeaponsSale(scn, tempWeaponsArray); // Handles attempted sale of a weapon
				break;
			
			case '2': // More details on an item
				breakLine();
				// Prints weapon options and prompts the user for what item they would like to inspect. Then stores player's choice
				this.printInventoryWeaponsArray(tempWeaponsArray);
				Dialogue.characterDialogue(this.getShopkeeper().getName(), 
						"What is the number of the item you would like to hear more about?" + "\n", txtSpd);
				pItemChoice = scn.next();
				if (isNumeric(pItemChoice)) {
					selection = Integer.parseInt(pItemChoice);
				} else {
					selection = -1;
				}
				
				// If statement to ensure the player's choice is a valid item on the list. player's choice is 1 based so needs to be converted to 0 based in calculations
				if (selection - 1 < tempWeaponsArray.size() && selection - 1 >= 0) {
					breakLine();
					// Displays selected weapon's information and then reprints weapons array and currency for the selling weapons menu
					Dialogue.characterDialogue(this.getShopkeeper().getName(), 
							"Absolutely! Here is the information about that consumable!" + "\n", txtSpd);
					tempWeaponsArray.get(selection - 1).displayInfo();
					this.printInventoryWeaponsArray(tempWeaponsArray);
					this.printPlayerCurrency();
					
				} else { // Invalid input handling
					breakLine();
					// Prints an error message then reprints the weapons array and player currency for the selling weapons menu
					System.err.println("(Invalid choice. That is not an item on the list.)");
					this.printInventoryWeaponsArray(tempWeaponsArray);
					this.printPlayerCurrency();
				}
				break;
			
			case '3': // Escape weapons sell menu
				breakLine();
				// Prints an exit message for the selling weapons menu
				Dialogue.characterDialogue(this.getShopkeeper().getName(), 
						"Alright you can always look again at the weapons you can sell "
						+ "if you would like!" + "\n", txtSpd);
				isSellingWeapons = false;	// Breaks out of the selling weapons menu
				break;
			
			default: // Invalid input handling
				breakLine();
				// Prints an error message, then reprints the weapons array and player currency for the weapons selling menu
				System.err.println("(Invalid choice. Please try again.)");
				this.printInventoryWeaponsArray(tempWeaponsArray);
				this.printPlayerCurrency();
			}
		}
	}
	
	/**
	 * Handles the attempted sale of weapons
	 * 
	 * @param scn			- For user input
	 * @param tempWeaponsArray	- For printing of the player's weapons array and calculations
	 */
	public void attemptWeaponsSale(Scanner scn, ArrayList<Weapon> tempWeaponsArray) {
		boolean saleSuccessful; 	// Boolean for storing if the sale was successful
		boolean isSelling = true;	// Boolean for keeping player in the isSelling menu
		String pItemChoice;		// variable for storing user's item selling choice
		int selection;
		
		
		// Print statement for entering the weapons sale menu
		Dialogue.characterDialogue(this.getShopkeeper().getName(), "Good to hear!" + "\n", txtSpd);

		// while loop for the is selling menu
		while (isSelling) {
			// Prints the players weapons inventory with an option at the end to cancel
			this.printInventoryWeaponsArray(tempWeaponsArray);
			Dialogue.infoDialogue(tempWeaponsArray.size()+1 + ") Cancel " + "\n", txtSpd);
			
			// Prints the player's current currency then prompts the user for the item they would like to sell
			this.printPlayerCurrency();
			Dialogue.characterDialogue(this.getShopkeeper().getName(), 
					"What is the number of the item you would like to sell?" + "\n", txtSpd);
			pItemChoice = scn.next();
			if (isNumeric(pItemChoice)) {
				selection = Integer.parseInt(pItemChoice);
			} else {
				selection = -1;
			}
			
			// If statement to ensure the player's choice is a valid item on the list. pItemChoice - 1 <= tempWeaponsArray.size() to account for cancel option
			if (selection - 1 <= tempWeaponsArray.size() && selection - 1 >= 0) {
				// If statement to check if the players choice was to cancel
				if (selection - 1 == tempWeaponsArray.size()) {
					isSelling = false; // Breaks out of the weapons sale menu
					breakLine();
					// Reprints the player's weapons inventory and player currency for the selling weapons menu
					this.printInventoryWeaponsArray(tempWeaponsArray);
					this.printPlayerCurrency();
					
				} else {	// if the player's choice was not to cancel, proceeds attempting to sell the weapon
					saleSuccessful = sellingWeapons(this.getPlayer().getInventory().getWeapons().get(selection - 1), selection - 1);
					
					// if statement to check if the sale was successful
					if (saleSuccessful) {
						breakLine();
						// Prints a confirmation message and prints the player's updated currency
						Dialogue.infoDialogue("That weapon is now gone from your inventory. Your new currency is: " 
								+ this.getPlayer().getCurrency() + "\n", txtSpd);
						isSelling = false; // breaks out of the weapons sale menu
						
						// reprints the player's weapons inventory and current currency for the selling weapons menu
						this.printInventoryWeaponsArray(tempWeaponsArray);
						this.printPlayerCurrency();
						
					} else { //  Handles an unsuccessful sale. The only reason it would be unsuccessful is because it was the last weapon in the player's inventory
						breakLine();
						// Prints a message informing the player that they cannot sell their last weapon
						Dialogue.characterDialogue(this.getShopkeeper().getName(), 
								"You can't sell your last weapon! That would leave you defenseless!" + "\n", txtSpd);
						isSelling = false; // Breaks out of the weapons sale menu
						
						// reprints the player's weapons inventory and current currency for the selling weapons menu
						this.printInventoryWeaponsArray(tempWeaponsArray);
						this.printPlayerCurrency();
					}
				}
			} else { // Invalid input handling
				breakLine();
				// Prints an error message
				System.err.println("(Invalid choice. Please try again.)");
			}
		}

		
	}
	
	/**
	 * Handles the selling of a weapon
	 * 
	 * @param product			- Item the player is trying to sell
	 * @param invIndex			- Index of that item in the player's inventory
	 * @return true or false	-Based on if the sale was successful. Only returns false if it is the last weapon in the player's inventory
	 */
	public boolean sellingWeapons(Weapon product, int invIndex) {
		// Checks to make sure that the player's weapon inventory has more than 1 item in it
		if (this.getPlayer().getInventory().getWeapons().size() > 1) {
			// Removes the weapon from the player's weapon inventory
			this.getPlayer().getInventory().getWeapons().remove(invIndex);
			// Adds the weapons value to the player's current currency, then returns true
			this.getPlayer().setCurrency(this.getPlayer().getCurrency() + product.getValue());
			return true;
			
		}
		return false; // Returns false if the players weapon inventory size has 1 or less items in it
	}
	
	/*
	 * ----------------Consumables Sell Menu Functionality-------------------
	 */
	
	/**
	 * Handles the sell consumables menu functionality
	 * 
	 * @param scn		- For handling user input
	 */
	public void SellConsumablesMenu(Scanner scn) {
		ArrayList<Consumable> tempConsumablesArray = this.getPlayer().getInventory().getConsumables(); // Stores player consumables array to avoid overuse of get methods
		boolean isSellingConsumables = true; // To keep the user in the selling consumables menu
		char pMenuChoice; 		// To store the user's menu choice
		String pItemChoice;	// To store the user's item choice when inspecting weapons
		int selection;
		
		
		// Print statements for entering the selling consumables menu. Prints consumables array and player currency
		Dialogue.characterDialogue(this.getShopkeeper().getName(), 
				"I'm always looking for some new stuff to sell. Lets see what consumables you've got:" + "\n", txtSpd);
		this.printInventoryConsumableArray(tempConsumablesArray);
		this.printPlayerCurrency();
		Dialogue.characterDialogue(this.getShopkeeper().getName(), 
				"Looks like you've got some pretty good stuff," + "\n", txtSpd);
		
		// While loop to keep the user in the selling consumables menu
		while (isSellingConsumables) {
			
			// Prints the consumables menu options and stores user input
			Dialogue.characterDialogue(this.getShopkeeper().getName(), "What would you like to do?\n" +
					"1) I think I know what I would like to sell\n" +
					"2) I want more details on an item before I sell it\n" +
					"3) I would like to see what other items I could sell" + "\n", txtSpd);
			pMenuChoice = scn.next().charAt(0);
			
			// Switch statement for processing user menu selection
			switch (pMenuChoice) {
			case '1': // Sell an Item
				breakLine();
				this.attemptConsumableSale(scn, tempConsumablesArray);	//Processes the attempted sale of consumables
				break;
			
			case '2': // More details on an item
				breakLine();
				// Prints the consumable array and prompts the user for what item they would like to inspect. Then stores that choice
				this.printInventoryConsumableArray(tempConsumablesArray);
				Dialogue.characterDialogue(this.getShopkeeper().getName(), 
						"What is the number of the item you would like to hear more about?" + "\n", txtSpd);
				pItemChoice = scn.next();
				if (isNumeric(pItemChoice)) {
					selection = Integer.parseInt(pItemChoice);
				} else {
					selection = -1;
				}
				
				// Ensures that the users choice is a valid item on the list
				if (selection - 1 < tempConsumablesArray.size() && selection - 1 >= 0) {
					breakLine();
					// Displays the information about the selected item, then reprints the consumable array and player currency for the selling consumables menu
					Dialogue.characterDialogue(this.getShopkeeper().getName(), 
							"Absolutely! Here is the information about that consumable!" + "\n", txtSpd);
					tempConsumablesArray.get(selection - 1).displayInfo();
					this.printInventoryConsumableArray(tempConsumablesArray);
					this.printPlayerCurrency();
				} else {  // Handles invalid input
					breakLine();
					// prints an error message then reprints the consumable array and player currency for the selling consumables menu
					System.err.println("(Invalid choice. Please try again.)");
					this.printInventoryConsumableArray(tempConsumablesArray);
					this.printPlayerCurrency();
				}
				break;
				
			case '3': // Escape consumables buy menu
				breakLine();
				// Prints an exiting selling consumables message
				Dialogue.characterDialogue(this.getShopkeeper().getName(), 
						"Alright you can always look again at the consumables you can sell "
						+ "if you would like!" + "\n", txtSpd);
				isSellingConsumables = false; // Breaks out of the selling consumables menu
				break;
				
			default: // Invalid input handling
				breakLine();
				// Prints an error message, then reprints the consumable array and player currency for the selling consumables menu
				System.err.println("(Invalid choice. Please try again.)");
				this.printInventoryConsumableArray(tempConsumablesArray);
				this.printPlayerCurrency();
			}
		}
	}
	
	/**
	 * Handles the attempted sale of consumables
	 * 
	 * @param scn
	 * @param tempConsumableArray
	 */
	public void attemptConsumableSale(Scanner scn, ArrayList<Consumable> tempConsumableArray) {
		boolean isSelling = true;		// Boolean to keep the user in the consumables sale menu
		boolean saleSuccessful;	// Boolean to store whether the sale was successful or not
		String pItemChoice;	// Variable to store the item choice the player would like to sell
		int selection;
		
		
		// Entering the consumables sale menu text
		Dialogue.characterDialogue(this.getShopkeeper().getName(), "Good to hear!" + "\n", txtSpd);
		
		// While loop to keep the user in the consumables sale menu
		while (isSelling) {
			// Prints the consumable array, an option to cancel at the end of the list, and the players current currency
			this.printInventoryConsumableArray(tempConsumableArray);
			Dialogue.infoDialogue(tempConsumableArray.size()+1 + ") Cancel " + "\n", txtSpd);
			this.printPlayerCurrency();
			
			// Prompts the user to select what consumable they would like to sell and stores that value
			Dialogue.characterDialogue(this.getShopkeeper().getName(), 
					"What is the number of the item you would like to sell?" + "\n", txtSpd);
			pItemChoice = scn.next();
			if (isNumeric(pItemChoice)) {
				selection = Integer.parseInt(pItemChoice);
			} else {
				selection = -1;
			}
			
			// If statement to ensure that the user's choice is on the list. pItemChoice - 1 <= tempConsumableArray.size() to account for the cancel option
			if (selection - 1 <= tempConsumableArray.size() && selection - 1 >= 0) {
				// If statement to check if the player selected to cancel sale
				if (selection - 1 == tempConsumableArray.size()) {
					isSelling = false;	// Breaks out of the consumables sale menu
					breakLine();
					// Prints the consumable array and [layer currency for the selling consumables array
					this.printInventoryConsumableArray(tempConsumableArray);
					this.printPlayerCurrency();
					
				} else { // If the user did not select to cancel, proceeds with the attempted sale
					// Handles the attempted sale of the consumable. sellingConsumables method returns a boolean value which is stored in saleSuccessful
					saleSuccessful = sellingConsumables(this.getPlayer().getInventory().getConsumables().get(selection - 1), selection - 1, scn);
					
					// If statement to check if the sale was successful. Due to the varying reasons that sale of consumables could fail, a failed sale 
					// is handled in the selling consumables method itself so it does nothing if saleSuccessful is false
					if (saleSuccessful) {
						breakLine();
						// Prints a confirmation message telling the player their new currency
						Dialogue.infoDialogue("Your sale was complete! Your new currency: " 
						+ this.getPlayer().getCurrency() + "\n", txtSpd);
						isSelling = false; // Breaks out of the consumables sale menu
						
						// Reprints the consumable array and player currency for the selling consumables menu
						this.printInventoryConsumableArray(tempConsumableArray);
						this.printPlayerCurrency();
					} 
					
				}
			} else { // Invalid input handling
				breakLine();
				// Prints an error message
				System.out.println("(Invalid choice. Please try again.)");
			}
		}
		
		
	}
	
	/**
	 * Handles the functionality of selling a consumable
	 * 
	 * @param product			-the item the player would like to sell
	 * @param invIndex			-the index of that item in the player's inventory
	 * @param scn			-for processing player input
	 * @return true or false	-Returns true if the sale was successful. non-successful sales are handled within the function and still return false
	 */
	public boolean sellingConsumables(Consumable product, int invIndex, Scanner scn) {
		String pCountChoice;	// For storing the player's choice of the amount of a consumable they would like to sell
		int selection;
		
		
		// Checks to see if there is more than 1 of the consumable
		if (product.getCount() > 1) {
			breakLine();
			// Tells the user how many of the consumable they have, how much each one is worth, and asks the user how much they would like to sell
			Dialogue.characterDialogue(this.getShopkeeper().getName(), 
					"You have " + product.getCount() + " of these consumables and they are worth " 
							+ product.getValue() + " a piece. How many would you like to sell?" + "\n", txtSpd);
			// Informs the player that they can enter 0 if they do not wish to sell any, then stores the player's choice
			Dialogue.infoDialogue("*Hint* Enter 0 if you decided against selling any" + "\n", txtSpd);
			pCountChoice = scn.next();
			if (isNumeric(pCountChoice)) {
				selection = Integer.parseInt(pCountChoice);
			} else {
				selection = -1;
			}
				
			// If the player chose to sell 0, it returns false and returns to the consumable sale menu
			if (selection == 0) {
				breakLine();
				return false;
			// checks to see if the amount the player would like to sell is greater than 0 but less than the total that they have
			} else if (selection > 0 && selection < product.getCount()) {
				// Adds the value * amount sold to the player's current currency
				this.getPlayer().setCurrency(this.getPlayer().getCurrency() + (product.getValue() * selection));
				// Removes the selected amount from the current count of that item in their inventory, then returns true
				this.getPlayer().getInventory().getConsumables().get(invIndex).setCount(this.getPlayer().getInventory().getConsumables().get(invIndex).getCount() - selection);
				return true;
			// Checks to see if the amount the player would like to sell is equal to the amount they have in their inventory
			} else if (selection == product.getCount()) {
				// Removes that item from their inventory
				this.getPlayer().getInventory().getConsumables().remove(invIndex);
				// Adds value * amount sold to the players current currency, then returns true
				this.getPlayer().setCurrency(this.getPlayer().getCurrency() + (product.getValue() * selection));
				return true;
			
			} else {	// Invalid input handling
				breakLine();
				// prints an error message and returns false, returning to the consumable sale menu
				System.err.println("(Invalid choice.)");
				return false;
			}
			
		} else { // If there is only one of the item, it sells the item normally
			// Removes the consumable from the player's inventory
			this.getPlayer().getInventory().getConsumables().remove(invIndex);
			// Adds the consumables value to the player's currency, then returns true
			this.getPlayer().setCurrency(this.getPlayer().getCurrency() + product.getValue());
			return true;
		}
		
	}
	
    private static boolean isNumeric(String str) {
        // Ensure the string only contains digits
        return str.matches("\\d+");
    }

}