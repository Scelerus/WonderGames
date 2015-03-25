
public class Opp extends Character {
   
    MCQ mcq = null;
    Random r = null;

    public Opp (Mcq mcq, Random r, int x, int y){
	this.mcq = mcq;
	this.r = r;
	this.setxCoord(x);
	this.setyCoord(y);
    }
    public JFrame askQuestion(){
	JFrame j = new JFrame();
	j.setSize(400,600);
	j.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	j.setContentPane(new MCQDisplay(q, r, j));
	j.setVisible(true);
	return j;
    }
}