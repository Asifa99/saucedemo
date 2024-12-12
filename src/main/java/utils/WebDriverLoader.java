package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverLoader {
    private static WebDriver driver;

    // Private constructor to prevent instantiation
    private WebDriverLoader() {
    }

    // Get the WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        return driver;
    }

    //    // Quit the WebDriver
    //    public static void quit() {
    //        if (driver != null) {
    //            driver.quit();
    //            driver = null;
    //        }
    //    }
}
