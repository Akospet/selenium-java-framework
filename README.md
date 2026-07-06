Why TestNG instead of JUnit 5?

This framework intentionally uses TestNG because it reflects the enterprise automation stacks I worked with 
in production environments, where TestNG's suite management, listeners, parallel execution and BrowserStack 
integration were standard.
A companion repository demonstrates the same architectural principles using Playwright and JUnit 5.

# Enterprise Selenium Test Automation Framework

> Enterprise-grade Selenium Test Automation Framework built with Java 21, Selenium 4, TestNG and BrowserStack.

🚧 Project under active development.

## Goals

- Modern Java 21
- Clean Architecture
- SOLID principles
- Enterprise-grade Selenium framework
- Parallel execution
- BrowserStack integration
- GitHub Actions CI

## Technology Stack

- Java 21
- Maven
- Selenium 4
- TestNG
- WebDriverManager
- SLF4J + Logback
- BrowserStack
- GitHub Actions

## Current Status

- [x] Maven project
- [x] Configuration layer
- [x] DriverFactory
- [ ] BasePage
- [ ] Login Page
- [ ] Smoke Tests
- [ ] BrowserStack
- [ ] Reporting

---

**More documentation will be added as the framework evolves.**
