package com.akospeteri.selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    
    public LoginPage(WebDriver driver, int timeout) {
        super(driver, timeout);
    }
    
    public InventoryPage login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginButton);
        
        return new InventoryPage(driver, timeout);
    }
}
