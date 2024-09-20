package game;

public class GameThread {
	public static void main(String args[]) {
		Weapon Sword = new Weapon("BroadSword", "Common", 10, 25, "Melee", true, 0, "Overhead Swing!");
		Weapon FireStaff = new Weapon("Fire Staff", "Legendary", 500, 75, "Magic", false, 20, "Fire Wall!");
		Item[] P1Inventory = {Sword, FireStaff};
		Player p1 = new Player("Gandalf The Great", 100, 10, 72, 50, "Magic", 750, P1Inventory, 3, 1, 1, 12, 7, 250);
		System.out.println(p1.toString());
	}
}