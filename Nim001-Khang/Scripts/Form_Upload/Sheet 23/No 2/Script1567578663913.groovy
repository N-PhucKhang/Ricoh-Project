import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
String Folder_Url = RunConfiguration.getProjectDir().replace('/', '\\')

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Sub/Into_Upload_Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Form_Upload/button_AddFile') 
    )
WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), Folder_Url + GlobalVariable.No2)
WebUI.delay(1)
WebUI.click(findTestObject('Form_Upload/button_UpFile_Popup') , FailureHandling.STOP_ON_FAILURE 
    )
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Form_Upload/button_ReadFile') , FailureHandling.STOP_ON_FAILURE 
    )
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Form_Upload/button_Reading_Result_Check') , FailureHandling.STOP_ON_FAILURE )
WebUI.switchToWindowIndex(1)
WebUI.maximizeWindow()
WebUI.waitForPageLoad(2)
MsgErr = WebUI.getText(findTestObject('Object Repository/Form_Upload/check_Text1'))
WebUI.verifyEqual(MsgErr, '更新区分が正しく設定されていません。1:登録、2:更新、3:削除の区分値を設定してください')
WebUI.closeBrowser()

