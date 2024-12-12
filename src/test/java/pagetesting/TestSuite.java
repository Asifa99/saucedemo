package pagetesting;

import org.junit.jupiter.api.Test;

public class TestSuite {
    @Test
    public void test_all() {
        new LoginTest().init_test();
//        new CartPageTest().init_test();
//        new CheckoutItemsTest().init_test();
//        new ProductDetailsPageTest().init_test();
//        new PurchaseItemsTest().init_test();
//        new PersistenceTest().init_test();
        new SortingTest().init_test();

    }
}
