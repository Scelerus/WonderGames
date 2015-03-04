import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;


public class Map extends JPanel {

    final int TILE_WIDTH = 200;
    final int TILE_HEIGHT = 200;

    Random r;
    Tile[][] tiles;
    public Map (ArrayList<MCQ> rgmcq, Random r){
	this.r = r;
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
		    img = ImageIO.read(new File(t.getFilename()));
		} catch (IOException e) {
		}
		g.drawImage(img, TILE_WIDTH*i, TILE_HEIGHT*j, null);
	    }
	}
    }

}
