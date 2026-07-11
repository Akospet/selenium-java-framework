package com.akospeteri.selenium.framework.driver.provider.local;

import com.akospeteri.selenium.framework.config.FrameworkConfig;
import com.akospeteri.selenium.framework.driver.provider.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirefoxDriverProvider implements DriverProvider {
    
    private static final Logger LOG = LoggerFactory.getLogger(FirefoxDriverProvider.class);
    
    @Override
    public WebDriver createDriver(FrameworkConfig config) {
        
        FirefoxOptions options = new FirefoxOptions();
        
        if (config.headless()) {
            LOG.info("Starting Firefox in headless mode");
            
            options.addArguments("-headless");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
        } else {
            LOG.info("Starting Firefox in headed mode");
        }
        
        WebDriver driver = new FirefoxDriver(options);
        
        if (!config.headless()) {
            driver.manage().window().maximize();
        }
        
        return driver;
    }
}
