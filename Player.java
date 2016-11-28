import java.util.Scanner;

import java.util.ArrayList;
import java.util.Random;
public class Player extends Character{

	int coins;
	ArrayList<Potion> inventory;
//	List<Potion> inventory;

	
	public Player(cType playerType){
		super(playerType);
		coins = 0;
		inventory = new ArrayList<Potion>(5);
	//	inventory = new Potion[5];
	}
	
	public void increaseStrength(int incStrength){
		strength += incStrength;
	}
	
	public int getCoins(){
		return coins;
	}
	
	public void increaseCoins(int incCoins){
		coins += incCoins;
	}
	
	public void decreaseCoins(int decCoins){
		coins += decCoins;
	}
	
	public void addToInventory(Potion addPotion){
		//inventory[count] = addPotion;
		
		inventory.add(addPotion);
		
	}
	
	public void removeFromInventory(int index){
		inventory.remove(index - 1);
		}
	
	public void displayInventory(){
		/*for (int k = 0; k < inventory.size(); k++){
			System.out.println(inventory.get(k));
		}
		
		for(int j = k; j < 5; j++){
			int space = 1;
		System.out.println("[" + space + "] Empty Slot");
		space++;
		}*/
		int space;
		if (inventory.size() == 0){
			System.out.println("You don't have any potions.");
		}
		
		
		else if (inventory.size() >= 1){
			for (int k = 0; k < inventory.size(); k++){
				space = 1;
				System.out.println("[" + space + "] " + inventory.get(k));
				space++;
			}
		}
		
	}
	
	public int getNumOpenSlots(){
		int openSlots = 0;
		
		for (int emptySlot = 0; emptySlot < 5; emptySlot++){
			if (inventory.get(emptySlot).equals(null)){
				openSlots++;
			}
		}
		return openSlots;
	}
	
	public void battleMinion(Enemy monster, Scanner forward){
		
		String moveForward;
		
		int playerAttack = super.getStrength() + weapon.getDamage();
		int monsterAttack = monster.getStrength() + monster.weapon.getDamage();
		
		if (monster.getName().equals("Goblin")){
		for (int i = 1; i < monster.getNumGoblins(); i++){
			System.out.println("***" + super.getName() + " vs " + monster.getName() + " " + i + "***");
			while (monster.getHitPoints() > 0){
				
				
				//Hero's turn
				System.out.println("\n" + super.getName() + " attacks with ATK = " + super.getStrength() + " + " + weapon.getDamage()+ " = " + playerAttack );
				System.out.print(monster.getName() + " HP is now " + monster.getHitPoints() + " - " + playerAttack + " = ");
				monster.decreaseHitPoints(playerAttack);
				System.out.println(monster.getHitPoints());
				
				//Breaks while loop if monster has less than or equal to zero health
				if (monster.getHitPoints() <= 0){
					break;
				}
				
				//Monster's turn
				System.out.println("\n" + monster.getName() + " attacks with ATK = " + monster.getStrength() + " + " + monster.weapon.getDamage() + " = " + monsterAttack );
				System.out.print(super.getName() + " HP is now " + super.getHitPoints() + "-" + monsterAttack + " = " );
				super.decreaseHitPoints(monsterAttack);
				System.out.println(super.getHitPoints());
				
				
				if (super.getHitPoints() <= 0){
					System.out.println("---" + super.getName() + " is defeated in battle!---\n\nGAME OVER");
					System.exit(0);
				}
			}
			System.out.println("\n" + super.getName() + " defeated the " + monster.getName() + "\n");
			int dropGold = monster.dropCoins();
			System.out.println("The minion dropped " + dropGold + " gold pieces\n");
			coins += dropGold;
			System.out.println("Press enter to go on the the next battle");
			monster = new Enemy(cType.GOBLIN);
			moveForward = forward.nextLine();
			}
		}
		
		else if (monster.getName().equals("Skeleton")){
			for (int i = 1; i < monster.getNumSkeletons(); i++){
				System.out.println("***" + super.getName() + " vs " + monster.getName() + " " + i + "***");
				while (monster.getHitPoints() > 0){
					
					
					//Hero's turn
					System.out.println("\n" + super.getName() + " attacks with ATK = " + super.getStrength() + " + " + weapon.getDamage()+ " = " + playerAttack );
					System.out.print(monster.getName() + " HP is now " + monster.getHitPoints() + " - " + playerAttack + " = ");
					monster.decreaseHitPoints(playerAttack);
					System.out.println(monster.getHitPoints());
					
					//Breaks while loop if monster has less than or equal to zero health
					if (monster.getHitPoints() <= 0){
						break;
					}
					
					//Monster's turn
					System.out.println("\n" + monster.getName() + " attacks with ATK = " + monster.getStrength() + " + " + monster.weapon.getDamage() + " = " + monsterAttack );
					System.out.print(super.getName() + " HP is now " + super.getHitPoints() + "-" + monsterAttack + " = " );
					super.decreaseHitPoints(monsterAttack);
					System.out.println(super.getHitPoints());
					
					
					if (super.getHitPoints() <= 0){
						System.out.println("---" + super.getName() + " is defeated in battle!---\n\nGAME OVER");
						System.exit(0);
					}
				}
				System.out.println("\n" + super.getName() + " defeated the " + monster.getName() + "\n");
				int dropGold = monster.dropCoins();
				System.out.println("The minion dropped " + dropGold + " gold pieces\n");
				coins += dropGold;
				System.out.println("Press enter to go on the the next battle");
				moveForward = forward.nextLine();
				monster = new Enemy(cType.SKELETON);
				}
			}
		
		
	}
	
	
	public void battleWizard(Enemy lichKing, Scanner fight){
		
		Random spell = new Random();
		
		int heroAttack = super.getStrength() + weapon.getDamage();
		int lichAttack = lichKing.getStrength() + lichKing.weapon.getDamage();
		
		while (lichKing.getHitPoints() > 0){
			int action;
			System.out.println("Choose your action:\n1. Attack\n2. Attempt Spell");
			//Takes int for the Hero's action
			action = fight.nextInt();
			
			if (action == 1){
			//Regular attack	
			
				
			System.out.println("\n" + super.getName() + " attacks with ATK = " + super.getStrength() + " + " +  weapon.getDamage() + " = " + heroAttack);
			System.out.print(lichKing.getName() + " HP is now " + lichKing.getHitPoints() + " - " + heroAttack + " = ");
			lichKing.decreaseHitPoints(heroAttack);
			System.out.println(lichKing.getHitPoints());
			
			System.out.println("\n" + " Lich King attacks with ATK = " + lichKing.getStrength() + " + " + lichKing.weapon.getDamage() + " = " + lichAttack );
			System.out.print(super.getName() + " HP is now " + super.getHitPoints() + "-" + lichAttack + " = ");
			super.decreaseHitPoints(lichAttack);
			System.out.println(super.getHitPoints());
			
				if (super.getHitPoints() <= 0){
					System.out.println("---" + super.getName() + " is defeated in battle!---\n\nGAME OVER");
					System.exit(0);
				}
				
			}
			else if (action == 2){
				//Process of casting a spell
				int guess;
				int magic = spell.nextInt(3) + 1;
				System.out.println("Enter your guess:");
				guess = fight.nextInt();
				
				if (guess == magic){
					System.out.println("Correct!\nThe " + super.getName() + "'s spell is cast successfully!" 
							+ "The Wizard's HP is now 0!");
					System.out.println("--" + super.getName() + " wins the battle!--");
					System.out.println("\nYou win! Congratulations!");
					System.out.println("GAME OVER");
					System.exit(0);
				}
				else if (guess != magic){
					
					System.out.println("Spell failed");
					System.out.println("\n" + " Lich King attacks with ATK = " + lichKing.getStrength() + " + " + lichKing.weapon.getDamage() + " = " + lichAttack );
					System.out.print(super.getName() + " HP is now " + super.getHitPoints() + "-" + lichAttack + " = ");
					super.decreaseHitPoints(lichAttack);
					System.out.println(super.getHitPoints());
					
						if (super.getHitPoints() <= 0){
							System.out.println("---" + super.getName() + " is defeated in battle!---\n\nGAME OVER");
							System.exit(0);
						}
							
					}
				
				}
			
			}
	}
	
}