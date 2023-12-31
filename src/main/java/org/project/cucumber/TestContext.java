package org.project.cucumber;

import org.project.managers.PageObjectManager;
import org.project.managers.WebDriverManager;
public class TestContext {

    private final WebDriverManager webDriverManager;
    private final PageObjectManager pageObjectManager;

    public TestContext() throws Exception {
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
