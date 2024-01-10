package projekt;

import java.awt.*;
<<<<<<< HEAD
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
=======
import java.util.ArrayList;

import javax.swing.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gui {
	static Logger demoLogger = LogManager.getLogger(Exchange.class.getName());
	static String image1 = "piggy_logo.png";
	static String[] currencyExchanges = {"Kantor Exchagne", "Kantor Baksy", "Kantor Grosz", "Najlepsze Kursy"};
	static String[] columnNames = {"Currency", "Purchase", "Sale"};
	static Color[] colors = {Color.red, Color.green, Color.blue, Color.cyan};
	static String[][] tableExchange = Exchange.getData();
	static String[][] tableBaksy = Baksy.getData();
	static String[][] tableGrosz = Grosz.getData();
	static String[][] bestExchangeRates = bestRates(tableExchange,tableBaksy,tableGrosz);
	static String[][][] dataTable = {tableExchange, tableBaksy, tableGrosz, bestExchangeRates};
	static int width = 1500;
	static int height = 800;
	static int gap = 10;
	static ArrayList<String> bestSalesTable;
>>>>>>> branczyk
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

=======
		int i = 0;
		int x = 0;
		for (String crrExc : currencyExchanges) {
			JPanel panel = new JPanel();
			panel.setBackground(colors[i]);
			panel.setBounds(x, 51, panelWidth, height - 50);
			panel.setLayout(new CardLayout(gap, gap));

>>>>>>> branczyk
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

<<<<<<< HEAD
			JTable table = new JTable(tableData, columnNames);
=======
			JTable table = new JTable(dataTable[i], columnNames);
>>>>>>> branczyk
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

<<<<<<< HEAD
=======
	public static String[][] bestRates(String[][] tableExchange, String[][] tableBaksy, String[][] tableGrosz) {
		String[][] resultTable = new String[Math.max(tableExchange.length,
				Math.max(tableBaksy.length, tableGrosz.length))][3];
		ArrayList<String> exchangeCurrencies = new ArrayList<String>();
		ArrayList<String> baksyCurrencies = new ArrayList<String>();
		ArrayList<String> groszCurrencies = new ArrayList<String>();
		bestSalesTable = new ArrayList<String>();
		
		for (int i = 0; i < tableBaksy.length; i++) {
			baksyCurrencies.add(tableBaksy[i][0]);
			if (i < tableExchange.length) {
				exchangeCurrencies.add(tableExchange[i][0]);
			}
			if (i < tableGrosz.length) {
				groszCurrencies.add(tableGrosz[i][0]);
			}
		}
		System.out.println(baksyCurrencies);
		System.out.println(exchangeCurrencies);
		System.out.println(groszCurrencies);
		int i = 0;
		for (String currency : baksyCurrencies) {
			if (exchangeCurrencies.contains(currency) && groszCurrencies.contains(currency) && (!tableExchange[exchangeCurrencies.indexOf(currency)][2].equals("") && !tableGrosz[groszCurrencies.indexOf(currency)][2].equals(""))) {
				resultTable[i][0] = currency;
				resultTable[i][1] = null;
				try {
					resultTable[i][2] = String.format("%.4f", Math.min(
							Double.parseDouble(tableBaksy[baksyCurrencies.indexOf(currency)][2].replace(",", ".")),
							Math.min(
									Double.parseDouble(
											tableExchange[exchangeCurrencies.indexOf(currency)][2].replace(",", ".")),
									Double.parseDouble(
											tableGrosz[groszCurrencies.indexOf(currency)][2].replace(",", ".")))));
					System.out.println(resultTable[i][2].equals(tableExchange[exchangeCurrencies.indexOf(currency)][2]));
					if (resultTable[i][2].equals(tableExchange[exchangeCurrencies.indexOf(currency)][2])) {
						bestSalesTable.add("Kantor Exchange");
					}
					else if (resultTable[i][2].equals(tableBaksy[baksyCurrencies.indexOf(currency)][2])) {
						bestSalesTable.add("Kantor Baksy");
					}
					else {
						bestSalesTable.add("Kantor Grosz");
					}
					// whatIsIt(resultTable[i][2])
					// xddd ale moloch, ogolnie sprawdzana jest tu najmniejsza wartosc Sell, ale
					// trzeba konwertowac dane xdddddddddd
				} catch (Exception e) {
					resultTable[i][2] = "";
					demoLogger.warn("No data in " + resultTable[i][0]);
					bestSalesTable.add("No data");
				}
			} else {
				if (exchangeCurrencies.contains(currency) && !tableExchange[exchangeCurrencies.indexOf(currency)][2].equals("")) {
					resultTable[i][0] = currency;
					resultTable[i][1] = null;
					try {
						resultTable[i][2] = String.format("%.4f", Math.min(
								Double.parseDouble(
										tableExchange[exchangeCurrencies.indexOf(currency)][2].replace(",", ".")),
								Double.parseDouble(
										tableBaksy[baksyCurrencies.indexOf(currency)][2].replace(",", "."))));
						if (resultTable[i][2].equals(tableExchange[exchangeCurrencies.indexOf(currency)][2])) {
							bestSalesTable.add("Kantor Exchange");
						}
						else {
							bestSalesTable.add("Kantor Baksy");
						}
					} catch (Exception e) {
						resultTable[i][2] = "";
						demoLogger.warn("No data in " + resultTable[i][0]);
						bestSalesTable.add("No data");
					}
				} else if (groszCurrencies.contains(currency) && !tableGrosz[groszCurrencies.indexOf(currency)][2].equals("")) {
					resultTable[i][0] = currency;
					resultTable[i][1] = null;
					try {
						resultTable[i][2] = String.format("%.4f",
								Math.min(
										Double.parseDouble(
												tableGrosz[groszCurrencies.indexOf(currency)][2].replace(",", ".")),
										Double.parseDouble(
												tableBaksy[baksyCurrencies.indexOf(currency)][2].replace(",", "."))));
						if (resultTable[i][2].equals(tableGrosz[groszCurrencies.indexOf(currency)][2])) {
							bestSalesTable.add("Kantor Grosz");
						}
						else {
							bestSalesTable.add("Kantor Baksy");
						}
					} catch (Exception e) {
						resultTable[i][2] = "";
						demoLogger.warn("No data in " + resultTable[i][0]);
						bestSalesTable.add("No data");
					}
				} else {
					resultTable[i][0] = currency;
					resultTable[i][1] = null;
					resultTable[i][2] = tableBaksy[baksyCurrencies.indexOf(currency)][2];
					bestSalesTable.add("Kantor Baksy");
				}
			}
			i++;
		}
		System.out.println(bestSalesTable);
		System.out.println(bestSalesTable.size());
		return resultTable;
	}
>>>>>>> branczyk
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() { createAndShowGUI(); }
		});
	}
}
