
public class Character {
	private int xCoord;
	private int yCoord;
    
    
    private String imagePath = "assets/WGSpriteP1Front1.png";

	public Character() {		
		xCoord = 0;
		yCoord = 0;
	}	

	public int getxCoord() {
		return this.xCoord;
	}

	public int getyCoord() {
		return this.yCoord;
	}

	public void setxCoord(int yC) {
		this.yCoord = yC;
	}

	public void setyCoord(int xC) {
		this.xCoord = xC;
	}

        public String getImagePath(){
	    return this.imagePath;
        }




}
