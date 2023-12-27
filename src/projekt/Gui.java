package projekt;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Gui {
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame();
		frame.setTitle("Kursy walut");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500, 800);
		frame.setVisible(true);
		frame.setLayout(null);
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
		
		String columnNames[] = {"Currency", "Purchase", "Sale"};
		
		JTable exchangeTable = new JTable(tableData, columnNames);
		exchangeTable.setEnabled(false);
		JScrollPane exchangeTableSP = new JScrollPane(exchangeTable);
        exchangePanel.add(exchangeTableSP, BorderLayout.NORTH);
        
		JTable baksyTable = new JTable(tableData, columnNames);
		baksyTable.setEnabled(false);
		JScrollPane baksyTableSP = new JScrollPane(baksyTable);
        baksyPanel.add(baksyTableSP, BorderLayout.NORTH);
        
		JTable groszTable = new JTable(tableData, columnNames);
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

}
