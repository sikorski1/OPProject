package projekt.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CustomPanel extends JPanel {

    public CustomPanel(String title, Color backgroundColor, Object[][] dataTable, String[] columnNames,
                       ArrayList<String> bestSalesTable, int x, int panelWidth, int height, int gap, JFrame frame, ArrayList<String> bestRatesPur) {
        this.setBackground(backgroundColor);
        this.setBounds(x, 51, panelWidth, height - 50);
        this.setLayout(new CardLayout(gap, gap));

        JTextField textField = createTextField(title, x, panelWidth);
        frame.add(textField, BorderLayout.NORTH);

        JTable table = createTable(dataTable[3], columnNames, bestSalesTable, bestRatesPur);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.NORTH);

        frame.add(this);
        x += panelWidth;
    }

    private JTextField createTextField(String text, int x, int panelWidth) {
        JTextField textField = new JTextField(text);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setBackground(Color.lightGray);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createLineBorder(Color.BLACK, 2)));
        textField.setBounds(x, 1, panelWidth, 50);
        return textField;
    }

    private JTable createTable(Object[] data, String[] columnNames, ArrayList<String> bestSalesTable, ArrayList<String> bestRatesPur) {
        JTable table = new JTable((Object[][]) data, columnNames);
        table.setEnabled(false);
        table.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                int row = table.rowAtPoint(p);
                int col = table.columnAtPoint(p);
                if (row >= 0 && col == 2) {
                    String value = bestSalesTable.get(row);
                    table.setToolTipText(value);
                } else if (row >= 0 && col == 1) {
                    String value2 = bestRatesPur.get(row);
                    table.setToolTipText(value2);
                } else {
                    table.setToolTipText(null);
                }

            }
        });
        return table;
    }
}