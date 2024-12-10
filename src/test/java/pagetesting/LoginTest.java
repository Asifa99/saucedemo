package pagetesting;

import Pages.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static Properties props;

    @BeforeAll
    public static void setUp() throws IOException {
        // Load properties file
        props = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            props.load(input);
        }

        // Initialize WebDriver
        driver = new ChromeDriver();

        // Navigate to the URL
        driver.get(props.getProperty("url"));

        // Initialize LoginPage
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        // Get credentials from the properties file
        String username = props.getProperty("user.name");
        String password = props.getProperty("password");

        // Perform login
        loginPage.login(username, password);

        // Verify successful login
        assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed(),
                "Login failed, inventory page not displayed.");
    }

    @AfterAll
    public static void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
