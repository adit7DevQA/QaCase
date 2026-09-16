import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable

/*
 * Test Case : TC_SignIn_Valid
 * Scenario  : Sign In with valid user
 *
 * Precondition:
 * - WeMine application is installed
 * - Valid test credentials are available
 */

Mobile.comment('Start Sign In test')

// Start application
Mobile.startApplication(GlobalVariable.APP_PATH, false)

// Wait for Sign In page
Mobile.waitForElementPresent(
    findTestObject('SignIn/txt_Username'),
    10,
    FailureHandling.STOP_ON_FAILURE
)

// Input username
Mobile.setText(
    findTestObject('SignIn/txt_Username'),
    GlobalVariable.USERNAME,
    10
)

// Tap Sign In
Mobile.tap(
    findTestObject('SignIn/btn_SignIn'),
    10
)

// Wait for Microsoft authentication page
Mobile.waitForElementPresent(
    findTestObject('SignIn/txt_MicrosoftPassword'),
    10,
    FailureHandling.STOP_ON_FAILURE
)

// Input password
Mobile.setText(
    findTestObject('SignIn/txt_MicrosoftPassword'),
    GlobalVariable.PASSWORD,
    10
)

// Tap Microsoft Sign In
Mobile.tap(
    findTestObject('SignIn/btn_MicrosoftSignIn'),
    10
)

// Verify Home page is displayed
Mobile.waitForElementPresent(
    findTestObject('Home/lbl_Home'),
    30,
    FailureHandling.STOP_ON_FAILURE
)

Mobile.comment('Sign In successful')

// Close application
Mobile.closeApplication()
