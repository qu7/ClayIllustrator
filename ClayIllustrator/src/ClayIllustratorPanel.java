import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.*;

public class ClayIllustratorPanel extends JPanel {
	Random random = new Random();
	static int newSize = 70;
	static Color selectedColor;
	int clickNum = 1;
	ArrayList<Blob> bl1 = new ArrayList<Blob>();
	boolean clickOn;
	
	public ClayIllustratorPanel() {  		
		selectedColor = new Color(200,100,128);
		setBackground(Color.WHITE);
		addMouseListener(new BlobListener());
		addMouseMotionListener(new BlobListener());
	}
	
	private class BlobListener extends MouseAdapter{    	
		// listens for mouse presses. if mouse is pressed, place a blob at x,y
		public void mousePressed(MouseEvent e) {
			bl1.add(new Blob(e.getX(), e.getY(), newSize, clickNum));
			clickOn = true;
		}
		public void mouseDragged(MouseEvent e) { 			
			bl1.add(new Blob(e.getX(), e.getY(), newSize, clickNum));
			clickOn = true;
		}
		public void mouseReleased(MouseEvent e) {
			clickOn = false;
			clickNum++;
			//bl1.clear();
		}
	}

	public void paintComponent(Graphics c) {
		super.paintComponent(c); 
			for(Blob b: bl1) {
				b.drawBlob(c);
			}
			for(Blob b: bl1) {
				b.drawEffects1(c);
			}
			for(Blob b: bl1) {
				b.drawEffects2(c);
			}
			for(Blob b: bl1) {
				b.drawEffects3(c);
			}
			repaint();
			if (clickOn == false) {
			c.copyArea(0, 0, super.getWidth(), super.getHeight(), 0, 0);
				
			}
		}
	
	public static void colorChange(int r, int g, int b) {
		int colorR = r;
		int colorG = g;
		int colorB = b;
		selectedColor = new Color(colorR, colorG, colorB);
	}
	
	public static void sizeChange(int blobSize) {
		newSize = blobSize;
	}
	
	private class Blob {   				
		private int x;
		private int y;
		private int size;
		private Color shadow;
		private Color color;
		private Color splig;
		private Color splig2;
		private Color splig3;
		private int rand;
		private int randC;
		private int click;
	
		public Blob(int newX, int newY, int newSize, int clickNum) {
			x = newX;
			y = newY;
			size = newSize;
			click = clickNum;
			rand = random.nextInt(3);
			randC = random.nextInt(2);
			color = selectedColor;
			shadow = new Color(color.getRed(), color.getGreen(), color.getBlue(), 25);
			splig = new Color(color.getRed() + 10 + randC, color.getGreen() + 10 + randC, color.getBlue() + 10);
			splig2 = new Color(color.getRed() + 20 + randC, color.getGreen() + 20, color.getBlue() + 20 + randC);
			splig3 = new Color(color.getRed() + 27, color.getGreen() + 27, color.getBlue() + 27);
		}
		
		public void drawBlob(Graphics c) {
			c.setColor(color);
			c.fillOval(x - size/2  + rand, y-size/2  + rand, size - 16, size - 16);
		}
		public void drawEffects1(Graphics c) {
			c.setColor(splig);
			c.fillOval(x - size/2, y-size/2, size - 20, size - 20);
		}
		public void drawEffects2(Graphics c) {
			c.setColor(splig2);
			c.fillOval(x - size/2, y-size/2, size - 24, size - 24);
		}
		public void drawEffects3(Graphics c) {
			c.setColor(splig3);
			c.fillOval(x - size/2, y-size/2, size - 26, size - 26);
		}	
	}
}
