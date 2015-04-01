
public class Character {
	private int xCoord;
	private int yCoord;
	private int health;
    
    
    private String imagePath = "assets/WGSpriteP1Front1.png";

	public Character() {		
		xCoord = 0;
		yCoord = 0;
		health = 20;
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
    
    public int getHealth() {
    	return health;
    }
    
    public void setHealth(int newHealth) {
    	health = newHealth;
    }

    public void loseHealth() {
    	health -= 2;
    }



}
