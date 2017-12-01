package com.vilkg.framework.core.drivers.factory;

import com.vilkg.framework.core.enums.Browser;
import org.openqa.selenium.WebDriver;

/**
 * Created by vilkg on 10/9/2017.
 */
public class RemoteDriverFactory extends DriverFactory {
    public static WebDriver initDriver(final Browser browser) {
        WebDriver driver = initDriver(true, browser);

        return driver;
    }
}
