package com.akospeteri.selenium.framework.config;

import com.akospeteri.selenium.framework.driver.BrowserType;

public record FrameworkConfig(
        
        String baseUrl,
        
        BrowserType browser,
        
        boolean headless,
        
        int implicitWait,
        
        int explicitWait,
        
        int pageLoadTimeout

) {
}
