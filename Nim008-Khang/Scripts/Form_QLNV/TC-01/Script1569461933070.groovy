import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('QLNV_Form/Into_QLNV_Form'))

WebUI.waitForPageLoad(3)

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('QLNV_Form/button_QA'))

errMsg = WebUI.getText(findTestObject('QLNV_Form/label_errMsg'))

WebUI.verifyEqual(errMsg, "チェックをしてください。")

WebUI.closeBrowser()

