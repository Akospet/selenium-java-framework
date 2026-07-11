package com.akospeteri.selenium.framework.listeners;

import com.akospeteri.selenium.framework.driver.DriverFactory;
import com.akospeteri.selenium.framework.utils.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    
    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtil.capture(
                DriverFactory.getDriver(),
                result.getMethod().getMethodName()
        );
    }
}
