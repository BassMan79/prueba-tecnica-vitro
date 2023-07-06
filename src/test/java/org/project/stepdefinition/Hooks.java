package org.project.stepdefinition;

import com.google.common.collect.ImmutableMap;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import org.project.cucumber.TestContext;
import org.project.dataproviders.ConfigFileReader;

import java.util.logging.Logger;

import static org.project.dataproviders.AllureEnvironmentWriter.allureEnvironmentWriter;

public class Hooks {

    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("URL", ConfigFileReader.getUrlApplication())
                        .put("Browser", ConfigFileReader.getBrowser())
                        .put("Browser", "Chrome")
                        .build());
    }

    @After(order = 0)
    public void afterSteps() {
        LOGGER.info("Log out");
        testContext.getWebDriverManager().quitDriver();
    }
}
