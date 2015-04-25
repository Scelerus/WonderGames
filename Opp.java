
import javax.swing.JFrame;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;


public class Opp extends Character {
   
    private Random r = null;
    private String name;
    private ArrayList<MCQ> rgMCQ;

    public Opp (String name, String questionFile, String imagepath, Random r, int x, int y)
    {
	super(imagepath, r);
    	try {
    		rgMCQ = MCQ.MCQInput(questionFile);
    	} catch (FileNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	this.r = r;
	this.name = name;
	this.setxCoord(x);
	this.setyCoord(y);
	this.setHealth(10);
	maxHealth = 10;

	// TODO: MJK : when we have imagaes for the enemies, use them here!
	this.setImagePath(imagepath);
    }

    public String get_name () {
    	return name;
    }

    //s is whether the character hitting them has a sword!
    @Override
    public void loseHealth(boolean s){
	if(s)
	    health -= 2;
	else
	    health--;
    }

    public void move(int MAXX, int MAXY, Til[][] tiles, int[][] MAP_DATA){
	if(r.nextInt(10) < 4){
	    tiles[this.getxCoord()][this.getyCoord()].placeOpp(null);
	    int d = r.nextInt(4);
	    int newx = this.getxCoord();
	    int newy = this.getyCoord();
	    int oldx = newx;
	    int oldy = newy;
	    switch(d){
	    case Character.NORTH:
		newy = this.getyCoord() - 1;
		this.setDir(Character.NORTH);
		if(newy < 0)
		    newy = 0;
		break;
	    case Character.SOUTH:
		newy = (this.getyCoord() + 1);
		this.setDir(Character.SOUTH);
		if(newy > MAXY)
		    newy = MAXY;
		break;
	    case Character.EAST:
		newx = (this.getxCoord() + 1);
		this.setDir(Character.EAST);
		if(newx > MAXX)
		    newx = MAXX;
		break;
	    case Character.WEST:
		newx = (this.getxCoord() - 1);
		this.setDir(Character.WEST);
		if(newx < 0)
		    newx = 0;
		break;
		
	     }

	    if(MAP_DATA[newx][newy] == 2){
		newx = oldx;
		newy = oldy;
	    }
	    
	    this.setxCoord(newx);
	    this.setyCoord(newy);
	    tiles[this.getxCoord()][this.getyCoord()].placeOpp(this);

	}
    }

    public JFrame askQuestion(Character player, Map caller){
	JFrame j = new JFrame();
	j.setSize(600,600);
	j.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	j.setContentPane(new MCQDisplay(rgMCQ.get(r.nextInt(rgMCQ.size())), r, j, player, this, caller));
	j.setVisible(true);
	return j;
    }
}