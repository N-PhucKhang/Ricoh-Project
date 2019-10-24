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

def paper_no = WebUI.getAttribute(findTestObject('QLNV_Form/Tab6/input_paper_no'), 'value')
//
println(paper_no.toString())

CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com', 'log_search_user', 'Log_seaRch_uSer', 'imart_rfg')
def sql = 'SELECT imfr_ud_journal_date , imfr_ud_voucher_no , imfr_ud_product_cd , imfr_ud_product_name , imfr_ud_uncollected , imfr_ud_overpayment , imfr_ud_inquiry_number , imfr_ud_section_nm , imfr_ud_application_key , imfr_ud_counter_dept_cd , imfr_ud_detail_description FROM imfr_ut_sf_nim008_apl001 WHERE imfr_sd_insert_id IN (' + paper_no + ')'
println(sql)
def DBCombinationKey = CustomKeywords.'com.database.connectSql.executeQuery'(sql)

def count = WebUI.executeJavaScript('return $("#gtr1").getGridParam("reccount")', null, FailureHandling.STOP_ON_FAILURE)

println(count)
println(DBCombinationKey.size())
WebUI.verifyEqual(count, DBCombinationKey.size())

