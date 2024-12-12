package pagetesting;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import utils.ConfigLoader;
import utils.waits;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class ProductItemTest {
    static WebDriver driver;
    static LoginPage loginPage;
    static CartPage cartPage;
    static ProductsPage productPage;
    static ConfigLoader configLoader;
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
        productPage = new ProductsPage(driver, props);

    }

    @Test
    public void AddItemsToCartAndCheckout() {
        // Retrieve credentials from ConfigLoader
        String username = ConfigLoader.getProperty("user.name");
        String password = ConfigLoader.getProperty("password");

        // Perform login
        loginPage.login(username, password);

        // Wait for the page to load
        waits.waitForPageToLoad(driver, 10);

        productPage.addProducts();


    }
}

