package game;

public class Item {
	
	/**
	 * 
	 * ----- Variables -----
	 * 
	 */
	
	String Name;
	String Rarity;
	int Value;
	int Damage;
	String DamageType;
	int Count;
	Boolean IsSellable;
	
	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */
	
	// Constructor that instantiates default values
	public Item() {
		this.Name = "No Name";
		this.Rarity = "Common";
		this.Value = 0;
		this.Damage = 0;
		this.DamageType = "No Damage Type";
		this.Count = 1;
		this.IsSellable = false;
	}
	// Constructor that instantiates all values
	public Item(String InputName, String InputRarity, int InputValue, int InputDamage, String InputDamageType,
			int InputCount, Boolean InputIsSellable) {
		this.Name = InputName;
		this.Rarity = InputRarity;
		this.Value = InputValue;
		this.Damage = InputDamage;
		this.DamageType = InputDamageType;
		this.Count = InputCount;
		this.IsSellable = InputIsSellable;
	}
	// Constructor that instantiates Items that are not sellable
	// Sets IsSellable to False and Value to 0
	public Item(String InputName, String InputRarity, int InputDamage, String InputDamageType,
			int InputCount) {
		this.Name = InputName;
		this.Rarity = InputRarity;
		this.Value = 0;
		this.Damage = InputDamage;
		this.DamageType = InputDamageType;
		this.Count = InputCount;
		this.IsSellable = false;
	}
	// Constructor that instantiates items with no damage
	// Sets Damage to 0 and DamageType to default No Damage Type String
	public Item(String InputName, String InputRarity, int InputValue, int InputCount, Boolean InputIsSellable) {
		this.Name = InputName;
		this.Rarity = InputRarity;
		this.Value = InputValue;
		this.Damage = 0;
		this.DamageType = "No Damage Type";
		this.Count = InputCount;
		this.IsSellable = InputIsSellable;
	}
	// Constructor that instantiates non-sellable items with no damage
	// Sets Value and Damage to 0, IsSellable to false, and DamageType to default No Damage Type string
	public Item(String InputName, String InputRarity, int InputCount) {
		this.Name = InputName;
		this.Rarity = InputRarity;
		this.Value = 0;
		this.Damage = 0;
		this.DamageType = "No Damage Type";
		this.Count = InputCount;
		this.IsSellable = false;
	}
	
	/**
	 * 
	 * ----- Getters -----
	 * 
	 */
	
	public String GetName() {
		return this.Name;
	}
	
	public String GetRarity() {
		return this.Rarity;
	}
	
	public int GetValue() {
		return this.Value;
	}
	
	public int GetDamage() {
		return this.Damage;
	}
	
	public String GetDamageType() {
		return this.DamageType;
	}
	
	public int GetCount() {
		return this.Count;
	}
	
	public Boolean GetIsSellable() {
		return this.IsSellable;
	}
	
	/**
	 * 
	 * ----- Setters -----
	 * 
	 */
	
	public void SetName(String InputName) {
		this.Name = InputName;
	}
	
	public void SetRarity(String InputRarity) {
		this.Rarity = InputRarity;
	}
	
	public void SetValue(int InputValue) {
		this.Value = InputValue;
	}
	
	public void SetDamage(int InputDamage) {
		this.Damage = InputDamage;
	}
	
	public void SetDamageType(String InputDamageType) {
		this.DamageType = InputDamageType;
	}
	
	public void SetCount(int InputCount) {
		this.Count = InputCount;
	}
	
	public void SetIsSellable(Boolean InputIsSellable) {
		this.IsSellable = InputIsSellable;
	}
	
	/**
	 * 
	 * ----- ToString method -----
	 * 
	 */
	
	public String toString() {
		return "Name: " + this.Name + "\n" +
				"Rarity: " + this.Rarity + "\n" +
				"Value: " + this.Value + "\n" +
				"Damage: " + this.Damage + "\n" +
				"Damage Type: " + this.DamageType + "\n" +
				"Count: " + this.Count + "\n" +
				"Is Sell-able?: " + this.IsSellable + "\n";
	}
}