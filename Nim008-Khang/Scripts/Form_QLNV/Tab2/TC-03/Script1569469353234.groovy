import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(3)

WebUI.click(findTestObject('QLNV_Form/Tab_2'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/QLNV_Form/button_Tab2_ClearSelected_Document'))

errMsg = WebUI.getText(findTestObject('QLNV_Form/label_errMsg'))
WebUI.verifyMatch(errMsg , "対象がありません。消込対象をチェックしてください。", true, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

