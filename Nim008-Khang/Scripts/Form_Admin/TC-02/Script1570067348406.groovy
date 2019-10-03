import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def connect = CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
	'log_search_user', 'Log_seaRch_uSer', "imart_rfg")


def recordset = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT")

//while (recordset.next()) {
//	String value = recordset.getObject("IMFR_SD_INSERT_ID")
//	System.out.println(value);
//}

CustomKeywords.'com.database.connectSql.closeDatabaseConnection'()


//WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)

//WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl003?', FailureHandling.STOP_ON_FAILURE)

//WebUI.waitForPageLoad(3)

//WebUI.delay(3)

//WebUI.setText(findTestObject('Object Repository/Admin_Form/textarea_Content'), 'abcd')

//WebUI.click(findTestObject('Object Repository/Admin_Form/button_DangKi_Content'))

//WebUI.delay(2)

//WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl003?', FailureHandling.STOP_ON_FAILURE)

//a = WebUI.getText(findTestObject('Object Repository/Admin_Form/textarea_Content_Header'))


//WebUI.closeBrowser()