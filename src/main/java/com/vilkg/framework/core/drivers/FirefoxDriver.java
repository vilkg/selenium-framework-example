package com.vilkg.framework.core.drivers;

import com.vilkg.framework.core.configuration.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by vilkg on 10/2/2017.
 */
public class FirefoxDriver implements Driver {
    private String firefoxDriverPropertyName = "webdriver.gecko.driver";

    public WebDriver init(final URL gridUrl) {
        if (gridUrl == null) {
            System.setProperty(firefoxDriverPropertyName, ConfigurationManager.pathToFirefox());
            return new org.openqa.selenium.firefox.FirefoxDriver(capabilities());
        }

        return new RemoteWebDriver(gridUrl, capabilities());

    }

    public FirefoxOptions capabilities() {
        FirefoxOptions capabilities = new FirefoxOptions();

        return capabilities;
    }
}
