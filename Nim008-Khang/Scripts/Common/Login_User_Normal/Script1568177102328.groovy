import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://132.145.113.198/imsl/login', FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.clearText(findTestObject('Login/textbox_Username'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Login/textbox_Username'), 'dev04')

WebUI.setEncryptedText(findTestObject('Login/textbox_Password'), 'TTqB56UtSiQ=')

WebUI.click(findTestObject('Login/button_Login'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(2)
<<<<<<< HEAD
WebUI.setText(findTestObject('Login/textbox_Username'), 'dev06')

WebUI.setText(findTestObject('Login/textbox_Password'), 'dev06')



WebUI.click(findTestObject('Login/button_Login'), FailureHandling.STOP_ON_FAILURE)


WebUI.waitForPageLoad(2)
=======
>>>>>>> 9d7a52bf00e226bd309c91fc113e56a573498793
