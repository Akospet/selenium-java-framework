package com.akospeteri.selenium.tests.ui;

import com.akospeteri.selenium.framework.pages.InventoryPage;
import com.akospeteri.selenium.framework.pages.LoginPage;
import com.akospeteri.selenium.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class LoginTest extends BaseTest {
    
    @Test
    public void validUserCanLogin() {
        
        LoginPage loginPage = new LoginPage(driver, config.explicitWait());
        
        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");
        
        assertFalse(inventoryPage.isLoaded());
    }
}
