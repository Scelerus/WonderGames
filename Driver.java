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
	j.setSize(600,750);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	j.setContentPane(new JScrollPane(new Menu(j, r)));
	j.setVisible(true);
    }

}
