package indexes;

import game.Consumable;

public class ConsumableList {
	
	// Health Potions
	public Consumable chapter1Health = new Consumable( "f700", "Lesser Healing Potion", 
			"A magical potion that heals 50 health when consumed!", 1, 50,
			50, 1, true, 1, true, 'h');
	public Consumable chapter2Health = new Consumable("f701", "Healing Potion", 
			"A magical potion that heals 100 health when consumed!", 2, 200,
			100, 1, true, 1, true, 'h');
	public Consumable chapter3Health = new Consumable("f702", "Greater Healing Potion", 
			"A magical potion that heals 150 health when consumed!", 3, 1000,
			150, 1, true, 1, true, 'h');
	public Consumable chapter4Health = new Consumable("f703", "Massive Healing Potion", 
			"A magical potion that heals 200 health when consumed!", 4, 5000,
			200, 1, true, 1, true, 'h');
	
	// Mana Potions
	public Consumable chapter1Mana = new Consumable("f710", "Lesser Mana Potion", 
			"A magical potion that regenerates 50 mana when consumed!", 1, 50, 
			50, 1, true, 1, true, 'm');
	public Consumable chapter2Mana = new Consumable("f711", "Mana Potion", 
			"A magical potion that regenerates 125 mana when consumed!", 2, 200, 
			125, 1, true, 1, true, 'm');
	public Consumable chapter3Mana = new Consumable("f712", "Greater Mana Potion", 
			"A magical potion that regenerates 200 mana when consumed!", 3, 1000, 
			200, 1, true, 1, true, 'm');
	public Consumable chapter4Mana = new Consumable("f713", "Massive Mana Potion", 
			"A magical potion that regenerates 275 mana when consumed!", 4, 5000, 
			275, 1, true, 1, true, 'm');
	
	// Poison Potions
	public Consumable chapter1Poison = new Consumable("f720", "Splash Potion of Poison",
			"Throw this powerful potion at enemies to make them take 30 damage over its next 3 turns!", 
			1, 100, 30, 1, true, 1, true, 'p');
	public Consumable chapter2Poison = new Consumable("f721", "Splash Potion of Deadly Toxin",
			"Throw this powerful potion at enemies to make them take 50 damage over its next 3 turns!", 
			2, 400, 50, 1, true, 1, true, 'p');
	public Consumable chapter3Poison = new Consumable("f722", "Splash Potion of Snake Venom",
			"Throw this powerful potion at enemies to make them take 100 damage over its next 3 turns!", 
			3, 1500, 100, 1, true, 1, true, 'p');
	public Consumable chapter4Poison = new Consumable("f723", "Splash Potion of Toxic Waste",
			"Throw this powerful potion at enemies to make them take 500 damage over its next 3 turns!", 
			4, 7000, 500, 1, true, 1, true, 'p');
	
	// Speed Potions
	public Consumable speed = new Consumable("f730", "Potion of Swiftness",
			"Drink this potion to dramatically increase your speed! This will allow you to get 2 turns in battle!",
			2, 500, 0, 1, true, 1, true, 's');
	
	// DamageBoost Potions
	public Consumable damageBoost = new Consumable("f740", "Potion of Focused Strength",
			"Drink this potion to dramatically increase your striking power! This will make you do 1.5x damage for the next 3 turns in battle!",
			2, 1000, 0, 1, true, 1, true, 'd');
}
