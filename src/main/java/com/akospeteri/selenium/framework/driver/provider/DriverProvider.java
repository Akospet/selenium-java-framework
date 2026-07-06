package com.akospeteri.selenium.framework.driver.provider;

import com.akospeteri.selenium.framework.config.FrameworkConfig;
import org.openqa.selenium.WebDriver;

/**
 * WHAT IS IT ???
 * <p>
 * WHAT PURPOSE THAT IT HAS ???
 * </p>
 *
 * @author peteriakos
 * @since 2026-07-06
 */
public interface DriverProvider {
    WebDriver createDriver(FrameworkConfig config);
}
