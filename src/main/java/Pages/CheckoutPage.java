package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private Properties props;

    // Locators
    private By cartIcon;
    private By checkoutButton;
    private By firstNameField;
    private By lastNameField;
    private By postalCodeField;
    private By continueButton;


    // Constructor
    public CheckoutPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;

        // Initialize locators with values from the config.properties file
        this.cartIcon = By.xpath(props.getProperty("cart.Icon"));
        this.checkoutButton = By.xpath(props.getProperty("checkout.Button"));
        this.firstNameField = By.xpath(props.getProperty("first.Name.Field"));
        this.lastNameField = By.xpath(props.getProperty("last.Name.Field"));
        this.postalCodeField = By.xpath(props.getProperty("postal.Code.Field"));
        this.continueButton = By.xpath(props.getProperty("continue.Button"));
    }

    public void proceedToCheckout() {

        driver.findElement(cartIcon).click();
        driver.findElement(checkoutButton).click();
    }

    public void completeCheckout(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(continueButton).click();
    }
}

