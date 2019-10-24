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
WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)
WebUI.waitForPageLoad(3)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab_2'))
WebUI.delay(2)


"Select sales com button, then select 5 sales_com and click btn choose"
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_SalesCom'))
WebUI.switchToWindowIndex(1)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Popup/sale_com_1'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Popup/sale_com_2'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Popup/sale_com_3'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Popup/sale_com_4'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Popup/sale_com_5'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_Popup_Choose'))
WebUI.delay(2)

"Get hidden sales com selected values"
WebUI.switchToWindowIndex(0)
hd_sales_com = WebUI.getAttribute(findTestObject('Object Repository/QLNV_Form/Tab2/hidden_sales_com'), "value")
println("hidden sales com: " + hd_sales_com)
WebUI.delay(2)

"Connect DB and get values"
CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
	'log_search_user', 'Log_seaRch_uSer', "imart_rfg")
def param = CustomKeywords.'com.helper.js.ConvertStringToArrayChar.convert'(hd_sales_com)
println(param)
sql = "SELECT IMFR_UD_APP_COMBINATION_KEY FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_UD_SALES_COM = ('" + param + "')"
println('SQL: ' + sql)
def DBCombinationKey = CustomKeywords.'com.database.connectSql.executeQuery'(sql.toString())
println(DBCombinationKey)