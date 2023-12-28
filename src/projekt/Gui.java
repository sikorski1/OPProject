package projekt;

import java.awt.*;
import javax.swing.*;

public class Gui {
	static String image1 = "piggy_logo.png";
	static String[] currencyExchanges = {"Kantor Exchagne", "Kantor Baksy", "Kantor Grosz"};
	static String[] columnNames = {"Currency", "Purchase", "Sale"};
	static Color[] colors = {Color.red, Color.green, Color.blue, Color.cyan};
	static String[][] tableExchange = Exchange.getData();
	static String[][] tableBaksy = Baksy.getData();
	static String[][] tableGrosz = Grosz.getData();
	static String[][][] dataTable = {tableExchange, tableBaksy, tableGrosz};
	static int width = 1500;
	static int height = 800;
	static int gap = 10;
	public static void createAndShowGUI() {
		int numOfCrrExc = currencyExchanges.length;
		int panelWidth = width/numOfCrrExc;

		JFrame frame = new JFrame();
		frame.setTitle("Kursy walut");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width + gap, height + 40);
		frame.setVisible(true);
		frame.setLayout(null);

		int i = 0;
		int x = 0;
		for (String crrExc : currencyExchanges) {
			JPanel panel = new JPanel();
			panel.setBackground(colors[i]);
			panel.setBounds(x, 51, panelWidth, height - 50);
			panel.setLayout(new CardLayout(gap, gap));

			JTextField textField = new JTextField(crrExc);
			textField.setEditable(false);
			textField.setHorizontalAlignment(JTextField.CENTER);
			textField.setFont(new Font("Arial", Font.BOLD, 20));
			textField.setBackground(Color.lightGray);
			textField.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
					BorderFactory.createLineBorder(Color.BLACK, 2)));
			textField.setBounds(x, 1, panelWidth, 50);
			frame.add(textField, BorderLayout.NORTH);

			JTable table = new JTable(dataTable[i], columnNames);
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
