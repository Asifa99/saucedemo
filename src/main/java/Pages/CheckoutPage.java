package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutPage {
    private String remove_cart_btn = "cart_button";

    // Constructor
    public CheckoutPage() {
    }

    public void remove_items_from_cart(WebDriver driver) {
        List<WebElement> cartButtons = driver.findElements(By.className(remove_cart_btn));

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
