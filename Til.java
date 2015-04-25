import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class Til {

	private String fileName;
	private Random r;
	private Opp opponent;

	public Til(String imageFile, Random r) {
		this.fileName = imageFile;
		if(fileName.equals("assets/WGDesert.png") && r.nextInt(10) == 2)
		    fileName = "assets/WGCacti.png";
		if(fileName.equals("assets/WGGrass-small.jpg") && r.nextInt(10) == 2)
		    fileName = "assets/WGRock.png";
		
		this.r = r;
	}

	public String getFileName() {
		return fileName;
	}
	
    public JFrame displayQuestion(Character player, Map caller) {
		if (opponent != null)
		    return opponent.askQuestion(player, caller);
		else
			return null;
	}
	
	public Opp getOpp() {
		return opponent;
	}
	
	public void placeOpp(Opp o) {
		opponent = o;
	}

}
