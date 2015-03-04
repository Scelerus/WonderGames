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

    final int TILE_WIDTH = 200;
    final int TILE_HEIGHT = 200;

    Random r;
    Tile[][] tiles;
    public Map (ArrayList<MCQ> rgmcq, Random r){
	this.r = r;
	KeyListener listener = new KeyListener();
	addKeyListener(listener);
	setFocusable(true);
	//create tiles here. Use mcq_s from the array list that's passed in
	int rgmcqLength = (int) Math.sqrt(rgmcq.size());
	int rgmcqWidth = rgmcq.size() - rgmcqLength;
	this.tiles = new Tile[rgmcqLength][rgmcqWidth];
		for (int j = 0; j < rgmcqLength; j++) {
			for (int k = 0; k < rgmcqWidth; k++) {
				tiles[j][k] = new Tile(rgmcq.get(0), "Image");
			}
			
		}
	
    }

    @Override
    protected void paintComponent(Graphics g){
	for(int i = 0; i < tiles.length; i++){
	    for(int j = 0; j < tiles[0].length; j++){
		Tile t = tiles[i][j];
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(t.getFileName()));
		} catch (IOException e) {
		}
		g.drawImage(img, TILE_WIDTH*i, TILE_HEIGHT*j, null);
	    }
	}
    }

    @Override
    public void keyPressed(KeyEvent e) {
	String kpText = KeyEvent.getKeyText(e.getKeyCode());
	if(kpText.equals("Left Arrow")) {
		chr.setxCoord(chr.getxCoord() - 1);
	}
	else if(kpText.equals("Right Arrow")) {
		chr.setxCoord(chr.getxCoord() + 1);
	}
	else if(kpText.equals("Up Arrow")) {
		chr.setyCoord(getyCoord() + 1);
	}
	else if(kpText.equals("Down Arrow")) {
		chr.setyCoord(getyCoord() - 1);
	}
    }
    @Override
    public voide keyReleased(KeyEvent e) {
    }
}
