package com.vilkg.framework.core;

import com.vilkg.framework.core.configuration.ConfigurationManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by vilkg on 10/2/2017.
 */
public class Screenshooter {
    private WebDriver driver;

    public Screenshooter(final WebDriver webDriver) {
        this.driver = webDriver;
    }

    private File takeScreenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        return screenshot;
    }

    public void saveScreenshot(final String name) {
        File tempFile = takeScreenshot();

        File destFile = new File(ConfigurationManager.getPathToScreenshots() + name + ".jpg");

        try {
            FileUtils.copyFile(tempFile, destFile);
        } catch (IOException e) {
            Logger.getGlobal().warning("Screenshot was not taken");
        }
    }

    public byte[] takeScreenshotAsByte() {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        return screenshot;
    }
}
