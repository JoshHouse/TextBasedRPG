package indexes;

import game.Weapon;

public class WeaponList {

	SpAtkList spAtk = new SpAtkList();

	/** Iron Sword */
	public Weapon ironSword = new Weapon('w', "Iron Sword", "A common iron blade used by many fighters.", 1, 150, 26, 1,
			true, 0, spAtk.none);

	/** Iron Axe */
	public Weapon ironAxe = new Weapon('w', "Iron Axe", "A common one-handed axe used by many fighters.", 1, 150, 33, 1,
			true, 0, spAtk.none);

	/** Scimitar */
	public Weapon scimitar = new Weapon('w', "Scimitar",
			"A curved sword that is favored by bandits and other criminals.", 1, 100, 26, 1, true, 0, spAtk.none);
	/** War Hammer */
	public Weapon warHammer = new Weapon('w', "War Hammer",
			"A large, metal hammer that is often wielded by men of great stature.", 1, 200, 40, 1, true, 0,
			spAtk.smash);

	/** Scythe */
	public Weapon scythe = new Weapon('w', "Scythe", "A weapon that's normally used by farmers for harvesting.", 1,
			100, 37, 1, true, 0, spAtk.none);

	/** Spear */
	public Weapon spear = new Weapon('w', "Spear",
			"A polearm usually wielded by various knights and guards in the kingdom.", 1, 200, 30, 1, true, 0,
			spAtk.thrust);

	/** Pike */
	public Weapon pike = new Weapon('w', "Pike",
			"A polearm favored by elite warriors and knights, wielded in both hands due to it's size.", 2, 400, 48, 1,
			true, 0, spAtk.spinSlash);

	/** Greatsword */
	public Weapon greatSword = new Weapon('w', "Greatsword", "A large sword wielded by many strong fighters.", 2, 350, 49,
			1, true, 0, spAtk.smash);

	/** Greataxe */
	public Weapon greatAxe = new Weapon('w', "Greataxe", "A large axe that is commonly wielded by barbarians.", 2, 450,
			55, 1, true, 0, spAtk.spinSlash);

	/** Glaive */
	public Weapon glaive = new Weapon('w', "Glaive",
			"A polearm requiring great skill to master, and does not see much common use among warriors. Beware those that"
					+ "\nare skilled enough to wield these weapons.",
			2, 600, 60, 1, true, 0, spAtk.doubleSlash);

	/** Rapier */
	public Weapon rapier = new Weapon('w', "Rapier",
			"An elegant straight sword commonly used to perform thrusting attacks.", 2, 250, 40, 1, true, 0,
			spAtk.triThrust);
	
	/** Knight's Longsword */
	public Weapon kSword = new Weapon('w', "Knight's Longsword",
			"The standard issued weapon carried by the servants of the king.", 2, 500, 55, 1, true, 0, spAtk.none);

}
