# E-Commerce Web Application Testing

## Overview

This project demonstrates a combination of manual testing and UI test automation for a demo e-commerce web application. It covers Software Testing Life Cycle (STLC) activities, including test planning, test scenario creation, test case design, test execution, defect reporting, API testing, SQL validation, and test reporting.

The project also includes Selenium WebDriver automation using Java, JUnit 5, Maven, and the Page Object Model (POM) design pattern.

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

## Testing Performed

### Manual Testing

- Functional Testing
- Positive and Negative Testing
- Boundary Value Testing
- Smoke Testing
- Regression Testing
- Test Case and Test Scenario Design
- Requirements Traceability Matrix (RTM)
- Defect Reporting and Tracking using Jira

### UI Test Automation

Automated browser tests were implemented using Selenium WebDriver and Java.

Current automated coverage includes:

- Opening the e-commerce website
- Verifying that the product search field is displayed
- Entering a search term
- Searching for matching products
- Searching for a term with no matching products
- Submitting an empty search
- Clearing the search field
- Searching with different product terms

**Latest verified execution:** 8 tests passed, with 0 failures, 0 errors, and 0 skipped tests.

### API Testing

Postman was used to test the following API operations:

- GET `/products`
- GET `/products/1`
- POST `/products`
- PUT `/products/1`
- DELETE `/products/1`

### SQL Database Validation

SQL validation exercises covered the following entities:

- Users
- Products
- Cart
- Orders
- Payments

The API practice and SQL validation activities are separate from the Selenium UI automation suite.

## Technology Stack and Tools

- Java 17
- Selenium WebDriver 4.39.0
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
                    └── pages/
                        ├── HomePage.java
                        └── ProductsPage.java
```

- `BaseTest.java` — shared browser setup and teardown.
- `BrowserLaunchTest.java` — browser launch and basic search-field checks.
- `ProductSearchTest.java` — automated product-search scenarios.
- `HomePage.java` and `ProductsPage.java` — page interaction methods following the Page Object Model.

## Running the Automated Tests

### Prerequisites

- Java JDK 17 or compatible version
- Maven
- Google Chrome
- Internet connection to access the demo application

### Execute the test suite

From the project root directory, run:

```bash
mvn clean test
```

Maven executes the JUnit test suite and generates test reports under:

```text
target/surefire-reports/
```

## Jira Defect Tracking

Jira was used to manage and track QA activities for the e-commerce application.

- Created and tracked verified defects
- Documented reproduction steps, expected results, actual results, and test data
- Attached screenshots as defect evidence
- Linked defects to functional testing work items for traceability
- Managed defect priority, assignee, and status
- Used Epic, Story, Subtask, Bug, Sprint, and Board features
- Added retest comments to document defect reproduction

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
- Maven Surefire Test Reports

## Outcome

The project combines manual QA documentation, Jira-based defect tracking, Postman API testing, SQL validation exercises, and Selenium UI automation. The current automated suite contains eight verified passing tests covering browser launch and product-search behavior on the demo e-commerce application.