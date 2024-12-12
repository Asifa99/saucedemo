package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waits;

import java.util.List;

public class ProductDetailsPage {
    private String product_links_class = "inventory_item_name";
    private String add_to_cart_btn_id = "add-to-cart";
    private String remove_from_cart_btn_id = "remove";


    // Constructor
    public ProductDetailsPage() {
    }


    public void open_first_product_details(WebDriver driver) {
        List<WebElement> product_links = driver.findElements(By.className(product_links_class));
        if (!product_links.isEmpty()) {
            // Click the first product link
            product_links.getFirst().click();
        } else {
            System.out.println("No products found.");
        }
    }

    public void add_to_cart(WebDriver driver) {
        WebElement add_to_cart_btn = Waits.getElementWhenVisible(driver, By.id(add_to_cart_btn_id));
        add_to_cart_btn.click();
    }

    public void remove_from_cart(WebDriver driver) {
        WebElement remove_from_cart_btn = Waits.getElementWhenVisible(driver, By.id(remove_from_cart_btn_id));
        remove_from_cart_btn.click();
    }
}
