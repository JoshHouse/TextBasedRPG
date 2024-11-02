package indexes;

import game.SpecialAttack;

public class SpAtkList {

	/** No special attack. */
	public static SpecialAttack none = new SpecialAttack();

	/** Triple Thrust. */
	public SpecialAttack x3Thrust = new SpecialAttack("Triple Thrust",
			"Ready your weapon and perform three consecutive thrusts in a row, dealing triple damage to your enemy!",
			" thrusts out their blade, striking their foe thrice before they can retaliate!",
			" thrust out their blade thrice, yet their foe was quicker, and avoided all three strikes.", 3.0);

}