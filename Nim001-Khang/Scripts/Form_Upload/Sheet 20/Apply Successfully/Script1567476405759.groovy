import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String Folder_Url = RunConfiguration.getProjectDir().replace('/', '\\')

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Sub/Into_Upload_Page'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Form_Upload/button_AddFile') // Click button add file
    )
WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), Folder_Url + GlobalVariable.NoError // Up file no_error.csv
    )
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject('Form_Upload/button_UpFile_Popup') // Click button upload file in popup page
    )
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Form_Upload/button_ReadFile') // Click button ReadFile
    )
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Form_Upload/button_Apply'))
WebUI.delay(2)
WebUI.switchToFrame(findTestObject('Form_Upload/Frame1'), 2)
WebUI.switchToFrame(findTestObject('Form_Upload/Frame2'), 2)
WebUI.switchToFrame(findTestObject('Form_Upload/Frame3'), 2)
WebUI.click(findTestObject('Object Repository/Form_Upload/button_Apply_StartProcessing'))
WebUI.click(findTestObject('Object Repository/Form_Upload/button_ApplyPopup'))
WebUI.closeBrowser()

