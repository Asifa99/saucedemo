package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

//Singleton Design Pattern for Webdriver
public class WebDriverLoader {
    private static WebDriver driver;
    private static String browsers;

    static {

        Map<String, Object> config = ConfigLoader.getConfig();
        browsers = (String) config.getOrDefault("browser", "chrome");
    }

    // Private constructor to prevent instantiation
    private WebDriverLoader() {
    }

    // Get the WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browsers) {
                case "firefox":
                    System.setProperty("selenium-firefox-driver", "C:\\Users\\pc Planet\\Downloads");
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    System.setProperty("selenium-chrome-driver", "C:\\Program Files\\Google\\Chrome\\Application");
                    driver = new ChromeDriver();
                    break;
            }
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
