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

WebUI.openBrowser('')
WebUI.waitForPageLoad(3)
WebUI.navigateToUrl('http://132.145.113.198/imsl/login' , FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()
WebUI.clearText(findTestObject('Login/textbox_Username'))  // Clear textbox user
WebUI.setText(findTestObject('Login/textbox_Username'), 'dev04')  // Input user
WebUI.setText(findTestObject('Login/textbox_Password'), 'dev04')  // Input password
// Click button login
WebUI.click(findTestObject('Login/button_Login'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(2)
WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/apply/apply_list?')
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject('Form_Upload/button_into_UploadPage'))  // Into Upload page
WebUI.waitForPageLoad(2)

int totalFile = 3;
for (int i = 1; i <= totalFile; i++) {
	WebUI.click(findTestObject('Form_Upload/button_AddFile'))
	WebUI.delay(2)
	
	WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), "C:\\users\\Dell\\Downloads\\nim001\\No14-"+ i + ".csv")
	WebUI.delay(2)
	WebUI.click(findTestObject('Form_Upload/button_UpFile_Popup'))
	WebUI.delay(2)
	
	
	WebUI.click(findTestObject('Object Repository/Form_Upload/button_ReadFile')) // Click button Read File
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Form_Upload/button_Reading_Result_Check'))
	
	WebUI.switchToWindowIndex(1)
	WebUI.maximizeWindow()
	WebUI.waitForPageLoad(2)
	WebUI.maximizeWindow()
	
	WebUI.takeScreenshot('D:\\KatalonScreenShot\\Sheet23\\No14-' + i + '.png') // Take screen shot
	WebUI.delay(2)
	WebUI.verifyTextPresent("商品コードは６桁で入力してください", false)
	WebUI.closeWindowIndex(1)
	
	WebUI.switchToWindowIndex(0)
	WebUI.delay(2)

	WebUI.click(findTestObject('Object Repository/Form_Upload/button_Delete'))
	WebUI.delay(3)
}

WebUI.closeBrowser()