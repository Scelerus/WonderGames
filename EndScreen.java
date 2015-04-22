import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class EndScreen extends JPanel {
	JFrame jf;
	TreeMap<String, ArrayList<Integer>> qResults;
	
	public EndScreen(JFrame my_frame, TreeMap<String, ArrayList<Integer>> results, boolean victory) {
		jf = my_frame;
		qResults = results;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("Wonder Games\n");
		this.add(title);
		
		JLabel jl1 = new JLabel("           ");
		this.add(jl1);
		
		JLabel jl2;
		if (victory == true)
			jl2 = new JLabel("You won!");
		else
			jl2 = new JLabel("You lost :(");
		this.add(jl2);
		
		for(String s : qResults.keySet()) {
			JLabel jli = new JLabel(s + ": " + qResults.get(s).get(0) + " / " + qResults.get(s).get(1) + " correct");
			this.add(jli);
		}
	}
	
}
