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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001')

WebUI.click(findTestObject('Object Repository/Page_HTTP Status-code 401 Unauthorized/input__imui-large-button'))

WebUI.setText(findTestObject('Object Repository/Page_/input__im_user'), 'dev01')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_/input__im_password'), '7RsZk39x0TM=')

WebUI.click(findTestObject('Object Repository/Page_/input__imui-btn-login'))

WebUI.click(findTestObject('Object Repository/Page_/span_'))

WebUI.delay(3) 

WebUI.click(findTestObject('Object Repository/Page_/img_x_gt13_image1'))

WebUI.switchToWindowIndex(1)

String insertID = WebUI.executeJavaScript("return new URL(window.location.href).searchParams.get('imfr_insert_id')", null)

println(insertID)
CustomKeywords.'com.database.connectSql.connectDB'('132.145.123.77', '1521', 'pdborcl.rsubnet.rvcn.oraclevcn.com',
	'log_search_user', 'Log_seaRch_uSer', "imart_rfg")
def data = CustomKeywords.'com.database.connectSql.executeQuery'('SELECT IMFR_UD_CUSTOMER_NM,IMFR_UD_QA_DIV,IMFR_UD_QA_NM,IMFR_UD_QA_DATE,IMFR_UD_TO,IMFR_UD_CC,IMFR_UD_QUESTION,IMFR_UD_DETAIL,IMFR_UD_RESPONSE  FROM IMFR_UT_SF_NIM008_APL002 WHERE IMFR_SD_INSERT_ID ='+'\''+insertID+'\'')
println(data)