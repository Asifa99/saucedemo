package pagetesting;

import Pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() throws IOException {
        // Load properties file
        Properties props = new Properties();
        FileInputStream input = new FileInputStream("src/main/resources/config.properties");
        props.load(input);

        driver = new ChromeDriver();

        // Navigate to the URL
        driver.get(props.getProperty("url"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() throws IOException {
        // Load properties file again (optional, already loaded in setUp)
        Properties props = new Properties();
        FileInputStream input = new FileInputStream("src/main/resources/config.properties");
        props.load(input);

        // Fetch credentials from properties file
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        LoginPage.login(username,password);

        // Verify successful login (update element locators as per your application)
        WebElement inventoryTitle = driver.findElement(By.className("inventory_list"));
        assertTrue(inventoryTitle.isDisplayed(), "Login failed, inventory page not displayed.");
    }

//    @AfterEach
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }

