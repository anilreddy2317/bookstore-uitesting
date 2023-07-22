package utils;

import config.ConfigReader;

public class TestData {
    public static String getUsername() {
        FileOperations.loadProperties();
        return FileOperations.getProperty("username");
    }

    public static String getPassword() {
        FileOperations.loadProperties();
        return FileOperations.getProperty("password");
    }
}
