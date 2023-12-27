package projekt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Gui {
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame();
		frame.setTitle("Kursy walut");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1600, 800);
		frame.setVisible(true);
		
		ImageIcon image = new ImageIcon("piggy_logo.png");
		frame.setIconImage(image.getImage());
	}
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });        
    }

}
