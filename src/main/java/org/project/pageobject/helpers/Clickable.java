package org.project.pageobject.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public interface Clickable extends Findable {

    default void clickOnClickableElement(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", findElement(locator));
    }
}
