package com.vilkg.framework.core.enums;

/**
 * Created by vilkg on 10/2/2017.
 */
public enum Browser {
    FIREFOX,
    CHROME,
    IE;

    public static Browser fromString(final String stringRepresentation) {
        return Browser.valueOf(stringRepresentation);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
