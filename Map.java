import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics;

import javax.swing.JFrame;

import java.awt.Color;

public class Map extends JPanel implements KeyListener{

    final int TILE_WIDTH = 160;
    final int TILE_HEIGHT = 120;

    final int MAP_WIDTH = 20; //should be tied to MAP_DATA
    final int MAP_HEIGHT = 20; // should be tied to MAP_DATA

    /*    Green = 1
	  Blue = 2
	  Black = 3
	  Brown = 4
	  Tan = 5
    */

    final int [] [] MAP_DATA = {
	{5, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 3, 3, 1, 1, 3},
	{5, 5, 1, 1, 1, 1, 3, 2, 2, 2, 2, 2, 1, 1, 1, 1, 3, 1, 3, 1},
	{5, 5, 1, 1, 3, 1, 1, 3, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 3, 1},
	{5, 1, 4, 4, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 1},
	{5, 1, 4, 4, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 1},
	{5, 1, 1, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 4, 4, 1, 1},
	{5, 5, 1, 4, 4, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 4, 4, 1, 1},
	{5, 5, 1, 1, 4, 4, 1, 1, 1, 1, 1, 2, 2, 2, 2, 4, 4, 1, 1, 1},
	{5, 5, 5, 1, 4, 4, 1, 1, 1, 1, 4, 2, 2, 2, 2, 4, 4, 1, 1, 1},
	{5, 5, 5, 1, 1, 4, 4, 1, 1, 4, 4, 4, 2, 2, 4, 4, 1, 1, 1, 1},
	{5, 5, 1, 1, 1, 4, 4, 1, 1, 4, 4, 4, 2, 2, 4, 4, 1, 1, 1, 1},
	{5, 5, 1, 1, 1, 1, 4, 4, 4, 4, 1, 4, 4, 4, 4, 1, 1, 1, 1, 3},
	{5, 5, 1, 1, 1, 1, 1, 4, 4, 1, 1, 1, 4, 4, 1, 1, 1, 1, 3, 3},
	{5, 5, 5, 5, 1, 1, 1, 4, 4, 1, 1, 1, 4, 4, 1, 1, 3, 1, 3, 3},
	{5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 3},
	{5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 1},
	{5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 1, 1, 1, 3, 1, 3, 1},
	{5, 1, 1, 1, 1, 5, 5, 1, 1, 1, 1, 5, 5, 5, 5, 1, 1, 3, 1, 1},
	{5, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1},
	{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}
    };

    
	//Number of rows and columns of tiles to display at a time
    final int H_TILES_DISPLAYED = 7;
    final int V_TILES_DISPLAYED = 6;

    /*    Green = 1
	  Blue = 2
	  Black = 3
	  Brown = 4
	  Tan = 5
    */

    final String[] RG_TIL_IMAGE = {"assets/WGGrass-small.jpg", "assets/WGWater.png", "assets/WGMountain.png", "assets/WGTree.png", "assets/WGDesert.png"};

    final String TILE_IMAGE = "assets/WGGrass-small.jpg";

    Character chr;
    JProgressBar healthBar;

    JFrame jf = null;
    JFrame jfBig = null;

    Random r;
    Til[][] tiles;
    
	//Set bounds for displaying part of the map at a time
	int leftBound;
	int rightBound;
	int topBound;
	int bottomBound;

    boolean fRepaint = false;

    private ArrayList<Opp> rgopp;
    

    public ArrayList<Opp> getrgopp(){
	return rgopp;
    }

    public Map (ArrayList<Opp> rgopp_in, Random r, JFrame my_frame){

		this.r = r;
		rgopp = rgopp_in;
		addKeyListener(this);
		setFocusable(true);
		jfBig = my_frame;
		//initialize the character
		chr = new Character("assets/WGSpriteP13", r);
		
		//Health bar setup
		this.healthBar = new JProgressBar(0, this.chr.getMaxHealth());
		healthBar.setValue(chr.getHealth());
		healthBar.setStringPainted(true);
		healthBar.setForeground(Color.red);
		healthBar.setString("Health: " + chr.getHealth() + "/" + chr.getMaxHealth());
		this.add(healthBar);
		
		//create tiles here. Use mcq_s from the array list that's passed in
		this.tiles = new Til[MAP_WIDTH][MAP_HEIGHT];
			for (int j = 0; j < MAP_WIDTH; j++) {
				for (int k = 0; k < MAP_HEIGHT; k++) {
				    tiles[j][k] = new Til(RG_TIL_IMAGE[(MAP_DATA[j][k] - 1)], r);
				}
				
			}
			for(int i = 0; i < rgopp.size(); i++){
			    Opp opp = rgopp.get(i);
			    tiles[opp.getxCoord()][opp.getyCoord()].placeOpp(opp);
			}
}

    private BufferedImage getImg(String filename){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(filename));
		} catch (IOException e) {
		    //System.err.println(filename + " not found");
		}
		return img;
	}

    public void setBounds() {
    	leftBound = 0;
    	rightBound = 0;
    	topBound = 0;
    	bottomBound = 0;

		leftBound += (chr.getxCoord() - (H_TILES_DISPLAYED / 2));
		if (leftBound < 0) {
			rightBound = -leftBound;
			leftBound = 0;
		}
		rightBound += (chr.getxCoord() + ((H_TILES_DISPLAYED + 1) / 2));
		if (rightBound > MAP_WIDTH) {
			leftBound -= (rightBound - MAP_WIDTH);
			rightBound = MAP_WIDTH;
		}
		topBound += (chr.getyCoord() - (V_TILES_DISPLAYED / 2));
		if (topBound < 0) {
			bottomBound = -topBound;
			topBound = 0;
		}
		bottomBound += (chr.getyCoord() + ((V_TILES_DISPLAYED + 1) / 2));
		if (bottomBound > MAP_HEIGHT) {
			topBound -= (bottomBound - MAP_HEIGHT);
			bottomBound = MAP_HEIGHT;
		}
    }
    
	@Override
	protected void paintComponent(Graphics g){
	    g.clearRect(0,0,1600,1200);
	    //check to see if any opponents have died. If so, remove them from the game
	    for (int iopp = rgopp.size() - 1; iopp >= 0; iopp--){
		if(rgopp.get(iopp).getHealth() <= 0){
		    tiles[rgopp.get(iopp).getxCoord()][rgopp.get(iopp).getyCoord()].placeOpp(null);
		    rgopp.remove(iopp);
		    
		}
	    }
	    if (rgopp.isEmpty())
	    	this.game_over();

	    healthBar.setValue(chr.getHealth());
		healthBar.setString("Health: " + chr.getHealth() + "/" + chr.getMaxHealth());
		

		this.setBounds();
		int hOrientation = 0;
		int vOrientation = 0;
		for(int i = leftBound; i < rightBound; i++){
		    for(int j = topBound; j < bottomBound; j++){
			Til t = tiles[i][j];
			g.drawImage(getImg(t.getFileName()), TILE_WIDTH*(hOrientation), TILE_HEIGHT*(vOrientation), null);
			if (t.getOpp() != null) {
			    g.setColor(Color.BLACK);
			    g.drawRect(TILE_WIDTH*(t.getOpp().getxCoord() - leftBound)+ t.getOpp().xoff, TILE_HEIGHT*(t.getOpp().getyCoord() - topBound)+ t.getOpp().yoff, t.getOpp().getMaxHealth(), 5);
			    g.setColor(Color.RED);
			    g.fillRect(TILE_WIDTH*(t.getOpp().getxCoord() - leftBound) + t.getOpp().xoff, TILE_HEIGHT*(t.getOpp().getyCoord() - topBound) + t.getOpp().yoff, t.getOpp().getHealth(), 5);
			    g.setColor(Color.BLACK);
			    g.drawImage(getImg(t.getOpp().getImagePath()), TILE_WIDTH*(t.getOpp().getxCoord() - leftBound) + t.getOpp().xoff, TILE_HEIGHT*(t.getOpp().getyCoord() - topBound) + t.getOpp().yoff, null);
			}
			vOrientation++;
		    }
		    vOrientation = 0;
		    hOrientation++;
		}
		g.drawImage(getImg(chr.getImagePath()), TILE_WIDTH*(chr.getxCoord() - leftBound)+chr.xoff, TILE_HEIGHT*(chr.getyCoord() - topBound)+chr.yoff, null); 

		//g.drawString(chr.getWeapon(), 20, 20);
		g.drawImage(getImg("assets/WGIcon"+chr.getWeapon()+".png"), 1125, 20, null);


//		Martin's Health Bar
//		g.setColor(Color.BLACK);
//		g.drawRect(50, 50, chr.getMaxHealth()*2+1, 10);
//		g.setColor(Color.RED);
//		g.fillRect(51, 51, chr.getHealth()*2, 8);
    }

    public void keyPressed(KeyEvent e) {

	if(jf != null && jf.isDisplayable()){ 
	    fRepaint = true;
	    return;
	}
	if(fRepaint){
	    repaint();
	    fRepaint = false;
	}

    	int kpCode = e.getKeyCode();
	int oldx = chr.getxCoord();
	int oldy = chr.getyCoord();
	boolean changed = false;
	int newx = oldx;
	int newy = oldy;
    	if(kpCode == KeyEvent.VK_LEFT || kpCode == KeyEvent.VK_A) { //Left
 	chr.setDir(Character.WEST);
	    newx--;
	    changed = true;
        }
        else if(kpCode == KeyEvent.VK_RIGHT || kpCode == KeyEvent.VK_D) {//Right
 	chr.setDir(Character.EAST);
	    newx++;
	    changed = true;
	}
        else if(kpCode == KeyEvent.VK_UP || kpCode == KeyEvent.VK_W) {//Up
 	chr.setDir(Character.NORTH);
	    newy--;
	    changed = true;
        }
        else if(kpCode == KeyEvent.VK_DOWN || kpCode == KeyEvent.VK_S) {//Down
 	chr.setDir(Character.SOUTH);
	    newy++;
	    changed = true;
	}
	if (changed) {
	    if (newx < 0 || newx >= MAP_WIDTH)
		newx = oldx;
	    else if (newy < 0 || newy >= MAP_WIDTH)
		newy = oldy;
	    for(Opp opp : rgopp)
		opp.move(MAP_WIDTH, MAP_HEIGHT, tiles, MAP_DATA);
	    //TODO: MJK: Figure out why the fuck we need this

	    /*
	    if (newx - oldx == 2)
		newx--;
	    if (oldx - newx == 2)
		newx++;
	    if (newy - oldy == 2)
		newy--;
	    if (oldy - newy == 2)
		newy++;
	    */

	    if(MAP_DATA[newx][newy] == 2 || MAP_DATA[newx][newy] == 3){
		newx = oldx;
		newy = oldy;
	    }

	    if(newx != oldx || newy != oldy){
		chr.setxCoord(newx);
		chr.setyCoord(newy);
		jf = tiles[newx][newy].displayQuestion(chr, this);
		repaint();
		fRepaint = true;
	    }
	}

    }
    public void keyReleased(KeyEvent e) {
    
    }

    public void keyTyped(KeyEvent e) {

    }
    
    public void game_over() {
	JFrame j = new JFrame("Wonder Games");
	j.setSize(1200,800);
	j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	if (rgopp.isEmpty())
		j.setContentPane(new JScrollPane(new EndScreen(j, chr.getResults(), true)));
	else 
		j.setContentPane(new JScrollPane(new EndScreen(j, chr.getResults(), false)));
	j.setVisible(true);
	jfBig.dispose();
    }
}
