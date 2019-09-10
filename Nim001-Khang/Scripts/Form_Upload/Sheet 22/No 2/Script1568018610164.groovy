import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://132.145.113.198/imsl/login')   // Open IM

WebUI.clearText(findTestObject('Login/textbox_Username'))  // Clear textbox user

WebUI.setText(findTestObject('Login/textbox_Username'), 'dev09')  // Input user

WebUI.setText(findTestObject('Login/textbox_Password'), 'dev09')  // Input password

WebUI.click(findTestObject('Login/button_Login'))   // Click button login

WebUI.waitForPageLoad(2)

WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/process/process_list')

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Object Repository/Form_Upload/button_into_ApprovePage'))

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Object Repository/Form_Upload/button_Approve'))
WebUI.delay(2)

WebUI.switchToFrame(findTestObject('Form_Upload/Frame1'), 2)
WebUI.switchToFrame(findTestObject('Form_Upload/Frame2'), 2)
WebUI.switchToFrame(findTestObject('Form_Upload/Frame3'), 2)

int updatekubun = 3;
for (int i = 1; i <= updatekubun; i++) {
		//sql
		def connect = CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
			'log_search_user', 'Log_seaRch_uSer', "imart_rfg")
		def recordset = CustomKeywords.'com.database.connectSql.executeQuery'("update IMFR_UT_SF_NIM001_APL002 set IMFR_UD_TANKA_TEKIYO_DATE = TO_DATE('2019/09/09','yyyy/MM/dd') where IMFR_SD_INSERT_ID = '8fbl8qi8zxe6tff'")
		def recordset1 = CustomKeywords.'com.database.connectSql.executeQuery'("update IMFR_UT_SF_NIM001_APL002_TB1 set  IMFR_UD_TB1_UPDATE_KUBUN = '" + i + "' ,IMFR_UD_TB1_JYORYO_SYS_CODE = '13311111116' where IMFR_SD_INSERT_ID = '8fbl8qi8zxe6tff'")
		CustomKeywords.'com.database.connectSql.closeDatabaseConnection'()
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Form_Upload/button_Approval_Process'))
		WebUI.delay(2)
		
		WebUI.click(findTestObject('Object Repository/Form_Upload/button_ApplyPopup'))
		WebUI.delay(2)
		WebUI.takeScreenshot('D:\\KatalonScreenShot\\Sheet22\\No2-' + i + '.png') // Take screen shot
		WebUI.delay(2)
		errMsg = WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg_Approve'))
		WebUI.verifyMatch(errMsg, '処理に失敗しました。 上流システムコードに登録されていないコードが設定されています。差戻してください。', false)
		WebUI.delay(4)
	}
WebUI.closeBrowser()