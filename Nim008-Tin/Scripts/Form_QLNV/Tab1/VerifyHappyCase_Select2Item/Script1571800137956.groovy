import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

"Check SUM Uncollect and Overpay"

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)
WebUI.waitForPageLoad(3)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab1/button_Selection_Company_Sales'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/display_application_view/sf_nim008_apl001')
WebUI.delay(2)
WebUI.check(findTestObject('Object Repository/QLNV_Form/Tab1/checkbox_Popup_Line 1'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab1/button_Popup_Choose_Sale_Comp'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?')
WebUI.delay(1)
WebUI.check(findTestObject('Object Repository/QLNV_Form/Tab1/checkbox_CheckAll'))

WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab1/button_QA'))
WebUI.delay(1)
WebUI.switchToWindowUrl('http://132.145.113.198/imsl//forma/normal/view/regist_application_view/sf_nim008_apl002?imui-theme-builder-module=headwithcontainer')

CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
	'log_search_user', 'Log_seaRch_uSer', "imart_rfg")

def DBSumUncollect = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT SUM(IMFR_UD_UNCOLLECTED) FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_UD_SALES_COM = '26'")
def DBSumOverpay = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT SUM(IMFR_UD_OVERPAYMENT) FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_UD_SALES_COM = '26'")

CustomKeywords.'com.database.connectSql.closeDatabaseConnection'()
SumUncollect = WebUI.getAttribute(findTestObject('Object Repository/QLNV_Form/Tab1/textbox_Sum_Uncollect'), "value")
println ("SumUncollect: " + SumUncollect)
SumOverpay = WebUI.getAttribute(findTestObject('Object Repository/QLNV_Form/Tab1/textbox_Sum_Overpay'), "value")
println ("SumOverpay: " + SumOverpay)

WebUI.verifyEqual(SumUncollect, DBSumUncollect[0][0])
WebUI.verifyEqual(SumOverpay, DBSumOverpay[0][0])

WebUI.closeBrowser()

