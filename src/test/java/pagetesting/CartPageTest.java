package pagetesting;

import Pages.CartPage;
import Pages.LoginPage;
import base.ConfigLoader;
import base.waits;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;


public class CartPageTest {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static CartPage cartPage;
    private static Properties props;

    @BeforeAll
    public static void setUp() throws IOException {
        // Load the properties file
        ConfigLoader.fileLoader();
        props = ConfigLoader.getProps(); // Retrieve props from ConfigLoader

        // Initialize WebDriver
        driver = new ChromeDriver();

        // Navigate to the URL
        String url = ConfigLoader.getProperty("url");
        driver.get(url);

        // Initialize LoginPage
        loginPage = new LoginPage(driver);

        // Initialize CartPage
        cartPage = new CartPage(driver, props);
    }

    @Test
    public void testCartPage() {
        // Retrieve credentials from ConfigLoader
        String username = ConfigLoader.getProperty("user.name");
        String password = ConfigLoader.getProperty("password");

        // Perform login
        loginPage.login(username, password);

        // Wait for the page to load
        waits.waitForPageToLoad(driver, 10);

        // Interact with the cart items
        WebElement item1 = waits.waitForElementToBeClickable(driver, cartPage.getCartItem1(), 6);
        item1.click();

        WebElement item2 = waits.waitForElementToBeClickable(driver, cartPage.getCartItem2(), 10);
        item2.click();

        WebElement item3 = waits.waitForElementToBeClickable(driver, cartPage.getCartItem3(), 7);
        item3.click();

        WebElement removeitem1 = waits.waitForElementToBeClickable(driver, cartPage.getRemovecartItem1(), 6);
        removeitem1.click();
        System.out.println("Removed first added product from cart");

        WebElement removeitem2 = waits.waitForElementToBeClickable(driver, cartPage.getRemovecartItem2(), 6);
        removeitem2.click();
        System.out.println("Removed first added product from cart");

        waits.waitForElementToBeVisible(driver, cartPage.getCartItem1(), 6);
        System.out.println("Add to cart Button is visible again for first product item");

        waits.waitForElementToBeVisible(driver, cartPage.getCartItem2(), 6);
        System.out.println("Add to cart Button is visible again for second product item");


    }

//    @AfterAll
//    public static void tearDown() {
//        // Close the browser
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
