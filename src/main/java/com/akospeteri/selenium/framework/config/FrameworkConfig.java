package com.akospeteri.selenium.framework.config;

import com.akospeteri.selenium.framework.driver.BrowserType;
import com.akospeteri.selenium.framework.driver.ExecutionMode;

public record FrameworkConfig(
        
        String baseUrl,
        
        BrowserType browser,
        
        boolean headless,
        
        int implicitWait,
        
        int explicitWait,
        
        ExecutionMode executionMode,
        
        String gridUrl,
        
        int pageLoadTimeout

) {
}
