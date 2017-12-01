package com.vilkg.framework.core.configuration;

import org.apache.commons.lang.StringUtils;

/**
 * Created by vilkg on 10/2/2017.
 */
public class EnvironmentVarsExtractor {
    protected EnvironmentVarsExtractor() {

    }

    protected String getProperty(final String propertyName, final String defaultValue) {

        String propertyValue = System.getProperty(propertyName);

        if (StringUtils.isNotEmpty(propertyValue)) {
            return propertyValue;
        }

        return defaultValue;
    }
}
