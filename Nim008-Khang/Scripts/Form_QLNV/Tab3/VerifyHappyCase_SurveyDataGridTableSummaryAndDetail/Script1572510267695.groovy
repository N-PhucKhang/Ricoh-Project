import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration
WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)
WebUI.waitForPageLoad(6)
WebUI.delay(3)
WebUI.click(findTestObject('QLNV_Form/Tab_3'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab3/button_Product'))
WebUI.switchToWindowIndex(1)
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab3/checkbox_Popup_CheckAll_Product'))
WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab3/button_Popup_Choose'))
WebUI.switchToWindowIndex(0)

CountProduct = WebUI.getText(findTestObject('QLNV_Form/product_count'))
CountProduct = CountProduct.replace(',','')
println(CountProduct)

SumNowDebit = WebUI.getText(findTestObject('QLNV_Form/colum2_num'))
SumNowDebit = SumNowDebit.replace(',','')
println(SumNowDebit)

SumNowCredit = WebUI.getText(findTestObject('QLNV_Form/colum3_num'))
SumNowCredit = SumNowCredit.replace(',','')
println(SumNowCredit)

SumAmountOfMoney = WebUI.getText(findTestObject('QLNV_Form/colum4_num'))
SumAmountOfMoney = SumAmountOfMoney.replace(',','')
println(SumAmountOfMoney)

CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
	'log_search_user', 'Log_seaRch_uSer', "imart_rfg")

def DBCountProduct = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT COUNT(*) FROM IMFR_UT_SF_NIM008_APL001")
println(DBCountProduct[0][0])

def DBSumNowDebit = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT SUM(IMFR_UD_FUNC_NOW_DEBIT) from IMFR_UT_SF_NIM008_APL001")
println(DBSumNowDebit[0][0])

def DBSumNowCredit = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT SUM(IMFR_UD_FUNC_NOW_CREDIT) from IMFR_UT_SF_NIM008_APL001")
println(DBSumNowCredit[0][0])

def DBSumAmountOfMoney = CustomKeywords.'com.database.connectSql.executeQuery'("SELECT SUM(IMFR_UD_AMOUNT_OF_MONEY) from IMFR_UT_SF_NIM008_APL001")
println(DBSumAmountOfMoney[0][0])

CustomKeywords.'com.database.connectSql.closeDatabaseConnection'()

WebUI.verifyEqual(CountProduct, DBCountProduct[0][0])
WebUI.verifyEqual(SumNowDebit, DBSumNowDebit[0][0])
WebUI.verifyEqual(SumNowCredit, DBSumNowCredit[0][0])
WebUI.verifyEqual(SumAmountOfMoney, DBSumAmountOfMoney[0][0])

WebUI.closeBrowser()