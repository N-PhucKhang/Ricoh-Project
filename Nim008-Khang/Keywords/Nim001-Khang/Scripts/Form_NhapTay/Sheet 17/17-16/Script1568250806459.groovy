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

WebUI.navigateToUrl('http://132.145.113.198/imsl/login' // Open IM
    )

WebUI.waitForPageLoad(2)

WebUI.clearText(findTestObject('Login/textbox_Username' // Clear textbox user
        ))

WebUI.setText(findTestObject('Login/textbox_Username'), GlobalVariable.username // Input user
    )

WebUI.setText(findTestObject('Login/textbox_Password'), GlobalVariable.pass // Input password
    // Input password
    )

WebUI.click(findTestObject('Login/button_Login' // Click button login
        ))

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

WebUI.delay(10)

for (int j = 0; j <= 120; j++) {
    if (WebUI.waitForElementNotPresent(findTestObject('Object Repository/Form_NhapTay/checkbox_Update'), 5) == false) {
        WebUI.waitForPageLoad(60)

        WebUI.waitForElementPresent(findTestObject('Form_NhapTay/btnUpdate'), 60)

        WebUI.waitForElementVisible(findTestObject('Form_NhapTay/btnUpdate'), 60)

        WebUI.waitForElementClickable(findTestObject('Form_NhapTay/btnUpdate'), 60)

        WebUI.click(findTestObject('Form_NhapTay/btnUpdate'))

        break
    } else {
        WebUI.comment('Button is still not ready. Wait.')

        WebUI.delay(1)
    }
}

WebUI.click(findTestObject('Form_NhapTay/btnDelete'))

WebUI.click(findTestObject('Form_NhapTay/btnAddGridInsert'))

WebUI.click(findTestObject('Form_NhapTay/clickshohinCDRow1'))

WebUI.click(findTestObject('Form_NhapTay/findShohinCDRow1'))

WebUI.click(findTestObject('Form_NhapTay/choose_shohin_0002'))

WebUI.click(findTestObject('Form_NhapTay/newtanka_valueRow1'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Form_NhapTay/newtankaValueRow1'), '100')

WebUI.click(findTestObject('Form_NhapTay/clickNewShohinCD'))

WebUI.setText(findTestObject('Form_NhapTay/settext_newShohinCD'), '1000')

WebUI.click(findTestObject('Object Repository/Form_NhapTay/btnApply'))

WebUI.takeScreenshot('D:\\KatalonScreenShot\\Sheet17\\Sheet17_No16.png')

