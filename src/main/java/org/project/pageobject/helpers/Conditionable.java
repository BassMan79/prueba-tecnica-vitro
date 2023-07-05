package org.project.pageobject.helpers;

import org.openqa.selenium.By;

public interface Conditionable extends Waitable {

    default boolean elementIsVisible(By locator) {
        return findElement(locator).isDisplayed();
    }
}
