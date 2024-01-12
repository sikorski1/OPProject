package projekt.Logic;

import java.util.ArrayList;

import static projekt.Gui.CreateAndShowGui.demoLogger;

public class BestRatesPurchase {
    static ArrayList<String> bestRatesPur;
    public static ArrayList<String> bestRatesValues(String[][] tableExchange, String[][] tableBaksy, String[][] tableGrosz) {
        String[][] resultTable = new String[Math.max(tableExchange.length,
                Math.max(tableBaksy.length, tableGrosz.length))][3];
        ArrayList<String> exchangeCurrencies = new ArrayList<String>();
        ArrayList<String> baksyCurrencies = new ArrayList<String>();
        ArrayList<String> groszCurrencies = new ArrayList<String>();
        bestRatesPur = new ArrayList<String>();

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
                //resultTable[i][1] = null;
                try {
                    resultTable[i][1] = String.format("%.4f", Math.max(
                            Double.parseDouble(tableBaksy[baksyCurrencies.indexOf(currency)][1].replace(",", ".")),
                            Math.max(
                                    Double.parseDouble(
                                            tableExchange[exchangeCurrencies.indexOf(currency)][1].replace(",", ".")),
                                    Double.parseDouble(
                                            tableGrosz[groszCurrencies.indexOf(currency)][1].replace(",", ".")))));
                    System.out
                            .println(resultTable[i][1].equals(tableExchange[exchangeCurrencies.indexOf(currency)][1]));
                    if (resultTable[i][1].equals(tableExchange[exchangeCurrencies.indexOf(currency)][1]) && resultTable[i][1].equals(tableBaksy[baksyCurrencies.indexOf(currency)][1])  ) {
                        bestRatesPur.add("Kantor Exchange i Kantor Baksy");
                    }
                    else if (resultTable[i][1].equals(tableExchange[exchangeCurrencies.indexOf(currency)][1]) && resultTable[i][1].equals(tableGrosz[groszCurrencies.indexOf(currency)][1])) {
                        bestRatesPur.add("Kantor Exchange i Kantor Grosz");
                    }
                    else if (resultTable[i][1].equals(tableGrosz[groszCurrencies.indexOf(currency)][1]) && resultTable[i][1].equals(tableBaksy[baksyCurrencies.indexOf(currency)][1])) {
                        bestRatesPur.add("Kantor Baksy i Kantor Grosz");
                    }
                    else if (resultTable[i][1].equals(tableExchange[exchangeCurrencies.indexOf(currency)][1])) {
                        bestRatesPur.add("Kantor Exchange");
                    } else if (resultTable[i][1].equals(tableBaksy[baksyCurrencies.indexOf(currency)][1])) {
                        bestRatesPur.add("Kantor Baksy");
                    } else {
                        bestRatesPur.add("Kantor Grosz");
                    }

                } catch (Exception e) {
                    resultTable[i][1] = "";
                    demoLogger.warn("No data in " + resultTable[i][0]);
                    bestRatesPur.add("No data");
                }
            } else {
                if (exchangeCurrencies.contains(currency)
                        && !tableExchange[exchangeCurrencies.indexOf(currency)][1].equals("")) {
                    resultTable[i][0] = currency;
                    //resultTable[i][1] = null;
                    try {
                        resultTable[i][1] = String.format("%.4f", Math.max(
                                Double.parseDouble(
                                        tableExchange[exchangeCurrencies.indexOf(currency)][1].replace(",", ".")),
                                Double.parseDouble(
                                        tableBaksy[baksyCurrencies.indexOf(currency)][1].replace(",", "."))));
                        if (resultTable[i][1].equals(tableExchange[exchangeCurrencies.indexOf(currency)][1]) && resultTable[i][1].equals(tableBaksy[baksyCurrencies.indexOf(currency)][1])  ) {
                            bestRatesPur.add("Kantor Exchange i Kantor Baksy");
                        }
                        else if (resultTable[i][1].equals(tableExchange[exchangeCurrencies.indexOf(currency)][1])) {
                            bestRatesPur.add("Kantor Exchange");
                        } else {
                            bestRatesPur.add("Kantor Baksy");
                        }
                    } catch (Exception e) {
                        resultTable[i][1] = "";
                        demoLogger.warn("No data in " + resultTable[i][0]);
                        bestRatesPur.add("No data");
                    }
                } else if (groszCurrencies.contains(currency)
                        && !tableGrosz[groszCurrencies.indexOf(currency)][1].equals("")) {
                    resultTable[i][0] = currency;
                    //resultTable[i][1] = null;
                    try {
                        resultTable[i][1] = String.format("%.4f",
                                Math.max(
                                        Double.parseDouble(
                                                tableGrosz[groszCurrencies.indexOf(currency)][1].replace(",", ".")),
                                        Double.parseDouble(
                                                tableBaksy[baksyCurrencies.indexOf(currency)][1].replace(",", "."))));
                        if (resultTable[i][1].equals(tableGrosz[groszCurrencies.indexOf(currency)][1]) && resultTable[i][1].equals(tableBaksy[baksyCurrencies.indexOf(currency)][1])) {
                            bestRatesPur.add("Kantor Baksy i Kantor Grosz");
                        }
                        else if (resultTable[i][1].equals(tableGrosz[groszCurrencies.indexOf(currency)][1])) {
                            bestRatesPur.add("Kantor Grosz");
                        } else {
                            bestRatesPur.add("Kantor Baksy");
                        }
                    } catch (Exception e) {
                        resultTable[i][1] = "";
                        demoLogger.warn("No data in " + resultTable[i][0]);
                        bestRatesPur.add("No data");
                    }
                } else {
                    resultTable[i][0] = currency;
                    //resultTable[i][1] = null;
                    resultTable[i][1] = tableBaksy[baksyCurrencies.indexOf(currency)][2];
                    bestRatesPur.add("Kantor Baksy");
                }
            }
            i++;
        }
        return bestRatesPur;
    }
}
