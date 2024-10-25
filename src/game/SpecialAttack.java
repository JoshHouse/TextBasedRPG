package game;

public class SpecialAttack {

	// -------------------Variables-------------------
	
	protected String info;
	protected double atkMultiplier;

	// -------------------Constructors-------------------
	
	/**
	 * Base constructor
	 */
	public SpecialAttack() {
		this.info = "This weapon has no special attack.";
		this.atkMultiplier = 0.0;
	}

	/**
	 * Initializes all values
	 * 
	 * @param info          - Special attack's description.
	 * @param atkMultiplier - The amount to multiply the character's initial attack
	 *                      stat by.
	 */
	public SpecialAttack(String info, double atkMultiplier) {
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
			System.out.println("You " + this.info);
		} else {
			System.out.println("You attempted to " + this.info + " but you failed!");
		}

	}

	// --------------------------------Getters--------------------------------

	public String getInfo() {
		return info;
	}

	public double getAtkMultiplier() {
		return atkMultiplier;
	}
	
	// --------------------------------Setters--------------------------------
	
	public void setInfo(String inputInfo) {
		this.info = inputInfo;
	}
	
	public void setAtkMultiplier(double inputAtkMultiplier) {
		this.atkMultiplier = inputAtkMultiplier;
	}

	// ---------------------------Overridden Methods---------------------------

	@Override
	/**
	 * Classic toString method. Prints the description and multiplier of the special attack.
	 */
	public String toString() {
		return "-----Special Attack-----\n" +
				"Description: " + this.info + "\n" + 
				"Success Damage Mutiplier: " + this.atkMultiplier + "\n";
	}

}
