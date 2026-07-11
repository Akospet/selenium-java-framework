# Enterprise Selenium Test Automation Framework

> Enterprise-grade Selenium Test Automation Framework built with Java 21, Selenium 4, TestNG and GitHub Actions.

🚧 **Project under active development**

## Why TestNG instead of JUnit 5?

This framework intentionally uses TestNG because it reflects the enterprise automation stacks I worked with in production environments, where TestNG's suite management, listeners, parallel execution and BrowserStack integration were standard.

A companion repository will demonstrate the same architectural principles using Playwright and JUnit 5.

---

## Goals

- Enterprise-grade Selenium framework
- Modern Java 21
- Clean Architecture
- SOLID principles
- Thread-safe WebDriver management
- Cross-browser execution
- Parallel execution
- CI/CD with GitHub Actions
- Local WebDriver execution
- Remote Selenium Grid execution
- Cross-browser support (Chrome, Firefox, Edge)

---

## Technology Stack

- Java 21
- Maven
- Selenium 4.35
- TestNG
- Selenium Manager
- SLF4J + Logback
- GitHub Actions
- BrowserStack *(planned)*
- Allure Report *(planned)*

---

## Current Features

- ✅ Maven project structure
- ✅ Configuration layer
- ✅ DriverFactory
- ✅ Thread-safe WebDriver management
- ✅ Page Object Model
- ✅ BasePage abstraction
- ✅ Login Page
- ✅ Inventory Page
- ✅ TestNG Listeners
- ✅ Automatic screenshots on test failure
- ✅ SLF4J + Logback logging
- ✅ Configurable headless execution
- ✅ GitHub Actions CI

---

## Planned Features

- Firefox support
- Edge support
- Parallel execution
- BrowserStack integration
- Allure reporting
- Selenium Grid
- Docker support

---

## CI

Every push to the `main` branch automatically:

- Builds the project
- Executes the TestNG test suite
- Runs Chrome in headless mode
- Publishes test results on GitHub Actions

---

**This repository is being developed as an enterprise-style Selenium framework and serves as part of my professional automation testing portfolio.**
