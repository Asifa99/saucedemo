package pagetesting;

import Pages.InventoryPage;
import Pages.Sorting;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTest {
    private static InventoryPage inventoryPage = new InventoryPage();
    private static Sorting sorting = new Sorting();
    private static WebDriver driver;

    static {
        try {
            driver = WebDriverLoader.getDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void init_test() {
        inventoryPage.open_inventory();

        sorting.sort_by_a_to_z();
        Boolean a_to_z_sorting_result = Sorting.verify_a_to_z_sorting();
        assertEquals(true, a_to_z_sorting_result, "A to Z Sorting Failed.");

        sorting.sort_by_z_to_a();
        Boolean z_to_a_sorting_result = Sorting.verify_z_to_a_sorting();
        assertEquals(true, z_to_a_sorting_result, "Z to A Sorting Failed.");

        sorting.sort_by_low_to_high();
        Boolean low_to_high_sorting_result = Sorting.verify_low_to_high_sorting();
        assertEquals(true, low_to_high_sorting_result, "Price Low to High Sorting Failed.");

        sorting.sort_by_high_to_low();
        Boolean high_to_low_sorting_result = Sorting.verify_high_to_low_sorting();
        assertEquals(true, high_to_low_sorting_result, "Price High to Low Sorting Failed.");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
