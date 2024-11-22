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
	private int playerWeaponDamage;
	private double playerSpAtkMulti;
	private int txtSpd = 25; 
	
	
	//----------------------------------Constructor---------------------------------
	
public Battle(Player inputPlayer, Enemy inputEnemy) {
	this.setPlayer(inputPlayer);
	this.setEnemy(inputEnemy);
	this.setTurn(0);
	this.setguardedTurn(0);
	this.setSpeedTurn(0);
	this.setPoisonTurn(0);
	this.setPoisonDamage(0);
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

public int getPlayerWeaponDamage() {
	return this.playerWeaponDamage;
}

public double getPlayerSpAtkMulti() {
	return this.playerSpAtkMulti;
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

public void setPlayerWeaponDamage(int inputPlayerWeaponDamage) {
	this.playerWeaponDamage = inputPlayerWeaponDamage;
}

public void setPlayerSpAtkMulti(double inputPlayerSpAtkMulti) {
	this.playerSpAtkMulti = inputPlayerSpAtkMulti;
}

//----------------------------------Functions---------------------------------

public static void breakLine() {  
    System.out.println("------------------------------");
}

private void battleSetup() {
	if (enemy.getCurrHP() != enemy.getHealth()) {
		enemy.setCurrHP(enemy.getHealth());
	}
	if (player.getCurrHP() != player.getHealth()) {
		player.setCurrHP(player.getHealth());
	}
	if (player.getCurrMana() != player.getMana()) {
		player.setCurrMana(player.getMana());
	}
	this.setTurn(0);
	this.setguardedTurn(0);
	this.setSpeedTurn(0);
	this.setPoisonTurn(0);
	this.setPoisonDamage(0);
	this.setPlayerWeaponDamage((int) this.getPlayer().getInventory().getEquipped().getDamage());
	this.setPlayerSpAtkMulti(this.getPlayer().getInventory().getEquipped().getSpecialAttack().getAtkMultiplier());
}

public boolean startBattle(Scanner keyboard) {
	boolean inBattle = true;
	boolean isWimp = false;
	
	battleSetup();
	
	Dialogue.infoDialogue("Welcome to the Battle Arena!\n", txtSpd);
	Dialogue.infoDialogue("Your opponent: " + this.getEnemy().getName() + "\n", txtSpd);
	breakLine();
	
	while(inBattle) {
		if (speedTurn > 0) {
			isWimp = this.playerTurn(keyboard);
			if (isWimp) {
				return false;
			}
			speedTurn--;
		} else {
			if(turn == 0) {
				isWimp = this.playerTurn(keyboard);
				if (isWimp) {
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
				Dialogue.infoDialogue("You have been defeated!\n", txtSpd);
				Dialogue.infoDialogue("Leaving the Battle Arena.\n", txtSpd);
	            player.setCurrHP(player.getHealth());
	            enemy.setCurrHP(enemy.getHealth());
	            player.setCurrMana(player.getMana());
	            return false;
	        } else if (enemy.getCurrHP() <= 0) {
				Dialogue.infoDialogue("You defeated the enemy!\n", txtSpd);
	            player.setCurrHP(player.getHealth());
	            enemy.setCurrHP(enemy.getHealth());
	            player.setCurrMana(player.getMana());
	            return true;
	        } else {
	            changeTurn(); // Change turn only if battle continues
	        }
		}
		
	}
	
	return false;
	
}



	private boolean playerTurn(Scanner keyboard) {
		int pChoice;
		boolean isPTurn = true;
		
		while (isPTurn) {
			Dialogue.infoDialogue("What would you like to do?\n" + 
					"1) Attack\n" + 
					"2) Guard\n" + 
					"3) Use Item\n" +
					"4) Flee\n", txtSpd);
			try {
				pChoice = keyboard.nextInt();
				
				switch(pChoice) {
			
				case 1:
					isPTurn = !(this.playerAttack(keyboard));
					breakLine();
					break;
					
				case 2:
					this.guard();
					isPTurn = false;
					breakLine();
					break;
					
				case 3:
					isPTurn = !(this.selectItem(keyboard));
					breakLine();
					break;
					
				case 4:
					Dialogue.infoDialogue("You fled the battle.\n", txtSpd);
					breakLine();
					return true; // sets isWimp boolean to true in the start battle function
					
				default:
					breakLine();
					Dialogue.infoDialogue("Invalid input! Your player looked intensely at " + this.getEnemy() + ". Try again!\n", txtSpd);
					break;
				}
			} catch (NumberFormatException e) {
				System.err.println("Invalid input. Please enter a number.");
			}
			
		}
		return false;

}
	private void printInventoryConsumableArray(ArrayList<Consumable> arrayList) {
		for(int x = 0; x < arrayList.size(); x++) {
			Dialogue.infoDialogue(x+1 + ") " + arrayList.get(x).getName() + 
					"\n Info: " + arrayList.get(x).getInfo() + "\n", txtSpd);
		}
	}
	

// add different arrow ammos
	private boolean selectItem(Scanner keyboard) {
        ArrayList<Consumable> pInventory = player.getInventory().getConsumables();
		boolean makingChoice = true;
		boolean usedItem = false;
        int choice;
        
		while (makingChoice) {
			Dialogue.infoDialogue("Choose an item to use from your inventory:\n", txtSpd);
	        printInventoryConsumableArray(pInventory);
			Dialogue.infoDialogue(pInventory.size()+1 + ") Cancel\n", txtSpd);
			Dialogue.infoDialogue("Make your choice:\n", txtSpd);


	        try {
	            choice = keyboard.nextInt();
	            if (choice == pInventory.size() + 1) {
	    			Dialogue.infoDialogue("Action canceled.\n", txtSpd);
		            return false;
		            
		        } else if (choice - 1 >= 0 && choice - 1 < pInventory.size()) {
		            usedItem = this.useItem(pInventory, choice - 1);
		            if (!usedItem) {
		            	return false;
		            }
		            return true;
		        	
		        } else {
					Dialogue.infoDialogue("Invalid choice. Please select a valid item number.\n", txtSpd);
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
			Dialogue.infoDialogue("You used a Damage Boost Potion! Boosting damage...\n", txtSpd);
        	this.setDbTurn(4);
			Dialogue.infoDialogue("You successfully used your Damage Boost Potion. You will now do 1.5x damage for "
        			+ "the next 3 turns!\n", txtSpd);
        	this.removeItem(pInventory, itemIndex);
        	return true;

        case 'h':
            if (player.getCurrHP() + pInventory.get(itemIndex).getDamage() < player.getHealth()) {
            	player.setCurrHP((int) (player.getCurrHP() + pInventory.get(itemIndex).getDamage()));
            } else {
            	player.setCurrHP(player.getHealth());
            }
			Dialogue.infoDialogue("You used a Health Potion! Restoring health...\n", txtSpd);
			Dialogue.infoDialogue("You successfully used a health potion! Your health is now: " + player.getCurrHP() + "\n", txtSpd);
        	this.removeItem(pInventory, itemIndex);
        	return true;

        case 'm':
        	if (player.getCurrMana() + pInventory.get(itemIndex).getDamage() < player.getMana()) {
        		player.setCurrMana((int)(player.getCurrMana() + pInventory.get(itemIndex).getDamage()));
        	} else {
        		player.setCurrMana(player.getMana());
        	}
			Dialogue.infoDialogue("You used a Mana Potion! Restoring mana...\n", txtSpd);
			Dialogue.infoDialogue("You successfully used a mana potion! Your mana is now: " + player.getCurrMana() + "\n", txtSpd);
        	this.removeItem(pInventory, itemIndex);
        	return true;
        	
        case 's':
        	this.setSpeedTurn(this.getSpeedTurn() + 2);
			Dialogue.infoDialogue("You used a Speed Potion! You get two turns...\n", txtSpd);
        	this.removeItem(pInventory, itemIndex);
        	return true;

        case 'p':
        	if (this.getPoisonTurn() > 0) {
    			Dialogue.infoDialogue("You cannot use a poison potion while another is already applied to this enemy!\n", txtSpd);
        		return false;
        	} else {
            	this.setPoisonTurn(this.getPoisonTurn() + 3);
            	this.setPoisonDamage((int) (pInventory.get(itemIndex).getDamage()));
    			Dialogue.infoDialogue("You used a Poison Potion! The Enemy will be damaged for three turns!\n", txtSpd);
            	this.removeItem(pInventory, itemIndex);
            	return true;
        	}
        	
        default:
			Dialogue.infoDialogue("Unknown item type. Unable to use item.\n", txtSpd);
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
		Dialogue.infoDialogue("You guard yourself from three attacks.\n", txtSpd);
		this.setguardedTurn(this.getguardedTurn() + 4);	
	}


	private boolean playerAttack(Scanner keyboard) {
		boolean isAttacking = true;
		int pChoice = 0;
		
		
		while(isAttacking) {
			breakLine();
			Dialogue.infoDialogue("You chose to go on the offensive!\n" + 
					"1) Standard Attack\n" + 
					"2) Special Attack\n" + 
					"3) Cancel\n", txtSpd);
			try {
				pChoice = keyboard.nextInt();
				
				switch(pChoice) {
				
				case 1:
					switch (player.getInventory().getEquipped().getDamageType()) {
					case "Melee":
						this.standardAttack();
						break;
					case "Ranged":
						this.standardAttack();
						break;
					case "Mage":
						this.standardAttack();
						break;
					case "Rogue":
						this.standardAttack();
						break;
					default:
						this.standardAttack();
						break;
					}
					
					Dialogue.infoDialogue("Enemy health:" + enemy.getCurrHP() + "\n", txtSpd);
					return true;
					
				case 2:
					Dialogue.infoDialogue("You chose a special attack!\n", txtSpd);
					if(player.getInventory().getEquipped().getSpecialAttack().useSpAtk(80)) {
						if (dbTurn > 0) {
							enemy.setCurrHP((int)(enemy.getCurrHP() - ((this.getPlayerWeaponDamage() * this.getPlayerSpAtkMulti()) * 1.5)));
							Dialogue.infoDialogue("You did " + ((this.getPlayerWeaponDamage() * this.getPlayerSpAtkMulti()) * 1.5) + " damage!\n", txtSpd);
						} else {
							enemy.setCurrHP((int)(enemy.getCurrHP() - (this.getPlayerWeaponDamage() * this.getPlayerSpAtkMulti())));
							Dialogue.infoDialogue("You did " + (this.getPlayerWeaponDamage() * this.getPlayerSpAtkMulti()) + " damage!\n", txtSpd);
						}
					}
					Dialogue.infoDialogue("Enemy health:" + enemy.getCurrHP() + "\n", txtSpd);
					return true;
					
				case 3:
					Dialogue.infoDialogue("You resheathed your weapon.\n", txtSpd);
					return false;
				
				default:
					Dialogue.infoDialogue("Invalid input, you stood there menacignly. Try again.\n", txtSpd);
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
		Dialogue.infoDialogue("You chose a standard attack!\n", txtSpd);
		if (dbTurn > 0) {
			enemy.setCurrHP((int) (enemy.getCurrHP() - (this.getPlayerWeaponDamage() * 1.5)));
			Dialogue.infoDialogue("You did " +  (this.getPlayerWeaponDamage() * 1.5) + " damage!\n", txtSpd);
		} else {
			enemy.setCurrHP((int) (enemy.getCurrHP() - this.getPlayerWeaponDamage()));
			Dialogue.infoDialogue("You did " + this.getPlayerWeaponDamage() + " damage!\n", txtSpd);
		}
	}

	private void enemyTurn() {
		
		if (poisonTurn > 0) {
			enemy.setCurrHP(enemy.getCurrHP() - poisonDamage);
			Dialogue.infoDialogue(enemy.getName() + ": Took " + this.getPoisonDamage() + "damage from the poison potion\n", txtSpd);
			Dialogue.infoDialogue("Enemy health:" + enemy.getCurrHP() + "\n", txtSpd);
		}
		
        if(enemy.getSpecialAttack().getName() != "None" && Luck.luckEvent(40)) {
        	// Special Attack Functionality
        	if(enemy.getSpecialAttack().useSpAtk(70)) {
            	if (guardedTurn > 0) {
            		player.setCurrHP((int) (player.getCurrHP() - ((enemy.getDamage() * enemy.getSpecialAttack().getAtkMultiplier()) / 2)));
        			Dialogue.infoDialogue("You took half damage because you had your guard up! The enemy did " + ((enemy.getDamage() * enemy.getSpecialAttack().getAtkMultiplier()) / 2) + " damage!\n", txtSpd);
            	} else {
            		player.setCurrHP((int) (player.getCurrHP() - (enemy.getDamage() * enemy.getSpecialAttack().getAtkMultiplier())));
        			Dialogue.infoDialogue("The enemy did " + (enemy.getDamage() * enemy.getSpecialAttack().getAtkMultiplier()) + "damage!\n", txtSpd);
            	}
        	} else {
        		Dialogue.infoDialogue("The Enemy did 0 damage!", txtSpd);
        	}

        } else {
        	// Regular Attack Functionality
        	if (guardedTurn > 0) {
        		player.setCurrHP((int) (player.getCurrHP() - (enemy.getDamage() / 2)));
    			Dialogue.infoDialogue("*"+ enemy.getRegularAttack() + "*\n", txtSpd);
    			Dialogue.infoDialogue("You took half damage because you had your guard up! The enemy did " + (enemy.getDamage() / 2) + " damage!\n", txtSpd);
        	} else {
        		player.setCurrHP((int) (player.getCurrHP() - enemy.getDamage()));
    			Dialogue.infoDialogue("*"+ enemy.getRegularAttack() + "*\n", txtSpd);
    			Dialogue.infoDialogue("The enemy did " + enemy.getDamage() + "damage!\n", txtSpd);
        	}
        }
        
		
		Dialogue.infoDialogue("Your HP: " + player.getCurrHP() + "\n", txtSpd);
        
        breakLine();
	
	}
	
	
	
	public void changeTurn() {
		if(this.getTurn() == 0) 
			this.setTurn(1);
		else
			this.setTurn(0);
	}

}
