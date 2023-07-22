package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookstorePage extends BasePage {
    private By booksAddedLocator = By.xpath("//div[@class='text-right col-md-4']//h5[contains(text(), 'Book added')]");
    private By booksOnWebsiteLocator = By.cssSelector("div#app>div>div>div>div>div>div>div>div>h5");

    public int getNumberOfBooksAddedToUser() {
        List<WebElement> booksAdded = findElements(booksAddedLocator);
        return booksAdded.size();
    }

    public int getNumberOfBooksDisplayedOnWebsite() {
        List<WebElement> booksOnWebsite = findElements(booksOnWebsiteLocator);
        return booksOnWebsite.size();
    }

    public boolean verifyBookDetails(int bookIndex) {
        String bookLocator = "(//div[@class='text-right col-md-4']//h5[contains(text(), 'Book added')])[" + bookIndex + "]";
        WebElement bookElement = findElement(By.xpath(bookLocator));
        bookElement.click();

        // TODO: Implement book details verification here.
        // You can extract and verify author, publisher, number of pages, etc., for the clicked book.
        WebElement authorElement = findElement(By.xpath("//h3[@class='author']"));
        WebElement publisherElement = findElement(By.xpath("//h3[@class='publisher']"));
        WebElement pagesElement = findElement(By.xpath("//h3[@class='pages']"));

        String author = authorElement.getText().trim();
        String publisher = publisherElement.getText().trim();
        String pages = pagesElement.getText().trim();

        // Perform assertions to verify book details
        boolean isAuthorValid = !author.isEmpty();
        boolean isPublisherValid = !publisher.isEmpty();
        boolean arePagesValid = pages.matches("\\d+"); // Match one or more digits

        // Print the book details for debugging
        System.out.println("Book #" + bookIndex + " - Author: " + author + ", Publisher: " + publisher + ", Pages: " + pages);

        // Return true if all assertions pass, otherwise, return false.
        return isAuthorValid && isPublisherValid && arePagesValid;

        // Return true if book details verification passes, otherwise, return false.
        return true;
    }
}
