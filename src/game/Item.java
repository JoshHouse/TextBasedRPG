package game;

public class Item {
	
	/**
	 * 
	 * ----- Variables -----
	 * 
	 */
	
	private String Name;
	private String info;
	private String Rarity;
	private int Value;
	private int Damage;
	private String DamageType;
	private int Count;
	private Boolean IsSellable;
	
	/**
	 * 
	 * ----- Constructors -----
	 * 
	 */
	
	// Constructor that instantiates default values
	public Item() {
		this.Name = "No Name";
		this.info = "...";
		this.SetRarity(0);
		this.Value = 0;
		this.Damage = 0;
		this.DamageType = "No Damage Type";
		this.Count = 1;
		this.IsSellable = false;
	}
	// Constructor that instantiates all values
	public Item(String InputName, String info, int InputRarity, int InputValue, int InputDamage, int InputDamageType,
			int InputCount, Boolean InputIsSellable) {
		this.Name = InputName;
		this.info = info;
		this.Rarity = this.SetRarity(InputRarity);
		this.Value = InputValue;
		this.Damage = InputDamage;
		this.DamageType = this.SetDamageType(InputDamageType);
		this.Count = InputCount;
		this.IsSellable = InputIsSellable;
	}
	// Constructor that instantiates Items that are not sellable
	// Sets IsSellable to False and Value to 0
	public Item(String InputName, String info, int InputRarity, int InputDamage, int InputDamageType,
			int InputCount) {
		this.Name = InputName;
		this.info = info;
		this.Rarity = this.SetRarity(InputRarity);
		this.Value = 0;
		this.Damage = InputDamage;
		this.DamageType = this.SetDamageType(InputDamageType);
		this.Count = InputCount;
		this.IsSellable = false;
	}
	// Constructor that instantiates items with no damage
	// Sets Damage to 0 and DamageType to default No Damage Type String
	public Item(String InputName, String info, int InputRarity, int InputValue, int InputCount, Boolean InputIsSellable) {
		this.Name = InputName;
		this.info = info;
		this.Rarity = this.SetRarity(InputRarity);
		this.Value = InputValue;
		this.Damage = 0;
		this.DamageType = this.SetDamageType(0);
		this.Count = InputCount;
		this.IsSellable = InputIsSellable;
	}
	// Constructor that instantiates non-sellable items with no damage
	// Sets Value and Damage to 0, IsSellable to false, and DamageType to default No Damage Type string
	public Item(String InputName, String info, int InputRarity, int InputCount) {
		this.Name = InputName;
		this.info = info;
		this.Rarity = this.SetRarity(InputRarity);
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
	
	public String getInfo() {
		return this.info;
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
	
	public String SetRarity(int numRare) {
		
		switch(numRare) {
		
		case 1:
			return "Common";
		case 2:
			return "Uncommon";
		case 3:
			return "Rare";
		case 4:
			return "Epic";
		case 5:
			return "Legendary";
		default:
			return "None";
		
		}
		
	}
	
/*	public void SetRarity(String InputRarity) {
		this.Rarity = InputRarity;
	}*/
	
	public void SetValue(int InputValue) {
		this.Value = InputValue;
	}
	
	public void SetDamage(int InputDamage) {
		this.Damage = InputDamage;
	}
	
	public String SetDamageType(int typeInt) {
		
		switch (typeInt) {
		
		case 1:
			return "Melee";
		case 2:
			return "Magic";
		case 3:
			return "Projectile";
		case 4:
			return "Throwable";
		default:
			return "None";
		
		}
		
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
				this.info + "\n" +
				"Rarity: " + this.Rarity + "\n" +
				"Value: " + this.Value + "\n" +
				"Damage: " + this.Damage + "\n" +
				"Damage Type: " + this.DamageType + "\n" +
				"Count: " + this.Count + "\n" +
				"Is Sell-able?: " + this.IsSellable + "\n";
	}
}