package org.project.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.project.cucumber.TestContext;
import org.project.pageobject.HomePage;
import org.project.pageobject.MenuPage;

public class HomeStep {

    private final HomePage homePage;
    private final MenuPage menuPage;

    public HomeStep(TestContext context) {
        homePage = context.getPageObjectManager().getHomePage();
        menuPage = context.getPageObjectManager().getMenuPage();
    }

    @When("I go to home page")
    public void iGoToRawDataPage(){
        menuPage.goToHomePage();
    }

    @And("I open a results widget")
    public void iOpenResultsWidget(){
        homePage.clickOnLastRejectWidget();
    }

    @And("I check that result widget appear")
    public void iCheckWidgetAppear(){
        Assertions.assertTrue(homePage.checkWidgetAppear());
    }

    @Then("I logout")
    public void iLogout(){
        menuPage.logout();
    }
}
