package pagetesting;

import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.Sorting;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTest {
    private static InventoryPage inventoryPage = new InventoryPage();
    private static Sorting sorting = new Sorting();
    private static WebDriver driver = WebDriverLoader.getDriver();
    private static LoginPage loginPage = new LoginPage();


    @Test
    public void init_test() {
        loginPage.login(driver);
        inventoryPage.open_inventory();

        sorting.sort_filter("a_to_z");
        Boolean a_to_z_sorting_result = Sorting.verify_sorting("a_to_z");
        assertEquals(true, a_to_z_sorting_result, "A to Z Sorting Failed.");

        sorting.sort_filter("z_to_a");
        Boolean z_to_a_sorting_result = Sorting.verify_sorting("z_to_a");
        assertEquals(true, z_to_a_sorting_result, "Z to A Sorting Failed.");

        sorting.sort_filter("high_to_low");
        Boolean low_to_high_sorting_result = Sorting.verify_sorting("high_to_low");
        assertEquals(true, low_to_high_sorting_result, "Price Low to High Sorting Failed.");

        sorting.sort_filter("low_to_high");
        Boolean high_to_low_sorting_result = Sorting.verify_sorting("low_to_high");
        assertEquals(true, high_to_low_sorting_result, "Price High to Low Sorting Failed.");
    }
}
