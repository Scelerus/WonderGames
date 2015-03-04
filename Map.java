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
    Til[][] tiles;
    public Map (ArrayList<MCQ> rgmcq, Random r){
	this.r = r;
	KeyListener listener = new KeyListener();
	addKeyListener(listener);
	//KeyListener listener = new MyKeyListener();
	//addKeyListener(listener);
	setFocusable(true);
	//create tiles here. Use mcq_s from the array list that's passed in
	int rgmcqLength = (int) Math.sqrt(rgmcq.size());
	int rgmcqWidth = rgmcq.size() - rgmcqLength;
	this.tiles = new Til[10][10];
		for (int j = 0; j < 10; j++) {
			for (int k = 0; k < 10; k++) {
				tiles[j][k] = new Til(rgmcq.get(r.nextInt(rgmcq.size())), "Image");
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
	if(KeyEvent.getKeyText(e.getKeyCode())
    }

}
