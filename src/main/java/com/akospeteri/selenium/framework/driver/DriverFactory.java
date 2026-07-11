package com.akospeteri.selenium.framework.driver;

import com.akospeteri.selenium.framework.config.FrameworkConfig;
import com.akospeteri.selenium.framework.driver.provider.DriverProvider;
import com.akospeteri.selenium.framework.driver.provider.local.ChromeDriverProvider;
import com.akospeteri.selenium.framework.driver.provider.local.EdgeDriverProvider;
import com.akospeteri.selenium.framework.driver.provider.local.FirefoxDriverProvider;
import com.akospeteri.selenium.framework.driver.provider.remote.SeleniumGridDriverProvider;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DriverFactory {
    
    private static final Logger LOG = LoggerFactory.getLogger(DriverFactory.class);
    
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    
    private DriverFactory() {
    }
    
    public static void createDriver(FrameworkConfig config) {
        
        DriverProvider provider;
        
        switch (config.executionMode()) {
            
            case LOCAL -> provider = switch (config.browser()) {
                    case CHROME -> new ChromeDriverProvider();
                    case FIREFOX -> new FirefoxDriverProvider();
                    case EDGE -> new EdgeDriverProvider();
            };
            
            case REMOTE -> provider = new SeleniumGridDriverProvider();
            
            default -> throw new IllegalArgumentException(
                    "Unsupported execution mode: " + config.executionMode());
        }
        
        LOG.info("Creating {} {} driver",
                config.executionMode(),
                config.browser());
        
        DRIVER.set(provider.createDriver(config));
        
        LOG.info("{} {} driver created successfully",
                config.executionMode(),
                config.browser());
    }
    
    public static WebDriver getDriver() {
        return DRIVER.get();
    }
    
    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            LOG.info("Closing browser");
            driver.quit();
            DRIVER.remove();
        }
    }
}
