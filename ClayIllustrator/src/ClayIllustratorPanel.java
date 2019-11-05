import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
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
	BufferedImage finger; 
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
			b.drawEffects1(imageC2);
		}
		
		for(Blob b: bl1) {
			b.drawEffects2(imageC2);
		}
		
		for(Blob b: bl1) {
			b.drawEffects3(imageC2);
		}
		
		for(Blob b: bl1) {
			b.drawGfx(imageC2);
		}
	
		repaint();
		
		c2.drawImage(imageBuffer, 0, 0, this);
		c.dispose();
		c2.dispose();
		
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
	
	private class Blob {   				
		private int x;
		private int y;
		private int size;
		private Color shadow;
		private Color white;
		private Color color;
		private Color splig;
		private Color splig2;
		private Color splig3;
		private int rand;
		private int randC;
	
		public Blob(int newX, int newY, int newSize, int clickNum) {
			x = newX;
			y = newY;
			size = newSize;
			rand = random.nextInt(3);
			randC = random.nextInt(2);
			color = selectedColor;
			white = new Color(200 + randC, 200 + randC, 200 + randC, 70);
			shadow = new Color(color.getRed() - 20, color.getGreen() - 20, color.getBlue() - 20, 21);
			splig = new Color(color.getRed() + 10 + randC, color.getGreen() + 10 + randC, color.getBlue() + 10);
			splig2 = new Color(color.getRed() + 20 + randC, color.getGreen() + 20, color.getBlue() + 20 + randC);
			splig3 = new Color(color.getRed() + 27, color.getGreen() + 27 + randC, color.getBlue() + 27, 30);
			
			try {
				finger = ImageIO.read(new File("C:\\Users\\Ana\\Desktop\\clay graphics\\finger2.png"));
				} catch (IOException e) {
			}			
				
		    for (int xx = 0; xx < finger.getWidth(); xx++) {
		        for (int yy = 0; yy < finger.getHeight(); yy++) {
		        	Color colors = new Color(finger.getRGB(xx, yy));
		        	int red = colors.getRed();
		        	int green = colors.getGreen();
		        	int blue = colors.getBlue();
		        	int value = ((red + green + blue)/3);
		        	if (finger.getRGB(xx, yy) == Transparency.TRANSLUCENT) {
		        		finger.setRGB(xx, yy, new Color(0, 0, 0, 0).getRGB());
		        	}
		        	else {
		        		finger.setRGB(xx, yy, new Color(value, value, value, 23).getRGB());
		        	}
			    }
		   }
		}

		public void shadow(Graphics c) {
			c.setColor(shadow);
			c.fillOval(x - size/2 + 2, y-size/2 + 2, size - 10, size - 10);
		}
		
		public void drawBlob(Graphics c) {
			c.setColor(color);
			c.fillOval(x - size/2 + 3, y-size/2 + 3, size - 13, size - 13);

		}
	
		public void drawEffects1(Graphics c) {
			c.setColor(splig);
			c.fillOval(x - size/2 + 4, y-size/2 + 4, size - 16, size - 16);

		}
		
		public void drawEffects2(Graphics c) {
			c.setColor(splig2);
			c.fillOval(x - size/2 + 5, y-size/2 + 5, size - 19, size - 19);
		}

		public void drawEffects3(Graphics c) {
			c.setColor(splig3);
			c.fillOval(x - size/2 + 6, y-size/2 + 6, size - 22, size - 22);
		}
		
		public void drawGfx(Graphics c) {
		//	c.setColor(white);
		//	c.fillOval(x - size/2 + 7, y-size/2 + 7, size - 24, size - 24);
			c.drawImage(finger, x - size/2 + 7, y-size/2 + 7, size - 22, size - 22, null);
		}	
		

	}
}
