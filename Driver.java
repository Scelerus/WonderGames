// Owner: Martin Kellogg

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Driver {
	final static long SEED = 0;
	
    public static void main (String[] args){
	JFrame j = new JFrame();
	//Random r = new Random(SEED);
	Random r = new Random();

	ArrayList<MCQ> rgMCQ = null;
	try {
		rgMCQ = MCQ.MCQInput("question.txt");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	MCQ q =  rgMCQ.get(r.nextInt(rgMCQ.size()));
	j.setSize(1200,800);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	j.setContentPane(new JScrollPane(new Map(rgMCQ, r)));
	j.setVisible(true);
    }

}
