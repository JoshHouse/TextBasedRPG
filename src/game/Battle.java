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
	
	Dialogue.infoDialogue("You have entered a battle!\n", txtSpd);
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
		char pChoice;
		boolean isPTurn = true;
		
		if(this.getPlayer().getCurrMana() < this.getPlayer().getMana()) {
			if (this.getPlayer().getCurrMana() + (this.getPlayer().getlvlMage() * 10) < this.getPlayer().getMana()) {
				this.getPlayer().setCurrMana(this.getPlayer().getCurrMana() + (this.getPlayer().getlvlMage() * 10));
				Dialogue.infoDialogue("You feel your mana regenerate partially!\n", txtSpd);
				Dialogue.infoDialogue("Your mana has been increased by " + this.getPlayer().getlvlMage() * 10 + "\n" , txtSpd);
				Dialogue.infoDialogue("Your current mana is now " + this.getPlayer().getCurrMana() + "\n", txtSpd);
			} else {
				this.getPlayer().setCurrMana(this.getPlayer().getMana());
				Dialogue.infoDialogue("You feel your mana practically overflowing! Your mana has been increased to full!\n", txtSpd);
				Dialogue.infoDialogue("Your current mana is now " + this.getPlayer().getCurrMana() + "\n", txtSpd);
			}
		} else if(this.getPlayer().getInventory().getEquipped().getDamageType() == "Mage") {
			Dialogue.infoDialogue("You feel your mana practically overflowing! You have full mana!\n", txtSpd);
			Dialogue.infoDialogue("Your current mana is " + this.getPlayer().getCurrMana() + "\n", txtSpd);
		}
		
		
		
		while (isPTurn) {
			Dialogue.infoDialogue("What would you like to do?\n" + 
					"1) Attack\n" + 
					"2) Guard\n" + 
					"3) Use Item\n" +
					"4) Flee\n", txtSpd);
				pChoice = keyboard.next().charAt(0);
				
				switch(pChoice) {
			
				case '1':
					isPTurn = !(this.playerAttack(keyboard));
					breakLine();
					break;
					
				case '2':
					this.guard();
					isPTurn = false;
					breakLine();
					break;
					
				case '3':
					isPTurn = !(this.selectItem(keyboard));
					breakLine();
					break;
					
				case '4':
					Dialogue.infoDialogue("You fled the battle.\n", txtSpd);
					breakLine();
					return true; // sets isWimp boolean to true in the start battle function
					
				default:
					breakLine();
					Dialogue.infoDialogue("Invalid input! Your player looked intensely at " + this.getEnemy() + ". Try again!\n", txtSpd);
					break;
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
        String pChoice;
        int selection;
        
		while (makingChoice) {
			Dialogue.infoDialogue("Choose an item to use from your inventory:\n", txtSpd);
	        printInventoryConsumableArray(pInventory);
			Dialogue.infoDialogue(pInventory.size()+1 + ") Cancel\n", txtSpd);
			Dialogue.infoDialogue("Make your choice:\n", txtSpd);

	            pChoice = keyboard.next();
	            if (isNumeric(pChoice)) {
	            	selection = Integer.parseInt(pChoice);
	            } else {
	            	selection = -1;
	            }
	            
	            if (selection == pInventory.size() + 1) {
	    			Dialogue.infoDialogue("Action canceled.\n", txtSpd);
		            return false;
		            
		        } else if (selection - 1 >= 0 && selection - 1 < pInventory.size()) {
		            usedItem = this.useItem(pInventory, selection - 1);
		            if (!usedItem) {
		            	return false;
		            }
		            return true;
		        	
		        } else {
					Dialogue.infoDialogue("Invalid choice. Please select a valid item number.\n", txtSpd);
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
		char pChoice = 0;
		
		
		while(isAttacking) {
			breakLine();
			Dialogue.infoDialogue("You chose to go on the offensive!\n" + 
					"1) Standard Attack\n" + 
					"2) Special Attack\n" + 
					"3) Cancel\n", txtSpd);
				pChoice = keyboard.next().charAt(0);
				
				switch(pChoice) {
				
				case '1': // Standard Attack
					switch (player.getInventory().getEquipped().getDamageType()) {
					case "Melee":
						this.defaultStandardAttack();
						break;
					case "Ranged":
						this.rangedStandardAttack();
						break;
					case "Magic":
						if (!this.mageStandardAttack()) {
							return false;
						}
						break;
					case "Rogue":
						this.defaultStandardAttack();
						break;
					default:
						this.defaultStandardAttack();
						break;
					}
					
					Dialogue.infoDialogue("Enemy health:" + enemy.getCurrHP() + "\n", txtSpd);
					return true;
					
				case '2': // Special Attack
					switch (player.getInventory().getEquipped().getDamageType()) {
					case "Melee":
						this.defaultSpecialAttack();
						break;
					case "Ranged":
						this.rangedSpecialAttack();
						break;
					case "Magic":
						if (!this.mageSpecialAttack()) {
							return false;
						}
						break;
					case "Rogue":
						this.defaultSpecialAttack();
						break;
					default:
						this.defaultSpecialAttack();
						break;
					}
					Dialogue.infoDialogue("Enemy health:" + enemy.getCurrHP() + "\n", txtSpd);
					return true;
					
				case '3':
					Dialogue.infoDialogue("You lowered your weapon.\n", txtSpd);
					return false;
				
				default:
					Dialogue.infoDialogue("Invalid input, you stood there menacignly. Try again.\n", txtSpd);
					break;
				}
		}
		
		return false;
		
	}
	
	private void meleeStandardAttack() {
		
	}
	
	private void meleeSpecialAttack() {
		
	}
	
	private boolean rangedStandardAttack() {
		double lvlDamageBoost = 1;
		for (int x = 1; x < player.getlvlRanged(); x++) {
			lvlDamageBoost = lvlDamageBoost + 0.2;
		}
	    Dialogue.infoDialogue("You nock a regular arrow and take aim...\n", txtSpd);

	    // Double damage turn (e.g., a buff or special condition)
	    if (dbTurn > 0) {
	        enemy.setCurrHP((int) (enemy.getCurrHP() - (this.getPlayerWeaponDamage() * lvlDamageBoost) * 1.5));
	        Dialogue.infoDialogue("Critical precision! Your attack is enhanced.\n", txtSpd);
	        Dialogue.infoDialogue("You did " +  (int) ((this.getPlayerWeaponDamage() * lvlDamageBoost) * 1.5) + " damage!\n", txtSpd);
		    Dialogue.infoDialogue("Enemy health: " + enemy.getCurrHP() + "\n", txtSpd);
				return true;
	    }  else {
	    	enemy.setCurrHP((int) (enemy.getCurrHP() - (this.getPlayerWeaponDamage() * lvlDamageBoost)));
	    	Dialogue.infoDialogue("You did " + (int) (this.getPlayerWeaponDamage() * lvlDamageBoost) + " damage!\n", txtSpd);
		    Dialogue.infoDialogue("Enemy health: " + enemy.getCurrHP() + "\n", txtSpd);
			return true;
	    }
	}

	
	private boolean rangedSpecialAttack() {
		double lvlDamageBoost = 1;
		for (int x = 1; x < player.getlvlRanged(); x++) {
			lvlDamageBoost = lvlDamageBoost + 0.2;
		}
		
		Dialogue.infoDialogue("You chose a Special Attack!\n", txtSpd);
		if(player.getCurrArrows() > player.getInventory().getSpecialArrows()) {
			if(player.getInventory().getEquipped().getSpecialAttack().useSpAtk(80)) {
				enemy.setCurrHP((int)(enemy.getCurrHP() - (((this.getPlayerWeaponDamage() * lvlDamageBoost) * this.getPlayerSpAtkMulti()) * 1.5)));
				Dialogue.infoDialogue("You did " + (((this.getPlayerWeaponDamage() * lvlDamageBoost) * this.getPlayerSpAtkMulti()) * 1.5) + " damage!\n", txtSpd);
				player.setCurrArrows(player.getCurrArrows() - 1);
				Dialogue.infoDialogue("You have " + player.getCurrArrows() + " Special Arrows!\n", txtSpd);
				Dialogue.infoDialogue("Enemy health: " + enemy.getCurrHP() + "\n", txtSpd);
				return true;
	    }  else {
	    	enemy.setCurrHP((int)(enemy.getCurrHP() - (this.getPlayerWeaponDamage() * this.getPlayerSpAtkMulti())));
	    	Dialogue.infoDialogue("You did " + (((this.getPlayerWeaponDamage() * lvlDamageBoost) * this.getPlayerSpAtkMulti()) * 1.5) + " damage!\n", txtSpd);
	    	player.setCurrArrows(player.getCurrArrows() - 1);
			Dialogue.infoDialogue("You have " + player.getCurrArrows() + " Special Arrows!\n", txtSpd);
			Dialogue.infoDialogue("Enemy health: " + enemy.getCurrHP() + "\n", txtSpd);
			return true;
			}
		}  else {
			Dialogue.infoDialogue("You don't have enough arrows to use a Special Attack!", txtSpd);
				return false;
			}
			
	}
				
	
	
	private boolean mageStandardAttack() {
		double lvlDamageBoost = 1;
		for (int x = 1; x < player.getlvlMage(); x++) {
			lvlDamageBoost = lvlDamageBoost + 0.2;
		}
		
		Dialogue.infoDialogue("You chose a standard attack!\n", txtSpd);
		
		if (player.getCurrMana() > player.getInventory().getEquipped().getManaUsage()) {
			if (dbTurn > 0) {
				enemy.setCurrHP((int) (enemy.getCurrHP() - ((this.getPlayerWeaponDamage() * lvlDamageBoost) * 1.5)));
				player.setCurrMana(player.getCurrMana() - player.getInventory().getEquipped().getManaUsage());
				Dialogue.infoDialogue("You expended " + player.getInventory().getEquipped().getManaUsage() + " mana!\n"
						+ "You have " + player.getCurrMana() + " mana remaining! \n", txtSpd);
				Dialogue.infoDialogue("You did " +  (int) ((this.getPlayerWeaponDamage() * lvlDamageBoost) * 1.5) + " damage!\n", txtSpd);
				return true;
			} else {
				enemy.setCurrHP((int) (enemy.getCurrHP() - (this.getPlayerWeaponDamage() * lvlDamageBoost)));
				player.setCurrMana(player.getCurrMana() - player.getInventory().getEquipped().getManaUsage());
				Dialogue.infoDialogue("You expended " + player.getInventory().getEquipped().getManaUsage() + " mana!\n"
						+ "You have " + player.getCurrMana() + " mana remaining! \n", txtSpd);
				Dialogue.infoDialogue("You did " + (int) (this.getPlayerWeaponDamage() * lvlDamageBoost) + " damage!\n", txtSpd);
				return true;
			}
		} else {
			Dialogue.infoDialogue("You find yourself exhausted. Your mana is depleted! You don't have enough "
					+ "mana to charge an attack! You will either need to defend yourself until you have enough time "
					+ "to regenerate your mana or drink a mana potion!\n", txtSpd);
			Dialogue.infoDialogue("You have " + player.getCurrMana() + " mana remaining! \n", txtSpd);
			return false;
		}
		
	}
	
	private boolean mageSpecialAttack() {
		double lvlDamageBoost = 1;
		for (int x = 1; x < player.getlvlMage(); x++) {
			lvlDamageBoost = lvlDamageBoost + 0.2;
		}
		
		Dialogue.infoDialogue("You chose a special attack!\n", txtSpd);
		
		if (player.getCurrMana() > player.getInventory().getEquipped().getManaUsage() * 1.2) {
			if(player.getInventory().getEquipped().getSpecialAttack().useSpAtk(80)) {
				if (dbTurn > 0) {
					enemy.setCurrHP((int)(enemy.getCurrHP() - (((this.getPlayerWeaponDamage() * lvlDamageBoost) * this.getPlayerSpAtkMulti()) * 1.5)));
					player.setCurrMana((int) (player.getCurrMana() - (player.getInventory().getEquipped().getManaUsage() * 1.2)));
					Dialogue.infoDialogue("You expended " + (int) (player.getInventory().getEquipped().getManaUsage() * 1.2) + " mana!\n"
							+ "You have " + player.getCurrMana() + " mana remaining! \n", txtSpd);
					Dialogue.infoDialogue("You did " + (((this.getPlayerWeaponDamage() * lvlDamageBoost) * this.getPlayerSpAtkMulti()) * 1.5) + " damage!\n", txtSpd);
					return true;
				} else {
					enemy.setCurrHP((int)(enemy.getCurrHP() - (this.getPlayerWeaponDamage() * this.getPlayerSpAtkMulti())));
					player.setCurrMana((int) (player.getCurrMana() - (player.getInventory().getEquipped().getManaUsage() * 1.2)));
					Dialogue.infoDialogue("You expended " + (int) (player.getInventory().getEquipped().getManaUsage() * 1.2) + " mana!\n"
							+ "You have " + player.getCurrMana() + " mana remaining! \n", txtSpd);
					Dialogue.infoDialogue("You did " + ((this.getPlayerWeaponDamage() * lvlDamageBoost) * this.getPlayerSpAtkMulti()) + " damage!\n", txtSpd);
					return true;
				}
			} else {
				Dialogue.infoDialogue("You did 0 damage!\n", txtSpd);
				Dialogue.infoDialogue("You have " + player.getCurrMana() + " mana remaining! \n", txtSpd);
				return true;
			} 
		} else {
			Dialogue.infoDialogue("You find yourself exhausted. Your mana is depleted! You don't have enough "
					+ "mana to charge a Special Attack! You will either need to defend yourself until you have enough time "
					+ "to regenerate your mana or drink a mana potion!\n", txtSpd);
			Dialogue.infoDialogue("You have " + player.getCurrMana() + " mana remaining! \n", txtSpd);
			Dialogue.infoDialogue("Your weapon uses " + player.getInventory().getEquipped().getManaUsage() + "mana to "
					+ "fire off a standard attack and " + (int) (player.getInventory().getEquipped().getManaUsage() * 1.2)
					+ " mana to fire off a special attack!", txtSpd);
			return false;
		}
	}
	
	private void rogueStandardAttack() {
		
	}
	
	private void rogueSpecialAttack() {
		
	}
	
	private void defaultStandardAttack() {
		Dialogue.infoDialogue("You chose a standard attack!\n", txtSpd);
		if (dbTurn > 0) {
			enemy.setCurrHP((int) (enemy.getCurrHP() - (this.getPlayerWeaponDamage() * 1.5)));
			Dialogue.infoDialogue("You did " +  (this.getPlayerWeaponDamage() * 1.5) + " damage!\n", txtSpd);
		} else {
			enemy.setCurrHP((int) (enemy.getCurrHP() - this.getPlayerWeaponDamage()));
			Dialogue.infoDialogue("You did " + this.getPlayerWeaponDamage() + " damage!\n", txtSpd);
		}
	}
	
	private void defaultSpecialAttack() {
		Dialogue.infoDialogue("You chose a special attack!\n", txtSpd);
		if(player.getInventory().getEquipped().getSpecialAttack().useSpAtk(80)) {
			if (dbTurn > 0) {
				enemy.setCurrHP((int)(enemy.getCurrHP() - ((this.getPlayerWeaponDamage() * this.getPlayerSpAtkMulti()) * 1.5)));
				Dialogue.infoDialogue("You did " + ((this.getPlayerWeaponDamage() * this.getPlayerSpAtkMulti()) * 1.5) + " damage!\n", txtSpd);
			} else {
				enemy.setCurrHP((int)(enemy.getCurrHP() - (this.getPlayerWeaponDamage() * this.getPlayerSpAtkMulti())));
				Dialogue.infoDialogue("You did " + (this.getPlayerWeaponDamage() * this.getPlayerSpAtkMulti()) + " damage!\n", txtSpd);
			}
		} else {
			Dialogue.infoDialogue("You did 0 damage!\n", txtSpd);
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
	
    private static boolean isNumeric(String str) {
        // Ensure the string only contains digits
        return str.matches("\\d+");
    }

}
