package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import indexes.EnemyList;
import indexes.WeaponList;

public class GameThread extends Throwable {

	private static final long serialVersionUID = 1L;

	private static WeaponList wList = new WeaponList();
	
	private static EnemyList eList = new EnemyList();

	
	/**
	 * 
	 * ----- Main -----
	 * 
	 */

	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);

		Player p1 = new Player("Nova", new Inventory(true, true, true), 1000, 180, 1, 0, 50, 4, 2, 1, 2, 9);
		p1.getInventory().add(wList.sword1);
		p1.getInventory().add(wList.axe2);
		p1.getInventory().add(wList.spear2);
		p1.getInventory().add(wList.axe1);
		p1.getInventory().add(wList.sword3);
		Shopkeeper keep = new Shopkeeper();
		Shop shop = new Shop(p1, keep, "Armory");
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		String[] searchTxt = {
				"Nothing but the fluffy clouds and beautiful buildings ahead.\nIt's quite nice to look at.",
				"Around the corner, there's appears to be a mime entertaining a crowd.\nNothing that seems too interesting "
						+ "to you, however.",
				"As you walk around, you get annoyed by gnats buzzing around your ears.\nIf only they were bigger. "
						+ "You could slay them easily...",
				"The city streets are rather lively today.\nThough, there's no signs of trouble, thankfully." };

		meleeChapter1(p1, scn);

		Hub hub1 = new Hub(p1, "Central Street", shop, enemies, searchTxt);
		hub1.start(scn);

		scn.close();

//		// Player Inventory Test
//		SpecialAttack gSsA = new SpecialAttack("You Leap into the Air and bring your sword down with mighty force",
//				1.5);
//		SpecialAttack fSsA = new SpecialAttack("You launch a wall of fire hurling towards your enemies", 2.7);
//		SpecialAttack lBsA = new SpecialAttack(
//				"You fire a well aimed shot, curving to hit the enemy where they would least expect it", 2.0);
//
//		Weapon greatSword = new Weapon("1111", "Great Sword", "A Mighty Big Sword", 2, 30, 25, 1, true, 0, gSsA);
//		Weapon fireStaff = new Weapon("2222", "Fire Staff", "Send your enemies out in a blaze of glory", 5, 1000, 500,
//				3, true, 75, fSsA);
//		Weapon longBow = new Weapon("3333", "Long Bow",
//				"Forged in the elven mountains, this bow is extremely well made", 3, 250, 75, 2, true, 0, lBsA);
//
//		Consumable throwingAxe = new Consumable("4444", "Throwing Axe", "Hurl an axe at your enemies", 1, 10, 20, 1,
//				true, 1, true);
//		Consumable healthPotion = new Consumable("5555", "Health Potion",
//				"Use this when you're in need of a pick-me-up", 2, 20, 0, -1, true, 1, true);
//		Consumable homemadeExplosives = new Consumable("6666", "Home-Made Explosives",
//				"Your enemies won't know what hit them. You might not want to stand too close though", 3, 75, 200, 2,
//				true, 1, true);
//
//		Inventory testPlayerInv = new Inventory();
//		testPlayerInv.add(greatSword);
//		testPlayerInv.add(fireStaff);
//		testPlayerInv.add(longBow);
//
//		testPlayerInv.add(throwingAxe);
//		testPlayerInv.add(healthPotion);
//		testPlayerInv.add(homemadeExplosives);
//
//		// Shopkeeper Inventory Test
//		SpecialAttack gSsA1 = new SpecialAttack("You Leap into the Air and bring your sword down with mighty force",
//				1.5);
//		SpecialAttack fSsA1 = new SpecialAttack("You launch a wall of fire hurling towards your enemies", 2.7);
//		SpecialAttack lBsA1 = new SpecialAttack(
//				"You fire a well aimed shot, curving to hit the enemy where they would least expect it", 2.0);
//
//		Weapon greatSword1 = new Weapon("1111", "Great Sword", "A Mighty Big Sword", 2, 30, 25, 1, true, 0, gSsA1);
//		Weapon fireStaff1 = new Weapon("2222", "Fire Staff", "Send your enemies out in a blaze of glory", 5, 1000, 500,
//				3, true, 75, fSsA1);
//		Weapon longBow1 = new Weapon("3333", "Long Bow",
//				"Forged in the elven mountains, this bow is extremely well made", 3, 250, 75, 2, true, 0, lBsA1);
//
//		Consumable throwingAxe1 = new Consumable("4444", "Throwing Axe", "Hurl an axe at your enemies", 1, 10, 20, 1,
//				true, 1, true);
//		Consumable healthPotion1 = new Consumable("5555", "Health Potion",
//				"Use this when you're in need of a pick-me-up", 2, 20, 0, -1, true, 1, true);
//		Consumable homemadeExplosives1 = new Consumable("6666", "Home-Made Explosives",
//				"Your enemies won't know what hit them. You might not want to stand too close though", 3, 75, 200, 2,
//				true, 1, true);
//		Inventory testShopkeeperInv = new Inventory();
//
//		testShopkeeperInv.add(greatSword1);
//		testShopkeeperInv.add(fireStaff1);
//		testShopkeeperInv.add(longBow1);
//
//		testShopkeeperInv.add(throwingAxe1);
//		testShopkeeperInv.add(healthPotion1);
//		testShopkeeperInv.add(homemadeExplosives1);
//
//		Player testPlayer = new Player("Joshua", testPlayerInv, 600, 200, 4, 26, fireStaff, 250, 3, 2, 5, 1, 3);
//
//		String enterShopDialog = "Welcome to the shop!";
//		String exitShopDialog = "See you again next time!";
//		String saleDialog = "Hope you enjoy!";
//		String inShops1 = "Hope I meet my sales quota";
//		String inShops2 = "Great to see some customers";
//		String inShops3 = "Been a slow day today";
//		String s1 = "Have you heard about the dragon on the mountain?";
//		String s2 = "People keep gossiping in town";
//		String s3 = "Man its been a long day";
//		ArrayList<String> sampleDialog = new ArrayList<String>();
//		ArrayList<String> sampleInShopDialog = new ArrayList<String>();
//		sampleDialog.add(s1);
//		sampleDialog.add(s2);
//		sampleDialog.add(s3);
//		sampleInShopDialog.add(inShops1);
//		sampleInShopDialog.add(inShops2);
//		sampleInShopDialog.add(inShops3);
//
//		Shopkeeper testShopkeeper = new Shopkeeper("Gandalf", testShopkeeperInv, sampleDialog, enterShopDialog,
//				exitShopDialog, saleDialog, sampleInShopDialog);
//
//		Shop YeOlShop = new Shop(testPlayer, testShopkeeper, "Ye Ol Shop");
//
//		YeOlShop.startShop();

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
	
	public static boolean meleeChapter1(Player player, Scanner scn) {

		int txtSpd = 25, wait = 1000;
		boolean pResponse = true;
		char input = ' ';
		boolean win = false;
		String charName = "???";

		Battle meleeTutorial = new Battle(player, eList.tutor1);

		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		Dialogue.infoDialogue(
				"As you arrive in the city, you decide that your first course of action should be to visit someplace\n"
						+ "where you can acquire a proper armament. Strolling around for a bit, you stumble upon an armory "
						+ "that\nwould suit your needs.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"Looking around, you could see that the place was... old. The shop wasn't in the best of shape. It's\n"
						+ "likely been around for a long time. The walls and floors were filled with cracks. Even though the\n"
						+ "interior seemed to be a mess, the weapons racks were in great condition, and all of the weapons "
						+ "were\nin great condition, a noteworthy contrast to the armory itself.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName, "What? First time seeing a run down shop?\n\n", txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"In the corner next to a furnace, there was an older gentlemen with gray, spiky hair and beard seated,\n"
						+ "pounding the dents out of a blade that had just been forged in the fire. He looked over, getting a\n"
						+ "good look at you.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"Oh? For a minute, I thought you were one of the usual land hawks. Oh well, not that any of that matters \n"
						+ "to you. You're new around these parts, aren't you?\n\n",
				txtSpd);
		Pause.pause(wait);

		while (pResponse) {
			Dialogue.infoDialogue("1) I am. How could you tell?\n2) No. What made you think that?\nReponse: ", 8);
			input = scn.next().charAt(0);

			switch (input) {
			case '1', '2':
				pResponse = false;
				System.out.println();
				break;
			default:
				System.err.println("Invalid choice. Try again.\n");
				Pause.pause(350);
				break;
			}
		}

		if (input == '1') {
			Dialogue.characterDialogue(charName,
					"When you've been around as long as I have, you meet a lot of people. There's not a single person in this\n"
							+ "city I haven't seen before, except the tourist in front of me.\n\n",
					txtSpd);
		} else {
			Dialogue.characterDialogue(charName,
					"If you're going to lie to an old man, try to make it sound convincing. I've been around for a long time.\n"
							+ "I'd recognize a tourist anywhere.\n\n",
					txtSpd);
		}
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"But that doesn't really matter. If you're a paying customer, then welcome.\n\n", txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"As the blade cooled down, the blacksmith finished what he was working on and walked over to you. As he got\n"
						+ "a good look at you, his eyes seemed to light up with interest.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"Hmm? Those eyes... That's the look of a warrior-to-be. So, you're someone with the heart of the fighter...\n"
						+ "Been a while since I've met a rookie adventurer. I remember when I was in your shoes a few decades "
						+ "ago.\n\n",
				txtSpd);
		Pause.pause(wait);

		charName = "Jagatai, Retired Warrior";

		Dialogue.characterDialogue(charName,
				"My name's Jagati. I used to be a warrior when I was younger, but my adventuring days are long behind me.\n"
						+ "If you're looking for a good place to get started with making a name for yourself, you've come"
						+ " to the right\nplace. Though, since your a greenhorn, "
						+ "I feel the need to ask--Are you aware of the basics of combat?\n\n",
				txtSpd);
		Pause.pause(wait);

		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue("1) Yes\n2) No\nReponse: ", 8);
			input = scn.next().charAt(0);

			switch (input) {
			case '1', '2':
				pResponse = false;
				System.out.println();
				break;
			default:
				System.err.println("Invalid choice. Try again.\n");
				Pause.pause(350);
				break;
			}
		}

		if (input == '1') {
			Dialogue.characterDialogue(charName, "Heh. So you've already been studying on what to expect.\n\n", txtSpd);
		} else {
			Dialogue.characterDialogue(charName, "If that's the case, then I won't mind giving you a crash course.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"Fighters like us, we obviously specialize in being up close and personal. Swords, spears, axes, we've "
							+ "got a\nvariety of weapons to attack with, some of them imbued with their own special attacks."
							+ "\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"Special attacks are techniques that are imbued into a weapon during their forging, allowing "
							+ "their wielder to\ndemonstrate lethal damage by calling them forth. But, there's a catch."
							+ "\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"Not just anybody can call them out at will. You've gotta be real lucky if you want to use "
							+ "a special attack\nsuccessfully. Bit of a \"high risk, high reward\" scenario, yeah?\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"That aside, I'm sure you don't need to be told to focus on defense.\n\n", txtSpd);

		}
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"You've got the basics in your head, but the only way to really remember them is to put them into practice.\n"
						+ "Here, I'll give you a little something to start your journey off with.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue("Walking over to a rack of swords, Jagatai removes one of them and hands it to you.\n\n",
				txtSpd);
		Pause.pause(wait);

		player.getInventory().add(wList.sword1);
		Dialogue.infoDialogue("[You got an Iron Sword]\n\n", txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"Don't get too excited over a free gift. It's just a simple blade. Nobody's imbued a special attack in\n"
						+ "it, and it doesn't use mana for anything. Oh, by the way, you know what mana is, don't you?\n\n",
				txtSpd);
		Pause.pause(wait);

		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue("1) Yes\n2) No.\nReponse: ", 8);
			input = scn.next().charAt(0);

			switch (input) {
			case '1', '2':
				pResponse = false;
				System.out.println();
				break;
			default:
				System.err.println("Invalid choice. Try again.\n");
				Pause.pause(350);
				break;
			}
		}

		if (input == '1') {
			Dialogue.characterDialogue(charName,
					"So you do. Then you know it's not really something you'd be using.\n\n", txtSpd);
		} else {
			Dialogue.characterDialogue(charName,
					"Mana's what mages use in their wands and weapons. It's an energy within a person's body that's expelled\n"
							+ "to attack or defend. I don't know too much about it, magic ain't my thing.\n\n",
					txtSpd);
		}
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"As you take a moment to observe the blade that you had been given, Jagatai picks up a black longsword\n"
						+ "before patting you on the shoulder, walking towards the door at the back of the armory.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"Well, there's no point in sitting there staring at that all day. Come on. I've got an old training spot\n"
						+ "out back. Let's see if all of that knowledge is gonna pay off when you're in combat.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"Sensing that a fight was coming, you steel your nerves before following the blacksmith, arriving in a\n"
						+ "fenced in area outside. Jagatai walks a good distance away from you before turning around, "
						+ "holding the\nsword in a middle guard stance.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"Better not expect any weak swings just cause you're new and I'm old. A couple of swings should help you\n"
						+ "get the feel of things, so try not to get banged up too much. Now bring it!\n\n",
				txtSpd);
		Pause.pause(wait);

		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		win = meleeTutorial.startBattle();

		if (win) {

			Dialogue.infoDialogue(
					"(As you battle enemies during your adventure, you will earn EXP after defeating them, the amount varying\n"
							+ "from enemy to enemy. Once you gain enough EXP, you will level up. Your stats will increase, "
							+ "and you will\nreceive a skill point to spend on one of the class stats, or your luck stat. You "
							+ "can view your overall\nlevel, the level of each stat, how much EXP you need to level up again, "
							+ "and how many skill points you\nhave available to spend all from your profile "
							+ "after the tutorial.)\n\n",
					txtSpd);
			Pause.pause(wait);
			Pause.pause();

			System.out.println(
					"---------------------------------------------------------------------------------------------------");

			Dialogue.infoDialogue(
					"The sparring session lasted barely over a minute before Jagatai found himself satisfied with you, "
							+ "putting\naway his weapon before nodding his head in approval.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"Looks like you've got a natural talent for combat too. I might not be in my prime anymore, but I "
							+ "can still\nsee you growing into the kind of warrior that could give me a run for my money.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"You'll do just fine out there as you learn and grow. Pretty soon, I'll be expecting to hear tales "
							+ "of your\naccomplishments. So, what's the name that I should be looking "
							+ "out for in the future?\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.infoDialogue("...\n\n", txtSpd + 80);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName, player.getName() + ", eh?\n\n", txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"Alright then. I'll be expecting to hear good things about the tales of " + player.getName()
							+ " while I'm still around.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName, "I wish you the best of luck, young warrior.\n\n", txtSpd);
			Pause.pause(wait);

			Dialogue.infoDialogue(
					"With Jagatai's words of praise fresh in your mind and a new sword in your hands, "
							+ "you exit the armory with\nyour morale high, ready to embark on your new adventure.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.infoDialogue("This marks the beginning of the tale of " + player.getName() + "...", txtSpd + 20);
			Pause.pause(wait);

			System.out.println("\n");
			Pause.pause();

		}

		return true;
	}
	
	public static boolean rangedChapter1(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean mageChapter1(Player player, Scanner keyboard) {
		boolean makingChoice = true;
		int pChoice;
		Battle tutorialBattle = new Battle(player, eList.sheep);
		boolean playerWon = false;
		
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
		
		System.out.println("[Herald the Wizard] First of all we need to get you started with a weapon that can "
				+ "channel magic energy. I believe I have an old wand around here somewhere ... Ah here it is! "
				+ "This was my first wand and its great for training. You can definitely find better weapons "
				+ "around town though! I have heard rumors of some pretty strong magic weapons but those are "
				+ "pretty dangerous to get. But no need to worry about those right now! First you need to get the "
				+ "basics down. Here, take this wand.");
		player.getInventory().add(wList.starterWand);
		System.out.println("The starter wand has been added to your inventory!");
		player.getInventory().getWeaponOnKey(wList.starterWand.getKey()).displayInfo();
		
		makingChoice = true;
		pChoice = 0;
		
		while (makingChoice) {			
			breakLine();
			System.out.println("[Herald the Wizard] Now that you have a weapon, I whould probably explain mana. Mana is the power inside "
					+ "each person that can be channeled through the use of magic weapons. Magic weapons use a portion "
					+ "of your built up mana to launch an attack! Be careful though because you can run out and your "
					+ "weapon will no longer work. Through tough battles you can increase the effectiveness of your magic "
					+ "and the amount of mana you can store.");
			System.out.println("Your current mana storage is: " + player.getMana());
			breakLine();
			System.out.println("1) Okay I think I got it!\n"
					+ "2) Explain that again?");
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			
			case 1:
				breakLine();
				System.out.println("[" + player.getName() + "] Okay I think I got it!");
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				System.out.println("[" + player.getName() + "] Explain that again?");
				break;
			
			default:
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		System.out.println("[Herald the Wizard] Great! Now that you understand the basics, why don't you test your "
				+ "skills on this sheep! Don't worry sheep around here aren't known for their fighting abilities.");
		
		while (!playerWon) {
			playerWon = tutorialBattle.startBattle();
			if (!playerWon) {
				player.setCurrHP(player.getHealth());
				tutorialBattle.getEnemy().setCurrHP(tutorialBattle.getEnemy().getHealth());
				tutorialBattle.setTurn(0);
				System.out.println("[Herald the Wizard] Thats okay you'll get the hang of it. take another shot at "
						+ "it!");
			}
		}
		
		breakLine();
		System.out.println("[Herald the Wizard] Nice! It seems like you got the hang of it! That;s about all I can "
				+ "teach you. I'm not much of the adventurous type so I really only know the basics. It comes in handy "
				+ "though for work around town. Since you're new around here, you should probably go check out the castle. "
				+ "Just about everything important happens around there. The King also might be interested in testing"
				+ "your skills too if you're up for the challenge. If you can get in his good graces, you might get a "
				+ "chance to talk to the King's wizard. He's probably the most knowledgable person you can find around "
				+ "here when it comes to magic! If you make it big, don't forget who taught you the basics though haha! "
				+ "And pay me a visit if you get the chance!");
	
		makingChoice = true;
		pChoice = 0;
		
		while (makingChoice) {
			
			breakLine();
			System.out.println("1) Will do! Thanks for the advice!\n"
				+ "2) I'll definitely have to check out the castle!");
			pChoice = keyboard.nextInt();
		
			switch(pChoice) {
			
			case 1:
				breakLine();
				System.out.println("[" + player.getName() + "] Will do! Thanks for the advice!");
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				System.out.println("[" + player.getName() + "] I'll definitely have to check out the castle!");
				makingChoice = false;
				break;
				
			default:
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}

		return true;
	}
	
	public static boolean rogueChapter1(Player player, Scanner keyboard) {
		return true;
	}
	
	public static boolean meleeSpecialMission(Player player, Scanner keyboard) {
		int txtSpd = 25, wait = 1000;
		String pName = player.getName();
		String wizName = "Magnus the King's Wizard";
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