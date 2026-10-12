# E-Commerce Web Application Testing

## Overview

This project demonstrates manual testing and automated testing for a demo e-commerce web application. It covers Software Testing Life Cycle (STLC) activities, including test planning, test scenario creation, test case design, test execution, defect reporting, API testing, SQL validation exercises, and test reporting.

The automation suite uses Selenium WebDriver with Java for UI testing and REST Assured with JUnit 5 for API testing.

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

Selenium WebDriver and Java are used to automate browser interactions with the demo e-commerce application.

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

REST Assured and JUnit 5 are used to automate HTTP API requests against the Fake Store API.

Current coverage includes:

- GET `/products` — status code, JSON response, and product list validation
- GET `/products` — product field validation
- GET `/products/1` — single product validation
- GET `/products/999999` — empty response validation for a nonexistent product
- POST `/products` — created product response validation
- PUT `/products/1` — updated product response validation
- DELETE `/products/1` — delete response validation

Fake Store API is a practice API. POST, PUT, and DELETE tests validate the returned responses and do not establish that changes are permanently stored.

**Latest verified API test count:** 7 passed.

## Combined Automation Results

The latest full Maven test run completed successfully:

- Total tests: 15
- Passed: 15
- Failures: 0
- Errors: 0
- Skipped: 0

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

## Outcome

The project combines manual QA documentation, Jira-based defect tracking, Postman API testing, SQL validation exercises, Selenium UI automation, and REST Assured API automation. The latest verified combined test run completed with 15 passing tests and no failures or errors.