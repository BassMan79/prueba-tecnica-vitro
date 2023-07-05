package org.project.pageobject;

import org.openqa.selenium.WebDriver;
import org.project.pageobject.helpers.*;

public class PageBase implements WebDriverContainer, Clickable, Conditionable, Fillable, Findable, Waitable {
    protected WebDriver driver;

    protected PageBase(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
