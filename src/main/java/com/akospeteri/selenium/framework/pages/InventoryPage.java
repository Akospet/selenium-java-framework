package com.akospeteri.selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    
    private final By inventoryContainer = By.id("inventory_container");
    
    public InventoryPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }
    
    public boolean isLoaded() {
        return isDisplayed(inventoryContainer);
    }
}
