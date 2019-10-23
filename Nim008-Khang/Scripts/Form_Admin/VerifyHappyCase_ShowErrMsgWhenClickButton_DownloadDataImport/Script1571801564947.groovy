import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl003?', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(3)

WebUI.click(findTestObject('Object Repository/Admin_Form/button_Tab2'))

WebUI.delay(3)

WebUI.click(findTestObject('Admin_Form/button_Tab2_Download_Data_Clear'))

errMsg = WebUI.getText(findTestObject('label_errMsg'))

WebUI.verifyEqual(errMsg , "対象がありません。チェックをしてください。")

WebUI.closeBrowser()