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
