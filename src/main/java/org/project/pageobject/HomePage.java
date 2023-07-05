package org.project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    private final By lastRejectedWidgetBtnId = By.id("BodyContentPlaceholder_repeater_widgetImage_0");
    private final By lastRejectWidgetWindowId = By.id("BodyContentPlaceholder_wResultsPanel_PW-1");

    public HomePage(WebDriver driver) { super(driver); }

    public void clickOnLastRejectWidget() {
        waitUntilElementIsVisible(lastRejectedWidgetBtnId);
        clickOnClickableElement(lastRejectedWidgetBtnId);
    }

    public boolean checkWidgetAppear(){
        return elementIsVisible(lastRejectWidgetWindowId);
    }
}
