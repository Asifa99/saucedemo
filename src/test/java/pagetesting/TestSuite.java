package pagetesting;

import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

public class TestSuite {
    @Test
    public void test_all() {
        new LoginTest().testLogin();
        new CartPageTest().test_cart_page();
    }
}
