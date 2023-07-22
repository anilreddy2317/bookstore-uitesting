package pages;

import core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TestData;
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='login']")
    private WebElement loginButton;

    @FindBy(css = "div:nth-child(6) div:nth-child(1) div:nth-child(1)")
    private WebElement bookstore;

    @FindBy(css = "#userName-value")
    private WebElement username;
    public void click_book_store(){
        //bookstore.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", bookstore);
    }
    public void login_click(){
        //loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButton);
    }
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        login_click();

    }

    public void username_validation(){
        String actualText = username.getText();
        String expectedText = TestData.getUsername();
        org.testng.Assert.assertEquals(actualText, expectedText);
    }


}
