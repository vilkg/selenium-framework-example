package com.vilkg.framework.core.configuration;

import com.vilkg.framework.core.enums.Browser;

import java.net.URL;

/**
 * Created by vilkg on 10/1/2017.
 */
public final class ConfigurationManager {
    private static final String BASE_URL_PROPERTY_NAME = "baseUrl";
    private static final String GRID_URL_PROPERTY_NAME = "gridUrl";
    private static final String BROWSER_PROPERTY_NAME = "browser";
    private static final String PATH_TO_IE_PROPERTY_NAME = "webdriver.ie.driver";
    private static final String PATH_TO_FIREFOX_PROPERTY_NAME = "webdriver.gecko.driver";
    private static final String PATH_TO_CHROME_PROPERTY_NAME = "webdriver.chrome.driver";
    private static final String TAKE_SCREENSHOTS_ON_FAILURE_PROPERTY_NAME = "takeScreenshotsOnFailure";
    private static final String PATH_TO_SCREENSHOTS_PROPERTY_NAME = "pathToScreenshots";
    private static ConfigurationExtractor extractor;
    private static EnvironmentVarsExtractor environmentVariablesExtractor;
    private static URL baseUrl;
    private static URL gridUrl;
    private static String browser;
    private static String pathToIe;
    private static String pathToChrome;
    private static String pathToFirefox;
    private static Boolean shouldTakeScreenshotsOnFailure;
    private static String pathToScreenshots;

    static {
        extractor = new ConfigurationExtractor("config.properties");
        environmentVariablesExtractor = new EnvironmentVarsExtractor();
        baseUrl = extractor.getUrlProperty(BASE_URL_PROPERTY_NAME);
        gridUrl = extractor.getUrlProperty(GRID_URL_PROPERTY_NAME);
        browser = environmentVariablesExtractor.getProperty(BROWSER_PROPERTY_NAME, "firefox");
        pathToChrome = extractor.getProperty(PATH_TO_CHROME_PROPERTY_NAME);
        pathToFirefox = extractor.getProperty(PATH_TO_FIREFOX_PROPERTY_NAME);
        pathToIe = extractor.getProperty(PATH_TO_IE_PROPERTY_NAME);
        shouldTakeScreenshotsOnFailure = extractor.getBooleanProperty(TAKE_SCREENSHOTS_ON_FAILURE_PROPERTY_NAME);
        pathToScreenshots = extractor.getProperty(PATH_TO_SCREENSHOTS_PROPERTY_NAME);
    }

    private ConfigurationManager() {
    }

    public static URL getBaseUrl() {
        return baseUrl;
    }

    public static URL getGridUrl() {
        return gridUrl;
    }

    public static Browser getBrowser() {
        return Browser.fromString(browser);
    }

    public static String pathToChrome() {
        return pathToChrome;
    }

    public static String pathToFirefox() {
        return pathToFirefox;
    }

    public static String pathToIE() {
        return pathToIe;
    }

    public static boolean shouldTakeScreenshotOnFailure() {
        return shouldTakeScreenshotsOnFailure;
    }

    public static String getPathToScreenshots() {
        return pathToScreenshots;
    }
}
