package com.akospeteri.selenium.framework.pages;

import com.akospeteri.selenium.framework.wait.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    
    protected final WebDriver driver;
    protected final WaitHelper wait;
    protected final int timeout;
    
    protected BasePage(WebDriver driver, int timeout) {
        this.driver = driver;
        this.timeout = timeout;
        this.wait = new WaitHelper(driver, timeout);
    }
    
    protected void click(By locator) {
        wait.untilClickable(locator).click();
    }
    
    protected void type(By locator, String value) {
        var element = wait.untilVisible(locator);
        element.clear();
        element.sendKeys(value);
    }
    
    protected String text(By locator) {
        return wait.untilVisible(locator).getText();
    }
    
    protected boolean isDisplayed(By locator) {
        return wait.untilVisible(locator).isDisplayed();
    }
}
