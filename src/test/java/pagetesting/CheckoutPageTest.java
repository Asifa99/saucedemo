package pagetesting;

import Pages.CheckoutPage;
import Pages.InventoryPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

import java.net.MalformedURLException;

public class CheckoutPageTest {
    private static CheckoutPage checkoutItemsPage = new CheckoutPage();
    private static InventoryPage inventoryPage = new InventoryPage();
    private static WebDriver driver;

    static {
        try {
            driver = WebDriverLoader.getDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void init_test() {
        inventoryPage.open_cart();
        checkoutItemsPage.remove_items_from_cart(driver);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
