package indexes;

import game.SpecialAttack;
import game.Weapon;

public class WeaponList {
	
	// Constructor for Weapon Object:
	// (String) Key, (String) Name, (String) Info, (int) Rarity, (int) Value, (int) Damage, (int) DamageType, 
	// (Boolean) isSellable, (int) manaUsage, (SpecialAttack) SpecialAttack
	
	// *Note* DamageType:    1 = Melee   2 = Ranged   3 = Mage   4 = Rogue   5 = Null

	private static SpAtkList spAtk = new SpAtkList();
	
	// --------------------Melee Weapons--------------------
	/** Iron Sword */
	public Weapon sword1 = new Weapon("f001", "Iron Sword",
			"A classic iron sword wielded by many fighters and warriors.", 1, 150, 19, 1, true);

	/** Iron Axe */
	public Weapon axe1 = new Weapon("f002", "Iron Axe", "A classic iron axe wielded by many fighters and warriors.", 1,
			200, 24, 1, true);

	// String key, String name, String info, int rarity, int inputValue, int damage, int dmgType,
	// Boolean inputIsSellable, int manaUsage, SpecialAttack spAtk
	/** Short Spear */
	public Weapon spear1 = new Weapon("f003", "Short Spear",
			"A spear whose pole is shorter than the standard length, making it easier to use.", 1, 100, 18, 1,true,
			spAtk.x3Thrust);

	/** Scimitar */
	public Weapon sword2 = new Weapon("f004", "Scimitar",
			"A curved sword commonly favored by bandits, thieves, and pirates, it's unique shape requiring\ngreat skill to use.",
			1, 150, 22, 1, true);

	/** Spear */
	public Weapon spear2 = new Weapon("f005", "Spear", "A standard spear commonly wielded by soldiers of the kingdom.",
			1, 250, 29, 1, true);

	/** War Pick */
	public Weapon axe2 = new Weapon("f006", "War Pick",
			"A type of pick-axe designed to use in battle rather than for mining. Commonly used by horseback\nriders.",
			1, 300, 30, 1, true);

	/** Rapier */
	public Weapon sword3 = new Weapon("f007", "Rapier",
			"A thrusting sword. Lightweight and quick, this weapon is good for rapid attacks,\nbut has low base damage.",
			1, 180, 14, 1, true, spAtk.x3Thrust);

	/** Cestus */
	public Weapon fist1 = new Weapon("f008", "Cestus",
			"A battle gauntlet made with leather and metal studs. Perfect for some wanting to punch their way to victory.",
			1, 225, 20, 1, true);

	/** Greataxe */
	public Weapon axe3 = new Weapon("f009", "Greataxe",
			"A massive axe wielded proficiently by only the strongest of warriors.", 2, 300, 40, 1, true);

	/** Greatsword */
	public Weapon sword4 = new Weapon("f010", "Greatsword",
			"A massive broadsword often favored for it's heavy swings and strong attacks.", 2, 300, 35, 1, true,
			spAtk.gSlash);

	/** Kinght's Spear */
	public Weapon spear3 = new Weapon("f011", "Knight's Spear", "A spear tailored for knights of the kingdom.", 2, 500,
			38, 1, true, spAtk.pSquare);

	/** Boneblade */
	public Weapon sword5 = new Weapon("f012", "Boneblade",
			"A wickedly shaped sword fashioned from a sharpened bone. Weapons like these are\n"
					+ "primarily used by hostile creatures capable of wielding weapons, like trolls,\n or goblins.",
			2, 100, 35, 1, true, spAtk.none);
	
	/** Cloudburst */
	public Weapon sword6 = new Weapon("f013", "Cloudburst", "A recreation of a sword belonging to a famous swordsman callled"
			+ " the \"Cloudwalker\", famous\nfor his flashy moves.", 3, 1200, 68, 1, true, spAtk.floatCloud);

	/** Phoenix Cleaver*/
	public Weapon axe4 = new Weapon("f014", "Phoenix Cleaver",
			"A golden greataxe that is nearly 7 feet long. It's adorned with silver\nplating on the side of the blade,"
			+ " resembling the body of a phoenix. This weapon was taken from the goblin champion, who\nhad taken it from"
			+ " the father of the knight Adicai.", 4, 120, 1, spAtk.phoenix);

	// --------------------Ranged Weapons--------------------
	
	/** Starter Bow */
	public Weapon bow1 = new Weapon("r001", "Starter Bow", 
	        "A simple wooden bow, often used by beginners. It's not the most powerful, but it's reliable for training.", 
	        1, 50, 10, 1, true);

	/** Shortbow */
	public Weapon bow2 = new Weapon("r002", "Shortbow", 
	        "A compact bow with a shorter range, favored by those who value speed over power.", 
	        1, 100, 15, 1, true, spAtk.piercingShot);

	/** Longbow */
	public Weapon bow3 = new Weapon("r003", "Longbow", 
	        "A tall bow with a long range, capable of dealing significant damage at a distance.", 
	        2, 300, 25, 1, true, spAtk.explosiveArrow);

	/** Frostbow */
	public Weapon bow4 = new Weapon("r004", "Frostbow", 
	        "A magical bow infused with the essence of ice. Each arrow fired chills the target to the bone.", 
	        2, 400, 22, 1, true, spAtk.frostbiteArrow);

	/** Composite Bow */
	public Weapon bow5 = new Weapon("r005", "Composite Bow", 
	        "An advanced bow crafted from multiple materials, offering a balance of speed and power.", 
	        2, 500, 30, 1, true, spAtk.rainOfArrows);

	/** Emberstring */
	public Weapon bow6 = new Weapon("r006", "Emberstring", 
	        "A bow with a string that glows with fiery energy, igniting arrows as they are fired.", 
	        3, 800, 40, 1, true, spAtk.flamingVolley);

	/** Phantom Bow */
	public Weapon bow7 = new Weapon("r007", "Phantom Bow", 
	        "A mystical bow crafted from ethereal materials. Its arrows are said to never miss their target.", 
	        3, 1000, 50, 1, true, spAtk.phantomArrow);

	/** Gale Bow */
	public Weapon bow8 = new Weapon("r008", "Gale Bow", 
	        "A bow imbued with the power of wind. Each arrow fired creates a powerful gust, pushing enemies back.", 
	        3, 900, 45, 1, true, spAtk.galeShot);

	/** Bow of the Phoenix */
	public Weapon bow9 = new Weapon("r009", "Bow of the Phoenix", 
	        "A legendary bow forged in phoenix fire. Each arrow ignites the battlefield in flames, burning enemies over time.", 
	        4, 1200, 60, 1, true, spAtk.flamingVolley);

	/** Starlight Bow */
	public Weapon bow10 = new Weapon("r010", "Starlight Bow", 
	        "A bow that glimmers with celestial light. It is said to be blessed by the stars themselves, striking true with every shot.", 
	        4, 1500, 70, 1, true, spAtk.phantomArrow);

	
	
	// --------------------Magic Weapons--------------------
	/** Training Wand*/
	public Weapon starterWand = new Weapon("f201", "Training Wand", 
			"A wand favored by young mages to learn the ropes.", 1, 25, 15, 3,true, 10, spAtk.pBeam);
	
	public Weapon fireStaff = new Weapon("f250", "Fire Staff", 
			"A powerful magic weapon forged by the Great Fire Mage with the power to take down "
			+ "castle walls in one blow!", 5, 1000, 500, 3, true, 75, spAtk.fireWall);
	
	// --------------------Rogue Weapons--------------------
	
	
	/*
	 * 
	 * --------------------Hub Weapons--------------------
	 * 
	 */
	
	/*
	 * --------------------Chapter 1 Hub--------------------
	 */
	
	// --------------------Melee Weapons--------------------
	
	// --------------------Ranged Weapons--------------------
	
	// --------------------Mage Weapons--------------------
	
	// --------------------Rogue Weapons--------------------
	
	
	/*
	 * --------------------Chapter 2 Hub--------------------
	 */
	
	// --------------------Melee Weapons--------------------
	
	// --------------------Ranged Weapons--------------------
	
	// --------------------Mage Weapons--------------------
	
	// --------------------Rogue Weapons--------------------
	
	
	/*
	 * --------------------Chapter 3 Hub--------------------
	 */
	
	// --------------------Melee Weapons--------------------
	
	// --------------------Ranged Weapons--------------------
	
	// --------------------Mage Weapons--------------------
	
	// --------------------Rogue Weapons--------------------
	
}
