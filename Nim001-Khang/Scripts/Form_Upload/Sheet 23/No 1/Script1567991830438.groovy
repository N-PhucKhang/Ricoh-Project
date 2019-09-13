import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : '', ('Password') : ''])

WebUI.callTestCase(findTestCase('Sub/Into_Upload_Page'), [:])

WebUI.click(findTestObject('Form_Upload/button_AddFile' // Click button add file
        ))

WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), RunConfiguration.getProjectDir() + GlobalVariable.NoError)

WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), CustomKeywords.'com.helper.UploadFile.UpFile.getDefaultAppicationRunningPath'() + GlobalVariable.NotCSV)

WebUI.waitForPageLoad(2)

WebUI.click(findTestObject('Form_Upload/button_UpFile_Popup' // Click button upload file in popup page
        ))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Form_Upload/button_ReadFile' // Click button Read File
        ))

WebUI.delay(2)

errMsg = WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg' // Get error message
        ))

WebUI.verifyEqual(errMsg, 'CSVファイルが登録されていません' // Verify error message
    )

WebUI.delay(2)

WebUI.takeScreenshot('D:\\KatalonScreenShot\\Sheet23\\do_not_csv.png' // Take screen shot
    )

WebUI.closeBrowser( // Close browser
    )

