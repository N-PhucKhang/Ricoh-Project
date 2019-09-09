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

// Login Itra-mart
WebUI.openBrowser('')
WebUI.navigateToUrl('http://132.145.113.198/imsl/login', FailureHandling.STOP_ON_FAILURE)
WebUI.maximizeWindow()
WebUI.waitForPageLoad(2)
WebUI.clearText(findTestObject('Login/textbox_Username'))
WebUI.setText(findTestObject('Login/textbox_Username'), 'dev04')
WebUI.setText(findTestObject('Login/textbox_Password'), 'dev04')
WebUI.click(findTestObject('Login/button_Login'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(2)
WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/apply/apply_list?')
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject('Form_Upload/button_into_UploadPage'))
WebUI.waitForPageLoad(2)

int totalFile = 1
for (int i = 1; i <= totalFile; i++) {
	WebUI.click(findTestObject('Form_Upload/button_AddFile'))
	WebUI.delay(2)
	WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), ('C:\\users\\Dell\\Downloads\\nim001\\No30-' + i) + '.csv')
	WebUI.delay(2)
	WebUI.click(findTestObject('Form_Upload/button_UpFile_Popup'))
	WebUI.delay(2)

	WebUI.click(findTestObject('Object Repository/Form_Upload/button_ReadFile'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Form_Upload/button_Reading_Result_Check'))
	WebUI.switchToWindowIndex(1)
	WebUI.maximizeWindow()
	WebUI.waitForPageLoad(2)
	WebUI.maximizeWindow()

	WebUI.takeScreenshot(('D:\\KatalonScreenShot\\Sheet23\\No30-' + i) + '.png')
	WebUI.delay(2)

	MsgErr1 = WebUI.getText(findTestObject('Form_Upload/check_Text1'))
	WebUI.verifyEqual(MsgErr1, '原価振替コードに不正な値が設定されています')

	WebUI.closeWindowIndex(1)
	WebUI.switchToWindowIndex(0)
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Form_Upload/button_Delete'))
	WebUI.delay(3)
}
WebUI.closeBrowser()