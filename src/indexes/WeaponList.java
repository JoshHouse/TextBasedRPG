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
	
	// starter bow /
	public Weapon starterBow = new Weapon("f101", "Training Bow", 
			"A simple wood bow for young archers.", 1, 25, 20, 2, true);
	
	
	
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
