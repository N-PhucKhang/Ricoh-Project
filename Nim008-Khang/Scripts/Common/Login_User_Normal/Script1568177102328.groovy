import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://132.145.113.198/imsl/login', FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.clearText(findTestObject('Login/textbox_Username'), FailureHandling.STOP_ON_FAILURE)

<<<<<<< HEAD
WebUI.setEncryptedText(findTestObject('Login/textbox_Username'), 'KEwpDvWOJMU=')
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
WebUI.setText(findTestObject('Login/textbox_Username'), 'dev04')
>>>>>>> 397644d2c53a5f506c88884ec244ca680ff41db6

WebUI.setEncryptedText(findTestObject('Login/textbox_Password'), 'TTqB56UtSiQ=')

WebUI.click(findTestObject('Login/button_Login'), FailureHandling.STOP_ON_FAILURE)

<<<<<<< HEAD
WebUI.waitForPageLoad(2)
=======
WebUI.waitForPageLoad(2)
=======
<<<<<<< HEAD
>>>>>>> df1d727fc9461963b12ad4abb59f274f6f44e6c6
WebUI.setText(findTestObject('Login/textbox_Username'), 'dev06')

WebUI.setText(findTestObject('Login/textbox_Password'), 'dev06')



WebUI.click(findTestObject('Login/button_Login'), FailureHandling.STOP_ON_FAILURE)

<<<<<<< HEAD
WebUI.waitForPageLoad(2)
=======
=======
>>>>>>> a58997ba17f1cad3a6a1e7fbe1d8a1c7ef39182c
>>>>>>> 88b9425ba07835e76a5a8e740658b40bd7f02919
>>>>>>> df1d727fc9461963b12ad4abb59f274f6f44e6c6
>>>>>>> 397644d2c53a5f506c88884ec244ca680ff41db6
