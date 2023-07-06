package org.project.managers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.project.dataproviders.ConfigFileReader;
import org.project.enums.DriverType;

import java.nio.file.Paths;
import java.util.HashMap;

public class WebDriverManager {

    private WebDriver driver;
    private final DriverType driverType;
    private final Dimension windowSize = new Dimension(1920, 1080);

    public WebDriverManager() throws Exception {
        driverType = ConfigFileReader.getBrowser();
    }
    public WebDriver getDriver() throws Exception {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() throws Exception {
        if (driverType.equals(DriverType.CHROME)) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePref = new HashMap<>();
            chromePref.put("download.default_directory", Paths.get("target/download").toAbsolutePath().toString());
            chromePref.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
            options.setExperimentalOption("prefs", chromePref);
            if(ConfigFileReader.getHeadLess()) {
                options.addArguments("--headless");
            }
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (driverType.equals(DriverType.CHROMIUM)) {
            System.setProperty("wdm.defaultBrowser", "chrome");
            io.github.bonigarcia.wdm.WebDriverManager.chromiumdriver().clearDriverCache().setup();
            ChromeOptions optionsGithub = new ChromeOptions().setHeadless(true);
            HashMap<String, Object> chromePref = new HashMap<>();
            chromePref.put("download.default_directory", Paths.get("target/download").toAbsolutePath().toString());
            chromePref.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
            optionsGithub.setExperimentalOption("prefs", chromePref);
            driver = new ChromeDriver(optionsGithub);
        }
        driver.get(ConfigFileReader.getApplicationUrl());
        if (ConfigFileReader.getBrowserWindowSize()) {
            driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(windowSize);
        }
        return driver;
    }

    public void quitDriver() {
        driver.close();
        driver.quit();
    }

}
