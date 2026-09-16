import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable

/*
 * Test Case : TC_Submit_Hazard_Valid
 * Scenario  : Submit Safety Hazard Report with valid mandatory data
 *
 * Precondition:
 * - WeMine application is installed
 * - User has successfully signed in
 * - User has access to Safety Hazard Report
 */

Mobile.comment('Start Safety Hazard Report test')

// Start application
Mobile.startApplication(GlobalVariable.APP_PATH, false)

// Wait for Create Hazard button
Mobile.waitForElementPresent(
    findTestObject('SafetyHazard/btn_CreateHazard'),
    10,
    FailureHandling.STOP_ON_FAILURE
)

// Tap Create Hazard
Mobile.tap(
    findTestObject('SafetyHazard/btn_CreateHazard'),
    10
)

// Input Hazard Description
Mobile.setText(
    findTestObject('SafetyHazard/txt_HazardDescription'),
    'Oil spill found on the workshop floor',
    10
)

// Tap Submit
Mobile.tap(
    findTestObject('SafetyHazard/btn_SubmitHazard'),
    10
)

// Verify Hazard Report submitted successfully
Mobile.waitForElementPresent(
    findTestObject('SafetyHazard/lbl_HazardSubmitSuccess'),
    15,
    FailureHandling.STOP_ON_FAILURE
)

Mobile.comment('Safety Hazard Report submitted successfully')

// Close application
Mobile.closeApplication()
