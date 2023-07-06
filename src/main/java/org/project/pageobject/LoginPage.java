package org.project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    private final By identificadorLaboratorioId = By.id("txtId");
    private final By usernameId = By.id("username");
    private final By passwordId = By.id("password");
    private final By loginBtnXpath = By.xpath("//*[@id=\"divLogin\"]/button");
    private final By headerMenuId = By.id("divHeaderMenu");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginWithUsername(String identifier, String username, String password){
        fillElement(identifier, identificadorLaboratorioId);
        fillElement(username, usernameId);
        fillElement(password, passwordId);
        clickOnClickableElement(loginBtnXpath);
    }

    public boolean checkUserIsLoged() throws Exception {
        waitUntilElementIsVisible(headerMenuId);
        return elementIsVisible(headerMenuId);
    }
}
