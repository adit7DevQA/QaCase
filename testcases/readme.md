# WeMine Test Cases

## Flow 0 - Sign In

### Manual Test Cases

| ID | Test Scenario | Precondition | Test Steps | Expected Result | Type | Priority |
|---|---|---|---|---|---|---|
| SI-003 | Sign in with incorrect Microsoft password | Valid username is available | 1. Enter a valid username. 2. Continue to Microsoft Login. 3. Enter an incorrect password. | Login fails and the user is not authenticated. | Negative | High |
| SI-008 | Verify progress bar during master data download | User has successfully authenticated | 1. Sign in with a valid user. 2. Wait for the master data download process. 3. Observe the download progress. | Progress bar is displayed while locations, sublocations, areas, employees, forms, and other master data are being downloaded. | Positive | Medium |
| SI-009 | Verify initial master data download | First-time login and user has successfully authenticated | 1. Sign in with a valid user. 2. Wait for the initial master data download to complete. | Initial master data is successfully downloaded and the process completes without application errors. | Positive | Critical |
| SI-010 | Verify restart prompt after initial master data update | First-time login and initial master data download is completed | 1. Sign in with a valid user. 2. Wait until the initial master data update is completed. | Application prompts the user to restart after the initial master data update is completed. | Positive | High |
| SI-011 | Verify connection interruption during master data download | Master data download is in progress | 1. Sign in with a valid user. 2. Wait until master data download starts. 3. Disconnect the internet connection during the download process. | Application handles the connection interruption without crashing or corrupting valid downloaded data. | Negative | High |
| SI-012 | Sign in with poor internet connection | Valid user is available and network can be configured as slow or unstable | 1. Set the network connection to slow or unstable. 2. Enter a valid username. 3. Complete the sign-in process. | Application handles poor network conditions without crashing during sign-in and synchronization. | Negative / Resilience | High |

### Automation Test Cases

| ID | Test Scenario | Precondition | Test Steps | Expected Result | Type | Priority |
|---|---|---|---|---|---|---|
| SI-001 | Sign in with valid user | Registered user and internet connection are available | 1. Open the application. 2. Enter a valid username. 3. Continue to Microsoft Login. 4. Enter valid credentials. | User is successfully authenticated and the application continues to retrieve the user profile and master data. | Positive | Critical |
| SI-002 | Sign in with unregistered username | Internet connection is available | 1. Open the application. 2. Enter an unregistered username. 3. Continue the sign-in process. | System rejects the sign-in process and the user cannot continue authentication. | Negative | High |
| SI-004 | Validate empty username | Application is on the Sign In page | 1. Leave the username field empty. 2. Click the button to continue. | Validation is displayed and the sign-in process is not initiated. | Negative | Medium |
| SI-005 | Validate tenant information based on username | Valid username associated with a tenant is available | 1. Enter a valid username. 2. Continue the sign-in process. 3. Verify the `/user/who` request. | `/user/who` request succeeds and the application receives the tenant information associated with the user. | Positive | High |
| SI-006 | Retrieve user profile after authentication | User has successfully authenticated | 1. Complete Microsoft authentication. 2. Verify the `/user/me` request. | `/user/me` request succeeds and the user profile is successfully retrieved. | Positive | High |
| SI-007 | Retrieve tenant master data after login | User has successfully authenticated | 1. Complete the login process. 2. Verify the `/tenant/master` request. | `/tenant/master` request succeeds and the application receives the list of master data. | Positive | Critical |

### Assumptions / Clarifications

- The application is designed to operate under poor or no internet connectivity. However, the requirement does not specify whether first-time authentication can be performed without an internet connection.
- The expected retry mechanism when a network interruption occurs during master data download is not specified.
- The expected behavior for partially downloaded master data is not specified.
- Detailed error messages for invalid username, authentication failure, and backend service failure are not specified.

---

## Flow 1 - Equipment Inspection Form

### Manual Test Cases

| ID | Test Scenario | Precondition | Test Steps | Expected Result | Type | Priority |
|---|---|---|---|---|---|---|
| EI-009 | Verify Radio field with maximum 4 options | A form with a Radio field configured with 4 options is available | 1. Open Equipment Inspection. 2. Open the configured form. 3. Check the Radio field options. | Radio field displays up to 4 options according to the form configuration. | Positive / Boundary | High |
| EI-010 | Verify Image Picker field | A form with an Image Picker field is available | 1. Open Equipment Inspection. 2. Open the configured form. 3. Tap the Image Picker. 4. Select an image. | User can select an image and the selected image is successfully added to the form. | Positive | High |
| EI-011 | Verify form with maximum 50 fields | A form configured with 50 fields is available | 1. Open Equipment Inspection. 2. Open the form configured with 50 fields. 3. Verify all fields. | All 50 configured fields are displayed correctly and the application remains stable without crashing. | Positive / Boundary | Critical |
| EI-012 | Verify form cannot exceed maximum 50 fields | User has access to the Web Form Builder | 1. Create or edit a form with 50 fields. 2. Attempt to add the 51st field. | System does not allow the form configuration to exceed the maximum limit of 50 fields. | Negative / Boundary | High |
| EI-013 | Verify dynamic form after configuration update | An Equipment Inspection form already exists | 1. Update the form configuration using the Web Form Builder. 2. Complete the available master data update/synchronization process. 3. Open the form again on the application. | The application displays the latest form configuration after the data update/synchronization is successfully completed. | Positive | High |
| EI-014 | Open Equipment Inspection with poor internet connection | Required master and form data are available on the application | 1. Set the network connection to slow or unstable. 2. Open Equipment Inspection. 3. Open an available inspection form. | Application handles the poor network condition without crashing and locally available data remains accessible according to the application's offline capability. | Negative / Resilience | High |
| EI-015 | Open Equipment Inspection without internet connection | Required master and form data have previously been downloaded | 1. Disable the internet connection. 2. Open Equipment Inspection. 3. Open an available inspection form. | Previously available form and master data remain accessible according to the application's offline capability. | Positive / Resilience | Critical |

### Automation Test Cases

| ID | Test Scenario | Precondition | Test Steps | Expected Result | Type | Priority |
|---|---|---|---|---|---|---|
| EI-001 | Open Equipment Inspection | User is authenticated and has access to Equipment Inspection | 1. Sign in. 2. Open the Equipment Inspection menu. | Equipment Inspection page is displayed with previous submissions and an option to create a new submission. | Positive | High |
| EI-002 | Verify previous submissions | User has previous Equipment Inspection submissions | 1. Open Equipment Inspection. 2. Check the previous submission list. | Previous Equipment Inspection submissions are displayed. | Positive | Medium |
| EI-003 | Open a new submission form | User is on the Equipment Inspection page | 1. Open Equipment Inspection. 2. Select the option to create a new submission. | Submission form is displayed with Form Code and its dynamically configured fields. | Positive | Critical |
| EI-004 | Verify dynamic form based on Form Code | A form has been configured using the Web Form Builder | 1. Open Equipment Inspection. 2. Open a form with a specific Form Code. 3. Verify the displayed fields. | Dynamic fields displayed on the application match the configuration associated with the Form Code. | Positive | Critical |
| EI-005 | Verify Input Text dynamic field | A form containing an Input Text field is available | 1. Open the configured form. 2. Enter text into the Input Text field. | Input Text field accepts and displays the value entered by the user. | Positive | Medium |
| EI-006 | Verify Date Picker dynamic field | A form containing a Date Picker field is available | 1. Open the configured form. 2. Open the Date Picker. 3. Select a date. | User can select a date and the selected date is displayed in the field. | Positive | Medium |
| EI-007 | Verify Select dynamic field | A form containing a Select field is available | 1. Open the configured form. 2. Open the Select field. 3. Select an available option. | User can select an option and the selected value is displayed in the field. | Positive | Medium |
| EI-008 | Verify Radio dynamic field | A form containing a Radio field is available | 1. Open the configured form. 2. Select one of the available Radio options. | User can select one of the configured Radio options successfully. | Positive | Medium |

### Assumptions / Clarifications

- Mandatory and optional configurations for dynamic Equipment Inspection fields are not specified.
- Maximum character length for the Input Text field is not specified.
- Supported image formats and maximum image file size are not specified.
- The application is designed to support poor or no internet connectivity, but the exact offline submission and synchronization mechanism is not specified.
- Detailed validation rules for Date Picker and Select fields are not specified.

---

## Flow 2 - Safety Hazard Report

### Manual Test Cases

| ID | Test Scenario | Precondition | Test Steps | Expected Result | Type | Priority |
|---|---|---|---|---|---|---|
| SH-001 | Open Hazard menu | User is authenticated and has access to Hazard menu | 1. Sign in to the application. 2. Open the Hazard menu. | Hazard page is displayed and user can see the list of hazard reports. | Positive | High |
| SH-002 | Create a new hazard report with valid mandatory data | User is on the Hazard page | 1. Create a new hazard report. 2. Select Location. 3. Select Sublocation. 4. Select Area. 5. Add Evidence. 6. Verify PIC is preselected to reporter. 7. Submit the report. | Hazard report is successfully submitted and a hazard entity is created. | Positive | Critical |
| SH-003 | Verify Location is mandatory | User is creating a new hazard report | 1. Leave Location empty. 2. Complete the other mandatory fields. 3. Submit the report. | Validation is displayed for Location and the hazard report is not submitted. | Negative | High |
| SH-004 | Verify Sublocation is mandatory | User is creating a new hazard report | 1. Select Location. 2. Leave Sublocation empty. 3. Complete the other mandatory fields. 4. Submit the report. | Validation is displayed for Sublocation and the hazard report is not submitted. | Negative | High |
| SH-005 | Verify Area is mandatory | User is creating a new hazard report | 1. Select Location and Sublocation. 2. Leave Area empty. 3. Complete the other mandatory fields. 4. Submit the report. | Validation is displayed for Area and the hazard report is not submitted. | Negative | High |
| SH-006 | Submit hazard without optional Area Description | User is creating a new hazard report | 1. Complete Location, Sublocation, Area, Evidence, and PIC. 2. Leave Area Description empty. 3. Submit the report. | Hazard report is successfully submitted without Area Description. | Positive | Medium |
| SH-007 | Verify Evidence is mandatory | User is creating a new hazard report | 1. Complete the required fields except Evidence. 2. Submit the report. | Validation is displayed for Evidence and the hazard report is not submitted. | Negative | High |
| SH-008 | Verify PIC is preselected to reporter | User is creating a new hazard report | 1. Open the new hazard report form. 2. Check the PIC field. | PIC field is automatically preselected to the reporter. | Positive | High |
| SH-009 | Verify follow-up task is generated after hazard submission | A valid hazard report is ready to be submitted | 1. Submit the hazard report. 2. Verify the created hazard. 3. Check the associated follow-up task. | System creates a hazard entity and a follow-up task for the submitted hazard. | Positive | Critical |
| SH-010 | Verify PIC receives follow-up notification | Hazard report has been successfully submitted | 1. Submit a hazard report. 2. Check notification received by the PIC. | PIC receives a notification for the follow-up task. | Positive | Critical |
| SH-011 | Verify people in the area receive hazard notification | Hazard report has been successfully submitted | 1. Submit a hazard report for a specific area. 2. Check notifications for users associated with that area. | People in the affected area receive a notification about the hazard. | Positive | Critical |
| SH-012 | PIC submits completed follow-up task | PIC has received a follow-up task and resolved the issue | 1. Open the follow-up task. 2. Add Evidence. 3. Select Resolution Date. 4. Select Co Observer if needed. 5. Submit the follow-up task. | Follow-up task is successfully submitted with the resolution information. | Positive | Critical |
| SH-013 | Verify Resolution Date is mandatory | PIC is completing a follow-up task | 1. Open the follow-up task. 2. Add Evidence. 3. Leave Resolution Date empty. 4. Submit the follow-up task. | Validation is displayed for Resolution Date and the follow-up task is not submitted. | Negative | High |
| SH-014 | Add multiple Co Observers | PIC is completing a follow-up task | 1. Open the follow-up task. 2. Select a Co Observer. 3. Click the (+) button. 4. Add another Co Observer. | Additional Co Observer select field is added and multiple Co Observers can be selected. | Positive | Medium |
| SH-015 | Verify Direct Supervisor receives notification | PIC has successfully submitted the follow-up task | 1. Complete and submit the follow-up task. 2. Check the Direct Supervisor notification. | Direct Supervisor of the area receives a notification for the completed follow-up. | Positive | High |

### Automation Test Cases

| ID | Test Scenario | Precondition | Test Steps | Expected Result | Type | Priority |
|---|---|---|---|---|---|---|
| SH-A001 | Create hazard report with valid data | Authenticated user has access to Hazard feature | 1. Open Hazard menu. 2. Create a new hazard report. 3. Complete all mandatory fields. 4. Submit the report. | Hazard report is successfully created and displayed in the hazard report list. | Positive | Critical |
| SH-A002 | Validate mandatory fields on hazard report | User is on the new Hazard Report form | 1. Leave mandatory fields empty. 2. Submit the form. | System displays validation for required fields and prevents submission. | Negative | Critical |
| SH-A003 | Verify hazard entity and follow-up task creation | Valid hazard report is submitted | 1. Submit a valid hazard report. 2. Verify the generated hazard entity. 3. Verify the associated follow-up task. | Hazard entity and follow-up task are successfully generated. | Positive | Critical |
| SH-A004 | Verify PIC follow-up notification | Hazard report is successfully submitted | 1. Submit a hazard report. 2. Verify notification generated for the PIC. | PIC receives the follow-up task notification. | Positive | Critical |
| SH-A005 | Verify area hazard notification | Hazard report is successfully submitted for a specific area | 1. Submit a hazard report. 2. Verify notifications for users associated with the affected area. | Users in the affected area receive the hazard notification. | Positive | High |
| SH-A006 | Submit hazard follow-up task | PIC has an active follow-up task | 1. Open the follow-up task. 2. Add Evidence. 3. Select Resolution Date. 4. Submit the task. | Follow-up task is successfully completed and submitted. | Positive | Critical |
| SH-A007 | Verify multiple Co Observers | PIC is completing a follow-up task | 1. Select a Co Observer. 2. Click the (+) button. 3. Select another Co Observer. | System allows additional Co Observer fields to be added and selected. | Positive | Medium |
| SH-A008 | Verify Direct Supervisor notification | Follow-up task has been successfully submitted | 1. Complete the follow-up task. 2. Verify notification generated for the Direct Supervisor. | Direct Supervisor of the area receives the expected notification. | Positive | High |

### Assumptions / Clarifications

- The requirement specifies Location, Sublocation, Area, Evidence, and PIC as mandatory fields for a hazard report.
- Area Description is specified as optional.
- PIC is preselected to the reporter, but the requirement does not specify whether the reporter can change the PIC.
- The requirement does not specify supported image formats or maximum Evidence file size.
- The requirement does not specify the maximum number of Co Observers that can be added.
- The requirement states that people in the area receive hazard notifications, but does not specify how users are mapped to an area.
- The requirement states that the Direct Supervisor receives a notification, but the exact notification content and delivery channel are not specified.
- Evidence is listed for the follow-up task, but the requirement does not explicitly mark it as mandatory or optional.
