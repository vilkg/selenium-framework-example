package com.vilkg.framework.stepDefs.hooks;

import com.vilkg.framework.core.Screenshooter;
import com.vilkg.framework.core.configuration.ConfigurationManager;
import com.vilkg.framework.core.drivers.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;


/**
 * Created by vilkg on 10/2/2017.
 */
public class ScreenshotingHook {
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && ConfigurationManager.shouldTakeScreenshotOnFailure()) {
            Screenshooter screenshooter = new Screenshooter(DriverManager.getDriver());

            String name = scenario.getName().trim() + "-" + ConfigurationManager.getBrowser();

            byte[] bytes = screenshooter.takeScreenshotAsByte();

            screenshooter.saveScreenshot(name);

            scenario.embed(bytes, "image/png");
        }
    }
}
