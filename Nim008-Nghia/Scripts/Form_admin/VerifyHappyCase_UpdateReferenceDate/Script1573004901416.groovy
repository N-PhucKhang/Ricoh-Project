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

WebUI.click(findTestObject('icon_choose_date'))

WebUI.click(findTestObject('choose_date'))

WebUI.setText(findTestObject('num_of_date'), '29')

WebUI.click(findTestObject('update_date_button'))

String date = WebUI.executeJavaScript('return $(\'[name="reference_date_display"]\').val()', null)

String num = WebUI.executeJavaScript('return $(\'[name="num_day_elapsed"]\').val()', null)

Boolean flag 
try {
	
	flag = WebUI.verifyMatch(num, '[0-9]+', true )
	
} catch (Exception e) {
	flag = false;
	e.printStackTrace()
}
if (flag == true) {
    CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com', 'log_search_user', 
        'Log_seaRch_uSer', 'imart_rfg')

    def countData = CustomKeywords.'com.database.connectSql.executeQuery'(((('SELECT COUNT(*) FROM imfr_ut_sf_nim008_apl003_base WHERE imfr_ud_gt2_reference_date = \'' + 
        date) + '\' and  imfr_ud_gt2_num_day_elapsed =\'') + num) + '\' ')

    WebUI.verifyGreaterThanOrEqual((countData[0])[0], 1)

    WebUI.closeBrowser()
} else {
    WebUI.verifyTextPresent('経過日数に不適切な値が指定されています。', true)

    WebUI.closeBrowser()
}

