package com.helpers

import com.kms.katalon.core.annotation.Keyword

public class Tab2Helpers {
	@Keyword
	def String convert(String string) {
		return "('" + string.replaceAll(",", "','") + "')";
	}

	@Keyword
	def countItems(LinkedList<String[]> array) {
		return array.size();
	}

	@Keyword
	def getUncollectedTotal(LinkedList<String[]> array) {
		int total = 0;
		for (int i = 0; i < array.size(); i++) {
			total += Integer.parseInt(array.get(i).get(7));
		}
		return total;
	}

	@Keyword
	def getOverpaymentTotal(LinkedList<String[]> array) {
		int total = 0;
		for (int i = 0; i < array.size(); i++) {
			total += Integer.parseInt(array.get(i).get(8));
		}
		return total;
	}

	@Keyword
	def getAmountOfMoneyTotal(LinkedList<String[]> array) {
		int total = 0;
		for (int i = 0; i < array.size(); i++) {
			total += Integer.parseInt(array.get(i).get(9));
		}
		return total;
	}
}
