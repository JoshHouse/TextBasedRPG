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
			" thrust out their blade thrice, yet their foe was quicker, and avoided all three strikes.", 
			3.0);

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
	
	

}