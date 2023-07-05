package org.project.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.HashMap;

public class WebDriverManager {

    private WebDriver driver;

    public WebDriverManager(){

    }
    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePref = new HashMap<>();
        chromePref.put("download.default_directory", Paths.get("target/download").toAbsolutePath().toString());
        chromePref.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
        options.setExperimentalOption("prefs", chromePref);
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://v3.interqc.com/");
        return driver;
    }

    public void quitDriver() {
        driver.close();
        driver.quit();
    }

}
