package com.vilkg.framework.core.helpers;

import org.openqa.selenium.WebDriver;

import java.net.URL;

/**
 * Created by vilkg on 10/2/2017.
 */
public class Navigate {
    private WebDriver driver;

    public Navigate(final WebDriver webDriver) {
        this.driver = webDriver;
    }

    public static Navigate driver(final WebDriver driver) {
        return new Navigate(driver);
    }

    public void toUrl(final URL url) {
        driver.navigate().to(url);
    }
}
