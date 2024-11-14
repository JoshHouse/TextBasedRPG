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
			if (guardedTurn > 0) {
				guardedTurn--;
			}
		}
		else {
			this.enemyTurn();
		}
		if (player.getCurrHP() <= 0) { //Check if battle continues after each turn
            System.out.println("You have been defeated!");
            System.out.println("Leaving the Battle Arena.");
            return false;
        } else if (enemy.getCurrHP() <= 0) {
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
				; //Exits program but I want to go back to hub
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
	

// add different arrow ammos
	private void useItem(Scanner keyboard, ArrayList<Consumable> arrayList) {
        System.out.println("Choose an item to use from your inventory:");
        printInventoryConsumableArray(arrayList);

        System.out.println("Enter the number of the item to use, or 0 to cancel:");

        int choice;
        try {
            choice = keyboard.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        if (choice == 0) {
            System.out.println("Action canceled.");
            return;
        }

        if ((choice - 1) < 1 || (choice - 1) > arrayList.size()) {
            System.out.println("Invalid choice. Please select a valid item number.");
            return;
        }

        Consumable selectedItem = arrayList.get(choice - 1);
// need help
        switch (selectedItem.getKey()) {
        case "Health Potion":
            System.out.println("You used a Health Potion! Restoring health...");
            // Add health restoration
            break;
        case "Mana Potion":
            System.out.println("You used a Mana Potion! Restoring mana...");
            // Add mana restoration
            break;
        case "Damage Boost Potion":
            System.out.println("You used a Damage Boost Potion! Boosting damage...");
            // Add damage boost
            break;
        case "Speed Potion":
        	System.out.println("You used a Speed Potion! You get two turns...");
        	// Add changeturn counter
        	break;
        case "Poison Potion":
        	System.out.println("You used a Poison Potion! Enemy damaged over two turns...");
        default:
            System.out.println("Unknown item type. Unable to use item.");
            break;
    }
        
        
        
	}


	private void guard() {
		System.out.println("You guard yourself from the next three attacks./n");
		guardedTurn = 4;
		
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
				enemy.setHealth((int) (enemy.getHealth() - player.getInventory().getEquipped().getDamage()));
				isAttacking = false;
				break;
				
			case 2:
				System.out.println("You chose a special attack!/n");
				if(player.getInventory().getEquipped().getSpecialAttack().useSpAtk(80)) {
					enemy.setCurrHP((int)(enemy.getCurrHP() - (player.getInventory().getEquipped().getDamage() * player.getInventory().getEquipped().getSpecialAttack().getAtkMultiplier())));
				}
				isAttacking = false;
				break;
				
			case 3:
				System.out.println("You resheathed your weapon./n");
				isAttacking = false;
				breakLine();
				break;
			
			default:
				System.out.println("Invalid input, you stood there menacignly. Try again./n");
				break;
			}
		}
			
		System.out.println("Enemy health:" + this.getEnemy());
		
		breakLine();
		
	}


	private void enemyTurn() {
		
		
        if(Luck.luckEvent(40)) {
        	// Special Attack Functionality
        	if(enemy.getSpecialAttack().useSpAtk(70)) {
            	if (guardedTurn > 0) {
            		player.setCurrHP((int) (player.getCurrHP() - ((enemy.getDamage() * enemy.getSpecialAttack().getAtkMultiplier()) / 2)));
            	} else {
            		player.setCurrHP((int) (player.getCurrHP() - (enemy.getDamage() * enemy.getSpecialAttack().getAtkMultiplier())));
            	}
        	}

        } else {
        	// Regular Attack Functionality
        	if (guardedTurn > 0) {
        		player.setCurrHP((int) (player.getCurrHP() - enemy.getDamage()));
        	}
        }
        
		
        System.out.println("Your HP: " + player.getCurrHP());
        
        breakLine();
	
	}
	
	
	
	public void changeTurn() {
		if(this.getTurn() == 0) 
			this.setTurn(1);
		else
			this.setTurn(0);
	}

}
