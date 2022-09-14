package myjavaproject;

import java.util.ArrayList;
import java.util.List;

public class Testcase_3 {

	static Node root = new Node(null);

	public static void main(String[] args) throws Exception {

		// @formatter:off
		List<String> lines = new ArrayList<String>(List.of(
				"1186	Canada [CAN]	FIXED",
				"1264583	Anguilla [AIA]	FIXED", 
				"1548	Canada [CAN]	FIXED", 
				"1876216	Jamaica [JAM]	MOBILE",
				"2017	Egypt [EGY]	MOBILE", 
				"212	Morocco [MAR]	FIXED", 
				"21210	Morocco [MAR]	MOBILE",
				"21211	Morocco [MAR]	MOBILE", 
				"21212	Morocco [MAR]	MOBILE"));
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
		}
	}
}
