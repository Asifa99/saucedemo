package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public static WebElement getUsernameField() {
        return driver.findElement(By.id("user-name"));
    }

    public static WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public static WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public static void login(String username, String password) {
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }
}
