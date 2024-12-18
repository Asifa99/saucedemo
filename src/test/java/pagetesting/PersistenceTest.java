package pagetesting;

import Pages.InventoryPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersistenceTest {
    private static LoginPage loginPage = new LoginPage();
    private static InventoryPage inventoryPage = new InventoryPage();
    private static WebDriver driver = WebDriverLoader.getDriver();


    @Test
    public void init_test() {
        loginPage.login(driver);

        inventoryPage.open_inventory();
        inventoryPage.add_items_to_cart(3);
        String init_cart_num = inventoryPage.get_cart_num();
        inventoryPage.logout();

        loginPage.login(driver);
        String final_cart_num = inventoryPage.get_cart_num();

        assertEquals(init_cart_num, final_cart_num, "Persistence Test Failed.");
    }
}
