/*Sakhari Thomas
November 16, 2016
Prof. Krebs
Assignment 4
*/

import java.util.Scanner;

import AdventureGame.Character.cType;
import AdventureGame.Potion.Type;

public class AdventureGameV3 {
	

	private static int LONG_SWORD_COST = 120;
    private static int SHORT_SWORD_COST = 90;
    private static int MACE_COST = 80;
    private static int MINOR_HEALING_POTION_COST = 5;
    private static int HEALING_POTION_COST = 10;
	private static int MINOR_STRENGTH_POTION_COST = 20;
	private static int STRENGTH_POTION_COST = 40;
	

	public static void main(String[] args) {
	
		int characterChoice;
		
		
		Scanner user = new Scanner(System.in);
		System.out.println("Adventure Game Start!!");
		System.out.println("Here are the characters:\n1.Rogue\n2.Paladin\n3.Bruce Lee");
		System.out.println("\nWhich character do you choose?");
		characterChoice = user.nextInt();
		Player radHero = null;
		
		if (characterChoice == 1){
			radHero = new Player(cType.ROGUE);
		}
		else if (characterChoice == 2){
			 radHero = new Player(cType.PALADIN);

		}
        else if (characterChoice == 3){
			 radHero = new Player(cType.BRUCE_LEE);

		}
		
		System.out.println("You chose: " + radHero.getName());
		System.out.println("The Lich King must be defeated! He is in The Castle."
				         + " To get to The Castle, you must travel through The\n "
                           + "Forest and then through The Graveyard. Let’s go!");
		System.out.println("\nOnce you enter The Forest, you encounter Goblins! Time for battle!");
		
		Enemy greenGoblin = new Enemy(cType.GOBLIN);
		radHero.battleMinion(greenGoblin, user);
		
		System.out.println("Your HP is: " + radHero.getHitPoints());
		boolean currentlyBreaking = true;
		while (currentlyBreaking == true){
			int decision;
			int potionChoice;
			System.out.println("What would you like to do now?");
			System.out.println("\n1. View Inventory\n2. Drink Potion\n3. Visit Item Shop\n4. Continue to the Graveyard");
			decision = user.nextInt();
			
			if (decision == 1){
				radHero.displayInventory();
			}
			
			else if (decision == 2){
				potionChoice = user.nextInt();
				Potion heal = radHero.inventory.get(potionChoice);
				radHero.inventory.remove(potionChoice);
				heal.drink(radHero);
			}
			
			else if (decision == 3){
				visitItemShop(radHero, user);
			}
			
			else if (decision == 4){
				currentlyBreaking = false;
			}
			
		}
		
		System.out.println("Once you enter The Graveyard, you encounter Skeletons! Time for battle!");
		
		Enemy jackSkelington = new Enemy(cType.SKELETON);
		radHero.battleMinion(jackSkelington, user);
		
		System.out.println("Your HP is: " + radHero.getHitPoints());
		boolean currentlyBreaking2 = true;
		while (currentlyBreaking2 == true){
			int decision2;
			int potionChoice2;
			System.out.println("What would you like to do now?");
			System.out.println("\n1. View Inventory\n2. Drink Potion\n3. Visit Item Shop\n4. Continue to the Castle");
			decision2 = user.nextInt();
			
			if (decision2 == 1){
				radHero.displayInventory();
			}
			
			else if (decision2 == 2){
				potionChoice2 = user.nextInt();
				Potion heal = radHero.inventory.get(potionChoice2);
				radHero.removeFromInventory(potionChoice2);
				heal.drink(radHero);
			}
			
			else if (decision2 == 3){
				visitItemShop(radHero, user);
			}
			
			else if (decision2 == 4){
				currentlyBreaking2 = false;
			}
			
		}
		
		System.out.println("You have now reached The Castle! Time to battle The Evil Wizard!");
		
		Enemy boss = new Enemy(cType.LICH_KING);
		radHero.battleWizard(boss, user);
		
		
	}
	

		public static void visitItemShop(Player shoppingPlayer, Scanner keyboard){
			boolean shopping = true;
	        int stillShopping;

	        int itemChoice, quantity;
	        int discount = 0, totalCost = 0, finalCost = 0;
	        String itemName = "";

	        System.out.println("\nWelcome to The Item Shop!\n");
	        
	        while (shopping = true){
	        System.out.print("You have " + shoppingPlayer.coins + " gold pieces.\n\n");
				
	        System.out.println("Here's what we have for sale (all prices are in units of Au):\n");

	        System.out.printf("1. %-18s%-6d\n", "Long Sword", 120);
	        System.out.printf("2. %-18s%-6d\n", "Short Sword", 90);
	        System.out.printf("3. %-18s%-6d\n", "Mace", 80);
	        System.out.printf("4. %-18s%-6d\n", "Minor Healing Potion", 5);
	        System.out.printf("5. %-18s%-6d\n", "Healing Potion", 10);
			System.out.printf("6. %-18s%-6d\n", "Minor Strength Potion", 20);
			System.out.printf("7. %-18s%-6d\n", "Strength Potion", 40);

	        System.out.print("\nPlease enter the item number: ");
	        itemChoice = keyboard.nextInt();

	        System.out.print("Please enter the quantity: ");
	        quantity = keyboard.nextInt();

	        switch(itemChoice)
	        {
	                case 1:
	                        itemName = "Long Sword";
	                        totalCost = LONG_SWORD_COST * quantity;
	                        break;
	                case 2:
	                        itemName = "Short Sword";
	                        totalCost = SHORT_SWORD_COST * quantity;
	                        break;
	                case 3:
	                        itemName = "Mace";
	                        totalCost = MACE_COST * quantity;
	                        break;
	                case 4:
	                        itemName = "Minor Healing Potion";
	                        totalCost = MINOR_HEALING_POTION_COST * quantity;
	                        break;
	                case 5:
	                        itemName = "Healing Potion";
	                        totalCost = HEALING_POTION_COST * quantity;
	                        break;
					 case 6:
							itemName = "Minor Strength Potion";
							totalCost = MINOR_STRENGTH_POTION_COST * quantity;
							break;
					case 7: 
							itemName = "Strength Potion";
							totalCost = STRENGTH_POTION_COST * quantity;
							break;
							
					  
	        }
	        if(quantity > 5)
	        {
	        	quantity = 5;
	        }
	        if (quantity > 2)
	                discount = (int) (totalCost * 0.1);

	        finalCost = totalCost - discount;

	        System.out.printf("\n%-10s: %5d gold", "Total cost", totalCost);
	        System.out.printf("\n%-10s: %5d gold", "Discount", discount);
	        System.out.printf("\n%-10s: %5d gold", "Final cost", finalCost);
	        
	        

	        if (shoppingPlayer.coins >= finalCost){
	                System.out.println("\n\nThank you, Your transaction is complete!\n\n");
	                shoppingPlayer.coins -= finalCost;
	        }
	        
	        else{
                System.out.println("\n\nYou have insufficient funds! Please come back with more gold!\n");
                break;
	        }
	        int i = 0;
	        
	        System.out.println("Your hero's inventory/attributes have been updated.");
	        
	        if (itemName.equals("Minor Healing Potion")){
	        	Potion addPotion = new Potion(Type.MINOR_HEALING);
	        	System.out.println("You bought " + quantity + " " +  itemName);
	        	for ( i = 0; i < quantity; i++){
		        	shoppingPlayer.addToInventory(addPotion);
		        }
	        }
	        
	        else if (itemName.equals("Healing Potion")){
	        	Potion addPotion = new Potion(Type.HEALING);
	        	System.out.println("You bought " + quantity + " " + itemName);
	        	for ( i = 0; i < quantity; i++){
		        	shoppingPlayer.addToInventory(addPotion);
		        }
	        }
	        
	        else if (itemName.equals("Minor Strength Potion")){
	        	Potion addPotion = new Potion(Type.MINOR_STRENGTH);
	        	System.out.println("You bought " + quantity + " " + itemName);
	        	for ( i = 0; i < quantity; i++){
		        	shoppingPlayer.addToInventory(addPotion);
		        }
	        }
	        
	        else if (itemName.equals("Strength Potion")){
	        	Potion addPotion = new Potion(Type.STRENGTH);
	        	System.out.println("You bought " + quantity + " " + itemName);
	        	for (i = 0; i < quantity; i++){
	        		shoppingPlayer.addToInventory(addPotion);
	        	}
	        }
	        
	        else if (itemName.equals("Long Sword")){
	        	Weapon longSword = new Weapon("Long Sword", Weapon.LONG_SWORD_MIN, Weapon.LONG_SWORD_MAX);
	        	System.out.println("You bought " + quantity + " " + itemName);
	        	shoppingPlayer.setWeapon(longSword);
	        }
	        
	        else if (itemName.equals("Short Sword")){
	        	Weapon shortSword = new Weapon("Short Sword", Weapon.SHORT_SWORD_MIN, Weapon.SHORT_SWORD_MAX);
	        	System.out.println("You bought " + quantity + " " + itemName);
	        	shoppingPlayer.setWeapon(shortSword);
	        }
	        
	        else if (itemName.equals("Mace")){
	        	Weapon mace = new Weapon("Mace", Weapon.MACE_MIN, Weapon.MACE_MAX);
	        	System.out.println("You bought " + quantity + " " + itemName);
	        	shoppingPlayer.setWeapon(mace);
	        }
	        
	        System.out.println("Would you like to keep shopping? Enter 1 for 'yes' or 0 for 'no': ");
	        stillShopping = keyboard.nextInt();
	        if (stillShopping == 1){
	      	  shopping = true;
	      	  System.out.println("Welcome back!");
	        }
	        else if (stillShopping == 0){
	      	 break;
	        }
	    }
	      
	       
	}