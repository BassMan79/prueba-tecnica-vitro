package org.project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DataInsertPage extends PageBase {

    //Lab./Dep./Inst. locators
    private final By labDropDownId = By.id("FilterControl_cbpLab_cbxLab_B-1");
    private final By firstLabExpandBtnXpath = By.xpath("//*[@id=\"FilterControl_cbpLab_cbxLab_DDD_tvLab_0_CD\"]/ul/li/span/img");
    private final By secondLabExpandBtnXpath = By.xpath("//*[@id=\"FilterControl_cbpLab_cbxLab_DDD_tvLab_0_CD\"]/ul/li/ul/li/span/img");
    private final By FACSLyricOptionId = By.id("FilterControl_cbpLab_cbxLab_DDD_tvLab_0_N0_0_1");

    //Control/Level/QC Lot locators
    private final By controlDropDownId = By.id("FilterControl_cbpControl_cbxMasterControl_B-1");
    private final By firstControlExpandBtnXpath = By.xpath("//*[@id=\"FilterControl_cbpControl_cbxMasterControl_DDD_tvControl_0_CD\"]/ul/li[2]/span/img");
    private final By secondControlExpandBtnXpath = By.xpath("//*[@id=\"FilterControl_cbpControl_cbxMasterControl_DDD_tvControl_0_CD\"]/ul/li[2]/ul/li/span/img");
    private final By BM0323NOptionId = By.id("FilterControl_cbpControl_cbxMasterControl_DDD_tvControl_0_N1_0_0");

    //Analyte locators
    private final By analyteDropDownId = By.id("FilterControl_cbpAssay_cbxAssay_B-1");
    private final By analyteDataToSelectId = By.id("FilterControl_cbpAssay_cbxAssay_DDD_tvAssay_0_N4");

    //Apply button
    private final By applyBtnId = By.id("BodyContentPlaceholder_btnProcess_CD");

    //Results
    private final By rowsResultsXpath = By.xpath("//tr[contains(@id, 'DXDataRow')]");

    public DataInsertPage(WebDriver driver) {
        super(driver);
    }

    public void enterLabCriteria() {
        waitUntilElementIsClicked(labDropDownId);
        clickOnClickableElement(firstLabExpandBtnXpath);
        waitUntilElementIsVisible(secondLabExpandBtnXpath);
        clickOnClickableElement(secondLabExpandBtnXpath);
        clickOnClickableElement(FACSLyricOptionId);
        waitSeconds(2);
    }

    public void enterControlCriteria() {
        waitUntilElementIsClicked(controlDropDownId);
        clickOnClickableElement(firstControlExpandBtnXpath);
        waitUntilElementIsVisible(secondControlExpandBtnXpath);
        clickOnClickableElement(secondControlExpandBtnXpath);
        clickOnClickableElement(BM0323NOptionId);
        waitSeconds(2);
    }

    public void enterAnalyteCriteria() {
        waitUntilElementIsClicked(analyteDropDownId);
        waitUntilElementIsVisible(analyteDataToSelectId);
        clickOnClickableElement(analyteDataToSelectId);
    }

    public void enterSearchCriteria() {
        enterLabCriteria();
        enterControlCriteria();
        enterAnalyteCriteria();
        waitSeconds(1);
        clickOnClickableElement(applyBtnId);
    }

    public boolean checkTwoRowsAppear(){
        waitUntilElementIsVisible(rowsResultsXpath);
        List<WebElement> rows = findElements(rowsResultsXpath);
        return rows.size() == 2;
    }
}
