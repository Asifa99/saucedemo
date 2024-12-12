package pagetesting;

import Pages.CheckoutItems;
import Pages.Commons;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

public class CheckoutItemsTest {
    private static CheckoutItems checkoutItemsPage = new CheckoutItems();
    private static Commons commons = new Commons();
    private static WebDriver driver = WebDriverLoader.getDriver();


    @Test
    public void init_test() {
        commons.open_cart();
        checkoutItemsPage.remove_items_from_cart(driver);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
