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
		int txtSpd = 25; 
		int wait = 1000;
		int pChoice;
		boolean makingChoice = true;
		String pName = player.getName();
		String wizName = "Magnus the King's Wizard";
		
		breakLine();
		Dialogue.characterDialogue(wizName, "I heard you defeated the Troll that has been terrorizing the "
				+ "townspeople. That is pretty impressive! That Troll has been a pain in our side for a little "
				+ "over a year now. I hear the King is pretty impressed with you too! Although that goes "
				+ "without saying if he’s allowing you to take orders from me.\n",
				txtSpd);
		
		while (makingChoice) {
			Dialogue.characterDialogue( wizName, "Speaking of, did the King mention that I had something "
					+ "I needed done that you might be able to help me out with?\n"
					+ "1) Yes I believe he did.\n"
					+ "2) I don’t recall. But I’d be willing to hear you out now.\n", 
					txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				Dialogue.characterDialogue(pName, "Yes I believe he did.\n",txtSpd);
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				Dialogue.characterDialogue(pName, "I don’t recall. But I’d be willing to hear you out now.\n",
						txtSpd);
				makingChoice = false;
				break;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		Dialogue.characterDialogue(wizName , "Well I have run into a bit of a roadblock in some research "
				+ "I have been doing. I have been looking into the inner workings of Fire Magic but to further "
				+ "my research I need a firestone. They can be found in the Fire Cave located on Mount "
				+ "Cloudripper. I would go retrieve it myself but I am the one responsible for the protective "
				+ "barrier around the kingdom. If I were to leave, it would put our population at risk of enemy "
				+ "magic users. I have been searching for someone strong enough to retrieve it for me but have not "
				+ "found much luck until now. I have sent multiple adventurers out but all of them have failed to "
				+ "come back. If you were strong enough to defeat the Troll, you might have a chance to make it "
				+ "back though! If you can make it to the bottom of the cave, there might be a powerful magic "
				+ "weapon in it for you.\n",
				txtSpd);
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.characterDialogue(wizName, "What do you think?\n"
					+ "1) That sounds interesting. What should I expect if I were to go?\n"
					+ "2) I’m not too sure. That sounds dangerous. I’m not sure if the magic weapon would be "
					+ "worth it.\n", 
					txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				Dialogue.characterDialogue(pName, "That sounds interesting. What should I expect if I were to go?\n",
						txtSpd);
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				Dialogue.characterDialogue(pName, "I’m not too sure. That sounds dangerous. I’m not sure if the "
						+ "magic weapon would be worth it.\n",
						txtSpd);
				Dialogue.characterDialogue(wizName , "That is understandable. It’s not a decision to make lightly. "
						+ "Let me know if you change your mind!\n",
						txtSpd);
				return false;
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		Dialogue.characterDialogue(wizName , "If you were to attempt this journey, I will not sugar coat it. "
				+ "It will be dangerous and you will encounter many strong enemies through the cave. As you "
				+ "journey deeper into the cave, you will more than likely encounter Fire Elementals. They are "
				+ "no joke and pack a serious punch. You will definitely want to stay on guard. But those are "
				+ "not the worst of your worries. One of the strongest fire magic users used to live in that "
				+ "cave, and right before the entrance to his home, he summoned a Fire Elemental Rock Golem as a "
				+ "bodyguard. The wizard is long dead but that Golem still stands to protect the wizard’s "
				+ "possessions. It can do some serious damage so if you decide to take on this challenge, the "
				+ "Golem will be your biggest hurdle.\n",
				txtSpd);
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("How do you respond?\n"
					+ "1) That sound’s like a very dangerous mission. What’s in it for me? You mentioned a "
					+ "powerful magic weapon?\n"
					+ "2) I’m not so sure that is a mission I would like to go on. Let me think about it.\n",
					txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				Dialogue.characterDialogue(pName, "That sound’s like a very dangerous mission. What’s in it for me? "
						+ "You mentioned a powerful magic weapon?\n",txtSpd);
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				Dialogue.characterDialogue(pName, "I’m not so sure that is a mission I would like to go on. Let "
						+ "me think about it.\n",
						txtSpd);
				Dialogue.characterDialogue(wizName , "That is understandable. It’s not a decision to make lightly. "
						+ "Let me know if you change your mind!\n",txtSpd);
				return false;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		Dialogue.characterDialogue(wizName , "Absolutely! This is not something I would ask you to do if there "
				+ "wasn’t anything in it for you. I have heard rumors that the wizard’s Fire Staff lies within "
				+ "his home, along with the Fire Stones. That Fire Staff is one of the strongest magic weapons "
				+ "you can find if you can make it through the Golem. Of course, I have only heard rumors and, "
				+ "not having been there myself, I can’t confirm whether it’s there. But if it is, it would make "
				+ "the trip worth it for just about any magic user.\n",
				txtSpd);
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.characterDialogue(wizName, "With that in mind, what do you think?\n"
					+ "1) I think I’ll give it a shot! How do I get to the cave?\n"
					+ "2) I’m not too sure. Let me think about it.\n",txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				Dialogue.characterDialogue(pName, "I think I’ll give it a shot! How do I get to the cave?\n",txtSpd);
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				Dialogue.characterDialogue(pName, "I’m not too sure. Let me think about it.\n",txtSpd);
				Dialogue.characterDialogue(wizName , "I completely understand. It’s not a decision to make lightly. "
						+ "Let me know if you change your mind!\n",txtSpd);
				return false;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		Dialogue.characterDialogue(wizName , "Great to hear! To reach the cave, head down the main road "
				+ "out of town. Then head toward the tallest mountain on the skyline. That’s Mount Cloudripper. "
				+ "The Fire Cave can be found on the opposite side of the mountain if you are leaving from "
				+ "the main gate. It’s almost impossible to miss. There is a fiery glow emanating from the "
				+ "entrance as a result of the flame infused rock that lines the walls of the cave. Deep within "
				+ "is where you’ll find the wizard’s hideout.\n",
				txtSpd);
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.characterDialogue(wizName, "I wish you luck on your journey and a better fate than "
					+ "those who have attempted this journey before you!\n"
					+ "1) Thank you! I will be on my way now!\n"
					+ "2) Thank you! I will be back soon, stone and staff in hand!\n",txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				Dialogue.characterDialogue(pName, "Thank you! I will be on my way now!\n",txtSpd);
				Dialogue.characterDialogue(wizName, "Of course! I hope to see you again soon!\n",txtSpd);
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				Dialogue.characterDialogue(pName, "Thank you! I will be back soon, stone and staff in hand!\n",
						txtSpd);
				Dialogue.characterDialogue(wizName, "Of course! I have every confidence you will!\n",txtSpd);
				makingChoice = false;
				break;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		Dialogue.infoDialogue("*You travel down the main road, away from the castle, mentally preparing yourself "
				+ "for the intense journey ahead of you. As you reach the main gate, you see the sun setting on "
				+ "the horizon, lighting the sky in an orange hue. Along the horizon, you see Mount Cloudripper "
				+ "standing far above everything else. You walk in the direction of the mountain, reaching it as "
				+ "night falls. You see a bright orange glow emanating from a cave entrance about half way up the "
				+ "mountain. By torch light, you make the treacherous journey up the path scaling tight cliff "
				+ "sides and narrowly escaping death on numerous occasions, having to be cautious of stepping on "
				+ "loose rock along the way. You finally reach the cave’s entrance, but after your long and "
				+ "treacherous journey, you find yourself exhausted. You decide to set up camp under an overhanging "
				+ "boulder to rest before your trek into the cave.*\n", 
				txtSpd);
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("*You wake up and see the sun overhead. You have rested through the night. What "
					+ "do you want to do?*\n "
					+ "1) *Being well rested, I am ready to make my journey into the depths*\n "
					+ "2) *I find myself still exhausted, I would like to rest some more*\n",
					txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				Dialogue.infoDialogue("*You decide to rest some more, sleeping through another day*\n", txtSpd);
				break;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		Dialogue.infoDialogue("*You begin your journey into the cave, noticing a dramatic rise in temperature. "
				+ "It is almost unbearable but you journey deeper in pursuit of your goal. Despite the blazing "
				+ "heat, you can’t help but admire the glowing formations of fire infused rock stalactites and "
				+ "stalagmites hanging overhead and rising up from the earth. As you travel deeper, you feel a "
				+ "sudden blast of heat and a screech that sends shivers down your spine. A large, four legged "
				+ "beast that seems to be perpetually on fire bursts out from around a path down the cave. You "
				+ "are now standing face to face with a Fire Elemental!*\n",
				txtSpd);
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("*Are you ready to fight?*\n"
					+ "1) *Nothing will stand in my way! I will slay the Fire Elemental!*\n"
					+ "2) *I can’t possibly deal with a beast this size. I must hide!*\n", txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				Dialogue.infoDialogue("*You raise your weapon, prepared for a tough battle*\n", txtSpd);
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				Dialogue.infoDialogue(" *You run to hide behind a rock formation! The beast, having caught a "
						+ "glimpse of you, will not leave its post. The only way out is through!*\n", txtSpd);
				makingChoice = false;
				break;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		/*
		 * 
		 * Fire Elemental Fight
		 * 
		 */
		
		/*
		 * lose:
		 * return false;
		 * 
		 * win:
		 */
		
		Dialogue.infoDialogue("* Having defeated the elemental, you continue through the cave with every step "
				+ "sending echoes down the long corridors of rocky terrain. Fiery geysers shoot blasts of "
				+ "flames from deep within the earth sending blasts of heat that are almost unbearable. Despite "
				+ "this, you venture on in pursuit of the treasure that lies deep within the cave. As you continue "
				+ "downward, you come across the singed body of a fallen wizard, more than likely in the pursuit "
				+ "of the same goal you came down here for.*\n", 
				txtSpd);
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("What will you do? \n"
					+ "1) *Loot the body*\n"
					+ "2) *Continue onward\n", txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				/*
				 * Loot functionality
				 */
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				makingChoice = false;
				break;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		Dialogue.infoDialogue("*You continue onward, on the lookout for the enemy that might have caused "
				+ "the death of that adventurer. That is when you hear another screech, no doubt coming from "
				+ "another Fire Elemental. You see the bright glow coming from the tunnel and in an instant "
				+ "have come face to face with the elemental. *\n", 
				txtSpd);
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("*Are you ready to fight?*\n"
					+ "1) *I was born ready*\n"
					+ "2) *I need to hide!*", txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				Dialogue.infoDialogue("*Poised with your weapon ready for battle, you face the fire elemental showing no fear*\n", txtSpd);
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				Dialogue.infoDialogue("*Unfortunately you do not have time to run away. You draw your weapon and "
						+ "ready yourself for another tough battle.*\n", txtSpd);
				makingChoice = false;
				break;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		/*
		 * 
		 * Fire Elemental Fight
		 * 
		 */
		
		/*
		 * lose:
		 * return false;
		 * 
		 * win:
		 */
		
		Dialogue.infoDialogue("*Having won the battle, you move on further down the cave. That is when you "
				+ "see it! You enter into a large open room and rush behind a boulder. Standing in the center "
				+ "of the room, ready for a fight, is the Fire Elemental Rock Golem. It stands roughly 20 feet "
				+ "tall, ready to take on anyone wishing to obtain the Fire Wizard’s Possessions. Lava courses "
				+ "between the stones that make up its body and drips from every crack and joint of its stature. "
				+ "The heat emanating from its sheer presence is enough to deter the weak willed. You have come "
				+ "this far though and you refuse to back down.*\n", txtSpd);
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("*Are you ready to fight?*\n"
					+ "1) Yes! I will take down the beast!\n"
					+ "2) No I would like some time to look through my bag and prepare\n", txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				Dialogue.infoDialogue("*Confident in your abilities, you appear from behind the boulder with "
						+ "your weapon drawn, ready to take down the menacing golem that stands in your path!*\n", 
						txtSpd);
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				/*
				 * Inventory Management functionality
				 */
				Dialogue.infoDialogue("*Having prepared for the fight, you appear from behind the boulder, ready "
						+ "for your toughest fight yet!*\n", txtSpd);
				makingChoice = false;
				break;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		/*
		 * 
		 * Fire Elemental Rock Golem Fight
		 * 
		 */
		
		/*
		 * lose:
		 * return false;
		 * 
		 * win:
		 */
		
		Dialogue.infoDialogue("*As the beast falls, the ground shakes as it hits the ground. On the other "
				+ "side of the opening, you see a door. That is no doubt the entrance to the Fire wizard’s "
				+ "home. You enter to see, propped up on a stand, the fire staff glowing with flame energy. "
				+ "You pick up the staff and feel the magical power coursing through the staff. On a shelf above "
				+ "the wizard’s alchemy table, you find the Fire Stone that Magnus asked you to retrieve. You "
				+ "grab both and notice a chest by the wizard’s bed.*\n", 
				txtSpd);
		// player.getInventory().add(wList.fireStaff);
		System.out.println("The Fire Staff has been added to your Inventory!");
		System.out.println("The Fire Stone has been added to your Inventory!");
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("What do you do?\\n\n"
					+ "1) Loot the chest\\n\n"
					+ "2) Leave\n", txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				/*
				 * Loot functionality
				 */
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				makingChoice = false;
				break;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		Dialogue.infoDialogue("*You make the trek back through the cave, having defeated all the enemies, "
				+ "you are free to admire the beauty of the flame embedded rock that lines the cave. As you exit, "
				+ "you feel the sun on your face and your eyes have to get adjusted to the light. You journey "
				+ "back to the castle and talk to Magnus the Wizard*\n", 
				txtSpd);
		Dialogue.characterDialogue(wizName, "My god you made it back! Fire stone in hand as well! You truly "
				+ "must be strong if you were able to contend with the likes of the Golem! Thank you for retrieving "
				+ "the stone! This will do wonders to further my research! You will have to tell me about your "
				+ "journey sometime! For now though, you have definitely proven yourself worthy to contend in "
				+ "the Arena and hone your skills. Many high class merchants will also be eager to sell new "
				+ "powerful items to someone they know can wield their power. Take a look around the castle and "
				+ "see what new opportunities might open up! When you're ready, go talk to the King. He will "
				+ "definitely be impressed when I tell him what you have accomplished!\n", 
				txtSpd);
		
		while (makingChoice) {
			Dialogue.infoDialogue("1) Will do thank you!\n"
					+ "2) I will definintely have to check it out!\n", txtSpd);
			pChoice = keyboard.nextInt();
			
			switch (pChoice) {
			case 1:
				breakLine();
				Dialogue.characterDialogue(pName, "Will do thank you!\n", txtSpd);
				makingChoice = false;
				break;
			
			case 2:
				breakLine();
				Dialogue.characterDialogue(pName, "I will definintely have to check it out!\n", txtSpd);
				makingChoice = false;
				break;
			
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
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