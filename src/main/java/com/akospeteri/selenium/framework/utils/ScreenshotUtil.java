package com.akospeteri.selenium.framework.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtil {
    
    private static final Logger LOG = LoggerFactory.getLogger(ScreenshotUtil.class);
    private static final Path SCREENSHOT_DIR = Path.of("target", "screenshots");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    
    private ScreenshotUtil() {}
    
    public static Path capture(WebDriver driver, String testName) {
        try {
            Files.createDirectories(SCREENSHOT_DIR);
            String filename = testName + "_"
                    + LocalDateTime.now().format(FORMATTER)
                    + ".png";
            
            Path destination = SCREENSHOT_DIR.resolve(filename);
            Path source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE)
                    .toPath();
            
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            LOG.info("Screenshot saved to {}", destination.toAbsolutePath());
            attachToAllure(destination);
            return destination;
        } catch (IOException e) {
            LOG.error("Unable to capture screenshot.", e);
            throw new ScreenshotException("Unable to capture screenshot.", e);
        }
    }
    
    @Attachment(value = "Failure Screenshot", type = "image/png")
    private static byte[] attachToAllure(Path screenshot) {
        
        try {
            LOG.info("Attaching screenshot to Allure report.");
            return Files.readAllBytes(screenshot);
        } catch (IOException e) {
            LOG.warn("Unable to attach screenshot to Allure report.", e);
            return new byte[0];
        }
    }
}
