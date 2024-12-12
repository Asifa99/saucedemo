package pagetesting;

import Pages.CartPage;
import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import utils.WebDriverLoader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPageTest {
    private static CartPage cartPage = new CartPage();
    private static WebDriver driver = WebDriverLoader.getDriver();


    @Test
    public void test_cart_page() {
        cartPage.add_items(driver);
        cartPage.remove_items(driver);

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
