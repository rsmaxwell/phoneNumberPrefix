package myjavaproject;

import java.util.HashMap;
import java.util.Map;

public class Node {

	private Data data;
	private Map<Character, Node> children = new HashMap<Character, Node>();

	public Node(Data data) {
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void put(String number, Data data) throws Exception {

		if (number.length() <= 0) {
			throw new Exception("number cannot be zero length");
		}

		Character first = number.charAt(0);
		Node child = children.get(first);

		if (child == null) {
			child = new Node(null);
			children.put(first, child);
		}

		if (number.length() > 1) {
			String theRest = number.substring(1);
			child.put(theRest, data);
		} else {
			child.data = data;
		}
	}

	public Data get(String number, Data datavalue) throws Exception {

		if (number.length() <= 0) {
			return datavalue;
		}

		Character first = number.charAt(0);
		Node child = children.get(first);

		if (child == null) {
			return datavalue;
		}

		String theRest = number.substring(1);

		Data bestvalue = datavalue;
		if (child.data != null) {
			bestvalue = child.data;
		}

		return child.get(theRest, bestvalue);
	}

	@Override
	public String toString() {
		return String.format("data: %s", data);
	}

	public void output(String indent) {
		System.out.printf("%s%s\n", indent, data);
		for (Character ch : children.keySet()) {
			Node child = children.get(ch);
			System.out.printf("%s    %c: ", indent, ch);
			child.output(indent + "    ");
		}
	}
}
