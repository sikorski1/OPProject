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
			Elements selectedDivs = document.select(".waluty-grid > .col > .card");
			String dataTable[][] = new String[selectedDivs.size()][3];
			for (Element div :selectedDivs) {
				for (int i = 0; i<3; i++) {
					if (i == 0) {
						dataTable[j][i] = div.select(".card-header > h2").text().replace("100", "");
					}
					
					else if (i == 1) {
						if (div.select(".card-body > .card-body-desc > .card-body-price > h5").text().replace("PLN", "") != "") {
						double convertedData = Double.parseDouble(div.select(".card-body > .card-body-desc > .card-body-price > h5").text().replace("PLN", ""));
						dataTable[j][i] = Double.toString(convertedData/100);
						}
						else {
							dataTable[j][i] = null;
						}
					}
					
					else {
						if (div.select(".card-body > .card-body-desc > .card-body-price > h5").text().replace("PLN", "") != "") {
							double convertedData = Double.parseDouble(div.select(".card-body > .card-body-desc > .card-body-price > h5").text().replace("PLN", ""))/100;
							dataTable[j][i] = Double.toString(convertedData);
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
