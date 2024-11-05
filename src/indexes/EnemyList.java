package indexes;

import game.Enemy;
import game.Inventory;

public class EnemyList {

	public static Enemy sheep = new Enemy("Sheep", new Inventory(), 25, 50, 1, 10, 5, 1, SpAtkList.none);

	/** Blacksmith Jagatai - Tutorial fight for melee class. */
	public static Enemy tutor1 = new Enemy("Blacksmith Jagatai", new Inventory(), 0, 65, 1, 10, 10, 1,
			SpAtkList.none);

}
