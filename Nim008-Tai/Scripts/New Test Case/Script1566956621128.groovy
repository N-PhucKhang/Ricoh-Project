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

WebUI.click(findTestObject('test/hand_input'))

WebUI.click(findTestObject('test/click_search_icon'))

WebUI.click(findTestObject('test/click_showbox'))

WebUI.click(findTestObject('test/show_imdata'))

WebUI.click(findTestObject('test/click_update_checkbox'))

WebUI.click(findTestObject('test/click_delete_checkbox'))

WebUI.click(findTestObject('test/click_add_insert_record'))

WebUI.click(findTestObject('test/click_before_click_search_inert'))

WebUI.click(findTestObject('test/click_serch_data_insert'))

WebUI.click(findTestObject('test/select_data_insert_showbox'))

WebUI.click(findTestObject('test/click_regisbutton'))

