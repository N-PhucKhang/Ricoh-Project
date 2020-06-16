import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('http://132.145.113.198/imsl/forma/normal/view/regist_application_view/sf_nim008_apl001?', FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(3)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/QLNV_Form/Tab_4'))

WebUI.delay(2)

WebUI.check(findTestObject('Object Repository/QLNV_Form/Tab4/checkbox_CheckAll'))
WebUI.delay(2)


WebUI.click(findTestObject('QLNV_Form/Tab4/button_CancellClearance'))

errMsg = WebUI.getText(findTestObject('label_errMsg'))
WebUI.verifyMatch(errMsg , "対象がありません。チェックをしてください。", true, FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

String countRows = WebUI.executeJavaScript("return \$('#gt6').jqGrid('getGridParam', 'records');", null)
println(countRows)

WebUI.verifyEqual((countRows[0])[0], '0')

WebUI.closeBrowser()