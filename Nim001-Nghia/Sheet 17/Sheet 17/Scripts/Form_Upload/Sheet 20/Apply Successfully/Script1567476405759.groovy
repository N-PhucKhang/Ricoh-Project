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

WebUI.navigateToUrl('http://132.145.113.198/imsl/login' // Open IM
    )

WebUI.waitForPageLoad(2)

WebUI.clearText(findTestObject('Login/textbox_Username' // Clear textbox user
        ))

WebUI.setText(findTestObject('Login/textbox_Username'), 'dev04' // Input user
    )

WebUI.setText(findTestObject('Login/textbox_Password'), 'dev04' // Input password
    )

WebUI.click(findTestObject('Login/button_Login' // Click button login
        ))

WebUI.waitForPageLoad(2)

WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/apply/apply_list?' // Go to URL
    )

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Form_Upload/button_into_UploadPage' // Into Upload page
        ))

WebUI.click(findTestObject('Form_Upload/button_AddFile' // Click button add file
        ))

WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), 'C:\\Users\\user\\Desktop\\khang38.csv' // Up file khang38.csv
    )

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Form_Upload/button_UpFile_Popup' // Click button upload file in popup page
        ))

WebUI.waitForPageLoad(2)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Form_Upload/button_ReadFile' // Click button ReadFile
        ))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Form_Upload/button_Apply'))

WebUI.delay(2)

WebUI.switchToFrame(findTestObject('Form_Upload/Frame1'), 2)

WebUI.switchToFrame(findTestObject('Form_Upload/Frame2'), 2)

WebUI.switchToFrame(findTestObject('Form_Upload/Frame3'), 2)

WebUI.click(findTestObject('Object Repository/Form_Upload/button_Apply_StartProcessing'))

WebUI.click(findTestObject('Object Repository/Form_Upload/button_ApplyPopup'))

WebUI.takeScreenshot('D:\\KatalonScreenShot\\Sheet20\\apply_successfully.png' // Take screen shot
    )

