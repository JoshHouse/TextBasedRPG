package indexes;

import game.Enemy;
import game.Inventory;

public class EnemyList {
	
	// Constructor for enemy object:
	// (String) Name, (Inventory) Inventory, (int) Currency, (int) Health, (int) Level, (int) Exp, 
	// (int) Damage, (int) DamageType, (SpecialAttack) SpecialAttack, (String) RegularAttack
	
	// *Note* Damage Type:   1 = Melee   2 = Ranged   3 = Mage   4 = Rogue   5 = Null
	
	private static SpAtkList spAtkList = new SpAtkList();
	
	// --------------------Chapter 1 Enemies--------------------
	
	public Enemy sheep = new Enemy("Sheep", new Inventory(), 25, 50, 1, 10, 5, 1, spAtkList.none, 
			"Charges forward and headbutts you!");

	/** Blacksmith Jagatai - Tutorial fight for melee class. */
	public Enemy tutor1 = new Enemy("Blacksmith Jagatai", new Inventory(), 0, 65, 1, 10, 10, 1,
			spAtkList.none, "Swings sword with all his might!");
	
	// --------------------Chapter 2 Enemies--------------------
	
	// --------------------Chapter 3 Enemies--------------------
	
	public Enemy fireElemental = new Enemy("Fire Elemental", new Inventory(), 500, 1000, 15, 200, 200,
			3, spAtkList.none, "Brings its flaming fist down with murderous intent!");
	
	public Enemy fireRockGolem = new Enemy("Fire Elemental Rock Golem", new Inventory(), 1000, 1750, 20, 500, 400,
			3, spAtkList.none, "Throws a flaming boulder of firey rock directly at you!");
	// --------------------Chapter 4 Enemies--------------------

}
