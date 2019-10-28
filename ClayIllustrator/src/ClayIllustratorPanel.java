import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ClayIllustratorPanel extends JPanel {
	
	Random random = new Random(); // random, the list to hold all the clay blobs, the basic blob size, and the color
	ArrayList<Blob> blobList;
	static int newSize = 40;
	static Color selectedColor;
		
	// the new panel that holds the list of 
	public ClayIllustratorPanel() {
		blobList = new ArrayList<Blob>();
		selectedColor = new Color(200,100,128);
		setBackground(Color.WHITE);
		addMouseListener(new BlobListener());
		addMouseMotionListener(new BlobListener());
	}
	
	public void paintComponent(Graphics canvas) {
		super.paintComponent(canvas);
		for(Blob b: blobList) {
			b.drawBlob(canvas);
		}
		for(Blob b: blobList) {
			b.drawEffects1(canvas);
		}
		for(Blob b: blobList) {
			b.drawEffects2(canvas);
		}
		for(Blob b: blobList) {
			b.drawEffects3(canvas);
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

	// listens for mouse presses. if mouse is pressed, place a blob at x,y
	private class BlobListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			blobList.add(new Blob(e.getX(), e.getY(), newSize));
			repaint();
		}
		
		// listens for mouse dragged, place a blob at x, y
		public void mouseDragged(MouseEvent e) {
			blobList.add(new Blob(e.getX(), e.getY(), newSize));
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {
			blobList.add(new Blob(e.getX(), e.getY(), newSize + 1));
			repaint();
		}
	}

	// creates a new blob and assigns it values
	private class Blob {
		private int x;
		private int y;
		private int size;
		private Color color;
		private Color splig;
		private Color splig2;
		private Color splig3;
		private Color splig4;
		private Color wheatD;
		private Color wheatW;
		private int rand;
		private int randC;
	
		public Blob(int newX, int newY, int newSize) {
			// basic selections for size and x, y value
			x = newX;
			y = newY;
			size = newSize;
			rand = random.nextInt(3);
			randC = random.nextInt(2);
			color = selectedColor;
			splig = new Color(color.getRed() + 10 + randC, color.getGreen() + 10 + randC, color.getBlue() + 10);
			splig2 = new Color(color.getRed() + 20 + randC, color.getGreen() + 20, color.getBlue() + 20 + randC);
			splig3 = new Color(color.getRed() + 27, color.getGreen() + 27, color.getBlue() + 27);
			wheatD = new Color(color.getRed() - 16, color.getGreen() - 16, color.getBlue() - 16);
			wheatW = new Color(255, 255, 255);
		}
		
		public void drawBlob(Graphics canvas) {				//render the texture
			canvas.setColor(color);
			canvas.fillOval(x - size/2, y-size/2, size - 16, size - 16);
		}
	
		public void drawEffects1(Graphics canvas) {
			// this method runs the light visible on the blob of clay
			// x and y coordinate of upper left coordinate, width, height
			canvas.setColor(splig);
			canvas.fillOval(x - size/2 + 1, y-size/2 + 1, size -20, size - 20);
		}
		
		public void drawEffects2(Graphics canvas) {
			canvas.setColor(splig2);
			canvas.fillOval(x - size/2 + 3, y-size/2 + 3, size - 24, size - 24);
		}
		
		public void drawEffects3(Graphics canvas) {
			canvas.setColor(splig3);
			canvas.fillOval(x - size/2 + 5, y-size/2 + 5, size - 26 + rand, size - 26 + rand);
//			canvas.drawImage(image, x-15, y-15, null);
		}
		
	}
	
}
