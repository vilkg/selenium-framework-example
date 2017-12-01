package com.vilkg.framework.core.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vilkg on 10/2/2017.
 */
public class BasePage {
    private WebDriver driver;

    public BasePage(final WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
