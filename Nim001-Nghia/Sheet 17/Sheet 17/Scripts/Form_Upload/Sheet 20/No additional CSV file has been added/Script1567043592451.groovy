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

// Chưa bổ sung file CSV đính kèm

WebUI.openBrowser('')

WebUI.navigateToUrl('http://132.145.113.198/imsl/login')

//WebUI.waitForPageLoad(2)

WebUI.maximizeWindow()

WebUI.clearText(findTestObject('Login/textbox_Username'))

//WebUI.clearText(findTestObject('Login/textbox_Password'))

WebUI.setText(findTestObject('Login/textbox_Username'), 'dev04')

WebUI.setText(findTestObject('Login/textbox_Password'), 'dev04')

WebUI.click(findTestObject('Login/button_Login'))

WebUI.waitForPageLoad(2)

WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/apply/apply_list?')

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Form_Upload/button_into_UploadPage'))

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Object Repository/Form_Upload/button_Apply'))

errMsg =  WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg'))

WebUI.verifyEqual(errMsg, "一括更新ファイルが添付されていません")

WebUI.waitForPageLoad(2)

WebUI.takeScreenshot('D:\\KatalonScreenShot\\Sheet20\\no_add_file_csv.png')

WebUI.closeBrowser()