import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

String Folder_Url = RunConfiguration.getProjectDir().replace('/', '\\')

//Xử lý validation check khi import (file đính kèm) do thao tác ấn button [ファイル読み込み] chưa được thực thi
//Sau khi thêm file file CSV đính kèm mà chưa ấn button「ファイル読み込み」（bao gồm cả trường hợp xóa file và add lại file）
WebUI.callTestCase(findTestCase('Common/Login_User_Normal'), [('Username') : 'dev04', ('Password') : 'dev04'], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Sub/Into_Upload_Page'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Form_Upload/button_AddFile') // Click button add file
    )
WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), Folder_Url + GlobalVariable.No2 // Up file khang38.csv
    )
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject('Form_Upload/button_UpFile_Popup') // Click button upload file in popup page
    )
WebUI.delay(2)
WebUI.click(findTestObject('Form_Upload/button_Apply') // Click button Apply
    )
WebUI.delay(1)
errMsg = WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg') // Get error message
    )
WebUI.verifyEqual(errMsg, '添付ファイルを追加後にファイル読み込みボタンを押していません。ファイル読み込みボタンを押してCSVファイルチェックを行ってください' // Verify error message
    )
WebUI.click(findTestObject('Object Repository/Form_Upload/button_ReadFile') // Click button ReadFile
    )
WebUI.delay(2)
WebUI.click(findTestObject('Form_Upload/button_AddFile') // Click button Add File
    )
WebUI.setText(findTestObject('Form_Upload/button_AddFile_Popup'), Folder_Url + GlobalVariable.NoError // Up file no_error.csv
    )
WebUI.delay(2)
WebUI.click(findTestObject('Form_Upload/button_UpFile_Popup') // Click button upload file in popup page
    )
WebUI.delay(2)
WebUI.click(findTestObject('Form_Upload/button_Apply') // Click button Apply
    )
WebUI.delay(1)
errMsg = WebUI.getText(findTestObject('Object Repository/Form_Upload/label_errMsg') // Get error message
    )
WebUI.verifyEqual(errMsg, '添付ファイルが編集されています。一括更新データ確認 を行ってください' // Verify error message
    )
WebUI.closeBrowser( // Close browser
    )

