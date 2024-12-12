package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import utils.ConfigLoader;
import utils.Waits;

import java.util.Map;
import java.util.Properties;

public class CartPage {
    private String id_cart_item_1 = "add-to-cart-sauce-labs-backpack";
    private String id_cart_item_2 = "add-to-cart-sauce-labs-bike-light";
    private String id_cart_item_3 = "add-to-cart-sauce-labs-bolt-t-shirt";

    private String id_remove_cart_item_1 = "remove-sauce-labs-backpack";
    private String id_remove_cart_item_2 = "remove-sauce-labs-bike-light";

    Map<String, Object> config = ConfigLoader.getConfig();

    // Constructor
    public CartPage() {
    }

    public void add_items(WebDriver driver){
        WebElement item_1 = Waits.getElementWhenVisible(driver, By.id(id_cart_item_1));
        item_1.click();
        WebElement item_2 = Waits.getElementWhenVisible(driver, By.id(id_cart_item_2));
        item_2.click();
        WebElement item_3 = Waits.getElementWhenVisible(driver, By.id(id_cart_item_3));
        item_3.click();
    }

    public void remove_items(WebDriver driver){
        WebElement item_1 = Waits.getElementWhenVisible(driver, By.id(id_remove_cart_item_1));
        item_1.click();
        WebElement item_2 = Waits.getElementWhenVisible(driver, By.id(id_remove_cart_item_2));
        item_2.click();
    }
}
