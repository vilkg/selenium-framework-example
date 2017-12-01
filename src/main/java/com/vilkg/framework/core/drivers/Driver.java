package com.vilkg.framework.core.drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.URL;

/**
 * Created by vilkg on 10/9/2017.
 */
public interface Driver {
    WebDriver init(URL gridUrl);

    MutableCapabilities capabilities();
}
