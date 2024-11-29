package indexes;

import game.Weapon;

public class WeaponList {

	// Constructor for Weapon Object:
	// (String) Key, (String) Name, (String) Info, (int) Rarity, (int) Value, (int)
	// Damage, (int) DamageType,
	// (Boolean) isSellable, (int) manaUsage, (SpecialAttack) SpecialAttack

	// *Note* DamageType: 1 = Melee 2 = Ranged 3 = Mage 4 = Rogue 5 = Null

	private static SpAtkList spAtk = new SpAtkList();

	// --------------------Null Weapon--------------------
	
	/** Weapon to represent no weapon **/
	public Weapon nullWeapon = new Weapon("0000", "No Weapon", "No Weapon", 0, 0, 0, 0, false, 0, spAtk.none);

	// --------------------Ranged Weapons--------------------

	/** Starter Bow */
	public Weapon bow1 = new Weapon("r001", "Starter Bow",
			"A simple wooden bow, often used by beginners. It's not the most powerful, but it's reliable for training.",
			1, 50, 10, 1, true);

	/** Shortbow */
	public Weapon bow2 = new Weapon("r002", "Shortbow",
			"A compact bow with a shorter range, favored by those who value speed over power.", 1, 100, 15, 1, true,
			spAtk.piercingShot);

	/** Longbow */
	public Weapon bow3 = new Weapon("r003", "Longbow",
			"A tall bow with a long range, capable of dealing significant damage at a distance.", 2, 300, 25, 1, true,
			spAtk.explosiveArrow);

	/** Frostbow */
	public Weapon bow4 = new Weapon("r004", "Frostbow",
			"A magical bow infused with the essence of ice. Each arrow fired chills the target to the bone.", 2, 400,
			22, 1, true, spAtk.frostbiteArrow);

	/** Composite Bow */
	public Weapon bow5 = new Weapon("r005", "Composite Bow",
			"An advanced bow crafted from multiple materials, offering a balance of speed and power.", 2, 500, 30, 1,
			true, spAtk.rainOfArrows);

	/** Emberstring */
	public Weapon bow6 = new Weapon("r006", "Emberstring",
			"A bow with a string that glows with fiery energy, igniting arrows as they are fired.", 3, 800, 40, 1, true,
			spAtk.flamingVolley);

	/** Phantom Bow */
	public Weapon bow7 = new Weapon("r007", "Phantom Bow",
			"A mystical bow crafted from ethereal materials. Its arrows are said to never miss their target.", 3, 1000,
			50, 1, true, spAtk.phantomArrow);

	/** Gale Bow */
	public Weapon bow8 = new Weapon("r008", "Gale Bow",
			"A bow imbued with the power of wind. Each arrow fired creates a powerful gust, pushing enemies back.", 3,
			900, 45, 1, true, spAtk.galeShot);

	/** Bow of the Phoenix */
	public Weapon bow9 = new Weapon("r009", "Bow of the Phoenix",
			"A legendary bow forged in phoenix fire. Each arrow ignites the battlefield in flames, burning enemies over time.",
			4, 1200, 60, 1, true, spAtk.flamingVolley);

	/** Starlight Bow */
	public Weapon bow10 = new Weapon("r010", "Starlight Bow",
			"A bow that glimmers with celestial light. It is said to be blessed by the stars themselves, striking true "
					+ "with every shot.",
			4, 1500, 70, 1, true, spAtk.phantomArrow);

	/*
	 * 
	 * --------------------Magic Weapons--------------------
	 *
	 */

	// --------------------Chapter 1--------------------

	/** Training Wand */
	public Weapon starterWand = new Weapon("f211", "Training Wand", "A wand favored by young mages to learn the ropes.",
			1, 25, 15, 3, true, 10, spAtk.pBeam);

	public Weapon windTome = new Weapon("f216", "Tome of Forceful Wind",
			"A spell tome used to channel mana, turning them into forceful winds!", 2, 60, 40, 3, true, 20,
			spAtk.windSlash);

	public Weapon earthTome = new Weapon("f217", "Tome of Earth",
			"A spell tome used to channel mana, moving the earth around you with devistating force!", 3, 70, 45, 3,
			true, 20, spAtk.massiveBoulder);

	// --------------------Chapter 2--------------------

	public Weapon tremorWand = new Weapon("f225", "Wand of Tremors",
			"A wand capable of channeling mana into the earth, making the entire ground shake as it moves the earth "
					+ "beneath the battlefield!",
			3, 180, 115, 3, true, 40, spAtk.doubleEarthWall);

	public Weapon flameWand = new Weapon("f226", "Wand of Scorching Flames",
			"A wand used to convert mana into blazing flames, scorching everything it touches!", 3, 200, 120, 3, true,
			45, spAtk.flamingTornados);

	public Weapon streamWand = new Weapon("f227", "Wand of Piercing Streams",
			"A wand that converts mana into highly pressurized, condensed streams of water capable of putting a hole "
					+ "through diamond itself!",
			3, 225, 125, 3, true, 50, spAtk.curvingSplitStream);

	// --------------------Chapter 3--------------------

	public Weapon tornadoStaff = new Weapon("f235", "Tornado Staff",
			"A staff capable of using mana to summon powerful tornados to disrupt the battlefield", 4, 750, 425, 3,
			true, 65, spAtk.motherOfAllTornados);

	public Weapon floodStaff = new Weapon("f236", "Flood Staff",
			"A staff used to convert mana into  insane amounts of water, washing away the battlefield, and your "
					+ "enemies along with it!",
			4, 800, 450, 3, true, 70, spAtk.doubleWave);

	public Weapon hellfireStaff = new Weapon("f237", "Hellfire Staff",
			"A staff used to summon the flames from the gates of hell themselves, leaving anything it touches as "
					+ "a pile of ash!",
			5, 1000, 500, 3, true, 75, spAtk.fireWall);

	// --------------------Chapter 4--------------------

	public Weapon apocolypseScroll = new Weapon("f245", "Scroll of the Apocolypse",
			"A scroll that teaches you the secrets of fire-based magic, allowing you to become one with the mana "
					+ "flowing through you, converting that mana into fire that rain's down from the heavens!",
			5, 3500, 1350, 3, true, 90, spAtk.impendingDoom);

	public Weapon hurricaneScroll = new Weapon("f246", "Scroll of the Hurricane",
			"A scroll that teaches you the secrets of wind-based magic, allowing you to become one with the mana "
					+ "flowing through you, converting that mana into hurricanes, utilizing the forces of mother-nature "
					+ "herself to destroy your opponents!",
			5, 3750, 1400, 3, true, 90, spAtk.eyeOfTheStorm);

	public Weapon canyonScroll = new Weapon("f247", "Scoll of Canyon Creation",
			"A scroll that teaches you the secrets of earth-based magic, allowing you to become one with the mana "
					+ "flowing through you, embewing that mana into the ground beneth you, allowing you to bend the earth "
					+ "to your will!",
			5, 4000, 1500, 3, true, 100, spAtk.straightToTheCore);

	// --------------------Rogue Weapons--------------------

	/*
	 * 
	 * -----------------------------------HUB--------------------------------------
	 * The following weapons are meant to be used when initiating a new hub object,
	 * meaning that the weapons listed will most likely added into shops to be
	 * brought by the player for a price.
	 * 
	 * The weapons are separated by chapter and class.
	 * ----------------------------------------------------------------------------
	 * 
	 */

	/*
	 * ---------------------------------Chapter 1----------------------------------
	 */

	// --------------------MELEE---------------------

	/** Iron Sword */
	public Weapon ironSword = new Weapon("f011", "Iron Sword",
			"A classic iron sword wielded by many fighters and warriors.", 1, 150, 19, 1, true);

	/** Iron Axe */
	public Weapon ironAxe = new Weapon("f012", "Iron Axe", "A classic iron axe wielded by many fighters and warriors.",
			1, 200, 24, 1, true);

	/** Short Spear */
	public Weapon shortSpear = new Weapon("f013", "Short Spear",
			"A spear whose pole is shorter than the standard length, making it easier to use.", 1, 100, 18, 1, true,
			spAtk.x3Thrust);

	/** Scimitar */
	public Weapon curveSword = new Weapon("f014", "Scimitar",
			"A curved sword commonly favored by bandits, thieves, and pirates, it's unique shape requiring great skill to use.",
			1, 150, 22, 1, true);

	/** Spear */
	public Weapon longSpear = new Weapon("f015", "Spear",
			"A standard spear commonly wielded by soldiers of the kingdom.", 1, 250, 29, 1, true);

	/** Rapier */
	public Weapon rapier = new Weapon("f016", "Rapier",
			"A thrusting sword. Lightweight and quick, this weapon is good for rapid attacks,\nbut has low base damage.",
			1, 180, 14, 1, true, spAtk.x3Thrust);

	/** Cestus */
	public Weapon fist1 = new Weapon("f017", "Cestus",
			"A battle gauntlet made with leather and metal studs. Perfect for some wanting to punch their way to victory.",
			1, 225, 20, 1, true);

	/** Greataxe */
	public Weapon bigAxe = new Weapon("f018", "Greataxe",
			"A massive axe wielded proficiently by only the strongest of warriors.", 2, 300, 40, 1, true, spAtk.gSlash);

	/** War Scythe */
	public Weapon warScythe = new Weapon("f019", "War Scythe",
			"A common farming tool attached to a polearm, turning it into a unique type of weapon. It inflicts the "
					+ "fear of death upon those who see it.",
			2, 500, 35, 1, true);

	// --------------------RANGED--------------------

	// ---------------------MAGE---------------------

	public Weapon natureWand = new Weapon("f212", "Nature Wand",
			"A wand used to channel the nature energy from your enviornment!", 1, 40, 25, 3, true, 15,
			spAtk.naturesGift);

	public Weapon lightningWand = new Weapon("f213", "Lightning Wand",
			"A wand capable of harnessing the power of electricity!", 2, 45, 30, 3, true, 15, spAtk.multiStrike);

	public Weapon fireTome = new Weapon("f214", "Tome of Fire",
			"A spell tome used to channel mana, turning them into deadly flames!", 2, 50, 35, 3, true, 20,
			spAtk.fireBall);

	public Weapon waterTome = new Weapon("f215", "Tome of Water",
			"A spell tome used to channel mana, turning them into powerful streams of water!", 2, 60, 40, 3, true, 20,
			spAtk.crushingWave);

	// ---------------------ROGUE--------------------

	/*
	 * ---------------------------------Chapter 2----------------------------------
	 */

	// --------------------MELEE---------------------

	/** Greatsword */
	public Weapon bigSword = new Weapon("f021", "Greatsword",
			"A massive broadsword often favored for it's heavy swings and strong attacks.", 2, 300, 55, 1, true,
			spAtk.gSlash);

	/** Kinght's Spear */
	public Weapon knightSpear = new Weapon("f011", "Knight's Spear", "A spear tailored for knights of the kingdom.", 1,
			500, 40, 1, true, spAtk.pSquare);

	/** Lightning Battle Axe */
	public Weapon elecAxe = new Weapon("f013", "Lightning Battle Axe",
			"A battle axe imbued with the power of lightning, allowing you to perform electrifying blows.", 2, 700, 44,
			1, true, spAtk.storm);

	/** Black Dragon's Halberd */
	public Weapon bDragAxe = new Weapon("f014", "Black Dragon's Halberd",
			"A long, heavy halberd made from the scales and hide of a black dragon.", 3, 1200, 100, 1, true,
			spAtk.dFire);

	/** Spiked Cestus */
	public Weapon spikeFist = new Weapon("f015", "Spiked Cestus", "A version of the cestus with spiked knuckles.", 1,
			440, 40, 1, true);

	/** Strenth & Virture */
	public Weapon strVirt = new Weapon("f016", "Stength & Virture",
			"A pair of twin swords carried oftenly by self-proclaimed holy knights.", 2, 600, 60, 1, true,
			spAtk.danceBlade);

	/** Bloodspiller */
	public Weapon bloodClaws = new Weapon("f017", "Bloodspiller",
			"A set of claws commonly used by assassins. Said to be sharper than any weapon, these weapons excel in "
					+ "cutting open flesh.",
			2, 850, 84, 1, true, spAtk.huntDog);

	// --------------------RANGED--------------------

	// ---------------------MAGE---------------------

	public Weapon ironHeartAmulet = new Weapon("f221", "Iron-Heart Amulet",
			"An amulet that allows you to channel your mana, creating formations of iron to send towards your enemies!",
			2, 100, 85, 3, true, 30, spAtk.bladeRain);

	public Weapon titansGauntlet = new Weapon("f222", "Silver-Titan's Gauntlet",
			"A gauntlet said to be forged by the titans, embewing your punches with mana, significantly increasing "
					+ "their effectiveness!",
			2, 125, 90, 3, true, 30, spAtk.heavyFist);

	public Weapon colossusRing = new Weapon("f223", "Silver-Colossus Ring",
			"A ring that channels the energy of colossus entities, using mana to release devistating waves of magical energy!",
			2, 150, 95, 3, true, 35, spAtk.colossusCrush);

	public Weapon forceWand = new Weapon("f224", "Wand of Unrelenting Force",
			"A wand that channels your magical energy, converting it into unrelenting winds, capable of sending your enemies "
					+ "flying!",
			2, 160, 100, 3, true, 35, spAtk.crushingWinds);

	// ---------------------ROGUE--------------------

	/*
	 * ---------------------------------Chapter 3----------------------------------
	 */

	// --------------------MELEE---------------------

	/** Cloudburst */
	public Weapon cloudburst = new Weapon("f031", "Cloudburst",
			"A recreation of a sword belonging to a famous swordsman callled the \"Cloudwalker\", famous for his "
					+ "flashy moves.",
			3, 1200, 280, 1, true, spAtk.floatCloud);

	/** Stallion Spear */
	public Weapon stalSpear = new Weapon("f0312", "Stallion Spear",
			"A silver spear where the spearhead has been fashioned in the likeness of a horse's head, replicating a golden "
					+ "spear once weld by a famous cavalryman",
			3, 2000, 282, 1, true, spAtk.pSquare);

	/** Onyx Greatsword */
	public Weapon onyxSword = new Weapon("f0313", "Onyx Greatsword",
			"An omninous black blade forged in unknown lands. It is said to contain disastrous power within.", 3, 2400,
			202, 1, true, spAtk.diver);

	/** Razor's Edge */
	public Weapon floatingSword = new Weapon("f0314", "Razor's Edge",
			"A mysterious sword that has the capability to float all on its own. Nobody knows who forged these blades, nor "
					+ "has their magic been replicated. While its damage is low, the special attack imbued within it is said "
					+ "to be uniquely destructive.",
			5, 4000, 117, 1, true, spAtk.swordOpera);

	/** Pride of the Beast King */
	public Weapon lionFist = new Weapon("f0315", "Pride of the Beast King",
			"A pair of cestus forged after the likeness of a lion's mane, a weapon used by only the most prideful brawlers.",
			4, 3000, 335, 1, true);

	/** Laughing Coffin */
	public Weapon coffinClub = new Weapon("f0316", "Laughing Coffin",
			"A large hammer made from a steel coffin. The hammer was made and popularized by a mercenary group of the same name"
					+ ", and every copy has their insignia- a laughing face- branded on the side of the coffin.",
			3, 4500, 400, 1, true);

	/** Flashpoint */
	public Weapon flashpoint = new Weapon("f0317", "Flashpoint",
			"A pair of claws imbued with electric magic. They're capable of summoning enough electricity to take "
					+ "down any beast.",
			3, 1800, 350, 1, true, spAtk.blink);

	// --------------------RANGED--------------------

	// ---------------------MAGE---------------------

	public Weapon rubyCatalyst = new Weapon("f231", "Ruby Catalyst",
			"A gauntlet infused with powerful ruby gemstones, embewing punches unprecidented magical energy!", 3, 550,
			325, 3, true, 55, spAtk.secondImpact);

	public Weapon celestialRing = new Weapon("f232", "Saphire Celestial Ring",
			"A ring infused with powerful saphire gemstones used to channel the power of the celestial entites themselves!",
			3, 600, 350, 3, true, 60, spAtk.celestialBeamRain);

	public Weapon crimsonPrism = new Weapon("f233", "Crimson Prism",
			"A prisim embewed with Crimson gemstones, used to convert the light energy of the sun into powerful beams "
					+ "of magical energy, burning a whole through anything it is pointed at!",
			3, 650, 375, 3, true, 60, spAtk.lightConvergence);

	public Weapon eqStaff = new Weapon("f234", "Earthquake Staff",
			"A staff capable of using magical energy to move the tectonic plates themselves, causing earthquakes throughout "
					+ "the battlefield!",
			3, 700, 400, 3, true, 65, spAtk.rockSlide);

	// ---------------------ROGUE--------------------

	/*
	 * ---------------------------------Chapter 4----------------------------------
	 */

	// --------------------MELEE---------------------

	/** Requiem */
	public Weapon requiem = new Weapon("f141", "Requiem",
			"A replica of the jet black war scythe wielded by a skeleton king. "
					+ "Even if it is just a remake, the gravelord's power resides within it, waiting for a worthy hand to "
					+ "draw it out.",
			5, 17500, 1250, 1, true, spAtk.graveyard);

	/** Severance */
	public Weapon severance = new Weapon("f142", "Severance",
			"A recreation of a pair of deadly claws wielded by a woman nicknamed \"Predator\", one of the most fearsome and "
					+ "ruthless assassins of the past century. Though but a replica, her techniques still slumber within.",
			5, 145000, 1026, 1, true, spAtk.nightRaid);

	/** Trickster's Ace */
	public Weapon trickBlade = new Weapon("f143", "Trickster's Ace", "A recreation of a slender blade carried by the "
			+ "\"Gentleman Thief\", a man skilled in trickery and fighting. The replica is said to be sturdier than the "
			+ "original was.", 5, 10000, 1000, 1, true);

	/** Grace & Glory */
	public Weapon graceGlory = new Weapon("f144", "Grace & Glory",
			"Replicas of a pair of swords wield by the \"Golden Gladiator\", one of the greatest swordsman of the decade. His"
					+ " skills were unrivaled, a fraction of them embedding themselves into each replica.",
			5, 16000, 800, 1, true, spAtk.autumn);

	/** Sky Piercer */
	public Weapon luBuSpear = new Weapon("f145", "Sky Piercer",
			"A recreation of a halberd wielded by the man known as the \"Flying Genera\". Though it is impossible to accurately"
					+ " create the power that he possessed, the replica is capable of outputting a fraction of it as its "
					+ "legacy even lives on through replicas.",
			5, 20000, 1330, 1, true, spAtk.sBomb);

	/** Oath of Kings */
	public Weapon kingOath = new Weapon("f146", "Oath of Kings",
			"A recreation of a golden blade weld by the \"Venerable Paladin\". The golden sheen of even the replica is capable"
					+ "of subjecting one's foes to the power of pure gold.",
			5, 20000, 1300, 1, true, spAtk.goldWave);

	// --------------------RANGED--------------------

	// ---------------------MAGE---------------------

	public Weapon hellsFuryRing = new Weapon("f241", "Onyx Ring of Hell's Fury",
			"A ring embewed with Onyx gemstones, summoning the fury of hell itself upon your enemies!", 3, 2500, 1150,
			3, true, 80, spAtk.demonStrike);

	public Weapon celestialCurseShard = new Weapon("f242", "Diamond Shard of Celestial Curse",
			"A shard that, when embewed with mana, channels the anger and wrath of the Gods, unleashing it upon your enemies!",
			4, 2750, 1200, 3, true, 80, spAtk.heavensRage);

	public Weapon abyssalAmethest = new Weapon("f243", "Abyssal Amethest",
			"An amethyst gemstone, enchanted to use mana to summon the wrath of the mythical beasts from the deapths of "
					+ "the abyss!",
			4, 3000, 1250, 3, true, 85, spAtk.eternalDarkness);

	public Weapon tsunamiScroll = new Weapon("f244", "Scroll of the Tsunami",
			"A scroll that teaches you the secrets of water-based magic, allowing you to become one with the mana flowing "
					+ "through you, and converting that mana directly into massive waves of water capable of destroying entire "
					+ "kingdoms in one attack!",
			5, 3250, 1300, 3, true, 85, spAtk.weightOfTheDepths);

	// ---------------------ROGUE--------------------

	// ----------------------------------------------------------------------------------------------------------------

	/*
	 * 
	 * ---------------------------------ENEMIES------------------------------------
	 * The following weapons are meant to be used when adding items to an enemy's
	 * inventory, as these are weapons that can be looted after combat from certain
	 * enemies.
	 * ----------------------------------------------------------------------------
	 * 
	 */

	// --------------------MELEE---------------------

	/** War Pick */
	public Weapon pickAxe = new Weapon("f161", "War Pick",
			"A type of pick-axe designed to use in battle rather than for mining. Commonly used by horseback riders.",
			1, 300, 30, 1, true);

	/** Boneblade */
	public Weapon boneSword = new Weapon("f162", "Boneblade",
			"A wickedly shaped sword fashioned from a sharpened bone. Weapons like these are"
					+ "primarily used by hostile creatures capable of wielding weapons, like trolls, or goblins.",
			2, 100, 35, 1, true);

	/** Disgraced Knight's Sword */
	public Weapon badSword = new Weapon("f163", "Disgraced Knight's Sword",
			"Swords wielded by disgraced knights, containing an unholy power within them.", 3, 1600, 155, 1, true,
			spAtk.none);

	/** Glacial Hatchet */
	public Weapon iceAxe = new Weapon("f164", "Glacial Hatchet",
			"A battle axe that many warrior bears seem to enjoy using, containing a glacial power within it", 3, 1500,
			200, 1, true, spAtk.iceStomp);

	// --------------------RANGED--------------------

	// ---------------------MAGE---------------------

	// ---------------------ROGUE--------------------

	// ----------------------------------------------------------------------------------------------------------------

	/*
	 * 
	 * ---------------------------------SPECIAL------------------------------------
	 * The following weapons are meant to be specifically obtained during special
	 * events. This could be a specific tutorial weapon, the class specific weapons
	 * earned after completing chapter 3, or special weapons meant to be gotten
	 * elsewhere other than a shop or by looting.
	 * ----------------------------------------------------------------------------
	 * 
	 */

	// --------------------MELEE---------------------

	/** Phoenix Cleaver */
	public Weapon axe4 = new Weapon("f014", "Phoenix Cleaver",
			"A golden greataxe that is nearly 7 feet long. It's adorned with silver plating on the side of the blade,"
					+ " resembling the body of a phoenix. This weapon was taken from the goblin champion, who had "
					+ "taken it from the father of the knight Adicai.",
			4, 878, 1, spAtk.phoenix);

	// --------------------RANGED--------------------

	// ---------------------MAGE---------------------

	// ---------------------ROGUE--------------------

}
