// @ Martin Kellogg ; 2/11/15

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;

public class MCQDisplay extends JPanel {

	public MCQDisplay(MCQ mcq) {
		JRadioButton jrbA = new JRadioButton(mcq.getAnsRight());
		JRadioButton jrbB = new JRadioButton(mcq.getAnsWrong1());
		JRadioButton jrbC = new JRadioButton(mcq.getAnsWrong2());
		JRadioButton jrbD = new JRadioButton(mcq.getAnsWrong3());
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(jrbA);
		this.add(jrbB);
		this.add(jrbC);
		this.add(jrbD);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(mcq.getQ(), 10, 10);

	}
}
