package projekt;

import java.awt.*;
import javax.swing.*;

public class Gui {
	static String image1 = "piggy_logo.png";
	static String[] currencyExchanges = {"Kantor Exchagne", "Kantor Baksy", "Kantor Grosz"};
	static String[] columnNames = {"Currency", "Purchase", "Sale"};
	static Color[] colors = {Color.red, Color.green, Color.blue};
	static String[][] tableData = {
			{"EUR", "4.35", "4.33"},
			{"USD", "4.12", "4.10"},
			{"GBP", "4.93", "4.95"}

	};
	static int width = 1500;
	static int height = 800;
	public static void createAndShowGUI() {
		int numOfCrrExc = currencyExchanges.length;
		int panelWidth = width/numOfCrrExc;

		JFrame frame = new JFrame();
		frame.setTitle("Kursy walut");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setLayout(null);

		int i = 0;
		int x = 0;
		for (String crrExc : currencyExchanges) {
			JPanel panel = new JPanel();
			JTextField textField = new JTextField(crrExc);
			textField.setEditable(false);
			textField.setBackground(Color.white);
			textField.setBounds(x, 1, panelWidth, 50);
			frame.add(textField, BorderLayout.NORTH);
			panel.setBackground(colors[i]);
			panel.setBounds(x, 51, panelWidth, height - 50);
			panel.setLayout(new BorderLayout());
			JTable table = new JTable(tableData, columnNames);
			table.setEnabled(false);
			JScrollPane scrollPane = new JScrollPane(table);
			panel.add(scrollPane, BorderLayout.NORTH);
			frame.add(panel);
			i += 1;
			x += panelWidth;
		}

		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() { createAndShowGUI(); }
		});
	}
}
