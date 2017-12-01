package com.vilkg.framework.listeners;

import com.vilkg.framework.core.configuration.ConfigurationManager;
import com.vilkg.framework.core.drivers.DriverManager;
import com.vilkg.framework.core.drivers.factory.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;

/**
 * Created by vilkg on 12/1/2017.
 */
public class RemoteTestListener {
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            WebDriver driver = RemoteDriverFactory.initDriver(true, ConfigurationManager.getBrowser());

            DriverManager.setDriver(driver);
        }
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            DriverManager.destroyDriver();
        }
    }
}
