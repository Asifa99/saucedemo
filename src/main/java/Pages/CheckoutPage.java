package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigLoader;

import java.util.List;
import java.util.Map;

public class CheckoutPage {
    private String remove_btn_class = "cart_button";

    Map<String, Object> config = ConfigLoader.getConfig();

    // Constructor
    public CheckoutPage() {
    }

    public void remove_items_from_cart(WebDriver driver) {
        List<WebElement> cartButtons = driver.findElements(By.className("cart_button"));

        for (WebElement button : cartButtons) {
            // Check if the button text is "Remove"
            if (button.getText().equals("Remove")) {
                // Click the button if text is "Remove"
                button.click();
                // Optionally, print or log the action
                System.out.println("Clicked Remove button");
            }
        }
    }
}
