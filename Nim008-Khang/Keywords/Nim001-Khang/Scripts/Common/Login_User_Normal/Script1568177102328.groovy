import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://132.145.113.198/imsl/login', FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.clearText(findTestObject('Login/textbox_Username'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Login/textbox_Username'), GlobalVariable.User)

WebUI.setText(findTestObject('Login/textbox_Password'), GlobalVariable.User)

WebUI.click(findTestObject('Login/button_Login'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(5)
