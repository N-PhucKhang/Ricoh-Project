import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Có check vào mục [MoM業務担当への連絡がチェック] và chưa nhập text ở khung [コメント]

WebUI.openBrowser('')

WebUI.navigateToUrl('http://132.145.113.198/imsl/login')

//WebUI.waitForPageLoad(10)

//WebUI.maximizeWindow()

WebUI.clearText(findTestObject('Login/textbox_Username'))

//WebUI.clearText(findTestObject('Login/textbox_Password'))

WebUI.setText(findTestObject('Login/textbox_Username'), 'dev04')

WebUI.setText(findTestObject('Login/textbox_Password'), 'dev04')

WebUI.click(findTestObject('Login/button_Login'))

WebUI.waitForPageLoad(2)

WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/apply/apply_list?')

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Form_Upload/button_into_UploadPage'))

WebUI.waitForPageLoad(2)

WebUI.check(findTestObject('Form_Upload/checkbox_MoM'))

WebUI.verifyElementChecked(findTestObject('Form_Upload/checkbox_MoM'), 30)

//WebUI.setText(findTestObject('Form_Upload/text_Area'), "khangdeptrai")

WebUI.click(findTestObject('Form_Upload/button_Apply'))

errMsg =  WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg'))

WebUI.verifyEqual(errMsg, "業務担当への 連絡内容 が入力されていません")

WebUI.waitForPageLoad(2)

WebUI.takeScreenshot('D:\\KatalonScreenShot\\Sheet20\\check_Mom.png')

WebUI.closeBrowser()