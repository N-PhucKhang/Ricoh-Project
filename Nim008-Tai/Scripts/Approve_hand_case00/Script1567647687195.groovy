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

WebUI.openBrowser('http://132.145.113.198/imsl/login?')

WebUI.setText(findTestObject('test/username'), 'dev09')

WebUI.setText(findTestObject('test/password'), 'dev09')

WebUI.click(findTestObject('test/button'))

WebUI.waitForPageLoad(5)

WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/process/process_list')

WebUI.click(findTestObject('approveHand_case01/click_icon_record'))

WebUI.click(findTestObject('approveHand_case01/onclick_approve1'))

WebUI.switchToFrame(findTestObject('approveHand_case01/frame1'), 5)

WebUI.switchToFrame(findTestObject('approveHand_case01/frame2'), 2)

WebUI.switchToFrame(findTestObject('approveHand_case01/frame3'), 2)

WebUI.click(findTestObject('approveHand_case01/onclick_approve2'))

WebUI.click(findTestObject('approveHand_case01/onclick_ok'))

WebUI.delay(2)

errMsg = WebUI.getText(findTestObject('Object Repository/approveHand_case01/text_check'))

if (errMsg.contains('取引停止の取引先情報は差戻してください。')) {
    WebUI.takeScreenshot('E:\\case00.png')
} 
else if (errMsg.contains('単価適用日 に土曜日、日曜日が設定されています。差戻してください。')) {
    WebUI.takeScreenshot('E:\\case01.png')
}
else if (errMsg.contains('単価適用日 に祝日、休日が設定されています。差戻してください。')) {
    WebUI.takeScreenshot('E:\\case02.png')
}
else if (errMsg.contains('同一商品が複数指定されています。差戻してください。商品CD:')) {
    WebUI.takeScreenshot('E:\\case03.png')
}
else if (errMsg.contains('既に登録されている商品が、追加登録に指定されています。差戻してください。登録')) {
    WebUI.takeScreenshot('E:\\case04.png')
}
else if (errMsg.contains('不適切な商品コード、追加登録に指定されています。差戻してください。登録')) {
    WebUI.takeScreenshot('E:\\case05.png')
}
else if (errMsg.contains('は承認できません。差戻してください。登録')) {
    WebUI.takeScreenshot('E:\\case06.png')
}
else if (errMsg.contains('は承認できません。差戻してください。更新')) {
    WebUI.takeScreenshot('E:\\case07.png')
}
else if (errMsg.contains('登録されていない商品が、更新に指定されています。差戻してください。更新')) {
    WebUI.takeScreenshot('E:\\case08.png')
}
else if (errMsg.contains('は承認できません。差戻してください。削除')) {
    WebUI.takeScreenshot('E:\\case09.png')
}
else if (errMsg.contains('登録されていない商品が、削除に指定されています。差戻してください。削除')) {
    WebUI.takeScreenshot('E:\\case10.png')
}
else if (errMsg.contains('2. 業務区承認を中断し、重複申請の文書を確認する')) {
	WebUI.takeScreenshot('E:\\case11.png')
}
else {
    WebUI.closeBrowser()
}

