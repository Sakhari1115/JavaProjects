import java.util.Random;

public class Weapon {

	  public static int SHORT_SWORD_MIN = 1;
	  public static int SHORT_SWORD_MAX = 4;
	  public static int LONG_SWORD_MIN = 3;
	  public static int LONG_SWORD_MAX = 7;
	  public static int JUMP_KICK_MIN = 2;
	  public static int JUMP_KICK_MAX = 6;
	  public static int AXE_MIN = 2;
	  public static int AXE_MAX = 6;
	  public static int MACE_MIN = 2;
	  public static int MACE_MAX = 6;
	  public static int FIREBLAST_MIN = 4;
	  public static int FIREBLAST_MAX = 10;

	
	String name = "";
	int minDamage;
	int maxDamage;
	
	public Weapon(String label, int MINDamage, int MAXDamage){
		if(label.equals("Short sword")){
			this.minDamage = MINDamage;
			this.maxDamage = MAXDamage;
		}
		else if(label.equals("Long Sword")){
			this.minDamage = MINDamage;
			this.maxDamage = MAXDamage;
		}
		else if(label.equals("Jump kick")){
			this.minDamage = MINDamage;
			this.maxDamage = MAXDamage;
		}
		else if(label.equals("Axe")){
			this.minDamage = MINDamage;
			this.maxDamage = MAXDamage;
		}
		else if(label.equals("Mace")){
			this.minDamage = MINDamage;
			this.maxDamage = MAXDamage;
		}
		else if(label.equals("Fire blast")){
			this.minDamage = MINDamage;
			this.maxDamage = MAXDamage;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public int getMinDamage(){
		return minDamage;
	}
	
	public int getMaxDamage(){
		return maxDamage;
	}
	
	public int getDamage(){
		int totalDamage;
		Random dmg = new Random();
		totalDamage = dmg.nextInt(maxDamage - minDamage + 1) + minDamage;
		return totalDamage;
	}
}
