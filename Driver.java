// @ Martin Kellogg ; 2/11/15

import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setSize(400, 600);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MCQ mcq = new MCQ("2+2","4","5","0","6");
		j.setContentPane(new MCQDisplay(mcq));
		j.setVisible(true);
	}
}