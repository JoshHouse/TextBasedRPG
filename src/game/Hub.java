package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Hub {

	private Player player;
	private String location;
	private Shop shop;
	private ArrayList<Enemy> enemies;

	public Hub(Player player, String location, Shop shop, ArrayList<Enemy> enemies) {
		this.player = player;
		this.location = location;
		this.shop = shop;
		this.enemies = enemies;
	}

	// ----------------------------Getters----------------------------

	public Player getPlayer() {
		return this.player;
	}

	public String getLocation() {
		return this.location;
	}

	public Shop getCurrentShop() {
		return this.shop;
	}

	public ArrayList<Enemy> getEnemies() {
		return this.enemies;
	}

	// ----------------------------Setters----------------------------

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCurrentShop(Shop shop) {
		this.shop = shop;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	// ---------------------------Functions---------------------------

	public void start(Scanner scn) {

		char input = '\0';
		boolean inHub = true;
		boolean opt1 = false;

		while (inHub) {

			String mainMenu = "Current Location: " + location + "\n-----------------------------------------\n"
					+ "1) View Character\t" + "2) Search Around\n" + "3) Go Shopping\t\t"
					+ "4) Change Equipped Weapon\n" + "5) Progress Story\t" + "6) Rest\n" + "7) Save & Exit\n"
					+ "-----------------------------------------\n\nSelect what you would like to do: ";
			String charMenu = "\n1) Your Profile\n2) Your Weapons\n3) Your Consumables\n4) Cancel\nChoice: ";
			Dialogue.infoDialogue(mainMenu, 10);
			input = scn.next().charAt(0);

			switch (input) {

			case '1': // Viewing the Player's Information.
				opt1 = true;

				while (opt1) {
					Dialogue.infoDialogue(charMenu, 6);
					input = scn.next().charAt(0);

					switch (input) {

					case '1': // View Player's Profile
						player.profile();
						Pause.pause();
						break;
					case '2': // View Player's Weapons
						player.showInventory('w', scn);
						break;
					case '3': // View Player's Consumables
						player.showInventory('c', scn);
						break;
					case '4': // Cancel and return to Main Menu
						opt1 = false;
						break;
					default:
						System.err.println("[---Invalid Option. Try Again.--]\n");
						Pause.pause(350);
						break;

					}
				}
				break;
			case '2': // Look around for Enemies to fight
				break;
			case '3': // Visit the available Shop
				shop.startShop();
				break;
			case '4': // Switch your equipped weapon
				break;
			case '5': // Progress the story
				break;
			case '6': // Rest and recover
				player.setCurrency(player.getCurrency() - 100);
				Dialogue.infoDialogue("\nYou've paid 100 gold to rest and recover your health.\n", 10);
				break;
			case '7': // Save and Exit
				inHub = false;
				break;
			default:
				System.err.println("[---Invalid Option. Try Again.--]\n");
				Pause.pause(350);
				break;

			}

		}

	}

}
