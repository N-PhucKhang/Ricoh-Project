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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev09', ('Password') : 'dev09'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForJQueryLoad(5)

WebUI.click(findTestObject('QLNV_Form/Tab_4'))

WebUI.waitForJQueryLoad(5)

String countRows1 = WebUI.executeJavaScript("return \$('#gt6').jqGrid('getGridParam', 'records');", null)

WebUI.click(findTestObject('QLNV_Form/Tab_3'))

WebUI.waitForJQueryLoad(5)

WebUI.click(findTestObject('QLNV_Form/Tab_4'))

WebUI.waitForJQueryLoad(5)

String countRows2 = WebUI.executeJavaScript("return \$('#gt6').jqGrid('getGridParam', 'records');", null)

WebUI.verifyMatch((countRows1[0])[0], (countRows2[0])[0], true, FailureHandling.STOP_ON_FAILURE)
