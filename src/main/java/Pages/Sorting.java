package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigLoader;
import utils.WebDriverLoader;

import java.util.List;
import java.util.Map;

public class Sorting {
    public static String sort_dropdown_class = "product_sort_container";
    public static String sort_by_a_to_z_value = "az";
    public static String sort_by_z_to_a_value = "za";
    public static String sort_by_low_to_high = "lohi";
    public static String sort_by_high_to_low = "hilo";


    Map<String, Object> config = ConfigLoader.getConfig();
    private static WebDriver driver = WebDriverLoader.getDriver();

    // Constructor
    public Sorting() {
    }

    public void sort_by_a_to_z() {
        WebElement sortDropdown = driver.findElement(By.className(sort_dropdown_class));
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByValue(sort_by_a_to_z_value);
    }

    public static Boolean verify_a_to_z_sorting() {
        List<WebElement> inventory_item_names = driver.findElements(By.className("inventory_item_name"));
        int ascii_value_temp = -1;
        for (WebElement item : inventory_item_names) {
            String name = item.getText();
            char first_char = name.charAt(0);
            int asciiValue = (int) first_char;
            if (asciiValue < ascii_value_temp) {
                return false;
            }
            ascii_value_temp = asciiValue;
        }
        return true;
    }


    public void sort_by_z_to_a() {
        WebElement sortDropdown = driver.findElement(By.className(sort_dropdown_class));
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByValue(sort_by_z_to_a_value);
    }

    public static Boolean verify_z_to_a_sorting() {
        List<WebElement> inventory_item_names = driver.findElements(By.className("inventory_item_name"));
        int ascii_value_temp = 200;
        for (WebElement item : inventory_item_names) {
            String name = item.getText();
            char first_char = name.charAt(0);
            int asciiValue = (int) first_char;
            if (asciiValue > ascii_value_temp) {
                return false;
            }
            ascii_value_temp = asciiValue;
        }
        return true;
    }


    public void sort_by_low_to_high() {
        WebElement sortDropdown = driver.findElement(By.className(sort_dropdown_class));
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByValue(sort_by_low_to_high);
    }

    public static Boolean verify_low_to_high_sorting() {
        List<WebElement> inventory_item_names = driver.findElements(By.className("inventory_item_price"));
        float price_temp = 0;

        for (WebElement item : inventory_item_names) {
            String price_str = item.getText().replace("$", "");
            float price = Float.parseFloat(price_str);
            if (price_temp == 0) {
                price_temp = price;
                continue;
            }
            if (price < price_temp) {
                return false;
            }
            price_temp = price;
        }
        return true;
    }


    public void sort_by_high_to_low() {
        WebElement sortDropdown = driver.findElement(By.className(sort_dropdown_class));
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByValue(sort_by_high_to_low);
    }

    public static Boolean verify_high_to_low_sorting() {
        List<WebElement> inventory_item_names = driver.findElements(By.className("inventory_item_price"));
        float price_temp = 0;

        for (WebElement item : inventory_item_names) {
            String price_str = item.getText().replace("$", "");
            float price = Float.parseFloat(price_str);
            if (price_temp == 0) {
                price_temp = price;
                continue;
            }
            if (price > price_temp) {
                return false;
            }
            price_temp = price;
        }
        return true;
    }
}
