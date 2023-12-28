package projekt;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Exchange {
	public static String[][] getData() {
		String[][] data = null;
		String url = "https://www.kantor-exchange.pl/kursy-walut-krakow/";
		int j = 0;
		try {
			Document document = Jsoup.connect(url).get();
			Elements selectedTags = document.select(".waluty-grid > .col > .card");
			String dataTable[][] = new String[selectedTags.size()][3];
			for (Element tag :selectedTags) {
				for (int i = 0; i<3; i++) {
					if (i == 0) {
						dataTable[j][i] = tag.select(".card-header > h2").text().replace("100", "");
					}
					
					else if (i == 1) {
						if (!tag.select(".card-body > .card-body-desc > .card-body-price > h5").text().replace("PLN", "").equals("")) {
						double convertedData = Double.parseDouble(tag.select(".card-body > .card-body-desc > .card-body-price > h5").text().replace("PLN", ""));
						dataTable[j][i] = String.format("%.4f", convertedData/100);
						}
						else {
							dataTable[j][i] = null;
						}
					}
					
					else {
						if (!tag.select(".card-body > .card-body-items > .card-body-change > h5").text().replace("PLN", "").equals("")) {
							double convertedData = Double.parseDouble(tag.select(".card-body > .card-body-items > .card-body-change > h5").text().replace("PLN", ""));
							dataTable[j][i] = String.format("%.4f", convertedData/100);
							
							
						}
						else {
							dataTable[j][i] = null;
						}
					}
				}
				j++;
			}
			data = dataTable;
		} 
		catch(Exception ex) {
			ex.printStackTrace();
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
