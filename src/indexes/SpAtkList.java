package indexes;

import game.SpecialAttack;

public class SpAtkList {

	// Constructor for SpecialAttack Object:
	// (String) Name, (String) Info, (String) HitText, (String) MissTxt, (double) AttackMultiplier
	
	
	/** No special attack. */
	public static SpecialAttack none = new SpecialAttack();

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
	
	// --------------------Ranged Special Attacks--------------------
	
	// --------------------Magic Special Attacks--------------------
	/** Special Attack - Power Beam */
	public static SpecialAttack pBeam = new SpecialAttack("Power Beam", 
			"Shoot a deadly beam capable of putting a hole straight through your enemy!",
			"Beams of light converge on your weapon, firing a blast of charged up energy!",
			"Beams of light begin to converge on your weapon but quickly fizzle out! You failed to fire off the beam!",
			1.3);
	
	// --------------------Rogue Special Attacks--------------------

}