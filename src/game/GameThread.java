package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameThread extends Throwable {
	
	/**
	 * 
	 * ----- Main -----
	 * 
	 */
	
	public static void main(String args[]) {

		Shopkeeper demoShopkeeper = new Shopkeeper("Cosmos", "Hello there! How can I help you?", "Will that be all?",
				"Have a nice day!");
		demoShopkeeper.addInShopDialog("How's the weather today? I think it's quite lovely.");
		demoShopkeeper.addInShopDialog("We don't have a lot here, so feel free to take your time looking around.");
		demoShopkeeper.addInShopDialog(
				"I don't mean to add any pressure, but I really hope I can hit my sales quota for today.");
		Shop demoShop = new Shop("Demo Armory Shop", demoShopkeeper);

		Scanner scn = new Scanner(System.in);
	}
	
	/**
	 * 
	 * ----- Functions -----
	 * 
	 */

	/**
	 * Pauses console till the user presses the enter key.
	 */
	public static void pause() {

		System.out.println("Press \"ENTER\" to continue...");

		try {
			System.in.read(new byte[2]);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Pauses console for a set number of milliseconds.
	 * 
	 * @param time - The number of milliseconds to sleep.
	 */
	public static void pause(long time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Function allowing players to go to the available shop
	 * 
	 * @param player - The player
	 * @param shop   - The available shop
	 * @param scn    - Scanner object for user input
	 * @throws IOException Makes use of System.in.read().
	 */
	public static void gotoShop(Player player, Shop shop, Scanner scn) throws IOException {

		char shopMenu;
		boolean isShopping = true; // When player finishes shopping, it will be set to false

		System.out.println("-------------Entering: " + shop.getName() + "...-------------\n");
		pause(1500);

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
				sell(player, shop, scn);
				break;
			case '3': // Leave
				isShopping = false;
				break;
			default: // Invalid input
				System.err.println("(Invalid choice. Please try again.)");
				pause(200);
				break;

			}

		} while (isShopping);

		System.out.println(shop.getShopkeeper().getExitShopDialog());
		System.out.println("-------------Leaving: " + shop.getName() + "...-------------\n");
		pause(1000);

	}

	/**
	 * Allows the player to buy items provided at a shop.
	 * 
	 * @param player - The player
	 * @param shop   - The shop the player is accessing
	 * @param scn    - Scanner for user input.
	 */
	public static void buy(Player player, Shop shop, Scanner scn) {

		int numChoice = 0; // Select from inventory
		char charChoice = 0; // For other options requiring user input
		Item chosen = null; // The selected item
		boolean isBuying = true, isPurchasing = false, purchased = false;

		// Have the shopkeeper say something
		System.out.println(shop.getShopkeeper().displayInShopDialog());
		pause(1500);

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
					pause(200);
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
							player.addToInventory(chosen);

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
						pause(200);
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
	 * Allows the player to sell items from their inventory to the shop for money.
	 * 
	 * @param player - The player
	 * @param shop   - The shop the player is accessing
	 * @param scn    - Scanner for user input.
	 */
	public static void sell(Player player, Shop shop, Scanner scn) {

		int numChoice = 0; // Select from inventory
		char charChoice = 0; // For other options requiring user input
		int chosenIndex = 0;

		boolean isSelling = true, startSelling = false, sold = false;

		// Do not allow the player to sell if there is only 1 item in their inventory.
		if (player.getInventory().size() <= 1) {
			System.err.println("(You can't sell when there's only 1 item in your inventory!)");
			isSelling = false;
			pause(2500);
		} else { // Have the shopkeeper say something
			System.out.println(shop.getShopkeeper().displayInShopDialog());
			pause(1500);
		}

		while (isSelling) { // Loop until the player is done selling

			while (numChoice < 1 || numChoice > player.getInventory().size() + 1) {

				// Print the player's inventory using a for loop
				System.out.println("[Select which item you would like to sell.]");
				for (int i = 0; i < player.getInventory().size(); i++) {
					System.out.println((i + 1) + ") " + player.getInventory().get(i).GetName());
				}
				System.out.println((player.getInventory().size() + 1) + ") Cancel\n"); // Print the cancel option

				System.out.print("Your choice: ");

				/*
				 * IndexOutOfBoundsException: User enters number outside the required range.
				 * InputMismatchException: USer enters a non-integer character.
				 */
				try {
					numChoice = scn.nextInt();

					if (numChoice < 1 || numChoice > player.getInventory().size() + 1)
						throw new IndexOutOfBoundsException();
				} catch (InputMismatchException | IndexOutOfBoundsException e) {
					System.err.println("(Invalid choice. Please try again.)\n");
					scn.nextLine();
					pause(200);
				}

			}

			if (numChoice == player.getInventory().size() + 1) { // Exit the sell function on cancel
				isSelling = false;
			} else { // Proceed to purchase window
				startSelling = true;
				chosenIndex = numChoice - 1;
			}

			while (startSelling) { // Loops till user completes or cancels a purchase

				// Display info on the item, including the price.
				System.out.println(player.getInventory().get(chosenIndex).GetName() + "\n"
						+ player.getInventory().get(chosenIndex).getInfo() + "\nPrice: "
						+ player.getInventory().get(chosenIndex).GetValue() + "\n");
				System.out.println("[Are you sure you want to sell this?]\nY) Yes\t\tN) No");

				do { // Loop until a valid choice is entered
					System.out.print("Response: ");
					charChoice = scn.next().charAt(0);
					charChoice = Character.toUpperCase(charChoice);

					switch (charChoice) {

					case 'Y': // Sell
						// Remove item from player inventory, add money to player.
						player.setCurrency(player.getCurrency() + player.getInventory().get(chosenIndex).GetValue());
						player.getInventory().remove(chosenIndex);
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

				if (player.getInventory().size() > 1) {

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
							pause(200);
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

	/**
	 * Takes the player and the enemy and processes exchange of EXP and currency
	 * 
	 * @param p1
	 * @param e1
	 */
	public static void EXPDefeat(Player p1, Enemy e1) {

		System.out.println("Defeated " + e1.getName() + "! Rewards:");
		System.out.println(e1.getExp() + " EXP");
		System.out.println(e1.getCurrency() + " Money");

		// Calculates if the enemy's EXP will cause the player to level up
		if (p1.getExp() + e1.getExp() > p1.getExpThreshold()) {
			// If the enemy's EXP will cause the player to level up, it calculates the
			// amount of overflow
			// EXP the player will get by adding the player and enemies EXP and subtracting
			// a rounded
			// EXP threshold by casting it as an int (it is stored as a double). It then
			// passes the overflow
			// amount to the levelUp function in the player class to process the levelUp
			// functionality.
			int overflow = (p1.getExp() + e1.getExp()) - (int) Math.round(p1.getExpThreshold());
			p1.levelUp(overflow);
		} else {
			// If the EXP will not cause the player to level up, it sets the player's EXP to
			// the player EXP
			// plus the enemy EXP
			p1.setExp(p1.getExp() + e1.getExp());
		}
		// After setting the EXP, it adds the current player currency and enemy currency
		// to set that as current
		// player currency
		p1.setCurrency(p1.getCurrency() + e1.getCurrency());
	}

}