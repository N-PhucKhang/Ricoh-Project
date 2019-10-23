import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)
WebUI.waitForPageLoad(3)
WebUI.delay(2)

WebUI.check(findTestObject('Object Repository/QLNV_Form/Tab1/checkbox_CheckAll'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab1/button_QA'))
WebUI.switchToWindowIndex(1)

int total = 3;
for(int i = 1; i <= total; i++ ){
	if(i == 1){
		WebUI.click(findTestObject('Object Repository/QA_Form/button_Save'))
	}
	if(i == 2){
		WebUI.click(findTestObject('Object Repository/QA_Form/button_SendMail'))
	}
	if(i == 3){
		WebUI.click(findTestObject('Object Repository/QA_Form/button_ReplyMail'))
	}
	errMsg = WebUI.getText(findTestObject('label_errMsg'))
	WebUI.delay(2)
	WebUI.verifyEqual(errMsg , "質問伝言分類,To,Question が入力されていません。")
}

WebUI.delay(2)
WebUI.check(findTestObject('Object Repository/QA_Form/chekbox_1'))
for(int i = 1; i <= total; i++ ){
	if(i == 1){
		WebUI.click(findTestObject('Object Repository/QA_Form/button_Save'))
	}
	if(i == 2){
		WebUI.click(findTestObject('Object Repository/QA_Form/button_SendMail'))
	}
	if(i == 3){
		WebUI.click(findTestObject('Object Repository/QA_Form/button_ReplyMail'))
	}
	errMsg = WebUI.getText(findTestObject('label_errMsg'))
	WebUI.delay(2)
	WebUI.verifyEqual(errMsg , "To,Question が入力されていません。")
}

WebUI.delay(2)
WebUI.setText(findTestObject('Object Repository/QA_Form/textarea_MailTo'), 'khang@gmail.com')
for(int i = 1; i <= total; i++ ){
	if(i == 1){
		WebUI.click(findTestObject('Object Repository/QA_Form/button_Save'))
	}
	if(i == 2){
		WebUI.click(findTestObject('Object Repository/QA_Form/button_SendMail'))
	}
	if(i == 3){
		WebUI.click(findTestObject('Object Repository/QA_Form/button_ReplyMail'))
	}
	errMsg = WebUI.getText(findTestObject('label_errMsg'))
	WebUI.delay(2)
	WebUI.verifyEqual(errMsg , "Question が入力されていません。")
}
WebUI.closeBrowser()



