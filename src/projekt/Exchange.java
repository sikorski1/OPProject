package projekt;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Exchange {
	static Logger demoLogger = LogManager.getLogger(Exchange.class.getName());
	public static String[][] getData() {
		String[][] data = null;
		String url = "https://www.kantor-exchange.pl/kursy-walut-krakow/";
		int j = 0;
		try {
			Document document = Jsoup.connect(url).get();
			demoLogger.info("The website has been downloaded");
			Elements selectedTags = document.select(".waluty-grid > .col > .card");
			String dataTable[][] = new String[selectedTags.size()][3];
			for (Element tag :selectedTags) {
				for (int i = 0; i<3; i++) {
					if (i == 0) {
						dataTable[j][i] = tag.select(".card-header > h2").text().replace("100 ", "");
					}
					
					else if (i == 1) {
						if (!tag.select(".card-body > .card-body-desc > .card-body-price > h5").text().replace("PLN", "").equals("")) {
						double convertedData = Double.parseDouble(tag.select(".card-body > .card-body-desc > .card-body-price > h5").text().replace("PLN", ""));
						dataTable[j][i] = String.format("%.4f", convertedData/100);
						}
						else {
							dataTable[j][i] = "";
							demoLogger.warn("No data in " + dataTable[j][0]);
						}
					}
					
					else {
						if (!tag.select(".card-body > .card-body-items > .card-body-change > h5").text().replace("PLN", "").equals("")) {
							double convertedData = Double.parseDouble(tag.select(".card-body > .card-body-items > .card-body-change > h5").text().replace("PLN", ""));
							dataTable[j][i] = String.format("%.4f", convertedData/100);
							
							
						}
						else {
							dataTable[j][i] = "";
							demoLogger.warn("No data in " + dataTable[j][0]);
						}
					}
				}
				j++;
			}
			data = dataTable;
			Arrays.sort(data, Comparator.comparing(arr -> arr[0]));
			demoLogger.info("The data has been downloaded and sorted");
		} 
		catch (Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String stackTrace = sw.toString();
			demoLogger.error(stackTrace);
		}
		return data;
	}
	public static void main(String args[]) {
		String data[][] = Exchange.getData();
		for (int i = 0; i<data.length; i++) {
			for  (int j = 0; j<3; j++) {
				System.out.print(data[i][j]);
			}
			System.out.println();
			
		}
	}
}
