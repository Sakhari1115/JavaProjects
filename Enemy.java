import java.util.Random;
public class Enemy extends Character {
	
	Random tool = new Random();
	int enemyNumber;
	
	public Enemy(cType enemyType){
		
		super(enemyType);
	}
	
	public int dropCoins(){
		int droppedGold;
		droppedGold = tool.nextInt(20)+ 31;
		return droppedGold;
	}
	
	public int getNumGoblins(){
		enemyNumber = tool.nextInt(4) + 2;
		return enemyNumber;
	}
	
	public int getNumSkeletons(){
		enemyNumber = tool.nextInt(5) + 3;
		return enemyNumber;
	}
}