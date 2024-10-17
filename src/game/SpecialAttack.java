package game;

public class SpecialAttack {

	private String name;
	private String info;
	private double atkMultiplier;

	/**
	 * Base constructor
	 */
	public SpecialAttack() {
		this.name = "None";
		this.info = "This weapon has no special attack.";
		this.atkMultiplier = 0.0;
	}

	/**
	 * Initializes all values
	 * 
	 * @param name          - Special attack's name.
	 * @param info          - Special attack's description.
	 * @param atkMultiplier - The amount to multiply the character's initial attack
	 *                      stat by.
	 */
	public SpecialAttack(String name, String info, double atkMultiplier) {
		this.name = name;
		this.info = info;
		this.atkMultiplier = atkMultiplier;
	}

	/**
	 * Calls a luck event to determine if the character will be able to use their
	 * special attack or not.
	 * 
	 * @param luckVal - The character's initial luck value.
	 */
	void useSpAtk(int luckVal) {

		if (Luck.luckEvent(luckVal)) {
			System.out.println("Used " + getName() + "!");
		} else {
			System.out.println(getName() + " failed!");
		}

	}

	// --------------------------------Getters--------------------------------

	public String getInfo() {
		return info;
	}

	public String getName() {
		return name;
	}

	public double getAtkMultiplier() {
		return atkMultiplier;
	}

	// ---------------------------Overridden Methods---------------------------

	@Override
	/**
	 * Classic toString method. Prints the name and description of a special attack.
	 */
	public String toString() {
		return getName() + "\n" + getInfo() + "\n";
	}

}
