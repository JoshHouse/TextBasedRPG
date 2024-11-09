package indexes;

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

	/** Short Spear */
	public Weapon spear1 = new Weapon("f003", "Short Spear",
			"A spear whose pole is shorter than the standard length, making it easier to use.", 1, 100, 20, 1, true);

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

	/** Greataxe */
	public Weapon axe3 = new Weapon("f008", "Greataxe",
			"A massive axe wielded proficiently by only the strongest of warriors.", 1, 300, 40, 1, true);

	/** Greatsword */
	public Weapon sword4 = new Weapon("f009", "Greatsword",
			"A massive broadsword often favored for it's heavy swings and strong attacks.", 1, 300, 35, 1, true,
			spAtk.gSlash);
	// --------------------Ranged Weapons--------------------
	
	// --------------------Magic Weapons--------------------
	/** Training Wand*/
	public Weapon starterWand = new Weapon("f201", "Training Wand", 
			"A wand favored by young mages to learn the ropes.", 1, 25, 15, 3,true, 10, spAtk.pBeam);
	
	// --------------------Rogue Weapons--------------------
	

}
