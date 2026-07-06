package com.akospeteri.selenium.framework.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    
    private final WebDriver driver;
    private final WebDriverWait wait;
    
    public WaitHelper(WebDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }
    
    public WebElement untilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public WebElement untilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
