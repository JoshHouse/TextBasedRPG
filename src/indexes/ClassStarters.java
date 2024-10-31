package indexes;

import game.Player;

public class ClassStarters {

	private static final int STARTER_HP = 150;
	private static final int STARTER_MONEY = 200;
	private static final int STARTER_LUCK = 15;

	/**
	 * Starting information of the Fighter class. The Fighter class scales best with
	 * heavy melee weapons such as swords, spears, and axes. This class also starts
	 * with the highest HP stat than any other class, but very low Mana.
	 */
	private static final Player FIGHTER = new Player("Fighter Class", (int) (STARTER_HP + (STARTER_HP * 0.5)), 1, 0,
			STARTER_MONEY, 7, 2, 1, 1, STARTER_LUCK, 10);

	/**
	 * Starting information of the Archer class. The Archer class scales best with
	 * bows and some throwable items. This class also employs the use of arrows for
	 * their bows, allowing them to deal various types of damage with a variety of
	 * arrows.
	 */
	private static final Player ARCHER = new Player("Archer Class", STARTER_HP, 1, 0, STARTER_MONEY, 1, 6, 3, 1,
			STARTER_LUCK, 30);

	/**
	 * Starting information of the Rogue class. The Rouge class scales best with
	 * daggers and throwable items, and starts off with a higher luck stat than
	 * other classes.
	 */
	private static final Player ROGUE = new Player("Rogue Class", STARTER_HP, 1, 0, STARTER_MONEY, 3, 2, 5, 1,
			(STARTER_LUCK * 2), 15);

	/**
	 * Starting information of the Mage class. The Mage class scales best with magic
	 * items and weapons, and has the highest starting Mana out of any class, but
	 * lower HP.
	 */
	private static final Player MAGE = new Player("Mage Class", (STARTER_HP - 50), 1, 0, STARTER_MONEY, 1, 1, 1, 8,
			STARTER_LUCK, 100);

	/**
	 * Initializes a new player at the start of a new game, using the base values of
	 * the requested class. This method also assigns the starting weapons to the
	 * chosen class when requested. The first weapon added to the class will also be
	 * the weapon initially equipped to use.
	 * 
	 * @param starter - A char variable representing the class that the player
	 *                chose. This variable controls a switch statement to return the
	 *                selected class.
	 * @param name    - The player's name. Replaces the demo name of the starting
	 *                class with the name the player has entered.
	 * @return Returns the selected class with all of the starting equipment.
	 */
	public static Player newPlayer(char starter, String name) {
		WeaponList wList = new WeaponList();

		switch (starter) {

		case '1':
			FIGHTER.setName(name);
			FIGHTER.getInventory().add(wList.ironSword);
			FIGHTER.setEquipped(FIGHTER.getInventory().getWeapons().getFirst());
			return FIGHTER;
		case '2':
			return ARCHER;
		case '3':
			return ROGUE;
		case '4':
			return MAGE;
		default:
			return null;

		}

	}

}
