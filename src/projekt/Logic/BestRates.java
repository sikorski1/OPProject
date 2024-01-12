package projekt.Logic;

import java.util.ArrayList;

import static projekt.Gui.CreateAndShowGui.demoLogger;

public class BestRates {
    static ArrayList<String> bestSalesTable;
    public static ArrayList<String> bestRates(String[][] tableExchange, String[][] tableBaksy, String[][] tableGrosz) {
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
            if (exchangeCurrencies.contains(currency) && groszCurrencies.contains(currency)
                    && (!tableExchange[exchangeCurrencies.indexOf(currency)][2].equals("")
                    && !tableGrosz[groszCurrencies.indexOf(currency)][2].equals(""))) {
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
                    System.out
                            .println(resultTable[i][2].equals(tableExchange[exchangeCurrencies.indexOf(currency)][2]));
                    if (resultTable[i][2].equals(tableExchange[exchangeCurrencies.indexOf(currency)][2]) && resultTable[i][2].equals(tableBaksy[baksyCurrencies.indexOf(currency)][2])  ) {
                    	bestSalesTable.add("Kantor Exchange i Kantor Baksy");
                    }
                    else if (resultTable[i][2].equals(tableExchange[exchangeCurrencies.indexOf(currency)][2]) && resultTable[i][2].equals(tableGrosz[groszCurrencies.indexOf(currency)][2])) {
                    	bestSalesTable.add("Kantor Exchange i Kantor Grosz");
                    }
                    else if (resultTable[i][2].equals(tableGrosz[groszCurrencies.indexOf(currency)][2]) && resultTable[i][2].equals(tableBaksy[baksyCurrencies.indexOf(currency)][2])) {
                    	bestSalesTable.add("Kantor Baksy i Kantor Grosz");
                    }
                     else if (resultTable[i][2].equals(tableExchange[exchangeCurrencies.indexOf(currency)][2])) {
                        bestSalesTable.add("Kantor Exchange");
                    } else if (resultTable[i][2].equals(tableBaksy[baksyCurrencies.indexOf(currency)][2])) {
                        bestSalesTable.add("Kantor Baksy");
                    } else {
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
                if (exchangeCurrencies.contains(currency)
                        && !tableExchange[exchangeCurrencies.indexOf(currency)][2].equals("")) {
                    resultTable[i][0] = currency;
                    resultTable[i][1] = null;
                    try {
                        resultTable[i][2] = String.format("%.4f", Math.min(
                                Double.parseDouble(
                                        tableExchange[exchangeCurrencies.indexOf(currency)][2].replace(",", ".")),
                                Double.parseDouble(
                                        tableBaksy[baksyCurrencies.indexOf(currency)][2].replace(",", "."))));
                        if (resultTable[i][2].equals(tableExchange[exchangeCurrencies.indexOf(currency)][2]) && resultTable[i][2].equals(tableBaksy[baksyCurrencies.indexOf(currency)][2])  ) {
                        	bestSalesTable.add("Kantor Exchange i Kantor Baksy");
                        	}
                        else if (resultTable[i][2].equals(tableExchange[exchangeCurrencies.indexOf(currency)][2])) {
                            bestSalesTable.add("Kantor Exchange");
                        } else {
                            bestSalesTable.add("Kantor Baksy");
                        }
                    } catch (Exception e) {
                        resultTable[i][2] = "";
                        demoLogger.warn("No data in " + resultTable[i][0]);
                        bestSalesTable.add("No data");
                    }
                } else if (groszCurrencies.contains(currency)
                        && !tableGrosz[groszCurrencies.indexOf(currency)][2].equals("")) {
                    resultTable[i][0] = currency;
                    resultTable[i][1] = null;
                    try {
                        resultTable[i][2] = String.format("%.4f",
                                Math.min(
                                        Double.parseDouble(
                                                tableGrosz[groszCurrencies.indexOf(currency)][2].replace(",", ".")),
                                        Double.parseDouble(
                                                tableBaksy[baksyCurrencies.indexOf(currency)][2].replace(",", "."))));
                         if (resultTable[i][2].equals(tableGrosz[groszCurrencies.indexOf(currency)][2]) && resultTable[i][2].equals(tableBaksy[baksyCurrencies.indexOf(currency)][2])) {
                        	bestSalesTable.add("Kantor Baksy i Kantor Grosz"); 
                        	}
                        else if (resultTable[i][2].equals(tableGrosz[groszCurrencies.indexOf(currency)][2])) {
                            bestSalesTable.add("Kantor Grosz");
                        } else {
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
        return bestSalesTable;
    }
}
