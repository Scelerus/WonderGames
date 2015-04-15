import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;

public class Menu extends JPanel {

    JFrame jf;
    Random r;
    ArrayList<Opp> rgopp;

    public Menu (JFrame my_frame, Random rand) {
	
	jf = my_frame;
	r = rand;

	rgopp = new ArrayList<Opp>();

	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	JLabel title = new JLabel("Wonder Games\n");
	this.add(title);

	JLabel jl1 = new JLabel("           ");
	this.add(jl1);
	JLabel jl2 = new JLabel("           ");
	this.add(jl2);

	JLabel jl3 = new JLabel("Choose your opponents:");
	this.add(jl3);





	JCheckBox jcbOpp1 = new JCheckBox("Darth Vader");
	jcbOpp1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Darth Vader");
			}
	    });
	

	JCheckBox jcbOpp2 = new JCheckBox("Homer Simpson");
	jcbOpp2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Homer Simpson");
			}
	    });

	JCheckBox jcbOpp3 = new JCheckBox("Will Hunting");
	jcbOpp3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Will Hunting");
			}
	    });

	JCheckBox jcbOpp4 = new JCheckBox("Nick Lytle");
	jcbOpp4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Nick Lytle");
			}
	    });

	JCheckBox jcbOpp5 = new JCheckBox("Mr. Chang");
	jcbOpp5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Mr. Chang");
			}
	    });


	JButton jbStart = new JButton("Start Game");
		jbStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    start_game();
		 }
	    });
		
		/*JPanel checkPanel = new JPanel(new GridLayout(0, 1));
		checkPanel.add(jcbOpp1);
		checkPanel.add(jcbOpp2);
		add(checkPanel);*/
		

		this.add(jcbOpp1);
		this.add(jcbOpp2);
		this.add(jcbOpp3);
		this.add(jcbOpp4);
		this.add(jcbOpp5);

	ArrayList<JButton> rgjb = new ArrayList();
	rgjb.add(jbStart);
		JLabel jl4 = new JLabel("           ");
	this.add(jl4);

	int length = rgjb.size();
	for (int i = 0; i < length; i++) {
	    int k = r.nextInt(rgjb.size());
	    this.add(rgjb.get(k));
	    rgjb.remove(k);
	}
	setBorder(BorderFactory.createEmptyBorder(100,200,100,100));
       
	
		
    }

    public void start_game() {
	JFrame j = new JFrame("Wonder Games");
	j.setSize(1200,800);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	j.setContentPane(new JScrollPane(new Map(rgopp, r)));
	j.setVisible(true);
	jf.dispose();
    }

    public void add_or_remove_opp (String opp_name) {
		
	int iopp = -1;
	for (int i = 0; i < rgopp.size(); i++){
	    if(rgopp.get(i).get_name().equals(opp_name)){
		iopp = i;
		break;
		    }
	}
	if(iopp != -1){
	    rgopp.remove(iopp);
	    return;
	}
	
	if (opp_name.equals("Darth Vader")){
	    rgopp.add(new Opp(opp_name, "assets/question.txt", r, 1, 1));
	}

	if (opp_name.equals("Homer Simpson")){
	    rgopp.add(new Opp(opp_name, "assets/question.txt", r, 2, 3));
	}

	if (opp_name.equals("Will Hunting")){
	    rgopp.add(new Opp(opp_name, "assets/Math6.txt", r, 3, 3));
	}
	if (opp_name.equals("Nick Lytle")){
	    rgopp.add(new Opp(opp_name, "assets/USHistoryTo1865.txt", r, 2, 4));
	}
	if (opp_name.equals("Mr. Chang")){
	    rgopp.add(new Opp(opp_name, "assets/Spanish.txt", r, 5, 3));
	}

    }
    
}