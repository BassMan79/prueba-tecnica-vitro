package org.project.dataproviders;

import org.project.enums.DriverType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class ConfigFileReader {

    private static final Properties TestProperties = new Properties();

    static {
        BufferedReader readerTestProperties;
        String propertiesFileName = "test.properties";
        readerTestProperties = new BufferedReader(new InputStreamReader(Objects.requireNonNull(ConfigFileReader.class.getClassLoader().getResourceAsStream(propertiesFileName))));
        try {
            TestProperties.load(readerTestProperties);
            readerTestProperties.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConfigFileReader() {
    }

    public static String getUrlApplication() throws Exception {
        String environment = TestProperties.getProperty("url");
        if (environment != null) return environment;
        else
            throw new Exception("environment not specified in the environment .properties file");
    }

    public static DriverType getBrowser() throws Exception {
        String browserName = TestProperties.getProperty("browser");
        if (browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("chromium")) return DriverType.CHROMIUM;
        else
            throw new Exception("browserName key value in environment is not matched : " + browserName);
    }

    public static Duration getImplicitlyWait() throws Exception {
        String implicitlyWait = TestProperties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Duration.ofSeconds(Long.parseLong(implicitlyWait));
        else
            throw new Exception("implicitlyWait key value in environment .properties file is not matched");
    }

    public static String getApplicationUrl() throws Exception {
        String url = TestProperties.getProperty("url");
        if (url != null) return url;
        else
            throw new Exception("url not specified in the .properties file");
    }

    public static boolean getHeadLess() {
        String headLess = TestProperties.getProperty("headless");
        if (headLess != null) return Boolean.parseBoolean(headLess);
        return true;
    }

    public static boolean getBrowserWindowSize() {
        String windowSize = TestProperties.getProperty("windowMaxime");
        if (windowSize != null) return Boolean.parseBoolean(windowSize);
        return true;
    }
}
