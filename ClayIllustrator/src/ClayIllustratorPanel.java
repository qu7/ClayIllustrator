import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ClayIllustratorPanel extends JPanel {
	Random random = new Random();
	static int newSize = 70;
	static Color selectedColor;
	int clickNum = 1;
	ArrayList<Blob> bl1 = new ArrayList<Blob>();
	BufferedImage bi;
	boolean clickOn;
	boolean edits;
	BufferedImage imageBuffer;
	BufferedImage finger0; 
	BufferedImage finger1; 
	BufferedImage finger2; 
	BufferedImage finger3; 

	Graphics imageC2;
	
	public ClayIllustratorPanel() {  		
		selectedColor = new Color(22,22,22);
		setBackground(Color.WHITE);
		addMouseListener(new BlobListener());
		addMouseMotionListener(new BlobListener());
	}
	
	private class BlobListener extends MouseAdapter{    	
		// listens for mouse presses. if mouse is pressed, place a blob at x,y
		public void mousePressed(MouseEvent e) {
			edits = true;
			clickOn = true;
			bl1.add(new Blob(e.getX(), e.getY(), newSize, clickNum));
			
		}
		public void mouseDragged(MouseEvent e) { 			
			edits = true;
			clickOn = true;
			bl1.add(new Blob(e.getX(), e.getY(), newSize, clickNum));
			
		}
		public void mouseReleased(MouseEvent e) {
			edits = true;
			clickOn = false;
		}
	}

	public void paintComponent(Graphics c) {
		super.paintComponent(c); 
		Graphics2D c2 = (Graphics2D) c;
		
		if (edits == false) {
			imageBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			imageC2 = imageBuffer.createGraphics();
		}
		
		else {
			
		}
		
		for(Blob b: bl1) {
			b.shadow(imageC2);
		}

		for(Blob b: bl1) {
			b.drawBlob(imageC2);
		}

		for(Blob b: bl1) {
			b.drawGfx(imageC2);
		}
	
		repaint();
		
		c2.drawImage(imageBuffer, 0, 0, this);
		c.dispose();
		c2.dispose();
		imageBuffer.flush();
		
		if (clickOn == false) {
//			try {
//			    // retrieve image
//				File saved = new File("saved.png");
//			    ImageIO.write(imageBuffer, "png", saved);
//			} catch (IOException e) {
//				System.out.println("Save failed.");
//			}
			c2.drawImage(imageBuffer, 0, 0, this);
			clickOn = true;
			
			bl1.clear();
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
	
	// each blob of paint is generated here
	private class Blob {   				
		private int x;
		private int y;
		private int size;
		private Color colorShadow1;
		private Color colorShadow2;
		private Color colorShadow3;
		private int redVariant;
		private int greenVariant;
		private int blueVariant;

		private Color color;
		private int rand;
	
		public Blob(int newX, int newY, int newSize, int clickNum) {
			x = newX;
			y = newY;
			size = newSize;
			rand = random.nextInt(3);
			color = new Color(selectedColor.getRed() + rand, selectedColor.getGreen() + rand, selectedColor.getBlue() + rand, 255-rand);
		
			colorShadow1 = new Color(color.getRed()/2 + rand, color.getGreen()/2 + rand, color.getBlue()/2 + rand, 200-rand);
			colorShadow2 = new Color(color.getRed()/3 + rand, color.getGreen()/3 + rand, color.getBlue()/3 + rand, 180-rand);
			colorShadow2 = new Color(color.getRed()/4 + rand, color.getGreen()/4 + rand, color.getBlue()/4 + rand, 160-rand);
		
//			try {
//				finger0 = ImageIO.read(new File("/resources/images/finger0.png"));
//				finger1 = ImageIO.read(new File("/resources/images/finger1.png"));
//				finger2 = ImageIO.read(new File("/resources/images/finger2.png"));
//				finger3 = ImageIO.read(new File("/resources/images/finger3.png"));
//			} catch (IOException e) {
//		}
		}
		
		public void shadow3(Graphics c) {
			c.setColor(colorShadow3);
			c.fillOval(x - size/2 + 1, y-size/2 + 1, size - 3, size - 3);
		}
		
		public void shadow2(Graphics c) {
			c.setColor(colorShadow2);
			c.fillOval(x - size/2 + 1, y-size/2 + 1, size - 6, size - 6);
		}
		
		public void shadow(Graphics c) {
			c.setColor(colorShadow1);
			c.fillOval(x - size/2 + 1, y-size/2 + 1, size - 8, size - 8);
		}
		
		public void drawBlob(Graphics c) {
			c.setColor(color);
			c.fillOval(x - size/2 + 3, y-size/2 + 3, size - 13, size - 13);
		}

		public void drawGfx(Graphics c) {
			float opacity = 0.1f;
			((Graphics2D) c).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

			if (rand == 0) {
				c.drawImage(finger0, x - size/2 + 3, y-size/2 + 3, size - 13, size - 13, null);
//				finger0.flush();
			}
			else if (rand == 1) {
				c.drawImage(finger1, x - size/2 + 3, y-size/2 + 3, size - 13, size - 13, null);
//				finger1.flush();		
			}
			else if (rand == 2) {
				c.drawImage(finger2, x - size/2 + 3, y-size/2 + 3, size - 13, size - 13, null);
//				finger2.flush();		
			}
			else {
				c.drawImage(finger3, x - size/2 + 3, y-size/2 + 3, size - 13, size - 13, null);
//				finger3.flush();		
			}
		}
	}
}
