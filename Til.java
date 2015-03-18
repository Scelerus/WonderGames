import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class Til {

	private MCQ q;
	private String fileName;
	private Random r;

	public Til(MCQ question, String imageFile, Random r) {
		this.q = question;
		this.fileName = imageFile;
		this.r = r;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void displayQuestion() {
		JFrame j = new JFrame();
		j.setSize(400,600);
		j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		j.setContentPane(new MCQDisplay(q, r, j));
		j.setVisible(true);
	}

}
