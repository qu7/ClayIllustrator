import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JSlider;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ClayIllustrator extends JFrame {
	public  ClayIllustrator() {
		Color color1 = new Color(22, 22, 22);
		Color color2 = new Color(225, 225, 225);
		Color color3 = new Color(222, 86, 86);
		Color color4 = new Color(109, 225, 118);
		Color color5 = new Color(18, 155, 32);
		Color color6 = new Color(35, 110, 43);
		Color color7 = new Color(212, 225, 84);
		Color color8 = new Color(201, 154, 16);
		Color color9 = new Color(16, 167, 201);
		Color color10 = new Color(40, 113, 155);

		// shows the current selected color
		JPanel panelColorChoice = new JPanel();
		panelColorChoice.setBounds(10, 11, 41, 44);
		panelColorChoice.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelColorChoice.setBackground(new Color(1,1,1));
		getContentPane().add(panelColorChoice);
		
		// adds buttons for each color
		JButton btnColor1 = new JButton("");
		btnColor1.setForeground(Color.BLACK);
		btnColor1.setBackground(color1);
		btnColor1.setBounds(63, 11, 23, 23);
		btnColor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int colorR = color1.getRed();
				int colorG = color1.getGreen();
				int colorB = color1.getBlue();
				ClayIllustratorPanel.colorChange(colorR, colorG, colorB);
				panelColorChoice.setBackground(color1);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnColor1);
		
		JButton btnColor2 = new JButton("");
		btnColor2.setForeground(Color.BLACK);
		btnColor2.setBackground(color2);
		btnColor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int colorR = color2.getRed();
				int colorG = color2.getGreen();
				int colorB = color2.getBlue();
				ClayIllustratorPanel.colorChange(colorR, colorG, colorB);
				panelColorChoice.setBackground(color2);
			}
		});
		btnColor2.setBounds(85, 11, 23, 23);
		getContentPane().add(btnColor2);
		
		JButton btnColor3 = new JButton("");
		btnColor3.setForeground(Color.BLACK);
		btnColor3.setBackground(color3);
		btnColor3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int colorR = color3.getRed();
				int colorG = color3.getGreen();
				int colorB = color3.getBlue();
				ClayIllustratorPanel.colorChange(colorR, colorG, colorB);
				panelColorChoice.setBackground(color3);
			}
		});
		btnColor3.setBounds(107, 11, 23, 23);
		getContentPane().add(btnColor3);
		
		JButton btnColor4 = new JButton("");
		btnColor4.setForeground(Color.BLACK);
		btnColor4.setBackground(color4);
		btnColor4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int colorR = color4.getRed();
				int colorG = color4.getGreen();
				int colorB = color4.getBlue();
				ClayIllustratorPanel.colorChange(colorR, colorG, colorB);
				panelColorChoice.setBackground(color4);
			}
		});
		btnColor4.setBounds(129, 11, 23, 23);
		getContentPane().add(btnColor4);
		
		JButton btnColor5 = new JButton("");
		btnColor5.setForeground(Color.BLACK);
		btnColor5.setBackground(color5);
		btnColor5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int colorR = color5.getRed();
				int colorG = color5.getGreen();
				int colorB = color5.getBlue();
				ClayIllustratorPanel.colorChange(colorR, colorG, colorB);
				panelColorChoice.setBackground(color5);
			}
		});
		btnColor5.setBounds(151, 11, 23, 23);
		getContentPane().add(btnColor5);
		
		JButton btnColor6 = new JButton("");
		btnColor6.setForeground(Color.BLACK);
		btnColor6.setBackground(color6);
		btnColor6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int colorR = color6.getRed();
				int colorG = color6.getGreen();
				int colorB = color6.getBlue();
				ClayIllustratorPanel.colorChange(colorR, colorG, colorB);
				panelColorChoice.setBackground(color6);
			}
		});
		btnColor6.setBounds(63, 32, 23, 23);
		getContentPane().add(btnColor6);
		
		JButton btnColor7 = new JButton("");
		btnColor7.setForeground(Color.BLACK);
		btnColor7.setBackground(color7);
		btnColor7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int colorR = color7.getRed();
				int colorG = color7.getGreen();
				int colorB = color7.getBlue();
				ClayIllustratorPanel.colorChange(colorR, colorG, colorB);
				panelColorChoice.setBackground(color7);
			}
		});
		btnColor7.setBounds(85, 32, 23, 23);
		getContentPane().add(btnColor7);
		
		JButton btnColor8 = new JButton("");
		btnColor8.setForeground(Color.BLACK);
		btnColor8.setBackground(color8);
		btnColor8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int colorR = color8.getRed();
				int colorG = color8.getGreen();
				int colorB = color8.getBlue();
				ClayIllustratorPanel.colorChange(colorR, colorG, colorB);
				panelColorChoice.setBackground(color8);
			}
		});
		btnColor8.setBounds(107, 32, 23, 23);
		getContentPane().add(btnColor8);
		
		JButton btnColor9 = new JButton("");
		btnColor9.setForeground(Color.BLACK);
		btnColor9.setBackground(color9);
		btnColor9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int colorR = color9.getRed();
				int colorG = color9.getGreen();
				int colorB = color9.getBlue();
				ClayIllustratorPanel.colorChange(colorR, colorG, colorB);
				panelColorChoice.setBackground(color9);
			}
		});
		btnColor9.setBounds(129, 32, 23, 23);
		getContentPane().add(btnColor9);
		
		JButton btnColor10 = new JButton("");
		btnColor10.setForeground(Color.BLACK);
		btnColor10.setBackground(color10);
		btnColor10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int colorR = color10.getRed();
				int colorG = color10.getGreen();
				int colorB = color10.getBlue();
				ClayIllustratorPanel.colorChange(colorR, colorG, colorB);
				panelColorChoice.setBackground(color10);
			}
		});
		btnColor10.setBounds(151, 32, 23, 23);
		getContentPane().add(btnColor10);
		
		// generate the canvas (aka panel)
		JPanel panel = new ClayIllustratorPanel();
		panel.setBounds(10, 63, 590, 357);
		getContentPane().add(panel);
		
		JSlider sldrBlobSize = new JSlider();
		sldrBlobSize.setPaintLabels(true);
		sldrBlobSize.setToolTipText("Change size of clay");
		sldrBlobSize.setMaximum(160);
		sldrBlobSize.setMinimum(30);
		sldrBlobSize.setValue(40);
		sldrBlobSize.setBounds(183, 32, 100, 23);
		getContentPane().add(sldrBlobSize);
		
		JLabel lblSize = new JLabel();
		lblSize.setText("Size: " + sldrBlobSize.getValue());
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setBounds(184, 11, 99, 14);
		getContentPane().add(lblSize);
		sldrBlobSize.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
					int newSize = sldrBlobSize.getValue();
					ClayIllustratorPanel.sizeChange(newSize);
					System.out.println(newSize);
					lblSize.setText("Size: " + sldrBlobSize.getValue());
			}
		});
	}

	public static void main(String args[]) {
		ClayIllustrator window = new ClayIllustrator();
		window.setSize(new Dimension(700, 500));
		window.setVisible(true);
	}	
}