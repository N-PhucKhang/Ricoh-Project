package com.helpers
<<<<<<< HEAD
=======

>>>>>>> dcf6c7b00b4e930ef234d9410e2be4ed5a585c23
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
<<<<<<< HEAD
=======
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

>>>>>>> dcf6c7b00b4e930ef234d9410e2be4ed5a585c23
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
<<<<<<< HEAD
=======
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

>>>>>>> dcf6c7b00b4e930ef234d9410e2be4ed5a585c23
import internal.GlobalVariable

public class Tab2Helpers {
	
	PrintServey printServey = new PrintServey();

	@Keyword
	def String convert(String string) {
		return "('" + string.replaceAll(",", "','") + "')";
	}

	@Keyword
	def BigDecimal convertStringToBigDecimal(String string) {
		return new BigDecimal(string);
	}

	@Keyword
	def countItems(LinkedList<String[]> array) {
		return new BigDecimal(array.size())
	}

	@Keyword
	def getColumnTotalValue(LinkedList<String[]> array, Integer columnNo) {
		println(columnNo)
		BigDecimal total = new BigDecimal('0');
		for (int i = 0; i < array.size(); i++) {
			println(array.get(i).get(columnNo))
			total = total.add(new BigDecimal(array.get(i).get(columnNo)));
		}
		return total;
	}

	@Keyword
	def getGridTableHeaderName(String gridTable) {
		def headers = WebUI.executeJavaScript('return $("#' + gridTable +'").jqGrid("getGridParam", "colModel")', null);
		ArrayList<String> arrayHeaderNames = new ArrayList<String>();
		for (int i = 0; i < headers.size(); i++) {
			for (String key : headers.get(i).keySet()) {
				if (key == 'name') {
					arrayHeaderNames.add(headers.get(i).get(key));
				}
			}
		}
		return arrayHeaderNames;
	}

	@Keyword
	def getGridTableData(String gridTable) {
		def datas = WebUI.executeJavaScript('return $("#' + gridTable +'").jqGrid("getGridParam", "data")', null);
		LinkedList<String[]> arrayResult = new LinkedList<String[]>();
		for (int i = 0; i < datas.size(); i++) {
			ArrayList<String> arrayString = new ArrayList<String>();
			for (String key : datas.get(i).keySet()) {
				arrayString.add(datas.get(i).get(key));
			}
			arrayResult.add(arrayString);
		}
		return arrayResult;
	}

	@Keyword
	//each input array have format: [item_count, func_now_debit_total, overpayment_total, amount_of_money_total]
	def surveySumariesData(ArrayList<BigDecimal> array_summaries_detail_from_db,
			ArrayList<BigDecimal> array_summaries_from_db,
			ArrayList<BigDecimal> array_summaries_detail_from_grid_table,
			ArrayList<BigDecimal> array_summaries_from_grid_table) {
		println(' =====> INPUT');
		println(' => array summaries detail from db:');
		println('    ' + array_summaries_detail_from_db);
		println(' => array summaries from db:');
		println('    ' + array_summaries_from_db);
		println(' => array summaries detail from grid table:');
		println('    ' + array_summaries_detail_from_grid_table);
		println(' => array summaries from grid table:');
		println('    ' + array_summaries_from_grid_table);
		println(' =====> SURVEY RESULT');

		def arrayHeader = [];
		def arrayResult = [];

		arrayHeader.add(['case', 'summaries from sql detail', 'summaries from sql summaries', 'summaries from grid table detail', 'summaries from grid table summaries', 'result']);

		arrayResult.add([
			'item count',
			array_summaries_detail_from_db[0],
			array_summaries_from_db[0],
			array_summaries_detail_from_grid_table[0],
			array_summaries_from_grid_table[0],
			getResult(
			array_summaries_detail_from_db[0] == array_summaries_from_db[0]
			&& array_summaries_detail_from_db[0] == array_summaries_detail_from_grid_table[0]
			&& array_summaries_detail_from_db[0] == array_summaries_from_grid_table[0]
			)
		]);

		arrayResult.add([
			'func now debit total',
			array_summaries_detail_from_db[1],
			array_summaries_from_db[1],
			array_summaries_detail_from_grid_table[1],
			array_summaries_from_grid_table[1],
			getResult(
			array_summaries_detail_from_db[1] == array_summaries_from_db[1]
			&& array_summaries_detail_from_db[1] == array_summaries_detail_from_grid_table[1]
			&& array_summaries_detail_from_db[1] == array_summaries_from_grid_table[1]
			)
		]);

		arrayResult.add([
			'func now credit total',
			array_summaries_detail_from_db[2],
			array_summaries_from_db[2],
			array_summaries_detail_from_grid_table[2],
			array_summaries_from_grid_table[2],
			getResult(
				array_summaries_detail_from_db[2] == array_summaries_from_db[2]
				&& array_summaries_detail_from_db[2] == array_summaries_detail_from_grid_table[2]
				&& array_summaries_detail_from_db[2] == array_summaries_from_grid_table[2]
			)
		]);

		arrayResult.add([
			'amount of money total',
			array_summaries_detail_from_db[3],
			array_summaries_from_db[3],
			array_summaries_detail_from_grid_table[3],
			array_summaries_from_grid_table[3],
			getResult(
				array_summaries_detail_from_db[3] == array_summaries_from_db[3]
				&& array_summaries_detail_from_db[3] == array_summaries_detail_from_grid_table[3]
				&& array_summaries_detail_from_db[3] == array_summaries_from_grid_table[3]
			)
		]);

		printServey.print(arrayHeader, arrayResult);
	}
			
	def surveyDetailDatas (LinkedList<String[]> arrayDetailFromDB, LinkedList<String[]> arrayDetailFromGT) {
		ArrayList<String> arrayIdFromDB = new ArrayList<String>();
		ArrayList<String> arrayIdFromGT = new ArrayList<String>();
		for(int i = 0; i < arrayDetailFromDB.size(); i++) {
			arrayIdFromDB.add(arrayDetailFromDB.get(i).get(0))
		}
		for(int i = 0; i < arrayDetailFromGT.size(); i++) {
			arrayIdFromGT.add(arrayDetailFromGT.get(i).get(9))
		}
		
		println(' =====> INPUT');
		println(' => array id from db:');
		println('    ' + arrayIdFromDB);
		println(' => array id from grid table:');
		println('    ' + arrayIdFromGT);
		println(' =====> SURVEY RESULT');
		
		def arrayHeader = [];
		def arrayResult = [];
		
		arrayHeader.add([
			'case',
			'array id from db',
			'array id from grid table',
			'result'
		])
		
		arrayResult.add([
			'size',
			arrayIdFromDB.size(),
			arrayIdFromGT.size(),
			getResult(arrayIdFromDB.size() == arrayIdFromGT.size())
		])
		
		arrayResult.add([
			'same with others',
			arrayIdFromDB.containsAll(arrayIdFromGT),
			arrayIdFromGT.containsAll(arrayIdFromDB),
			getResult(
				arrayIdFromDB.containsAll(arrayIdFromGT) 
				&& arrayIdFromGT.containsAll(arrayIdFromDB)
			)
		])
		
		printServey.print(arrayHeader, arrayResult);
	}

	

	def String getResult(Boolean bool) {
		return bool == true ? 'PASS' : 'FAILED';
	}
}
