import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable

/*
 * Test Case : TC_SignIn_Invalid
 * Scenario  : Sign In with invalid password
 *
 * Precondition:
 * - WeMine application is installed
 * - Valid username is available
 */

Mobile.comment('Start invalid Sign In test')

// Start application
Mobile.startApplication(GlobalVariable.APP_PATH, false)

// Wait for Sign In page
Mobile.waitForElementPresent(
    findTestObject('SignIn/txt_Username'),
    10,
    FailureHandling.STOP_ON_FAILURE
)

// Input valid username
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

// Input invalid password
Mobile.setText(
    findTestObject('SignIn/txt_MicrosoftPassword'),
    'INVALID_PASSWORD',
    10
)

// Tap Microsoft Sign In
Mobile.tap(
    findTestObject('SignIn/btn_MicrosoftSignIn'),
    10
)

// Verify invalid credential error is displayed
Mobile.waitForElementPresent(
    findTestObject('SignIn/lbl_InvalidCredentialError'),
    10,
    FailureHandling.STOP_ON_FAILURE
)

Mobile.comment('Invalid credential error displayed as expected')

// Close application
Mobile.closeApplication()
