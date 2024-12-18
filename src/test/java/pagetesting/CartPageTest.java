package pagetesting;

import Pages.InventoryPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverLoader;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPageTest {
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
        inventoryPage.add_items_to_cart(3);
        inventoryPage.remove_items_cart(2);

        WebElement cart_items_num = driver.findElement(By.className("shopping_cart_badge"));
        assertEquals("1", cart_items_num.getText(), "Cart icon should be equal to 1 after adding 3 and removing 2 items.");

    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
