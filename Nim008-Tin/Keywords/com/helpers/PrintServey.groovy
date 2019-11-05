package com.helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.ArrayList

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

public class PrintServey {

	def print(ArrayList<ArrayList<String>> arrayHeader, ArrayList<ArrayList<String>> arrayResult) {
		def arrayFormat = getFormatArray(arrayHeader, arrayResult);
		def stringFormat = getFormatString(arrayFormat);
		printLine(arrayFormat);
		println(sprintf(stringFormat, arrayHeader.get(0)));
		printLine(arrayFormat);
		for (int i = 0; i < arrayResult.size(); i++) {
			println(sprintf(stringFormat, arrayResult.get(i)));
		}
		printLine(arrayFormat);
	}

	def ArrayList<Integer> getFormatArray(ArrayList<ArrayList<String>> arrayHeader, ArrayList<ArrayList<String>> arrayResult) {
		def arrayFormat = [];
		for (int i = 0; i < arrayHeader.get(0).size(); i++) {
			arrayFormat.add(arrayHeader.get(0).get(i).toString().length());
		}
		for (int i = 0; i < arrayResult.size(); i++) {
			for(int j = 0; j < arrayResult.get(i).size(); j ++) {
				if(arrayResult.get(i).get(j).toString().length() > arrayFormat.get(j)) {
					arrayFormat.set(j, arrayResult.get(i).get(j).toString().length());
				}
			}
		}
		return arrayFormat;
	}

	def String getFormatString(ArrayList<Integer> arrayFormat) {
		def stringFormat = '|';
		for (int i = 0; i < arrayFormat.size(); i++) {
			stringFormat += (' %-' + arrayFormat.get(i) + 's |');
		}
		return stringFormat;
	}

	def printLine(ArrayList<Integer> arrayFormat) {
		print('+');
		for (int i = 0; i < arrayFormat.size(); i++) {
			print('-');
			for (int j = 0; j < arrayFormat.get(i); j++) {
				print('-');
			}
			print('-');
			print('+');
		}
		print('\n');

	}
}
