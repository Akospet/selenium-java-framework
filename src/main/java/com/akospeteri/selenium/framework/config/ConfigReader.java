package com.akospeteri.selenium.framework.config;

import com.akospeteri.selenium.framework.driver.BrowserType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    
    public FrameworkConfig load() {
        
        Properties properties = new Properties();
        
        try (InputStream inputStream =
                     getClass().getClassLoader().getResourceAsStream("config.properties")) {
            
            if (inputStream == null) {
                throw new IllegalStateException("config.properties not found.");
            }
            
            properties.load(inputStream);
            
            return new FrameworkConfig(
                    properties.getProperty("base.url"),
                    BrowserType.valueOf(properties.getProperty("browser").toUpperCase()),
                    Boolean.parseBoolean(properties.getProperty("headless")),
                    Integer.parseInt(properties.getProperty("implicit.wait")),
                    Integer.parseInt(properties.getProperty("explicit.wait")),
                    Integer.parseInt(properties.getProperty("page.load.timeout"))
            );
            
        } catch (IOException e) {
            throw new RuntimeException("Unable to load configuration.", e);
        }
    }
}
