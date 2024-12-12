package pagetesting;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

public class TestSuite {
    private static WebDriver driver = WebDriverLoader.getDriver();

    @Test
    public void test_all() {
        new LoginTest().init_test();
        new CartPageTest().init_test();
        new CheckoutItemsTest().init_test();
        new ProductDetailsPageTest().init_test();
        new PurchaseItemsTest().init_test();
        new PersistenceTest().init_test();
        new SortingTest().init_test();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
