import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.navigateToUrl('http://132.145.113.198/imsl/im_workflow/user/apply/apply_list?')
WebUI.waitForPageLoad(2)
WebUI.click(findTestObject('Form_Upload/button_into_UploadPage') 
	)
WebUI.waitForPageLoad(2)