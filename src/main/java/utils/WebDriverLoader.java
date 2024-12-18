package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;
import java.util.Objects;

public class WebDriverLoader {
    private static WebDriver driver;
    private static String browser = System.getProperty("browser");
    static Map<String, Object> config = ConfigLoader.getConfig();


    // Private constructor to prevent instantiation
    private WebDriverLoader() {
    }

    // Get the WebDriver instance
    public static WebDriver getDriver() {
        if (browser == null) {
            System.out.println("No browser specified in the command, getting browser from configuration file.");
            browser = (String) config.get("browser");
            System.out.println("Browser Selected: " + browser);
        }

        if (driver == null) {
            if (Objects.equals(browser, "chrome")) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (Objects.equals(browser, "firefox")) {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
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