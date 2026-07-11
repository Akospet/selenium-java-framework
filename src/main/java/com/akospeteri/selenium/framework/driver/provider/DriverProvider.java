package com.akospeteri.selenium.framework.driver.provider;

import com.akospeteri.selenium.framework.config.FrameworkConfig;
import org.openqa.selenium.WebDriver;

public interface DriverProvider {
    WebDriver createDriver(FrameworkConfig config);
}
