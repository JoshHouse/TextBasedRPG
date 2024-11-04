package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameThread extends Throwable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * ----- Main -----
	 * 
	 */

	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);

		// Player Inventory Test
		SpecialAttack gSsA = new SpecialAttack("You Leap into the Air and bring your sword down with mighty force",
				1.5);
		SpecialAttack fSsA = new SpecialAttack("You launch a wall of fire hurling towards your enemies", 2.7);
		SpecialAttack lBsA = new SpecialAttack(
				"You fire a well aimed shot, curving to hit the enemy where they would least expect it", 2.0);

		Weapon greatSword = new Weapon("1111", "Great Sword", "A Mighty Big Sword", 2, 30, 25, 1, true, 0, gSsA);
		Weapon fireStaff = new Weapon("2222", "Fire Staff", "Send your enemies out in a blaze of glory", 5, 1000, 500,
				3, true, 75, fSsA);
		Weapon longBow = new Weapon("3333", "Long Bow",
				"Forged in the elven mountains, this bow is extremely well made", 3, 250, 75, 2, true, 0, lBsA);

		Consumable throwingAxe = new Consumable("4444", "Throwing Axe", "Hurl an axe at your enemies", 1, 10, 20, 1,
				true, 1, true);
		Consumable healthPotion = new Consumable("5555", "Health Potion",
				"Use this when you're in need of a pick-me-up", 2, 20, 0, -1, true, 1, true);
		Consumable homemadeExplosives = new Consumable("6666", "Home-Made Explosives",
				"Your enemies won't know what hit them. You might not want to stand too close though", 3, 75, 200, 2,
				true, 1, true);

		Inventory testPlayerInv = new Inventory();
		testPlayerInv.add(greatSword);
		testPlayerInv.add(fireStaff);
		testPlayerInv.add(longBow);

		testPlayerInv.add(throwingAxe);
		testPlayerInv.add(healthPotion);
		testPlayerInv.add(homemadeExplosives);

		// Shopkeeper Inventory Test
		SpecialAttack gSsA1 = new SpecialAttack("You Leap into the Air and bring your sword down with mighty force",
				1.5);
		SpecialAttack fSsA1 = new SpecialAttack("You launch a wall of fire hurling towards your enemies", 2.7);
		SpecialAttack lBsA1 = new SpecialAttack(
				"You fire a well aimed shot, curving to hit the enemy where they would least expect it", 2.0);

		Weapon greatSword1 = new Weapon("1111", "Great Sword", "A Mighty Big Sword", 2, 30, 25, 1, true, 0, gSsA1);
		Weapon fireStaff1 = new Weapon("2222", "Fire Staff", "Send your enemies out in a blaze of glory", 5, 1000, 500,
				3, true, 75, fSsA1);
		Weapon longBow1 = new Weapon("3333", "Long Bow",
				"Forged in the elven mountains, this bow is extremely well made", 3, 250, 75, 2, true, 0, lBsA1);

		Consumable throwingAxe1 = new Consumable("4444", "Throwing Axe", "Hurl an axe at your enemies", 1, 10, 20, 1,
				true, 1, true);
		Consumable healthPotion1 = new Consumable("5555", "Health Potion",
				"Use this when you're in need of a pick-me-up", 2, 20, 0, -1, true, 1, true);
		Consumable homemadeExplosives1 = new Consumable("6666", "Home-Made Explosives",
				"Your enemies won't know what hit them. You might not want to stand too close though", 3, 75, 200, 2,
				true, 1, true);
		Inventory testShopkeeperInv = new Inventory();

		testShopkeeperInv.add(greatSword1);
		testShopkeeperInv.add(fireStaff1);
		testShopkeeperInv.add(longBow1);

		testShopkeeperInv.add(throwingAxe1);
		testShopkeeperInv.add(healthPotion1);
		testShopkeeperInv.add(homemadeExplosives1);

		Player testPlayer = new Player("Joshua", testPlayerInv, 600, 200, 4, 26, fireStaff, 250, 3, 2, 5, 1, 3);

		String enterShopDialog = "Welcome to the shop!";
		String exitShopDialog = "See you again next time!";
		String saleDialog = "Hope you enjoy!";
		String inShops1 = "Hope I meet my sales quota";
		String inShops2 = "Great to see some customers";
		String inShops3 = "Been a slow day today";
		String s1 = "Have you heard about the dragon on the mountain?";
		String s2 = "People keep gossiping in town";
		String s3 = "Man its been a long day";
		ArrayList<String> sampleDialog = new ArrayList<String>();
		ArrayList<String> sampleInShopDialog = new ArrayList<String>();
		sampleDialog.add(s1);
		sampleDialog.add(s2);
		sampleDialog.add(s3);
		sampleInShopDialog.add(inShops1);
		sampleInShopDialog.add(inShops2);
		sampleInShopDialog.add(inShops3);

		Shopkeeper testShopkeeper = new Shopkeeper("Gandalf", testShopkeeperInv, sampleDialog, enterShopDialog,
				exitShopDialog, saleDialog, sampleInShopDialog);

		Shop YeOlShop = new Shop(testPlayer, testShopkeeper, "Ye Ol Shop");

		YeOlShop.startShop();

//		Shopkeeper demoShopkeeper = new Shopkeeper("Cosmos", "Hello there! How can I help you?", "Will that be all?",
//				"Have a nice day!");
//		demoShopkeeper.addInShopDialog("How's the weather today? I think it's quite lovely.");
//		demoShopkeeper.addInShopDialog("We don't have a lot here, so feel free to take your time looking around.");
//		demoShopkeeper.addInShopDialog(
//				"I don't mean to add any pressure, but I really hope I can hit my sales quota for today.");
//		Shop demoShop = new Shop("Demo Armory Shop", demoShopkeeper);
//
//		Scanner scn = new Scanner(System.in);

		scn.close();
	}

	/**
	 * 
	 * ----- Functions -----
	 * 
	 */

	// --------------------Formatting Functions--------------------
	public static void breakLine() {  
	    System.out.println("------------------------------");
	}
	
	// --------------------General Functions--------------------
	public static void BeginningGame(Player player, Scanner keyboard) {
		
	}
	
	// --------------------Dialog Functions--------------------
	public static void ApproachCastle(Player player) {
		
	}
	
	public static void KingsFinalMission(Player player) {
		
	}
	
	public static boolean meleeDragonApproach(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean rangedDragonApproach(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean mageDragonApproach(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean rogueDragonApproach(Player player, Scanner keyboard) {
		return true;
	}
	
	// --------------------Mission Functions--------------------
	public static boolean kingsMission(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean dragonFight(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean meleeChapter1(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean rangedChapter1(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean mageChapter1(Player player, Scanner keyboard) {
		boolean makingChoice = true;
		int pChoice;
		Weapon trainingWand = new Weapon();
		
		breakLine();
		System.out.println("[Herald the Wizard] Hello " + player.getName() + "! I heard we had a newcomer in town!"
				+ "Interested in learning how to use magic to defend yourself from the various different monsters,"
				+ "enemies, and mythical beasts you can find around here? Well you've come to the right place! Although"
				+ "I am no expert, I can definitely help get you started!");
		
		while (makingChoice) {
			System.out.println("[Herald the Wizard] Does that sound like something you might be interested in? \n"
					+ "1) Absolutely!\n"
					+ "2) I'm not sure if I'm interested in magic.");
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				System.out.println("[" + player.getName() + "] Absolutely!");
				System.out.println("[Herald the Wizard] Great to hear! It's always nice to have another mage in town!");
				makingChoice = false;
				break;
				
			case 2:
				breakLine();
				System.out.println("[" + player.getName() + "] I'm not sure if I'm interested in magic.");
				System.out.println("[Herald the Wizard] That's alright! I'll be here if you change your mind!");
				return false;
				
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
			}
		}
		
		System.out.println("[Herald the Wizard] First of all we need to get you started with a weapon that can"
				+ "channel magic energy. I believe I have an old wand around here somewhere ... Ah here it is!"
				+ "This was my first wand and its great for training. You can definitely find better weapons"
				+ "around town though! I have heard rumors of some pretty strong magic weapons but those are"
				+ "pretty dangerous to get. But no need to worry about those right now! First you need to get the"
				+ "basics down. Here, take this wand.");
		
		
		return true;
	}
	
	public static boolean rogueChapter1(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean meleeSpecialMission(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean rangedSpecialMission(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean mageSpecialMission(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean rogueSpecialMission(Player player, Scanner keyboard) {
		return true;
	}
	
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
	 * Takes the player and the enemy and processes exchange of EXP and currency
	 * 
	 * @param p1
	 * @param e1
	 */
	public static void EXPDefeat(Player p1, Enemy e1) {

		System.out.println("Defeated " + e1.getName() + "!\nRewards:");
		System.out.println("- " + e1.getExp() + " EXP");
		System.out.println("- " + e1.getCurrency() + " Money");

		p1.setExp(p1.getExp() + e1.getExp()); // Add EXP after displayed messages
		p1.lvlUp(); // Attempt to level up
		p1.setCurrency(p1.getCurrency() + e1.getCurrency()); // Add currency after displayed messages
	}

}