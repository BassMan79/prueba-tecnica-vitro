package org.project.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
