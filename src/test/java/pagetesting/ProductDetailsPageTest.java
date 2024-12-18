package pagetesting;

import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.WebDriverLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductDetailsPageTest {
    private static final Logger log = LoggerFactory.getLogger(ProductDetailsPageTest.class);
    private static ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    private static InventoryPage inventoryPage = new InventoryPage();
    private static WebDriver driver = WebDriverLoader.getDriver();
    private static LoginPage loginPage = new LoginPage();


    @Test
    public void init_test() {
        loginPage.login(driver);
        inventoryPage.open_inventory();
        // Removing all items from the cart initially, if there is any item
        inventoryPage.remove_items_cart(0);
        String init_cart_num = inventoryPage.get_cart_num();
        productDetailsPage.open_first_product_details(driver);
        productDetailsPage.add_to_cart(driver);
        productDetailsPage.remove_from_cart(driver);
        String final_cart_num = inventoryPage.get_cart_num();
        assertEquals(init_cart_num, final_cart_num, "Shopping cart number should be equal to previous value: " + init_cart_num);
    }
}
