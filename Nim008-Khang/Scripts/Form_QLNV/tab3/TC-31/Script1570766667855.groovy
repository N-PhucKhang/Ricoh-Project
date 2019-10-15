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

WebUI.waitForPageLoad(6)

WebUI.click(findTestObject('QLNV_Form/Tab_3'))

WebUI.click(findTestObject('QLNV_Form/produc_button'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/display_application_view/sf_nim008_apl001')

WebUI.click(findTestObject('QLNV_Form/checkbox_all'))

WebUI.click(findTestObject('QLNV_Form/select_bt'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?')

product_count = WebUI.getText(findTestObject('QLNV_Form/product_count'))

colum3_num = WebUI.getText(findTestObject('QLNV_Form/colum3_num'))

colum2_num = WebUI.getText(findTestObject('QLNV_Form/colum2_num'))

colum4_num = WebUI.getText(findTestObject('QLNV_Form/colum4_num'))

WebUI.verifyMatch(product_count, '61', true, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyMatch(colum3_num, '15,442', true, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyMatch(colum2_num, '376,478', true, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyMatch(colum4_num, '371,755', true, FailureHandling.STOP_ON_FAILURE)


WebUI.closeBrowser()

