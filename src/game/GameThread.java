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
		SpecialAttack gSsA = new SpecialAttack("You Leap into the Air and bring your sword down with mighty force", 1.5);
		SpecialAttack fSsA = new SpecialAttack("You launch a wall of fire hurling towards your enemies", 2.7);
		SpecialAttack lBsA = new SpecialAttack("You fire a well aimed shot, curving to hit the enemy where they would least expect it", 2.0);
		
		Weapon greatSword = new Weapon( "1111", "Great Sword",  "A Mighty Big Sword",  2,  30,  25,  1,
				 true, 0, gSsA);
		Weapon fireStaff = new Weapon( "2222", "Fire Staff",  "Send your enemies out in a blaze of glory",  5,  1000,  500,  3,
				 true, 75, fSsA);
		Weapon longBow = new Weapon( "3333", "Long Bow",  "Forged in the elven mountains, this bow is extremely well made",  
				3,  250,  75,  2, true, 0, lBsA);
		
		Consumable throwingAxe = new Consumable("4444", "Throwing Axe", "Hurl an axe at your enemies", 1, 10, 
				20, 1, true, 1, true);
		Consumable healthPotion = new Consumable("5555", "Health Potion", "Use this when you're in need of a pick-me-up", 
				2, 20, 0, -1, true, 1, true);
		Consumable homemadeExplosives = new Consumable("6666", "Home-Made Explosives", "Your enemies won't know what hit them. You might not want to stand too close though", 
				3, 75, 200, 2, true, 1, true);
		
		
		Inventory testPlayerInv = new Inventory();
		Inventory testShopkeeperInv = new Inventory();
		
		testPlayerInv.add(greatSword);
		testPlayerInv.add(fireStaff);
		testPlayerInv.add(longBow);
		
		testPlayerInv.add(throwingAxe);
		testPlayerInv.add(healthPotion);
		testPlayerInv.add(homemadeExplosives);
		
		testShopkeeperInv.add(greatSword);
		testShopkeeperInv.add(fireStaff);
		testShopkeeperInv.add(longBow);
		
		testShopkeeperInv.add(throwingAxe);
		testShopkeeperInv.add(healthPotion);
		testShopkeeperInv.add(homemadeExplosives);
		
		
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