# E-Commerce Web Application Testing

A QA testing project demonstrating manual testing, defect tracking, API testing, database validation, UI automation, and continuous integration using Java, Selenium WebDriver, JUnit 5, Maven, and GitHub Actions.

**GitHub Repository:** [E-Commerce Web Application Testing](https://github.com/Asvitha-12/E-Commerce-Web-Application-Testing)

## Project Overview

This project demonstrates a structured QA workflow for an e-commerce application, covering manual test design, test execution, defect tracking, API validation, SQL practice, UI automation, and automated test execution through a CI pipeline.

The project is organized into the following areas:

- Manual testing and test documentation
- UI automation using Selenium WebDriver
- REST API testing using REST Assured
- Database validation practice using SQL
- Defect tracking using Jira
- API request testing using Postman
- Continuous integration using GitHub Actions
- Test reporting using Allure

## Technologies and Tools

| Category | Tools and Technologies |
|---|---|
| Programming Language | Java 17 |
| UI Automation | Selenium WebDriver |
| Test Framework | JUnit 5 |
| Build Tool | Maven |
| API Automation | REST Assured |
| API Testing | Postman |
| Database | SQL, MySQL |
| Defect Tracking | Jira |
| CI/CD | GitHub Actions |
| Test Reporting | Allure Report |
| Version Control | Git, GitHub |
| IDE | Eclipse / Visual Studio Code |

## Manual Testing

The manual testing module contains test documentation and test execution artifacts for the e-commerce application.

### Testing Activities

- Test scenario and test case design
- Functional testing
- Positive and negative testing
- Smoke testing
- Regression testing
- Requirement Traceability Matrix (RTM)
- Defect identification and reporting
- Severity and priority classification

### Test Documentation

The repository includes testing documents such as:

- Test Plan
- Test Scenarios
- Test Cases
- Requirement Traceability Matrix
- Smoke and Regression Testing documentation
- Defect Reports
- Test Execution Reports

## UI Test Automation

UI automation is implemented using **Java, Selenium WebDriver, JUnit 5, Maven, and the Page Object Model (POM)**.

The UI tests automate selected user workflows on [Automation Exercise](https://automationexercise.com/).

### Automated UI Test Coverage

- Browser launch and application access
- Product page navigation
- Product search
- Product-related UI validations
- Other implemented browser and product workflow checks

The automation code uses reusable page classes to separate page interactions from test logic.

### UI Test Results

- Tests passed: 8
- Tests failed: 0

These results reflect the recorded local test execution.

## REST API Test Automation

API automation is implemented using **REST Assured and JUnit 5** against the [DummyJSON API](https://dummyjson.com/).

The API practice environment is separate from the UI application and does not share its backend.

### API Test Coverage

- GET `/products` — validate the response status, JSON response, product list, and required fields
- GET `/products/1` — validate product details
- GET `/products/999999` — validate the not-found response
- POST `/products/add` — validate the simulated product creation response
- PUT `/products/1` — validate the simulated product update response
- DELETE `/products/1` — validate the simulated product deletion response

### API Test Results

- Tests passed: 7
- Tests failed: 0

**Note:** DummyJSON simulates write operations. Successful POST, PUT, and DELETE responses validate the API responses; they do not establish that changes are permanently stored.

## Database Testing Using SQL

The project includes SQL practice for database creation, table creation, data validation, and queries involving related tables.

### Database Activities

- Database and table creation
- Table data validation
- SELECT queries
- Filtering and sorting records
- JOIN queries for related data
- Data verification using SQL

The SQL practice database is independent of the Automation Exercise website and DummyJSON API. The project does not claim direct database integration with either external application.

## API Testing with Postman

Postman is used for sending API requests and validating responses.

The repository includes a Postman collection for the API testing work. The collection can be imported into Postman to inspect and execute the saved requests.

## Defect Tracking with Jira

Jira is used to organize testing activities and track defects for the e-commerce testing project.

**Jira project key:** `ECWAT`

The project includes an epic, a functional testing story, subtasks for test execution, and verified defect tickets.

Jira helps demonstrate issue tracking and the organization of QA activities.

## Combined Automation Results

The recorded local execution completed with the following results:

| Test Suite | Passed | Failed |
|---|---:|---:|
| UI Automation | 8 | 0 |
| API Automation | 7 | 0 |
| **Total** | **15** | **0** |

These results represent the documented execution at the time of testing. Test results may change if the application, test code, browser, or external API changes.

## Automation Evidence

### Allure Test Report

The Allure dashboard provides a visual summary of the automated test execution.

![Allure Report showing automated test results](Screenshots/Allure%20Report.png)

### GitHub Actions CI

The screenshot below documents the successful GitHub Actions workflow execution.

![GitHub Actions CI workflow](Screenshots/GitHub%20Actions.png)

## Continuous Integration with GitHub Actions

The project includes a GitHub Actions workflow that runs automatically on pushes and pull requests targeting the `main` branch. It can also be started manually using `workflow_dispatch`.

### CI Pipeline Steps

1. Check out the repository.
2. Set up Java 17.
3. Set up Chrome for browser automation.
4. Execute UI and API tests using Maven.
5. Upload Maven Surefire test reports.
6. Upload Allure test results.
7. Install the Allure command-line tool.
8. Generate the Allure HTML report.
9. Upload the generated Allure report as a workflow artifact.

### View the Workflow

[Open the GitHub Actions page](https://github.com/Asvitha-12/E-Commerce-Web-Application-Testing/actions)

After a successful run, open the workflow run and check its **Artifacts** section to access the uploaded reports.

## Project Structure

```text
E-Commerce-Web-Application-Testing/
├── .github/
│   └── workflows/
│       └── maven-ci.yml
├── Screenshots/
│   ├── Allure Report.png
│   └── GitHub Actions.png
├── Test Cases/
├── Test Scenarios/
├── Test Plan/
├── RTM/
├── Defect Reports/
├── Reports/
├── Postman/
├── SQL/
├── src/
│   └── test/
│       └── java/
│           └── com/
│               └── asvi/
│                   └── qa/
│                       ├── BaseTest.java
│                       ├── BrowserLaunchTest.java
│                       ├── ProductSearchTest.java
│                       ├── api/
│                       │   └── ProductsApiTest.java
│                       └── pages/
│                           ├── HomePage.java
│                           └── ProductsPage.java
├── pom.xml
└── README.md
```

The structure above highlights the main project areas. Some folders may contain additional files and supporting documentation.

## Prerequisites

Install the following tools before running the automation tests:

- Java JDK 17
- Apache Maven
- Google Chrome
- Git

The Allure CLI is required only when generating and opening the HTML report locally.

## How to Run the Tests

### 1. Clone the repository

```bash
git clone https://github.com/Asvitha-12/E-Commerce-Web-Application-Testing.git
```

### 2. Navigate to the project directory

```bash
cd E-Commerce-Web-Application-Testing
```

### 3. Run the automated tests

```bash
mvn clean test
```

Maven compiles the test code and executes the configured UI and API test suites.

### 4. Generate the Allure report

After the tests finish, run:

```bash
allure generate allure-results --clean -o allure-report
```

### 5. Open the Allure report

```bash
allure open allure-report
```

These Allure commands require the Allure CLI to be installed and available on the system PATH.

## Key Learning Outcomes

- Creating and maintaining manual test documentation
- Designing and executing functional test cases
- Automating browser workflows using Selenium WebDriver
- Applying the Page Object Model
- Validating REST API responses using REST Assured
- Writing SQL queries to verify database records
- Tracking testing work and defects using Jira
- Managing automation dependencies with Maven
- Running automated tests in GitHub Actions
- Generating and reviewing Allure test reports

## Conclusion

This project demonstrates practical QA activities across manual testing, UI automation, API testing, SQL validation practice, defect tracking, and continuous integration. It brings testing documentation and automation work together in a single repository and provides evidence of the recorded automated test results.

**Repository:** [Asvitha-12/E-Commerce-Web-Application-Testing](https://github.com/Asvitha-12/E-Commerce-Web-Application-Testing)