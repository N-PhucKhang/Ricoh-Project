import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('http://132.145.113.198/imsl/login', FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.clearText(findTestObject('Login/textbox_Username'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Login/textbox_Username'), 'dev09')

WebUI.setText(findTestObject('Login/textbox_Password'), 'dev09')

WebUI.click(findTestObject('Login/button_Login'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(6)
