import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String Folder_Url = RunConfiguration.getProjectDir().replace('/', '\\')

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Sub/Into_Upload_Page'), [:], FailureHandling.STOP_ON_FAILURE)

int totalFile = 3
for (int i = 1; i <= totalFile; i++) {
    WebUI.click(findTestObject('Form_Upload/button_AddFile'))
    WebUI.delay(2)
    WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), Folder_Url + GlobalVariable.No9 + 
        i + '.csv', FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.delay(2)
    WebUI.click(findTestObject('Form_Upload/button_UpFile_Popup'))
    WebUI.delay(2)
    WebUI.click(findTestObject('Object Repository/Form_Upload/button_ReadFile') // Click button Read File
        )
    WebUI.delay(2)
    WebUI.click(findTestObject('Object Repository/Form_Upload/button_Reading_Result_Check'))
    WebUI.switchToWindowIndex(1)
    WebUI.maximizeWindow()
    WebUI.waitForPageLoad(2)
    WebUI.maximizeWindow()
	WebUI.delay(1)
    WebUI.verifyTextPresent('適用開始日８桁数値以外を設定されています', false, FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.closeWindowIndex(1)
    WebUI.switchToWindowIndex(0)
    WebUI.delay(2)
    WebUI.click(findTestObject('Object Repository/Form_Upload/button_Delete'))
    WebUI.delay(3)
}
WebUI.closeBrowser()

