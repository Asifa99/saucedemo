package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    public static long timeout = 10;
    public static WebElement getElementWhenVisible(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    // Wait until the element is clickable, either by By locator or XPath as String
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, String xpath, long timeoutInSeconds) {
        By locator = By.xpath(xpath);
        return waitForElementToBeClickable(driver, locator, timeoutInSeconds);
    }

    // Wait until the element is visible, either by By locator or XPath as String
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, String xpath, long timeoutInSeconds) {
        By locator = By.xpath(xpath);
        return waitForElementToBeVisible(driver, locator, timeoutInSeconds);
    }

    // Wait for the page to load completely (checking document.readyState)
    public static void waitForPageToLoad(WebDriver driver, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
}
