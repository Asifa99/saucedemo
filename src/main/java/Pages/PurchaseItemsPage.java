package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigLoader;
import utils.Waits;
import utils.WebDriverLoader;

import java.net.MalformedURLException;
import java.util.Map;

public class PurchaseItemsPage {
    private String checkout_btn_id = "checkout";

    private String continue_btn_id = "continue";
    private String first_name_id = "first-name";
    private String last_name_id = "last-name";
    private String postal_code_id = "postal-code";

    private String finist_btn_id = "finish";

    Map<String, Object> config = ConfigLoader.getConfig();

    private static InventoryPage inventoryPage = new InventoryPage();

    private static WebDriver driver;

    static {
        try {
            driver = WebDriverLoader.getDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkout() {
        inventoryPage.open_cart();
        Waits.getElementWhenVisible(driver, By.id(checkout_btn_id)).click();
    }

    public void checkout_confirm() {
        driver.findElement(By.id(first_name_id)).sendKeys((String) config.get("first_name"));
        driver.findElement(By.id(last_name_id)).sendKeys((String) config.get("last_name"));
        driver.findElement(By.id(postal_code_id)).sendKeys((String) config.get("postal_code"));

        Waits.getElementWhenVisible(driver, By.id(continue_btn_id)).click();
    }

    public void complete_purchase() {
        Waits.getElementWhenVisible(driver, By.id(finist_btn_id)).click();
    }

}
