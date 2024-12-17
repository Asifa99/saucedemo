package pagetesting;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

import java.net.MalformedURLException;

public class TestSuite {
    private static WebDriver driver;

    static {
        try {
            driver = WebDriverLoader.getDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

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
