package com.vilkg.framework.core.drivers;

import org.openqa.selenium.WebDriver;

/**
 * Created by vilkg on 10/2/2017.
 */
public class DriverManager {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return DriverManager.driverThreadLocal.get();
    }

    public static void setDriver(final WebDriver driver) {
        DriverManager.driverThreadLocal.set(driver);
    }

    public static void destroyDriver() {
        if (DriverManager.driverThreadLocal.get() != null) {
            DriverManager.driverThreadLocal.get().quit();
            DriverManager.driverThreadLocal.remove();
        }
    }
}
