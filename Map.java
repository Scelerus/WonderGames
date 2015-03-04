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
    Tile[][] tiles;
    public Map (ArrayList<MCQ> rgmcq, Random r){
	this.r = r;
	KeyListener listener = new KeyListener();
	addKeyListener(listener);
	//KeyListener listener = new MyKeyListener();
	//addKeyListener(listener);
	setFocusable(true);
	
	//initialize the character
	chr = new Character();
	
	//create tiles here. Use mcq_s from the array list that's passed in
	int rgmcqLength = (int) Math.sqrt(rgmcq.size());
	int rgmcqWidth = rgmcq.size() - rgmcqLength;
	this.tiles = new Tile[rgmcqLength][rgmcqWidth];
		for (int j = 0; j < rgmcqLength; j++) {
			for (int k = 0; k < rgmcqWidth; k++) {
				tiles[j][k] = new Tile(rgmcq.get(0), "tile_image.jpg");
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
		Tile t = tiles[i][j];
		g.drawImage(getImg(t.getFileName()), TILE_WIDTH*i, TILE_HEIGHT*j, null);
	    }
	}
	g.drawImage(getImg(chr.getImagePath()), TILE_WIDTH*chr.getxCoord(), TILE_HEIGHT*chr.getyCoord(), null); 
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
	//if(KeyEvent.getKeyText(e.getKeyCode())
    }

}
