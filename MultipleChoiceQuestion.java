// @ Martin Kellogg ; 2/11/15

import javax.swing.JPanel;
import java.awt.Graphics;

public class MultipleChoiceQuestion extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("HEY BUDDY", 10, 10);
	}
}
