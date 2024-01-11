package projekt.Gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import projekt.Data.Baksy;
import projekt.Data.Exchange;
import projekt.Data.Grosz;
import projekt.Logic.BestRates;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static projekt.Logic.BestRatesValues.bestRatesValues;


public class CreateAndShowGui {

    public static Logger demoLogger = LogManager.getLogger(Exchange.class.getName());
    static String image1 = "piggy_logo.png";
    static String[] currencyExchanges = { "Kantor Exchagne", "Kantor Baksy", "Kantor Grosz"};
    static String[] columnNames = { "Currency", "Purchase", "Sale" };
    static Color[] colors = { Color.red, Color.green, Color.blue, Color.cyan };
    static String[][] tableExchange = Exchange.getData();
    static String[][] tableBaksy = Baksy.getData();
    static String[][] tableGrosz = Grosz.getData();
    static String[][] bestExchangeRates = bestRatesValues(tableExchange, tableBaksy, tableGrosz);
    static String[][][] dataTable = { tableExchange, tableBaksy, tableGrosz, bestExchangeRates };
    static int width = 1500;
    static int height = 800;
    static int gap = 10;
    static ArrayList<String> bestSalesTable = BestRates.bestRates(tableExchange, tableBaksy, tableGrosz); // <---- nazwy kantorow według najlepszych cen (Sell)

    public static void createAndShowGUI() {
        int numOfCrrExc = (currencyExchanges.length + 1);
        int panelWidth = width / numOfCrrExc;

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
            textField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
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
        JPanel panel = new CustomPanel("Najlepsze kursy", colors[3], dataTable, columnNames, bestSalesTable, x, panelWidth, height, gap, frame);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
