package com.vilkg.framework.core.drivers.factory;

import com.vilkg.framework.core.configuration.ConfigurationManager;
import com.vilkg.framework.core.drivers.ChromeDriver;
import com.vilkg.framework.core.drivers.FirefoxDriver;
import com.vilkg.framework.core.drivers.IEDriver;
import com.vilkg.framework.core.enums.Browser;
import org.openqa.selenium.WebDriver;

import java.net.URL;

/**
 * Created by vilkg on 10/9/2017.
 */
public class DriverFactory {

    protected DriverFactory() {
    }

    public static WebDriver initDriver(final boolean isRemote, final Browser browser) {
        URL gridUrl = null;
        WebDriver driver = null;

        if (isRemote) {
            gridUrl = ConfigurationManager.getGridUrl();
        }

        if (browser == Browser.CHROME) {
            driver = new ChromeDriver().init(gridUrl);
        }

        if (browser == Browser.FIREFOX) {
            driver = new FirefoxDriver().init(gridUrl);
        }

        if (browser == Browser.IE) {
            driver = new IEDriver().init(gridUrl);
        }

        return driver;
    }
}
