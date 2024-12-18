package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
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

    //Test Browser (Firefox/Chrome) should be selectable through a json file.
    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            switch (browsers) {
                case "firefox":
                    // Set the path to the Firefox driver
                    System.setProperty("selenium-firefox-driver", "C:\\Users\\pc Planet\\Downloads");
                    //driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    // Set the path to the Chrome Driver
                    System.setProperty("selenium-chrome-driver", "C:\\Program Files\\Google\\Chrome\\Application");
                    //driver = new ChromeDriver();
                    ChromeOptions options = new ChromeOptions();
                    driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
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
