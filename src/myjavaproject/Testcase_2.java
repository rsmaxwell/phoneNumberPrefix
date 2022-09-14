package myjavaproject;

import java.util.ArrayList;
import java.util.List;

public class Testcase_2 {

	static Node root = new Node(null);

	public static void main(String[] args) throws Exception {

		// @formatter:off
		List<String> lines = new ArrayList<String>(List.of(
				"1186	Canada [CAN]	FIXED"));
		// @formatter:on

		System.out.println("Loading data ...");
		for (String line : lines) {
			Item item = Item.MakeItem(line);
			root.put(item.getPrefix(), item.getData());
		}

		System.out.println("Output nodes ...");
		root.output("");

		System.out.println("Looking up numbers ...");
		for (String line : lines) {
			Item item = Item.MakeItem(line);
			String number = item.getPrefix() + "999";
			Data data = root.get(number, null);

			System.out.format("    %s : %s\n", number, data);

			return;
		}
	}
}
