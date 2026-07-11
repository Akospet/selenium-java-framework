package com.akospeteri.selenium.framework.config;

import com.akospeteri.selenium.framework.driver.BrowserType;
import com.akospeteri.selenium.framework.driver.ExecutionMode;

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
                    resolveProperty(properties, "base.url"),
                    BrowserType.valueOf(resolveProperty(properties, "browser").toUpperCase()),
                    Boolean.parseBoolean(resolveProperty(properties, "headless")),
                    Integer.parseInt(resolveProperty(properties, "implicit.wait")),
                    Integer.parseInt(resolveProperty(properties, "explicit.wait")),
                    ExecutionMode.valueOf(
                            properties.getProperty("execution.mode").toUpperCase()
                    ),
                    properties.getProperty("grid.url"),
                    Integer.parseInt(resolveProperty(properties, "page.load.timeout"))
            );
            
        } catch (IOException e) {
            throw new RuntimeException("Unable to load configuration.", e);
        }
    }
    
    private String resolveProperty(Properties properties, String key) {
        return System.getProperty(key, properties.getProperty(key));
    }
}
