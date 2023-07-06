package org.project.stepdefinition;

import com.google.common.collect.ImmutableMap;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import org.project.cucumber.TestContext;

import java.util.logging.Logger;

import static org.project.dataproviders.AllureEnvironmentWriter.allureEnvironmentWriter;

public class Hooks {

    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @BeforeAll
    public static void beforeAll() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .build());
    }

    @After(order = 0)
    public void afterSteps() {
        LOGGER.info("Log out");
        testContext.getWebDriverManager().quitDriver();
    }
}
