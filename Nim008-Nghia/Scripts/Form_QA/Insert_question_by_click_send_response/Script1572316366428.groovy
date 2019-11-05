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

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(3)

WebUI.delay(2)

WebUI.click(findTestObject('sale_comp_button'))

WebUI.waitForPageLoad(3)

WebUI.delay(2)

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/display_application_view/sf_nim008_apl001')

WebUI.click(findTestObject('sale_value_all'))

WebUI.click(findTestObject('choice_button'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?')

WebUI.check(findTestObject('salecom_checkbox'))

WebUI.click(findTestObject('QA_button'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl//forma/normal/view/regist_application_view/sf_nim008_apl002?imui-theme-builder-module=headwithcontainer')

WebUI.check(findTestObject('qa_div_1_checkbox'))

WebUI.click(findTestObject('TO_button'), FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowIndex(2)

WebUI.setText(findTestObject('search_user_name'), 'a')

WebUI.click(findTestObject('search_user_name_button'))

WebUI.click(findTestObject('choose_user_mail'))

WebUI.click(findTestObject('select_button'))

WebUI.switchToWindowIndex(1)

WebUI.setText(findTestObject('question_textbox'), '金曜日は25日ですか？inserted by NghiaHH')

String link_registraton = WebUI.getUrl()

WebUI.getUrl().contains('regist_application_view')

WebUI.click(findTestObject('send_response_button'))

WebUI.delay(2)

WebUI.verifyTextPresent('Q&A本文を保存し、メールを送信しました', false)

WebUI.click(findTestObject('ok_button'))

WebUI.getUrl().contains('edit_application_view')

CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com', 'log_search_user', 
    'Log_seaRch_uSer', 'imart_rfg')

def countData = CustomKeywords.'com.database.connectSql.executeQuery'('SELECT COUNT(*) FROM IMFR_UT_SF_NIM008_APL002 WHERE IMFR_UD_QUESTION = \'金曜日は25日ですか？inserted by NghiaHH\' AND IMFR_SD_CREATE_DATE = (SELECT MAX(IMFR_SD_CREATE_DATE) FROM IMFR_UT_SF_NIM008_APL002 )')

WebUI.verifyGreaterThanOrEqual((countData[0])[0], 1)

WebUI.click(findTestObject('send_response_button'))

WebUI.click(findTestObject('ok_button'))

WebUI.switchToWindowIndex(0)

WebUI.click(findTestObject('list_question_tab'))

WebUI.click(findTestObject('pager'))

WebUI.click(findTestObject('pager_200'))

WebUI.verifyTextPresent('金曜日は25日ですか？inserted by NghiaHH', false)

WebUI.click(findTestObject('list_question_tab'))

def countRow = CustomKeywords.'com.database.connectSql.executeQuery'('SELECT COUNT(*) FROM IMFR_UT_SF_NIM008_APL002')

WebUI.delay(2)

String countRowsOnGrids = WebUI.executeJavaScript('return $(\'#gt8\').jqGrid(\'getGridParam\', \'records\')', null)

WebUI.verifyEqual((countRow[0])[0], countRowsOnGrids)

WebUI.closeBrowser()

