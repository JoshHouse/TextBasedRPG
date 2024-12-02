package indexes;

import game.SpecialAttack;

public class SpAtkList {

	// Constructor for SpecialAttack Object:
	// (String) Name, (String) Info, (String) HitText, (String) MissTxt, (double)
	// AttackMultiplier

	/** No special attack. */
	public SpecialAttack none = new SpecialAttack();

	// --------------------Melee Special Attacks--------------------

	/*
	 * ---------------------------------Chapter 1----------------------------------
	 */

	/** Special Attack - Triple Thrust. */
	public SpecialAttack x3Thrust = new SpecialAttack("Triple Thrust",
			"Ready your weapon and perform three consecutive thrusts in a row, dealing triple damage to your enemy!",
			" thrusts out their blade, striking their foe thrice before they can retaliate!",
			" thrust out their blade thrice, yet their foe was quicker, and avoided all three strikes.", 3.0);

	/** Special Attack - Great Slash. */
	public SpecialAttack gSlash = new SpecialAttack("Great Slash",
			"Peform a powerful upwards slash that threatens to tear your enemy in two!",
			" holds their blade behind them and charges forward, swinging upwards with all their might, "
					+ "as if aiming to split the clouds in two!",
			" holds their blade behind them and charges forward, yet misses their foe as they swing towards the sky.",
			1.3);

	/*
	 * ---------------------------------Chapter 2----------------------------------
	 */

	/** Special Attack - Dancing Blade. */
	public SpecialAttack danceBlade = new SpecialAttack("Dancing Blade",
			"Strike your opponent with a series of intricate strikes with your blade, almost as if you're dancing around them!",
			" rushes forward and dances around their opponent, swinging and slashing repeatedly with blinding speed!",
			" attempts to dance around their opponent, but instead revealed their two left feet as they nearly tripped...",
			1.8);

	/** Special Attack - Pike Square. */
	public SpecialAttack pSquare = new SpecialAttack("Pike Square",
			"A well-known combo favored by knights. Perform four powerful strikes with your polearm to deal devastating "
					+ "damage to your opponents.",
			" enters their stance and swings their weapon downward, then back, jabs their foe with the blunt end before ending "
					+ "on a horizontal slash, finishing the Pike Square combo!",
			" enters their stance, but their first swing misses, and the second swing is blocked. The wise response was made, "
					+ "and they backed off on their combo.",
			2.0);

	/** Special Attack - Stormcaller */
	public SpecialAttack storm = new SpecialAttack("Stormcaller",
			"Spin the weapon around to channel lightning into the blade, then strike your opponent!",
			" spins the blade around before striking their foe with a torrent of lightning!",
			" spins their blade around, yet the lightning that appears quickly fizzles out.", 2.44);

	/** Special Attack - Drake Fire */
	public SpecialAttack dFire = new SpecialAttack("Drake Fire", "Have the blade breathe fire like a powerful dragon!",
			" aims their blade, letting it unleash a torrent of fire like from the mouth of a dragon!",
			" aims their blade, but only unleashes smoke.", 3.0);

	/** Special Attack - Hunting Dog */
	public SpecialAttack huntDog = new SpecialAttack("Hunting Dog",
			"With your claws, pursue your opponent like a beast going after it's prey.",
			" violently rushes their foe with a myriad of deadlly slashes!",
			" rushes their foe, yet their attacks are avoided.", 2.55);

	/*
	 * ---------------------------------Chapter 3----------------------------------
	 */

	/** Special Attack - Floating Cloud */
	public SpecialAttack floatCloud = new SpecialAttack("Floating Cloud",
			"The signature move of the \"Cloudwalker\". A flashy sword combo that involves moving one's body so light, it\n"
					+ "appears that they are floating in the air.",
			" moves so lightly as they swing their blade, slashing their opponent as they appear to be walking on air!",
			" appears to attempt to fly. Unfortunately, they do not have wings.", 2.1);

	/** Special Attack - Sword Opera */
	public SpecialAttack swordOpera = new SpecialAttack("Sword Opera", "Rain down thousands of swords upon your enemy!",
			" causes hundreds upon hundred of blades to appear out of thin air, all of them honing in on one spot- their foe!",
			" creates hundreds upon hundreds of blades to rain down... yet many dispersed midair, only a few landing and "
					+ "missing their target...",
			7.5);

	/** Special Attack - Breath of the Phoenix */
	public SpecialAttack phoenix = new SpecialAttack("Breath of the Phoenix",
			"By spinning the Phoenix Cleaver above your head, you create a tornado made from flames that are said to\n burn as"
					+ " hot as a phoenix breathing fire.",
			" holds the greatxe over their head and rapidly spins it around, giving birth to a mighty tornado to reduce\ntheir"
					+ "enemies to ashes!",
			" holds the greataxe over their head and spins it around... but the flames refused to emerge to consume their foe.",
			3.0);

	/** Special Attack - Blink */
	public SpecialAttack blink = new SpecialAttack("Blink",
			"Disappear within the blink of an eye, then impale your opponent!",
			" vanishes in an instant before reappearing and impaling their foe!",
			" disappears, but misses their thrust attack as they reappear.", 2.1);

	/** Special Attack - Unholy Diver */
	public SpecialAttack diver = new SpecialAttack("Unholy Diver",
			"Strike the ground, creating a field of dark energy to sprout up and engulf your foe!",
			"'s blade stabs into the ground. And like flowing water, a sea of darkness appears before the energy sprouts up, "
					+ "nearly consuming their foe whole.",
			"'s blade strikes the ground... yet the appearing darkness barely stretched out a full foot in radius.",
			2.41);

	/*
	 * ---------------------------------Chapter 4----------------------------------
	 */

	/** Special Attack - Hoarfrost Stomp */
	public SpecialAttack iceStomp = new SpecialAttack("Hoarfrost Stomp",
			"Stomp down hard on the ground to create a field of ice in front of you",
			" stomps their foot down, freezing the ground and their opponent in front of them!",
			"Stomps their foot down. . . awkwardly.", 2.1);

	/** Special Attack - Wave of Gold */
	public SpecialAttack goldWave = new SpecialAttack("Wave of Gold",
			"Channel the power of the \"Venerable Paladin\" to attack your enemies with a wave of gold across the battlefield!",
			" swings their blade as the battlefield is bathes in rays of gold!",
			" swings their blade... yet the power within refuses to obey.", 3.33);

	/** Special Attack - Call of the Gravelord */
	public SpecialAttack graveyard = new SpecialAttack("Call of the Gravelord",
			"Summon the skeleton king's power to attack with a small army of skeletons!",
			" bangs the scythe on the ground, causing the ground to split open as several skeletons climbed out, "
					+ "each leaping at their foe with a variety of weapons!",
			" bangs the scythe on the ground... but the dead refused to come up.", 2.0);

	/** Special Attack - Spirit Bomb */
	public SpecialAttack sBomb = new SpecialAttack("Spirit Bomb",
			"Summon the spirit of the \"Flying General\" to fire a devastating amount of energy from your weapon!",
			" readies their weapon and thrusts it forth, sending a torrent of energy straight at their foe!",
			" thrusts forth their weapon... but the power witihn refuses to come forth.", 3.0);

	/** Special Attack - Autumn Flow */
	public SpecialAttack autumn = new SpecialAttack("Autumn Flow",
			"A combo favored by the \"Golden Gladiator\". Perform a powerful 4-hit combo with your weapons!",
			" lunges at their target and hits with four direct slashes, each one landing in critical spots to maximize damage.",
			" lunges at their target, but all of their attacks miss as they weren't fast enough.", 4.0);

	/** Special Attack - Night Raid */
	public SpecialAttack nightRaid = new SpecialAttack("Night Raid",
			"A unique skill of the famous assassin. Coat your claws in darkness and perform a fast, piercing strike "
					+ "through the heart and soul!",
			" lunges forth with claws of darkness, impaling their foe with blinding speed!",
			" waits for darkness to envelop their claws... yet nothing happened.", 2.89);

	// --------------------Ranged Special Attacks--------------------

	/** Special Attack - Piercing Shot. */
	public SpecialAttack piercingShot = new SpecialAttack("Piercing Shot",
			"Take careful aim and fire an arrow that pierces through multiple enemies, dealing increased damage to all targets in a line.",
			" carefully takes aim, releasing an arrow that cuts through the air with precision, striking multiple foes in its path!",
			" carefully takes aim, but their arrow misses its mark, vanishing into the distance.", 2.0);

	/** Special Attack - Explosive Arrow. */
	public SpecialAttack explosiveArrow = new SpecialAttack("Explosive Arrow",
			"Fire an arrow tipped with an explosive charge that detonates on impact, dealing splash damage to all nearby enemies.",
			" fires an explosive arrow that streaks through the air before detonating in a fiery explosion, engulfing enemies in flames!",
			" fires an explosive arrow, but it fizzles out and harmlessly hits the ground.", 2.5);

	/** Special Attack - Frostbite Arrow. */
	public SpecialAttack frostbiteArrow = new SpecialAttack("Frostbite Arrow",
			"Unleash an ice-tipped arrow that chills the target to the bone, slowing their movements and dealing damage over time.",
			" fires an icy arrow that strikes their foe, encasing their limbs in frost and sapping their strength with freezing cold!",
			" fires an icy arrow, but their opponent dodges it, leaving the air around them cold but harmless.", 1.8);

	/** Special Attack - Rain of Arrows. */
	public SpecialAttack rainOfArrows = new SpecialAttack("Rain of Arrows",
			"Leap into the air and unleash a volley of arrows that rain down on enemies in a wide area, dealing significant damage.",
			" leaps into the air, firing a flurry of arrows that rain down upon their foes, leaving devastation in their wake!",
			" leaps into the air, but the arrows scatter harmlessly, leaving their opponents unscathed.", 2.2);

	/** Special Attack - Flaming Volley. */
	public SpecialAttack flamingVolley = new SpecialAttack("Flaming Volley",
			"Launch a volley of fire arrows that explode upon impact, creating a fiery inferno to burn enemies over time.",
			" releases a blazing volley of fire arrows, igniting the battlefield in an inferno that scorches everything in its path!",
			" fires a blazing volley, but the arrows fail to ignite, leaving their enemies unharmed.", 2.8);

	/** Special Attack - Phantom Arrow. */
	public SpecialAttack phantomArrow = new SpecialAttack("Phantom Arrow",
			"Summon a magical arrow of pure energy that seeks out the target with unerring accuracy, bypassing defenses.",
			" conjures a glowing arrow of energy that streaks unerringly towards its target, bypassing all defenses to strike true!",
			" summons a glowing arrow of energy, but it fizzles out before reaching its target.", 3.0);

	/** Special Attack - Gale Shot. */
	public SpecialAttack galeShot = new SpecialAttack("Gale Shot",
			"Fire an arrow infused with wind magic that generates a powerful gale, pushing back enemies and dealing area damage.",
			" fires a wind-infused arrow that creates a howling gale, knocking enemies back and causing them to stumble!",
			" fires a wind-infused arrow, but the gust is too weak to affect their enemies.", 2.0);

	/*
	 * 
	 * --------------------Magic Special Attacks--------------------
	 * 
	 */

	// --------------------Chapter 1--------------------

	/** Special Attack - Power Beam */
	public SpecialAttack pBeam = new SpecialAttack("Power Beam",
			"Shoots a deadly beam of charged up mana capable of putting a hole straight through whatever it's pointed at!",
			"Beams of light converge on your weapon, firing a blast of charged up energy!",
			"Beams of light converge on the weapon but quickly fizzle out. The power beam failed to fire!", 1.5);

	public SpecialAttack naturesGift = new SpecialAttack("Nature's Gift",
			"Summons roots from the ground to encarcerate and impale your enemies!",
			"Roots erupt from the ground, surrounding the enemy and dig into their body!",
			"Roots begin to grow from the ground but then quickly sink back into the earth! Nature's gift failed to emerge!",
			1.5);

	public SpecialAttack multiStrike = new SpecialAttack("Multi-Strike",
			"Summons rapid fire electric streaks of lighting, hitting your enemy multiple times!",
			"Streaks of lightning errupt from your wand with devistating speed, hitting your enemy multiple times",
			"Streaks of lightning errupt from your wand but you lose focus, causing them to be erratic. Multi-Strike failed to land!",
			1.5);

	public SpecialAttack fireBall = new SpecialAttack("Fire Ball",
			"Creates a large orb of burning flames, firing it at the enemy!",
			"A burning orb appears at the tip of your wand, growing larger, and larger, until it is too large to control, then it is sent flying at your enemy, incinerting everything in its path!",
			"Flames begin to converge at the tip of your wand but quickly disipate! Fire Ball failed to fire!", 1.5);

	public SpecialAttack crushingWave = new SpecialAttack("Crushing Wave",
			"Creates a large wave of water, smashing into your enemy and doing devistating damage!",
			"Water bursts from the ground forming a death wall of raging currents before being cast upon the enemy!",
			"Water bursts from the ground but fails to organize in a meaningful way. Crushing Wave failed to land!",
			1.5);

	public SpecialAttack windSlash = new SpecialAttack("Wind Slash",
			"Summons a thin line of condenced air sharper than any blade that is sent at your enemy!",
			"A shreek of powerful wind being pressed against powerful wind is heard as a wind blade forms, being sent flying towards the enemy!",
			"You lose focus as you attempt to summon the wind currents necissary to materialize the wind slash! Wind Slash failed to fire!",
			1.5);

	public SpecialAttack massiveBoulder = new SpecialAttack("Massive Boulder",
			"Raises a massive bolder above the enemy, crushing them under its weight!",
			"The ground trembles as a boulder is raised from the earth above your enemy, being dropped with devistating force!",
			"The ground trembles as a boulder begins to be raised, but quickly falls back to the ground. Massive boulder failed to fire!",
			1.5);

	// --------------------Chapter 2--------------------

	public SpecialAttack bladeRain = new SpecialAttack("Blade Rain",
			"Thousands of sharp metal blades are summoned above the battle field, raining upon the enemy!",
			"The sky begins to glisten as thousands of reflective blades materialize, before showering the enemy with slashes!",
			"The sky begins to glisten as thousands of blades begin to materialize before falling without serious intent! Blade rain failed to do any significant damage!",
			2.0);

	public SpecialAttack heavyFist = new SpecialAttack("Heavy Fist",
			"Magical energy surrounds the gauntlet, creating an extra powerful blow!",
			"Magical energy converges on the gauntlet, and as the blow lands the shockwave sends tremors through your arm with the sheer force outputted by the impact!",
			"Magical energy converges on your gauntlet but the weight is too much to bare! You are unable to make meaningful contact with the enemy! Heavy Fist failed to land!",
			2.0);

	public SpecialAttack colossusCrush = new SpecialAttack("Colossus Crush",
			"Create A colossal being made out of pure magical energy to crush your enemy!",
			"A colossal being made of pure magical energy standing 50 feet tall materializes on the battlefield, slamming its fist down on the enemy with devistating speed and force!",
			"A colossal being begins to materialize on the battlefield but quickly disintegrates! Colossus Crush failed to go off!",
			2.0);

	public SpecialAttack crushingWinds = new SpecialAttack("Crushing Winds",
			"Two raging winds are smashed together, with your opponent in between, crushing them with the pure force of the two currents!",
			"You hear raging winds coming from the left, and more coming from the right. That is when, in an instant, your oponent is crushed between the force of these two wind currents!",
			"You summon two currents of raging wind but they are unfocused so fail to concentrate the pressure on your opponent! Crushing Winds failed to fire!",
			2.0);

	public SpecialAttack doubleEarthWall = new SpecialAttack("Double Earth Wall",
			"Errects two walls of rock from the earth, slaming your opponent on both sides!",
			"Two rock walls errupt from the ground on either side of your opponent, quickly slamming together, crushing your opponent with devistating force!",
			"Two rock walls emerge from the ground but quickly shatter to dust. Double Earth Wall failed to fire!",
			2.0);

	public SpecialAttack flamingTornados = new SpecialAttack("Flaming tornados",
			"Swirling tunnels of scorching flames reach to the heavens, appearing as though a tornado of flames has materialized on the battlefield!",
			"Rotating Flames appear in multiple locations on the battlefield reaching towards the heavens, incinerating your opponent in the process!",
			"Rotating flames begin to appear but quickly fizzle out! Flaming tornados fails to fire!", 2.0);

	public SpecialAttack curvingSplitStream = new SpecialAttack("Curving Split-Stream",
			"Send out two piercing streams of water in two directions, and watch as the curve inward, impaling the enemy from two sides!",
			"A hissing sound is heard as two piercing streams of water shoot from your wand, converging on the enemy and putting a hole through them from two directions!",
			"Two streams of water shoot out of your wand but are unfocused and lack the necissary power to do any significant damage. Curving Split-Stream failed to land!",
			2.0);

	// --------------------Chapter 3--------------------

	public SpecialAttack secondImpact = new SpecialAttack("Second Impact",
			"Channel Magical energy inside the gauntlet, being released a split second after the energy of the first impact, serving as a second, even more devistating impact!",
			"You feel the magical energy coursing through the inside of the gauntlet. The first impact lands with devistating force, being quickly preceeded by a secondary, even more damaging impact that rattles your opponent!",
			"You charge up the magical energy in your gauntlet and swing at the enemy, but the enemy dodges! You failed to land Second Impact!",
			2.5);

	public SpecialAttack celestialBeamRain = new SpecialAttack("Celestial Beam Rain",
			"Channel magical energy to summon clestial beams of light that cover the battlefield!",
			"As you pour mana into the ring, the clouds disipate as the skies open up and rain down beams of celectial energy, covering the battefield!",
			"You pour mana into the ring but you are unfocused and fail to summon the celestial wrath! Celectial Beam Rain failed to summon!",
			2.5);

	public SpecialAttack lightConvergence = new SpecialAttack("Light Convergence",
			"All light from the surrounding area converges on the prisim, releasing a large focused beam of pure light energy to desimate opponenets!",
			"All light in the surrounding area is focused into the prisim and redirected into a focused beam shot directly at your opponent!",
			"All light from the surrounding area converges on the prisim, but due to a lack of focus, it fails to coverge into a single beam, being released in all directions. Light Convergence failed to fire!",
			2.5);

	public SpecialAttack rockSlide = new SpecialAttack("Mountain Summoning - Rock Slide",
			"Summon a mountain on the battlefield that releases a rockslide, cascading down upon your opponent!",
			"A Mountain errupts in the center of the battefield, sending loose rock tumbling upon your opponent!",
			"A mountain begins to rise from the ground but fails to fully materialize! Mountain Summoning - Rock Slide failed to fire!",
			2.5);

	public SpecialAttack motherOfAllTornados = new SpecialAttack("Mother of all Tornados",
			"Summon a swirling tunnel of violent winds that eclipses the sky! Legends have spoken of this power, referring to it as the \"Mother of all Tornados\"!",
			"The sky turns as dark as the night as the clouds above turn black and begin to swirl! This funnel of powerful winds touches ground directly on top of your opponent, trapping them in swirling wind and debris!",
			"The clouds turn dark and begin to swirl but fail to reach the ground! Mother of all Tornados failed to summon!",
			2.5);

	public SpecialAttack doubleWave = new SpecialAttack("Double Wave",
			"Summons two large waves of powerful water currents that collide into each other with your opponent in the middle!",
			"The sound of crashing waves echos through the battlefield as two raging currents collide on your opponent, applying insane pressure and hitting them with the debris picked up from both waves!",
			"Raging currents flood the battlefield but a lack of focus causes them to miss their mark, leaving the opponent with minimal damage! Double Wave failed to land!",
			2.5);

	// --------------------Chapter 4--------------------

	public SpecialAttack demonStrike = new SpecialAttack("Demon Strike",
			"Open a portal from the gates of hell, allowing a raging demon to emerge and unleashing its wrath upon your opponent!",
			"A firey portal opens on the battlefield, as a raging demon emerges and unleashes the wrath of hell upon your enemy!",
			"A firey portal begins to open but quickly slams shut! Demon Strike failed to fire!", 3.0);

	public SpecialAttack heavensRage = new SpecialAttack("Heaven's rage",
			"Summon a powerful beam of celestial energy from the heavens to desimate your opponent!",
			"The sky clears in an instant, and as if containing the energy of the sun itself, a beam of pure celestial energy decents from the heaven, doing massive damage to your opponent!",
			"The sky clears but the celestial energy fails to materialize! Heaven's rage failed to fire!", 3.0);

	public SpecialAttack eternalDarkness = new SpecialAttack("Eternal Darkness",
			"Casts the curse of the abyss upon your enemy, tormenting them with the psychological effects of eternal darkness!",
			"Your enemies eyes go black, as they experience in an instant the psychological effects of a lifetime of eternal darkness!",
			"You attempt to cast the abyssal curse upon your enemy but they remain uneffected! Eternal Darkness failed to land!",
			3.0);

	public SpecialAttack weightOfTheDepths = new SpecialAttack("Weight of the Depths",
			"Water surrounds your opponent and applies the pressure that would be experienced on the ocean floor to the opponent!",
			"Water surrounds your opponent and applies the crushing weight from the ocean floor, crushing bone and making their organs bulge!",
			"Water surrounds your opponent but quickly falls to the ground! Weight of the Depths failed to land!", 3.0);
	public SpecialAttack impendingDoom = new SpecialAttack("Impending Doom",
			"Fire rains down from the skies, covering the battlefield in scorching flames!",
			"The skys split open, as hellfire rains down, burning everything in its path!",
			"The sky splits open but hellfire fails to rain! Impending Doom failed to materialize!", 3.0);
	public SpecialAttack eyeOfTheStorm = new SpecialAttack("Eye of the Storm",
			"Summon a raging hurricane that surrounds your opponent with the eye of the storm shrinking until the winds consumen them!",
			"The sky turns black as a raging hurricane forms around your opponent! Though initially safe in the eye of the storm, the eye shrinks until there is no safe place and your opponent is consumed by the raging winds and flying debris!",
			"The sky turns black and a hurricane begins to materialize but dissipates quickly! Eye of the Storm failed to land!",
			3.0);
	public SpecialAttack straightToTheCore = new SpecialAttack("Straight to the Core",
			"Open a crack in the ground, sending your opponent straight to the center of the earth! Burning them in the lava of the core!",
			"The ground beneath your opponent violently splits open, sending your opponent plummiting into the earths core!",
			"The earth begins to split open beneath your opponent but quickly slams shut! Straight to the Core failed to fire!",
			3.0);

	/*
	 *
	 * --------------------Rogue Special Attacks--------------------
	 *
	 */

	// --------------------Chapter 1--------------------

	/** Special Attack - Poison Strike */
	public SpecialAttack poisonStrike = new SpecialAttack("Poison Strike",
			"Coat your blade with poison, delivering a strike that weakens and damages your opponent over time.",
			"You swiftly coat your blade in poison and land a precise strike! The venom begins to take effect immediately.",
			"You attempt to coat your blade, but the poison slips off before you can strike! Poison Strike failed to land!",
			1.8);

	/** Special Attack - Basic Slash */
	public SpecialAttack basicSlash = new SpecialAttack("Silent Slash",
			"A quick and precise slash aimed at the enemy’s weak spot, dealing decent damage.",
			"You move with deadly silence, your blade slicing through the enemy’s defenses with ease.",
			"You move in for the attack, but your blade misses its mark. Basic Slash failed to land!",
			1.2);

	/** Special Attack - Throwing Barrage */
	public SpecialAttack throwingBarrage = new SpecialAttack("Throwing Barrage",
			"Hurl a volley of shurikens at your enemy, overwhelming them with rapid strikes.",
			"You reach for your shurikens and unleash a flurry of blades, hitting the target with deadly accuracy.",
			"You throw a handful of shurikens, but your aim falters, and the blades scatter harmlessly! Throwing Barrage failed to hit!",
			1.5);

	// --------------------Chapter 2--------------------

	/** Special Attack - Bleed Out */
	public SpecialAttack bleedOut = new SpecialAttack("Bleed Out",
			"A vicious strike that causes your opponent to bleed heavily, dealing damage over time.",
			"You land a deep slash, and blood begins to pour from the wound, weakening your opponent.",
			"You swing your blade, but the attack lacks the precision needed to cause serious damage. Bleed Out failed to land!",
			2.4);

	/** Special Attack - Shadow Step */
	public SpecialAttack shadowStep = new SpecialAttack("Shadow Step",
			"Disappear into the shadows and strike from behind, catching your opponent off-guard.",
			"You vanish into the darkness and reappear behind your opponent, landing a devastating blow.",
			"You attempt to step into the shadows, but your opponent senses your movement! Shadow Step failed to land!",
			2.6);

	/** Special Attack - Twin Fang Strike */
	public SpecialAttack twinFangStrike = new SpecialAttack("Twin Fang Strike",
			"Strike twice in rapid succession with dual daggers, aiming for critical points.",
			"Your daggers flash in the air as you land two precise strikes, dealing devastating damage.",
			"You swing your daggers, but your opponent dodges the second strike! Twin Fang Strike failed to land!",
			2.0);

	// --------------------Chapter 3--------------------

	/** Special Attack - Critical Ambush */
	public SpecialAttack criticalAmbush = new SpecialAttack("Critical Ambush",
			"Wait for the perfect moment to strike, dealing critical damage from stealth.",
			"You bide your time, then strike with precision, dealing a devastating critical hit!",
			"You attempt to strike from stealth, but your timing is off! Critical Ambush failed to land!",
			2.6);

	/** Special Attack - Frenzy Attack */
	public SpecialAttack frenzyAttack = new SpecialAttack("Frenzy Attack",
			"Unleash a flurry of rapid attacks, overwhelming your opponent with sheer speed.",
			"You lash out with a series of lightning-fast strikes, leaving your opponent battered and stunned.",
			"You launch into a frenzy, but your strikes fail to find their target! Frenzy Attack failed to land!",
			2.9);

	/** Special Attack - Piercing Throw */
	public SpecialAttack piercingThrow = new SpecialAttack("Piercing Throw",
			"Target a weak point with your axe, bypassing armor and dealing massive damage.",
			"You line up your shot and throw with deadly accuracy, piercing through your opponent’s armor!",
			"You hurl your blade, but it glances off the opponent’s armor! Piercing Throw failed to land!",
			3.5);

	// --------------------Chapter 4--------------------

	/** Special Attack - Life Steal */
	public SpecialAttack lifeSteal = new SpecialAttack("Life Steal",
			"Drain the life force from your enemy with a precise strike, healing yourself in the process.",
			"You lash out. Your blade glows faintly as it siphons your opponent’s life force, rejuvenating you!",
			"You strike, but the connection is weak, and you fail to drain any life force. Life Steal failed to land!",
			4);

	/** Special Attack - Armor Pierce */
	public SpecialAttack armorPierce = new SpecialAttack("Armor Pierce",
			"Strike with enough force to bypass even the strongest armor, dealing massive damage.",
			"Your blade finds the weak spot in your opponent’s armor, piercing through with devastating precision!",
			"You aim for the weak spot but fail to penetrate the armor! Armor Pierce failed to land!",
			4.5);

	/** Special Attack - Death Mark */
	public SpecialAttack deathMark = new SpecialAttack("Death Mark",
			"Mark your opponent for death, dealing massive damage and weakening them for future attacks.",
			"Your blade leaves a glowing mark on your opponent, signaling their imminent demise!",
			"You attempt to mark your opponent, but they evade your strike! Death Mark failed to land!",
			5.0);


	// --------------------Enemy Special Attacks--------------------

	/** Special Attack - Bear Hug */
	public SpecialAttack bearHug = new SpecialAttack("Bear Hug",
			"A bear can grab and crsuh you beneath the weight of its body.",
			"The bear runs up seemingly to slash you... but suddenly grabs you, squeezing you tightly as it held you close, "
					+ "trying to crush you to death.",
			"The bear attempts to run and grab you... however, its prey manages to see it" + " coming, and dodges.",
			2.0);

	/** Special Attack - Double Slash */
	public SpecialAttack doubSlash = new SpecialAttack("Double Slash",
			"A skilled fighter is capable of performing multiple strikes at once.",
			"The fighter grips their blade before hitting you with two consecutive strikes!",
			"With your own skill, you manage to avoid the double slashes from the mercenary!", 2.0);

	/** Special Attack - Wolf Pack */
	public SpecialAttack wolves = new SpecialAttack("Wolf Pack",
			"Howling, the alpha wolf can call for several wolves to aid it.",
			"The wolf howls, summoning its companions to aid it as it attacks you!",
			"The wolf howls... but no one came.", 4.0);

	/** Special Attack - Mythic Blast */
	public SpecialAttack mythic = new SpecialAttack("Mythic Blast", "Fire a blast of ethereal energy!",
			"The shaman chants, gathering power in their staff, then blasts you with a torrent of energy!",
			"The shaman chants... yet nothing happens!", 2.0);

	/** Special Attack - Bite */
	public SpecialAttack bite = new SpecialAttack("Bite", "Be bitten by a dangerous creature!",
			"The dangerous beast sinks its teeth into you!",
			"The beast lunges to bite, but you avoid in the knick of time!", 2.1);

	public SpecialAttack fireWall = new SpecialAttack("Fire Wall",
			"Creates a blazing wall of flames capable of incinerating anything in its path!",
			"A blazing wall materializes on the battlefield burning everything it touches!",
			"A blazing wall begins to appear but fizzles out! The fire wall failed to materialize!", 2.0);

	public SpecialAttack erruption = new SpecialAttack("Erruption",
			"Splits the ground beneath its target blasting pillars of fire from the deapths of the earth!",
			"The ground begins to tremble as cracks begin to form! The earth splits open covering "
					+ "the battlefield with blazing pillars from the deapths of the earth!",
			"The ground begins to rumble and cracks begin to form but quickly slam shut! The erruption fails to occur!",
			2.5);
	
	public SpecialAttack boulderToss = new SpecialAttack("Boulder Toss",
			"The troll picks up a nearby boulder and hurls it toward you!",
			"The troll lifts a nearby boulder, hoisting it on its back and in one swift motion, sends the boulder flying toward you! ",
			"The troll lifts up a nearby boulder but quickly loses it's grip! The troll failed to use Boulder Toss!",
			2.5);

	/** Special Attack - Rampaging Tusks. */
	public SpecialAttack kioqSpAtk = new SpecialAttack("Rampaging Tusks",
			"Kioq goes on a rampage! No one, friend or foe, should be around the champion when he starts swinging his axes!",
			"Kioq roars like a wild animal before charging forth, swinging his axes back "
					+ "and forth widly while striking everything in his path!",
			"Kioq roars loudly as if to prepare for an attack... but he suddenly keels over to catch his breath, as if he used "
					+ "up all of his energy in that opening roar...",
			2.5);

	/** Special Attack - Dragon Punch */
	public SpecialAttack shoryuken = new SpecialAttack("Dragon Punch", "Hit your opponent with a devastating uppercut!",
			"The fighter lunges in before sending you airborne with a powerful uppercut!",
			"The fighter attempts to uppercut you, but you block it, leaving him wide open for a counterattack!", 2.25);

	/** Special Attack - Avalanche */
	public SpecialAttack snowfall = new SpecialAttack("Avalanche",
			"A polar bear's skill that allows them to send forth a volley of snow with their axe.",
			"The polar bear roars and swings its axe, causing snow to come forth and nearly free you solid!",
			"The polar bear roars and swings its axe... but accidentally freezes itself solid. Unfortunately, it was "
					+ "strong enough to break free.",
			2.5);

	/** Special Attack - Pale Fire */
	public SpecialAttack paleFire = new SpecialAttack("Pale Fire",
			"A skill made by fire knights after studying dragons.",
			"From the slits in its visor, the flame knights breathes forth a pale colored fire to burn you to cinders!",
			"From the slits in its visor, the flame knights breathes forth nothing but smoke...", 2.35);

	/** Special Attack - Night Slash */
	public SpecialAttack nightSlash = new SpecialAttack("Night Slash",
			"Allows the user to harness darkness itself to lash out in a deadly arc.",
			"Darkness lunges forth slicing everything in it's path.",
			"Darkness slashes outwards from the blade but was ineffective.", 2.5);

	// --------------------Dragon Special Attacks--------------------
	public SpecialAttack flameBreath = new SpecialAttack("Flame Breath",
			"The dragon conjures the flames from deep within its throat and in one powerful blast covers a large area with rampaging flames!",
			"The dragon opens its mouth, and deep from within its throat, flames begin to glow, as if being summoned from the gates of hell! "
					+ "Before you have time to react, you are surrounded in scorching flames!",
			"The dragon opens its mouth, and deep from within its throat, flames begin to glow, but then the dragon seems to get stunned from the heat "
					+ "it attempted to conjure! The dragon failed to fire its flames!",
			2.0);

	public SpecialAttack hellFire = new SpecialAttack("Hell Fire",
			"The dragon flies into the air makeing laps of the area and covering everything in site with scorching flames!",
			"The dragon dashes into the sky with the sheer power of the wind from its wings capable of knocking you over! As "
					+ "the beast soars overhead, it rain's fire down upon you, scorching everything in sight!",
			"The dragon dashes into the sky with the sheer power of the wind from its wings capable of knocking you over! Whatever "
					+ "is coming, you know it can't be good! You spot a boulder, and in a split second decision, you run for cover as the "
					+ "beast rains fire on the area. Your act of quick thinking saved you from the scorching flames!",
			2.5);

}
