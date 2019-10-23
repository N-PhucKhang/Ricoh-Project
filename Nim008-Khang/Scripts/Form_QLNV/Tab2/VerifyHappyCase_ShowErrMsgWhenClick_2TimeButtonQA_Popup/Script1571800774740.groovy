import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)
WebUI.waitForPageLoad(3)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab_2'))
WebUI.delay(3)
WebUI.click(findTestObject('QLNV_Form/Tab1/button_Edit_Line1'))

WebUI.switchToWindowUrl("http://132.145.113.198/imsl/forma/normal/view/display_application_view/sf_nim008_apl001")
WebUI.delay(1)
WebUI.click(findTestObject('button_QA_Popup'))
WebUI.delay(2)
WebUI.click(findTestObject('button_QA_Popup'))
WebUI.delay(2)
WebUI.click(findTestObject('button_QA_Popup'))

errMsg = WebUI.getText(findTestObject('label_errMsg'))
WebUI.verifyMatch(errMsg , "既に問い合わせ登録画面が開いています。保存又は画面を閉じた後、.*新しい登録を行ってください", true, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()