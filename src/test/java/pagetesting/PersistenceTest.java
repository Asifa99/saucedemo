package pagetesting;

import Pages.Commons;
import Pages.LoginPage;
import Pages.PurchaseItemsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.ConfigLoader;
import utils.WebDriverLoader;

import java.net.MalformedURLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersistenceTest {
    private static LoginPage loginPage = new LoginPage();
    private static PurchaseItemsPage purchaseItemsPage = new PurchaseItemsPage();
    private static Commons commons = new Commons();
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
        commons.open_inventory();
        commons.add_items_to_cart(3);
        String init_cart_num = commons.get_cart_num();
        commons.logout();

        loginPage.login(driver);
        String final_cart_num = commons.get_cart_num();

        assertEquals(init_cart_num, final_cart_num, "Persistence Test Failed.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
