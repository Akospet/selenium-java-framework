package com.akospeteri.selenium.tests.base;

import com.akospeteri.selenium.framework.config.ConfigReader;
import com.akospeteri.selenium.framework.config.FrameworkConfig;
import com.akospeteri.selenium.framework.driver.DriverFactory;
import com.akospeteri.selenium.tests.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;

@Listeners(TestListener.class)
public abstract class BaseTest {
    private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
    
    protected FrameworkConfig config;
    protected WebDriver driver;

    @BeforeMethod
    public void setup(Method method) {
        LOG.info("========== START TEST: {} ==========", method.getName());
        config = new ConfigReader().load();
        DriverFactory.createDriver(config);
        driver = DriverFactory.getDriver();
        driver.get(config.baseUrl());
    }
    
    @AfterMethod
    public void tearDown(Method method) {
        LOG.info("========== END TEST: {} ==========", method.getName());
        DriverFactory.quitDriver();
    }
}
