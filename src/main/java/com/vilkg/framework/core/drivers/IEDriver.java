package com.vilkg.framework.core.drivers;

import com.vilkg.framework.core.configuration.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by vilkg on 10/2/2017.
 */
public class IEDriver implements Driver {
    private String ieDriverPropertyName = "webdriver.ie.driver";

    public WebDriver init(final URL gridUrl) {
        if (gridUrl == null) {
            System.setProperty(ieDriverPropertyName, ConfigurationManager.pathToIE());
            InternetExplorerDriverService service = InternetExplorerDriverService.createDefaultService();

            return new InternetExplorerDriver(service, capabilities());
        }

        return new RemoteWebDriver(gridUrl, capabilities());
    }

    public InternetExplorerOptions capabilities() {
        InternetExplorerOptions capabilities = new InternetExplorerOptions();
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

        return capabilities;
    }
}
