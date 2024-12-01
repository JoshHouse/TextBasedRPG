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

	/*
	 * Enables special attacks to the taken from the list of attacks and added to a
	 * enemy.
	 */
	private static SpAtkList spAtkList = new SpAtkList();

	/*
	 * 
	 * -----------------------------------HUB--------------------------------------
	 * The following enemies are meant to be added within the hub class to help
	 * simulate random encounters during grinding.
	 * ----------------------------------------------------------------------------
	 * 
	 */

	// ----------------------------- Chapter 1 Enemies -----------------------------

	/** Wolf - Common Enemy (Chapter 1) */
	public Enemy wolf = new Enemy("Wolf", new Inventory(), 25, 50, 1, 15, 12, 1, spAtkList.none,
			"The wolf lunges forward and swipes its claws at its foe.");

	/** Wild Boar - Common Enemy (Chapter 1) */
	public Enemy boar = new Enemy("Wild Boar", new Inventory(), 60, 80, 3, 30, 25, 1, spAtkList.none,
			"The horned pig rams you with its " + "tusks!");

	/** Grizzly Bear - Common Enemy (Chapter 1) */
	public Enemy bear = new Enemy("Grizzly Bear", new Inventory(), 120, 100, 5, 90, 44, 1, spAtkList.bearHug,
			"The grizzly bear swipes at you with its sharp claws!");

	// ----------------------------- Chapter 2 Enemies -----------------------------

	/** Wanted Criminal - Common Enemy (Chapter 2) */
	public Enemy criminal = new Enemy("Wanted Criminal", new Inventory(), 200, 319, 8, 140, 86, 1, spAtkList.none,
			"The criminal strikes you with their sword!");

	/** Pickpocket - Common Enemy (Chapter 2) */
	public Enemy thief = new Enemy("Pickpocket", new Inventory(), 750, 225, 7, 60, 70, 4, spAtkList.none,
			"The thief pokes at you relentlessly with its dagger");

	/** Independent Mercenary - Common Enemy (Chapter 2) */
	public Enemy mercA = new Enemy("Independent Mercenary", 400, 563, 10, 200, 105, 1, spAtkList.doubSlash,
			"The mercenary performs a skilled slash with their blade!");

	/** Ruffian - Common Enemy (Chapter 2) */
	public Enemy ruffian = new Enemy("Ruffian", 250, 440, 10, 150, 75, 1, spAtkList.none,
			"The ruffian strikes with a myriad of punches!");

	// ----------------------------- Chapter 3 Enemies -----------------------------

	/** Disgraced Knight - Common Enemy (Chapter 3) */
	public Enemy badKnight = new Enemy("Disgraced Knight", 800, 1500, 19, 777, 200, 1, spAtkList.none,
			"Raising its hand, the disgraced knight hits you with a powerful slice!");

	/** Alpha Wolf - Common Enemy (Chapter 3) */
	public Enemy aWolf = new Enemy("Alpha Wolf", 300, 1200, 14, 600, 89, 1, spAtkList.wolves,
			"The wolf swipes at you and bites each chance it gets!");

	/** Suspicious Shaman - Common Enemy (Chapter 3) */
	public Enemy shaman = new Enemy("Suspicious Shaman", 550, 900, 16, 852, 175, 3, spAtkList.mythic,
			"The shaman fires magical orbs ar you!");

	/** Orc Raider - Common Enemy (Chapter 3) */
	public Enemy orcRaider = new Enemy("Orc Raider", 750, 1800, 20, 1000, 160, 1, spAtkList.none,
			"The orc bashes you repeatedly with its club!");

	/** Giant Snake - Common Enemy (Chapter 3) */
	public Enemy bigSnake = new Enemy("Giant Snake", 400, 1600, 15, 1200, 125, 1, spAtkList.bite,
			"The snake whacks you with its large tail!");

	/** Bow-sworn Mercenary - Common Enemy (Chapter 3) */
	public Enemy mercB = new Enemy("Bow-Sworn Mercenary", 1200, 2000, 22, 913, 200, 2, spAtkList.none,
			"The mercenary shoots you with their bow!");

	// ----------------------------- Chapter 4 Enemies -----------------------------

	/** Street Fighter - Common Enemy (Chapter 4) */
	public Enemy ryu = new Enemy("Street Fighter", 2500, 2200, 28, 1987, 150, 1, spAtkList.shoryuken,
			"The fighter hits you with an amazing combo of punches and kicks!");

	/** Polar Bear Warrior - Common Enemy (Chapter 4) */
	public Enemy warBear = new Enemy("Polar Bear Warrior", 1650, 2647, 26, 2100, 264, 1, spAtkList.snowfall,
			"The bear warrior strikes you with its icy axe!");

	/** Knight of Pyromancy - Common Enemy (Chapter 4) */
	public Enemy fireKnight = new Enemy("Knight of Pyromancy", 3300, 3000, 30, 2001, 220, 3, spAtkList.paleFire,
			"The knights hold out his hand and shoots you with a fireball!");

	// ----------------------------------------------------------------------------------------------------------------

	/*
	 * 
	 * ---------------------------------TUTORIAL-----------------------------------
	 * The following enemies are meant to serve as tutorial fights for the players,
	 * and help them learn the mechanics.
	 * ----------------------------------------------------------------------------
	 * 
	 */

	public Enemy sheep = new Enemy("Sheep", new Inventory(), 25, 50, 1, 10, 5, 1, spAtkList.none,
			"The sheep charges forward and headbutts you!");

	/** Blacksmith Jagatai - Tutorial fight for melee class. */
	public Enemy tutor1 = new Enemy("Blacksmith Jagatai", new Inventory(), 0, 65, 1, 100, 10, 1, spAtkList.none,
			"Jagatai swings his sword with \"all\" his might.");

	// ----------------------------------------------------------------------------------------------------------------

	/*
	 * 
	 * -----------------------------CHAPTER SPECIFIC-------------------------------
	 * The following enemies are specific to each chapter, mostly for story reasons,
	 * and should only be employed in concerns to that chapter when necessary.
	 * ----------------------------------------------------------------------------
	 * 
	 */

	// --------------------Chapter 2 Special Enemies--------------------

	/** King's Mission Troll - Troll Boss for Chapter 2 */
	public Enemy grakthar = new Enemy("Grakthar the Troll", new Inventory(), 850, 1500, 18, 425, 350, 1, spAtkList.none,
			" swings his club with brutal force.");

	// --------------------Chapter 3 Special Enemies--------------------

	// --------------------MELEE---------------------

	/** Encountered during melee's special mission */
	public Enemy goblin1 = new Enemy("Goblin Grunt", new Inventory(), 328, 460, 11, 70, 80, 1, spAtkList.none,
			"The goblin takes a stab at you with its dagger.");

	/** Encountered during melee's special mission */
	public Enemy goblin2 = new Enemy("Hobgoblin", new Inventory(), 555, 900, 15, 125, 115, 1, spAtkList.none,
			"The hobgoblin slashes with the sharpened bone it calls a sword.");

	/** Melee Chapter 3 Boss */
	public Enemy goblinBoss = new Enemy("Champion Kioq", new Inventory(), 1200, 2200, 20, 5100, 200, 1,
			spAtkList.kioqSpAtk,
			"Kioq roars and swings one of his axes down viciously, the ground cracking from the weapon just passing over it!");

	// --------------------RANGED--------------------

	// ---------------------MAGE---------------------

	public Enemy fireElemental = new Enemy("Fire Elemental", new Inventory(), 500, 10000, 15, 200, 200, 3,
			spAtkList.fireWall, "The fire elemental brings its flaming fist down with murderous intent!");

	public Enemy fireRockGolem = new Enemy("Fire Elemental Rock Golem", new Inventory(), 1000, 20000, 20, 500, 400, 3,
			spAtkList.erruption, "The golem throws a flaming boulder of firey rock directly at you!");

	// ---------------------ROGUE--------------------

	// --------------------Chapter 4 Special Enemies--------------------

	public Enemy dWar = new Enemy("Dragon Warrior", new Inventory(), 2000, 2000, 25, 1200, 150, 1, spAtkList.none,
			"The dragon warrior slashes with its the warped glaive in its hands!");
	
	public Enemy troll = new Enemy("Troll", new Inventory(), 850, 1500, 18, 425, 350, 1, spAtkList.boulderToss,
			" swings his club with brutal force.");

	// ----------------------------------------------------------------------------------------------------------------

	/*
	 * 
	 * --------------------------------BOSS BATTLE---------------------------------
	 * The following enemies are used during the final boss battle of the game.
	 * ----------------------------------------------------------------------------
	 * 
	 */

	/** Gilgamesh the Dragon - Final Boss */
	public Enemy gilgemeshTheDragon = new Enemy("Gilgemesh the Dragon", new Inventory(), 5000, 30000, 30, 5000, 300, 5,
			spAtkList.hellFire,
			"With blazing speed and ferocity, Gilgemesh flap's his wings and soares toward you, and stabs you with his "
					+ "razor-sharp claws!");

	/** Juvenile Dragon - Final Boss's Minions */
	public Enemy gilgemeshsChildren = new Enemy("Juvenile Dragon", new Inventory(), 2000, 15000, 20, 1500, 150, 5,
			spAtkList.flameBreath,
			"With its biteforce rivaling the crushing power of a castle stone, the Juvenile Dragon clamps onto your arm, "
					+ "leaving serious damage in its wake!");

}
