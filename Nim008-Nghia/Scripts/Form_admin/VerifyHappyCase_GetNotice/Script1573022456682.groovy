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

WebUI.callTestCase(findTestCase('Common/Login_user'), [('Password') : 'dev06', ('Username') : 'dev06'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl003?', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(3)

WebUI.delay(2)

WebUI.click(findTestObject('notice_date_icon'))

WebUI.click(findTestObject('choose_notice_date'))

WebUI.setText(findTestObject('notice_area'), 'もしもし、私は乾燥ココナッツを買いたい。ありますか？')

WebUI.click(findTestObject('update_notice_button'))
WebUI.delay(2)

String notice_text = WebUI.executeJavaScript('return $(\'[name="notice_field_h"]\').val()', null)
String notice_date = WebUI.executeJavaScript('return $(\'[name="notice_date_h"]\').val()', null)

String notice_text_display = WebUI.executeJavaScript('return $(\'[name="notice_field"]\').val()', null)
String notice_date_display = WebUI.executeJavaScript('return $(\'[name="notice_date_display"]\').val()', null)

WebUI.verifyEqual(notice_date, notice_date_display)

WebUI.verifyEqual(notice_text, notice_text_display)

CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com', 'log_search_user',
	'Log_seaRch_uSer', 'imart_rfg')

def countData = CustomKeywords.'com.database.connectSql.executeQuery'('SELECT Count(*) FROM imfr_ut_sf_nim008_apl003_info')
WebUI.verifyGreaterThanOrEqual((countData[0])[0], 1)

WebUI.closeBrowser()