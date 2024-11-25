package indexes;

import game.SpecialAttack;

public class SpAtkList {

	// Constructor for SpecialAttack Object:
	// (String) Name, (String) Info, (String) HitText, (String) MissTxt, (double) AttackMultiplier
	
	
	/** No special attack. */
	public SpecialAttack none = new SpecialAttack();

	// --------------------Melee Special Attacks--------------------

	/** Special Attack - Triple Thrust. */
	public SpecialAttack x3Thrust = new SpecialAttack("Triple Thrust",
			"Ready your weapon and perform three consecutive thrusts in a row, dealing triple damage to your enemy!",
			" thrusts out their blade, striking their foe thrice before they can retaliate!",
			" thrust out their blade thrice, yet their foe was quicker, and avoided all three strikes.", 3.0);

	/** Special Attack - Great Slash. */
	public SpecialAttack gSlash = new SpecialAttack("Great Slash",
			"Peform a powerful upwards slash that threatens to tear your enemy in two!",
			" holds their blade behind them and charges forward, swinging upwards with all their might\n"
					+ "as if aiming to split the clouds in two.",
			" holds their blade behind them and charges forward, yet misses their foe as they swing towards the sky.",
			1.3);

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
	
	/** Special Attack - Floating Cloud*/
	public SpecialAttack floatCloud = new SpecialAttack("Floating Cloud",
			"The signature move of the \"Cloudwalker\". A flashy sword combo that involves moving one's body so light, it\n"
			+ "appears that they are floating in the air.",
			" moves so lightly as they swing their blade, slashing their opponent as they appear to be walking on air!",
			" appears to attempt to fly. Unfortunately, they do not have wings.",
			2.1);

	/** Special Attack - Breath of the Phoenix*/
	public SpecialAttack phoenix = new SpecialAttack("Breath of the Phoenix",
			"By spinning the Phoenix Cleaver above your head, you create a tornado made from flames that are said to\n burn as"
					+ " hot as a phoenix breathing fire.",
			" holds the greatxe over their head and rapidly spins it around, giving birth to a mighty tornado to reduce\ntheir"
					+ "enemies to ashes!",
			" holds the greataxe over their head and spins it around... but the flames refused to emerge to consume their foe.",
			3.0);
	
	// --------------------Ranged Special Attacks--------------------

	/** Special Attack - Piercing Shot. */
	public SpecialAttack piercingShot = new SpecialAttack("Piercing Shot",
	        "Take careful aim and fire an arrow that pierces through multiple enemies, dealing increased damage to all targets in a line.",
	        " carefully takes aim, releasing an arrow that cuts through the air with precision, striking multiple foes in its path!",
	        " carefully takes aim, but their arrow misses its mark, vanishing into the distance.",
	        2.0);

	/** Special Attack - Explosive Arrow. */
	public SpecialAttack explosiveArrow = new SpecialAttack("Explosive Arrow",
	        "Fire an arrow tipped with an explosive charge that detonates on impact, dealing splash damage to all nearby enemies.",
	        " fires an explosive arrow that streaks through the air before detonating in a fiery explosion, engulfing enemies in flames!",
	        " fires an explosive arrow, but it fizzles out and harmlessly hits the ground.",
	        2.5);

	/** Special Attack - Frostbite Arrow. */
	public SpecialAttack frostbiteArrow = new SpecialAttack("Frostbite Arrow",
	        "Unleash an ice-tipped arrow that chills the target to the bone, slowing their movements and dealing damage over time.",
	        " fires an icy arrow that strikes their foe, encasing their limbs in frost and sapping their strength with freezing cold!",
	        " fires an icy arrow, but their opponent dodges it, leaving the air around them cold but harmless.",
	        1.8);

	/** Special Attack - Rain of Arrows. */
	public SpecialAttack rainOfArrows = new SpecialAttack("Rain of Arrows",
	        "Leap into the air and unleash a volley of arrows that rain down on enemies in a wide area, dealing significant damage.",
	        " leaps into the air, firing a flurry of arrows that rain down upon their foes, leaving devastation in their wake!",
	        " leaps into the air, but the arrows scatter harmlessly, leaving their opponents unscathed.",
	        2.2);

	/** Special Attack - Flaming Volley. */
	public SpecialAttack flamingVolley = new SpecialAttack("Flaming Volley",
	        "Launch a volley of fire arrows that explode upon impact, creating a fiery inferno to burn enemies over time.",
	        " releases a blazing volley of fire arrows, igniting the battlefield in an inferno that scorches everything in its path!",
	        " fires a blazing volley, but the arrows fail to ignite, leaving their enemies unharmed.",
	        2.8);

	/** Special Attack - Phantom Arrow. */
	public SpecialAttack phantomArrow = new SpecialAttack("Phantom Arrow",
	        "Summon a magical arrow of pure energy that seeks out the target with unerring accuracy, bypassing defenses.",
	        " conjures a glowing arrow of energy that streaks unerringly towards its target, bypassing all defenses to strike true!",
	        " summons a glowing arrow of energy, but it fizzles out before reaching its target.",
	        3.0);

	/** Special Attack - Gale Shot. */
	public SpecialAttack galeShot = new SpecialAttack("Gale Shot",
	        "Fire an arrow infused with wind magic that generates a powerful gale, pushing back enemies and dealing area damage.",
	        " fires a wind-infused arrow that creates a howling gale, knocking enemies back and causing them to stumble!",
	        " fires a wind-infused arrow, but the gust is too weak to affect their enemies.",
	        2.0);

	
	// --------------------Magic Special Attacks--------------------
	/** Special Attack - Power Beam */
	public SpecialAttack pBeam = new SpecialAttack("Power Beam", 
			"Shoots a deadly beam capable of putting a hole straight through whatever its pointed at!",
			"Beams of light converge on the weapon, firing a blast of charged up energy!",
			"Beams of light begin to converge on the weapon but quickly fizzle out! The power beam failed to fire!",
			1.3);
	
	// --------------------Rogue Special Attacks--------------------
	
	// --------------------Enemy Special Attacks--------------------
	
	public SpecialAttack fireWall = new SpecialAttack("Fire Wall", 
			"Creates a blazing wall of flames capable of incinerating anything in its path!", 
			"A blazing wall materializes on the battlefield burning everything it touches!", 
			"A blazing wall begins to appear but fizzles out! The fire wall failed to materialize!", 
			2.0);
	
	public SpecialAttack erruption = new SpecialAttack("Erruption",
			"Splits the ground beneath its target blasting pillars of fire from the deapths of the earth!",
			"The ground begins to tremble as cracks begin to form! The earth splits open covering "
			+ "the battlefield with blazing pillars from the deapths of the earth!",
			"The ground begins to rumble and cracks begin to form but quickly slam shut! The erruption fails to occur!",
			2.5);
	
	/** Special Attack - Rampaging Tusks. */
	public SpecialAttack kioqSpAtk = new SpecialAttack("Rampaging Tusks",
			"Kioq goes on a rampage! No one, friend or foe, should be around the champion when he starts swinging his axes!",
			"Kioq roars like a wild animal before charging forth, swinging his axes back "
					+ "and forth widly while striking everything in his path!",
			"Kioq roars loudly as if to prepare for an attack... but he suddenly keels over to catch his breath, as if he used "
					+ "up all of his energy in that opening roar...",
			2.5);
	
	// --------------------Dragon Special Attacks--------------------
	public SpecialAttack flameBreath = new SpecialAttack("Flame Breath", 
			"The dragon conjures the flames from deep within its throat and in one powerful blast covers a large area with rampaging flames!", 
			"The dragon opens its mouth, and deep from within its throat, flames begin to glow, as if being summoned from the gates of hell! "
			+ "Before you have time to react, you are surrounded in scorching flames!",  
			"The dragon opens its mouth, and deep from within its throat, flames begin to glow, but then the dragon seems to get stunned from the heat "
			+ "it attempted to conjure! The dragon failed to fire its flames!", 2.0);
	
	public SpecialAttack hellFire = new SpecialAttack("Hell Fire", 
			"The dragon flies into the air makeing laps of the area and covering everything in site with scorching flames!", 
			"The dragon dashes into the sky with the sheer power of the wind from its wings capable of knocking you over! As "
			+ "the beast soars overhead, it rain's fire down upon you, scorching everything in sight!",
			"The dragon dashes into the sky with the sheer power of the wind from its wings capable of knocking you over! Whatever "
			+ "is coming, you know it can't be good! You spot a boulder, and in a split second decision, you run for cover as the "
			+ "beast rains fire on the area. Your act of quick thinking saved you from the scorching flames!", 2.5);
	
	

}