public abstract class Character {

	String name = "";
	int hitPoints;
	int strength;
	Weapon weapon;
	
	public enum cType{
		ROGUE, PALADIN, BRUCE_LEE, GOBLIN, SKELETON, LICH_KING
	}
	
	public Character(cType characterType){
		switch (characterType){
		
		case ROGUE:
			name = "Rogue";
			hitPoints = 55;
			strength = 8;
			weapon = new Weapon("Short sword", 1, 4);
			break;
		
		case PALADIN:
			name = "Paladin";
			hitPoints = 35;
			strength = 14;
			weapon = new Weapon("Long sword", 3, 7);
			break;
			
		case BRUCE_LEE:
			name = "Bruce Lee";
			hitPoints = 45;
			strength = 10;
			weapon = new Weapon("Jump kick", 2, 6);
			break;
			
		case GOBLIN:
			name = "Goblin";
			hitPoints = 25;
			strength = 4;
			weapon = new Weapon("Axe", 2, 6);
			break;
			
		case SKELETON:
			name = "Skeleton";
			hitPoints = 25;
			strength = 3;
			weapon = new Weapon("Mace", 2, 6);
			break;
			
		case LICH_KING:
			name = "Lich King";
			hitPoints = 40;
			strength = 8;
			weapon = new Weapon("Fire blast", 4, 10);
			break;
			
		}
		
	}
	
	public String getName(){
		return name;
	}
	
	public int getHitPoints(){
		return hitPoints;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public void setStrength(int strong){
		strength = strong;
	}
	
	public void setWeapon(Weapon crossbow){
		weapon = crossbow;
	}
	
	/*public void attack(Character opponent){
		System.out.println("\n" );
	}*/
	
	public void increaseHitPoints(int incHP){
		hitPoints += incHP;
	}
	
	public void decreaseHitPoints(int decHP){
		hitPoints -= decHP;
	}
	
	public boolean isDefeated(){
		if (hitPoints <= 0){
			return true;
		}
		else{
			return false;
		}
	}
}