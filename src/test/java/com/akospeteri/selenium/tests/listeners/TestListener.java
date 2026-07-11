package com.akospeteri.selenium.tests.listeners;

import com.akospeteri.selenium.framework.driver.DriverFactory;
import com.akospeteri.selenium.framework.utils.ScreenshotUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger LOG = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.error("Test failed. {}", result.getMethod().getMethodName(), result.getThrowable());
    }
}
