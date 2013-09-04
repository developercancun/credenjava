package gafetes;
 
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.*;
import java.io.*;
 
import javax.imageio.ImageIO;
import javax.swing.*;
 
public class JFileChooserPreview {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) { }
		
		final JFrame frame = new JFrame();
		JButton button = new JButton("Open File Chooser");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				PreviewPane previewPane = new PreviewPane();
				chooser.setAccessory(previewPane);
				chooser.addPropertyChangeListener(previewPane);
				chooser.showDialog(frame, "OK");
			}
		});
		frame.getContentPane().add(button);
 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
 
}