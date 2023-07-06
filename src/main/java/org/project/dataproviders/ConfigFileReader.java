package org.project.dataproviders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class ConfigFileReader {

    private static final Properties properties = new Properties();

    private static final String ENVIRONMENT = "environment";

    static {
        BufferedReader reader;
        String propertiesFileName = "test.properties";
        reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(ConfigFileReader.class.getClassLoader().getResourceAsStream(propertiesFileName))));
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConfigFileReader() {
    }

    public static String getUrlApplication() throws Exception {
        String environment = properties.getProperty("url");
        if (environment != null) return environment;
        else
            throw new Exception("environment not specified in the " + properties.getProperty(ENVIRONMENT) + ".properties file");
    }

    public static String getBrowser() throws Exception {
        String environment = properties.getProperty("browser");
        if (environment != null) return environment;
        else
            throw new Exception("environment not specified in the " + properties.getProperty(ENVIRONMENT) + ".properties file");
    }

    public static Duration getImplicitlyWait() throws Exception {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Duration.ofSeconds(Long.parseLong(implicitlyWait));
        else
            throw new Exception("implicitlyWait key value in " + properties.getProperty(ENVIRONMENT) + ".properties file is not matched");
    }
}
