
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MCQDisplay extends JPanel {

    public MCQDisplay(MCQ mcq, final Random r, final JFrame j, final Character player, final Opp opponent, final Map caller) {
		JLabel jl = new JLabel("<html>" + mcq.getQ() + "</html>");
		this.add(jl);
		
		JButton jbA = new JButton(mcq.getansRight());
		jbA.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    
			    opponent.loseHealth(player.getWeapon().equals("Sword"));
			    switch (r.nextInt(2)){
				case 0:
				    player.setWeapon("Sword");
				    break;
				case 1:
				    player.setWeapon("Shield");
				    break;
				}
				player.updateResults(opponent.get_name(), true);
			    caller.paintImmediately(0,0,caller.getWidth(), caller.getHeight());
			    caller.revalidate();
			if (player.health <= 0)
				caller.game_over();
    try{
				Thread.sleep(20);
			    } catch(Exception e){
			    }
			    j.dispose();
				
			}
		});
		
		JButton jbB = new JButton(mcq.getansWrong1());
		jbB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			
					
				player.loseHealth(false);
				player.setWeapon("");
				player.updateResults(opponent.get_name(), false);
				caller.paintImmediately(0,0,caller.getWidth(), caller.getHeight());
				caller.revalidate();
				if (player.health <= 0)
					caller.game_over();
				try{
				Thread.sleep(20);
			    } catch(Exception e){
			    }
				j.dispose();
				
			}
		});
		
		JButton jbC = new JButton(mcq.getansWrong2());
		jbC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				player.loseHealth(false);
				player.setWeapon("");     
				player.updateResults(opponent.get_name(), false);
				caller.paintImmediately(0,0,caller.getWidth(), caller.getHeight());
				caller.revalidate();
				if (player.health <= 0)
					caller.game_over();
							
try{
				Thread.sleep(20);
			    } catch(Exception e){
			    }
				j.dispose();
			}
		});
		
		JButton jbD = new JButton(mcq.getansWrong3());
		jbD.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				player.loseHealth(false);
				player.setWeapon("");
				player.updateResults(opponent.get_name(), false);
				caller.paintImmediately(0,0,caller.getWidth(), caller.getHeight());
				caller.revalidate();
				if (player.health <= 0)
					caller.game_over();
				try{
				Thread.sleep(20);
			    } catch(Exception e){
			    }
				j.dispose();
			}
		});
		
		ArrayList<JButton> rgjb = new ArrayList();
		rgjb.add(jbA);
		rgjb.add(jbB);
		rgjb.add(jbC);
		rgjb.add(jbD);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		int length = rgjb.size();
		for (int i = 0; i < length; i++) {
			int k = r.nextInt(rgjb.size());
			this.add(rgjb.get(k));
			rgjb.remove(k);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		g.drawString(mcq.getQ(), 10, 10);

	}
}
