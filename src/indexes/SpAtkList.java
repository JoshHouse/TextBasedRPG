package indexes;

import game.SpecialAttack;

public class SpAtkList {
	
	/**
	 * No special attack.
	 */
	SpecialAttack none = new SpecialAttack();
	
	/**
	 * Smash - Slam the weapon down with all your might to do a large amount of
	 * damage!
	 */
	SpecialAttack smash = new SpecialAttack("Smash",
			"Slam the weapon down with all your might to do a large amount of damage!", 1.8);

	/**
	 * Spinning Slash - Spin your body and your weapon around and use the momentum
	 * to dish out a large amount of damage!
	 */
	SpecialAttack spinSlash = new SpecialAttack("Spinning Slash",
			"Spin your body and your weapon around and use the momentum to dish out a large amount of damage!", 1.5);

	/**
	 * Double Slash - Perform two attacks at once by spinning the weapon vertically
	 * with great dexterity!
	 */
	SpecialAttack doubleSlash = new SpecialAttack("Double Slash",
			"Perform two attacks at once by spinning the weapon vertically with great dexterity!", 2.0);

	/**
	 * Thrust - Thrust out your weapon forward will all your might, and deal a great
	 * amount of damage!
	 */
	SpecialAttack thrust = new SpecialAttack("Thrust",
			"Thrust out your weapon forward will all your might, and deal a great amount of damage!", 1.3);

	/**
	 * Triple Thrust - Perform three quick thrusts of your sword before your
	 * opponent can retaliate!
	 */
	SpecialAttack triThrust = new SpecialAttack("Triple Thrust",
			"Perform three quick thrusts of your sword before your opponent can retaliate!", (1.3 * 3));

	/**
	 * Crunch - Crush your opponent with your mighty jaws!
	 */
	SpecialAttack crunch = new SpecialAttack("Crunch", "Crush your opponent with your mighty jaws!", 1.6);

}
