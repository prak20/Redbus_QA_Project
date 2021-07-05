### _Redbus Automation Using Selenium Maven Framework_
#### To run the [RedbusAutomation](https://www.redbus.in/) Website Test Scenarios , Follow Below Steps :

1. Copy/Clone the project into your eclipse workspace.
2. Navigate to the project Folder
3. Run run_project.bat file to run the tests.

> ##### Github Link :
[RedBus Github](https://github.com/prak20/Redbus_QA_Project).
### Folders Description
##### 1. Drivers
Contains all the drivers used in the project
##### 2. logs
Contains logfile.log that captures all the logs.
##### 3. Resources
Contains all the resources required for project. ( Global Config File, log4j.xml File, testData File )
##### 4. Result
4.1. ExtentReport

Contains an HTML report that is generated after the tests are executed.

4.2. FailedScreenshots

Contains Screenshots of the tests that are failed.

4.3. Logs

Contains logfile of the Project

### Packages Description
##### 1. Pages
Contains pages - AboutRedbusPage, busHirePage, homePage, loginPage, searchPage
##### 2. pageUtils
Contains utility file that supports all the pages
##### 3. tests
Contains all the test files.
#####  4. utils
Contains common files required for the tests like ExcelReaderTest.java, RunBrowserSetup.java,  Screenshots.java and utils.java

### Drivers Used
1. Chrome
2. Firefox

#### Prerequisites
1. Eclipse IDE
2. JDK 8 installed
3. Java and Maven Path set in Environment Variables
3. Browsers required 
4. Docker desktop installed 
5. Jenkins installed

## Note:
### To change Project configurations ( like browser name, url or docker mode or headless-nonheadless mode etc. )
>  Use config.properties file.

### To change and modify test data 
>use Resources/testData.xlsx file.

### To choose between headless and non headless mode
>Set headLessMode to either 'true' or 'false' in the config.properties file.
 
### To set docker mode
>Set dockerMode to True in config.properties file


#### TestFiles Description :
1. AboutRedBusPage - Contains 7  tests
2. busHireTest - Contains 4  tests
3. HomeFunctionalityTest - Contains 6  tests
4. LoginTest - Contains 7  tests
5. searchBusTicketTest - Contains 4  tests

> ## Ways to Run Tests Normally

- Running Individual Test in Test Class - Click on the run option present below @Test Annotation to run specific test case

- Running particular Test Class - Click on RunAll option present at the top of the test file below import statements

- Running All Test Classes - Use Testng.xml to run all test Classes by right click on Testng File -> Run As -> Testng Test

### Using Jenkins To Run Tests - 
1. download jenkins.war file
2. open cmd in location where jenkins.war is installed 
3. write command `java -jar jenkins.war --httpPort=8080` in cmd 
4. navigate to localhost:8080
5. login with credentials
6. click on new item
7. Enter projects name
8. click on freestyle project, 
9. Go into build -> build windows batch commannd
10. Type :

	> cd <project path>
	> mvn clean install 
	
11. click apply and then save
12. Then build project by clicking on build
13. Then the project will run the test cases and build

##### Note : Jenkins Setup is also Shown in JenkinsFlow.docx file



### Using Docker To Run Tests - 


**Note** : To Run docker tests, In Testng.xml, Add - 
 
```
<suite parallel="classes">...</suite>
```
 
1. Open cmd -> Login to docker by typing -

`docker login`

2. Before starting tests, Open cmd in project directory where docker-compose.yaml is present and run following command - 

`docker-compose up`

3. To check hub and node running state -

> **http://localhost:4444/grid/console**
 
4. To increase number of browser nodes use command -

`docker-compose scale <browser name> = <no of instances>`

5. To check installed images - 

`docker images`

6. To check running Containers -

`docker ps`

7.  After running tests, at last Open cmd in project directory where docker-compose.yaml is present and run following command - 

`docker-compose down`






