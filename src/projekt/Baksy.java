package projekt;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Baksy {
	public static String[][] getData() {
		String[][] data = null;
		String url = "https://www.baksy.pl/kurs-walut";
		int j = 0;
		try {
			Document document = Jsoup.connect(url).get();
			Elements selectedTags = document.select(".rate-table > tbody > tr");
			String dataTable[][] = new String[selectedTags.size()][3];
			for (Element tag :selectedTags) {
				for (int i = 0; i<3; i++) {
					if (i == 0) {
						dataTable[j][i] = tag.select("td").first().text();					
					}
					
					else if (i == 1) {
						if (!tag.select(".price").first().text().equals("")) {
							double convertedData = Double.parseDouble(tag.select(".price").first().text());
							dataTable[j][i] = String.format("%.4f", convertedData);
						}
						else {
							dataTable[j][i] = null;
						}
					}
					
					else {
						if (!tag.select(".price").get(1).text().equals("")) {
							double convertedData = Double.parseDouble(tag.select(".price").get(1).text());
							dataTable[j][i] = String.format("%.4f", convertedData);	
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
		String data[][] = Baksy.getData();
		for (int i = 0; i<data.length; i++) {
			for  (int j = 0; j<3; j++) {
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
	}
}