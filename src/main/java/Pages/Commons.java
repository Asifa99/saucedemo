package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigLoader;
import utils.Waits;
import utils.WebDriverLoader;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Commons {
    private String shopping_cart_class = "shopping_cart_badge";
    private String side_bar_icon_id = "react-burger-menu-btn";
    private String logout_link_id = "logout_sidebar_link";

    Map<String, Object> config = ConfigLoader.getConfig();
    private static WebDriver driver = WebDriverLoader.getDriver();

    public void open_inventory() {
        String currentUrl = driver.getCurrentUrl();
        String inventory_url = (String) config.get("inventory_url");

        if (!Objects.equals(currentUrl, inventory_url)) {
            driver.get((String) config.get("inventory_url"));
            Waits.waitForPageToLoad(driver);
        }
    }

    public void open_cart() {
        Waits.getElementWhenVisible(driver, By.className("shopping_cart_link")).click();
    }

    public String get_cart_num() {
        try {
            return driver.findElement(By.className(shopping_cart_class)).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public void add_items_to_cart(Integer items_num) {
        int counter = 0;
        List<WebElement> buttons = driver.findElements(By.className("btn_inventory"));
        for (WebElement button : buttons) {
            // Check if the button text is "Add to cart"
            if (button.getText().equals("Add to cart")) {
                // Click the button if text is "Add to cart"
                button.click();
                counter++;
            }
            if (counter >= items_num) {
                break;
            }
        }
    }

    public void remove_items_cart(Integer items_num) {
        int counter = 0;
        List<WebElement> buttons = driver.findElements(By.className("btn_inventory"));
        for (WebElement button : buttons) {
            // Check if the button text is "Remove"
            if (button.getText().equals("Remove")) {
                // Click the button if text is "Remove"
                button.click();
                counter++;
            }
            if (counter >= items_num) {
                break;
            }
        }
    }

    public void logout() {
        WebElement sidebar_element = Waits.getElementWhenVisible(driver, By.id(side_bar_icon_id));
        sidebar_element.click();

        WebElement logout_btn = Waits.getElementWhenVisible(driver, By.id(logout_link_id));
        logout_btn.click();
    }

}
