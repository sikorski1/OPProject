package projekt.Data;

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

public class Grosz {
	static Logger demoLogger = LogManager.getLogger(Grosz.class.getName());
	public static String[][] getData() {
		String[][] data = null;
		String url = "http://www.kantorgrosz.pl/kursywalut";
		int j = 0;
		try {
			Document document = Jsoup.connect(url).get();
			demoLogger.info("The website has been downloaded");
			Elements selectedTags = document.select(".Text > table > tbody > tr");
			selectedTags.remove(0);
			String dataTable[][] = new String[selectedTags.size()][3];
			for (Element tag :selectedTags) {
				for (int i = 0; i<3; i++) {
					if (i == 0) {
						dataTable[j][i] = tag.select("td").get(2).text();			
					}
					
					else if (i == 1) {
						if (!tag.select("td").get(4).text().equals("")) {
							double convertedData = Double.parseDouble(tag.select("td").get(4).text());
							dataTable[j][i] = String.format("%.4f", convertedData/100);		
						}
						else {
							dataTable[j][i] = "";
							demoLogger.warn("No data in " + dataTable[j][0]);
						}
					}
					
					else {
						if (!tag.select("td").get(5).text().equals("")) {
							double convertedData = Double.parseDouble(tag.select("td").get(5).text());
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
		catch(Exception ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String stackTrace = sw.toString();
			demoLogger.error(stackTrace);
		}
		return data;
	}
	public static void main(String args[]) {
		String data[][] = Grosz.getData();
		for (int i = 0; i<data.length; i++) {
			for  (int j = 0; j<3; j++) {
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
	}
}