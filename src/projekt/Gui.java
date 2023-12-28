package projekt;

import java.awt.*;
import javax.swing.*;

public class Gui {
	static String image1 = "piggy_logo.png";
	static String[] currencyExchanges = {"Kantor Exchagne", "Kantor Baksy", "Kantor Grosz", "Najlepsze kursy"};
	static String[] columnNames = {"Currency", "Purchase", "Sale"};
	static Color[] colors = {Color.red, Color.green, Color.blue, Color.cyan};
	static String[][] tableData = {
			{"EUR", "4.35", "4.33"},
			{"USD", "4.12", "4.10"},
			{"GBP", "4.93", "4.95"}
	};
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
<<<<<<< HEAD
;
		JPanel exchangePanel = new JPanel();
		exchangePanel.setBackground(Color.red);
		exchangePanel.setBounds(0, 0, 500, 800);
		exchangePanel.setLayout(new BorderLayout());
		JPanel baksyPanel = new JPanel();
		baksyPanel.setBackground(Color.green);
		baksyPanel.setBounds(500, 0, 500, 800);
		baksyPanel.setLayout(new BorderLayout());
		JPanel groszPanel = new JPanel();
		groszPanel.setBackground(Color.blue);
		groszPanel.setBounds(1000, 0, 500, 800);
		groszPanel.setLayout(new BorderLayout());
		
		
		ImageIcon image = new ImageIcon("piggy_logo.png");
		frame.setIconImage(image.getImage());
		
		
		String tableData[][] = Exchange.getData();
		String tableData2[][] = Baksy.getData();
		String tableData3[][] = Grosz.getData();
		
		String columnNames[] = {"Currency", "Purchase", "Sale"};
		
		JTable exchangeTable = new JTable(tableData, columnNames);
		exchangeTable.setEnabled(false);
		JScrollPane exchangeTableSP = new JScrollPane(exchangeTable);
        exchangePanel.add(exchangeTableSP, BorderLayout.NORTH);
        
		JTable baksyTable = new JTable(tableData2, columnNames);
		baksyTable.setEnabled(false);
		JScrollPane baksyTableSP = new JScrollPane(baksyTable);
        baksyPanel.add(baksyTableSP, BorderLayout.NORTH);
        
		JTable groszTable = new JTable(tableData3, columnNames);
		groszTable.setEnabled(false);
		JScrollPane groszTableSP = new JScrollPane(groszTable);
        groszPanel.add(groszTableSP, BorderLayout.NORTH);
        
        frame.add(exchangePanel);
        frame.add(baksyPanel);
        frame.add(groszPanel);
        
      
	}
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });        
    }
=======
		//frame.setResizable(false);
>>>>>>> origin/inny_branczyk

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
