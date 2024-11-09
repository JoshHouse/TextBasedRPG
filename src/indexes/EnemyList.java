package indexes;

import game.Enemy;
import game.Inventory;
import game.SpecialAttack;

public class EnemyList {
	
	// Constructor for enemy object:
	// (String) Name, (Inventory) Inventory, (int) Currency, (int) Health, (int) Level, (int) Exp, 
	// (int) Damage, (int) DamageType, (SpecialAttack) SpecialAttack, (String) RegularAttack
	
	// *Note* Damage Type:   1 = Melee   2 = Ranged   3 = Mage   4 = Rogue   5 = Null
	
	// --------------------Chapter 1 Enemies--------------------
	
	public Enemy sheep = new Enemy("Sheep", new Inventory(), 25, 50, 1, 10, 5, 1, SpAtkList.none, 
			"Charges forward and headbutts you!");

	/** Blacksmith Jagatai - Tutorial fight for melee class. */
	public Enemy tutor1 = new Enemy("Blacksmith Jagatai", new Inventory(), 0, 65, 1, 10, 10, 1,
			SpAtkList.none, "Swings sword with all his might!");
	
	// --------------------Chapter 2 Enemies--------------------
	
	// --------------------Chapter 3 Enemies--------------------
	
	// --------------------Chapter 4 Enemies--------------------

}
