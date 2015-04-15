import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class Til {

	private String fileName;
	private Random r;
	private Opp opponent;

	public Til(String imageFile, Random r) {
		this.fileName = imageFile;
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
