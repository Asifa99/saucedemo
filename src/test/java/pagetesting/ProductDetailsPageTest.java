package pagetesting;

import Pages.Commons;
import Pages.ProductDetailsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductDetailsPageTest {
    private static ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    private static Commons commons = new Commons();
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
        commons.open_inventory();
        String init_cart_num = commons.get_cart_num();
        productDetailsPage.open_first_product_details(driver);
        productDetailsPage.add_to_cart(driver);
        productDetailsPage.remove_from_cart(driver);
        String final_cart_num = commons.get_cart_num();
        assertEquals(init_cart_num, final_cart_num, "Shopping cart number should be equal to previous value: " + init_cart_num);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
