package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileOperations {
    private static Properties properties;

    public static void loadProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\anilr\\OneDrive\\Desktop\\books-store\\book-store-uitesting\\bookstore-uitesting\\src\\main\\resources\\config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
