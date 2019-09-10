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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://132.145.113.198/imsl/login')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Login/textbox_Username'), 'dev06')

WebUI.setText(findTestObject('Object Repository/Login/textbox_Password'), 'dev06')

WebUI.click(findTestObject('Login/button_Login'))

WebUI.waitForPageLoad(2)

WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/apply/apply_list?' // Go to URL
    )

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Object Repository/Form_NhapTay/button_into_NhapTayPage'))

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Object Repository/Form_NhapTay/search_CustomerCode'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Form_NhapTay/choose_CustomerCode'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Form_NhapTay/button_Next'))

WebUI.waitForPageLoad(2)

for (int j = 0; j <= 120; j++) {
    if (WebUI.waitForElementNotPresent(findTestObject('Object Repository/Form_NhapTay/btnInsert'), 5) == false) {
        WebUI.waitForPageLoad(60)

        WebUI.waitForElementPresent(findTestObject('Form_NhapTay/btnInsert'), 60)

        WebUI.waitForElementVisible(findTestObject('Form_NhapTay/btnInsert'), 60)

        WebUI.waitForElementClickable(findTestObject('Form_NhapTay/btnInsert'), 60)

        WebUI.click(findTestObject('Form_NhapTay/btnInsert'))

        break
    } else {
        WebUI.comment('Button is still not ready. Wait.')

        WebUI.delay(1)
    }
}

WebUI.click(findTestObject('Form_NhapTay/btnUpdate'))

WebUI.click(findTestObject('Form_NhapTay/btnDelete'))

WebUI.click(findTestObject('Form_NhapTay/btnApply'))

WebUI.takeScreenshot('D:\\KatalonScreenShot\\Sheet17\\Sheet17_No2.png')

