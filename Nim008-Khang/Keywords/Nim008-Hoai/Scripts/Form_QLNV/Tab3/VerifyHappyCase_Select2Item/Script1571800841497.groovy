import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

"Check update CombinationKey and ClearedFlag"
WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)
WebUI.waitForPageLoad(3)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab_3'))
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab3/button_Product'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/display_application_view/sf_nim008_apl001')
WebUI.check(findTestObject('Object Repository/QLNV_Form/Tab3/checkbox_Popup_CheckAll_Product'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab3/button_Popup_Choose'))

WebUI.switchToWindowUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?')
WebUI.delay(2)

WebUI.check(findTestObject('Object Repository/QLNV_Form/Tab3/checkbox_Line_SaleComp11'))

WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab3/button_Tab3_Clear_Selected_Document'))

CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
	'log_search_user', 'Log_seaRch_uSer', "imart_rfg")
def DBCombinationKey = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT IMFR_UD_APP_COMBINATION_KEY FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_UD_SALES_COM = '11'")
def DBClearedFlag = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT IMFR_UD_CLEARED_FLAG FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_UD_SALES_COM = '11'")
CustomKeywords.'com.database.connectSql.closeDatabaseConnection'()

CheckCombinationKey = WebUI.getAttribute(findTestObject('Object Repository/QLNV_Form/Tab3/formaAutoNo2'), "value")
println ("CheckCombinationKey: " + CheckCombinationKey)

WebUI.verifyEqual(DBClearedFlag[0][0], '1')
WebUI.verifyEqual(DBCombinationKey[0][0], CheckCombinationKey)

WebUI.closeBrowser()




