import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

"Login to nim008_apl001 and switch to tab 2"
println('----- LOGIN AND SWITCH TO TAB 2 -----')
WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)
WebUI.waitForPageLoad(3)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab_2'))
println('----- END LOGIN AND SWITCH TO TAB 2 -----')
WebUI.delay(2)


"Select sales com button, then select 5 sales_com and click btn choose"
println('----- SELECT SALES COM -----')
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_SalesCom'))
WebUI.switchToWindowIndex(1)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/sale_com_1'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/sale_com_2'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/sale_com_3'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/sale_com_4'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/sale_com_5'))
//WebUI.click(findTestObject('QLNV_Form/Tab2/checkbox_Popup_CheckAll_SalesCom'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_Popup_Choose'))
println('----- END SELECT SALES COM -----')
WebUI.delay(2)

"Get hidden sales com selected values"
println('----- GET HIDDEN SELECT SALES COM VALUES -----')
WebUI.switchToWindowIndex(0)
hidden_sales_com_values = WebUI.getAttribute(findTestObject('Object Repository/QLNV_Form/Tab2/hidden_sales_com'), "value")
println("hidden sales com: " + hidden_sales_com_values)
println('----- END GET HIDDEN SELECT SALES COM VALUES -----')

"Convert input values"
println('----- CONVERT INPUT VALUES -----')
def hidden_sales_com_param = CustomKeywords.'com.helpers.Tab2Helpers.convert'(hidden_sales_com_values)
println('Hidden sales com param: ' + hidden_sales_com_param)
println('----- END CONVERT INPUT VALUES -----')

"Connect DB and get values"
println('----- CONNECT DATABASE -----')
CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
	'log_search_user', 'Log_seaRch_uSer', "imart_rfg")
println('----- END CONNECT DATABASE -----')

println('----- GET SUMMARIES SALES COM DETAIL FROM DB -----')
sql_select_sales_com_detail = "SELECT imfr_sd_insert_id AS insert_id, imfr_ud_sales_com AS sales_com, imfr_ud_department_name AS department_name, imfr_ud_customer_name AS customer, imfr_ud_journal_date AS journal_date, imfr_ud_application_key AS application_key, imfr_ud_customer_nm AS customer_nm, imfr_ud_func_now_debit AS func_now_debit, imfr_ud_func_now_credit AS func_now_credit, imfr_ud_amount_of_money AS amount_of_money, imfr_ud_qa AS qa, imfr_ud_product_cd AS product_cd, imfr_ud_product_name AS product_name FROM imfr_ut_sf_nim008_apl001 WHERE imfr_ud_sales_com IN " + hidden_sales_com_param
println('SQL select sales com detail: ' + sql_select_sales_com_detail)
def sales_com_detail_list = CustomKeywords.'com.database.connectSql.executeQuery'(sql_select_sales_com_detail.toString())
println('sales com detail list:')
println(sales_com_detail_list)
println("Summary sales com detail list from DB: " + CustomKeywords.'com.helpers.Tab2Helpers.countItems'(sales_com_detail_list)
	+ " " + CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(sales_com_detail_list, 7)
	+ " " + CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(sales_com_detail_list, 8)
	+ " " + CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(sales_com_detail_list, 9)
)

def array_summaries_detail_from_db = [
	CustomKeywords.'com.helpers.Tab2Helpers.countItems'(sales_com_detail_list),
	CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(sales_com_detail_list, 7),
	CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(sales_com_detail_list, 8),
	CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(sales_com_detail_list, 9)
]

println('----- END GET SUMMARIES SALES COM DETAIL FROM DB -----')

println('----- GET SALES COM SUMMARIES FROM DB -----')
sql_select_sales_com_summary = "SELECT COUNT(imfr_ud_sales_com) AS sales_com_count, COUNT(imfr_ud_department_name) AS department_count, SUM(imfr_ud_func_now_debit) AS func_now_debit_total, SUM(imfr_ud_func_now_credit) AS func_now_credit_total, SUM(imfr_ud_amount_of_money) AS amount_of_money_total FROM imfr_ut_sf_nim008_apl001 WHERE imfr_ud_sales_com IN " + hidden_sales_com_param
println('SQL select sales com summary: ' + sql_select_sales_com_summary);
def sales_com_summary_list = CustomKeywords.'com.database.connectSql.executeQuery'(sql_select_sales_com_summary.toString())
println('sales com summary list:')
println(sales_com_summary_list)
println('Summaries values from DB: ' + sales_com_summary_list.get(0).get(0)
	+ ' ' + sales_com_summary_list.get(0).get(2)
	+ ' ' + sales_com_summary_list.get(0).get(3)
	+ ' ' + sales_com_summary_list.get(0).get(4)
)

def array_summaries_from_db = [
	CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(sales_com_summary_list.get(0).get(0).toString()),
	CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(sales_com_summary_list.get(0).get(2).toString()),
	CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(sales_com_summary_list.get(0).get(3).toString()),
	CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(sales_com_summary_list.get(0).get(4).toString())
]

println('----- END GET SALES COM SUMMARIES FROM DB -----');

println('----- GET DATAS GRID TABLE DETAIL -----');
def gt_detail_datas = CustomKeywords.'com.helpers.Tab2Helpers.getGridTableData'("gt3");
println('gt detail datas');
println(gt_detail_datas);
println('Summaries grid table detail: ' + CustomKeywords.'com.helpers.Tab2Helpers.countItems'(gt_detail_datas)
	+ ' ' + CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(gt_detail_datas, 0)
	+ ' ' + CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(gt_detail_datas, 6)
	+ ' ' + CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(gt_detail_datas, 7)
);

def array_summaries_detail_from_grid_table = [
	CustomKeywords.'com.helpers.Tab2Helpers.countItems'(gt_detail_datas),
	CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(gt_detail_datas, 0),
	CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(gt_detail_datas, 6),
	CustomKeywords.'com.helpers.Tab2Helpers.getColumnTotalValue'(gt_detail_datas, 7)
]

println('----- END GET DATAS GRID TABLE DETAIL -----');

println('----- GET DATAS GRID TABLE SUMMARIES -----');
//def js_get_gt_detail_datas  = 'return $("#gt3").jqGrid("getRowData")'
def gt_summaries_datas = CustomKeywords.'com.helpers.Tab2Helpers.getGridTableData'('gt2');
println('gt summaries datas');
println(gt_summaries_datas);
println('Summaries grid table summaries: ' + gt_summaries_datas[0][5]
	+ ' ' + CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(gt_summaries_datas[0][1])
	+ ' ' + CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(gt_summaries_datas[0][0])
	+ ' ' + CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(gt_summaries_datas[0][2])
	+ ' ' + CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(gt_summaries_datas[0][3])
);

def array_summaries_from_grid_table = [
	CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(gt_summaries_datas[0][1]),
	CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(gt_summaries_datas[0][0]),
	CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(gt_summaries_datas[0][2]),
	CustomKeywords.'com.helpers.Tab2Helpers.convertStringToBigDecimal'(gt_summaries_datas[0][3])
]

println('----- END GET DATAS GRID TABLE SUMMARIES -----');

println('----- SURVEY SUMMARIES DATA -----');
CustomKeywords.'com.helpers.Tab2Helpers.surveySumariesData'(
	array_summaries_detail_from_db,
	array_summaries_from_db,
	array_summaries_detail_from_grid_table,
	array_summaries_from_grid_table
)
println('----- END SURVEY SUMMARIES DATA -----');


