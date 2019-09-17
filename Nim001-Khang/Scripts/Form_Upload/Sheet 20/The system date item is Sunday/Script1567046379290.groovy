import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Mục [単価適用日](system date) là chủ nhật
WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Sub/Into_Upload_Page'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Form_Upload/Calendar/textbox_Calendar'))
WebUI.selectOptionByIndex(findTestObject('Form_Upload/Calendar/Month'), 8)
WebUI.click(findTestObject('Form_Upload/Calendar/Sunday'))
WebUI.click(findTestObject('Form_Upload/button_Apply'))
errMsg = WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg'))
WebUI.verifyEqual(errMsg, '単価適用日 に土曜日、日曜日が設定されています')
WebUI.closeBrowser()

