import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Map extends JPanel {

    Random r;

    public Map (ArrayList<MCQ> rgmcq, Random r){
	this.r = r;
	KeyListener listener = new MyKeyListener();
	addKeyListener(listener);
	setFocusable(true);
	//create tiles here. Use mcq_s from the array list that's passed in
    }

    public class MyKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
	}

    }

}
