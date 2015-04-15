
public class Character {
	private int xCoord;
	private int yCoord;
	protected int health;
    private int maxHealth;
    private String weapon = "";
    
    private String imagePath = "assets/WGSpriteP1Front1.png";

	public Character() {		
		xCoord = 0;
		yCoord = 0;
		health = 20;
		maxHealth = health;
	}	

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yC) {
		yCoord = yC;
	}

	public void setxCoord(int xC) {
		xCoord = xC;
	}

    public String getImagePath(){
	    return this.imagePath;
    }
    
    public void setImagePath(String newImagePath){
    	this.imagePath = newImagePath;
    }
    
    public int getHealth() {
    	return health;
    }

    public int getMaxHealth() {
	return maxHealth;
    }
    
    public void setHealth(int newHealth) {
    	health = newHealth;
    }

    public void loseHealth(boolean s) {
	if(weapon.equals("Shield"))
	    health--;
	else
	    health -= 2;
    }
	
	public void setWeapon(String w){
	    weapon = w;
	}
	public String getWeapon(){
	    return weapon;
	}


}
