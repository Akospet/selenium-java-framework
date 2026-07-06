package com.akospeteri.selenium.framework.driver;

import com.akospeteri.selenium.framework.config.FrameworkConfig;
import com.akospeteri.selenium.framework.driver.provider.local.ChromeDriverProvider;
import com.akospeteri.selenium.framework.driver.provider.DriverProvider;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {
    
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    
    private DriverFactory() {}
    
    public static void createDriver(FrameworkConfig config) {

        DriverProvider provider = switch (config.browser()) {
            case CHROME -> new ChromeDriverProvider();
            
            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + config.browser());
        };
        DRIVER.set(provider.createDriver(config));
    }
    
    public static WebDriver getDriver() {
        return DRIVER.get();
    }
    
    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
            DRIVER.remove();
        }
    }
}
