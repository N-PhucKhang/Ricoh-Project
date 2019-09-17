import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://132.145.113.198/imsl/login?')

WebUI.setText(findTestObject('test/username'), 'dev09')

WebUI.setText(findTestObject('test/password'), 'dev09')

WebUI.click(findTestObject('test/button'))

WebUI.waitForPageLoad(5)

WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/process/process_list')

WebUI.click(findTestObject('approveFileUp_case01/onclick_icon_file'))

WebUI.click(findTestObject('approveFileUp_case01/onclick_approve1'))

WebUI.switchToFrame(findTestObject('approveHand_case01/frame1'), 5)

WebUI.switchToFrame(findTestObject('approveHand_case01/frame2'), 2)

WebUI.switchToFrame(findTestObject('approveHand_case01/frame3'), 2)

WebUI.click(findTestObject('approveHand_case01/onclick_approve2'))

WebUI.click(findTestObject('approveHand_case01/onclick_ok'))

WebUI.delay(2)

errMsg = WebUI.getText(findTestObject('Object Repository/approveHand_case01/text_check'))

if (errMsg.contains('単価適用日に祝日、休日が設定されています。差戻してください。')) {
    WebUI.takeScreenshot('E:\\casef0.png')
} else if (errMsg.contains('上流システムコードに登録されていないコードが設定されています。差戻してください。')) {
    WebUI.takeScreenshot('E:\\casef1.png')
} else if (errMsg.contains('上流システムコードが取引停止になっています。差戻してください。')) {
    WebUI.takeScreenshot('E:\\casef2.png')
} else if (errMsg.contains('商品コードに登録されていないコードが設定されています。差戻してください。')) {
    WebUI.takeScreenshot('E:\\casef3.png')
} else if (errMsg.contains('MoM顧客別単価マスタに登録済みコードが設定されています。差戻してください。')) {
    WebUI.takeScreenshot('E:\\casef4.png')
} else if (errMsg.contains('MoM顧客別単価マスタに登録されていないコードが設定されています。差戻してください。')) {
    WebUI.takeScreenshot('E:\\casef5.png')
} else if (errMsg.contains('統一仕切未満です。差戻してください。')) {
    WebUI.takeScreenshot('E:\\casef6.png')
} else {
    WebUI.closeBrowser()
}

