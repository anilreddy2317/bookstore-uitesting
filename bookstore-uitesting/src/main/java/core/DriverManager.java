package core;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
        // Private constructor to prevent direct instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        ConfigReader.loadProperties();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anilr\\OneDrive\\Desktop\\books-store\\book-store-uitesting\\bookstore-uitesting\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
