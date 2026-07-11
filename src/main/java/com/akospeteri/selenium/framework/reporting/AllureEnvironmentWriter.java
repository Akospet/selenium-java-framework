package com.akospeteri.selenium.framework.reporting;

import com.akospeteri.selenium.framework.config.FrameworkConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public final class AllureEnvironmentWriter {
    
    private AllureEnvironmentWriter() {
    }
    
    public static void write(FrameworkConfig config) {
        
        try {
            
            Files.createDirectories(Path.of("allure-results"));
            
            try (PrintWriter writer = new PrintWriter("allure-results/environment.properties")) {
                
                writer.println("Browser=" + config.browser());
                writer.println("Headless=" + config.headless());
                writer.println("Base URL=" + config.baseUrl());
                
                writer.println("Java=" + System.getProperty("java.version"));
                writer.println("OS=" + System.getProperty("os.name"));
                
                writer.println("Framework=Selenium Java Framework");
                writer.println("Selenium=4.35.0");
            }
            
        } catch (IOException e) {
            throw new RuntimeException("Unable to create Allure environment file.", e);
        }
    }
}
