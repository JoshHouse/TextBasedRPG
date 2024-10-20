package game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {

	private String name;
	private Shopkeeper shopkeeper;
	private ArrayList<Item> shopInventory = new ArrayList<Item>();

	// ----------------------------------Constructors---------------------------------

	/**
	 * Base Constructor
	 */
	public Shop() {
		this.setName("");
		this.setShopkeeper(null);

	}

	/**
	 * Constructor for shops that only sell weapons
	 * 
	 * @param name       - Shop name
	 * @param shopkeeper - The shopkeeper, from the Shopkeeper class
	 */
	public Shop(String name, Shopkeeper shopkeeper) {
		this.setName(name);
		this.setShopkeeper(shopkeeper);
	}

	// ----------------------------------Getters---------------------------------

	public String getName() {
		return name;
	}

	public Shopkeeper getShopkeeper() {
		return shopkeeper;
	}
	
	public ArrayList<Item> getInventory() {
		return shopInventory;
	}

	// ----------------------------------Setters---------------------------------

	public void setName(String name) {
		this.name = name;
	}

	public void setShopkeeper(Shopkeeper shopkeeper) {
		this.shopkeeper = shopkeeper;
	}

	// ----------------------------------Functions---------------------------------

	/**
	 * Adds an item to the various array lists, based on the item's type provided.
	 * 
	 * @param item - The item to be added. Will be casted to another Object type
	 *             when necessary.
	 */
	public void addItem(Item item) {
		shopInventory.add(item);
	}

	/**
	 * Function allowing players to go to the available shop
	 * 
	 * @param player - The player
	 * @param shop   - The available shop
	 * @param scn    - Scanner object for user input
	 * @throws IOException Makes use of System.in.read().
	 */
	public static void gotoShop(Player player, Shop shop, Scanner scn) {

		char shopMenu, sellMenu = 0;
		boolean isShopping = true; // When player finishes shopping, it will be set to false

		System.out.println("-------------Entering: " + shop.getName() + "...-------------\n");
		Pause.pause(1500);

		System.out.println(shop.getShopkeeper().getEnterShopDialog());

		do {

			System.out.print("1) Buy\n" + "2) Sell\n" + "3) Leave\n" + "Your Choice: ");
			shopMenu = scn.next().charAt(0);
			System.out.println();

			switch (shopMenu) {

			case '1': // Buy
				buy(player, shop, scn);
				break;
			case '2': // Sell

				do {

					System.out.println("[What do you want to sell?]");
					System.out.print("1) Weapons\n" + "2) Consumables\n" + "3) Cancel\n" + "Your choice: ");
					sellMenu = scn.next().charAt(0);

					switch (sellMenu) {

					case '1':
						sellWeapons(player, shop, scn);
						break;
					case '2':
						sellConsumables(player, shop, scn);
						break;
					case '3':
						break;
					default:
						System.err.println("(Invalid choice. Please try again.)");
						Pause.pause(200);
						break;

					}

				} while (sellMenu < '1' && sellMenu > '3');
				break;
			case '3': // Leave
				isShopping = false;
				break;
			default: // Invalid input
				System.err.println("(Invalid choice. Please try again.)");
				Pause.pause(200);
				break;

			}

		} while (isShopping);

		System.out.println(shop.getShopkeeper().getExitShopDialog());
		System.out.println("-------------Leaving: " + shop.getName() + "...-------------\n");
		Pause.pause(1000);

	}

	/**
	 * Allows the player to buy items provided at a shop.
	 * 
	 * @param player - The player
	 * @param shop   - The shop the player is accessing
	 * @param scn    - Scanner for user input.
	 */
	private static void buy(Player player, Shop shop, Scanner scn) {

		int numChoice = 0; // Select from inventory
		char charChoice = 0; // For other options requiring user input
		Item chosen = null; // The selected item
		boolean isBuying = true, isPurchasing = false, purchased = false;

		// Have the shopkeeper say something
		System.out.println(shop.getShopkeeper().displayInShopDialog());
		Pause.pause(1500);

		while (isBuying) { // Loop until the player is done buying

			while (numChoice < 1 || numChoice > shop.getInventory().size() + 1) { // The final listed item is always
																					// cancel.

				// Print the shop inventory using a for loop
				System.out.println("[Select which item you would like to buy.]");
				for (int i = 0; i < shop.getInventory().size(); i++) {
					System.out.println((i + 1) + ") " + shop.getInventory().get(i).getName());
				}
				System.out.println((shop.getInventory().size() + 1) + ") Cancel\n"); // Print the cancel option

				System.out.print("Your choice: ");

				/*
				 * IndexOutOfBoundsException: User enters number outside the required range.
				 * InputMismatchException: USer enters a non-integer character.
				 */
				try {
					numChoice = scn.nextInt();

					if (numChoice < 1 || numChoice > shop.getInventory().size() + 1)
						throw new IndexOutOfBoundsException();
				} catch (InputMismatchException | IndexOutOfBoundsException e) {
					System.err.println("(Invalid choice. Please try again.)\n");
					scn.nextLine();
					Pause.pause(200);
				}

			}

			if (numChoice == shop.getInventory().size() + 1) { // Exit the buy function on cancel
				isBuying = false;
			} else { // Proceed to purchase window
				isPurchasing = true;
				chosen = shop.getInventory().get(numChoice - 1); // Put selected item in chosen variable
			}

			while (isPurchasing) { // Loops till user completes or cancels a purchase

				// Display info on the item, including the price.
				System.out.println(chosen.getName() + "\n" + chosen.getInfo() + "\nPrice: " + chosen.getValue() + "\n");
				System.out.println("[Is this the weapon you want?]\nY) Yes\t\tN) No");

				do { // Loop until a valid choice is entered
					System.out.print("Response: ");
					charChoice = scn.next().charAt(0);
					charChoice = Character.toUpperCase(charChoice);

					switch (charChoice) {

					case 'Y': // Buy
						// Add item to player inventory, subtract money from player.
						if (player.getCurrency() >= chosen.getValue()) {
							player.setCurrency(player.getCurrency() - chosen.getValue());

							player.getInventory().add(chosen);

							purchased = true;
						} else { // The user has attempted to make a purchase when they don't have enough money
							System.err.println("(You don't have enough money to buy this!)");
							isBuying = false;
						}
						break;
					case 'N': // Don't buy
						purchased = false;
						break;
					default:
						System.err.println("(Invalid choice. Please try again.)");
						break;

					}
				} while (charChoice != 'Y' && charChoice != 'N');

				isPurchasing = false;
				charChoice = 0; // Reset the variable

				if (purchased) { // Different dialogue based on whether or not a purchase was made.
					System.out.println(shop.getShopkeeper().getSaleDialog());
				} else {
					System.out.println("[Continue viewing buyable items?]");
				}

				do { // Loop till valid choice is made

					System.out.println("Y) Continue Buying\t\tN) Back to Shop Menu");
					System.out.print("Response: ");
					charChoice = scn.next().charAt(0);
					charChoice = Character.toUpperCase(charChoice);

					switch (charChoice) {

					case 'Y': // Continue shopping
						isBuying = true;
						break;
					case 'N': // Return to shop menu
						isBuying = false;
						break;
					default:
						System.err.println("(Invalid choice. Please try again.)");
						Pause.pause(200);
						break;

					}

				} while (charChoice != 'Y' && charChoice != 'N');

			}

			// Reset the variables
			numChoice = 0;
			charChoice = 0;

		}

	}

	/**
	 * Allows the player to sell weapons from their inventory to the shop for money.
	 * 
	 * @param player - The player
	 * @param shop   - The shop the player is accessing
	 * @param scn    - Scanner for user input.
	 */
	private static void sellWeapons(Player player, Shop shop, Scanner scn) {

		int numChoice = 0; // Select from inventory
		char charChoice = 0; // For other options requiring user input
		int chosenIndex = 0;

		boolean isSelling = true, startSelling = false, sold = false;

		// Do not allow the player to sell if there is only 1 item in their inventory.
		if (player.getInventory().getWeapons().size() <= 1) {
			System.err.println("(You can't sell when there's only 1 weapon in your inventory!)");
			isSelling = false;
			Pause.pause(2500);
		} else { // Have the shopkeeper say something
			System.out.println(shop.getShopkeeper().displayInShopDialog());
			Pause.pause(1500);
		}

		while (isSelling) { // Loop until the player is done selling

			while (numChoice < 1 || numChoice > player.getInventory().getWeapons().size() + 1) {

				// Print the player's inventory using a for loop
				System.out.println("[Select which item you would like to sell.]");
				for (int i = 0; i < player.getInventory().getWeapons().size(); i++) {
					System.out.println((i + 1) + ") " + player.getInventory().getWeapons().get(i).getName());
				}
				System.out.println((player.getInventory().getWeapons().size() + 1) + ") Cancel\n"); // Print the cancel
																									// option

				System.out.print("Your choice: ");

				/*
				 * IndexOutOfBoundsException: User enters number outside the required range.
				 * InputMismatchException: USer enters a non-integer character.
				 */
				try {
					numChoice = scn.nextInt();

					if (numChoice < 1 || numChoice > player.getInventory().getWeapons().size() + 1)
						throw new IndexOutOfBoundsException();
				} catch (InputMismatchException | IndexOutOfBoundsException e) {
					System.err.println("(Invalid choice. Please try again.)\n");
					scn.nextLine();
					Pause.pause(200);
				}

			}

			if (numChoice == player.getInventory().getWeapons().size() + 1) { // Exit the sell function on cancel
				isSelling = false;
			} else { // Proceed to purchase window
				startSelling = true;
				chosenIndex = numChoice - 1;
			}

			while (startSelling) { // Loops till user completes or cancels a purchase

				// Display info on the item, including the price.
				System.out.println(player.getInventory().getWeapons().get(chosenIndex).getName() + "\n"
						+ player.getInventory().getWeapons().get(chosenIndex).getInfo() + "\nPrice: "
						+ player.getInventory().getWeapons().get(chosenIndex).getValue() + "\n");
				System.out.println("[Are you sure you want to sell this?]\nY) Yes\t\tN) No");

				do { // Loop until a valid choice is entered
					System.out.print("Response: ");
					charChoice = scn.next().charAt(0);
					charChoice = Character.toUpperCase(charChoice);

					switch (charChoice) {

					case 'Y': // Sell
						// Remove item from player inventory, add money to player.
						player.setCurrency(
								player.getCurrency() + player.getInventory().getWeapons().get(chosenIndex).getValue());
						player.getInventory().getWeapons().remove(chosenIndex);
						sold = true;
						break;
					case 'N': // Don't sell
						sold = false;
						break;
					default:
						System.err.println("(Invalid choice. Please try again.)");
						break;

					}
				} while (charChoice != 'Y' && charChoice != 'N');

				startSelling = false;
				charChoice = 0; // Reset the variable

				if (player.getInventory().getWeapons().size() > 1) {

					if (sold) { // Different dialogue based on whether or not a purchase was made.
						System.out.println(shop.getShopkeeper().getSaleDialog());
					} else {
						System.out.println("[Continue viewing sellable items?]");
					}

					do { // Loop till valid choice is made

						System.out.println("Y) Continue Selling\t\tN) Back to Shop Menu");
						System.out.print("Response: ");
						charChoice = scn.next().charAt(0);
						charChoice = Character.toUpperCase(charChoice);

						switch (charChoice) {

						case 'Y': // Continue shopping
							isSelling = true;
							break;
						case 'N': // Return to shop menu
							isSelling = false;
							break;
						default:
							System.err.println("(Invalid choice. Please try again.)");
							Pause.pause(200);
							break;

						}

					} while (charChoice != 'Y' && charChoice != 'N');

				} else {
					isSelling = false;
				}

			}

			// Reset the variables
			numChoice = 0;
			charChoice = 0;

		}

	}

	private static void sellConsumables(Player player, Shop shop, Scanner scn) {

	}

}
