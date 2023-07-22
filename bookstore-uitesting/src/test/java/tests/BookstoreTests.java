package tests;

import config.Constants;
import core.BaseTest;
import core.DriverManager;
import core.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestData;
import pages.BookstorePage;
public class BookstoreTests extends BaseTest {
    private PageObjectManager pageObjectManager;
    private WebDriver driver;

    @BeforeClass
    public void init() {
        driver = DriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
    }

    @Test
    public void verify_demoQA_website_and_login() throws InterruptedException {
        driver.get(Constants.BASE_URL);
        pageObjectManager.getLoginPage().click_book_store();
        pageObjectManager.getLoginPage().login_click();
        pageObjectManager.getLoginPage().login(TestData.getUsername(), TestData.getPassword());
        Thread.sleep(5000);
        pageObjectManager.getLoginPage().login_click();
        pageObjectManager.getLoginPage().username_validation();

    }

    @Test
    public void verifyNumberOfBooksAddedToUser() {
        // Step 1: Login to the website with user's credentials
        driver.get(Constants.BASE_URL);
        pageObjectManager.getLoginPage().click_book_store();
        pageObjectManager.getLoginPage().login_click();
        pageObjectManager.getLoginPage().login(TestData.getUsername(), TestData.getPassword());
        pageObjectManager.getLoginPage().login_click();
        // Step 2: Verify the number of books added to the user
        int booksAddedToUser = bookstorePage.getNumberOfBooksAddedToUser();
        int booksDisplayedOnWebsite = bookstorePage.getNumberOfBooksDisplayedOnWebsite();
        Assert.assertEquals(booksAddedToUser, booksDisplayedOnWebsite,
                "Number of books added to the user does not match the number of books displayed on the website.");
    }

    @Test
    public void verifyBookDetails() {
        // Step 1: Login to the website with user's credentials
        driver.get(Constants.BASE_URL);
        pageObjectManager.getLoginPage().click_book_store();
        pageObjectManager.getLoginPage().login_click();
        pageObjectManager.getLoginPage().login(TestData.getUsername(), TestData.getPassword());
        pageObjectManager.getLoginPage().login_click();
        // Step 2: Verify book details for each book on the website
        int totalBooks = bookstorePage.getNumberOfBooksDisplayedOnWebsite();
        for (int i = 1; i <= totalBooks; i++) {
            Assert.assertTrue(bookstorePage.verifyBookDetails(i),
                    "Book details verification failed for book #" + i);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
