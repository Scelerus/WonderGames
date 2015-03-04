import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Map extends JPanel {

    Random r;
    Tile[][] tiles;
    public Map (ArrayList<MCQ> rgmcq, Random r){
	this.r = r;
	KeyListener listener = new MyKeyListener();
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

    public class MyKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
	}

    }

}
