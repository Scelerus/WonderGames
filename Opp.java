
import javax.swing.JFrame;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;


public class Opp extends Character {
   
    private Random r = null;
    private String name;
    private ArrayList<MCQ> rgMCQ;

    public Opp (String name, String questionFile, Random r, int x, int y){
    	try {
    		rgMCQ = MCQ.MCQInput(questionFile);
    	} catch (FileNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	this.r = r;
	this.name = name;
	this.setxCoord(x);
	this.setyCoord(y);
	this.setHealth(10);
    }

    public String get_name () {
    	return name;
    }

    public JFrame askQuestion(Character player){
	JFrame j = new JFrame();
	j.setSize(400,600);
	j.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	j.setContentPane(new MCQDisplay(rgMCQ.get(r.nextInt(rgMCQ.size())), r, j, player, this));
	j.setVisible(true);
	return j;
    }
}