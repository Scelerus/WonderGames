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

public class Map extends JPanel implements KeyListener{

    final int TILE_WIDTH = 160;
    final int TILE_HEIGHT = 160;

    Character chr;

    Random r;
    Til[][] tiles;
    
    public Map (ArrayList<MCQ> rgmcq, Random r){
		this.r = r;
		addKeyListener(this);
		setFocusable(true);
		
		//initialize the character
		chr = new Character();
		
		//create tiles here. Use mcq_s from the array list that's passed in
		int rgmcqLength = (int) Math.sqrt(rgmcq.size());
		int rgmcqWidth = rgmcq.size() - rgmcqLength;
		this.tiles = new Til[10][10];
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					tiles[j][k] = new Til(rgmcq.get(r.nextInt(rgmcq.size())), "tile_image.jpg");
				}
				
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

	@Override
	protected void paintComponent(Graphics g){
		for(int i = 0; i < tiles.length; i++){
		    for(int j = 0; j < tiles[0].length; j++){
			Til t = tiles[i][j];
			g.drawImage(getImg(t.getFileName()), TILE_WIDTH*i, TILE_HEIGHT*j, null);
		    }
		}
		g.drawImage(getImg(chr.getImagePath()), TILE_WIDTH*chr.getxCoord(), TILE_HEIGHT*chr.getyCoord(), null); 
        
    }

    public void keyPressed(KeyEvent e) {
    	int kpCode = e.getKeyCode();
    	if(kpCode == 38) { //Left
    			if((chr.getxCoord() - 1) < 0) {
    			}
    			else { 
                	chr.setxCoord(chr.getxCoord() - 1);
                }
        }
        else if(kpCode == 40) {//Right
                chr.setxCoord(chr.getxCoord() + 1);
        }
        else if(kpCode == 37) {//Up
        		if((chr.getyCoord() - 1) < 0) {
    			}
    			else { 
                	chr.setyCoord(chr.getyCoord() - 1);
                }
        }
        else if(kpCode == 39) {//Down
                chr.setyCoord(chr.getyCoord() + 1);
        }
        System.out.println(chr.getxCoord());
        System.out.println(chr.getyCoord());

    }
    
    public void keyReleased(KeyEvent e) {
    	repaint();
    
    }
    
    public void keyTyped(KeyEvent e) {

    }
}
