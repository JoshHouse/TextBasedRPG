package indexes;

import game.SpecialAttack;
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

	// String key, String name, String info, int rarity, int inputValue, int damage, int dmgType,
	// Boolean inputIsSellable, int manaUsage, SpecialAttack spAtk
	/** Short Spear */
	public Weapon spear1 = new Weapon("f003", "Short Spear",
			"A spear whose pole is shorter than the standard length, making it easier to use.", 1, 100, 18, 1,true,
			spAtk.x3Thrust);

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

	/** Cestus */
	public Weapon fist1 = new Weapon("f008", "Cestus",
			"A battle gauntlet made with leather and metal studs. Perfect for some wanting to punch their way to victory.",
			1, 225, 20, 1, true);

	/** Greataxe */
	public Weapon axe3 = new Weapon("f009", "Greataxe",
			"A massive axe wielded proficiently by only the strongest of warriors.", 2, 300, 40, 1, true);

	/** Greatsword */
	public Weapon sword4 = new Weapon("f010", "Greatsword",
			"A massive broadsword often favored for it's heavy swings and strong attacks.", 2, 300, 35, 1, true,
			spAtk.gSlash);

	/** Kinght's Spear */
	public Weapon spear3 = new Weapon("f011", "Knight's Spear", "A spear tailored for knights of the kingdom.", 2, 500,
			38, 1, true, spAtk.pSquare);

	/** Boneblade */
	public Weapon sword5 = new Weapon("f012", "Boneblade",
			"A wickedly shaped sword fashioned from a sharpened bone. Weapons like these are\n"
					+ "primarily used by hostile creatures capable of wielding weapons, like trolls,\n or goblins.",
			2, 100, 35, 1, true, spAtk.none);
	
	/** Cloudburst */
	public Weapon sword6 = new Weapon("f013", "Cloudburst", "A recreation of a sword belonging to a famous swordsman callled"
			+ " the \"Cloudwalker\", famous\nfor his flashy moves.", 3, 1200, 68, 1, true, spAtk.floatCloud);

	/** Phoenix Cleaver*/
	public Weapon axe4 = new Weapon("f014", "Phoenix Cleaver",
			"A golden greataxe that is nearly 7 feet long. It's adorned with silver\nplating on the side of the blade,"
			+ " resembling the body of a phoenix. This weapon was taken from the goblin champion, who\nhad taken it from"
			+ " the father of the knight Adicai.", 4, 120, 1, spAtk.phoenix);

	// --------------------Ranged Weapons--------------------
	
	/** Starter Bow */
	public Weapon bow1 = new Weapon("r001", "Starter Bow", 
	        "A simple wooden bow, often used by beginners. It's not the most powerful, but it's reliable for training.", 
	        1, 50, 10, 1, true);

	/** Shortbow */
	public Weapon bow2 = new Weapon("r002", "Shortbow", 
	        "A compact bow with a shorter range, favored by those who value speed over power.", 
	        1, 100, 15, 1, true, spAtk.piercingShot);

	/** Longbow */
	public Weapon bow3 = new Weapon("r003", "Longbow", 
	        "A tall bow with a long range, capable of dealing significant damage at a distance.", 
	        2, 300, 25, 1, true, spAtk.explosiveArrow);

	/** Frostbow */
	public Weapon bow4 = new Weapon("r004", "Frostbow", 
	        "A magical bow infused with the essence of ice. Each arrow fired chills the target to the bone.", 
	        2, 400, 22, 1, true, spAtk.frostbiteArrow);

	/** Composite Bow */
	public Weapon bow5 = new Weapon("r005", "Composite Bow", 
	        "An advanced bow crafted from multiple materials, offering a balance of speed and power.", 
	        2, 500, 30, 1, true, spAtk.rainOfArrows);

	/** Emberstring */
	public Weapon bow6 = new Weapon("r006", "Emberstring", 
	        "A bow with a string that glows with fiery energy, igniting arrows as they are fired.", 
	        3, 800, 40, 1, true, spAtk.flamingVolley);

	/** Phantom Bow */
	public Weapon bow7 = new Weapon("r007", "Phantom Bow", 
	        "A mystical bow crafted from ethereal materials. Its arrows are said to never miss their target.", 
	        3, 1000, 50, 1, true, spAtk.phantomArrow);

	/** Gale Bow */
	public Weapon bow8 = new Weapon("r008", "Gale Bow", 
	        "A bow imbued with the power of wind. Each arrow fired creates a powerful gust, pushing enemies back.", 
	        3, 900, 45, 1, true, spAtk.galeShot);

	/** Bow of the Phoenix */
	public Weapon bow9 = new Weapon("r009", "Bow of the Phoenix", 
	        "A legendary bow forged in phoenix fire. Each arrow ignites the battlefield in flames, burning enemies over time.", 
	        4, 1200, 60, 1, true, spAtk.flamingVolley);

	/** Starlight Bow */
	public Weapon bow10 = new Weapon("r010", "Starlight Bow", 
	        "A bow that glimmers with celestial light. It is said to be blessed by the stars themselves, striking true with every shot.", 
	        4, 1500, 70, 1, true, spAtk.phantomArrow);

	
	
	/*
	 * 
	 *  --------------------Magic Weapons--------------------
	 *
	 */
	
	// --------------------Chapter 1--------------------
	
	/** Training Wand*/
	public Weapon starterWand = new Weapon("f211", "Training Wand", 
			"A wand favored by young mages to learn the ropes.", 
			1, 25, 15, 3,true, 10, spAtk.pBeam);
	
	public Weapon windTome = new Weapon("f216", "Tome of Forceful Wind",
			"A spell tome used to channel mana, turning them into forceful winds!",
			2, 60, 40, 3, true, 20, spAtk.windSlash);
	
	public Weapon earthTome = new Weapon("f217", "Tome of Earth",
			"A spell tome used to channel mana, moving the earth around you with devistating force!",
			3, 70, 45, 3, true, 20, spAtk.massiveBoulder);
	
	
	
	
	// --------------------Chapter 2--------------------
	
	public Weapon tremorWand = new Weapon("f225", "Wand of Tremors",
			"A wand capable of channeling mana into the earth, making the entire ground shake as it moves the earth beneath the battlefield!",
			3, 180, 115, 3, true, 40, spAtk.doubleEarthWall);
	
	public Weapon flameWand = new Weapon("f226", "Wand of Scorching Flames",
			"A wand used to convert mana into blazing flames, scorching everything it touches!",
			3, 200, 120, 3, true, 45, spAtk.flamingTornados);
	
	public Weapon streamWand = new Weapon("f227", "Wand of Piercing Streams",
			"A wand that converts mana into highly pressurized, condensed streams of water capable of putting a hole through diamond itself!",
			3, 225, 125, 3, true, 50, spAtk.curvingSplitStream);
	
	// --------------------Chapter 3--------------------
	
	public Weapon tornadoStaff = new Weapon("f235", "Tornado Staff",
			"A staff capable of using mana to summon powerful tornados to disrupt the battlefield",
			4, 750, 425, 3, true, 65, spAtk.motherOfAllTornados);
	
	public Weapon floodStaff = new Weapon("f236", "Flood Staff",
			"A staff used to convert mana into  insane amounts of water, washing away the battlefield, and your enemies along with it!",
			4, 800, 450, 3, true, 70, spAtk.doubleWave);
	
	public Weapon hellfireStaff = new Weapon("f237", "Hellfire Staff", 
			"A staff used to summon the flames from the gates of hell themselves, leaving anything it touches as a pile of ash!", 
			5, 1000, 500, 3, true, 75, spAtk.fireWall);
	
	// --------------------Chapter 4--------------------
	
	public Weapon apocolypseScroll = new Weapon("f245", "Scroll of the Apocolypse",
			"A scroll that teaches you the secrets of fire-based magic,  allowing you to become one with the mana flowing through you, converting that mana into fire that rain's down from the heavens!",
			5, 3500, 1350, 3, true, 90, spAtk.impendingDoom);
	
	public Weapon hurricaneScroll = new Weapon("f246", "Scroll of the Hurricane",
			"A scroll that teaches you the secrets of wind-based magic, allowing you to become one with the mana flowing through you, converting that mana into hurricanes, utilizing the forces of mother-nature herself to destroy your opponents!",
			5, 3750, 1400, 3, true, 90, spAtk.eyeOfTheStorm);
	
	public Weapon canyonScroll = new Weapon("f247", "Scoll of Canyon Creation",
			"A scroll that teaches you the secrets of earth-based magic, allowing you to become one with the mana flowing through you, embewing that mana into the ground beneth you, allowing you to bend the earth to your will!",
			5, 4000, 1500, 3, true, 100, spAtk.straightToTheCore);
	
	// --------------------Rogue Weapons--------------------
	
	
	/*
	 * 
	 * --------------------Hub Weapons--------------------
	 * 
	 */
	
	/*
	 * --------------------Chapter 1 Hub--------------------
	 */
	
	// --------------------Melee Weapons--------------------
	
	// --------------------Ranged Weapons--------------------
	
	// --------------------Mage Weapons--------------------
	
	public Weapon natureWand = new Weapon("f212", "Nature Wand",
			"A wand used to channel the nature energy from your enviornment!",
			1, 40, 25, 3, true, 15, spAtk.naturesGift);
	
	public Weapon lightningWand = new Weapon("f213", "Lightning Wand",
			"A wand capable of harnessing the power of electricity!",
			2, 45, 30, 3, true, 15, spAtk.multiStrike);
	
	public Weapon fireTome = new Weapon("f214", "Tome of Fire",
			"A spell tome used to channel mana, turning them into deadly flames!",
			2, 50, 35, 3, true, 20, spAtk.fireBall);
	
	public Weapon waterTome = new Weapon("f215", "Tome of Water",
			"A spell tome used to channel mana, turning them into powerful streams of water!",
			2, 60, 40, 3, true, 20, spAtk.crushingWave);
	
	// --------------------Rogue Weapons--------------------
	
	
	/*
	 * --------------------Chapter 2 Hub--------------------
	 */
	
	// --------------------Melee Weapons--------------------
	
	// --------------------Ranged Weapons--------------------
	
	// --------------------Mage Weapons--------------------
	
	public Weapon ironHeartAmulet = new Weapon("f221", "Iron-Heart Amulet",
			"An amulet that allows you to channel your mana, creating formations of iron to send towards your enemies!",
			2, 100, 85, 3, true, 30, spAtk.bladeRain);
	
	public Weapon titansGauntlet = new Weapon("f222", "Silver-Titan's Gauntlet",
			"A gauntlet said to be forged by the titans, embewing your punches with mana, significantly increasing their effectiveness!",
			2, 125, 90, 3, true, 30, spAtk.heavyFist);
	
	public Weapon colossusRing = new Weapon("f223", "Silver-Colossus Ring",
			"A ring that channels the energy of colossus entities, using mana to release devistating waves of magical energy!",
			2, 150, 95, 3, true, 35, spAtk.colossusCrush);
	
	public Weapon forceWand = new Weapon("f224", "Wand of Unrelenting Force",
			"A wand that channels your magical energy, converting it into unrelenting winds, capable of sending your enemies flying!",
			2, 160, 100, 3, true, 35, spAtk.crushingWinds);
	
	// --------------------Rogue Weapons--------------------
	
	
	/*
	 * --------------------Chapter 3 Hub--------------------
	 */
	
	// --------------------Melee Weapons--------------------
	
	// --------------------Ranged Weapons--------------------
	
	// --------------------Mage Weapons--------------------
	
	public Weapon rubyCatalyst = new Weapon("f231", "Ruby Catalyst",
			"A gauntlet infused with powerful ruby gemstones, embewing punches unprecidented magical energy!",
			3, 550, 325, 3, true, 55, spAtk.secondImpact);
	
	public Weapon celestialRing = new Weapon("f232", "Saphire Celestial Ring",
			"A ring infused with powerful saphire gemstones used to channel the power of the celestial entites themselves!",
			3, 600, 350, 3, true, 60, spAtk.celestialBeamRain);
	
	public Weapon crimsonPrism = new Weapon("f233", "Crimson Prism",
			"A prisim embewed with Crimson gemstones, used to convert the light energy of the sun into powerful beams of magical energy, burning a whole through anything it is pointed at!",
			3, 650, 375, 3, true, 60, spAtk.lightConvergence);
	
	public Weapon eqStaff = new Weapon("f234", "Earthquake Staff",
			"A staff capable of using magical energy to move the tectonic plates themselves, causing earthquakes throughout the battlefield!",
			3, 700, 400, 3, true, 65, spAtk.rockSlide);
	
	// --------------------Rogue Weapons--------------------
	
	/*
	 * --------------------Chapter 4 Hub--------------------
	 */
	
	// --------------------Melee Weapons--------------------
	
	// --------------------Ranged Weapons--------------------
	
	// --------------------Mage Weapons--------------------
	
	public Weapon hellsFuryRing = new Weapon("f241", "Onyx Ring of Hell's Fury",
			"A ring embewed with Onyx gemstones, summoning the fury of hell itself upon your enemies!",
			3, 2500, 1150, 3, true, 80, spAtk.demonStrike);
	
	public Weapon celestialCurseShard = new Weapon("f242", "Diamond Shard of Celestial Curse",
			"A shard that, when embewed with mana, channels the anger and wrath of the Gods, unleashing it upon your enemies!",
			4, 2750, 1200, 3, true, 80, spAtk.heavensRage);
	
	public Weapon abyssalAmethest = new Weapon("f243", "Abyssal Amethest",
			"An amethyst gemstone, enchanted to use mana to summon the wrath of the mythical beasts from the deapths of the abyss!",
			4, 3000, 1250, 3, true, 85, spAtk.eternalDarkness);
	
	public Weapon tsunamiScroll = new Weapon("f244", "Scroll of the Tsunami",
			"A scroll that teaches you the secrets of water-based magic, allowing you to become one with the mana flowing through you, and converting that mana directly into massive waves of water capable of destroying entire kingdoms in one attack!",
			5, 3250, 1300, 3, true, 85, spAtk.weightOfTheDepths);
	
	// --------------------Rogue Weapons--------------------
	
	
}
