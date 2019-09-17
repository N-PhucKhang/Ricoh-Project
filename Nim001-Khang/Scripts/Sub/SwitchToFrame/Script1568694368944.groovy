import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.switchToFrame(findTestObject('Form_Upload/Frame1'), 2)
WebUI.switchToFrame(findTestObject('Form_Upload/Frame2'), 2)
WebUI.switchToFrame(findTestObject('Form_Upload/Frame3'), 2)