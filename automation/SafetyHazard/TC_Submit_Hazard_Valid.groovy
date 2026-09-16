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
 * - Valid master data is available
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

// Open Create Hazard form
Mobile.tap(
    findTestObject('SafetyHazard/btn_CreateHazard'),
    10
)

// Select Location
Mobile.tap(
    findTestObject('SafetyHazard/ddl_Location'),
    10
)

// Select Sublocation
Mobile.tap(
    findTestObject('SafetyHazard/ddl_Sublocation'),
    10
)

// Select Area
Mobile.tap(
    findTestObject('SafetyHazard/ddl_Area'),
    10
)

// Add Evidence
Mobile.tap(
    findTestObject('SafetyHazard/img_Evidence'),
    10
)

// Verify PIC field is available
Mobile.waitForElementPresent(
    findTestObject('SafetyHazard/ddl_PIC'),
    10,
    FailureHandling.STOP_ON_FAILURE
)

// Submit Safety Hazard Report
Mobile.tap(
    findTestObject('SafetyHazard/btn_SubmitHazard'),
    10
)

// Verify submission success
Mobile.waitForElementPresent(
    findTestObject('SafetyHazard/lbl_HazardSubmitSuccess'),
    15,
    FailureHandling.STOP_ON_FAILURE
)

Mobile.comment('Safety Hazard Report submitted successfully')

// Close application
Mobile.closeApplication()
