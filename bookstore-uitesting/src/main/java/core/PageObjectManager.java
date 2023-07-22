package core;

import pages.BookstorePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private final WebDriver driver;

    private LoginPage loginPage;
    private BookstorePage bookstorePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public BookstorePage getBookstorePage() {
        return (bookstorePage == null) ? bookstorePage = new BookstorePage(driver) : bookstorePage;
    }
}
