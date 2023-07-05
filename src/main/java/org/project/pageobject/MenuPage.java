package org.project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends PageBase{

    //Home
    private final By homeMenuId = By.id("HeaderControl_HeaderMenu1_mainMenu_DXI0_T");

    //Manual Results menu
    private final By resultsAndLotMenuId = By.id ("HeaderControl_HeaderMenu1_mainMenu_DXI1_");
    private final By manualResultsMenuXpath = By.xpath("//*[@id=\"HeaderControl_HeaderMenu1_mainMenu_DXI1i0_T\"]/span");
    private final By rawDataMenuId = By.id("HeaderControl_HeaderMenu1_mainMenu_DXI1i0i0_T");

    //Logout
    private final By logoutBtnId = By.id ("HeaderControl_hlQuit");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void goToRawDataPage(){
        waitUntilElementIsVisible(resultsAndLotMenuId);
        clickOnClickableElement(resultsAndLotMenuId);
        clickOnClickableElement(manualResultsMenuXpath);
        clickOnClickableElement(rawDataMenuId);
    }

    public void goToHomePage(){
        clickOnClickableElement(homeMenuId);
    }

    public void logout(){
        clickOnClickableElement(logoutBtnId);
    }
}
