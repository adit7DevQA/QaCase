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
