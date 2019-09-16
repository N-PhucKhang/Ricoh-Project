import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.callTestCase(findTestCase('Common/Login_User_Admin'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/process/process_list')
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject('Object Repository/Form_Upload/button_into_ApprovePage'))
WebUI.waitForPageLoad(2)

int updatekubun = 3
for (int i = 2; i <= updatekubun; i++) {
	//sql
	def connect = CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
		'log_search_user', 'Log_seaRch_uSer', 'imart_rfg')
	def recordset = CustomKeywords.'com.database.connectSql.executeQuery'('update IMFR_UT_SF_NIM001_APL002 set IMFR_UD_TANKA_TEKIYO_DATE = TO_DATE(\'2019/09/09\',\'yyyy/MM/dd\') where IMFR_SD_INSERT_ID =' + '\'' + GlobalVariable.insert_ID + '\'')
	def recordset1 = CustomKeywords.'com.database.connectSql.executeQuery'(('update IMFR_UT_SF_NIM001_APL002_TB1 set  IMFR_UD_TB1_UPDATE_KUBUN = \'' +
		i) + '\' ,IMFR_UD_TB1_JYORYO_SYS_CODE = \'11111111116\', IMFR_UD_TB1_SHOHIN_CODE = \'A00113\' where IMFR_SD_INSERT_ID =' + '\'' + GlobalVariable.insert_ID + '\'')
	CustomKeywords.'com.database.connectSql.closeDatabaseConnection'()
	WebUI.switchToWindowIndex(0)
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Form_Upload/button_Approve'))
	WebUI.delay(2)
	WebUI.switchToFrame(findTestObject('Form_Upload/Frame1'), 2)
	WebUI.switchToFrame(findTestObject('Form_Upload/Frame2'), 2)
	WebUI.switchToFrame(findTestObject('Form_Upload/Frame3'), 2)
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Form_Upload/button_Approval_Process'))
	WebUI.click(findTestObject('Object Repository/Form_Upload/button_ApplyPopup'))
	WebUI.delay(2)
	errMsg1 = WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg_Approve'))
	WebUI.verifyMatch(errMsg1, '処理に失敗しました。 MoM顧客別単価マスタに登録されていないコードが設定されています。差戻してください。', true, FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Form_Upload/button_ClosePopup'))
	WebUI.delay(2)
}
WebUI.closeBrowser()