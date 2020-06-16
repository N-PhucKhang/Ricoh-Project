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

WebUI.delay(3)

WebUI.click(findTestObject('add_button'))

String sale_com = '202'

String sale_name = '秋田'

WebUI.click(findTestObject('sale_come_cell'))

WebUI.setText(findTestObject('sale_com_text'), sale_com)

WebUI.click(findTestObject('sale_com_name'))

WebUI.setText(findTestObject('sale_com_name'), sale_name)

WebUI.click(findTestObject('update_sale_com_button'))

if (sale_com == '999') {
    WebUI.verifyTextPresent('999は登録出来ません。', false)
}

if ((sale_com == '202') && (sale_name != '')) {
    WebUI.verifyTextPresent('同一販社が複数入力されています。販社CD：202', false)
	WebUI.closeBrowser()
}

if ((sale_com != '') && (sale_name == '秋田')) {
    WebUI.verifyTextPresent('同一販社が複数入力されています。販社名：秋田', false)
	WebUI.closeBrowser()
}

if ((sale_com == '202') && (sale_name == '秋田')) {
    WebUI.verifyTextPresent('同一販社が複数入力されています。販社CD：202', false)
	WebUI.closeBrowser()
}

if (((sale_com == '') && (sale_name == '')) || ((sale_com == '') || (sale_name == ''))) {
    WebUI.verifyTextPresent('販社コードと販社名はかならず入力してください。', false)
	WebUI.closeBrowser()
}

