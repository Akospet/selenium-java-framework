package com.akospeteri.selenium.framework.driver.provider.remote;

import com.akospeteri.selenium.framework.config.FrameworkConfig;
import com.akospeteri.selenium.framework.driver.provider.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridDriverProvider implements DriverProvider {
    
    private static final Logger LOG = LoggerFactory.getLogger(SeleniumGridDriverProvider.class);
    
    @Override
    public WebDriver createDriver(FrameworkConfig config) {
        
        LOG.info("Connecting to Selenium Grid: {}", config.gridUrl());
        
        try {
            
            return switch (config.browser()) {
                
                case CHROME -> new RemoteWebDriver(
                        new URL(config.gridUrl()),
                        createChromeOptions(config));
                
                case FIREFOX -> new RemoteWebDriver(
                        new URL(config.gridUrl()),
                        createFirefoxOptions(config));
                
                case EDGE -> new RemoteWebDriver(
                        new URL(config.gridUrl()),
                        createEdgeOptions(config));
            };
            
        } catch (MalformedURLException e) {
            throw new IllegalStateException(
                    "Invalid Selenium Grid URL: " + config.gridUrl(), e);
        }
    }
    
    private ChromeOptions createChromeOptions(FrameworkConfig config) {
        
        ChromeOptions options = new ChromeOptions();
        
        if (config.headless()) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        
        return options;
    }
    
    private FirefoxOptions createFirefoxOptions(FrameworkConfig config) {
        
        FirefoxOptions options = new FirefoxOptions();
        
        if (config.headless()) {
            options.addArguments("-headless");
        }
        
        return options;
    }
    
    private EdgeOptions createEdgeOptions(FrameworkConfig config) {
        
        EdgeOptions options = new EdgeOptions();
        
        if (config.headless()) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        
        return options;
    }
}
