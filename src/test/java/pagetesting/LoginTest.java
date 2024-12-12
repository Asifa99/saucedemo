package pagetesting;

import Pages.LoginPage;
import org.openqa.selenium.bidi.log.Log;
import utils.ConfigLoader;
import utils.WebDriverLoader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private static LoginPage loginPage;
    private static WebDriver driver = WebDriverLoader.getDriver();

    @BeforeAll
    public static void setUp() throws Exception {
        loginPage = new LoginPage();
    }

    @Test
    public void testLogin() {
        loginPage.login(driver);
        assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed(),
                "Login failed, inventory page not displayed.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
