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
