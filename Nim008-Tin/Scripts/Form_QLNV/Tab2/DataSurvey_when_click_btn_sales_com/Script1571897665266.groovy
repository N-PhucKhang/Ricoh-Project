import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
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
WebUI.click(findTestObject('Object Repository/QLNV_Form/Popup/sale_com_1'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Popup/sale_com_2'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Popup/sale_com_3'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Popup/sale_com_4'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Popup/sale_com_5'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_Popup_Choose'))
println('----- END SELECT SALES COM -----')
WebUI.delay(2)

"Get hidden sales com selected values"
println('----- GET HIDDEN SELECT SALES COM VALUES -----')
WebUI.switchToWindowIndex(0)
hidden_sales_com_values = WebUI.getAttribute(findTestObject('Object Repository/QLNV_Form/Tab2/hidden_sales_com'), "value")
println("hidden sales com: " + hidden_sales_com_values)
WebUI.delay(2)
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
sql_select_sales_com_detail = "SELECT imfr_sd_insert_id AS insert_id,imfr_ud_sales_com AS sales_com,imfr_ud_branch_office AS branch_office,imfr_ud_customer AS customer,imfr_ud_journal_date AS journal_date,imfr_ud_application_key AS application_key,imfr_ud_customer_nm AS customer_nm,imfr_ud_uncollected AS uncollected,imfr_ud_overpayment AS overpayment,imfr_ud_amount_of_money AS amount_of_money,imfr_ud_qa AS qa,imfr_ud_product_cd AS product_cd,imfr_ud_product_name AS product_name FROM imfr_ut_sf_nim008_apl001 WHERE imfr_ud_sales_com IN " + hidden_sales_com_param
println('SQL select sales com detail: ' + sql_select_sales_com_detail)
def sales_com_detail_list = CustomKeywords.'com.database.connectSql.executeQuery'(sql_select_sales_com_detail.toString())
println('sales com detail list:')
println(sales_com_detail_list)
println("Summary sales com detail list from DB: " + CustomKeywords.'com.helpers.Tab2Helpers.countItems'(sales_com_detail_list)
	+ " " + CustomKeywords.'com.helpers.Tab2Helpers.getUncollectedTotal'(sales_com_detail_list)
	+ " " + CustomKeywords.'com.helpers.Tab2Helpers.getOverpaymentTotal'(sales_com_detail_list)
	+ " " + CustomKeywords.'com.helpers.Tab2Helpers.getAmountOfMoneyTotal'(sales_com_detail_list)
)
println('----- END GET SUMMARIES SALES COM DETAIL FROM DB -----')

println('----- GET SALES COM SUMMARIES FROM DB -----')
sql_select_sales_com_summary = "SELECT COUNT(imfr_ud_sales_com) AS sales_com_count, COUNT(imfr_ud_department) AS department_count, SUM(imfr_ud_uncollected) AS uncollected_total, SUM(imfr_ud_overpayment) AS overpayment_total, SUM(imfr_ud_amount_of_money) AS amount_of_money_total FROM imfr_ut_sf_nim008_apl001 WHERE imfr_ud_sales_com IN " + hidden_sales_com_param
println('SQL select sales com summary: ' + sql_select_sales_com_summary);
def sales_com_summary_list = CustomKeywords.'com.database.connectSql.executeQuery'(sql_select_sales_com_summary.toString())
println('sales com summary list:')
println(sales_com_summary_list)
println('Summaries values from DB: ' + sales_com_summary_list.get(0).get(0)
	+ ' ' + sales_com_summary_list.get(0).get(2)
	+ ' ' + sales_com_summary_list.get(0).get(3)
	+ ' ' + sales_com_summary_list.get(0).get(4)
)
println('----- END GET SALES COM SUMMARIES FROM DB -----')

println('----- GET DATAS GRID TABLE DETAIL -----')
def s  = 'return $("#gt3").jqGrid("getRowData")'
def gt_detail_datas = WebUI.executeJavaScript(s.toString(), null);
println(gt_detail_datas)
println('----- END GET DATAS GRID TABLE DETAIL -----')

