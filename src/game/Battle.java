package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
	
	private Player player;
	private Enemy enemy;
	private int turn;
	private int guardedTurn;
	private int dbTurn;
	private int speedTurn;
	private int poisonTurn;
	private int poisonDamage;
	
	
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

public int getDbTurn() {
	return this.dbTurn;
}

public int getSpeedTurn() {
	return this.speedTurn;
}

public int getPoisonTurn() {
	return this.poisonTurn;
}

public int getPoisonDamage() {
	return this.poisonDamage;
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

public void setDbTurn(int inputDbTurn) {
	this.dbTurn = inputDbTurn;
}

public void setSpeedTurn(int inputSpeedTurn) {
	this.speedTurn = inputSpeedTurn;
}

public void setPoisonTurn(int inputPoisonTurn) {
	this.poisonTurn = inputPoisonTurn;
}

public void setPoisonDamage(int inputPoisonDamage) {
	this.poisonDamage = inputPoisonDamage;
}

//----------------------------------Functions---------------------------------

public static void breakLine() {  
    System.out.println("------------------------------");
}

public boolean startBattle() {
	boolean inBattle = true;
	Scanner keyboard = new Scanner(System.in);
	boolean isWimp = false;
	
	System.out.println("Welcome to the Battle Arena!/n");
	System.out.println("Your opponent: " + this.getEnemy());
	breakLine();
	
	while(inBattle) {
		if (speedTurn > 0) {
			isWimp = this.playerTurn(keyboard);
			if (isWimp) {
				keyboard.close();
				return false;
			}
			speedTurn--;
		} else {
			if(turn == 0) {
				this.playerTurn(keyboard);
				if (isWimp) {
					keyboard.close();
					return false;
				}
				
				if (guardedTurn > 0) {
					guardedTurn--;
				}
				if (dbTurn > 0) {
					dbTurn--;
				}
			}
			else {
				this.enemyTurn();
				if (poisonTurn > 0) {
					poisonTurn--;
					if (poisonTurn == 0) {
						this.setPoisonDamage(0);
					}
				}
			}
			if (player.getCurrHP() <= 0) { //Check if battle continues after each turn
	            System.out.println("You have been defeated!");
	            System.out.println("Leaving the Battle Arena.");
	            keyboard.close();
	            return false;
	        } else if (enemy.getCurrHP() <= 0) {
	            System.out.println("You defeated the enemy!");
	            keyboard.close();
	            return true;
	        } else {
	            changeTurn(); // Change turn only if battle continues
	        }
		}
		
	}
	
	keyboard.close();
	return false;
	
}



	private boolean playerTurn(Scanner keyboard) {
		int pChoice;
		boolean isPTurn = true;
		
		while (isPTurn) {
			System.out.print("What would you like to do?\n" + 
					"1) Attack\n" + 
					"2) Guard\n" + 
					"3) Use Item\n" +
					"4) Flee/n");
			try {
				pChoice = keyboard.nextInt();
				
				switch(pChoice) {
			
				case 1:
					isPTurn = !(this.playerAttack(keyboard));
					breakLine();
					return false;
					
				case 2:
					this.guard();
					isPTurn = false;
					breakLine();
					return false;
					
				case 3:
					isPTurn = !(this.selectItem(keyboard));
					breakLine();
					return false;
					
				case 4:
					System.out.println("You fled the battle."); 
					breakLine();
					return true; // sets isWimp boolean to true in the start battle function
					
				default:
					breakLine();
					System.err.println("Invalid input! Your player looked intensely at " + this.getEnemy() + ". Try again!/n");
					break;
				}
			} catch (NumberFormatException e) {
				System.err.println("Invalid input. Please enter a number.");
			}
			
		}
		return true;

}
	private void printInventoryConsumableArray(ArrayList<Consumable> arrayList) {
		for(int x = 0; x < arrayList.size(); x++) {
			System.out.println(x+1 + ") " + arrayList.get(x).getName() + 
					"\n Info: " + arrayList.get(x).getInfo());
		}
	}
	

// add different arrow ammos
	private boolean selectItem(Scanner keyboard) {
        ArrayList<Consumable> pInventory = player.getInventory().getConsumables();
		boolean makingChoice = true;
		boolean usedItem = false;
        int choice;
        
		while (makingChoice) {
	        System.out.println("Choose an item to use from your inventory:");
	        printInventoryConsumableArray(pInventory);
	        System.out.println(pInventory.size()+1 + ") Cancel ");

	        System.out.println("Make your choice:");


	        try {
	            choice = keyboard.nextInt();
	            if (choice == pInventory.size() + 1) {
		            System.out.println("Action canceled.");
		            return false;
		            
		        } else if (choice - 1 >= 0 && choice - 1 < pInventory.size()) {
		            usedItem = this.useItem(pInventory, choice - 1);
		            if (!usedItem) {
		            	return false;
		            }
		            return true;
		        	
		        } else {
		            System.out.println("Invalid choice. Please select a valid item number.");
		        }    
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a number.");
	        }
	        
		}
		return false;
        
	}

	private boolean useItem(ArrayList<Consumable> pInventory, int itemIndex) {
        switch (pInventory.get(itemIndex).getConsumableType()) {
        case 'd':
        	System.out.println("You used a Damage Boost Potion! Boosting damage...");
        	this.setDbTurn(4);
        	System.out.println("You successfully used your Damage Boost Potion. You will now do 1.5x damage for "
        			+ "the next 3 turns!");
        	this.removeItem(pInventory, itemIndex);
        	return true;

        case 'h':
            if (player.getCurrHP() + pInventory.get(itemIndex).getDamage() < player.getHealth()) {
            	player.setCurrHP((int) (player.getCurrHP() + pInventory.get(itemIndex).getDamage()));
            } else {
            	player.setCurrHP(player.getHealth());
            }
            System.out.println("You used a Health Potion! Restoring health...");
            System.out.println("You successfully used a health potion! Your health is now: " + player.getCurrHP());
        	this.removeItem(pInventory, itemIndex);
        	return true;

        case 'm':
        	if (player.getCurrMana() + pInventory.get(itemIndex).getDamage() < player.getMana()) {
        		player.setCurrMana((int)(player.getCurrMana() + pInventory.get(itemIndex).getDamage()));
        	} else {
        		player.setCurrMana(player.getMana());
        	}
        	System.out.println("You used a Mana Potion! Restoring mana...");
        	System.out.println("You successfully used a mana potion! Your mana is now: " + player.getCurrMana());
        	this.removeItem(pInventory, itemIndex);
        	return true;
        	
        case 's':
        	this.setSpeedTurn(this.getSpeedTurn() + 2);
        	System.out.println("You used a Speed Potion! You get two turns...");
        	this.removeItem(pInventory, itemIndex);
        	return true;

        case 'p':
        	if (this.getPoisonTurn() > 0) {
        		System.out.println("You cannot use a poison potion while another is already applied to this enemy!");
        		return false;
        	} else {
            	this.setPoisonTurn(this.getPoisonTurn() + 3);
            	this.setPoisonDamage((int) (pInventory.get(itemIndex).getDamage()));
            	System.out.println("You used a Poison Potion! The Enemy will be damaged for three turns...");
            	this.removeItem(pInventory, itemIndex);
            	return true;
        	}
        	
        default:
            System.out.println("Unknown item type. Unable to use item.");
            return false;
        }

	}
	
	private void removeItem(ArrayList<Consumable> pInventory, int itemIndex) {
		if (pInventory.get(itemIndex).getCount() > 1) {
			pInventory.get(itemIndex).setCount(pInventory.get(itemIndex).getCount() - 1);
		} else {
			pInventory.remove(itemIndex);
		}
	}

	private void guard() {
		System.out.println("You guard yourself from three attacks./n");
		this.setguardedTurn(this.getguardedTurn() + 4);
		
	}


	private boolean playerAttack(Scanner keyboard) {
		boolean isAttacking = true;
		int pChoice = 0;
		
		
		while(isAttacking) {
			breakLine();
			System.out.println("You chose to go on the offensive!/n" + 
					"1) Standard Attack\n" + 
					"2) Special Attack\n" + 
					"3) Cancel");
			try {
				pChoice = keyboard.nextInt();
				
				switch(pChoice) {
				
				case 1:
					switch (player.getInventory().getEquipped().getDamageType()) {
					case "Melee":
						this.standardAttack();
						break;
					case "Ranged":
						
						break;
					case "Mage":
						
						break;
					case "Rogue":
						this.standardAttack();
						break;
					}
					
					

					
//					System.out.println("You chose a standard attack!/n");
//					if (dbTurn > 0) {
//						enemy.setCurrHP((int) (enemy.getCurrHP() - (player.getInventory().getEquipped().getDamage() * 1.5)));
//						System.out.println("You did " +  (player.getInventory().getEquipped().getDamage() * 1.5) + " damage!");
//					} else {
//						enemy.setCurrHP((int) (enemy.getCurrHP() - player.getInventory().getEquipped().getDamage()));
//						System.out.println("You did " + player.getInventory().getEquipped().getDamage() + " damage!");
//					}

					System.out.println("Enemy health:" + enemy.getCurrHP());
					return true;
					
				case 2:
					System.out.println("You chose a special attack!/n");
					if(player.getInventory().getEquipped().getSpecialAttack().useSpAtk(80)) {
						if (dbTurn > 0) {
							enemy.setCurrHP((int)(enemy.getCurrHP() - ((player.getInventory().getEquipped().getDamage() * player.getInventory().getEquipped().getSpecialAttack().getAtkMultiplier()) * 1.5)));
							System.out.println("You did " + ((player.getInventory().getEquipped().getDamage() * player.getInventory().getEquipped().getSpecialAttack().getAtkMultiplier()) * 1.5) + " damage!");
						} else {
							enemy.setCurrHP((int)(enemy.getCurrHP() - (player.getInventory().getEquipped().getDamage() * player.getInventory().getEquipped().getSpecialAttack().getAtkMultiplier())));
							System.out.println("You did " + (player.getInventory().getEquipped().getDamage() * player.getInventory().getEquipped().getSpecialAttack().getAtkMultiplier()) + " damage!");
						}
					}
					System.out.println("Enemy health:" + enemy.getCurrHP());
					return true;
					
				case 3:
					System.out.println("You resheathed your weapon./n");
					return false;
				
				default:
					System.out.println("Invalid input, you stood there menacignly. Try again./n");
					break;
				}
			} catch (NumberFormatException e) {
				System.err.println("Invalid input. Please enter a number.");
			}
		}
		
		return false;
		
	}
	
	private void rangedAttack() {
		
	}
	
	private void mageAttack() {
		
	}
	
	private void standardAttack() {
		System.out.println("You chose a standard attack!/n");
		if (dbTurn > 0) {
			enemy.setCurrHP((int) (enemy.getCurrHP() - (player.getInventory().getEquipped().getDamage() * 1.5)));
			System.out.println("You did " +  (player.getInventory().getEquipped().getDamage() * 1.5) + " damage!");
		} else {
			enemy.setCurrHP((int) (enemy.getCurrHP() - player.getInventory().getEquipped().getDamage()));
			System.out.println("You did " + player.getInventory().getEquipped().getDamage() + " damage!");
		}
	}

	private void enemyTurn() {
		
		if (poisonTurn > 0) {
			enemy.setCurrHP(enemy.getCurrHP() - poisonDamage);
			System.out.println(enemy.getName() + ": Took " + poisonDamage + "damage from the poison potion");
			System.out.println();
			System.out.println("Enemy health:" + enemy.getCurrHP());
		}
		
        if(Luck.luckEvent(40)) {
        	// Special Attack Functionality
        	if(enemy.getSpecialAttack().useSpAtk(70)) {
            	if (guardedTurn > 0) {
            		player.setCurrHP((int) (player.getCurrHP() - ((enemy.getDamage() * enemy.getSpecialAttack().getAtkMultiplier()) / 2)));
            		System.out.println("You took half damage because you had your guard up! The enemy did " + ((enemy.getDamage() * enemy.getSpecialAttack().getAtkMultiplier()) / 2) + " damage!");
            	} else {
            		player.setCurrHP((int) (player.getCurrHP() - (enemy.getDamage() * enemy.getSpecialAttack().getAtkMultiplier())));
            		System.out.println("The enemy did " + (enemy.getDamage() * enemy.getSpecialAttack().getAtkMultiplier()) + "damage!");
            	}
        	}

        } else {
        	// Regular Attack Functionality
        	if (guardedTurn > 0) {
        		player.setCurrHP((int) (player.getCurrHP() - (enemy.getDamage() / 2)));
        		System.out.println("You took half damage because you had your guard up! The enemy did " + (enemy.getDamage() / 2) + " damage!");
        	} else {
        		player.setCurrHP((int) (player.getCurrHP() - enemy.getDamage()));
        		System.out.println("The enemy did " + enemy.getDamage() + "damage!");
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
