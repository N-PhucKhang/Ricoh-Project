import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(3)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab_6'))

WebUI.waitForPageLoad(3)

WebUI.delay(2)

WebUI.click(findTestObject('QLNV_Form/Tab6/button_Tab6_Edit_Line1'))

WebUI.switchToWindowUrl("http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl002?gt8_sec=&subform=8")
WebUI.maximizeWindow()

WebUI.verifyElementPresent(findTestObject('Object Repository/Admin_Form/button_To_Mails'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()