public class Potion {

	String name = "";
	Type type;
	
	public enum Type{
		MINOR_HEALING, HEALING, MINOR_STRENGTH, STRENGTH
	}
	
	public Potion(Type potionType){
		
		switch (potionType){
		
		case MINOR_HEALING:
			name = "Minor Healing Potion";
			
		case HEALING:
			name = "Healing Potion";
			
		case MINOR_STRENGTH:
			name = "Minor Strength Potion";
			
		case STRENGTH:
			name = "Strength Potion";
		}
		
	}
	
	public String getName(){
		return name;
	}
	
	public void drink(Player playerAttributes){
		if (name.equals("Minor Healing Potion")){
			playerAttributes.increaseHitPoints(5);
			System.out.println("Your HP increased by 5. Your HP is now" + playerAttributes.getHitPoints());
		}
		else if (name.equals("Healing Potion")){
			playerAttributes.increaseHitPoints(10);
			System.out.println("Your HP increased by 10. Your HP is now" + playerAttributes.getHitPoints());

		}
		else if (name.equals("Minor Strength Potion")){
			playerAttributes.increaseStrength(2);
			System.out.println("Your Strength increased by 2. Your Strength is now" + playerAttributes.getStrength());

		}
		else if (name.equals("Strength Potion")){
			playerAttributes.increaseStrength(5);
			System.out.println("Your Strength increased by 5. Your Strength is now" + playerAttributes.getStrength());

		}
	}
}
