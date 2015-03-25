import javax.swing.JPanel;
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

public class Map extends JPanel implements KeyListener{

    final int TILE_WIDTH = 160;
    final int TILE_HEIGHT = 120;

    final int MAP_WIDTH = 10;
    final int MAP_HEIGHT = 10;

    final String TILE_IMAGE = "assets/WGGrass-small.jpg";

    Character chr;

    JFrame jf = null;

    Random r;
    Til[][] tiles;

    ArrayList<Opp> rgopp;
    
    public Map (ArrayList<MCQ> rgmcq, Random r){
		this.r = r;
		rgopp = new ArrayList<Opp>();
		addKeyListener(this);
		setFocusable(true);
		
		//initialize the character
		chr = new Character();
		
		//create tiles here. Use mcq_s from the array list that's passed in
		int rgmcqLength = (int) Math.sqrt(rgmcq.size());
		int rgmcqWidth = rgmcq.size() - rgmcqLength;
		this.tiles = new Til[MAP_WIDTH][MAP_HEIGHT];
			for (int j = 0; j < MAP_WIDTH; j++) {
				for (int k = 0; k < MAP_HEIGHT; k++) {
					tiles[j][k] = new Til(TILE_IMAGE, r);
				}
				
			}
			rgopp.add(new Opp(rgmcq.get(0), r, 3, 2));
			
}

    private BufferedImage getImg(String filename){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(filename));
		} catch (IOException e) {
		}
		return img;
	}

	@Override
	protected void paintComponent(Graphics g){
		for(int i = 0; i < tiles.length; i++){
		    for(int j = 0; j < tiles[0].length; j++){
			Til t = tiles[i][j];
			g.drawImage(getImg(t.getFileName()), TILE_WIDTH*i, TILE_HEIGHT*j, null);
			if (t.getOpp() != null) {
			    g.drawImage(getImg(t.getOpp().getImagePath()), TILE_WIDTH*t.getOpp().getxCoord(), TILE_HEIGHT*t.getOpp().getyCoord(), null);
			}
		    }
		}
		g.drawImage(getImg(chr.getImagePath()), TILE_WIDTH*chr.getxCoord(), TILE_HEIGHT*chr.getyCoord(), null); 
        
    }

    public void keyPressed(KeyEvent e) {

	if(jf != null && jf.isDisplayable()) return;

    	int kpCode = e.getKeyCode();
	int oldx = chr.getxCoord();
	int oldy = chr.getyCoord();
	boolean changed = false;
	int newx = oldx;
	int newy = oldy;
    	if(kpCode == KeyEvent.VK_LEFT || kpCode == KeyEvent.VK_A) { //Left
	    newx--;
	    changed = true;
        }
        else if(kpCode == KeyEvent.VK_RIGHT || kpCode == KeyEvent.VK_D) {//Right
	    newx++;
	    changed = true;
	}
        else if(kpCode == KeyEvent.VK_UP || kpCode == KeyEvent.VK_W) {//Up
	    newy--;
	    changed = true;
        }
        else if(kpCode == KeyEvent.VK_DOWN || kpCode == KeyEvent.VK_S) {//Down
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
		jf = tiles[newx][newy].displayQuestion();
		repaint();	    
	    }
	}

    }
    public void keyReleased(KeyEvent e) {
    
    }

    public void keyTyped(KeyEvent e) {

    }
}
