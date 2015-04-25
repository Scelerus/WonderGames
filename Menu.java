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





	JCheckBox jcbOpp1 = new JCheckBox("Pythagoras of Samos (Math 6)");
	jcbOpp1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Pythagoras of Samos (Math 6)");
			}
	    });
	

	JCheckBox jcbOpp2 = new JCheckBox("Hypntia Theon (Math 7)");
	jcbOpp2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Hypntia Theon (Math 7)");
			}
	    });

	JCheckBox jcbOpp3 = new JCheckBox("Sophie Germain (Math 8)");
	jcbOpp3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Sophie Germain (Math 8)");
			}
	    });

	JCheckBox jcbOpp4 = new JCheckBox("Ada Lovelace (Algebra I)");
	jcbOpp4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Ada Lovelace (Algebra I)");
			}
	    });

	JCheckBox jcbOpp5 = new JCheckBox("Don Quixote (Spanish)");
	jcbOpp5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Don Quixote (Spanish)");
			}
	    });
	JCheckBox jcbOpp6 = new JCheckBox("Maya Angelou (Reading 6)");
	jcbOpp6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Maya Angelou (Reading 6)");
			}
	    });
	JCheckBox jcbOpp7 = new JCheckBox("Emily Dickinson (Reading 7)");
	jcbOpp7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Emily Dickinson (Reading 7)");
			}
	    });
	JCheckBox jcbOpp8 = new JCheckBox("Edgar Allen Poe (Reading 8)");
	jcbOpp8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Edgar Allen Poe (Reading 8)");
			}
	    });
	JCheckBox jcbOpp9 = new JCheckBox("Jane Austen (Writing 8)");
	jcbOpp9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Jane Austen (Writing 8)");
			}
	    });
	JCheckBox jcbOpp10 = new JCheckBox("Nikola Tesla (Science 6)");
	jcbOpp10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Nikola Tesla (Science 6)");
			}
	    });
	JCheckBox jcbOpp11 = new JCheckBox("Jane Goodall (Life Science)");
	jcbOpp11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Jane Goodall (Life Science)");
			}
	    });
	JCheckBox jcbOpp12 = new JCheckBox("Marie Curie (Physical Science)");
	jcbOpp12.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Marie Curie (Physical Science)");
			}
	    });
	JCheckBox jcbOpp13 = new JCheckBox("Thomas Jefferson (US History to 1865)");
	jcbOpp13.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Thomas Jefferson (US History to 1865)");
			}
	    });
	JCheckBox jcbOpp14 = new JCheckBox("Carlos Slim Helu (Civics and Economics)");
	jcbOpp14.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Carlos Slim Helu (Civics and Economics)");
			}
	    });
	JCheckBox jcbOpp15 = new JCheckBox("Nick Lytle (US History 1865 to present)");
	jcbOpp15.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Nick Lytle (US History 1865 to present)");
			}
	    });
	JCheckBox jcbOpp16 = new JCheckBox("Grace Hopper (Technology)");
	jcbOpp16.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Grace Hopper (Technology)");
			}
	    });
	JCheckBox jcbOpp17 = new JCheckBox("Alex Trebek (Trivia)");
	jcbOpp17.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    add_or_remove_opp("Alex Trebek (Trivia)");
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
		this.add(jcbOpp6);
		this.add(jcbOpp7);
		this.add(jcbOpp8);
		this.add(jcbOpp9);
		this.add(jcbOpp10);
		this.add(jcbOpp11);
		this.add(jcbOpp12);
		this.add(jcbOpp13);
		this.add(jcbOpp14);
		this.add(jcbOpp15);
		this.add(jcbOpp16);
		this.add(jcbOpp17);

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
	j.setContentPane(new JScrollPane(new Map(rgopp, r, j)));
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
	
	if (opp_name.equals("Pythagoras of Samos (Math 6)")){
	    rgopp.add(new Opp(opp_name, "assets/question.txt", "assets/WGSpriteP15", r, 1, 1));
	}

	if (opp_name.equals("Hypnatia Theon (Math 7)")){
	    rgopp.add(new Opp(opp_name, "assets/question.txt","assets/WGSpriteP1",  r, 2, 3));
	}

	if (opp_name.equals("Sophie Germain (Math 8)")){
	    rgopp.add(new Opp(opp_name, "assets/Math6.txt","assets/WGSpriteP2",  r, 3, 3));
	}
	if (opp_name.equals("Ada Lovelace (Algebra I)")){
	    rgopp.add(new Opp(opp_name, "assets/USHistoryTo1865.txt","assets/WGSpriteP8",  r, 2, 4));
	}
	if (opp_name.equals("Don Quixote (Spanish)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP20",  r, 5, 3));
	}
	
	if (opp_name.equals("Maya Angelou (Reading 6)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP5",  r, 5, 3));
	}
	if (opp_name.equals("Emily Dickinson (Reading 7)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP7",  r, 5, 3));
	}
	if (opp_name.equals("Edgar Allen Poe (Reading 8)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP14",  r, 5, 3));
	}
	if (opp_name.equals("Jane Austen (Writing 8)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP9",  r, 5, 3));
	}
	if (opp_name.equals("Nikola Tesla (Science 6)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP16",  r, 5, 3));
	}
	if (opp_name.equals("Jane Goodall (Life Science)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP3",  r, 5, 3));
	}
	if (opp_name.equals("Marie Curie (Physical Science)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP4",  r, 5, 3));
	}
	if (opp_name.equals("Thomas Jefferson (US History to 1865)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP21",  r, 5, 3));
	}
	if (opp_name.equals("Carlos Slim Helu (Civics and Economics)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP17",  r, 5, 3));
	}
	if (opp_name.equals("Nick Lytle (US History 1865 to present")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP19",  r, 5, 3));
	}
	if (opp_name.equals("Grace Hopper (Technology)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP6",  r, 5, 3));
	}
	if (opp_name.equals("Alex Trebek (Trivia)")){
	    rgopp.add(new Opp(opp_name, "assets/Trivia.txt","assets/WGSpriteP18",  r, 5, 3));
	}

    }
    
}