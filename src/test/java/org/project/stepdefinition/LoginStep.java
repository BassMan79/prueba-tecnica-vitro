package org.project.stepdefinition;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.project.cucumber.TestContext;
import org.project.pageobject.LoginPage;

public class LoginStep {

    private final LoginPage loginPage;

    public LoginStep(TestContext context) {
        loginPage = context.getPageObjectManager().getLoginPage();
    }

    @Given("^I log in with (.*) identifier (.*) username and (.*) password$")
    public void iLogInWithUsername(int identifier, String username, String password){
        loginPage.loginWithUsername(String.valueOf(identifier), username, password);
    }

    @And("I check login is correct")
    public void iCheckLoginIsCorrect() {
        Assertions.assertTrue(loginPage.checkUserIsLoged());
    }
}
