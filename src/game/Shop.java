package game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {

	private String name;
	private Player player;
	private Shopkeeper shopkeeper;

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

	public static void breakLine() {  
	    System.out.println("------------------------------");
	} 
	
	public void printPlayerCurrency() {
		System.out.println("Your currency: " + this.getPlayer().getCurrency());
	}
	
	/**
	 * Function allowing players to go to the available shop
	 * 
	 * @param player - The player
	 * @param shop   - The available shop
	 * @param scn    - Scanner object for user input
	 * @throws IOException Makes use of System.in.read().
	 */
	public void startShop() {

		int shopMenu = 0;
		boolean isShopping = true; // When player finishes shopping, it will be set to false

		System.out.println("-------------Entering: " + this.getName() + "-------------\n");
		System.out.println(this.getShopkeeper().getEnterShopDialog());
		
		Scanner keyboard = new Scanner(System.in);
		

		while (isShopping) {
			breakLine();
			System.out.print("What would you like to do?\n" + "1) Buy\n" + "2) Sell\n" + "3) Leave\n");
			shopMenu = keyboard.nextInt();
			System.out.println();

			switch (shopMenu) {

			case 1: // Buy
				this.BuyMenu(keyboard);
				break;
			case 2: // Sell
				this.SellMenu(keyboard);
				break;
			case 3: // Leave
				isShopping = false;
				break;
			default: // Invalid input
				System.err.println("(Invalid choice. Please try again.)");
				break;

			}

		}

		System.out.println(this.getShopkeeper().getExitShopDialog());
		System.out.println("-------------Leaving: " + this.getName() + "-------------\n");

	}

	/*
	 * 
	 * ---------------------Buy Menu Functionality-------------------------
	 * 
	 */

	private void BuyMenu(Scanner keyboard) {
		boolean isBuying = true;
		int pMainMenuChoice = 0;
		
		breakLine();
		System.out.println(this.getShopkeeper().displayInShopDialog());
		
		while (isBuying) {
			System.out.println("What are you in the market for today?\n" + 
					"1) Weapons\n" + 
					"2) Consumables\n" + 
					"3) Cancel");
			pMainMenuChoice = keyboard.nextInt();
			
			switch (pMainMenuChoice) {
			case 1:	// Weapons buy menu
				this.weaponsBuyMenu(keyboard);
				break;
			
			case 2: // Consumables buy menu
				this.consumablesBuyMenu(keyboard);
				break;
			
			case 3: // Back to main menu
				isBuying = false;
				break;
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
				break;
					
			}
			
		}
	}
	
	public boolean buying(Item product) {
		if (product.getValue() <= this.getPlayer().getCurrency()) {
			this.getPlayer().setCurrency(this.getPlayer().getCurrency() - product.getValue());
			this.getPlayer().getInventory().add(product);
			return true;
		} 
		return false;
	}
	
	// ----------------Weapons Buy Menu Functionality-------------------
	
	public void weaponsBuyMenu(Scanner keyboard) {
		ArrayList<Weapon> tempWeaponsArray = this.getShopkeeper().getInventory().getWeapons();
		boolean isBuyingWeapons;
		int pMenuChoice, pItemChoice = 0;
		
		
		isBuyingWeapons = true;
		breakLine();
		System.out.println("We've got a great selection of weapons for you today. Heres what we got:");
		
		this.printInventoryWeaponsArray(tempWeaponsArray);
		this.printPlayerCurrency();
		System.out.println("Now that you have seen what we have in stock,");
		while (isBuyingWeapons) {
			System.out.println("What would you like to do?\n" +
					"1) Ready to purchace!\n" +
					"2) I want more details on an item\n" +
					"3) I would like to look at my other options");
			pMenuChoice = keyboard.nextInt();
			switch (pMenuChoice) {
			case 1: // Make a purchase
				breakLine();
				this.attemptWeaponPurchace(keyboard, tempWeaponsArray);
				break;
			
			case 2: // More details on an item
				breakLine();
				this.printInventoryWeaponsArray(tempWeaponsArray);
				System.out.println("What is the number of the item you would like to hear more about?");
				pItemChoice = keyboard.nextInt();
				
				if (pItemChoice - 1 < tempWeaponsArray.size() && pItemChoice - 1 >= 0) {
					breakLine();
					System.out.println("Absolutely! Here is the information about that weapon!");
					tempWeaponsArray.get(pItemChoice - 1).displayInfo();
					this.printInventoryWeaponsArray(tempWeaponsArray);
					this.printPlayerCurrency();
				} else { 
					breakLine();
					System.err.println("(Invalid choice. Please try again.)");
					this.printInventoryWeaponsArray(tempWeaponsArray);
					this.printPlayerCurrency();
				}
				break;
			case 3: // Escape Weapons buy menu
				breakLine();
				System.out.println("Alright you can always look at the weapons again if you would like!");
				isBuyingWeapons = false;
				break;
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
				this.printInventoryWeaponsArray(tempWeaponsArray);
				this.printPlayerCurrency();
				break;
			}
		}
	}
	
	private void printInventoryWeaponsArray(ArrayList<Weapon> arrayList) {
		for(int x = 0; x < arrayList.size(); x++) {
			System.out.println(x+1 + ") " + arrayList.get(x).getName() + 
					"\t Cost: " + arrayList.get(x).getValue());
		}
		
	}
	
	public void attemptWeaponPurchace(Scanner keyboard, ArrayList<Weapon> arrayList) {
		boolean successfulPurchace, isPurchacing;
		int pItemChoice = 0;
		
		System.out.println("Good to hear!");
		
		isPurchacing = true;
		
		while (isPurchacing) {
			this.printInventoryWeaponsArray(arrayList);
			System.out.println(arrayList.size()+1 + ") Cancel ");
			this.printPlayerCurrency();
			System.out.println("What is the number of the item you would like to buy?");
			pItemChoice = keyboard.nextInt();
			
			if (pItemChoice - 1 <= arrayList.size() && pItemChoice - 1 >= 0) {
				if (pItemChoice - 1 == arrayList.size()) {
					isPurchacing = false;
					breakLine();
					this.printInventoryWeaponsArray(arrayList);
					this.printPlayerCurrency();
				} else {
					successfulPurchace = this.buying(arrayList.get(pItemChoice - 1));
			
					if (successfulPurchace) {
						breakLine();
						System.out.println("You have a new weapon in your inventory! Your updated currency: " + this.getPlayer().getCurrency());
						System.out.println(this.getShopkeeper().getSaleDialog());
						isPurchacing = false;
						this.printInventoryWeaponsArray(arrayList);
						this.printPlayerCurrency();
					} else { 
						breakLine();
						System.out.println("You don't have enough currency to buy this item.\n" + 
								"Your currency is: " + this.getPlayer().getCurrency() + "\n" +
								"The cost of that item is: " + arrayList.get(pItemChoice - 1).getValue() + "\n");
					}
				}
			} 
			else 
			{
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
			}
		}
	}
	
	//-------------------------Buy Consumables Menu Functionality-------------------------
	
	public void consumablesBuyMenu(Scanner keyboard) {
		ArrayList<Consumable> tempConsumablesArray = this.getShopkeeper().getInventory().getConsumables();
		boolean isBuyingConsumables;
		int pMenuChoice, pItemChoice = 0;
		
		
		isBuyingConsumables = true;
		
		breakLine();
		System.out.println("We've got a great selection of consumables for you today. Heres what we got:");
		
		this.printInventoryConsumableArray(tempConsumablesArray);
		this.printPlayerCurrency();
		System.out.println("Now that you have seen what we have in stock,");
		while (isBuyingConsumables) {
			System.out.println("What would you like to do?\n" +
					"1) Ready to purchace!\n" +
					"2) I want more details on an item\n" +
					"3) I would like to look at my other options");
			pMenuChoice = keyboard.nextInt();
			
			switch (pMenuChoice) {
			case 1: // Make a purchase
				breakLine();
				this.attemptConsumablePurchace(keyboard, tempConsumablesArray);
				break;
			
			case 2: // More details on an item
				breakLine();
				this.printInventoryConsumableArray(tempConsumablesArray);
				System.out.println("What is the number of the item you would like to hear more about?");
				pItemChoice = keyboard.nextInt();
				
				if (pItemChoice - 1 < tempConsumablesArray.size() && pItemChoice - 1 >= 0) {
					breakLine();
					System.out.println("Absolutely! Here is the information about that consumable!");
					tempConsumablesArray.get(pItemChoice - 1).displayInfo();
					this.printInventoryConsumableArray(tempConsumablesArray);
					this.printPlayerCurrency();
				} else { 
					breakLine();
					System.err.println("(Invalid choice. That is not an item on the list)");
					this.printInventoryConsumableArray(tempConsumablesArray);
					this.printPlayerCurrency();
				}
				break;

			case 3: // Escape consumables buy menu
				breakLine();
				System.out.println("Alright you can always look at the consumables again if you would like!");
				isBuyingConsumables = false;
				break;
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
				this.printInventoryConsumableArray(tempConsumablesArray);
				this.printPlayerCurrency();
			}
		}
	}
	
	private void printInventoryConsumableArray(ArrayList<Consumable> arrayList) {
		for(int x = 0; x < arrayList.size(); x++) {
			System.out.println(x+1 + ") " + arrayList.get(x).getName() + 
					"\t Cost: " + arrayList.get(x).getValue());
		}
	}
	
	public void attemptConsumablePurchace(Scanner keyboard, ArrayList<Consumable> arrayList) {
		boolean successfulPurchace, isPurchacing;
		int pItemChoice = 0;
		
		System.out.println("Good to hear!");
		
		isPurchacing = true;
		while (isPurchacing) {
			this.printInventoryConsumableArray(arrayList);
			System.out.println(arrayList.size()+1 + ") Cancel ");
			this.printPlayerCurrency();
			System.out.println("What is the number of the item you would like to buy?");
			pItemChoice = keyboard.nextInt();
			if (pItemChoice - 1 <= arrayList.size() && pItemChoice - 1 >= 0) {
				if (pItemChoice - 1 == arrayList.size()) {
					isPurchacing = false;
					this.printInventoryConsumableArray(arrayList);
					this.printPlayerCurrency();
				} else {
					successfulPurchace = this.buying(arrayList.get(pItemChoice - 1));
			
					if (successfulPurchace) {
						breakLine();
						System.out.println("You have a new consumable in your inventory! Your updated currency: " + this.getPlayer().getCurrency());
						System.out.println(this.getShopkeeper().getSaleDialog());
						isPurchacing = false;
						this.printInventoryConsumableArray(arrayList);
						this.printPlayerCurrency();
					} else { 
						breakLine();
						System.out.println("You don't have enough currency to buy this item.\n" + 
								"Your currency is: " + this.getPlayer().getCurrency() + "\n" +
								"The cost of that item is: " + arrayList.get(pItemChoice - 1).getValue() + "\n");
					}
				}
			} 
			else 
			{
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
			}
		}
	}
	
	//  ----------------Sell Menu Functionality-------------------
	
	public void SellMenu(Scanner keyboard) {
		boolean isSelling = true;
		int pSellMenuChoice = 0;
		
		breakLine();
		while (isSelling) {
			System.out.println("What do you want to sell?");
			System.out.print("1) Weapons\n" + 
					"2) Consumables\n" + 
					"3) Cancel\n");
			pSellMenuChoice = keyboard.nextInt();

			switch (pSellMenuChoice) {

			case 1:
				breakLine();
				this.SellWeaponsMenu(keyboard);
				break;
			case 2:
				breakLine();
				this.SellConsumablesMenu(keyboard);
				break;
			case 3:
				isSelling = false;
				break;
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
				break;
			}
		
		}
	}
	
	// ----------------Weapons Sell Menu Functionality-------------------
	
	public void SellWeaponsMenu(Scanner keyboard) {
		ArrayList<Weapon> tempWeaponsArray = this.getPlayer().getInventory().getWeapons();
		boolean isSellingWeapons;
		int pMenuChoice, pItemChoice = 0;
		
		
		isSellingWeapons = true;
		
		System.out.println("I'm always looking for some new stuff to sell. Lets see what Weapons you have:");
		this.printInventoryWeaponsArray(tempWeaponsArray);
		this.printPlayerCurrency();
		System.out.println("Looks like you've got some pretty good stuff,");
		
		while (isSellingWeapons) {
			System.out.println("What would you like to do?\n" +
					"1) I think I know what I would like to sell\n" +
					"2) I want more details on an item before I sell it\n" +
					"3) I would like to see what other items I could sell");
			pMenuChoice = keyboard.nextInt();
			
			switch (pMenuChoice) {
			case 1: // Sell an Item
				breakLine();
				this.attemptWeaponsSale(keyboard, tempWeaponsArray);
				break;
			
			case 2: // More details on an item
				breakLine();
				this.printInventoryWeaponsArray(tempWeaponsArray);
				System.out.println("What is the number of the item you would like to hear more about?");
				pItemChoice = keyboard.nextInt();
				
				if (pItemChoice - 1 < tempWeaponsArray.size() && pItemChoice - 1 >= 0) {
					breakLine();
					System.out.println("Absolutely! Here is the information about that consumable!");
					tempWeaponsArray.get(pItemChoice - 1).displayInfo();
					this.printInventoryWeaponsArray(tempWeaponsArray);
					this.printPlayerCurrency();
				} else { 
					breakLine();
					System.err.println("(Invalid choice. That is not an item on the list.)");
					this.printInventoryWeaponsArray(tempWeaponsArray);
					this.printPlayerCurrency();
				}
				break;
			
			case 3: // Escape weapons sell menu
				breakLine();
				System.out.println("Alright you can always look again at the weapons you can sell "
						+ "if you would like!");
				isSellingWeapons = false;
				break;
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
				this.printInventoryWeaponsArray(tempWeaponsArray);
				this.printPlayerCurrency();
			}
		}
	}
	
	public void attemptWeaponsSale(Scanner keyboard, ArrayList<Weapon> tempWeaponsArray) {
		boolean saleSuccessful, isSelling;
		int pItemChoice = 0;
		
		System.out.println("Good to hear!");
		
		isSelling = true;
		
		while (isSelling) {
			this.printInventoryWeaponsArray(tempWeaponsArray);
			System.out.println(tempWeaponsArray.size()+1 + ") Cancel ");
			this.printPlayerCurrency();
			System.out.println("What is the number of the item you would like to sell?");
			pItemChoice = keyboard.nextInt();
			if (pItemChoice - 1 <= tempWeaponsArray.size() && pItemChoice - 1 >= 0) {
				if (pItemChoice - 1 == tempWeaponsArray.size()) {
					isSelling = false;
					breakLine();
					this.printInventoryWeaponsArray(tempWeaponsArray);
					this.printPlayerCurrency();
					
				} else {
					saleSuccessful = sellingWeapons(this.getPlayer().getInventory().getWeapons().get(pItemChoice - 1), pItemChoice - 1);
					
					if (saleSuccessful) {
						breakLine();
						System.out.println("That weapon is now gone from your inventory. Your new currency is: " + this.getPlayer().getCurrency());
						System.out.println(this.getShopkeeper().getSaleDialog());
						isSelling = false;
						this.printInventoryWeaponsArray(tempWeaponsArray);
						this.printPlayerCurrency();
					} 
					else 
					{
						breakLine();
						System.out.println("You can't sell your last weapon! That would leave you defenseless!");
						isSelling = false;
						this.printInventoryWeaponsArray(tempWeaponsArray);
						this.printPlayerCurrency();
					}
				}
			} 
			else 
			{ 
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
			}
		}

		
	}
	
	public boolean sellingWeapons(Weapon product, int invIndex) {
		if (this.getPlayer().getInventory().getWeapons().size() > 1) {
			this.getPlayer().getInventory().getWeapons().remove(invIndex);
			this.getPlayer().setCurrency(this.getPlayer().getCurrency() + product.getValue());
			return true;
		}
		return false;
	}
	
	// ----------------Consumables Sell Menu Functionality-------------------
	public void SellConsumablesMenu(Scanner keyboard) {
		ArrayList<Consumable> tempConsumablesArray = this.getPlayer().getInventory().getConsumables();
		boolean isSellingConsumables;
		int pMenuChoice, pItemChoice = 0;
		
		
		isSellingConsumables = true;
		
		System.out.println("I'm always looking for some new stuff to sell. Lets see what consumables you've got:");
		this.printInventoryConsumableArray(tempConsumablesArray);
		this.printPlayerCurrency();
		System.out.println("Looks like you've got some pretty good stuff,");
		
		while (isSellingConsumables) {
			System.out.println("What would you like to do?\n" +
					"1) I think I know what I would like to sell\n" +
					"2) I want more details on an item before I sell it\n" +
					"3) I would like to see what other items I could sell");
			pMenuChoice = keyboard.nextInt();
			
			switch (pMenuChoice) {
			case 1: // Sell an Item
				breakLine();
				this.attemptConsumableSale(keyboard, tempConsumablesArray);
				break;
			
			case 2: // More details on an item
				breakLine();
				System.out.println("What is the number of the item you would like to hear more about?");
				pItemChoice = keyboard.nextInt();
				
				if (pItemChoice - 1 < tempConsumablesArray.size() && pItemChoice - 1 >= 0) {
					System.out.println("Absolutely! Here is the information about that consumable!");
					tempConsumablesArray.get(pItemChoice - 1).displayInfo();
					this.printInventoryConsumableArray(tempConsumablesArray);
					this.printPlayerCurrency();
				} else { 
					breakLine();
					System.err.println("(Invalid choice. Please try again.)");
					this.printInventoryConsumableArray(tempConsumablesArray);
					this.printPlayerCurrency();
				}
				break;
				
			case 3: // Escape consumables buy menu
				breakLine();
				System.out.println("Alright you can always look again at the consumables you can sell "
						+ "if you would like!");
				isSellingConsumables = false;
				break;
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again.)");
				this.printInventoryConsumableArray(tempConsumablesArray);
				this.printPlayerCurrency();
			}
		}
	}
	
	public void attemptConsumableSale(Scanner keyboard, ArrayList<Consumable> tempConsumableArray) {
		boolean isSelling, saleSuccessful;
		int pItemChoice = 0;
		System.out.println("Good to hear!");
		
		isSelling = true;
		while (isSelling) {
			this.printInventoryConsumableArray(tempConsumableArray);
			System.out.println(tempConsumableArray.size()+1 + ") Cancel ");
			this.printPlayerCurrency();
			System.out.println("What is the number of the item you would like to sell?");
			pItemChoice = keyboard.nextInt();
			
			if (pItemChoice - 1 <= tempConsumableArray.size() && pItemChoice - 1 >= 0) {
				if (pItemChoice - 1 == tempConsumableArray.size()) {
					isSelling = false;
					breakLine();
					this.printInventoryConsumableArray(tempConsumableArray);
					this.printPlayerCurrency();
				} else {
					saleSuccessful = sellingConsumables(this.getPlayer().getInventory().getConsumables().get(pItemChoice - 1), pItemChoice - 1, keyboard);
					if (saleSuccessful) {
						breakLine();
						System.out.println("Your sale was complete! Your new currency: " + this.getPlayer().getCurrency());
						System.out.println(this.getShopkeeper().getSaleDialog());
						isSelling = false;
						this.printInventoryConsumableArray(tempConsumableArray);
						this.printPlayerCurrency();
					} 
					
				}
			} 
			else 
			{ 
				breakLine();
				System.out.println("(Invalid choice. Please try again.)");
			}
		}
		
		
	}
	
	public boolean sellingConsumables(Consumable product, int invIndex, Scanner keyboard) {
		int pCountChoice;
		
		if (product.getCount() > 1) {
			breakLine();
			System.out.println("You have " + product.getCount() + " of these consumables and they are worth " + product.getValue() + " a piece. "
						+ "How many would you like to sell?");
			System.out.println("*Hint* Enter 0 if you decided against selling any");
			pCountChoice = keyboard.nextInt();
				
			if (pCountChoice == 0) {
				breakLine();
				return false;
			} else if (pCountChoice > 0 && pCountChoice < product.getCount()) {
				this.getPlayer().setCurrency(this.getPlayer().getCurrency() + (product.getValue() * pCountChoice));
				this.getPlayer().getInventory().getConsumables().get(invIndex).setCount(product.getCount() - pCountChoice);
				return true;
			} else if (pCountChoice == product.getCount()) {
				this.getPlayer().getInventory().getConsumables().remove(invIndex);
				this.getPlayer().setCurrency(this.getPlayer().getCurrency() + (product.getValue() * pCountChoice));
				return true;
			} else {
				breakLine();
				System.err.println("(Invalid choice.)");
				return false;
			}
			
		} else {
			this.getPlayer().getInventory().getConsumables().remove(invIndex);
			this.getPlayer().setCurrency(this.getPlayer().getCurrency() + product.getValue());
			return true;
		}
		
	}

}
