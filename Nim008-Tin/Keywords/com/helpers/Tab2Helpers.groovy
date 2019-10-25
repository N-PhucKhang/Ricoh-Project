package com.helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

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
