// @ Martin Kellogg ; 2/11/15

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class MCQDisplay extends JPanel {

	public MCQDisplay(MCQ mcq) {
		JLabel jl = new JLabel(mcq.getQ());
		this.add(jl);
		JRadioButton jrbA = new JRadioButton(mcq.getansRight());
		JRadioButton jrbB = new JRadioButton(mcq.getansWrong1());
		JRadioButton jrbC = new JRadioButton(mcq.getansWrong2());
		JRadioButton jrbD = new JRadioButton(mcq.getansWrong3());
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(jrbA);
		this.add(jrbB);
		this.add(jrbC);
		this.add(jrbD);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		g.drawString(mcq.getQ(), 10, 10);

	}
}
