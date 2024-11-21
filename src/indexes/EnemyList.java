package indexes;

import game.Enemy;
import game.Inventory;

public class EnemyList {

	// Constructor for enemy object:
	// (String) Name, (Inventory) Inventory, (int) Currency, (int) Health, (int)
	// Level, (int) Exp,
	// (int) Damage, (int) DamageType, (SpecialAttack) SpecialAttack, (String)
	// RegularAttack

	// *Note* Damage Type: 1 = Melee 2 = Ranged 3 = Mage 4 = Rogue 5 = Null

	private static SpAtkList spAtkList = new SpAtkList();

	// --------------------Chapter 1 Enemies--------------------

	public Enemy sheep = new Enemy("Sheep", new Inventory(), 25, 50, 1, 10, 5, 1, spAtkList.none,
			"Charges forward and headbutts you!");

	/** Blacksmith Jagatai - Tutorial fight for melee class. */
	public Enemy tutor1 = new Enemy("Blacksmith Jagatai", new Inventory(), 0, 65, 1, 100, 10, 1, spAtkList.none,
			" swings his sword with all his might.");

	// --------------------Chapter 2 Enemies--------------------

	// --------------------Chapter 3 Enemies--------------------

	public Enemy fireElemental = new Enemy("Fire Elemental", new Inventory(), 500, 1000, 15, 200, 200, 3,
			spAtkList.fireWall, "Brings its flaming fist down with murderous intent!");

	public Enemy fireRockGolem = new Enemy("Fire Elemental Rock Golem", new Inventory(), 1000, 1750, 20, 500, 400, 3,
			spAtkList.erruption, "Throws a flaming boulder of firey rock directly at you!");
	
	/** Encountered during melee's special mission */
	public Enemy goblin1 = new Enemy("Goblin Grunt", new Inventory(), 328, 460, 11, 70, 80, 1, spAtkList.none,
			" takes a stab at you with its dagger.");

	/** Encountered during melee's special mission */
	public Enemy goblin2 = new Enemy("Hobgoblin", new Inventory(), 555, 900, 15, 125, 115, 1, spAtkList.none,
			" slashes with the sharpened bone it calls a sword.");

	/** Melee Chapter 3 Boss */
	public Enemy goblinBoss = new Enemy("Champion Kioq", new Inventory(), 1200, 2200, 20, 2100, 200, 1,
			spAtkList.kioqSpAtk,
			" swings one of his axes down viciously, the ground cracking from the weapon just passing over it!");

	// --------------------Chapter 4 Enemies--------------------

	public Enemy dWar = new Enemy("Dragon Warrior", new Inventory(), 2000, 2000, 25, 1200, 150, 1, spAtkList.none,
			" slashes with its the warped glaive in its hands!");

	/*
	 * 
	 * --------------------Hub Enemies--------------------
	 * 
	 */
	
	/** Wolf - Simple enemy to be encountered */
	public Enemy wolf = new Enemy("Wolf", new Inventory(), 25, 50, 1, 15, 12, 1, spAtkList.none,
			" lunges forward and swipes its claws at its foe.");

}
