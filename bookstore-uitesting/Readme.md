
## Requirements

- Java (JDK 8 or higher)
- Selenium WebDriver
- TestNG
- Apache POI (if using Excel for test data)

## Setup and Execution

1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE (Eclipse, IntelliJ, etc.).
3. Ensure that you have the required dependencies (Java, Selenium, TestNG) configured in your project.
4. Download the appropriate web driver (ChromeDriver, GeckoDriver, etc.) and place it in the `resources` folder.
5. Update the `config.properties` file with your demoQA login credentials.

## Usage

To run the test cases, navigate to the `BookstoreTests.java` class in the `tests` package and execute the test methods.

The test cases cover the following scenarios:

1. Verify the number of books added to the user against the number of books displayed on the website.
2. Verify the book details (author, publisher, number of pages, etc.) for each book on the website.

## Test Data

The test data is read from the `config.properties` file in the `resources` folder. Update this file with your demoQA login credentials.

## Contributors

- Anil Kumar Reddy

Feel free to contribute to this project by adding more test cases, improving page classes, or enhancing the framework's capabilities.

## src/main/java/config: 
    This folder contains the ConfigReader.java and Constants.java classes.
ConfigReader.java: This class is responsible for reading configuration properties from the config.properties file. It loads the properties from the file and provides methods to retrieve specific values based on keys.
Constants.java: This class stores constant values used throughout the project. For example, it can hold the base URL of the demoQA website.

## src/main/java/core: 
    This folder contains core classes that form the backbone of the framework.
BasePage.java: This class is the base class for all page classes in the project. It initializes the web elements using PageFactory from Selenium's support library.
BaseTest.java: This class is the base class for all test classes. It initializes the WebDriver, sets up the configuration, and handles the teardown after each test.
DriverManager.java: This class provides a driver instance using the Singleton design pattern. It ensures that only one WebDriver instance is used throughout the test execution.
PageObjectManager.java: This class manages the page objects and ensures a single instance of each page is created. It follows the Singleton pattern to create and store page objects.

## src/main/java/pages: 
    This folder contains page classes representing the web pages of the demoQA application.
LoginPage.java: This class represents the login page of the demoQA application. It contains web elements and methods to interact with the login page.
BookstorePage.java: This class represents the bookstore application page of the demoQA application. It contains web elements and methods to interact with the bookstore page.

## src/main/java/utils: 
    This folder contains utility classes to assist in various operations.
FileOperations.java: This class is responsible for reading data from the config.properties file. It loads the properties from the file and provides methods to retrieve specific values based on keys.
TestData.java: This class provides test data by calling FileOperations.getProperty(). It acts as a bridge between test cases and the config.properties file, making test data easily accessible.

## src/test/java/tests: 
    This folder contains the test classes.
BookstoreTests.java: This class contains the actual test cases for the demoQA application. It includes test methods to verify the number of books and their details on the website.

## src/test/resources: 
    This folder contains resources required for test execution.
chromedriver.exe (or other drivers): This is the WebDriver executable for the chosen browser (e.g., Chrome, Firefox). You need to download and place it in this folder.
config.properties: This file contains test data, such as the demoQA login credentials (username and password). It is read by the ConfigReader and TestData classes.

pom.xml: This is the Maven Project Object Model (POM) file, which manages the project's dependencies and build configuration.
