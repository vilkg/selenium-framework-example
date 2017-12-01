package com.vilkg.framework.listeners;

import com.vilkg.framework.core.configuration.ConfigurationManager;
import com.vilkg.framework.core.drivers.DriverManager;
import com.vilkg.framework.core.drivers.factory.LocalDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Created by vilkg on 10/2/2017.
 */
public class LocalTestListener implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            WebDriver driver = LocalDriverFactory.initDriver(false, ConfigurationManager.getBrowser());

            DriverManager.setDriver(driver);
        }
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            DriverManager.destroyDriver();
        }
    }
}
