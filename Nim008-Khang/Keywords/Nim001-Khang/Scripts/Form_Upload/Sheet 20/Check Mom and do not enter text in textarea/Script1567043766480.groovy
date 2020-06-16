import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Có check vào mục [MoM業務担当への連絡がチェック] và chưa nhập text ở khung [コメント]
WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Sub/Into_Upload_Page'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.check(findTestObject('Form_Upload/checkbox_MoM'))
WebUI.verifyElementChecked(findTestObject('Form_Upload/checkbox_MoM'), 30, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Form_Upload/button_Apply'))
errMsg = WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg'))
WebUI.verifyEqual(errMsg, '業務担当への 連絡内容 が入力されていません', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.closeBrowser()

