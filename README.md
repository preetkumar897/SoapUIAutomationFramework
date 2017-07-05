# SoapUIAutomationFramework
**SoapUI** Automation framework using free version of **SoapUI**. *No need of **SoapUI** paid version.*

This data-driven framework is designed using groovy script. User has to import the project from ***projects*** folder in SoapUI, add WSDL which has to be tested and prepare the test data sheet in ***testData*** folder.

***Best part of this framework is that it creates the soap request dynamically based on the text nodes user provides in test data sheet.***

## Getting Started
1) Download ***SoapUIWorkspace*** folder. It will have the folloing folders in it; *keyStore*, *output*, *projects*, *sampleXML* and *testData*
2) Import *SOAPUIAutomationFramework-soapui-project.xml* project from *projects* folder in SoapUI
3) Add WSDL in the imported project
4) Prepare test cases in *SOAPUIAutomationFramework.xlsx* test data sheet which is in *testData* folder

### Folder Structure
* keyStore - Keep All SSL certificates here
* output - Creates a folder for each run and store Request and Response of each test case from test data sheet. This helps for future refrence and work as evidences also
* projects - **SOAPUIAutomationFramework** will be there, which needs to be imported in SoapUI
* sampleXML - sample xmls of Soap request will be created in this folder, which are used to create dynamic Soap Request
* testData - **SOAPUIAutomationFramework.xlsx** will be there, which is source of test data

### Prerequisites
#### Add the following jars in lib folder:

*dom4j-1.6.1.jar*, *xmlbeans-2.6.0.jar*

#### Add the following jars in bin/ext folder:

*commons-collections4-4.1.jar*, *commons-collections4-4.1-javadoc.jar*, *poi-3.16.jar*, *poi-examples-3.16.jar*, *poi-excelant-3.16.jar*, *poi-ooxml-3.16.jar*, *poi-ooxml-schemas-3.16.jar*, *poi-scratchpad-3.16.jar*, *writeevidence.jar*, *xmlbeans-2.6.0.jar*

### Verify the imported project in SoapUI
There will be only one project (**SOAPUIAutomationFramework**), one testsuite (**WebServiceTestSuite**) and one test case (**WebServiceTest**).
And following test steps will be there in the test case. All test steps should be in this sequence:

1) createFolder
2) bootstrap
3) sampleXML
4) pushSampleRequest
5) testData
6) requestSample
7) transformXml
8) pushFinalRequest
9) WebServiceTest
10) writeReq&Res
11) statusWrite
12) getNextStep
13) End

***Note** - requestSample and WebServiceTest are SOAP Request steps.**

## Add WSDL in project
Add WSDL in project which has to be tested. User can add multiple WSDLs in one project, no need of creating multiple projects, testsuites or test cases.

## Test Data/ Test Cases preparation
There will be only one test data excel sheet (same name as SoapUI project name, **SOAPUIAutomationFramework.xlsx**)There will be only one worksheet (same name as test case name in SoapUI, **WebServiceTest**). Following columns are there in test data sheet.

* Execute - Y (include as part of run), N (do not include as part of run). Only this column has fixed position (0).
* WebService - enter Web Service name, exactly same from SoapUI
* Operation - enter operation name, exactly same from SoapUI
* EndPoint - enter end point of web service
* UserName - enter user name if user authentication is requied.
* Password - enter corresponding password for the given username
* KeyStore - This is for SSL certificates. Copy your certificate in keyStore folder, and enter the name of the same in this column
* KeyPass - enter password of KeyStore certificate
* Env - Enter environment Name
* Test Case - enter test case name/description
* Data1 to Data...n - These are the test data for soap request. User needs to provide data in the form of "*KEY,VALUE*". Where key is text node name and value is text/string which user wants to pass in it
* Expected1 to Expected...n - These are the validations with soap response. User needs to provide data in the form of "*KEY,VALUE*". Where key is node name and value is text/string which user wants to validate to pass or fail the test

* Status - This column will be filled after the test run. Values will be PASSED, FAILED and empty(if Execute is N)

***Note*** - 
* Framework creates Soap Request dynamically based on the data provided in DATA columns.
* Data and Expected columns accept direct node name, xpath, list node (need to provide with indexing)
* '#KEEP' is a keyword, if user wants to keep the text node in soap request with empty/null value. e.g 'username;#KEEP' . in this scenario username will be part of Soap Request but with empty value.
* '#EXISTS' is a keyword, if user wants to validate a dynamic value in Soap Response. e.g. 'transactionNumber;#EXISTS'. In this scenario system checks if provided node is present in Response or not and it should not be empty.


Add n number of test cases in one test data sheet.

## Running the tests

You can run the test directly from SoapUI, create a .bat file and create a Task scheduler in windows or .sh file and write a cron job in ubuntu machine.

Close the test data sheet while running the test.

Test Data sheet will be updated with PASSED or FAILED status once test will be completed.

## Stats

This framework can execute 600 test cases in 1 hour, or even more based on your system tps.

## Author

* **Preet Kumar** - [PreetKumar/Linkedin](linkedin.com/in/preetkumar897)

