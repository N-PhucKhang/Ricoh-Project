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

WebUI.click(findTestObject('sale_value_equal_26'))

WebUI.click(findTestObject('choice_button'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?')

WebUI.check(findTestObject('salecom_checkbox'))

WebUI.click(findTestObject('QA_button'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl//forma/normal/view/regist_application_view/sf_nim008_apl002?imui-theme-builder-module=headwithcontainer')

WebUI.check(findTestObject('qa_div_1_checkbox'))

WebUI.setText(findTestObject('to_textbox'), 'nghia@pasona.com')

WebUI.setText(findTestObject('question_textbox'), '金曜日は25日ですか？')

WebUI.click(findTestObject('save_close_button'))

