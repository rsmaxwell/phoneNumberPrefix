package myjavaproject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Item {

	private String prefix;
	private Data data;

	public Item(String number, Data data) {
		this.prefix = number;
		this.data = data;
	}

	public static Item MakeItem(String line) throws Exception {
		String[] words = line.split("\\t");

		if (words.length != 3) {
			throw new Exception("unexpected data: " + line);
		}

		Data data = new Data(words[1], words[2]);

		return new Item(words[0], data);
	}

	public static List<Item> ReadData(String filename) throws Exception {

		InputStream stream = Item.class.getResourceAsStream(filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

		List<Item> result = new ArrayList<Item>();

		for (String line; (line = reader.readLine()) != null;) {

			if (line.startsWith("NUMBER PREFIX")) {
				continue;
			}

			Item item = Item.MakeItem(line);
			result.add(item);
		}

		return result;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

}
