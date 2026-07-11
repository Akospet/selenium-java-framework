package com.akospeteri.selenium.framework.driver.provider.local;

import com.akospeteri.selenium.framework.config.FrameworkConfig;
import com.akospeteri.selenium.framework.driver.provider.DriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverProvider implements DriverProvider {
    
    @Override
    public WebDriver createDriver(FrameworkConfig config) {
        
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--start-maximized");
        
        if (config.headless()) {
            options.addArguments("--headless=new");
        }
        
        return new ChromeDriver(options);
    }
}
