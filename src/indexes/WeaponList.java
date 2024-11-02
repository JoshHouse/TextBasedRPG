package indexes;

import game.Weapon;

public class WeaponList {

	private SpAtkList spAtk = new SpAtkList();

	/** Iron Sword */
	public Weapon sword1 = new Weapon("w001", "Iron Sword",
			"A classic iron sword wielded by many fighters and warriors.", 1, 150, 19, 1, true);

	/** Iron Axe */
	public Weapon axe1 = new Weapon("w002", "Iron Axe", "A classic iron axe wielded by many fighters and warriors.", 1,
			200, 24, 1, true);

	/** Short Spear */
	public Weapon spear1 = new Weapon("w003", "Short Spear",
			"A spear whose pole is shorter than the standard length, making it easier to use.", 1, 100, 20, 1, true);

	/** Scimitar */
	public Weapon sword2 = new Weapon("w004", "Scimitar",
			"A curved sword commonly favored by bandits, thieves, and pirates, it's unique shape requiring\ngreat skill to use.",
			1, 150, 22, 1, true);

	/** Spear */
	public Weapon spear2 = new Weapon("w005", "Spear", "A standard spear commonly wielded by soldiers of the kingdom.",
			1, 250, 29, 1, true);

	/** War Pick */
	public Weapon axe2 = new Weapon("w006", "War Pick",
			"A type of pick-axe designed to use in battle rather than for mining. Commonly used by horseback\nriders.",
			1, 300, 30, 1, true);

}