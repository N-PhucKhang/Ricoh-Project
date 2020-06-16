import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Check SUM Uncollect and Overpay'
WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev09', ('Password') : 'dev09'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(5)

WebUI.delay(2)

WebUI.click(findTestObject('QLNV_Form/Tab_6'))

WebUI.delay(3)

WebUI.click(findTestObject('QLNV_Form/Tab6/button_Tab6_Edit_Line1'))

WebUI.delay(2)

WebUI.switchToWindowIndex(1)
String insertID = WebUI.executeJavaScript("return new URL(window.location.href).searchParams.get('imfr_insert_id')", null)

println(insertID)
//def paper_no = WebUI.getAttribute(findTestObject('QLNV_Form/Tab6/input_paper_no'), 'value')

//println(paper_no.toString())

CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com', 'log_search_user', 'Log_seaRch_uSer', 'imart_rfg')
def sql = 'SELECT IMFR_UD_JOURNAL_DATE , IMFR_UD_VOUCHER_NO , IMFR_UD_PRODUCT_CD , IMFR_UD_PRODUCT_NAME , IMFR_UD_FUNC_NOW_DEBIT , IMFR_UD_FUNC_NOW_CREDIT , IMFR_UD_INQUIRY_NUMBER , IMFR_UD_SECTION_NM , IMFR_UD_APPLICATION_KEY , IMFR_UD_COUNTER_DEPT_CD , IMFR_UD_DETAIL_DESCRIPTION FROM IMFR_UT_SF_NIM008_APL001 WHERE IMFR_SD_INSERT_ID IN (' + insertID + ')'
println(sql)
def DBCombinationKey = CustomKeywords.'com.database.connectSql.executeQuery'(sql)

def count = WebUI.executeJavaScript('return $("#gtr1").getGridParam("reccount")', null, FailureHandling.STOP_ON_FAILURE)

println(count)
println(DBCombinationKey.size())
WebUI.verifyEqual(count, DBCombinationKey.size())

