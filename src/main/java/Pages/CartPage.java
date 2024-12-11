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
    private By cartItem4;
    private By cartItem5;
    private By removecartItem1;
    private By removecartItem2;



    // Constructor
    public CartPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;

        // Initialize locators with values from the config.properties file
        this.cartItem1 = By.xpath(props.getProperty("cart.item1"));
        this.cartItem2 = By.xpath(props.getProperty("cart.item2"));
        this.cartItem3 = By.xpath(props.getProperty("cart.item3"));
        this.cartItem4 = By.xpath(props.getProperty("cart.item4"));
        this.cartItem5 = By.xpath(props.getProperty("cart.item5"));
        this.removecartItem1 = By.xpath(props.getProperty("remove.cart.item1"));
        this.removecartItem2 = By.xpath(props.getProperty("remove.cart.item2"));

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
    public By getCartItem4() {
        return cartItem4;
    }
    public By getCartItem5() {
        return cartItem5;
    }
    public By getRemovecartItem1() {
        return removecartItem1;
    }
    public By getRemovecartItem2() {
        return removecartItem2;
    }
}
