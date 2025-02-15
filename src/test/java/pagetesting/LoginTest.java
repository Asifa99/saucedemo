package pagetesting;

import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private static LoginPage loginPage = new LoginPage();
    private static WebDriver driver = WebDriverLoader.getDriver();


    @Test
    public void init_test() {
        loginPage.login(driver);
        assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed(),
                "Login failed, inventory page not displayed.");
    }
}
