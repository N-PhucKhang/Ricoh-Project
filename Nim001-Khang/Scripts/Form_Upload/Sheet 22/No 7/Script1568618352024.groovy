import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

"Update record by sql"
def connect = CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
	'log_search_user', 'Log_seaRch_uSer', 'imart_rfg')
def recordset = CustomKeywords.'com.database.connectSql.executeQuery'('update IMFR_UT_SF_NIM001_APL002 set IMFR_UD_TANKA_TEKIYO_DATE = TO_DATE(\'2019/09/09\',\'yyyy/MM/dd\') where IMFR_SD_INSERT_ID = ' + '\'' + GlobalVariable.insert_ID + '\'')
def recordset1 = CustomKeywords.'com.database.connectSql.executeQuery'('update IMFR_UT_SS_AP0033_APL000 set IMFR_UD_TOITSU_SIKIRI_KAKAKU  = \'5000\' where IMFR_SD_INSERT_ID = \'10\'')
def recordset2 = CustomKeywords.'com.database.connectSql.executeQuery'('update IMFR_UT_SF_NIM001_APL002_TB1 set IMFR_UD_TB1_SHOHIN_CODE = \'A00003\' ,  IMFR_UD_TB1_UPDATE_KUBUN =  \'2\', IMFR_UD_TB1_SHIN_TANKA  = \'3000\' where IMFR_SD_INSERT_ID =' + '\'' + GlobalVariable.insert_ID + '\'')

"Login Intra_mart"
WebUI.callTestCase(findTestCase('Common/Login_User_Admin'), [:], FailureHandling.STOP_ON_FAILURE)
"Into URL approve page"
WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/process/process_list')
WebUI.waitForPageLoad(2)
"Into approve page"
WebUI.click(findTestObject('Object Repository/Form_Upload/button_into_ApprovePage'))
WebUI.waitForPageLoad(2)
"Click button Approve"
WebUI.click(findTestObject('Object Repository/Form_Upload/button_Approve'))
WebUI.delay(2)
"Switch to Frame"
WebUI.callTestCase(findTestCase('Sub/SwitchToFrame'), [:], FailureHandling.STOP_ON_FAILURE)
"Click button Approval_Process"
WebUI.click(findTestObject('Object Repository/Form_Upload/button_Approval_Process'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/Form_Upload/button_ApplyPopup'))
"Verify Error Msg"
errMsg = WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg_Approve'))
WebUI.verifyMatch(errMsg, '処理に失敗しました。 統一仕切未満です。差戻してください。', false, FailureHandling.CONTINUE_ON_FAILURE)

def recordset3 = CustomKeywords.'com.database.connectSql.executeQuery'('update IMFR_UT_SS_AP0033_APL000 set IMFR_UD_TOITSU_SIKIRI_KAKAKU  = \'\' where IMFR_SD_INSERT_ID = \'10\'')
def recordset4 = CustomKeywords.'com.database.connectSql.executeQuery'('update IMFR_UT_SF_NIM001_APL002_TB1 set IMFR_UD_TB1_SHIN_TANKA  = \'\' where IMFR_SD_INSERT_ID =' + '\'' + GlobalVariable.insert_ID + '\'')
CustomKeywords.'com.database.connectSql.closeDatabaseConnection'()
"Close browse"
WebUI.closeBrowser()

