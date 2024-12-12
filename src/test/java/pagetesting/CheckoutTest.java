package pagetesting;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import base.ConfigLoader;
import base.waits;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest {
    static WebDriver driver;
    static LoginPage loginPage;
    static CartPage cartPage;
    static CheckoutPage checkoutPage;
  //  static ConfigLoader configLoader;

    @BeforeAll
    public static void setUp() throws IOException {
        // Load the properties file
        ConfigLoader.fileLoader();
        Properties props = ConfigLoader.getProps(); // Retrieve props from ConfigLoader

        // Initialize WebDriver
        driver = new ChromeDriver();

        // Navigate to the URL
        String url = ConfigLoader.getProperty("url");
        driver.get(url);

        // Initialize LoginPage
        loginPage = new LoginPage(driver);

        // Initialize CartPage
        cartPage = new CartPage(driver, props);

        // Initialize CheckoutPage
        checkoutPage = new CheckoutPage(driver, ConfigLoader.getProps()); // Fix: Initialize checkoutPage here
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

        // Add items to cart
        WebElement item4 = waits.waitForElementToBeClickable(driver, cartPage.getCartItem4(), 6);
        item4.click();

        WebElement item5 = waits.waitForElementToBeClickable(driver, cartPage.getCartItem5(), 6);
        item5.click();

        // Proceed to checkout
        checkoutPage.proceedToCheckout();

        // Complete checkout process
        checkoutPage.completeCheckout("asifa", "iqbal", "12345");

//        WebElement cancelBtn = waits.waitForElementToBeClickable(driver, checkoutPage.getcancelBtn(), 6);
//        cancelBtn.click();

        //Complete Purchase
        WebElement CompletePurchase= waits.waitForElementToBeClickable(driver, checkoutPage.getfinishBtn(), 6);
        CompletePurchase.click();

        WebElement confirmation = waits.waitForElementToBeVisible(driver, checkoutPage.getConfirmationMessage(), 6);
        String confirmationText = confirmation.getText();
        String expectedText = "Thank you for your order"; // Update based on actual text

        //Assertions

        assertTrue(confirmationText.contains("Thank you for your order"),
                "Purchase confirmation message does not contain expected text!");
    }
}
