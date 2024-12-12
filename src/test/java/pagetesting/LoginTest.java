package pagetesting;

import Pages.LoginPage;
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

    @BeforeAll
    public static void setUp() throws Exception {
        ConfigLoader.fileLoader();

        WebDriver driver = WebDriverLoader.getDriver();

        // Navigate to the URL
        String url = ConfigLoader.getProperty("user.name");
        driver.get(url);

        // Initialize LoginPage
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        // Retrieve credentials from ConfigLoader
        String username = ConfigLoader.getProperty("user.name");
        String password = ConfigLoader.getProperty("user.name");

        // Perform login
        loginPage.login(username, password);

        // Verify successful login
        assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed(),
                "Login failed, inventory page not displayed.");
    }

    @AfterAll
    public static void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
