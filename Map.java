import javax.swing.JPanel;
import javax.swing.JProgressBar;

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

    final int MAP_WIDTH = 10; //should be tied to MAP_DATA
    final int MAP_HEIGHT = 10; // should be tied to MAP_DATA

    final int [] [] MAP_DATA = {{1,2},{0,3}};
    
	//Number of rows and columns of tiles to display at a time
    final int H_TILES_DISPLAYED = 7;
    final int V_TILES_DISPLAYED = 6;

    final String[] RG_TIL_IMAGE = {"assets/WGGrass-small.jpg", "assets/WGGrass-small.jpg", "assets/WGGrass-small.jpg", "assets/WGGrass-small.jpg", "assets/WGGrass-small.jpg"};

    final String TILE_IMAGE = "assets/WGGrass-small.jpg";

    Character chr;
    JProgressBar healthBar;

    JFrame jf = null;

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

    public Map (ArrayList<Opp> rgopp_in, Random r){
		this.r = r;
		rgopp = rgopp_in;
		addKeyListener(this);
		setFocusable(true);
		
		//initialize the character
		chr = new Character();
		
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

	    //check to see if any opponents have died. If so, remove them from the game
	    for (int iopp = rgopp.size() - 1; iopp >= 0; iopp--){
		if(rgopp.get(iopp).getHealth() <= 0){
		    tiles[rgopp.get(iopp).getxCoord()][rgopp.get(iopp).getyCoord()].placeOpp(null);
		    rgopp.remove(iopp);
		    
		}
	    }

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
			    g.drawRect(TILE_WIDTH*(t.getOpp().getxCoord() - leftBound), TILE_HEIGHT*(t.getOpp().getyCoord() - topBound), t.getOpp().getMaxHealth(), 5);
			    g.setColor(Color.RED);
			    g.fillRect(TILE_WIDTH*(t.getOpp().getxCoord() - leftBound), TILE_HEIGHT*(t.getOpp().getyCoord() - topBound), t.getOpp().getHealth(), 5);
			    g.setColor(Color.BLACK);
			    g.drawImage(getImg(t.getOpp().getImagePath()), TILE_WIDTH*(t.getOpp().getxCoord() - leftBound), TILE_HEIGHT*(t.getOpp().getyCoord() - topBound), null);
			}
			vOrientation++;
		    }
		    vOrientation = 0;
		    hOrientation++;
		}
		g.drawImage(getImg(chr.getImagePath()), TILE_WIDTH*(chr.getxCoord() - leftBound), TILE_HEIGHT*(chr.getyCoord() - topBound), null); 

		g.drawString(chr.getWeapon(), 20, 20);
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
    	chr.setImagePath("assets/WGSpriteP1Left3.png");
	chr.setDir(Character.WEST);
	    newx--;
	    changed = true;
        }
        else if(kpCode == KeyEvent.VK_RIGHT || kpCode == KeyEvent.VK_D) {//Right
        chr.setImagePath("assets/WGSpriteP1Right2.png");
	chr.setDir(Character.EAST);
	    newx++;
	    changed = true;
	}
        else if(kpCode == KeyEvent.VK_UP || kpCode == KeyEvent.VK_W) {//Up
        chr.setImagePath("assets/WGSpriteP1Back1.png");
	chr.setDir(Character.NORTH);
	    newy--;
	    changed = true;
        }
        else if(kpCode == KeyEvent.VK_DOWN || kpCode == KeyEvent.VK_S) {//Down
        chr.setImagePath("assets/WGSpriteP1Front1.png");
	chr.setDir(Character.SOUTH);
	    newy++;
	    changed = true;
	}
	if (changed) {
	    if (newx < 0 || newx >= MAP_WIDTH)
		newx = oldx;
	    else if (newy < 0 || newy >= MAP_WIDTH)
		newy = oldy;
	    
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
}
