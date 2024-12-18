package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigLoader;
import utils.Waits;

import java.util.Map;

public class LoginPage {
    private String username_id = "user-name";
    private String password_id = "password";
    private String login_btn_id = "login-button";

    Map<String, Object> config = ConfigLoader.getConfig();

    public LoginPage() {
    }


    public void login(WebDriver driver) {
        //have to add waits here
        driver.get((String) config.get("login_url"));
        Waits.waitForPageToLoad(driver);
        driver.findElement(By.id(username_id)).sendKeys((String) config.get("username"));
        driver.findElement(By.id(password_id)).sendKeys((String) config.get("password"));
        driver.findElement(By.id(login_btn_id)).click();
        Waits.waitForPageToLoad(driver);
    }
}
