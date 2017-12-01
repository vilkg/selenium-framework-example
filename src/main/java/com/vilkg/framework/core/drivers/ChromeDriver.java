package com.vilkg.framework.core.drivers;

import com.vilkg.framework.core.configuration.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by vilkg on 10/2/2017.
 */
public class ChromeDriver implements Driver {
    private String chromeDriverPropertyName = "webdriver.chrome.driver";

    public WebDriver init(final URL gridUrl) {
        if (gridUrl == null) {
            System.setProperty(chromeDriverPropertyName, ConfigurationManager.pathToChrome());
            ChromeDriverService service = ChromeDriverService.createDefaultService();
            return new org.openqa.selenium.chrome.ChromeDriver(service, capabilities());
        }

        return new RemoteWebDriver(gridUrl, capabilities());

    }

    public ChromeOptions capabilities() {
        ChromeOptions capabilities = new ChromeOptions();

        return capabilities;
    }
}
