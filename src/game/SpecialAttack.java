package game;

public class SpecialAttack {

	// -------------------Variables-------------------

	private String name;
	private String info;
	private String hitTxt;
	private String missTxt;
	private double atkMultiplier;

	// -------------------Constructors-------------------

	/**
	 * Base constructor
	 */
	public SpecialAttack() {
		this.name = "None";
		this.info = "This weapon has no special attack.";
		this.hitTxt = "";
		this.missTxt = "";
		this.atkMultiplier = 1.0;
	}
	
	public SpecialAttack(SpecialAttack inputSpecialAttack) {
		this.setName(inputSpecialAttack.getName());
		this.setInfo(inputSpecialAttack.getInfo());
		this.setHitTxt(inputSpecialAttack.getHitTxt());
		this.setMissTxt(inputSpecialAttack.getMissTxt());
		this.setAtkMultiplier(inputSpecialAttack.getAtkMultiplier());
	}

	/**
	 * Initializes all values
	 * 
	 * @param info          - Special attack's description.
	 * @param atkMultiplier - The amount to multiply the character's initial attack
	 *                      stat by.
	 */
	public SpecialAttack(String name, String info, String hitTxt, String missTxt, double atkMult) {
		this.name = name;
		this.info = info;
		this.hitTxt = hitTxt;
		this.missTxt = missTxt;
		this.atkMultiplier = atkMult;
	}

	/**
	 * Calls a luck event to determine if the character will be able to use their
	 * special attack or not.
	 * 
	 * @param luckVal - The character's initial luck value.
	 */
	public boolean useSpAtk(int luckVal) {
		
		if (Luck.luckEvent(luckVal)) {
			Dialogue.infoDialogue(hitTxt, 30);
			return true;
		} else {
			Dialogue.infoDialogue(missTxt, 30);
			return false;
		}

	}

	// --------------------------------Getters--------------------------------

	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	public String getHitTxt() {
		return hitTxt;
	}

	public String getMissTxt() {
		return missTxt;
	}

	public double getAtkMultiplier() {
		return atkMultiplier;
	}

	// --------------------------------Setters--------------------------------

	public void setName(String name) {
		this.name = name;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setHitTxt(String hitTxt) {
		this.hitTxt = hitTxt;
	}

	public void setMissTxt(String missTxt) {
		this.missTxt = missTxt;
	}

	public void setAtkMultiplier(double atkMultiplier) {
		this.atkMultiplier = atkMultiplier;
	}
	
	// --------------------------------Functions--------------------------------

	/**
	 * Sends the special attack info for displaying.
	 * @return
	 */
	public String displayInfo() {
		return "\nSpecial Attack: " + this.name + "\n" + this.info + "\n";
	}

	// ---------------------------Overridden Methods---------------------------

	@Override
	/**
	 * Classic toString method. Prints the name, description, and multiplier of the
	 * special attack.
	 */
	public String toString() {
		return "-----" + this.name + "-----\n" + this.info + "\n" + "Attack Multipler: " + this.atkMultiplier + "\n";
	}

}
