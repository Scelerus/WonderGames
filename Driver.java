// Owner: Martin Kellogg

import java.util.Random;

import javax.swing.JFrame;

public class Driver {
	final static long SEED = 0;
	
    public static void main (String[] args){
	JFrame j = new JFrame();
	Random r = new Random(SEED);
	
	MCQ q = new MCQ("Question", "Right", "Wrong", "Wrong2", "Wrong3");
	j.setSize(400,600);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	j.setContentPane(new MCQDisplay(q, r));
	j.setVisible(true);
    }

}