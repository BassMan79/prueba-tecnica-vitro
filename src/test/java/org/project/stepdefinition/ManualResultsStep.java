package org.project.stepdefinition;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.project.cucumber.TestContext;
import org.project.pageobject.DataInsertPage;
import org.project.pageobject.MenuPage;

public class ManualResultsStep {

    private final MenuPage menuPage;
    private final DataInsertPage dataInsertPage;

    public ManualResultsStep(TestContext context) {
        menuPage = context.getPageObjectManager().getMenuPage();
        dataInsertPage = context.getPageObjectManager().getDataInsertPage();
    }

    @When("I go to raw data page")
    public void iGoToRawDataPage(){
        menuPage.goToRawDataPage();
    }

    @And("I enter search criteria")
    public void iEnterSearchCriteria() {
        dataInsertPage.enterSearchCriteria();
    }

    @Then("I check that two rows appear")
    public void iCheckTwoRowsAppear() {
        Assertions.assertTrue(dataInsertPage.checkTwoRowsAppear());
    }
}
