package com.akospeteri.selenium.tests.base;

import com.akospeteri.selenium.framework.config.ConfigReader;
import com.akospeteri.selenium.framework.config.FrameworkConfig;
import com.akospeteri.selenium.framework.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    
    protected FrameworkConfig config;
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        config = new ConfigReader().load();
        DriverFactory.createDriver(config);
        driver = DriverFactory.getDriver();
        driver.get(config.baseUrl());
    }
    
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
