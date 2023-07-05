package org.project.stepdefinition;

import io.cucumber.java.After;
import org.project.cucumber.TestContext;

import java.util.logging.Logger;

public class Hooks {

    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @After(order = 0)
    public void afterSteps() {
        LOGGER.info("Log out");
        testContext.getWebDriverManager().quitDriver();
    }
}
