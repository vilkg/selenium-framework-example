package com.vilkg.framework.core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by vilkg on 10/2/2017.
 */
public class ConfigurationExtractor {
    private Properties properties;

    protected ConfigurationExtractor(final String fileName) {

        this.properties = initProperties(fileName);
    }

    protected String getProperty(final String propertyName) {
        String propertyValue = properties.getProperty(propertyName);

        return propertyValue;
    }

    public Boolean getBooleanProperty(final String propertyName) {
        String property = getProperty(propertyName);

        return Boolean.parseBoolean(property);
    }

    protected URL getUrlProperty(final String propertyName) {
        URL url = null;

        String property = getProperty(propertyName);

        try {
            url = new URL(property);
        } catch (MalformedURLException ex) {
            Logger.getGlobal().severe("property " + propertyName + " is not url");
        }

        return url;
    }

    private Properties initProperties(final String fileName) {
        Properties props = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(fileName);
            props.load(inputStream);
        } catch (FileNotFoundException e) {
            System.out.print("No file.");
        } catch (IOException exception) {
            System.out.print("Couldn't load properties");
        }

        return properties;
    }
}
