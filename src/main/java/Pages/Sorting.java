package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigLoader;
import utils.WebDriverLoader;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public class Sorting {
    public static String sort_dropdown_class = "product_sort_container";
    public static String sort_by_a_to_z_value = "az";
    public static String sort_by_z_to_a_value = "za";
    public static String sort_by_low_to_high = "lohi";
    public static String sort_by_high_to_low = "hilo";


    Map<String, Object> config = ConfigLoader.getConfig();
    private static WebDriver driver;

    static {
        try {
            driver = WebDriverLoader.getDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    // Constructor
    public Sorting() {
    }

    public void sort_by_a_to_z() {
        WebElement sortDropdown = driver.findElement(By.className(sort_dropdown_class));
        //Select class is specifically designed for handling dropdown elements
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByValue(sort_by_a_to_z_value);
    }

    public static Boolean verify_a_to_z_sorting() {
        //Returns a list of all products
        List<WebElement> inventory_item_names = driver.findElements(By.className("inventory_item_name"));
        //initialize variable
        int ascii_value_temp = -1;
        //iterates through each product item
        for (WebElement item : inventory_item_names) {
            //fetch text of each product
            String name = item.getText();
            //Gets the first character of the name
            char first_char = name.charAt(0);
            //Converts the character to its ASCII value.
            int asciiValue = (int) first_char;
            //Checks if the current item's first character ASCII value is less than the previous one
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
        //Initializes a temporary variable  with a high value 200
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

    //low to high price filter
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
            //convert string into float
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
