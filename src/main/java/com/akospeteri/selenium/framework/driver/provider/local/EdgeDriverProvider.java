package com.akospeteri.selenium.framework.driver.provider.local;

import com.akospeteri.selenium.framework.config.FrameworkConfig;
import com.akospeteri.selenium.framework.driver.provider.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdgeDriverProvider implements DriverProvider {
    
    private static final Logger LOG = LoggerFactory.getLogger(EdgeDriverProvider.class);
    
    @Override
    public WebDriver createDriver(FrameworkConfig config) {
        
        EdgeOptions options = new EdgeOptions();
        
        if (config.headless()) {
            LOG.info("Starting Edge in headless mode");
            
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
        } else {
            LOG.info("Starting Edge in headed mode");
            options.addArguments("--start-maximized");
        }
        
        return new EdgeDriver(options);
    }
}
