package com.vilkg.framework.actions;

import org.openqa.selenium.WebElement;

/**
 * Created by vilkg on 10/2/2017.
 */
public class Click {
    private Click() {
    }

    public static void element(final WebElement element) {
        element.click();
    }
}
