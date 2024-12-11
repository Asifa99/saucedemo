package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class CartPage {

    private WebDriver driver;
    private Properties props;

    // Locators
    private By cartItem1;
    private By cartItem2;
    private By cartItem3;

    // Constructor
    public CartPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;

        // Initialize locators with values from the config.properties file
        this.cartItem1 = By.xpath(props.getProperty("cart.item1"));
        this.cartItem2 = By.xpath(props.getProperty("cart.item2"));
        this.cartItem3 = By.xpath(props.getProperty("cart.item3"));
    }

    // Getter methods for cart items
    public By getCartItem1() {
        return cartItem1;
    }

    public By getCartItem2() {
        return cartItem2;
    }

    public By getCartItem3() {
        return cartItem3;
    }
}
