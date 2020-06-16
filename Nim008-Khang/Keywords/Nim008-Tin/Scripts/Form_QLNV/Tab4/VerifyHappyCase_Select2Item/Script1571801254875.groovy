import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

"Check update CombinationKey and ClearedFlag"

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)
WebUI.waitForPageLoad(3)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab_4'))
WebUI.delay(2)

WebUI.check(findTestObject('QLNV_Form/Tab4/checkbox_CheckAll'))
WebUI.click(findTestObject('QLNV_Form/Tab4/button_CancellClearance'))

CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
	'log_search_user', 'Log_seaRch_uSer', "imart_rfg")
def DBCombinationKey = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT IMFR_UD_APP_COMBINATION_KEY FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_UD_SALES_COM = '11'")
def DBClearedFlag = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT IMFR_UD_CLEARED_FLAG FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_UD_SALES_COM = '11'")
CustomKeywords.'com.database.connectSql.closeDatabaseConnection'()

WebUI.verifyEqual(DBClearedFlag[0][0], '0')
WebUI.verifyEqual(DBCombinationKey[0][0], null)

WebUI.closeBrowser()