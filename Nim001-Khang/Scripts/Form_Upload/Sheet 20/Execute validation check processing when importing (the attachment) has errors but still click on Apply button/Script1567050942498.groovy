import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String Folder_Url = RunConfiguration.getProjectDir().replace('/', '\\')

// Thực thi xử lý validation check khi import (file đính kèm) có error nhưng vẫn click vào button [申請]
WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Sub/Into_Upload_Page'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Form_Upload/button_AddFile') // Click button add file
    )
WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), Folder_Url + GlobalVariable.No2 , FailureHandling.CONTINUE_ON_FAILURE// Up file error.csv
    )
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject('Form_Upload/button_UpFile_Popup') // Click button upload file in popup page
    )
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/Form_Upload/button_ReadFile') // Click button ReadFile
    )
WebUI.delay(2)
WebUI.click(findTestObject('Form_Upload/button_Apply') // Click button Apply
    )
errMsg = WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg') // Get error message
    )
WebUI.verifyEqual(errMsg, '読み込み結果確認ボタンを押してCSVファイルチェックを行い、エラーを再確認してください。', FailureHandling.CONTINUE_ON_FAILURE // Verify error message
    )
WebUI.closeBrowser()

