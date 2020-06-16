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

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev09', ('Password') : 'dev09'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('QLNV_Form/Tab_3'))

WebUI.waitForPageLoad(4)

WebUI.click(findTestObject('QLNV_Form/produc_button'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/display_application_view/sf_nim008_apl001')

WebUI.click(findTestObject('QLNV_Form/checkbox_all'))

WebUI.click(findTestObject('QLNV_Form/select_bt'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?')

WebUI.click(findTestObject('QLNV_Form/Tab3/check_box'))

WebUI.click(findTestObject('QLNV_Form/Tab3/clear_button'))

hdd_insertId = WebUI.getAttribute(findTestObject('QLNV_Form/Tab3/hdd_insert_idd'), 'title')

CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com', 'log_search_user', 
    'Log_seaRch_uSer', 'imart_rfg')

String sql = 'SELECT IMFR_UD_CLEARED_FLAG FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_SD_INSERT_ID = ' + hdd_insertId

println(sql)

def DBClearedFlag = CustomKeywords.'com.database.connectSql.executeQuery'(sql)

println('CheckCombinationKey: ' + DBClearedFlag)

CustomKeywords.'com.database.connectSql.closeDatabaseConnection'()

WebUI.verifyMatch((DBClearedFlag[0])[0], '1', true, FailureHandling.STOP_ON_FAILURE)

