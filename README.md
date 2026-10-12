# E-Commerce Web Application Testing

## Overview

This project demonstrates manual testing and automated testing for a demo e-commerce web application. It covers Software Testing Life Cycle (STLC) activities, including test planning, test scenario creation, test case design, test execution, defect reporting, API testing, SQL validation exercises, and test reporting.

The automation suite uses Selenium WebDriver with Java for UI testing and REST Assured with JUnit 5 for API testing. GitHub Actions runs the automated test suite in a CI environment, and Allure generates detailed test reports.

## Project Modules

- User Registration
- User Login
- Logout
- Product Search
- Product Details
- Shopping Cart
- Checkout
- Payment
- Order Confirmation
- Contact Us

## Manual Testing

- Functional Testing
- Positive and Negative Testing
- Boundary Value Testing
- Smoke Testing
- Regression Testing
- Boundary Value Analysis
- Test Case and Test Scenario Design
- Requirements Traceability Matrix (RTM)
- Defect Reporting and Tracking using Jira

## UI Test Automation

Selenium WebDriver and Java automate browser interactions with the demo e-commerce application.

Current coverage includes:

- Opening the e-commerce website
- Verifying the product search field
- Entering a search term
- Searching for matching products
- Searching for a term with no matching products
- Submitting an empty search
- Clearing the search field
- Searching with different product terms

**Latest verified UI test count:** 8 passed.

## API Test Automation

REST Assured and JUnit 5 automate HTTP API requests against the [DummyJSON API](https://dummyjson.com/).

Current coverage includes:

- GET `/products` — status code, JSON response, and product list validation
- GET `/products` — product field validation
- GET `/products/1` — single product validation
- GET `/products/999999` — nonexistent product response validation
- POST `/products/add` — created product response validation
- PUT `/products/1` — updated product response validation
- DELETE `/products/1` — delete response validation

DummyJSON is a practice API. POST, PUT, and DELETE tests validate simulated responses and do not establish that changes are permanently stored.

**Latest verified API test count:** 7 passed.

## Combined Automation Results

The latest verified full Maven test run completed successfully.

| Result | Count |
|---|---:|
| Total tests | 15 |
| Passed | 15 |
| Failures | 0 |
| Errors | 0 |
| Skipped | 0 |

## Continuous Integration with GitHub Actions

GitHub Actions automatically runs the UI and API test suites when changes are pushed to the `main` branch or a pull request targets `main`. The workflow can also be started manually.

The CI workflow:

1. Checks out the repository.
2. Sets up Java 17 and Maven dependency caching.
3. Sets up Chrome for browser automation.
4. Runs the automated tests using Maven.
5. Uploads Maven Surefire reports.
6. Uploads raw Allure test results.
7. Generates an Allure HTML report.
8. Uploads the HTML report as a workflow artifact.

**Latest verified CI status:** Successful. The workflow completed, and the Allure HTML report was generated and uploaded.

To view the workflow, visit the [GitHub Actions page](https://github.com/Asvitha-12/E-Commerce-Web-Application-Testing/actions).

### Accessing CI reports

1. Open the GitHub Actions page.
2. Select a successful workflow run.
3. Locate the Artifacts section.
4. Download `allure-html-report` or `maven-surefire-reports`.
5. Extract the downloaded ZIP file.

The Allure HTML report can be opened locally using `index.html`.

## SQL Database Validation

SQL validation exercises cover:

- Users
- Products
- Cart
- Orders
- Payments

The SQL exercises use a separate practice database and are not integrated into the Selenium or REST Assured test suites.

## Technology Stack and Tools

- Java 17
- Selenium WebDriver 4.39.0
- REST Assured 5.5.6
- JUnit 5.14.0
- Maven
- Page Object Model (POM)
- GitHub Actions
- Allure Report
- Postman
- SQL and MySQL Workbench
- Jira
- Microsoft Excel
- Microsoft Word
- Google Chrome
- Git and GitHub

## Project Structure

```text
src/
└── test/
    └── java/
        └── com/
            └── asvi/
                └── qa/
                    ├── BaseTest.java
                    ├── BrowserLaunchTest.java
                    ├── ProductSearchTest.java
                    ├── api/
                    │   └── ProductsApiTest.java
                    └── pages/
                        ├── HomePage.java
                        └── ProductsPage.java
```

- `BaseTest.java` — shared browser setup and teardown.
- `BrowserLaunchTest.java` — browser launch and search-field checks.
- `ProductSearchTest.java` — automated product-search scenarios.
- `ProductsApiTest.java` — REST Assured API tests.
- `HomePage.java` and `ProductsPage.java` — page interaction methods following the Page Object Model.

## Running the Automated Tests

### Prerequisites

- Java JDK 17 or compatible version
- Maven
- Google Chrome
- Internet connection

### Run all UI and API tests

From the project root directory, execute:

```bash
mvn clean test
```

### Run only API tests

```bash
mvn -Dtest=ProductsApiTest test
```

### Run only UI tests

```bash
mvn -Dtest=BrowserLaunchTest,ProductSearchTest test
```

Maven generates test reports under:

```text
target/surefire-reports/
```

### Generate and open an Allure report locally

After running the tests, generate the report:

```bash
allure generate allure-results --clean -o allure-report
```

Open it in your browser:

```bash
allure open allure-report
```

Allure Commandline must be installed to use these commands.

## Jira Defect Tracking

Jira was used to manage QA activities for the e-commerce application.

- Created and tracked verified defects
- Documented reproduction steps, expected results, actual results, and test data
- Attached screenshots as defect evidence
- Linked defects to functional testing work items for traceability
- Managed defect priority, assignee, and status
- Used Epic, Story, Subtask, Bug, Sprint, and Board features
- Added retest comments to document defect reproduction

## Postman API Testing

The existing Postman collection and screenshots document API testing exercises for GET, POST, PUT, and DELETE operations.

The Postman exercises are maintained separately from the REST Assured automation suite.

## Project Deliverables

- Test Plan
- Test Scenarios
- Test Cases
- Defect Report
- Smoke Testing Report
- Regression Testing Report
- Requirements Traceability Matrix (RTM)
- API Testing Report
- SQL Validation Queries
- Final Test Report
- Selenium UI Automation Tests
- REST Assured API Automation Tests
- Maven Surefire Test Reports
- Allure HTML Test Report
- GitHub Actions CI Workflow

## Outcome

The project combines manual QA documentation, Jira-based defect tracking, Postman API testing, SQL validation exercises, Selenium UI automation, REST Assured API automation, CI execution, and Allure reporting.

The latest verified combined test run completed with **15 passing tests and no failures or errors**. GitHub Actions also completed successfully, generating and uploading the Allure HTML report.