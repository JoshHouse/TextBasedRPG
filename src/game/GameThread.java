package game;

import java.util.ArrayList;
import java.util.Scanner;

public class GameThread {
	
	/**
	 * 
	 * ----- Main -----
	 * 
	 */
	
	public static void main(String args[]) {
		Weapon Sword = new Weapon("BroadSword", "Common", 10, 25, "Melee", true, 0, "Overhead Swing!");
		Weapon FireStaff = new Weapon("Fire Staff", "Legendary", 500, 75, "Magic", false, 20, "Fire Wall!");
		Item[] P1Inventory = {Sword, FireStaff};
		Player p1 = new Player("Gandalf The Great", 100, 10, 72, 50, "Magic", 750, P1Inventory, 3, 1, 1, 12, 7, 250);
		System.out.println(p1.toString());
	}
	
	/**
	 * 
	 * ----- Functions -----
	 * 
	 */
	
	public void Shop(Player p1, NPC n1) {
		

		Boolean DoneSaleMenu = false;
		Boolean DoneBuyMenu = false;
		Boolean DoneWithShop = false;
		Scanner Keyboard = new Scanner(System.in);
		
		ArrayList<Item> NPCInventory = new ArrayList<Item>();
		ArrayList<Item> PlayerInventory = new ArrayList<Item>();
		
		System.out.println(n1.getEnterShopDialog());
		
		// Creates a resizeable array to easily process buyable items
		for(int x = 0; x < n1.getInventory().length; x++) {
			if(n1.getInventory()[x].getName() != "No Name") {
				NPCInventory.add(n1.getInventory()[x]);
			}
		}
		// Creates a resizeable array to easily process purchase and sale of items
		for(int x = 0; x < p1.getInventory().length; x++) {
			if(n1.getInventory()[x].getName() != "No Name") {
				PlayerInventory.add(p1.getInventory()[x]);
			}
		}
		

		// While loop to keep player in the shop until they are done
		while (DoneWithShop != true) {
			// Recurring Shop menu
			System.out.println("What are you looking to do?(Simply type in the number of your menu selection)"
					+ "1) Buy Menu \n"
					+ "2) Sell Menu \n"
					+ "3) Exit");
			int ChoiceShop = Keyboard.nextInt();
			
			// Switch Statement to process player choice
			switch (ChoiceShop) {
			
			// Buy menu case
			case 1:
				DoneBuyMenu = false;
				
				// While loop to keep player in the buy menu
				while (DoneBuyMenu != true) 
				{
					// Recurring menu prompting the player to choose what they would like to buy.
					System.out.println("What would you like to buy?");
					
					// For loop prints the name and price of each item with numbers beside each item
					for (int x = 1; x <= NPCInventory.size(); x++) {
						System.out.println(x + ") Name: " + NPCInventory.get(x-1).getName() + "\n"
								+ "Price: " + NPCInventory.get(x-1).getValue() + "\n");
					}
					
					// The last 2 options will always be to display the info of each item and to exit the buy menu
					System.out.println((NPCInventory.size()+1) + ") Display More Info");
					System.out.println((NPCInventory.size()+2) + ") Exit");
					int ChoiceBuy = Keyboard.nextInt();
					
					// Checks to see if the choice is one of the last 2 options, and if not it processes the buy
					if(ChoiceBuy != NPCInventory.size()+1 && ChoiceBuy != NPCInventory.size()+2) 
					{
						Boolean BuySuccess = Buy(p1, NPCInventory.get(ChoiceBuy - 1));
						// If statement for if the buy was a success. Buy() function processes failed purchases
						// in the function itself. If buy was a success, it updates the Player Inventory Array
						// List for future menu displays. It also prints NPC sale dialog
						if (BuySuccess) {
							PlayerInventory.add(NPCInventory.get(ChoiceBuy - 1));
							System.out.println(n1.getSaleDialog());
						}
					} 
					// If player chooses second to last option, it prints the details of each NPC item for sale
					else if (ChoiceBuy == NPCInventory.size()+1) 
					{
						String TempNInventory = "";
						for (int x = 0; x < NPCInventory.size(); x++) {
							TempNInventory = TempNInventory + NPCInventory.get(x) + "-------" + "\n";
						}
						System.out.println(TempNInventory);
						
						// Checks for keyboard input so the player has time to read the item details
						System.out.println("Press Enter when you are done reviewing the NPC's shop:");
						Keyboard.nextLine();
					} 
					// If player chooses last option, it breaks out of the buy menu
					else if (ChoiceBuy == NPCInventory.size()+2) 
					{
						DoneBuyMenu = true;
					}
				}
				break;
			
			// Sell menu case
			case 2:
				DoneSaleMenu = false;
				
				// While loop to keep player in the Sale menu
				while (DoneSaleMenu != true) 
				{
					// Recurring menu option to display players inventory with the name and value of each item
					System.out.println("What would you like to sell?");
					for (int x = 1; x <= PlayerInventory.size(); x++) {
						System.out.println(x + ") Name: " + PlayerInventory.get(x-1).getName() + "\n"
								+ "Value: " + PlayerInventory.get(x-1).getValue() + "\n");
					}
					// Last 2 options are always to display more info and exit
					System.out.println((PlayerInventory.size()+1) + ") Display More Info");
					System.out.println((PlayerInventory.size()+2) + ") Exit");
					int ChoiceSale = Keyboard.nextInt();
					
					// Checks to see if the players choice was either of the last 2 options and if not,
					// processes the sale
					if(ChoiceSale != PlayerInventory.size()+1 && ChoiceSale != PlayerInventory.size()+2) 
					{
						// If statement for if the sale was a success. Sell() function processes failed sales
						// in the function itself. If sale was a success, it updates the Player Inventory Array
						// List for future menu displays. Also gives player a thank you message
						Boolean SellSuccess = Sell(p1, PlayerInventory.get(ChoiceSale - 1));
						if (SellSuccess) {
							PlayerInventory.remove(ChoiceSale-1);
							System.out.println("Thank you for your buisness!");
						}
					} 
					// If player chooses second to last option, it prints the details of each item in their 
					// inventory so they can make a more informed decision on what to sell
					else if (ChoiceSale == PlayerInventory.size()+1) 
					{
						String TempPInventory = "";
						for (int x = 0; x < PlayerInventory.size(); x++) {
							TempPInventory = TempPInventory + PlayerInventory.get(x) + "-------" + "\n";
						}
						System.out.println(TempPInventory);
						
						// Checks for keyboard input so the player has time to read the item details
						System.out.println("Press Enter when you are done reviewing your inventory:");
						Keyboard.nextLine();
					} 
					// If player chooses last option, it breaks out of the buy menu
					else if (ChoiceSale == PlayerInventory.size()+2) 
					{
						DoneSaleMenu = true;
					}
				}
				break;
			
			// Exit case
			case 3:
				// Prints the NPC's exit shop dialog and breaks out of the shop menu
				System.out.println(n1.getExitShopDialog());
				DoneWithShop = false;
				break;	
			
			// Default case if player does not choose 1,2 or 3
			default:
				System.out.println("Please Enter a valid menu choice: \n");
			}
		}
		Keyboard.close();		
	}
	
	// Buy function takes the item the player wants to buy and the player object. Returns true if buy was
	// successful and false if buy was not successful. It prints messages for the various reasons buy could
	// not be successful
	public Boolean Buy(Player p1, Item i1) {
		
		// If statement 1 to check if player has enough currency to buy the item
		if(p1.getCurrency() >= i1.getValue()) {
		
			Item[] CheckInventory = p1.getInventory();
			
			// For loop that looks through the players inventory to find an empty slot, subtracts the
			// value of the item from the players currency, and fills the slot with the selected item
			// Returns true when the purchase is made
			for(int x = 0; x < p1.getInventory().length; x++ ) {
			
				// Checks the name of each item in the players inventory to see if there is an unnamed slot
				if(CheckInventory[x].getName() == "No Name") {
					p1.setCurrency(p1.getCurrency() - i1.getValue());
					CheckInventory[x] = i1;
					p1.setInventory(CheckInventory);
					return true;
				}
			
			}
			
			// If the for loop does not return true indicating that an open slot was found in the players
			// inventory, it prints a notification informing the player they don't have enough space for
			// item. Then returns false
			System.out.println("You do not have enough inventory space for this item. \n"
					+ "Tip: Try Selling some items to make more room");
			return false;
		} 
		// Else statement to If statement 1 that prints a message informing the player that they don't have 
		// enough currency then returns false
		else 
		{
			System.out.println("You do not have enough currency to purchace this item. \n");
			return false;
		}
	}
	
	// Sell function that takes the item the player is trying to sell and the player object. Returns true
	// if the sell was successful and false if the sell was not successful. Prints a message for the various
	// reasons a sell could not be successful.
	public Boolean Sell(Player p1, Item i1) {
		
		Boolean NotSoftLocked = false;
		int WeaponCount = 0;
		Item[] CheckInventory = p1.getInventory();
		
		// If statement 1 that checks if the item being sold does damage (indicating they are trying to sell
		// a weapon)
		if (i1.getDamage() != 0) {
			
			// If they are trying to sell a weapon, it runs through a for loop, checking to see if they have
			// at least 2 weapons to ensure they do not soft lock themselves. Once 2 weapons are found, 
			// NotSoftLocked is set to true which breaks out of the for loop
			for (int x = 0; x < p1.getInventory().length && NotSoftLocked == false; x++) {
				// Increases weapon count when it finds named items that do damage
				if (CheckInventory[x].getName() != "No Name" && CheckInventory[x].getDamage() != 0) {
					WeaponCount++;
				}
				// When weapon count reaches 2, breaks out of the for loop
				if (WeaponCount >= 2) {
					NotSoftLocked = true;
				}
			}
		} 
		// If player is not trying to sell a weapon, they wont soft lock themselves so NotSoftLocked is set
		// to true
		else 
		{
			NotSoftLocked = true;
		}
		
		// If statement 2 that checks to see if NotSoftLocked was never set to true, that indicates that the 
		// item they are trying to sell is a weapon and is the last weapon in their inventory. It prints a 
		// message informing the player they cannot sell it and returns false
		if (NotSoftLocked = false) {
			System.out.println("This item is the last weapon in your inventory. You cannot sell it.");
			return false;
		}
		// Else statement to if statement 2 that runs the sell functionality after ensuring the player isn't
		// soft locking themselves
		else
		{
			// For loop that runs through the player's inventory looking for the item that the player is
			// trying to sell
			for (int x = 0; x < p1.getInventory().length; x++) {
				
				// If it finds the item, it adds the value of the item to the player's currency and fills the slot
				// with an empty Item object. Sets the new inventory to the player's inventory and returns true.
				if(CheckInventory[x].equals(i1)) {
					p1.setCurrency(p1.getCurrency() + i1.getValue());
					CheckInventory[x] = new Item();
					p1.setInventory(CheckInventory);
					return true;
				}
			
			}
		}
		// If all else fails and function never returns true indicating sale of an item, function returns false.
		return false;
	}
	
	// Takes the player and the enemy and processes exchange of EXP and currency
	public void EXPDefeat(Player p1, Enemy e1) {
		
		// Calculates if the enemy's EXP will cause the player to level up
		if (p1.getEXP() + e1.getEXP() > p1.getEXPThreshold()) {
			// If the enemy's EXP will cause the player to level up, it calculates the amount of overflow
			// EXP the player will get by adding the player and enemies EXP and subtracting a rounded 
			// EXP threshold by casting it as an int (it is stored as a double). It then passes the overflow
			// amount to the levelUp function in the player class to process the levelUp functionality.
			int overflow = (p1.getEXP() + e1.getEXP()) - (int)Math.round(p1.getEXPThreshold());
			p1.levelUp(overflow);
		} 
		else 
		{
			// If the EXP will not cause the player to level up, it sets the player's EXP to the player EXP
			// plus the enemy EXP
			p1.setEXP(p1.getEXP() + e1.getEXP());
		}
		// After setting the EXP, it adds the current player currency and enemy currency to set that as current
		// player currency
		p1.setCurrency(p1.getCurrency() + e1.getCurrency());
	}
}