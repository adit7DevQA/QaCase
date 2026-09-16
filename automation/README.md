# WeMine Test Automation

This directory contains the proposed test automation implementation for the WeMine application.

## Automation Tool

The automation tool selected for this project is **Katalon Studio**.

Katalon Studio is selected because it supports both Mobile Application and API testing in one platform. This is suitable for WeMine because the application contains mobile user flows and several backend services that need to be validated.

Katalon Studio also provides built-in keywords for Mobile and API testing, which makes the automation implementation easier to create, maintain, and execute.

## Why Katalon Studio

Katalon Studio is selected for the following reasons:

- Supports Android and iOS mobile automation.
- Supports REST API testing.
- Provides built-in keywords for common automation actions.
- Supports reusable Test Cases and Test Objects.
- Supports test data management.
- Provides test execution reports.
- Can organize multiple test cases using Test Suites.
- Suitable for regression testing and repetitive test scenarios.
- Can be integrated with CI/CD pipelines.

## Automated Flows

The automation implementation focuses on the following important flows:

1. Sign In
2. Equipment Inspection
3. Safety Hazard Report

### Sign In

Automation can be used to validate important Sign In scenarios such as:

- Sign in with valid credentials.
- Sign in with invalid credentials.
- Validate user profile retrieval.
- Validate tenant master data download.
- Validate initial master data download.

### Equipment Inspection

Automation can be used to validate:

- Open Equipment Inspection.
- Display previous inspection submissions.
- Open a new inspection form.
- Load dynamic fields based on Form Code.
- Fill and submit the inspection form.

### Safety Hazard Report

Automation can be used to validate:

- Open Hazard menu.
- Create a new hazard report.
- Validate mandatory fields.
- Upload Evidence.
- Submit hazard report.
- Verify hazard entity creation.
- Verify follow-up task creation.
- Verify PIC notification.
- Complete follow-up task.
- Verify Direct Supervisor notification.

## API Automation

Katalon Studio can also be used to test the backend services used by WeMine.

API automation can validate important backend processes such as:

- User authentication.
- User profile retrieval.
- Tenant master data retrieval.
- Hazard entity creation.
- Follow-up task creation.
- Notification-related API responses.

API testing is useful to validate backend functionality without depending entirely on the Mobile Application UI.

## Automation Approach

Not every test case needs to be automated.

Automation should prioritize test scenarios that are:

- Critical to the main business flow.
- Frequently executed.
- Repetitive.
- Suitable for regression testing.
- Stable enough for automation.

Manual testing should still be used for exploratory testing, usability testing, visual validation, and scenarios that require human observation.

## Proposed Katalon Project Structure

The automation project can use the following structure:

automation/
├── Test Cases/
│   ├── SignIn/
│   ├── EquipmentInspection/
│   └── SafetyHazard/
│
├── Object Repository/
│   ├── SignIn/
│   ├── EquipmentInspection/
│   └── SafetyHazard/
│
├── Test Suites/
│   ├── Smoke Test Suite
│   └── Regression Test Suite
│
├── Data Files/
│   └── TestData
│
├── Keywords/
│   └── CommonKeywords
│
├── Profiles/
│   └── default
│
└── README.md

## Example Automation Scenarios

The following test cases are recommended as examples for automation:

1. Successful Sign In with valid user.
2. Sign In validation with invalid credentials.
3. Initial master data download after Sign In.
4. Open Equipment Inspection and load form based on Form Code.
5. Submit Equipment Inspection with valid data.
6. Create Safety Hazard Report with valid mandatory data.
7. Validate mandatory fields on Safety Hazard Report.
8. Verify follow-up task is created after Hazard submission.
9. Verify PIC receives follow-up notification.
10. Submit completed Hazard follow-up task.

These scenarios represent important and repeatable flows that are suitable for automation testing using Katalon Studio.

## Implemented Automation

### TC_SignIn_Valid

This test case automates the successful Sign In flow using valid user credentials.

Test flow:
1. Launch the WeMine application.
2. Enter a valid username.
3. Tap the Sign In button.
4. Wait for the Microsoft authentication page.
5. Enter a valid password.
6. Tap the Microsoft Sign In button.
7. Verify that the Home page is displayed.

The application path and test credentials are managed using Katalon Global Variables. Credentials are not hardcoded in the test case or committed to the repository.

### Test Objects

The following objects are used:

- `SignIn/txt_Username`
- `SignIn/btn_SignIn`
- `SignIn/txt_MicrosoftPassword`
- `SignIn/btn_MicrosoftSignIn`
- `Home/lbl_Home`

### TC_SignIn_Invalid

This test case automates the unsuccessful Sign In flow using an invalid password.

Test flow:
1. Launch the WeMine application.
2. Enter a valid username.
3. Tap the Sign In button.
4. Wait for the Microsoft authentication page.
5. Enter an invalid password.
6. Tap the Microsoft Sign In button.
7. Verify that the invalid credential error message is displayed.

Test Objects:
- `SignIn/txt_Username`
- `SignIn/btn_SignIn`
- `SignIn/txt_MicrosoftPassword`
- `SignIn/btn_MicrosoftSignIn`
- `SignIn/lbl_InvalidCredentialError`


### TC_Submit_Hazard_Valid

This test case demonstrates the automation flow for submitting a Safety Hazard Report with valid mandatory data.

Test flow:
1. Launch the WeMine application.
2. Open the Safety Hazard Report form.
3. Create a new Safety Hazard Report.
4. Enter a valid hazard description.
5. Submit the Safety Hazard Report.
6. Verify that the report is submitted successfully.

Test Objects:
- `SafetyHazard/btn_CreateHazard`
- `SafetyHazard/txt_HazardDescription`
- `SafetyHazard/btn_SubmitHazard`
- `SafetyHazard/lbl_HazardSubmitSuccess`


## Execution Notes

The automation examples provide the proposed Katalon implementation structure.

Actual execution requires:
- Access to the WeMine application build.
- A configured Android device or emulator.
- Valid test credentials.
- Actual element locators captured from the application.

The current Test Object locators are placeholders and should be replaced with actual locators when application access is available.

Sensitive credentials should not be hardcoded or committed to the repository.
