package pagetesting;

import Pages.LoginPage;
import base.ConfigLoader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp() throws Exception {
        // Load the properties file
        ConfigLoader.fileLoader();

        // Use Selenium Manager to set up the WebDriver
        driver = new ChromeDriver();

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
