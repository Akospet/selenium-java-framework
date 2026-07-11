package com.akospeteri.selenium.framework.driver.provider.local;

import com.akospeteri.selenium.framework.config.FrameworkConfig;
import com.akospeteri.selenium.framework.driver.provider.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeDriverProvider implements DriverProvider {
    
    private static final Logger LOG = LoggerFactory.getLogger(ChromeDriverProvider.class);
    
    @Override
    public WebDriver createDriver(FrameworkConfig config) {
        
        ChromeOptions options = new ChromeOptions();
        
        if (config.headless()) {
            LOG.info("Starting Chrome in headless mode");
            
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        } else {
            LOG.info("Starting Chrome in headed mode");
            options.addArguments("--start-maximized");
        }
        
        return new ChromeDriver(options);
    }
}
