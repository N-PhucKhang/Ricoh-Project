import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Check update CombinationKey and ClearedFlag'
WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/Insert_Data_Test'), [:], FailureHandling.STOP_ON_FAILURE)

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

WebUI.check(findTestObject('QLNV_Form/Tab3/checkbox_Line1_GridTable'))

WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab3/button_Tab3_Clear_Selected_Document'))

CheckCombinationKey = WebUI.getAttribute(findTestObject('Object Repository/QLNV_Form/Tab3/formaAutoNo2'), 'value')

println('CheckCombinationKey: ' + CheckCombinationKey)

def ParamCombinationKey = CustomKeywords.'com.helpers.Tab2Helpers.convert'(CheckCombinationKey)

println('ParamCombinationKey: ' + ParamCombinationKey)

CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com', 'log_search_user', 
    'Log_seaRch_uSer', 'imart_rfg')

String sqlCombinationKey = 'SELECT IMFR_UD_APP_COMBINATION_KEY FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_UD_APP_COMBINATION_KEY IN ' + 
ParamCombinationKey

def DBCombinationKey = CustomKeywords.'com.database.connectSql.executeQuery'(sqlCombinationKey)

println(DBCombinationKey)

String sqlClearedFlag = 'SELECT IMFR_UD_CLEARED_FLAG FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_UD_APP_COMBINATION_KEY IN ' + 
ParamCombinationKey

def DBClearedFlag = CustomKeywords.'com.database.connectSql.executeQuery'(sqlClearedFlag)

println(DBClearedFlag)

CustomKeywords.'com.database.connectSql.closeDatabaseConnection'()

WebUI.verifyEqual((DBCombinationKey[0])[0], CheckCombinationKey)

WebUI.verifyEqual((DBClearedFlag[0])[0], '1')

WebUI.closeBrowser()

