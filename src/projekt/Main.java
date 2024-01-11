package projekt;

import static projekt.Gui.CreateAndShowGui.createAndShowGUI;

public class Main {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
