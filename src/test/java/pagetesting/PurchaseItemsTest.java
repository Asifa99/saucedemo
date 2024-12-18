package pagetesting;

import Pages.InventoryPage;
import Pages.PurchaseItemsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.ConfigLoader;
import utils.WebDriverLoader;

import java.net.MalformedURLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseItemsTest {
    private static PurchaseItemsPage purchaseItemsPage = new PurchaseItemsPage();
    private static InventoryPage inventoryPage = new InventoryPage();
    private static WebDriver driver;

    static {
        try {
            driver = WebDriverLoader.getDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    Map<String, Object> config = ConfigLoader.getConfig();

    @Test
    public void init_test() {
        inventoryPage.open_inventory();
        inventoryPage.add_items_to_cart(3);
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
