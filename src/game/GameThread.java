package game;

import java.io.*;
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

		Player player = new Player("Josh");

		mageChapter1(player, scn);
		
		
		
		
		
		
		
		
		
		
		
		
		
		//		Player p1 = new Player("Nova", new Inventory(true, true, true), 1000, 180, 1, 0, 50, 4, 2, 1, 2, 9);
//		p1.getInventory().add(wList.sword1);
//		p1.getInventory().add(wList.axe2);
//		p1.getInventory().add(wList.spear2);
//		p1.getInventory().add(wList.axe1);
//		p1.getInventory().add(wList.sword3);
//		Shopkeeper keep = new Shopkeeper();
//		Shop shop = new Shop(p1, keep, "Armory");
//		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
//		String[] searchTxt = {
//				"Nothing but the fluffy clouds and beautiful buildings ahead.\nIt's quite nice to look at.",
//				"Around the corner, there's appears to be a mime entertaining a crowd.\nNothing that seems too interesting "
//						+ "to you, however.",
//				"As you walk around, you get annoyed by gnats buzzing around your ears.\nIf only they were bigger. "
//						+ "You could slay them easily...",
//				"The city streets are rather lively today.\nThough, there's no signs of trouble, thankfully." };
//
//		meleeChapter1(p1, scn);
//
//		Hub hub1 = new Hub(p1, "Central Street", shop, enemies, searchTxt);
//		hub1.start(scn);
//
//		scn.close();

		

		scn.close();
	}

	/**
	 * 
	 * ----- Functions -----
	 * 
	 */
	// --------------------GameThread function--------------------
	
	public static void GameChapters(Player player, Scanner keyboard) {
		boolean inChapter = false;
		boolean willProgress = false;
		boolean chapterCompleted = false;
		int txtSpd = 25;
		char pChoice;
		
		/*
		 * 
		 * --------------------Chapter 1--------------------
		 * 
		 */
		if (true) {
			Hub chapter1Hub = instantiateHub(player, "Town");
			
			chapterCompleted = false;
			inChapter = true;
			while (inChapter) {
				
				willProgress = chapter1Hub.start(keyboard);
				// Save functionality
				if(!willProgress) {
					GameData saving = new GameData(player, chapter1Hub);
					save(saving);
					try {
						System.exit(0);
					} catch (SecurityException e) {
						System.err.println("(Error when exiting)");
					}
				// Progressing with the main story
				} else {
					breakLine();
					Dialogue.infoDialogue("You find yourself at a crossroads. Where do you decide to go?\n"
							+ "1) Armory (Melee) \n"
							+ "2) Archery Range (Ranger) \n"
							+ "3) Wizard's tower (Mage) \n"
							+ "4) (Rogue) \n", txtSpd);
					pChoice = keyboard.next().charAt(0);
					switch (pChoice) {
					case '1':
						chapterCompleted = meleeChapter1(player, keyboard);
						break;
					case '2':
						chapterCompleted = rangerChapter1(player, keyboard);
						break;
					case '3':
						chapterCompleted = mageChapter1(player, keyboard);
						break;
					case '4':
						chapterCompleted = rogueChapter1(player, keyboard);
						break;
					default:
						System.err.println("(Invalid input. Please try again.)");
						break;
					}
					if (chapterCompleted) {
						inChapter = false;
						/*
						 * Increment player's chapter counter
						 */
						ApproachCastle(player);
					}
					
				}
			}
		}
		
		/*
		 * 
		 * --------------------Chapter 2--------------------
		 * 
		 */
		if (true) {
			Hub chapter2Hub = instantiateHub(player, "Castle Common Grounds");
			
			chapterCompleted = false;
			inChapter = true;
			while (inChapter) {
				
				willProgress = chapter2Hub.start(keyboard);
				// Save functionality
				if(!willProgress) {
					GameData saving = new GameData(player, chapter2Hub);
					save(saving);
					try {
						System.exit(0);
					} catch (SecurityException e) {
						System.err.println("(Error when exiting)");
					}
				// Progressing with the main story
				} else {
					breakLine();
					
					chapterCompleted = kingsMission(player, keyboard);
					
					if (chapterCompleted) {
						inChapter = false;
						/*
						 * Increment player's chapter counter
						 */
					}
				}
			}
		}
		
		/*
		 * 
		 * --------------------Chapter 3--------------------
		 * 
		 */
		if (true) {
			Hub chapter3Hub = instantiateHub(player, "Castle Upper-Class Lobby");
			
			chapterCompleted = false;
			inChapter = true;
			while (inChapter) {
				
				willProgress = chapter3Hub.start(keyboard);
				// Save functionality
				if(!willProgress) {
					GameData saving = new GameData(player, chapter3Hub);
					save(saving);
					try {
						System.exit(0);
					} catch (SecurityException e) {
						System.err.println("(Error when exiting)");
					}
				// Progressing with the main story
				} else {
					breakLine();
					Dialogue.infoDialogue("Which of the king's high council would you like to speak to?\n"
							+ "1) (Melee) \n"
							+ "2) Elaris the Ranger (Ranger) \n"
							+ "3) Magnus the King's wizard (Mage) \n"
							+ "4) (Rogue) \n", txtSpd);
					pChoice = keyboard.next().charAt(0);
					switch (pChoice) {
					case '1':
						chapterCompleted = meleeSpecialMission(player, keyboard);
						break;
					case '2':
						chapterCompleted = rangedSpecialMission(player, keyboard);
						break;
					case '3':
						chapterCompleted = mageSpecialMission(player, keyboard);
						break;
					case '4':
						chapterCompleted = rogueSpecialMission(player, keyboard);
						break;
					default:
						System.err.println("(Invalid input. Please try again.)");
						break;
					}
					if (chapterCompleted) {
						inChapter = false;
						/*
						 * Increment player's chapter counter
						 */
					}
				}
			}
		}
		
		/*
		 * 
		 * --------------------Chapter 4--------------------
		 * 
		 */
		if (true) {
			Hub chapter4Hub = instantiateHub(player, "Castle Hero's Sector");
			boolean finalChant = true;
			Battle dragonFight = new Battle(player, eList.gilgemeshTheDragon, eList.gilgemeshsChildren);
			
			chapterCompleted = false;
			inChapter = true;
			while (inChapter) {
				
				willProgress = chapter4Hub.start(keyboard);
				// Save Functionality
				if(!willProgress) {
					GameData saving = new GameData(player, chapter4Hub);
					save(saving);
					try {
						System.exit(0);
					} catch (SecurityException e) {
						System.err.println("(Error when exiting)");
					}
				// Progressing with main story
				} else {
					breakLine();
					
					KingsFinalMission(player);
					breakLine();
					Dialogue.infoDialogue("Which of the king's high council would you like to speak to for advice "
							+ "about the dangerous path you are about to walk?\n"
							+ "1) (Melee) \n"
							+ "2) Elaris the Ranger (Ranger) \n"
							+ "3) Magnus the King's wizard (Mage) \n"
							+ "4) (Rogue) \n", txtSpd);
					pChoice = keyboard.next().charAt(0);
					switch (pChoice) {
					case '1':
						meleeDragonApproach(player, keyboard);
						chapterCompleted =  dragonFight.dragonFight(keyboard);
						break;
					case '2':
						rangedDragonApproach(player, keyboard);
						chapterCompleted =  dragonFight.dragonFight(keyboard);
						break;
					case '3':
						mageDragonApproach(player, keyboard);
						chapterCompleted =  dragonFight.dragonFight(keyboard);
						break;
					case '4':
						rogueDragonApproach(player, keyboard);
						chapterCompleted =  dragonFight.dragonFight(keyboard);
						break;
					default:
						System.err.println("(Invalid input. Please try again.)");
						break;
					}
					if (chapterCompleted) {
						inChapter = false;
						Dialogue.infoDialogue("As the Gilgemesh falls and releases one final, mighty roar, you know "
								+ "the battle is over. You have done it! With your skills in battle and all you learned "
								+ "from the people that helped you along the way, you have become the hero of the kingdom!"
								+ " You have done what no other in the realm could do and have freed the kingdom from the "
								+ "fear that has gripped them for decades! Congratulations " + player.getName() + "! You are "
								+ "truly a great adventurer the likes of which none have seen before. \n", txtSpd);
						while (finalChant) {
							breakLine();
							Dialogue.infoDialogue("*Release a mighty shout from the mountain top!* \n"
									+ "(enter 1)\n", txtSpd);
							pChoice = keyboard.next().charAt(0);
							switch (pChoice) {
							case '1':
								Dialogue.characterDialogue(player.getName(), "Hooooorah!", txtSpd);
								Pause.pause(15000);
								try {
									System.exit(0);
								} catch (SecurityException e) {
									System.err.println("(Error when exiting)");
								}
							}
						}
					}
					
				}
			}
		}
	}
	// --------------------Formatting Functions--------------------
	public static void breakLine() {  
	    System.out.println("------------------------------------------------------------------------------------------");
	}
	
	// --------------------General Functions--------------------
	public static void BeginningGame(Player player, Scanner keyboard) {
		
	}
	
	@SuppressWarnings("unused")
	public static Hub instantiateHub(Player player, String location) {
		// Chapter 1
		if (true) {
			Shopkeeper shopkeeperCh1 = new Shopkeeper();
			String shopNameCh1 = "";
			Shop ch1Shop = new Shop(player, shopkeeperCh1, shopNameCh1);
			
			ArrayList<Enemy> ch1Enemies = new ArrayList<Enemy>();
			String[] ch1SearchTxt = new String[0];
			
			Hub chapter1Hub = new Hub(player, location, ch1Shop, ch1Enemies, ch1SearchTxt);
			
			return chapter1Hub;
		}
		// Chapter 2
		if (true) {
			Shopkeeper shopkeeperCh2 = new Shopkeeper();
			String shopNameCh2 = "";
			Shop ch2Shop = new Shop(player, shopkeeperCh2, shopNameCh2);
			
			ArrayList<Enemy> ch2Enemies = new ArrayList<Enemy>();
			String[] ch2SearchTxt = new String[0];
			
			Hub chapter2Hub = new Hub(player, location, ch2Shop, ch2Enemies, ch2SearchTxt);
			
			return chapter2Hub;
		}
		// Chapter 3
		if (true) {
			Shopkeeper shopkeeperCh3 = new Shopkeeper();
			String shopNameCh3 = "";
			Shop ch3Shop = new Shop(player, shopkeeperCh3, shopNameCh3);
			
			ArrayList<Enemy> ch3Enemies = new ArrayList<Enemy>();
			String[] ch3SearchTxt = new String[0];
			
			Hub chapter3Hub = new Hub(player, location, ch3Shop, ch3Enemies, ch3SearchTxt);
			
			return chapter3Hub;
		}
		// Chapter 4
		if (true) {
			Shopkeeper shopkeeperCh4 = new Shopkeeper();
			String shopNameCh4 = "";
			Shop ch4Shop = new Shop(player, shopkeeperCh4, shopNameCh4);
			
			ArrayList<Enemy> ch4Enemies = new ArrayList<Enemy>();
			String[] ch4SearchTxt = new String[0];
			
			Hub chapter4Hub = new Hub(player, location, ch4Shop, ch4Enemies, ch4SearchTxt);
			
			return chapter4Hub;
		}
		return null;
	}
	
	// --------------------Dialog Functions--------------------
	public static void ApproachCastle(Player player) {
		
	}
	
	public static void KingsFinalMission(Player player) {
	}
	
	public static boolean meleeDragonApproach(Player player, Scanner scn) {

		String kingKnight = "Paris, King's Left Hand";
		Battle miniBoss = new Battle(player, eList.dWar);
		boolean win = false;
		int txtSpd = 25, wait = 1000;
		boolean pResponse;
		char input = 0;
		
		breakLine();
		
		Dialogue.infoDialogue("Once again, you find yourself in the company of Paris, having been called out by the king's "
				+ "knight in regards to another mission. This time, the condescending look on his face was gone by the time "
				+ "you arrived.\n\n"
				, txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "Well, look what the cat finally dragged in.\n\n", txtSpd);
		Pause.pause(wait + 500);
		
		Dialogue.infoDialogue("...ONLY the look wasn't present.\n\n", txtSpd + 10);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "Adicai's been singing nothing but praises for you for a while, and I have to "
				+ "admit, even I am impressed to hear that the goblin champion fell by your hands and your hands alone. You "
				+ "aren't the same wannabe hero that you were when we first met. You might actually be the perfect fit for a "
				+ "task such as this.\n\n", txtSpd);
		Pause.pause(wait);
		
		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue("1) And that task would be...?\n2) You? Praising me? What a surprise!\nReponse: "
					, 8);
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
			Dialogue.characterDialogue(kingKnight, "How hard is it to wait til I finish talking? I was getting to that.\n\n",
					txtSpd);
		} else {
			Dialogue.characterDialogue(kingKnight, "Yes, yes. As surprising as it may seem, you actually earned it.\n\n", 
					txtSpd);
		}
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "Now then, this is something that I myself along with the other key advisors "
				+ "to the king have been focusing on. This kingdom has always been in grave jeopardy at the hands of a "
				+ "powerful dragonlord. Sitting on top of the tallest mountain you can see from the castle gates is where its"
				+ " nest is positioned. Naturally, you would think that we would have dealt with this by now what with all "
				+ "the information we have. However, there's a slight issue.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "It's... impossible for even us to reach that peak. Although most of the lesser"
				+ " dragons around the mountaintop have been dealt with, a handful remain. Furthermore, too many men have died"
				+ " making the climb up the mountain. We've had no luck finding a better path. A warrior such as yourself was"
				+ " capable of besting an entire army by yourself, so this may be doable for you.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "I need you to scout around the mountain without going past the midpoint. If "
				+ "you can find a passageway up to the peak where the dragonlord resides, then I swear that a hefty reward "
				+ "will be waiting for you the moment you find it and we confirm that you've done so.\n\n", txtSpd);
		Pause.pause(wait);
		
		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue("1) ...What would the reward be if I were to defeat the dragonlord while I'm there?\n"
					+ "Reponse: "
					, 8);
			input = scn.next().charAt(0);

			switch (input) {
			case '1':
				pResponse = false;
				System.out.println();
				break;
			default:
				System.err.println("Invalid choice. Try again.\n");
				Pause.pause(350);
				break;
			}
		}
		
		Dialogue.characterDialogue(kingKnight, "What?! Have you gone mad?! To take on the dragonlord single-handedly, that's "
				+ "a fool's task! It's impossible! Suicide! You'd never survive!\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "The king's elite will lead a force strong enough to handle the dragonlord. We "
				+ "don't need you to attempt to play hero by yourself.\n\n", txtSpd);
		Pause.pause(wait);
		
		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue("1) But that would lead to lots of casualties\n2) I don't care if you think I can handle it."
					+ "\nReponse: "
					, 8);
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
			Dialogue.characterDialogue(kingKnight, "Well, yes... that is true, I...\n\n", txtSpd);
		} else {
			Dialogue.characterDialogue(kingKnight, "Are you that desperate to prove something here...?\n\n", txtSpd);
		}
		Pause.pause(wait);
		
		Dialogue.infoDialogue("Paris let out a loud sigh.\n\n", txtSpd);
		Pause.pause(wait * 2);
		
		Dialogue.characterDialogue(kingKnight, "Hypothetically speaking... We're you capable of defeating a dragonlord without"
				+ " any form of aid, we would allow you to name your price in terms of payment. I can't think of any other way"
				+ " that it'd be fair for your efforts. Hoever, this is merely a hypothetical situation. Only a fool would go "
				+ "out there and attempt to play hero over it.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "Regardless, I've given you your ACTUAL mission already. Head to the mountain "
				+ "and find a path for our army to march up to the dragonlord. You will be paid handsomely upon your return."
				+ "\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.infoDialogue("Despite Paris' warning, your mind was already made up. You had every intention of putting your "
				+ "strength to the test against this dragonlord. Of course, you still had to find your own way up. With your "
				+ "weapons ready to go, you set off towards the mountains, ready to climb towards your destination.\n\n"
				+ "", txtSpd);
		Pause.pause(wait);
		
		Pause.pause();
		
		breakLine();

		Dialogue.infoDialogue(
				"By this point, the kingdom looks like a simple town with how far you've come. Per the king's request, you "
						+ "ascended into the mountaintops to reach the dragonlord's lair. You've not even come close "
						+ "to entering, and "
						+ "the sounds of it, and the nearby dragons fill your eardrums and mind with dread.\n\n",
				txtSpd);
		Pause.pause(wait);

		txtSpd += 15;
		Dialogue.infoDialogue("Their ferocious roars. ", txtSpd);
		Pause.pause(wait);
		Dialogue.infoDialogue("The flapping of wings. ", txtSpd);
		Pause.pause(wait);
		Dialogue.infoDialogue("The smell of smoke. ", txtSpd);
		Pause.pause(wait);
		Dialogue.infoDialogue("The field of bones around you. ", txtSpd);
		Pause.pause(wait);
		Dialogue.infoDialogue("The weapons of those who previously challenged it.\n", txtSpd);
		Pause.pause(wait);
		Dialogue.infoDialogue("All these things fill you with both fear, and determination.\n\n", txtSpd);
		Pause.pause(wait);
		txtSpd -= 15;

		Dialogue.infoDialogue(
				"With your goal in mind, you push on ahead further up the mountain. By this point, it appears that the sides "
						+ "are becoming too steep for you to continue climbing, and you'd likely fall to your death "
						+ "before ever seeing the dragonlord. Having a look around, you can see a flat area of the mountain, "
						+ "with a weak spot in the side.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"Climbing up and walking to that spot, you peered through the cracks to see that the inside was hollowed, as "
						+ "if a path had been carved inside of the mountain that would lead you up safely. "
						+ "Taking out the great Phoenix "
						+ "Cleaver received from Adicai, you strike the cracked wall with all your might, "
						+ "shattering it and giving you a clearer view of the carved path ahead.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"You stepped into the hollowed mountain and swing the greataxe in order to cause the blade to light ablaze, "
						+ "giving you a light so that you can see ahead. It appeared that you had stepped foot into a large "
						+ "cavern with an empty nest in the center, and a broken spiral staircase carved out into the walls "
						+ "leading both up and down. Though the stairs were burned and broken, they were stable and long "
						+ "enough that you'd have the might to make it to the top.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"However, you were taken back by a loud roar as a humanoid creature descended from above, landing on the "
						+ "ground hard as a crate formed beneath its scaly feet. Before you was a draconic being that was "
						+ "only slightly taller than you, standing upright and wielding a long glaive. You could feel "
						+ "its murderous intent from miles away, even if it hadn't said a word. The dragonoid growled "
						+ "as it ready its weapon, challenging you to a fight.\n\n",
				txtSpd);
		Pause.pause(wait);

		breakLine();
		win = miniBoss.startBattle(scn);
		breakLine();

		if (win) {

			Dialogue.infoDialogue(
					"The dragonoid warrior collapsed dead at your feet as you look around, trying to see if it came alone "
							+ "or had friends lying in wait. Not seeing or hearing another living soul in the cavern, "
							+ "you begin making your way up the spiral staircase.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.infoDialogue("The further you head up, you begin to see an opening at the top, and the "
					+ "sight of a dragon flying around high in the sky. You make your way closer and closer"
					+ " to the top, conserving your stamina for the fight\nto come.\n\n", txtSpd);
			Pause.pause(wait);

			Dialogue.infoDialogue("Finally... you reach the top.\n\n", txtSpd);
			Pause.pause(wait);

			Dialogue.infoDialogue("You mentally prepare yourself as the dragon above... the dragonlord... "
					+ "sees you and descends...", txtSpd);
			Pause.pause(wait);

		}

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
		// king sends you on mission
		// travel
		
		
		// fight troll
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

		breakLine();

		Dialogue.infoDialogue(
				"As you arrive in the city, you decide that your first course of action should be to visit someplace "
						+ "where you can acquire a proper armament. Strolling around for a bit, you stumble upon an armory "
						+ "that would suit your needs.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"Looking around, you could see that the place was... old. The shop wasn't in the best of shape. It's "
						+ "likely been around for a long time. The walls and floors were filled with cracks. Even though the "
						+ "interior seemed to be a mess, the weapons racks were in great condition, and all of the weapons "
						+ "were in great condition, a noteworthy contrast to the armory itself.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName, "What? First time seeing a run down shop?\n\n", txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"In the corner next to a furnace, there was an older gentlemen with gray, spiky hair and beard seated, "
						+ "pounding the dents out of a blade that had just been forged in the fire. He looked over, getting a"
						+ " good look at you.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"Oh? For a minute, I thought you were one of the usual land hawks. Oh well, not that any of that matters "
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
					"When you've been around as long as I have, you meet a lot of people. There's not a single person in this "
							+ "city I haven't seen before, except the tourist in front of me.\n\n",
					txtSpd);
		} else {
			Dialogue.characterDialogue(charName,
					"If you're going to lie to an old man, try to make it sound convincing. I've been around for a long time. "
							+ "I'd recognize a tourist anywhere.\n\n",
					txtSpd);
		}
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"But that doesn't really matter. If you're a paying customer, then welcome.\n\n", txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"As the blade cooled down, the blacksmith finished what he was working on and walked over to you. As he got "
						+ "a good look at you, his eyes seemed to light up with interest.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"Hmm? Those eyes... That's the look of a warrior-to-be. So, you're someone with the heart of the fighter... "
						+ "Been a while since I've met a rookie adventurer. I remember when I was in your shoes a few decades "
						+ "ago.\n\n",
				txtSpd);
		Pause.pause(wait);

		charName = "Jagatai, Retired Warrior";

		Dialogue.characterDialogue(charName,
				"My name's Jagati. I used to be a warrior when I was younger, but my adventuring days are long behind me. "
						+ "If you're looking for a good place to get started with making a name for yourself, you've come"
						+ " to the right place. Though, since your a greenhorn, "
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
							+ "got a variety of weapons to attack with, some of them imbued with their own special attacks."
							+ "\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"Special attacks are techniques that are imbued into a weapon during their forging, allowing "
							+ "their wielder to demonstrate lethal damage by calling them forth. But, there's a catch."
							+ "\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"Not just anybody can call them out at will. You've gotta be real lucky if you want to use "
							+ "a special attack successfully. Bit of a \"high risk, high reward\" scenario, yeah?\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"That aside, I'm sure you don't need to be told to focus on defense.\n\n", txtSpd);

		}
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"You've got the basics in your head, but the only way to really remember them is to put them into practice. "
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
				"Don't get too excited over a free gift. It's just a simple blade. Nobody's imbued a special attack in "
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
					"Mana's what mages use in their wands and weapons. It's an energy within a person's body that's expelled "
							+ "to attack or defend. I don't know too much about it, magic ain't my thing.\n\n",
					txtSpd);
		}
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"As you take a moment to observe the blade that you had been given, Jagatai picks up a black longsword "
						+ "before patting you on the shoulder, walking towards the door at the back of the armory.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"Well, there's no point in sitting there staring at that all day. Come on. I've got an old training spot "
						+ "out back. Let's see if all of that knowledge is gonna pay off when you're in combat.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"Sensing that a fight was coming, you steel your nerves before following the blacksmith, arriving in a "
						+ "fenced in area outside. Jagatai walks a good distance away from you before turning around, "
						+ "holding the\nsword in a middle guard stance.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"Better not expect any weak swings just cause you're new and I'm old. A couple of swings should help you "
						+ "get the feel of things, so try not to get banged up too much. Now bring it!\n\n",
				txtSpd);
		Pause.pause(wait);

		breakLine();

		win = meleeTutorial.startBattle(scn);

		if (win) {

			Dialogue.infoDialogue(
					"(As you battle enemies during your adventure, you will earn EXP after defeating them, the amount varying "
							+ "from enemy to enemy. Once you gain enough EXP, you will level up. Your stats will increase, "
							+ "and you will receive a skill point to spend on one of the class stats, or your luck stat. You "
							+ "can view your overall level, the level of each stat, how much EXP you need to level up again, "
							+ "and how many skill points you have available to spend all from your profile "
							+ "after the tutorial.)\n\n",
					txtSpd);
			Pause.pause(wait);
			Pause.pause();

			System.out.println(
					"---------------------------------------------------------------------------------------------------");

			Dialogue.infoDialogue(
					"The sparring session lasted barely over a minute before Jagatai found himself satisfied with you, "
							+ "putting away his weapon before nodding his head in approval.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"Looks like you've got a natural talent for combat too. I might not be in my prime anymore, but I "
							+ "can still see you growing into the kind of warrior that could give me a run for my money.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(charName,
					"You'll do just fine out there as you learn and grow. Pretty soon, I'll be expecting to hear tales "
							+ "of your accomplishments. So, what's the name that I should be looking "
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
							+ "you exit the armory with your morale high, ready to embark on your new adventure.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.infoDialogue("This marks the beginning of the tale of " + player.getName() + "...", txtSpd + 20);
			Pause.pause(wait);

			System.out.println("\n");
			Pause.pause();

		}

		return true;
	}
	
	public static boolean rangerChapter1(Player player, Scanner keyboard) {
	    boolean makingChoice = true;
	    char pChoice;
	    Battle tutorialBattle = new Battle(player, eList.sheep);
	    boolean playerWon = false;
	    int txtSpd = 25, wait = 1000; 

	    breakLine();
	    Dialogue.infoDialogue(
	            "You step into a sunlit clearing surrounded by towering trees with golden leaves swaying gently in the breeze. "
	                    + "A narrow path winds through the grass, leading to a wooden archery range. The air is fresh and filled with the soft "
	                    + "chirping of birds. At the center stands a tall, graceful elf with sharp features and emerald-green eyes. She has a "
	                    + "quiver slung across her back and a bow in hand, her stance both relaxed and ready.\n",
	            txtSpd);
	    Pause.pause(wait);
	    Dialogue.characterDialogue("Elaris the Ranger", "Welcome, traveler. I’ve heard whispers of a newcomer—your name is " + player.getName() + ", yes?", txtSpd);
	    Pause.pause(wait);
	    Dialogue.characterDialogue("Elaris the Ranger", "My name is Elaris, and I guide those who seek to master the bow. Shall we begin your training?", txtSpd);

	    while (makingChoice) {
	        Dialogue.characterDialogue("Elaris the Ranger", "What do you say?\n"
	                + "1) Yes, I’m ready!\n"
	                + "2) Hmm, I’m not sure if I want to be an archer.", txtSpd);
	        pChoice = keyboard.next().charAt(0);

	        switch (pChoice) {
	            case '1':
	                breakLine();
	                Dialogue.characterDialogue(player.getName(), "Yes, I’m ready!", txtSpd);
	                Pause.pause(wait);
	                Dialogue.characterDialogue("Elaris the Ranger", "Wonderful. The bow may seem simple, but wield it well, and it becomes the deadliest of weapons.", txtSpd);
	                makingChoice = false;
	                break;

	            case '2':
	                breakLine();
	                Dialogue.characterDialogue(player.getName(), "Hmm, I’m not sure if I want to be an archer.", txtSpd);
	                Pause.pause(wait);
	                Dialogue.characterDialogue("Elaris the Ranger", "No pressure. The woods are patient, and I’ll be here if you change your mind.", txtSpd);
	                return false;

	            default:
	                breakLine();
	                Dialogue.infoDialogue("(Invalid choice. Please try again)\n", txtSpd);
	        }
	    }

	    Dialogue.characterDialogue("Elaris the Ranger", "First, you’ll need a bow. This shortbow has served many a beginner well. Take it, and we’ll get started.", txtSpd);
	    player.getInventory().add(wList.bow1);
	    Pause.pause(wait);
	    Dialogue.infoDialogue("The starter bow has been added to your inventory!\n", txtSpd);
	    player.getInventory().getWeaponOnKey(wList.bow1.getKey()).displayInfo();

	    makingChoice = true;

	    while (makingChoice) {
	        breakLine();
	        Dialogue.characterDialogue("Elaris the Ranger", "Let’s talk about ammunition. Regular arrows are infinite, so you’ll never run out of basic shots. "
	                + "However, special arrows—fire and ice—are rare and must be looted from enemies or chests. "
	                + "Use them wisely when the situation demands.\n"
	                + "Here are your current special arrows:\n" 
	                + "Special arrows: " + player.getInventory().getSpecialArrows(), txtSpd);
	        Pause.pause(wait);
	        Dialogue.characterDialogue("Elaris the Ranger", "1) Got it! Let’s move on.\n"
	                + "2) Can you explain that again?", txtSpd);
	        pChoice = keyboard.next().charAt(0);

	        switch (pChoice) {
	            case '1':
	                breakLine();
	                Dialogue.characterDialogue(player.getName(), "Got it! Let’s move on.", txtSpd);
	                Pause.pause(wait);
	                makingChoice = false;
	                break;

	            case '2':
	                breakLine();
	                Dialogue.characterDialogue(player.getName(), "Can you explain that again?", txtSpd);
	                Pause.pause(wait);
	                break;

	            default:
	                Dialogue.infoDialogue("(Invalid choice. Please try again)\n", txtSpd);
	                break;
	        }
	    }

	    Dialogue.characterDialogue("Elaris the Ranger", "Time to test your aim. Let’s see how you handle a live target. Don’t worry—"
	            + "this sheep is harmless, and we use it to train all newcomers. Draw your bow, aim for the mark, and let your arrow fly!", txtSpd);

	    while (!playerWon) {
	        playerWon = tutorialBattle.startBattle(keyboard, true);
	        if (!playerWon) {
	            player.setCurrHP(player.getHealth());
	            tutorialBattle.getEnemy().setCurrHP(tutorialBattle.getEnemy().getHealth());
	            tutorialBattle.setTurn(0);
	            Dialogue.characterDialogue("Elaris the Ranger", "You’re getting there! Precision comes with practice. Try again.", txtSpd);
	        }
	    }

	    breakLine();
	    Dialogue.characterDialogue("Elaris the Ranger", "Well done! You’re already showing promise. That’s all I can teach for now, but the true lessons "
	            + "lie ahead. Head to the castle—the King often seeks skilled adventurers, and the journey will test your abilities.", txtSpd);
	    Pause.pause(wait);
	    Dialogue.characterDialogue("Elaris the Ranger", "And remember, I’m always here should you need guidance. The woods never turn their back on a friend.", txtSpd);

	    Dialogue.infoDialogue(
	            "(As you battle enemies during your adventure, you will earn EXP after defeating them, the amount varying\n"
	                    + "from enemy to enemy. Once you gain enough EXP, you will level up. Your stats will increase, "
	                    + "and you will\nreceive a skill point to spend on one of the class stats, or your luck stat. You "
	                    + "can view your overall\nlevel, the level of each stat, how much EXP you need to level up again, "
	                    + "and how many skill points you\nhave available to spend all from your profile after the tutorial.)\n\n",
	            txtSpd);

	    makingChoice = true;

	    while (makingChoice) {
	        breakLine();
	        Dialogue.characterDialogue("Elaris the Ranger", "1) Thanks, Elaris! I’ll head to the castle.\n"
	                + "2) I’ll be sure to visit again!", txtSpd);
	        pChoice = keyboard.next().charAt(0);

	        switch (pChoice) {
	            case '1':
	                breakLine();
	                Dialogue.characterDialogue(player.getName(), "Thanks, Elaris! I’ll head to the castle.", txtSpd);
	                Pause.pause(wait);
	                makingChoice = false;
	                break;

	            case '2':
	                breakLine();
	                Dialogue.characterDialogue(player.getName(), "I’ll be sure to visit again!", txtSpd);
	                Pause.pause(wait);
	                makingChoice = false;
	                break;

	            default:
	                Dialogue.infoDialogue("(Invalid choice. Please try again)\n", txtSpd);
	                break;
	        }
	    }

	    return true;
	}


	
	public static boolean mageChapter1(Player player, Scanner keyboard) {
		boolean makingChoice = true;
		char pChoice;
		int txtSpd = 25;
		Battle tutorialBattle = new Battle(player, eList.sheep);
		boolean playerWon = false;
		String pName = player.getName();
		String wizName = "Herald the Wizard";
		
		
		breakLine();
		Dialogue.characterDialogue(wizName, "Hello " + player.getName() + "! I heard we had a newcomer in town! "
				+ "Interested in learning how to use magic to defend yourself from the various different monsters,"
				+ "enemies, and mythical beasts you can find around here? Well you've come to the right place! Although "
				+ "I am no expert, I can definitely help get you started!\n", txtSpd);
		
		while (makingChoice) {
			Dialogue.characterDialogue(wizName, "Does that sound like something you might be interested in? \n"
					+ "1) Absolutely!\n"
					+ "2) I'm not sure if I'm interested in magic.\n", txtSpd);
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.characterDialogue(pName, "Absolutely!\n", txtSpd);
					Dialogue.characterDialogue(wizName, "Great to hear! It's always nice to have another mage in town!\n", txtSpd);
					makingChoice = false;
					break;
					
				case '2':
					breakLine();
					Dialogue.characterDialogue(pName, "I'm not sure if I'm interested in magic.\n", txtSpd);
					Dialogue.characterDialogue(wizName, "That's alright! I'll be here if you change your mind!\n", txtSpd);
					return false;
					
				default:
					breakLine();
					System.err.println("(Invalid choice. Please try again)");
				}
			
		}
		
		Dialogue.characterDialogue(wizName,"First of all we need to get you started with a weapon that can "
				+ "channel magic energy. I believe I have an old wand around here somewhere ... Ah here it is! "
				+ "This was my first wand and its great for training. You can definitely find better weapons "
				+ "around town though! I have heard rumors of some pretty strong magic weapons but those are "
				+ "pretty dangerous to get. But no need to worry about those right now! First you need to get the "
				+ "basics down. Here, take this wand.\n", txtSpd);
		player.getInventory().add(wList.starterWand);
		Dialogue.infoDialogue("The starter wand has been added to your inventory!\n", txtSpd);
		player.getInventory().getWeaponOnKey(wList.starterWand.getKey()).displayInfo();
		
		makingChoice = true;
		
		while (makingChoice) {			
			breakLine();
			Dialogue.characterDialogue(wizName, "Now that you have a weapon, I should probably explain mana. Mana is the power inside "
					+ "each person that can be channeled through the use of magic weapons. Magic weapons use a portion "
					+ "of your built up mana to launch an attack! Be careful though because you can run out and your "
					+ "weapon will no longer work. Through tough battles you can increase the effectiveness of your magic "
					+ "and the amount of mana you can store.\n", txtSpd);
			Dialogue.infoDialogue("Your current mana storage is: " + player.getMana() + "\n", txtSpd);
			breakLine();
			Dialogue.infoDialogue("1) Okay I think I got it!\n"
					+ "2) Explain that again?\n", txtSpd);
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				
				case '1':
					breakLine();
					Dialogue.characterDialogue(pName, "Okay I think I got it!\n", txtSpd);
					makingChoice = false;
					break;
				
				case '2':
					breakLine();
					Dialogue.characterDialogue(pName, "Explain that again?\n", txtSpd);
					break;
				
				default:
					System.err.println("(Invalid choice. Please try again)");
					break;
				}
			
		}
		
		Dialogue.characterDialogue(wizName, "Great! Now that you understand the basics, why don't you test your "
				+ "skills on this sheep! Don't worry sheep around here aren't known for their fighting abilities.\n"
				, txtSpd);
		
		while (!playerWon) {
			playerWon = tutorialBattle.startBattle(keyboard, true);
			if (!playerWon) {
				Dialogue.characterDialogue(wizName, "Thats okay you'll get the hang of it. take another shot at "
						+ "it!\n", txtSpd);
			}
		}
		
		breakLine();
		Dialogue.characterDialogue(wizName, "Nice! It seems like you got the hang of it! That's about all I can "
				+ "teach you. I'm not much of the adventurous type so I really only know the basics. It comes in handy "
				+ "though for work around town. Since you're new around here, you should probably go check out the castle. "
				+ "Just about everything important happens around there. The King also might be interested in testing "
				+ "your skills too if you're up for the challenge. If you can get in his good graces, you might get a "
				+ "chance to talk to the King's wizard. He's probably the most knowledgable person you can find around "
				+ "here when it comes to magic! If you make it big, don't forget who taught you the basics though haha! "
				+ "And pay me a visit if you get the chance!\n", txtSpd);
	
		makingChoice = true;
		
		while (makingChoice) {
			
			breakLine();
			Dialogue.infoDialogue("1) Will do! Thanks for the advice!\n"
					+ "2) I'll definitely have to check out the castle!\n", txtSpd);
				pChoice = keyboard.next().charAt(0);
				
				switch(pChoice) {
				
				case '1':
					breakLine();
					Dialogue.characterDialogue(pName, "Will do! Thanks for the advice!\n", txtSpd);
					makingChoice = false;
					break;
				
				case '2':
					breakLine();
					Dialogue.characterDialogue(pName, "I'll definitely have to check out the castle!\n", txtSpd);
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
	
	public static boolean mageSpecialMission(Player player, Scanner keyboard) {
		int txtSpd = 25; 
		char pChoice;
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
			
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.characterDialogue(pName, "Yes I believe he did.\n",txtSpd);
					makingChoice = false;
					break;
				
				case '2':
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
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.characterDialogue(pName, "That sounds interesting. What should I expect if I were to go?\n",
							txtSpd);
					makingChoice = false;
					break;
				
				case '2':
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
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.characterDialogue(pName, "That sound’s like a very dangerous mission. What’s in it for me? "
							+ "You mentioned a powerful magic weapon?\n",txtSpd);
					makingChoice = false;
					break;
				
				case '2':
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
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.characterDialogue(pName, "I think I’ll give it a shot! How do I get to the cave?\n",txtSpd);
					makingChoice = false;
					break;
				
				case '2':
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
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.characterDialogue(pName, "Thank you! I will be on my way now!\n",txtSpd);
					Dialogue.characterDialogue(wizName, "Of course! I hope to see you again soon!\n",txtSpd);
					makingChoice = false;
					break;
				
				case '2':
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
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					makingChoice = false;
					break;
				
				case '2':
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
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.infoDialogue("*You raise your weapon, prepared for a tough battle*\n", txtSpd);
					makingChoice = false;
					break;
				
				case '2':
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
		
		Battle FireElemental = new Battle(player, eList.fireElemental);
		
		if (!FireElemental.startBattle(keyboard, true)) {
			return false;
		}
		
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
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					/*
					 * Loot functionality
					 */
					makingChoice = false;
					break;
				
				case '2':
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
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.infoDialogue("*Poised with your weapon ready for battle, you face the fire elemental showing no fear*\n", txtSpd);
					makingChoice = false;
					break;
				
				case '2':
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
		
		if (!FireElemental.startBattle(keyboard, true)) {
			return false;
		}
		
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
				pChoice = keyboard.next().charAt(0);
				
				switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.infoDialogue("*Confident in your abilities, you appear from behind the boulder with "
							+ "your weapon drawn, ready to take down the menacing golem that stands in your path!*\n", 
							txtSpd);
					makingChoice = false;
					break;
				
				case '2':
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
		
		Battle fireElementalRockGolem = new Battle(player, eList.fireRockGolem);
		
		if(!fireElementalRockGolem.startBattle(keyboard, true)) {
			return false;
		}
		
		Dialogue.infoDialogue("*As the beast falls, the ground shakes as it hits the ground. On the other "
				+ "side of the opening, you see a door. That is no doubt the entrance to the Fire wizard’s "
				+ "home. You enter to see, propped up on a stand, the fire staff glowing with flame energy. "
				+ "You pick up the staff and feel the magical power coursing through the staff. On a shelf above "
				+ "the wizard’s alchemy table, you find the Fire Stone that Magnus asked you to retrieve. You "
				+ "grab both and notice a chest by the wizard’s bed.*\n", 
				txtSpd);
		player.getInventory().add(wList.fireStaff);
		System.out.println("The Fire Staff has been added to your Inventory!");
		System.out.println("The Fire Stone has been added to your Inventory!");
		
		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("What do you do?\\n\n"
					+ "1) Loot the chest\\n\n"
					+ "2) Leave\n", txtSpd);
			pChoice = keyboard.next().charAt(0);
			
			switch (pChoice) {
			case '1':
				breakLine();
				/*
				 * Loot functionality
				 */
				makingChoice = false;
				break;
			
			case '2':
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
			pChoice = keyboard.next().charAt(0);
			
			switch (pChoice) {
			case '1':
				breakLine();
				Dialogue.characterDialogue(pName, "Will do thank you!\n", txtSpd);
				makingChoice = false;
				break;
			
			case '2':
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
	    int txtSpd = 25;
	    char pChoice;
	    boolean makingChoice = true;
	    String pName = player.getName();
	    String rangerName = "Elaris the Ranger";

	    breakLine();
	    Dialogue.characterDialogue(rangerName, "Ah, " + pName + "! I’ve been meaning to speak with you. Your skill with a bow is unmatched in these parts, and there’s a dire situation that needs addressing.", txtSpd);

	    while (makingChoice) {
	        Dialogue.characterDialogue(rangerName, "The Shadow Stalker pack has taken over an ancient territory nearby, and their alpha, Nightfang, is growing stronger by the day. We need you to stop him before the pack becomes unstoppable.\n"
	                + "Are you willing to take on this mission?\n"
	                + "1) Yes, I’ll take on the challenge.\n"
	                + "2) I’m not sure. This sounds dangerous.\n", txtSpd);
	        pChoice = keyboard.next().charAt(0);

	        switch (pChoice) {
	        case '1':
	            breakLine();
	            Dialogue.characterDialogue(pName, "Yes, I’ll take on the challenge.\n", txtSpd);
	            makingChoice = false;
	            break;

	        case '2':
	            breakLine();
	            Dialogue.characterDialogue(pName, "I’m not sure. This sounds dangerous.\n", txtSpd);
	            Dialogue.characterDialogue(rangerName, "It is dangerous, but you’re the only one capable of stopping Nightfang. Let me know if you change your mind.\n", txtSpd);
	            return false;

	        default:
	            breakLine();
	            System.err.println("(Invalid choice. Please try again)");
	            break;
	        }
	    }

	    Dialogue.characterDialogue(rangerName, "Nightfang’s territory lies in the Heartshadow Woods. It’s a twisted place of darkness, but you’ll have an important choice to make when you arrive. "
	            + "Nightfang prowls between two locations, and you’ll need to decide where to confront him.", txtSpd);

	    Dialogue.infoDialogue("*You gather your gear and head out, the forest growing darker as you approach the Heartshadow Woods. The air is thick with mist, and the faint glow of fireflies provides the only light. "
	            + "After some time, you reach the edge of the woods where a fork in the path offers two distinct routes.*\n", txtSpd);

	    makingChoice = true;
	    while (makingChoice) {
	        Dialogue.infoDialogue("*Which path will you take?*\n"
	                + "1) *The Ancient Clearing: An open field where moonlight breaks through the canopy, casting eerie shadows.*\n"
	                + "2) *The Cursed Hollow: A narrow gorge filled with jagged rocks and an oppressive darkness.*\n", txtSpd);
	        pChoice = keyboard.next().charAt(0);

	        switch (pChoice) {
	        case '1':
	            breakLine();
	            Dialogue.infoDialogue("*You choose the path to the Ancient Clearing, where the forest opens into a large field. Moonlight filters down through the twisted branches, illuminating the clearing in a pale silver glow. "
	                    + "The ground is covered in moss and glowing mushrooms, and the air hums with an unnatural silence. You step into the clearing cautiously, sensing movement among the shadows.*\n", txtSpd);
	            makingChoice = false;
	            break;

	        case '2':
	            breakLine();
	            Dialogue.infoDialogue("*You choose the path to the Cursed Hollow, where the forest closes in tightly around you. The narrow gorge is suffocating, with jagged rocks jutting out like broken teeth. "
	                    + "A faint red glow pulses from deep within, and the sound of dripping water echoes eerily. The oppressive air weighs heavily on your chest as you venture deeper, your every step crunching against loose stone.*\n", txtSpd);
	            makingChoice = false;
	            break;

	        default:
	            breakLine();
	            System.err.println("(Invalid choice. Please try again)");
	            break;
	        }
	    }

	    Dialogue.infoDialogue("*You hear a guttural growl nearby, and your heart races as you realize Nightfang is near. The alpha Shadow Stalker emerges from the darkness, its glowing red eyes locked onto you. "
	            + "The creature stands taller than any of its kin, its fur bristling with shadowy tendrils that shift and writhe as if alive. Its razor-sharp claws glint in the dim light.*\n", txtSpd);

	    makingChoice = true;
	    while (makingChoice) {
	        Dialogue.infoDialogue("*What do you do?*\n"
	                + "1) *Raise your bow and prepare for battle.*\n"
	                + "2) *Try to find a better position for the fight.*\n", txtSpd);
	        pChoice = keyboard.next().charAt(0);

	        switch (pChoice) {
	        case '1':
	            breakLine();
	            Dialogue.infoDialogue("*You nock an arrow and face Nightfang head-on, your heart pounding as you prepare for a fierce battle.*\n", txtSpd);
	            makingChoice = false;
	            break;

	        case '2':
	            breakLine();
	            Dialogue.infoDialogue("*You dart behind a nearby boulder, using the terrain to gain a tactical advantage. Nightfang circles, its glowing eyes tracking your every move.*\n", txtSpd);
	            makingChoice = false;
	            break;

	        default:
	            breakLine();
	            System.err.println("(Invalid choice. Please try again)");
	            break;
	        }
	    }

	    /*
	     * Nightfang Boss Fight
	     * 
	     * lose:
	     * return false;
	     * 
	     * win:
	     */

	    Dialogue.infoDialogue("*As the battle concludes, Nightfang collapses with a final, ear-splitting howl. The oppressive atmosphere of the woods begins to lift, and the shadows that clung to the trees slowly recede. "
	            + "The forest is quiet once more, save for the rustling of leaves in a gentle breeze. You take a moment to catch your breath, the adrenaline of the fight still coursing through your veins.*\n", txtSpd);

	    Dialogue.infoDialogue("*You begin your journey back to Elaris, the weight of your victory etched in every step you take.*\n", txtSpd);

	    Dialogue.characterDialogue(rangerName, "You’ve returned! And from the look of you, I’d say the mission was a success. The woods will remember your courage, and so will I. Thank you, " + pName + ". You’ve done more than you know.\n", txtSpd);

	    return true;
	}

	
	public static boolean meleeSpecialMission(Player player, Scanner scn) {

		int txtSpd = 25, wait = 1000, battleCount = 1;
		boolean pResponse;
		char input = ' ';
		boolean win = false;
		String kingKnight = "Paris, King's Left Hand";
		String ally1Name = "Jagatai, Retired Warrior", ally2Name = "Knight Adicai";
		String boss1Name = "Kioq, Goblin Champion";
		breakLine();

		Enemy e1 = eList.goblin1, e2 = eList.goblin2, eBoss = eList.goblinBoss;
		e1.getInventory();

		Battle battle1 = new Battle(player, e1), battle2 = new Battle(player, e2),
				bossBattle = new Battle(player, eBoss);
		
		Dialogue.infoDialogue("You approach the king's chamber after receiving a summons concerning a new task for"
				+ " you. However, you were quickly stopped as the chamber doors opened, and stepping out was one of the king's"
				+ " loyal commanders, looking at you with a condescending expression.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "You've been quite busy I see. Trying to rack up a good reputation with the "
				+ "royal court now by pleasing the king, are we? Quite ambitious for a rookie. But that's enough discussion. "
				+ "I'm the one that sent that summons. I have a task for somebody that's unable to keep still. Someone like"
				+ " you.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.infoDialogue("Though his attitude got annoying to you quickly, you knew that it'd be in your best interest "
				+ "to listen to Paris' request.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "Color me surprised to hear that a large band of goblins- yes those creatures-"
				+ " have begun to organize themselves into a unit that threatens the safety of this kingdom. While it would "
				+ "be extremely easy for me to deploy a platoon to deal with them and be on my way, I'd rather not waste "
				+ "many of my own soldiers like this.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "So! What better way to solve the issue than to delegate it the new hotshot "
				+ "adventurer that's the talk of the town? I want you to deal with the kingdom's goblin problem. I don't "
				+ "intend to take no for an answer, so don't bother.\n\n", txtSpd);
		Pause.pause(wait);
		
		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue("1) I wasn't going to say no, so I'll be going now.\n2) Are you finished yet?\nReponse: "
					, 8);
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
			Dialogue.characterDialogue(kingKnight, "I do love how we're on the same page, but I would love it even more if you"
					+ " didn't interrupt me. I wasn't finished talking.\n\n", txtSpd);
		} else {
			Dialogue.characterDialogue(kingKnight, "I'd be finished a lot sooner if you wouldn't interrupt me. Now, as I was "
					+ "about to say...\n\n", txtSpd);
		}
		Pause.pause(wait);
		
		Dialogue.infoDialogue("You begin to consider how bad walking away now would hurt your reputation, thinking just long "
				+ "enough for Paris to say something interesting.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "General Adicai is insistent on heading out personally to defeat these goblins "
				+ "alongside you. There's something about the appearance of a goblin champion that's made him restless, so "
				+ "get along well with him.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "I suggest that you keep in mind that Adicai is far more important to this "
				+ "kingdom that you'll ever be. Your most important duty will be to ensure that he returns safe and sound.\n\n"
				, txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(ally2Name, "I am more than capable of taking care of myself, sir Paris.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.infoDialogue("Suddenly the general in question, Adicai, appraoches both you and Paris, having overheard the "
				+ "conversation. After his initial statement, he turned to you as his tone softened.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(ally2Name, "You must be the new adventurer I've heard about. My name is Adicai. You needn't"
				+ " worry about me on the battlefield. Our main goal will be to ensure that as many goblins are wiped out as "
				+ "possible, and defeating the ringleader behind their organization. You can use whatever you see fit for "
				+ "this operation. I'll be waiting for you to prepare.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.characterDialogue(kingKnight, "...Regardless of Adicai's concerns, keep in mind what I said. That is all."
				+ " I'll leave you two to take care of this.\n\n", txtSpd);
		Pause.pause(wait);
		
		Dialogue.infoDialogue("Paris headed back for the king's chamber. Adicai saluted you before he left. All that was left"
				+ " to do was prepare yourself for the battle with the goblins... and you had an idea on how to do so.\n\n"
				, txtSpd);
		Pause.pause(wait);
		
		Pause.pause();
		
		breakLine();

		Dialogue.infoDialogue(
				"Under the orders of the king's knight, you have been given the task of defeating the goblin army that has "
				+ "been threatening the safety of this kingdom, working alongside of the king's generals, Adicai. "
						+ "In order to have as many allies as possible, you pay a visit to the blacksmith Jagatai, "
						+ "in hopes of marching with a team of three.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally1Name,
				"So you trust an old man enough to ask for his help against a horde of goblins, eh? I'm flattered. I "
						+ "could use a little exercise.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally1Name,
				"Make sure you're ready for this. I'm ready to go at any time. But once we're out there, don't expect "
						+ "to turn back until we've wiped them out. Are you ready for this?\n\n",
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
			Dialogue.characterDialogue(ally1Name, "Just like I expected from you. Let's move.\n\n", txtSpd);
		} else {
			Dialogue.characterDialogue(ally1Name, "Then don't keep us waiting for long.\n\n", txtSpd);
			return false;
		}
		Pause.pause(wait);

		breakLine();

		Dialogue.infoDialogue("It was not long before your party set out to march on the goblin horde. "
				+ "Leaving the safety of the kingdom and stepping out of the walls, you would soon find "
				+ "that it would not take long to arrive at your destination... or rather, your destination had moved "
				+ "closer. Much closer. Only a few miles outside the "
				+ "kingdom, the goblin horde had managed to set up their camp for a closer attack.\n\n", txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally2Name,
				"These foul beasts have the gall to set up an encampment on the outskirts of our borders? Hmph. Kioq is an "
						+ "issue that I should have dealt with long ago.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally1Name,
				"Looks like the goblins have gotten restless and are about ready to ransack the place. There's no getting "
						+ "the jump on them when they're this ready to go. Only way we're going to deal with this problem "
						+ "is to\ntackle it head on.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally2Name,
				"Ah, but that's how the famous \"Jagatai the Grey\" likes to fight, is it not?\n\n", txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally1Name, "Took the words right out of my mouth.\n\n", txtSpd);
		Pause.pause(wait);

		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue("1) Are you two friends?\n2) Do you two know each other?\nReponse: ", 8);
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
			Dialogue.characterDialogue(ally1Name, "I wouldn't go that far. But, we have heard of each other.\n\n",
					txtSpd);
		} else {
			Dialogue.characterDialogue(ally2Name,
					"You won't find many that don't know of this man's feats in his prime.\n\n", txtSpd);
		}
		Pause.pause(wait);

		Dialogue.characterDialogue(ally2Name,
				"Enough chatter for now. The ones on the front lines are weak. We'll tear through them with ease separately. "
						+ "Whichever one is first to reach the commander- the goblin's champion, Kioq- "
						+ "may try their hand in gaining the glory of taking his head.",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally1Name,
				"Just cause they're weak doesn't mean you can drop your guard. Don't die out there you two.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally2Name, "As if I'd lose a battle to lesser creatures, yet alone my life.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally2Name, "FORWARD!!\n\n", txtSpd - 10);
		Pause.pause(wait);

		Pause.pause();
		breakLine();

		while (!win) {

			if (battleCount % 3 == 0) {
				if (battle2.startBattle(scn)) {
					battleCount++;
				}
			} else {
				if (battle1.startBattle(scn)) {
					battleCount++;
				}
			}

			if (battleCount == 6) {
				win = true;
			}

		}

		win = false;

		Dialogue.infoDialogue(
				"Battling your way through several goblins, you find yourself separated from your companions as more and "
						+ "more goblins approached. Suddenly, they all stopped in place as loud footsteps "
						+ "were stomping up behind you.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(boss1Name, "Grr... Dem first w'ves... all weaklings!\n\n", txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue("Behind you was a massive, big-bellied goblin wielding a greataxe in each hand. "
				+ "Judging by his size and presence, "
				+ "it was clear to you that this was the goblin champion you were after.\n\n", txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(boss1Name,
				"I'm tired o' all dis waitin' round! How bout I beat puny human to pulp now!?\n\n", txtSpd);
		Pause.pause(wait);

		breakLine();

		while (!win) {
			win = bossBattle.startBattle(scn);
		}

		if (win) {

			Dialogue.infoDialogue("The champion of goblins now lays dead at your feet as you catch your breath. "
					+ "Any goblins that were around you "
					+ "began to back away in fear before they all ran away, abandoning their plan completely."
					+ " As all your adversaries "
					+ "were either dead or have fled, you could hear familiar footsteps as your companions "
					+ "finally caught up with you.\n\n", txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(ally2Name, "Impressive... you were able to fell Kioq by yourself.\n\n", txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(ally1Name,
					"Sorry about the delay. There were more of these guys than we thought. "
							+ "But, it looks like you didn't even need us "
							+ "in the first place. Adicai was right to choose you for this.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.infoDialogue(
					"Adicai approached the fallen goblin champion and picked up one of the axes that he had wielded.\n\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue(ally2Name,
					"At long last... I am able to pry this from the grips of this foul beast.\n\n", txtSpd);
			Pause.pause(wait);

			pResponse = true;
			while (pResponse) {
				Dialogue.infoDialogue(
						"1) What's special about that axe?\n2) Were you after the goblins to steal that axe?\nReponse: ",
						8);
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

			if (input == '2') {
				Dialogue.characterDialogue(ally2Name,
						"Indeed... I wanted to steal this from the thieves who originally stole it.\n\n", txtSpd);
			}
			Pause.pause(wait);

			Dialogue.characterDialogue(ally2Name,
					"This is the weapon of my father. Many years ago, he was slain in a war against the beasts of the earth, "
							+ "and this axe was taken from his corpse. I was but a young lad back then, and hardly "
							+ "with the power to "
							+ "get it back. Now, I can finally rejoice knowing that the axe has been retrieved from the "
							+ "hands of the "
							+ "goblin champion, a fool who can't even wield the weapon to its fullest potential and draw out "
							+ "its special attack.\n\n",
					txtSpd);

			Dialogue.characterDialogue(ally2Name,
					"However, I was not the one who retrieved this weapon. Therefore, I cannot say that I am truly "
							+ "worthy to wield it\nin my father's place...\n\n",
					txtSpd);

			Dialogue.infoDialogue(
					"Adicai hands over the greataxe to you, the one responsible for defeating the goblin champion.\n\n",
					txtSpd);

			Dialogue.characterDialogue(ally2Name,
					"As the slayer of Kioq, I want you to have this. Bring out the full potential of "
							+ "this weapon in your quests. I wish nothing but success for you," + player.getName()
							+ ".\n\n",
					txtSpd);

			player.getInventory().add(wList.axe4);
			Dialogue.infoDialogue("[You got the Phoenix Cleaver]\n\n", txtSpd);
			Pause.pause(wait);

		}

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

	/**
	 * Takes and serializes GameData object and stores it in a file to be reloaded later
	 *
	 * @param gameData Combination of player and shop objects
	 */
	public static void save(GameData gameData) {
		try (FileOutputStream fileOut = new FileOutputStream("gameSave.ser");
			 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(gameData);
			System.out.println("Game saved successfully.");
		} catch (Exception e) {e.printStackTrace();}
	}

	/**
	 * Reads and deserializes GameData object (player and shop objects).
	 * Deserialized GameData object is returned.
	 */
	public static GameData load() {
		try (FileInputStream fileIn = new FileInputStream("gameSave.ser");
			 ObjectInputStream in = new ObjectInputStream(fileIn)) {
			GameData gameData = (GameData) in.readObject();
			System.out.println("Game loaded successfully.");
			return gameData;
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}


}