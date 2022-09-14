package myjavaproject;

import java.util.List;

public class Testcase_4 {

	static Node root = new Node(null);

	public static void main(String[] args) throws Exception {

		System.out.println("Loading data ...");
		List<Item> items = Item.ReadData("Dial-plan-extract.txt");
		for (Item item : items) {
			root.put(item.getPrefix(), item.getData());
		}

		System.out.println("Looking up numbers ...");
		for (Item item : items) {
			String number = item.getPrefix() + "999";
			Data data = root.get(number, null);

			System.out.format("    %s : %s\n", number, data);
		}
	}
}
