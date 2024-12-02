package game;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import indexes.EnemyList;
import indexes.WeaponList;
import indexes.ConsumableList;

public class GameThread extends Throwable {

	private static final long serialVersionUID = 1L;

	private static WeaponList wList = new WeaponList();

	private static EnemyList eList = new EnemyList();
	
	private static ConsumableList cList = new ConsumableList();

	/**
	 * 
	 * ----- Main -----
	 * 
	 */

	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);

		Player player = OpeningMenu.showOpeningMenu();

		GameChapters(player, scn);

		scn.close();
	}

	/**
	 * 
	 * 
	 * ----- Functions -----
	 * 
	 * 
	 */

	/*
	 * 
	 * ----------------------------------------GameThread
	 * function----------------------------------------
	 * 
	 */

	public static void GameChapters(Player player, Scanner keyboard) {
		boolean inChapter = false;
		boolean willProgress = false;
		boolean chapterCompleted = false;
		int txtSpd = 25;
		char pChoice;
		
		/*
		 * --------------------Chapter 0--------------------
		 */
		
		if (player.getChapter() == 0) {
			
			chapterCompleted = false;
			inChapter = true;
			
			while (inChapter) {
				
				breakLine();
				Dialogue.infoDialogue(
						"You find yourself at a crossroads. Where do you decide to go?\n" + "1) Armory (Melee) \n"
								+ "2) Archery Range (Ranger) \n" + "3) Wizard's tower (Mage) \n" + "4) Shady Tavern (Rogue) \n",
						txtSpd);
				pChoice = keyboard.next().charAt(0);
				System.out.println();

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
					player.setChapter(player.getChapter() + 1);
				}
				
			}
			
		}

		/*
		 * --------------------Chapter 1--------------------
		 */
		if (player.getChapter() == 1) {
			Hub chapter1Hub = instantiateHub(player, "Town");

			chapterCompleted = false;
			inChapter = true;
			while (inChapter) {

				willProgress = chapter1Hub.start(keyboard);
				// Save functionality
				if (!willProgress) {
					save(player);
					try {
						System.exit(0);
					} catch (SecurityException e) {
						System.err.println("(Error when exiting)");
					}
					// Progressing with the main story
				} else {
					if (player.getlvlMelee() >= 3 || player.getlvlMage() >= 3 
							|| player.getlvlRanged() >= 3 || player.getlvlRogue() >= 3) {
						
						if (player.getInventory().getWeapons().size() >= 2) {
							boolean lvlMatchesInventory = false;
							for (int x = 0; x < player.getInventory().getWeapons().size(); x++) {
								switch(player.getInventory().getWeapons().get(x).getDamageType()) {
								case "Melee":
									if (player.getlvlMelee() >= 3) {
										lvlMatchesInventory = true;
									}
									break;
								case "Ranged":
									if (player.getlvlRanged() >= 3) {
										lvlMatchesInventory = true;
									}
									break;
								case "Magic":
									if (player.getlvlMage() >= 3) {
										lvlMatchesInventory = true;
									}
									break;
								case "Rogue":
									if (player.getlvlRogue() >= 3) {
										lvlMatchesInventory = true;
									}
									break;
								default:
									break;
								}
							}
							
							if (lvlMatchesInventory) {
								breakLine();
								chapterCompleted = ApproachCastle(player);
								
								if (chapterCompleted) {
									inChapter = false;
									player.setChapter(player.getChapter() + 1);
								}
							} else {
								Dialogue.infoDialogue("It is wise to ensure that the class that you have leveled "
										+ "up matches a weapon in your inventory. This will maximise the benefit "
										+ "gained from leveling up a class level.\n"
										+ "*Tip: By navigating to view character, you can both view what weapons"
										+ "you have as well as your profile which shows what your class levels are*", txtSpd);
							}
							
						} else {
							breakLine();
							Dialogue.infoDialogue("Before progressing to the castle, it is wise to purchace at "
									+ "least one weapon from the town's shop! More powerful weapons will help you "
									+ "contend with the powerful enemies you might face on castle grounds.\n"
									+ "*Tip: You can increase your currency by looking around the town! You might "
									+ "encounter some enemies that, if defeated will give you currency!*\n", txtSpd);
						}
						
						
					} else {
						breakLine();
						Dialogue.infoDialogue("Before progressing to the castle, it is wise to level up one of "
								+ "your class levels to at least level 3 to contend with any foes you might "
								+ "encounter on castle grounds.\n"
								+ "*Tip: You can increase your level by looking around the town! You might "
								+ "encounter some enemies that, if defeated will give you exp!*\n", txtSpd);
					}


				}
			}
		}

		/*
		 * --------------------Chapter 2--------------------
		 */
		if (player.getChapter() == 2) {
			Hub chapter2Hub = instantiateHub(player, "Castle Common Grounds");

			chapterCompleted = false;
			inChapter = true;
			while (inChapter) {

				willProgress = chapter2Hub.start(keyboard);
				// Save functionality
				if (!willProgress) {
					save(player);
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
						player.setChapter(player.getChapter() + 1);
					}
				}
			}
		}

		/*
		 * --------------------Chapter 3--------------------
		 */
		if (player.getChapter() == 3) {
			Hub chapter3Hub = instantiateHub(player, "Castle Upper-Class Lobby");

			chapterCompleted = false;
			inChapter = true;
			while (inChapter) {

				willProgress = chapter3Hub.start(keyboard);
				// Save functionality
				if (!willProgress) {
					save(player);
					try {
						System.exit(0);
					} catch (SecurityException e) {
						System.err.println("(Error when exiting)");
					}
					// Progressing with the main story
				} else {
					breakLine();
					Dialogue.infoDialogue("Which of the king's high council would you like to speak to?\n"+ 
							"1) Paris, King's Left Hand (Melee) \n" + 
							"2) Elaris the Ranger (Ranger) \n"+ 
							"3) Magnus the King's wizard (Mage) \n" + 
							"4) Fenric the advisor (Rogue) \n", txtSpd);
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
						player.setChapter(player.getChapter() + 1);
					}
				}
			}
		}

		/*
		 * --------------------Chapter 4--------------------
		 */
		if (player.getChapter() == 4) {
			Hub chapter4Hub = instantiateHub(player, "Castle Hero's Sector");
			boolean finalChant = true;
			Battle dragonFight = new Battle(player, eList.gilgemeshTheDragon, eList.gilgemeshsChildren);

			chapterCompleted = false;
			inChapter = true;
			while (inChapter) {

				willProgress = chapter4Hub.start(keyboard);
				// Save Functionality
				if (!willProgress) {
					save(player);
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
							+ "about the dangerous path you are about to walk?\n" + 
							"1) Paris, King's Left Hand(Melee) \n" + 
							"2) Elaris the Ranger (Ranger) \n" + 
							"3) Magnus the King's wizard (Mage) \n" + 
							"4) (Rogue) \n", txtSpd);
					pChoice = keyboard.next().charAt(0);
					switch (pChoice) {
					case '1':
						meleeDragonApproach(player, keyboard);
						chapterCompleted = dragonFight.dragonFight(keyboard);
						break;
					case '2':
						rangedDragonApproach(player, keyboard);
						chapterCompleted = dragonFight.dragonFight(keyboard);
						break;
					case '3':
						mageDragonApproach(player, keyboard);
						chapterCompleted = dragonFight.dragonFight(keyboard);
						break;
					case '4':
						rogueDragonApproach(player, keyboard);
						chapterCompleted = dragonFight.dragonFight(keyboard);
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
								+ "fear that has gripped them for decades! Congratulations " + player.getName()
								+ "! You are "
								+ "truly a great adventurer the likes of which none have seen before. \n", txtSpd);
						while (finalChant) {
							breakLine();
							Dialogue.infoDialogue("*Release a mighty shout from the mountain top!* \n" + "(enter 1)\n",
									txtSpd);
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

	/*
	 * 
	 * 
	 * ----------------------------------------Story
	 * Functions----------------------------------------
	 * 
	 * 
	 */

	/*
	 * 
	 * ------------------------------All class Story
	 * Functions------------------------------
	 * 
	 */

	/*
	 * --------------------Chapter 2--------------------
	 */

	public static boolean ApproachCastle(Player player) {
		
		return true;

	}

	public static boolean kingsMission(Player player, Scanner keyboard) {
		int txtSpd = 25;
		int wait = 1000;
		char choice;
		boolean validChoice = false;

		Dialogue.infoDialogue(
				"You are led through the grand halls of the castle, every step echoing off the polished marble floors. "
						+ "The air is thick with the scent of incense, and sunlight streams through towering stained-glass windows, casting vibrant"
						+ "patterns on the walls. Guards, clad in golden armor, stand at attention as you pass, their expressions unreadable. "
						+ "Ahead lies the throne room, its gilded doors slowly creaking open to reveal an awe-inspiring sight.\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"At the end of the cavernous hall sits King Mightus, the extraordinary ruler of the kingdom. His throne, carved from a single"
						+ "block of shimmering gold, gleams in the sunlight. The king himself is a towering figure, clad in resplendent robes"
						+ "that seem to shimmer with every color of the rainbow. His presence is overwhelming, a mix of authority and"
						+ "charisma that leaves you momentarily speechless.\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue("King Mightus",
				"Ah, the newcomer who has stirred whispers across my kingdom. Step forward, " + player.getName()
						+ ", and let me see the face of this promising adventurer.\n",
				txtSpd);
		Pause.pause(wait);

		// Player response choices
		Dialogue.characterDialogue("King Mightus",
				"How do you respond?\n" + "1) (Nervously) Y-Your Majesty… I… It’s an honor… I mean… I’m speechless!\n"
						+ "2) (Confidently) Your Majesty, I’m honored to stand before you.\n"
						+ "3) (Awkwardly) Uh… Hi? This is all a bit overwhelming...\n",
				txtSpd);

		choice = keyboard.next().charAt(0);
		breakLine();

		if (choice == '1') { // Nervous Response
			Dialogue.characterDialogue(player.getName(),
					"(Nervously) Y-Your Majesty… I… It’s an honor… I mean… I’m speechless!\n", txtSpd);
			Dialogue.characterDialogue("King Mightus",
					"Your nervousness speaks to your humility. It is not every day one stands before royalty, I understand.\n",
					txtSpd);
		} else if (choice == '2') { // Confident Response
			Dialogue.characterDialogue(player.getName(), "(Confidently) Your Majesty, I’m honored to stand before you.\n",
					txtSpd);
			Dialogue.characterDialogue("King Mightus",
					"A confident reply—good. Confidence, tempered with humility, will serve you well in this mission.\n",
					txtSpd);
		} else if (choice == '3') { // Awkward Response
			Dialogue.characterDialogue(player.getName(), "(Awkwardly) Uh… Hi? This is all a bit overwhelming...\n",
					txtSpd);
			Dialogue.characterDialogue("King Mightus",
					"An honest reaction. Overwhelming, perhaps, but clarity of purpose will guide you forward.\n",
					txtSpd);
		} else {
			Dialogue.infoDialogue("Invalid response. The King awaits your proper reply.\n", txtSpd);
			return false; // Exit if invalid choice
		}

		Dialogue.characterDialogue("King Mightus",
				"I have summoned you for a mission that requires great courage and skill.\n", txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"The king's tone sharpens as he describes the mission—a cruel troll named Grakthar the Vile, terrorizing the outskirts of the kingdom.\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue("King Mightus",
				"Grakthar dwells in the dark depths of the Shadowgrove. Many have faced him, and all have failed. "
						+ "This will be your first great test. Prepare well, for you will need every ounce of strength and cunning to prevail.\n",
				txtSpd);
		breakLine();

		// Player preparation
		Dialogue.infoDialogue(
				"You leave the throne room, the weight of the mission pressing on your shoulders. The guards guide you to the castle’s armory.\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"The castle's blacksmith ensures that your weapons are in good condition and that you are well prepared for the journey ahead of you.\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue("Blacksmith",
				"Your gear is as ready as it’ll ever be. Good luck out there, adventurer. Grakthar isn’t just a brute—he’s clever.\n",
				txtSpd);
		breakLine();

		Dialogue.infoDialogue(
				"As night falls, you arrive at the edge of the Shadowgrove. The forest is dark and twisted, the air thick with malice. You draw your weapon, "
						+ "prepared for the battle ahead.\n",
				txtSpd);
		Pause.pause(wait);

		// Battle against Grakthar
		Battle trollBattle = new Battle(player, eList.grakthar);
		boolean win = trollBattle.startBattle(keyboard, true);
		breakLine();

		if (win) {
			Dialogue.infoDialogue(
					"Grakthar the Vile lets out a thunderous roar, his massive body crashing to the ground with a tremor that shakes the forest."
							+ "The once-dominant monster, now lifeless, lies amidst the dark shadows of the grove. A moment of eerie silence follows,"
							+ "broken only by the rustling of leaves in the wind. You have done it—Grakthar's reign of terror has ended.\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.infoDialogue(
					"As the adrenaline fades, you take a deep breath, steadying yourself as the reality of your victory sets in."
							+ "The Shadowgrove seems less menacing now, its dark presence waning with the fall of the vile beast. "
							+ "You prepare to return to the castle, carrying news of your triumph.\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.characterDialogue("King Mightus",
					"You have done what no other could. My kingdom owes you a debt of gratitude, " + player.getName()
							+ ". You are a true hero.\n",
					txtSpd);
			breakLine();
		} else {
			Dialogue.infoDialogue(
					"Grakthar lets out a guttural laugh as he towers over you, his cruel eyes glowing with triumph."
							+ "His massive hand raises, ready to deliver the final blow. Your vision blurs as you fall to the ground, your strength spent.\n",
					txtSpd);
			Pause.pause(wait);

			Dialogue.infoDialogue(
					"The last thing you hear is the sound of Grakthar’s heavy footsteps fading into the shadows, his reign of terror unbroken."
							+ "The Shadowgrove remains a place of fear, and the kingdom's people will suffer once more...\n",
					txtSpd);
			breakLine();
			return false;
		}

		return true;
	}

	/*
	 * --------------------Chapter 4--------------------
	 */

	public static void KingsFinalMission(Player player) {
		int txtSpd = 25;
		Dialogue.characterDialogue("King Mightus", "It is very impressive that you have managed to satisfy one of "
				+ "my council members. They are not easy to please! I have recieved high praise from them that you "
				+ "are someone that can be relied on. If you are as good as they say, I have a mission that I believe "
				+ "you might find intriguing, although it would be your greatest challenge yet. There is a dragon at "
				+ "the top of Mount Doom named Gilgemesh that has terrorized our kingdom for decades. There has not been a "
				+ "single soldier nor adventurer that has been able to topple the Dragon. Since you have arived here, you "
				+ "have taken on every challenge that has been presented to you so I have an inclination you might find "
				+ "this proposal appealing. If you managed to conquer this dragon, you would free our kingdom from its rain "
				+ "of tyrany and we would forever be indebted to you. Based on how you would like to approach this battle, "
				+ "speak to one of my council members for advice, as their specialty in certain areas will be of more aid to you.\n",
				txtSpd);
	}

	/*
	 * 
	 * ------------------------------Melee Story
	 * Functions------------------------------
	 * 
	 */

	/*
	 * --------------------Chapter 1--------------------
	 */

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

		player.getInventory().add(wList.ironSword);
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
						+ "holding the sword in a middle guard stance.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(charName,
				"Better not expect any weak swings just cause you're new and I'm old. A couple of swings should help you "
						+ "get the feel of things, so try not to get banged up too much. Now bring it!\n\n",
				txtSpd);
		Pause.pause(wait);

		breakLine();

		win = meleeTutorial.startBattle(scn, true);
		
		while (!win) {
			
			Dialogue.characterDialogue(charName, "Come on! I know you are capable of more than this!", txtSpd);
			Pause.pause(wait);
			win = meleeTutorial.startBattle(scn, true);
		}
		
		breakLine();

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
					"-----------------------------------------------------------------------------------------------------------------------------");

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

	/*
	 * --------------------Chapter 3--------------------
	 */

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

		Dialogue.characterDialogue(kingKnight,
				"You've been quite busy I see. Trying to rack up a good reputation with the "
						+ "royal court now by pleasing the king, are we? Quite ambitious for a rookie. But that's enough discussion. "
						+ "I'm the one that sent that summons. I have a task for somebody that's unable to keep still. Someone like"
						+ " you.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"Though his attitude got annoying to you quickly, you knew that it'd be in your best interest "
						+ "to listen to Paris' request.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"Color me surprised to hear that a large band of goblins- yes those creatures-"
						+ " have begun to organize themselves into a unit that threatens the safety of this kingdom. While it would "
						+ "be extremely easy for me to deploy a platoon to deal with them and be on my way, I'd rather not waste "
						+ "many of my own soldiers like this.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"So! What better way to solve the issue than to delegate it the new hotshot "
						+ "adventurer that's the talk of the town? I want you to deal with the kingdom's goblin problem. I don't "
						+ "intend to take no for an answer, so don't bother.\n\n",
				txtSpd);
		Pause.pause(wait);

		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue(
					"1) I wasn't going to say no, so I'll be going now.\n2) Are you finished yet?\nReponse: ", 8);
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
			Dialogue.characterDialogue(kingKnight,
					"I do love how we're on the same page, but I would love it even more if you"
							+ " didn't interrupt me. I wasn't finished talking.\n\n",
					txtSpd);
		} else {
			Dialogue.characterDialogue(kingKnight,
					"I'd be finished a lot sooner if you wouldn't interrupt me. Now, as I was " + "about to say...\n\n",
					txtSpd);
		}
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"You begin to consider how bad walking away now would hurt your reputation, thinking just long "
						+ "enough for Paris to say something interesting.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"General Adicai is insistent on heading out personally to defeat these goblins "
						+ "alongside you. There's something about the appearance of a goblin champion that's made him restless, so "
						+ "get along well with him.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"I suggest that you keep in mind that Adicai is far more important to this "
						+ "kingdom that you'll ever be. Your most important duty will be to ensure that he returns safe and sound.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally2Name, "I am more than capable of taking care of myself, sir Paris.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"Suddenly the general in question, Adicai, appraoches both you and Paris, having overheard the "
						+ "conversation. After his initial statement, he turned to you as his tone softened.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(ally2Name,
				"You must be the new adventurer I've heard about. My name is Adicai. You needn't"
						+ " worry about me on the battlefield. Our main goal will be to ensure that as many goblins are wiped out as "
						+ "possible, and defeating the ringleader behind their organization. You can use whatever you see fit for "
						+ "this operation. I'll be waiting for you to prepare.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"...Regardless of Adicai's concerns, keep in mind what I said. That is all."
						+ " I'll leave you two to take care of this.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"Paris headed back for the king's chamber. Adicai saluted you before he left. All that was left"
						+ " to do was prepare yourself for the battle with the goblins... and you had an idea on how to do so.\n\n",
				txtSpd);
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
				if (battle2.startBattle(scn, true)) {
					battleCount++;
				}
			} else {
				if (battle1.startBattle(scn, true)) {
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
			win = bossBattle.startBattle(scn, true);
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

	/*
	 * --------------------Chapter 4--------------------
	 */

	public static boolean meleeDragonApproach(Player player, Scanner scn) {

		String kingKnight = "Paris, King's Left Hand";
		Battle miniBoss = new Battle(player, eList.dWar);
		boolean win = false;
		int txtSpd = 25, wait = 1000;
		boolean pResponse;
		char input = 0;

		breakLine();

		Dialogue.infoDialogue(
				"Once again, you find yourself in the company of Paris, having been called out by the king's "
						+ "knight in regards to another mission. This time, the condescending look on his face was gone by the time "
						+ "you arrived.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight, "Well, look what the cat finally dragged in.\n\n", txtSpd);
		Pause.pause(wait + 500);

		Dialogue.infoDialogue("...ONLY the look wasn't present.\n\n", txtSpd + 10);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"Adicai's been singing nothing but praises for you for a while, and I have to "
						+ "admit, even I am impressed to hear that the goblin champion fell by your hands and your hands alone. You "
						+ "aren't the same wannabe hero that you were when we first met. You might actually be the perfect fit for a "
						+ "task such as this.\n\n",
				txtSpd);
		Pause.pause(wait);

		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue("1) And that task would be...?\n2) You? Praising me? What a surprise!\nReponse: ", 8);
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
			Dialogue.characterDialogue(kingKnight,
					"How hard is it to wait til I finish talking? I was getting to that.\n\n", txtSpd);
		} else {
			Dialogue.characterDialogue(kingKnight,
					"Yes, yes. As surprising as it may seem, you actually earned it.\n\n", txtSpd);
		}
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"Now then, this is something that I myself along with the other key advisors "
						+ "to the king have been focusing on. This kingdom has always been in grave jeopardy at the hands of a "
						+ "powerful dragonlord. Sitting on top of the tallest mountain you can see from the castle gates is where its"
						+ " nest is positioned. Naturally, you would think that we would have dealt with this by now what with all "
						+ "the information we have. However, there's a slight issue.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"It's... impossible for even us to reach that peak. Although most of the lesser"
						+ " dragons around the mountaintop have been dealt with, a handful remain. Furthermore, too many men have died"
						+ " making the climb up the mountain. We've had no luck finding a better path. A warrior such as yourself was"
						+ " capable of besting an entire army by yourself, so this may be doable for you.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"I need you to scout around the mountain without going past the midpoint. If "
						+ "you can find a passageway up to the peak where the dragonlord resides, then I swear that a hefty reward "
						+ "will be waiting for you the moment you find it and we confirm that you've done so.\n\n",
				txtSpd);
		Pause.pause(wait);

		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue("1) ...What would the reward be if I were to defeat the dragonlord while I'm there?\n"
					+ "Reponse: ", 8);
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

		Dialogue.characterDialogue(kingKnight,
				"What?! Have you gone mad?! To take on the dragonlord single-handedly, that's "
						+ "a fool's task! It's impossible! Suicide! You'd never survive!\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"The king's elite will lead a force strong enough to handle the dragonlord. We "
						+ "don't need you to attempt to play hero by yourself.\n\n",
				txtSpd);
		Pause.pause(wait);

		pResponse = true;
		while (pResponse) {
			Dialogue.infoDialogue(
					"1) But that would lead to lots of casualties\n2) I don't care if you think I can handle it."
							+ "\nReponse: ",
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

		if (input == '1') {
			Dialogue.characterDialogue(kingKnight, "Well, yes... that is true, I...\n\n", txtSpd);
		} else {
			Dialogue.characterDialogue(kingKnight, "Are you that desperate to prove something here...?\n\n", txtSpd);
		}
		Pause.pause(wait);

		Dialogue.infoDialogue("Paris let out a loud sigh.\n\n", txtSpd);
		Pause.pause(wait * 2);

		Dialogue.characterDialogue(kingKnight,
				"Hypothetically speaking... We're you capable of defeating a dragonlord without"
						+ " any form of aid, we would allow you to name your price in terms of payment. I can't think of any other way"
						+ " that it'd be fair for your efforts. Hoever, this is merely a hypothetical situation. Only a fool would go "
						+ "out there and attempt to play hero over it.\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue(kingKnight,
				"Regardless, I've given you your ACTUAL mission already. Head to the mountain "
						+ "and find a path for our army to march up to the dragonlord. You will be paid handsomely upon your return."
						+ "\n\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.infoDialogue(
				"Despite Paris' warning, your mind was already made up. You had every intention of putting your "
						+ "strength to the test against this dragonlord. Of course, you still had to find your own way up. With your "
						+ "weapons ready to go, you set off towards the mountains, ready to climb towards your destination.\n\n"
						+ "",
				txtSpd);
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
		win = miniBoss.startBattle(scn, true);
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

	/*
	 * 
	 * ------------------------------Ranged Story
	 * Functions------------------------------
	 * 
	 */

	/*
	 * --------------------Chapter 1--------------------
	 */

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
		Dialogue.characterDialogue("Elaris the Ranger",
				"Welcome, traveler. I’ve heard whispers of a newcomer—your name is " + player.getName() + ", yes?",
				txtSpd);
		Pause.pause(wait);
		Dialogue.characterDialogue("Elaris the Ranger",
				"My name is Elaris, and I guide those who seek to master the bow. Shall we begin your training?",
				txtSpd);

		while (makingChoice) {
			Dialogue.characterDialogue("Elaris the Ranger",
					"What do you say?\n" + "1) Yes, I’m ready!\n" + "2) Hmm, I’m not sure if I want to be an archer.",
					txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				breakLine();
				Dialogue.characterDialogue(player.getName(), "Yes, I’m ready!", txtSpd);
				Pause.pause(wait);
				Dialogue.characterDialogue("Elaris the Ranger",
						"Wonderful. The bow may seem simple, but wield it well, and it becomes the deadliest of weapons.",
						txtSpd);
				makingChoice = false;
				break;

			case '2':
				breakLine();
				Dialogue.characterDialogue(player.getName(), "Hmm, I’m not sure if I want to be an archer.", txtSpd);
				Pause.pause(wait);
				Dialogue.characterDialogue("Elaris the Ranger",
						"No pressure. The woods are patient, and I’ll be here if you change your mind.", txtSpd);
				return false;

			default:
				breakLine();
				Dialogue.infoDialogue("(Invalid choice. Please try again)\n", txtSpd);
			}
		}

		Dialogue.characterDialogue("Elaris the Ranger",
				"First, you’ll need a bow. This shortbow has served many a beginner well. Take it, and we’ll get started.",
				txtSpd);
		player.getInventory().add(wList.bow1);
		Pause.pause(wait);
		Dialogue.infoDialogue("The starter bow has been added to your inventory!\n", txtSpd);
		player.getInventory().getWeaponOnKey(wList.bow1.getKey()).displayInfo();

		makingChoice = true;

		while (makingChoice) {
			breakLine();
			Dialogue.characterDialogue("Elaris the Ranger",
					"Let’s talk about ammunition. Regular arrows are infinite, so you’ll never run out of basic shots. "
							+ "However, special arrows—fire and ice—are rare and must be looted from enemies or chests. "
							+ "Use them wisely when the situation demands.\n"
							+ "Here are your current special arrows:\n" + "Special arrows: "
							+ player.getInventory().getSpecialArrows(),
					txtSpd);
			Pause.pause(wait);
			Dialogue.characterDialogue("Elaris the Ranger",
					"1) Got it! Let’s move on.\n" + "2) Can you explain that again?", txtSpd);
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

		Dialogue.characterDialogue("Elaris the Ranger",
				"Time to test your aim. Let’s see how you handle a live target. Don’t worry—"
						+ "this sheep is harmless, and we use it to train all newcomers. Draw your bow, aim for the mark, and let your arrow fly!",
				txtSpd);

		while (!playerWon) {
			playerWon = tutorialBattle.startBattle(keyboard, true);
			if (!playerWon) {
				player.setCurrHP(player.getHealth());
				tutorialBattle.getEnemy().setCurrHP(tutorialBattle.getEnemy().getHealth());
				tutorialBattle.setTurn(0);
				Dialogue.characterDialogue("Elaris the Ranger",
						"You’re getting there! Precision comes with practice. Try again.", txtSpd);
			}
		}

		breakLine();
		Dialogue.characterDialogue("Elaris the Ranger",
				"Well done! You’re already showing promise. That’s all I can teach for now, but the true lessons "
						+ "lie ahead. Head to the castle—the King often seeks skilled adventurers, and the journey will test your abilities.",
				txtSpd);
		Pause.pause(wait);
		Dialogue.characterDialogue("Elaris the Ranger",
				"And remember, I’m always here should you need guidance. The woods never turn their back on a friend.",
				txtSpd);

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
			Dialogue.characterDialogue("Elaris the Ranger",
					"1) Thanks, Elaris! I’ll head to the castle.\n" + "2) I’ll be sure to visit again!", txtSpd);
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

	/*
	 * --------------------Chapter 3--------------------
	 */

	public static boolean rangedSpecialMission(Player player, Scanner keyboard) {
		int txtSpd = 25;
		char pChoice;
		boolean makingChoice = true;
		String pName = player.getName();
		String rangerName = "Elaris the Ranger";

		breakLine();
		Dialogue.characterDialogue(rangerName, "Ah, " + pName
				+ "! I’ve been meaning to speak with you. Your skill with a bow is unmatched in these parts, and there’s a dire situation that needs addressing.",
				txtSpd);

		while (makingChoice) {
			Dialogue.characterDialogue(rangerName,
					"The Shadow Stalker pack has taken over an ancient territory nearby, and their alpha, Nightfang, is growing stronger by the day. We need you to stop him before the pack becomes unstoppable.\n"
							+ "Are you willing to take on this mission?\n" + "1) Yes, I’ll take on the challenge.\n"
							+ "2) I’m not sure. This sounds dangerous.\n",
					txtSpd);
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
				Dialogue.characterDialogue(rangerName,
						"It is dangerous, but you’re the only one capable of stopping Nightfang. Let me know if you change your mind.\n",
						txtSpd);
				return false;

			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}

		Dialogue.characterDialogue(rangerName,
				"Nightfang’s territory lies in the Heartshadow Woods. It’s a twisted place of darkness, but you’ll have an important choice to make when you arrive. "
						+ "Nightfang prowls between two locations, and you’ll need to decide where to confront him.",
				txtSpd);

		Dialogue.infoDialogue(
				"*You gather your gear and head out, the forest growing darker as you approach the Heartshadow Woods. The air is thick with mist, and the faint glow of fireflies provides the only light. "
						+ "After some time, you reach the edge of the woods where a fork in the path offers two distinct routes.*\n",
				txtSpd);

		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("*Which path will you take?*\n"
					+ "1) *The Ancient Clearing: An open field where moonlight breaks through the canopy, casting eerie shadows.*\n"
					+ "2) *The Cursed Hollow: A narrow gorge filled with jagged rocks and an oppressive darkness.*\n",
					txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				breakLine();
				Dialogue.infoDialogue(
						"*You choose the path to the Ancient Clearing, where the forest opens into a large field. Moonlight filters down through the twisted branches, illuminating the clearing in a pale silver glow. "
								+ "The ground is covered in moss and glowing mushrooms, and the air hums with an unnatural silence. You step into the clearing cautiously, sensing movement among the shadows.*\n",
						txtSpd);
				makingChoice = false;
				break;

			case '2':
				breakLine();
				Dialogue.infoDialogue(
						"*You choose the path to the Cursed Hollow, where the forest closes in tightly around you. The narrow gorge is suffocating, with jagged rocks jutting out like broken teeth. "
								+ "A faint red glow pulses from deep within, and the sound of dripping water echoes eerily. The oppressive air weighs heavily on your chest as you venture deeper, your every step crunching against loose stone.*\n",
						txtSpd);
				makingChoice = false;
				break;

			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}

		Dialogue.infoDialogue(
				"*You hear a guttural growl nearby, and your heart races as you realize Nightfang is near. The alpha Shadow Stalker emerges from the darkness, its glowing red eyes locked onto you. "
						+ "The creature stands taller than any of its kin, its fur bristling with shadowy tendrils that shift and writhe as if alive. Its razor-sharp claws glint in the dim light.*\n",
				txtSpd);

		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("*What do you do?*\n" + "1) *Raise your bow and prepare for battle.*\n"
					+ "2) *Try to find a better position for the fight.*\n", txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				breakLine();
				Dialogue.infoDialogue(
						"*You nock an arrow and face Nightfang head-on, your heart pounding as you prepare for a fierce battle.*\n",
						txtSpd);
				makingChoice = false;
				break;

			case '2':
				breakLine();
				Dialogue.infoDialogue(
						"*You dart behind a nearby boulder, using the terrain to gain a tactical advantage. Nightfang circles, its glowing eyes tracking your every move.*\n",
						txtSpd);
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
		 * lose: return false;
		 * 
		 * win:
		 */

		Dialogue.infoDialogue(
				"*As the battle concludes, Nightfang collapses with a final, ear-splitting howl. The oppressive atmosphere of the woods begins to lift, and the shadows that clung to the trees slowly recede. "
						+ "The forest is quiet once more, save for the rustling of leaves in a gentle breeze. You take a moment to catch your breath, the adrenaline of the fight still coursing through your veins.*\n",
				txtSpd);

		Dialogue.infoDialogue(
				"*You begin your journey back to Elaris, the weight of your victory etched in every step you take.*\n",
				txtSpd);

		Dialogue.characterDialogue(rangerName,
				"You’ve returned! And from the look of you, I’d say the mission was a success. The woods will remember your courage, and so will I. Thank you, "
						+ pName + ". You’ve done more than you know.\n",
				txtSpd);

		return true;
	}

	/*
	 * --------------------Chapter 4--------------------
	 */

	public static boolean rangedDragonApproach(Player player, Scanner keyboard) {
		return true;
	}

	/*
	 * 
	 * ------------------------------Mage Story
	 * Functions------------------------------
	 * 
	 */

	/*
	 * --------------------Chapter 1--------------------
	 */

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
					+ "1) Absolutely!\n" + "2) I'm not sure if I'm interested in magic.\n", txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				breakLine();
				Dialogue.characterDialogue(pName, "Absolutely!\n", txtSpd);
				Dialogue.characterDialogue(wizName, "Great to hear! It's always nice to have another mage in town!\n",
						txtSpd);
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

		Dialogue.characterDialogue(wizName, "First of all we need to get you started with a weapon that can "
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
			Dialogue.characterDialogue(wizName,
					"Now that you have a weapon, I should probably explain mana. Mana is the power inside "
							+ "each person that can be channeled through the use of magic weapons. Magic weapons use a portion "
							+ "of your built up mana to launch an attack! Be careful though because you can run out and your "
							+ "weapon will no longer work. Through tough battles you can increase the effectiveness of your magic "
							+ "and the amount of mana you can store.\n",
					txtSpd);
			Dialogue.infoDialogue("Your current mana storage is: " + player.getMana() + "\n", txtSpd);
			breakLine();
			Dialogue.infoDialogue("1) Okay I think I got it!\n" + "2) Explain that again?\n", txtSpd);
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
				+ "skills on this sheep! Don't worry sheep around here aren't known for their fighting abilities.\n",
				txtSpd);

		while (!playerWon) {
			playerWon = tutorialBattle.startBattle(keyboard, true);
			if (!playerWon) {
				Dialogue.characterDialogue(wizName,
						"Thats okay you'll get the hang of it. take another shot at " + "it!\n", txtSpd);
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
			Dialogue.infoDialogue(
					"1) Will do! Thanks for the advice!\n" + "2) I'll definitely have to check out the castle!\n",
					txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {

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

	/*
	 * --------------------Chapter 3--------------------
	 */

	public static boolean mageSpecialMission(Player player, Scanner keyboard) {
		int txtSpd = 25;
		char pChoice;
		boolean makingChoice = true;
		String pName = player.getName();
		String wizName = "Magnus the King's Wizard";

		breakLine();
		Dialogue.characterDialogue(wizName,
				"I heard you defeated the Troll that has been terrorizing the "
						+ "townspeople. That is pretty impressive! That Troll has been a pain in our side for a little "
						+ "over a year now. I hear the King is pretty impressed with you too! Although that goes "
						+ "without saying if he’s allowing you to take orders from me.\n",
				txtSpd);

		while (makingChoice) {
			Dialogue.characterDialogue(wizName, "Speaking of, did the King mention that I had something "
					+ "I needed done that you might be able to help me out with?\n" + "1) Yes I believe he did.\n"
					+ "2) I don’t recall. But I’d be willing to hear you out now.\n", txtSpd);

			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				breakLine();
				Dialogue.characterDialogue(pName, "Yes I believe he did.\n", txtSpd);
				makingChoice = false;
				break;

			case '2':
				breakLine();
				Dialogue.characterDialogue(pName, "I don’t recall. But I’d be willing to hear you out now.\n", txtSpd);
				makingChoice = false;
				break;

			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}

		}

		Dialogue.characterDialogue(wizName, "Well I have run into a bit of a roadblock in some research "
				+ "I have been doing. I have been looking into the inner workings of Fire Magic but to further "
				+ "my research I need a firestone. They can be found in the Fire Cave located on Mount "
				+ "Cloudripper. I would go retrieve it myself but I am the one responsible for the protective "
				+ "barrier around the kingdom. If I were to leave, it would put our population at risk of enemy "
				+ "magic users. I have been searching for someone strong enough to retrieve it for me but have not "
				+ "found much luck until now. I have sent multiple adventurers out but all of them have failed to "
				+ "come back. If you were strong enough to defeat the Troll, you might have a chance to make it "
				+ "back though! If you can make it to the bottom of the cave, there might be a powerful magic "
				+ "weapon in it for you.\n", txtSpd);

		makingChoice = true;
		while (makingChoice) {
			Dialogue.characterDialogue(wizName,
					"What do you think?\n" + "1) That sounds interesting. What should I expect if I were to go?\n"
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
						+ "magic weapon would be worth it.\n", txtSpd);
				Dialogue.characterDialogue(wizName, "That is understandable. It’s not a decision to make lightly. "
						+ "Let me know if you change your mind!\n", txtSpd);
				return false;
			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}

		}

		Dialogue.characterDialogue(wizName, "If you were to attempt this journey, I will not sugar coat it. "
				+ "It will be dangerous and you will encounter many strong enemies through the cave. As you "
				+ "journey deeper into the cave, you will more than likely encounter Fire Elementals. They are "
				+ "no joke and pack a serious punch. You will definitely want to stay on guard. But those are "
				+ "not the worst of your worries. One of the strongest fire magic users used to live in that "
				+ "cave, and right before the entrance to his home, he summoned a Fire Elemental Rock Golem as a "
				+ "bodyguard. The wizard is long dead but that Golem still stands to protect the wizard’s "
				+ "possessions. It can do some serious damage so if you decide to take on this challenge, the "
				+ "Golem will be your biggest hurdle.\n", txtSpd);

		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue(
					"How do you respond?\n"
							+ "1) That sound’s like a very dangerous mission. What’s in it for me? You mentioned a "
							+ "powerful magic weapon?\n"
							+ "2) I’m not so sure that is a mission I would like to go on. Let me think about it.\n",
					txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				breakLine();
				Dialogue.characterDialogue(pName, "That sound’s like a very dangerous mission. What’s in it for me? "
						+ "You mentioned a powerful magic weapon?\n", txtSpd);
				makingChoice = false;
				break;

			case '2':
				breakLine();
				Dialogue.characterDialogue(pName,
						"I’m not so sure that is a mission I would like to go on. Let " + "me think about it.\n",
						txtSpd);
				Dialogue.characterDialogue(wizName, "That is understandable. It’s not a decision to make lightly. "
						+ "Let me know if you change your mind!\n", txtSpd);
				return false;

			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}

		}

		Dialogue.characterDialogue(wizName, "Absolutely! This is not something I would ask you to do if there "
				+ "wasn’t anything in it for you. I have heard rumors that the wizard’s Hellfire Staff lies within "
				+ "his home, along with the Fire Stones. That staff is one of the strongest magic weapons "
				+ "you can find if you can make it through the Golem. Of course, I have only heard rumors and, "
				+ "not having been there myself, I can’t confirm whether it’s there. But if it is, it would make "
				+ "the trip worth it for just about any magic user.\n", txtSpd);

		makingChoice = true;
		while (makingChoice) {
			Dialogue.characterDialogue(wizName,
					"With that in mind, what do you think?\n"
							+ "1) I think I’ll give it a shot! How do I get to the cave?\n"
							+ "2) I’m not too sure. Let me think about it.\n",
					txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				breakLine();
				Dialogue.characterDialogue(pName, "I think I’ll give it a shot! How do I get to the cave?\n", txtSpd);
				makingChoice = false;
				break;

			case '2':
				breakLine();
				Dialogue.characterDialogue(pName, "I’m not too sure. Let me think about it.\n", txtSpd);
				Dialogue.characterDialogue(wizName, "I completely understand. It’s not a decision to make lightly. "
						+ "Let me know if you change your mind!\n", txtSpd);
				return false;

			default:
				breakLine();
				System.err.println("(Invalid choice. Please try again)");
				break;
			}

		}

		Dialogue.characterDialogue(wizName, "Great to hear! To reach the cave, head down the main road "
				+ "out of town. Then head toward the tallest mountain on the skyline. That’s Mount Cloudripper. "
				+ "The Fire Cave can be found on the opposite side of the mountain if you are leaving from "
				+ "the main gate. It’s almost impossible to miss. There is a fiery glow emanating from the "
				+ "entrance as a result of the flame infused rock that lines the walls of the cave. Deep within "
				+ "is where you’ll find the wizard’s hideout.\n", txtSpd);

		makingChoice = true;
		while (makingChoice) {
			Dialogue.characterDialogue(wizName, "I wish you luck on your journey and a better fate than "
					+ "those who have attempted this journey before you!\n" + "1) Thank you! I will be on my way now!\n"
					+ "2) Thank you! I will be back soon, stone and staff in hand!\n", txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				breakLine();
				Dialogue.characterDialogue(pName, "Thank you! I will be on my way now!\n", txtSpd);
				Dialogue.characterDialogue(wizName, "Of course! I hope to see you again soon!\n", txtSpd);
				makingChoice = false;
				break;

			case '2':
				breakLine();
				Dialogue.characterDialogue(pName, "Thank you! I will be back soon, stone and staff in hand!\n", txtSpd);
				Dialogue.characterDialogue(wizName, "Of course! I have every confidence you will!\n", txtSpd);
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
				+ "boulder to rest before your trek into the cave.*\n", txtSpd);

		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("*You wake up and see the sun overhead. You have rested through the night. What "
					+ "do you want to do?*\n "
					+ "1) *Being well rested, I am ready to make my journey into the depths*\n "
					+ "2) *I find myself still exhausted, I would like to rest some more*\n", txtSpd);
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
				+ "are now standing face to face with a Fire Elemental!*\n", txtSpd);

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
				+ "of the same goal you came down here for.*\n", txtSpd);

		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("What will you do? \n" + "1) *Loot the body*\n" + "2) *Continue onward\n", txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				Lootable body = new Lootable("Gerald the Fallen Wizard", new Inventory(), 500);
				Item[] bodyItems = {wList.tornadoStaff, cList.speed, cList.chapter3Mana};
				body.getInventory().addMulti(bodyItems);
				
				breakLine();
				player.loot(body, keyboard);
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
				+ "have come face to face with the elemental. *\n", txtSpd);

		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("*Are you ready to fight?*\n" + "1) *I was born ready*\n" + "2) *I need to hide!*",
					txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				breakLine();
				Dialogue.infoDialogue(
						"*Poised with your weapon ready for battle, you face the fire elemental showing no fear*\n",
						txtSpd);
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
			Dialogue.infoDialogue("*Are you ready to fight?*\n" + "1) Yes! I will take down the beast!\n"
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
				player.selectMainhandWeapon(keyboard);
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

		if (!fireElementalRockGolem.startBattle(keyboard, true)) {
			return false;
		}

		Dialogue.infoDialogue("*As the beast falls, the ground shakes as it hits the ground. On the other "
				+ "side of the opening, you see a door. That is no doubt the entrance to the Fire wizard’s "
				+ "home. You enter to see, propped up on a stand, the hellfire staff glowing with flame energy. "
				+ "You pick up the staff and feel the magical power coursing through the staff. On a shelf above "
				+ "the wizard’s alchemy table, you find the Fire Stone that Magnus asked you to retrieve. You "
				+ "grab both and notice a chest by the wizard’s bed.*\n", txtSpd);
		player.getInventory().add(wList.hellfireStaff);
		System.out.println("The hellfire Staff has been added to your Inventory!");
		System.out.println("The Fire Stone has been added to your Inventory!");

		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue("What do you do?\n" + "1) Loot the chest\n" + "2) Leave\n", txtSpd);
			pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
			case '1':
				Lootable chest = new Lootable("Fire Wizard's Chest", new Inventory(), 1000);
				Item[] chestInv = {cList.chapter4Health, cList.chapter4Mana, cList.chapter4Poison, 
						cList.speed, cList.damageBoost, wList.floodStaff};
				chest.getInventory().addMulti(chestInv);
				breakLine();
				player.loot(chest, keyboard);
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
				+ "back to the castle and talk to Magnus the Wizard*\n", txtSpd);
		Dialogue.characterDialogue(wizName, "My god you made it back! Fire stone in hand as well! You truly "
				+ "must be strong if you were able to contend with the likes of the Golem! Thank you for retrieving "
				+ "the stone! This will do wonders to further my research! You will have to tell me about your "
				+ "journey sometime! For now though, you have definitely proven yourself worthy to contend in "
				+ "the Arena and hone your skills. Many high class merchants will also be eager to sell new "
				+ "powerful items to someone they know can wield their power. Take a look around the castle and "
				+ "see what new opportunities might open up! When you're ready, go talk to the King. He will "
				+ "definitely be impressed when I tell him what you have accomplished!\n", txtSpd);

		while (makingChoice) {
			Dialogue.infoDialogue("1) Will do thank you!\n" + "2) I will definintely have to check it out!\n", txtSpd);
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

	/*
	 * --------------------Chapter 4--------------------
	 */

	public static boolean mageDragonApproach(Player player, Scanner keyboard) {
		String wizName = "Magnus the King's wizard";
		int txtSpd = 25;
		Battle trollFight = new Battle(player, eList.troll);
		boolean isResponding;
		int pChoice;
		
		Dialogue.characterDialogue(wizName, "", txtSpd);
		Dialogue.characterDialogue(player.getName(), "", txtSpd);
		Dialogue.infoDialogue("", txtSpd);
		
		isResponding = true;
		while (isResponding) {
			Dialogue.infoDialogue("How do you respond? \n"
					+ "1) \n"
					+ "2) \n", txtSpd);
			pChoice = keyboard.next().charAt(0);
			switch (pChoice) {
			case '1':
				
				break;
			case '2':
				
				break;
			default:
				
				break;
			}
		}
			
		breakLine();
		Dialogue.characterDialogue(wizName, "So you intend on fighting Gilgemesh the Dragon huh? That is no small task "
				+ "to undertake! Gilgemesh is a fearsome beast that has terrorized our kingdom for decades. No adventurer, "
				+ "warior, or army we have sent to take him on has come back unscathed... or alive for that matter. I hope you "
				+ "understand the risk that you are taking. Are you sure you want to do this?\n", txtSpd);
		
		isResponding = true;
		while (isResponding) {
			Dialogue.infoDialogue("How do you respond? \n"
					+ "1) I have not come this far to give up now!\n"
					+ "2) If that is the case, I might need to think this over.\n", txtSpd);
			pChoice = keyboard.next().charAt(0);
			switch (pChoice) {
			case '1':
				Dialogue.characterDialogue(player.getName(), "I have not come this far to give up now!\n", txtSpd);
				isResponding = false;
				break;
			case '2':
				Dialogue.characterDialogue(player.getName(), "If that is the case, I might need to think this over.\n", txtSpd);
				Dialogue.characterDialogue(wizName, "That is a wise decision. If you decide you would like to persue the "
						+ "dragon in the future, you can always come back and speak to me.\n", txtSpd);
				return false;
			default:
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
			
		}
		
		Dialogue.characterDialogue(wizName, "Well if you are confident, I can't stop you. The best I can do to aid you "
				+ "is tell you everything I know about the dragon so you can be as prepared as possible. Gilgemesh is a ferocious "
				+ "beast with skin thick enough to take multiple blasts from the most powerful of magic weapons. I would advise keeping "
				+ "your guard up too. His claws aren't just for show. They can do serious damage if you let your guard down. He is "
				+ "also known to rain fire down upon the battlefield. The best you can hope for if he does is that you have a place to "
				+ "hide in time. Gilgemesh isn't the only dragon you have to worry about either. Gilgemesh is the father of multiple "
				+ "juvinile dragons that, if in the area, might run into the battle to aid their father. They, like their father, are "
				+ "powerful on their own and can cause some serious trouble. You won't have time to recover once you defeat them either. "
				+ "Before you reach Gilgemesh, you also might encounter a troll or two along the path. If you are attempting to take on "
				+ "Gilgemesh though, I assume you can handle the likes of them. \n", txtSpd);
		
		isResponding = true;
		while (isResponding) {
			Dialogue.infoDialogue("How do you respond? \n"
					+ "1) I appreciate the advice. I am as prepared as I will ever be. How do I get to the dragon?\n"
					+ "2) This sounds like more than I am ready for. Let me think about this for a bit.\n", txtSpd);
			pChoice = keyboard.next().charAt(0);
			switch (pChoice) {
			case '1':
				Dialogue.characterDialogue(player.getName(), "I appreciate the advice. I am as prepared as I will ever be. How do I get to the dragon?\n", txtSpd);
				isResponding = false;
				break;
			case '2':
				Dialogue.characterDialogue(player.getName(), "This sounds like more than I am ready for. Let me think about this for a bit.\n", txtSpd);
				Dialogue.characterDialogue(wizName, "That is a wise decision. If you decide you would like to persue the "
						+ "dragon in the future, you can always come back and speak to me.\n", txtSpd);
				return false;
			default:
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
		
		Dialogue.characterDialogue(wizName, "To get to Gilgemesh, you will need to assend Mount Doom. Gilgemesh lies "
				+ "at the top of the mountain, but along the path up to the top is trecherous and riddled with trolls. "
				+ "To reach Mount Doom, go to the main gate and turn west. The only mountain to the west is Mount doom. "
				+ "On the east side of the mountain, you should see the start of the path. Simply follow that path and it "
				+ "will lead you to Gilgemesh. I wish you luck brave adventurer. Only time will tell whether this journey is "
				+ "bravery or stupidity.\n", txtSpd);
		
		isResponding = true;
		while (isResponding) {
			Dialogue.infoDialogue("How do you respond? \n"
					+ "1) I assure you it is bravery. I will not fail! \n"
					+ "2) Thank you for the advice! I hope to see you soon.\n", txtSpd);
			pChoice = keyboard.next().charAt(0);
			switch (pChoice) {
			case '1':
				Dialogue.characterDialogue(player.getName(), "I assure you it is bravery. I will not fail! \n", txtSpd);
				isResponding = false;

				break;
			case '2':
				Dialogue.characterDialogue(player.getName(), "2) Thank you for the advice! I hope to see you soon.\n", txtSpd);
				isResponding = false;

				break;
			default:
				System.err.println("(Invalid choice. Please try again)");
				break;
			}
		}
			
			Dialogue.infoDialogue("*You venture to the main gate and turn west. That is when you see it. Mount Doom "
					+ "is in sight. The wizard's words ring in your ears. All the warnings he gave you and you can't "
					+ "help but feel a small amount of fear. Despite this, you venture onward, reaching the base "
					+ "of Mount Doom by mid-day. You begin up the path, climbing higher and higher. That is when "
					+ "you see it. One of the trolls the Wizard spoke of. You ready your weapon, prepared to take "
					+ "out any enemy that stands between you and the dragon!\n", txtSpd);
			
			if (!trollFight.startBattle(keyboard, true)) {
				return false;
			}
			
			Dialogue.infoDialogue("*With the troll at your feet, you venture on, climbing higher and higher. From "
					+ "the cliffsides of the mountain, you can see the entire kingdom and can't help but admire how "
					+ "small it looks from this distance. As you admire the view, you hear a ferocious roar as another "
					+ "troll comes barelling toward you. You prepare for yet another battle! \n", txtSpd);
			
			if (!trollFight.startBattle(keyboard, true)) {
				return false;
			}
			
			Dialogue.infoDialogue("*With another foe defeated, you climb higher. You can see the summit as you continue "
					+ "following the path. You hear Gilgemesh before you see him. The ground rumbles. You hear snarles coming from "
					+ "around the corner. You jump out and come face to face with the ferocious face of Gilgemesh. Flames passively "
					+ "escape his mouth and his claws break rock under each step. Gilgemesh snarles preparing to attack. You raise your "
					+ "weapon. This is it. The climax of your adventure. You prepare for the toughest battle yet!*", txtSpd);
			
		return true;
	}

	/*
	 * 
	 * ------------------------------Rogue Story
	 * Functions------------------------------
	 * 
	 */

	/*
	 * --------------------Chapter 1--------------------
	 */

	public static boolean rogueChapter1(Player player, Scanner keyboard) {
		boolean makingChoice = true;
		boolean playerWon = false;
		int txtSpd = 10, wait = 1000;

		breakLine();
		Dialogue.infoDialogue(
			"You step into the 'Black Veil Tavern', the door creaking loudly as you push it open. Inside, the air is heavy with the smell of spilled beer and musky patrons. "
			+ "The place is dimly lit, just a few candles flickering here and there. Groups of shady-looking people are scattered around, hunched over their drinks or arguing over a game of dice. "
			+ "In the corner, a man strums an out of tune fiddle but no one seems to pay him any mind. Every so often, the room bursts into laughter at someone’s drunken antics.\n",
			txtSpd
		);
		Pause.pause(wait);

		Dialogue.infoDialogue(
			"You make your way to the bar. Behind it, a big, gruff-looking bartender is polishing a glass, though it’s hard to tell if the rag he’s using is actually making it any cleaner. "
			+ "He glances at you, his one good eye sizing you up. Nearby, a drunk guy wobbles dangerously on his stool, mumbling to himself about something no one can understand.\n",
			txtSpd
		);

		Pause.pause(wait);

		Dialogue.characterDialogue("Barkeep",
			"Ah, a fresh face. You’ve got the look of someone who’s seen their share of shadows. I hope you can back that up."
			+ "We don’t get many fools here who can hold their own. You’ll need this if you want to survive in these parts.\n",
			txtSpd
		);
		Pause.pause(wait);

		Dialogue.infoDialogue(
			"The bartender reaches under the counter and pulls out a sleek dagger, its blade gleaming even in the dim tavern light.\n",
				txtSpd
		);
		Pause.pause(wait);

		player.getInventory().add(wList.starterDagger);
		Dialogue.infoDialogue("A starter dagger has been added to your inventory!\n", txtSpd);
		player.getInventory().getWeaponOnKey(wList.starterDagger.getKey()).displayInfo();

		Dialogue.characterDialogue("Barkeep",
			"Now, keep your wits about you. This place has its share of trouble, and not everyone knows when to leave well enough alone.\n",
			txtSpd
		);
		Pause.pause(wait);

		Dialogue.infoDialogue(
			"As the bartender finishes his sentence, the drunkard nearby lurches to his feet. His glass tumbles to the floor, shattering. "
			+ "He stumbles toward you, his bloodshot eyes narrowing as he sways unsteadily.\n",
			txtSpd
		);
		Pause.pause(wait);

		Dialogue.characterDialogue("Drunkard",
			"You! Fancy-lookin’ rogue! You think you’re better than me? Hah! Let’s see how tough you really are!\n",
			txtSpd
		);
		Pause.pause(wait);

		Dialogue.infoDialogue(
			"The drunkard swings wildly at you, his fists clenched. The bartender sighs and steps back, clearly unimpressed.\n",
			txtSpd
		);
		Pause.pause(wait);

		Dialogue.characterDialogue("Barkeep",
			"Well, don’t just stand there. Deal with him before he wrecks more of my place. Consider it your first test.\n",
			txtSpd
		);

		Battle tutorialBattle = new Battle(player, eList.drunkard);

		while (!playerWon) {
			playerWon = tutorialBattle.startBattle(keyboard, true);
			if (!playerWon) {
				player.setCurrHP(player.getHealth());
				tutorialBattle.getEnemy().setCurrHP(tutorialBattle.getEnemy().getHealth());
				tutorialBattle.setTurn(0);
				Dialogue.characterDialogue("Bartender",
					"Come on, kid. I gave you the tools; now show me you know how to use them.",
					txtSpd
				);
			}
		}

		breakLine();
		Dialogue.characterDialogue("Barkeep",
			"Not bad, kid. You’ve got some potential. That idiot won’t be bothering anyone for a while. Now listen closely.\n",
			txtSpd
		);
		Pause.pause(wait);

		Dialogue.characterDialogue("Barkeep",
			"If you’re serious about making a name for yourself, head to the castle. The King’s always looking for skilled adventurers. "
			+ "You might even pick up some decent coin. And if you live to tell the tale, come back here. There’s always work for a rogue who knows their way around trouble.\n",
			txtSpd
		);
		Pause.pause(wait);

		Dialogue.infoDialogue(
			"(As you battle enemies during your adventure, you will earn EXP after defeating them, the amount varying "
			+ "from enemy to enemy. Once you gain enough EXP, you will level up. Your stats will increase, "
			+ "and you will receive a skill point to spend on one of the class stats, or your luck stat. "
			+ "You can view your overall level, the level of each stat, how much EXP you need to level up again, "
			+ "and how many skill points you have available to spend all from your profile after the tutorial.)\n\n",
			txtSpd
		);

		while (makingChoice) {
			breakLine();
			Dialogue.characterDialogue("Barkeep",
				"1) Thanks for the advice. I’ll head to the castle.\n"
				+ "2) I’ll stick around. Might be more opportunities here.\n",
				txtSpd
			);
			char pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.characterDialogue(player.getName(),
						"Thanks for the advice. I’ll head to the castle.\n",
						txtSpd
					);
					Pause.pause(wait);
					makingChoice = false;
					break;

				case '2':
					breakLine();
					Dialogue.characterDialogue(player.getName(),
						"I’ll stick around. Might be more opportunities here.\n",
						txtSpd
					);
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


	/*
	 * --------------------Chapter 3--------------------
	 */

	public static boolean rogueSpecialMission(Player player, Scanner keyboard) {
		boolean makingChoice = true;
		boolean playerSucceeded;
		int txtSpd = 10, wait = 1000;
		String pName = player.getName();

		breakLine();
		Dialogue.infoDialogue(
				"As you approach, confusion sets in, your eyes must be deceiving you, right...? "
						+ "The bartender from the 'Black Veil Tavern' greets you with a beaming smile.\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue("Barkeep?",
				"Well come on now, don't look so surprised! A guy like me can't be on the king's court?. "
						+ "The name's Fenric and I AM the king's advisor, there are no laws against owning a bar, in case you were wondering. HAHAHA"
						+ "Besides, I like like keeping my ear close to the ground.\n",
				txtSpd);
		Pause.pause(wait);

		Dialogue.characterDialogue("Fenric, King's Advisor and Barkeep",
				"There’s a guy down in the undercity tunnels, calls himself the ‘Ravenblade'. "
						+ "He’s been stealing from guild shipments and had quite a few run-ins the king's guard. Word is, he’s hiding out in the old sewer tunnels. "
						+ "Everyone wants him gone, but no one wants to handle it. That's where you come in. I told them you might be the type to take care of business. What do you say?\n",
				txtSpd);

		while (makingChoice) {
			Dialogue.characterDialogue("Fenric, King's Advisor and Barkeep",
					"1) I’m in. Where do I find him?\n"
							+ "2) What’s in it for me?\n",
					txtSpd);
			char pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.characterDialogue(pName,
							"I’m in. Where do I find him?\n",
							txtSpd);
					Pause.pause(wait);
					makingChoice = false;
					break;

				case '2':
					breakLine();
					Dialogue.characterDialogue(pName,
							"What’s in it for me?\n",
							txtSpd);
					Pause.pause(wait);
					Dialogue.characterDialogue("Fenric, King's Advisor and Barkeep",
							"Aside from the coin lining the fools pockets? I heard he may have a rare weapon that I'm sure no one would be missing if you catch my drift. "
									+ "People will think twice before crossing you. So, you in or not?\n",
							txtSpd);
					break;

				default:
					Dialogue.infoDialogue("(Invalid choice. Try again.)\n", txtSpd);
					break;
			}
		}

		Dialogue.characterDialogue("Fenric, King's Advisor and Barkeep",
				"He’s holed up in the sewer tunnels. You’ll find the entrance near the old market district. Be careful, this one's no joke. "
						+ "I heard that the guy’s completely lost it... Good luck. Oh, and if you survive, your next drink’s on me.\n",
				txtSpd);

		Dialogue.infoDialogue(
				"You make your way to the undercity, the air gets damp and foul as you near the sewer entrance. "
						+ "The sound of dripping water echoes around you as you step inside. It’s dark, and the smell is awful, but you’ve dealt with worse.\n",
				txtSpd);

		makingChoice = true;
		while (makingChoice) {
			Dialogue.infoDialogue(
					"You see two paths ahead:\n"
							+ "1) Sneak through the shadows and avoid detection.\n"
							+ "2) Set off a diversion to draw out some of his lackeys.\n",
					txtSpd);
			char pChoice = keyboard.next().charAt(0);

			switch (pChoice) {
				case '1':
					breakLine();
					Dialogue.infoDialogue(
							"You stick to the shadows, moving silently. The flicker of torchlight gives you just enough visibility to dodge patrols. "
									+ "You make it deeper into the tunnels without raising the alarm.\n",
							txtSpd);
					makingChoice = false;
					break;

				case '2':
					breakLine();
					Dialogue.infoDialogue(
							"You knock over a stack of crates, sending them crashing to the ground. The noise draws a few guards away from the main area, leaving their posts unguarded. "
									+ "You slip past while they investigate.\n",
							txtSpd);
					makingChoice = false;
					break;

				default:
					Dialogue.infoDialogue("(Invalid choice. Try again.)\n", txtSpd);
					break;
			}
		}

		Dialogue.infoDialogue(
				"You reach the main chamber. The \"Ravenblade\" stands at the center, sharpening his weapon. He looks up, his eyes narrowing as he spots you.\n",
				txtSpd);

		Dialogue.characterDialogue("Crazed Maniac",
				"Who dares approach darkness?! I will show you the way! The truth of it all! Ahaha heeehehehehe\n",
				txtSpd);

		Dialogue.infoDialogue(
				"He brandishes his black, curved blade with a toothy grin.\n",
				txtSpd);

		Battle ravenbladeFight = new Battle(player, eList.ravenBlade);
		playerSucceeded = ravenbladeFight.startBattle(keyboard, true);

		if (!playerSucceeded) {
			Dialogue.infoDialogue("The lunatic was too much for you. Better luck next time.\n", txtSpd);
			return false;
		}

		Dialogue.infoDialogue(
				"The maniac collapses, his weapon falling to the ground. You feel a sense of triumph wash over you. "
						+ "You take a moment to catch your breath before grabbing his weapon and coin purse.\n",
				txtSpd);

		player.getInventory().add(wList.ravenBlade);
		Dialogue.infoDialogue("You’ve received the Raven Blade!\n", txtSpd);

		Dialogue.characterDialogue("Fenric, King's Advisor and Barkeep",
				"You’re back, and alive. That’s more than I expected, honestly. The king's happy and the guild’s happy, well done. "
						+ "Word of what happened is already spreading across town. Drinks are on me, at least for tonight.\n",
				txtSpd);

		return true;
	}


	/*
	 * --------------------Chapter 4--------------------
	 */

	public static boolean rogueDragonApproach(Player player, Scanner keyboard) {
		return true;
	}

	/*
	 * 
	 * ------------------------------Save & Load
	 * Functionality------------------------------
	 * 
	 */

	/**
	 * Takes and serializes Player object and stores it in a file to be reloaded
	 * later.
	 *
	 * @param player saved player
	 */
	public static void save(Player player) {
		try (FileOutputStream fileOut = new FileOutputStream("gameSave.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(player);
			System.out.println("Game saved successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads and deserializes Player object. Deserialized Player object is returned.
	 */
	public static Player load() {
		try (FileInputStream fileIn = new FileInputStream("gameSave.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			System.out.println("Game loaded successfully.");
            return (Player) in.readObject();
		} catch (Exception e) {
			System.out.println("No saved game found.");
		}
		return null;
	}

	/*
	 * 
	 * ------------------------------Helper Functions------------------------------
	 * 
	 */

	public static void breakLine() {
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");
	}

	public static Hub instantiateHub(Player player, String location) {

		
		// Chapter 1
		if (player.getChapter() == 1) {

			// Shopkeeper's text when you're in the shop
			ArrayList<String> s1txt = new ArrayList<String>();
			s1txt.add("I know I said no jokes... buuuuuut...");
			s1txt.add("Never seen you around before. You new? Did a friend recommend me to ya?");

			// Initialize the shopkeeper
			Shopkeeper shopkeeperCh1 = new Shopkeeper("Foolz, the Jester", new Inventory(),
					"Welcome! I can promise you there's no tricks here, just good, quality items!",
					"Thank you, thank you. Have a nice day, and tell all your friends about ol' Jester!",
					"Nice pick! Don't go using it for crimes! Not that I could stop you if you did, but still.", s1txt);

			// Add weapons to the shopkeeper's inventory
			Item[] items = { wList.bow2, wList.ironAxe, wList.rapier, wList.curveSword, wList.bow3, wList.bow4,
					wList.natureWand, wList.windTome, wList.waterTome, wList.fireTome, wList.fist1, wList.warScythe,
					wList.lightningWand, wList.bigAxe, wList.shortSpear, wList.longSpear, wList.ironSword, 
					cList.chapter1Health, cList.chapter1Mana, cList.chapter1Poison, cList.speed, cList.damageBoost };
			shopkeeperCh1.getInventory().addMulti(items);

			// Create the shop
			String shopNameCh1 = "Jester, the Town's 1st Shop";
			Shop ch1Shop = new Shop(player, shopkeeperCh1, shopNameCh1);

			// Create the ArrayList of enemies
			ArrayList<Enemy> ch1Enemies = new ArrayList<Enemy>();

			Enemy e1 = eList.wolf, e2 = eList.boar, e3 = eList.bear;
			ch1Enemies.add(e1);
			ch1Enemies.add(e2);
			ch1Enemies.add(e3);

			// Text while searching for enemies
			String[] ch1SearchTxt = { "Quite the lovely town this place is. Hopefully it stays that way...",
					"You look around to see the streets filled with bustling shops... how much money do you have again?",
					"Just outside of town, you find beautiful fields filled with all sorts of creatures. Thankfully, you haven't "
							+ "provoked one... yet." };

			// Create the hub
			Hub chapter1Hub = new Hub(player, location, ch1Shop, ch1Enemies, ch1SearchTxt);

			// Return the hub
			return chapter1Hub;

		}
		// Chapter 2
		if (player.getChapter() == 2) {

			// Shopkeeper's text when you're in the shop
			ArrayList<String> s2txt = new ArrayList<String>();
			s2txt.add("New around here? That's fine, take your time having a good look around.");
			s2txt.add(
					"Queensly's been around for a long time, you know. So we've got quite the vast collection of items.");
			s2txt.add(
					"You know, I've always considered adding various jewelry to our roster. If this place were an accessory shop, "
							+ "would that interest anyone you know?");

			// Initialize the shopkeeper
			Shopkeeper shopkeeperCh2 = new Shopkeeper("Aphrodite, Manager of Queensly", new Inventory(),
					"Oh? What brings you to this humble abode? Were you drawn here by the beauty of our wares? Or was it by my "
							+ "own natural good looks?",
					"Don't be a stranger, you hear? You're always welcome around here.",
					"Ooh, what an excellent choice.", s2txt);

			Item[] shopItems = { wList.ironSword, wList.waterTome, wList.bow5, wList.bow6, wList.bigSword, wList.bigAxe,
					wList.knightSpear, wList.elecAxe, wList.bDragAxe, wList.spikeFist, wList.strVirt, wList.bloodClaws,
					wList.ironHeartAmulet, wList.titansGauntlet, wList.colossusRing, wList.forceWand, 
					cList.chapter2Health, cList.chapter2Mana, cList.chapter2Poison, cList.speed, cList.damageBoost};
			shopkeeperCh2.getInventory().addMulti(shopItems);

			// Create the shop
			String shopNameCh2 = "Queensly, the Town's 2nd Shop";
			Shop ch2Shop = new Shop(player, shopkeeperCh2, shopNameCh2);

			// Create the ArrayList of enemies
			ArrayList<Enemy> ch2Enemies = new ArrayList<Enemy>();

			Enemy e1 = eList.criminal, e2 = eList.mercA, e3 = eList.thief, e4 = eList.ruffian;
			Item[] e1Loot = { wList.bow3, wList.spikeFist };
			Item[] e2Loot = { wList.pickAxe, wList.ironSword, wList.bow2 };
			Item[] e3Loot = { wList.waterTome, wList.bow4, wList.fist1, wList.curveSword, wList.knightSpear };
			Item[] e4Loot = { wList.fist1, wList.spikeFist };
			e1.getInventory().addMulti(e1Loot);
			e2.getInventory().addMulti(e2Loot);
			e3.getInventory().addMulti(e3Loot);
			e4.getInventory().addMulti(e4Loot);

			ch2Enemies.add(e1);
			ch2Enemies.add(e2);
			ch2Enemies.add(e3);
			ch2Enemies.add(e4);

			// Text while searching for enemies
			String[] ch2SearchTxt = {
					"From the castle windows, you can see the streets below, beautiful gardens, and several troops "
							+ "stationed on guard.",
					"The kingdom seems incredibly peaceful today." };

			// Create the hub
			Hub chapter2Hub = new Hub(player, location, ch2Shop, ch2Enemies, ch2SearchTxt);

			// Return the hub
			return chapter2Hub;

		}
		// Chapter 3
		if (player.getChapter() == 3) {

			ArrayList<String> s3txt = new ArrayList<String>();
			s3txt.add(
					"I like to make a little small talk with all of my newcomers to get to know them better. How about I start "
							+ "with myself? I, the honorable Kimbly who watches over this shop day and night, was once but a "
							+ "humble lad coming from a small town on the outskirts of-");
			s3txt.add(
					"Every day, I am glad that my mother sent me down the righteous path that I'm on! Believe it or not, but "
							+ "this very shop, Kingsly, used to be run by her! Yes, I remember it like it was yesterday. Though "
							+ "the wares weren't nearly as plentiful back then, but it was also a far different time. Adventurers "
							+ "weren't in the droves that they were nowadays and business was hardly-");
			s3txt.add(
					"Why just looking at you reminds me of the day when I used to be a knight for the kingdom. My father first "
							+ "gifted me a spectactular sword that I keep with me till this day- the Blade of Honor! I'll tell "
							+ "you, it is one of a kind! If it weren't for a weapon as illustrious and noble as this one, I might"
							+ "not have passed all the tests required to serve this kingdom and I might not be retired to where "
							+ "I can watch over the new generation of soon-to-be honorable-");

			Shopkeeper shopkeeperCh3 = new Shopkeeper("Honorable Kimbly", new Inventory(),
					"Welcome one and all to the revered store Kingsly, known far and wide as the kingdom's most famous shop for "
							+ "supplying its various adventurers, guards, and all else with only the most well kept, the most "
							+ "sturidest, and the most-",
					"Thank you, noble warrior, for the time and possibly money you've spent here at Kingsly! Remember, if you "
							+ "find yourself in need of a new tool for justful means, a new souvenir or gift to give to the "
							+ "missus, or something that you would proudly display in your home, the most revered shop in all-",
					"I see you've gone through with your purchase! Before you move on, might you all this man to take the time to "
							+ "tell you about the warranty offers that we have on all of our-",
					s3txt);

			Item[] shopItems = { wList.cloudburst, wList.stalSpear, wList.onyxSword, wList.floatingSword,
					wList.lionFist, wList.coffinClub, wList.flashpoint, wList.rubyCatalyst, wList.celestialRing,
					wList.crimsonPrism, wList.eqStaff, cList.chapter3Health, cList.chapter3Mana, cList.chapter3Poison, 
					cList.speed, cList.damageBoost };
			shopkeeperCh3.getInventory().addMulti(shopItems);

			String shopNameCh3 = "Kingsly, the Town's 3rd Shop";
			Shop ch3Shop = new Shop(player, shopkeeperCh3, shopNameCh3);

			ArrayList<Enemy> ch3Enemies = new ArrayList<Enemy>();
			Enemy e1 = eList.aWolf, e2 = eList.badKnight, e3 = eList.bigSnake, e4 = eList.mercB, e5 = eList.shaman,
					e6 = eList.orcRaider;
			Item[] e2Items = { wList.badSword, wList.bDragAxe };
			Item[] e4Items = { wList.bloodClaws, wList.bow8, wList.colossusRing, wList.knightSpear };
			Item[] e5Items = { wList.rubyCatalyst };
			Item[] e6Items = { wList.boneSword };

			e2.getInventory().addMulti(e2Items);
			e4.getInventory().addMulti(e4Items);
			e5.getInventory().addMulti(e5Items);
			e6.getInventory().addMulti(e6Items);

			ch3Enemies.add(e1);
			ch3Enemies.add(e2);
			ch3Enemies.add(e3);
			ch3Enemies.add(e4);
			ch3Enemies.add(e5);
			ch3Enemies.add(e6);

			String[] ch3SearchTxt = {
					"So far, the sights seem a bit borning... nothing out of the ordinary in the upper areas.",
					"There do seem to be a lot of interesting creatures on display here... is this a private zoo?",
					"Walking up and down these halls seems to be working up a sweat... maybe you should take a break "
							+ "and cool off." };

			Hub chapter3Hub = new Hub(player, location, ch3Shop, ch3Enemies, ch3SearchTxt);

			return chapter3Hub;
		}
		// Chapter 4
		if (player.getChapter() == 4) {

			ArrayList<String> s4txt = new ArrayList<String>();
			s4txt.add("What are you standing around for? I haven't got all day.");
			s4txt.add("We only sell the finest replicas here.");
			s4txt.add("You break it, you buy it. Watch what you touch.");

			Shopkeeper shopkeeperCh4 = new Shopkeeper("Big Boss Adan", new Inventory(),
					"Don't waste my time. Buy something, or get out.", "Hmph. See ya.", "...Good eye.", s4txt);
			String shopNameCh4 = "Aces High, the Town's 4th Shop";

			Item[] shopItems = { wList.requiem, wList.severance, wList.trickBlade, wList.graceGlory, wList.luBuSpear,
					wList.kingOath, wList.hellsFuryRing, wList.celestialCurseShard, wList.abyssalAmethest,
					wList.tsunamiScroll, wList.bow10, cList.chapter4Health, cList.chapter4Mana, cList.chapter4Poison, 
					cList.speed, cList.damageBoost};
			shopkeeperCh4.getInventory().addMulti(shopItems);
			Shop ch4Shop = new Shop(player, shopkeeperCh4, shopNameCh4);

			ArrayList<Enemy> ch4Enemies = new ArrayList<Enemy>();
			Enemy e1 = eList.warBear, e2 = eList.ryu, e3 = eList.fireKnight;
			
			Item[] e1Items = {wList.iceAxe, wList.ironAxe, wList.waterTome};
			Item[] e2Items = {wList.fist1};
			Item[] e3Items = {wList.hellsFuryRing, wList.bDragAxe};
			
			e1.getInventory().addMulti(e1Items);
			e2.getInventory().addMulti(e2Items);
			e3.getInventory().addMulti(e3Items);
			
			ch4Enemies.add(e1);
			ch4Enemies.add(e2);
			ch4Enemies.add(e3);
			
			String[] ch4SearchTxt = {
					"Reaching a place likes this means you're the elite of elites. Hope you feel that way.",
					"You start to wonder what food tastes like for people here out of hunger... perhpaps you should take a break?",
					"As you grow bored, you beg for something to happen... alas..."};

			Hub chapter4Hub = new Hub(player, location, ch4Shop, ch4Enemies, ch4SearchTxt);

			return chapter4Hub;
		}
		return null;
	}

}