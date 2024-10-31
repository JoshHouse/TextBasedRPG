package game;

import java.util.ArrayList;

public class Hub {
	
	// -------------------Variables-------------------
	private Shop shop;
	private Enemy ExpEnemy;
	private Player player;
	private ArrayList<String> info;
	
	// -------------------Constructor-------------------
	public Hub(ArrayList<String> inputInfo, Player inputPlayer, Enemy inputExpEnemy, Shop inputShop) {
		
	}
	
	// -------------------Getters-------------------
	public ArrayList<String> getInfo() {
		return this.info;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Shop getShop() {
		return this.shop;
	}
	
	public Enemy getExpEnemy() {
		return this.ExpEnemy;
	}
	
	// -------------------Setters-------------------
	public void setInfo(ArrayList<String> inputInfo) {
		this.info = inputInfo;
	}
	
	public void setPlayer(Player inputPlayer) {
		this.player = inputPlayer;
	}
	
	public void setShop(Shop inputShop) {
		this.shop = inputShop;
	}
	
	public void setInfo(Enemy inputExpEnemy) {
		this.ExpEnemy = inputExpEnemy;
	}
}
