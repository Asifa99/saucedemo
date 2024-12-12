package pagetesting;

import Pages.Commons;
import Pages.PurchaseItemsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.ConfigLoader;
import utils.WebDriverLoader;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseItemsTest {
    private static PurchaseItemsPage purchaseItemsPage = new PurchaseItemsPage();
    private static Commons commons = new Commons();
    private static WebDriver driver = WebDriverLoader.getDriver();
    Map<String, Object> config = ConfigLoader.getConfig();

    @Test
    public void init_test() {
        commons.open_inventory();
        commons.add_items_to_cart(3);
        purchaseItemsPage.checkout();
        purchaseItemsPage.checkout_confirm();
        purchaseItemsPage.complete_purchase();

        String currentUrl = driver.getCurrentUrl();
        String checkout_confirmed_url = (String) config.get("checkout_confirmed_url");

        assertEquals(checkout_confirmed_url, currentUrl, "The URLs do not match");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
