import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling

/*
 * Test Case   : TC_SignIn_Valid
 * Scenario    : Sign In with valid user
 * Type        : Positive
 * Priority    : Critical
 *
 * Precondition:
 * - WeMine application is installed
 * - User has valid credentials
 * - User is on the Sign In page
 */

Mobile.comment('Start Test Case: Sign In with valid user')

// Start WeMine application
Mobile.startApplication('PATH_TO_WEMINE_APK', false)

// Wait until Sign In page is displayed
Mobile.waitForElementPresent(
    findTestObject('SignIn/txt_Username'),
    10,
    FailureHandling.STOP_ON_FAILURE
)

// Enter valid username
Mobile.setText(
    findTestObject('SignIn/txt_Username'),
    'VALID_USERNAME',
    10
)

// Tap Continue / Sign In button
Mobile.tap(
    findTestObject('SignIn/btn_SignIn'),
    10
)

// Wait for Microsoft Login page
Mobile.waitForElementPresent(
    findTestObject('SignIn/txt_MicrosoftPassword'),
    10
)

// Enter valid password
Mobile.setText(
    findTestObject('SignIn/txt_MicrosoftPassword'),
    'VALID_PASSWORD',
    10
)

// Tap Sign In
Mobile.tap(
    findTestObject('SignIn/btn_MicrosoftSignIn'),
    10
)

// Verify user successfully signs in
Mobile.waitForElementPresent(
    findTestObject('Home/lbl_Home'),
    30,
    FailureHandling.STOP_ON_FAILURE
)

Mobile.comment('User successfully signed in to WeMine')

// Close application
Mobile.closeApplication()
