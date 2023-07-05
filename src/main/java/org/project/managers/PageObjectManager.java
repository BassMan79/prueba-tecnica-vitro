package org.project.managers;

import org.openqa.selenium.WebDriver;
import org.project.pageobject.DataInsertPage;
import org.project.pageobject.HomePage;
import org.project.pageobject.LoginPage;
import org.project.pageobject.MenuPage;

public class PageObjectManager {

    private WebDriver driver;
    private LoginPage loginPage;

    private HomePage homePage;
    private MenuPage menuPage;
    private DataInsertPage dataInsertPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public MenuPage getMenuPage() {
        if (menuPage == null) {
            menuPage = new MenuPage(driver);
        }
        return menuPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public DataInsertPage getDataInsertPage() {
        if (dataInsertPage == null) {
            dataInsertPage = new DataInsertPage(driver);
        }
        return dataInsertPage;
    }
}
