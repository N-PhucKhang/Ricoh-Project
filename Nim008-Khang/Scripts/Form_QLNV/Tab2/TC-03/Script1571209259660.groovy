import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
"Check 4 button"

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)
WebUI.waitForPageLoad(3)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab_2'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_SalesCom'))
WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/display_application_view/sf_nim008_apl001')
WebUI.click(findTestObject('QLNV_Form/Tab2/checkbox_Popup_CheckAll_SalesCom'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_Popup_Choose'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?')

WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_Branch'))
WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/display_application_view/sf_nim008_apl001')
WebUI.click(findTestObject('QLNV_Form/Tab2/checkbox_Popup_CheckAll_Branch'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_Popup_Choose'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?')

WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_Department'))
WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/display_application_view/sf_nim008_apl001')
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/checkbox_Popup_CheckAll_Department'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_Popup_Choose'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?')

WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_Customer'))
WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/display_application_view/sf_nim008_apl001')
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/checkbox_Popup_CheckAll_Customer'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab2/button_Popup_Choose'))

