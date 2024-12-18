package pagetesting;

import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

public class CheckoutPageTest {
    private static CheckoutPage checkoutItemsPage = new CheckoutPage();
    private static InventoryPage inventoryPage = new InventoryPage();
    private static WebDriver driver = WebDriverLoader.getDriver();
    private static LoginPage loginPage = new LoginPage();


    @Test
    public void init_test() {
        loginPage.login(driver);
        inventoryPage.open_cart();
        checkoutItemsPage.remove_items_from_cart(driver);
    }
}
