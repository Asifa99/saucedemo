package pagetesting;

import Pages.InventoryPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waits;
import utils.WebDriverLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPageTest {
    private static InventoryPage inventoryPage = new InventoryPage();
    private static WebDriver driver = WebDriverLoader.getDriver();
    private static LoginPage loginPage = new LoginPage();


    @Test
    public void init_test() {
        loginPage.login(driver);
        inventoryPage.add_items_to_cart(3);
        inventoryPage.remove_items_cart(2);

        WebElement cart_items_num = Waits.getElementWhenVisible(driver, By.className("shopping_cart_badge"));
        assertEquals("1", cart_items_num.getText(), "Cart icon should be equal to 1 after adding 3 and removing 2 items.");

    }

}
