package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
	
	private Player player;
	private Enemy enemy;
	private int turn;
	
	//----------------------------------Constructor---------------------------------
	
public Battle(Player inputPlayer, Enemy inputEnemy) {
	this.setPlayer(inputPlayer);
	this.setEnemy(inputEnemy);
	this.setTurn(0);
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
		if(turn == 0)
			this.playerTurn(keyboard);
		
		else
			this.enemyTurn();
		
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

	


	private void useItem(Scanner keyboard) {
		System.out.println("Choose an item to use from your inventory:");
        player.getInventory().displayItems(); // Assuming Inventory has displayItems method
        int itemChoice = keyboard.nextInt();
        
        Consumable item = player.getInventory().getItem(itemChoice); // Retrieve the chosen item
        if (item != null) {
            player.consume(item); // Use the item, applying its effect to the player
            System.out.println("You used " + item.getName());
        } else {
            System.out.println("Invalid item choice.");
        }
	}


	private void guard() {
		System.out.println("You guard yourself from the next attack./n");
		player.setGuarding(true);
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
				enemy.setHealth(enemy.getHealth() - player.getEquipped().getDamage());
				isAttacking = false;
				break;
				
			case 2:
				System.out.println("You chose a special attack!/n");
				enemy.setHealth(enemy.getHealth() - player.getEquipped().getSpecialAttack().useSpAtk());
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
        
        if (player.isGuarding()) { // Reduce damage if the player is guarding
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
