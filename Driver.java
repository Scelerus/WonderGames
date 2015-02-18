// @ Martin Kellogg ; 2/11/15

import javax.swing.JFrame;

public class Driver {
    public static void main (String[] args){
	JFrame j = new JFrame();
	j.setSize(400,600);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	j.setContentPane(new MCQDisplay());
	j.setVisible(true);
    }
}