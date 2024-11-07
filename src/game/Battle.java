package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
	
	private Player player;
	private Enemy enemy;
	private int turn;
	private int guardedTurn;
	
	//----------------------------------Constructor---------------------------------
	
public Battle(Player inputPlayer, Enemy inputEnemy) {
	this.setPlayer(inputPlayer);
	this.setEnemy(inputEnemy);
	this.setTurn(0);
	this.setguardedTurn(0);
}
	
	
	// ----------------------------------Getters---------------------------------
	
public Player getPlayer() {
	return this.player;
}

public Enemy getEnemy() {
	return this.enemy;
}

public int getTurn() {
	return this.turn;
}

public int getguardedTurn() {
	return this.guardedTurn;
}

	//----------------------------------Setters---------------------------------

public void setPlayer(Player inputPlayer) {
	this.player = inputPlayer;
}

public void setEnemy(Enemy inputEnemy) {
	this.enemy = inputEnemy;
}

public void setTurn(int inputTurn) {
	this.turn = inputTurn;
}

public void setguardedTurn(int inputGTurn) {
	this.guardedTurn = inputGTurn;
}

//----------------------------------Functions---------------------------------

public static void breakLine() {  
    System.out.println("------------------------------");
}

public boolean startBattle() {
	int battleMenu = 0;
	boolean inBattle = true;
	Scanner keyboard = new Scanner(System.in);
	
	System.out.println("Welcome to the Battle Arena!/n");
	System.out.println("Your opponent: " + this.getEnemy());
	breakLine();
	
	while(inBattle) {
		if(turn == 0) {
			this.playerTurn(keyboard);
		}
		else {
			this.enemyTurn();
		}
		if (player.getHealth() <= 0) { //Check if battle continues after each turn
            System.out.println("You have been defeated!");
            System.out.println("Leaving the Battle Arena.");
            return false;
        } else if (enemy.getHealth() <= 0) {
            System.out.println("You defeated the enemy!");
            return true;
        } else {
            changeTurn(); // Change turn only if battle continues
        }
		
	}
	
	keyboard.close();
	return false;
	
}



	private void playerTurn(Scanner keyboard) {
		System.out.print("What would you like to do?\n" + 
				"1) Attack\n" + 
				"2) Guard\n" + 
				"3) Use Item\n" +
				"4) Flee/n");
			int pChoice = keyboard.nextInt();
		
			switch(pChoice) {
		
			case 1:
				this.playerAttack(keyboard);
				breakLine();
				break;
			case 2:
				this.guard();
				breakLine();
				break;
			case 3:
				this.useItem(keyboard);
				breakLine();
				break;
			case 4:
				System.out.println("You fled the battle."); // error
				breakLine();
				System.exit(0); //Exits program but I want to go back to hub
				break;
			default:
				breakLine();
				System.err.println("Invalid error! Your player looked intensely at " + this.getEnemy() + "/n");
				break;
			}
}
	
	
	private void printInventoryConsumableArray(ArrayList<Consumable> arrayList) {
		for(int x = 0; x < arrayList.size(); x++) {
			System.out.println(x+1 + ") " + arrayList.get(x).getName() + 
					"\t Value: " + arrayList.get(x).getValue());
		}
	}

	
	private void enemyDefeat() {
		System.out.println("You have defeated " + enemy);
	}
	


	private void useItem(Scanner keyboard) {
		System.out.println("Choose an item to use from your inventory:");
        
        
        
        
        
	}


	private void guard() {
		System.out.println("You guard yourself from the next attack./n");
		
	}


	private void playerAttack(Scanner keyboard) {
		boolean isAttacking = true;
		int pChoice = 0;
		
		breakLine();
		
		
		while(isAttacking) {
			System.out.println("You chose to go on the offensive!/n" + 
					"1) Standard Attack\n" + 
					"2) Special Attack\n" + 
					"3) Cancel");
			pChoice = keyboard.nextInt();
			
			switch(pChoice) {
			
			case 1:
				System.out.println("You chose a standard attack!/n");
				enemy.setHealth(enemy.getHealth() - player.getInventory().getEquipped().getDamage());
				isAttacking = false;
				break;
				
			case 2:
				System.out.println("You chose a special attack!/n");
				enemy.setHealth(enemy.getHealth() - player.getInventory().getEquipped().getSpecialAttack().useSpAtk());
				isAttacking = false;
				break;
				
			case 3:
				System.out.println("You resheathed your weapon./n");
				isAttacking = false;
				break;
			
			default:
				System.out.println("Invalid input, you stood there menacignly. Try again.");
				break;
			}
		}
			
		System.out.println("Enemy health:" + this.getEnemy());
		
	}


	private void enemyTurn() {
		System.out.println("The enemy attacked you!\n");
        int damage = enemy.getDamage();
        
        if (player.guard(0)) { // Reduce damage if the player is guarding
            damage /= 2;
            System.out.println("You guarded against the attack, reducing the damage!");
            player.setGuarding(false);
        }
        
        int newHealth = player.getHealth();
        player.setHealth(newHealth);
        System.out.println("Your HP: " + newHealth);
	
	}
	
	
	
	public void changeTurn() {
		if(this.getTurn() == 0) 
			this.setTurn(1);
		else
			this.setTurn(0);
	}

}
