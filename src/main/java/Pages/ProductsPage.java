package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ProductsPage {

    private WebDriver driver;

    private Properties props;

    //Locators
    private By productitem1;
    private By productitem2;
    private By AddtoCart;

    //Constructors
    public ProductsPage(WebDriver driver, Properties props) {
        this.driver = driver;
        this.props = props;

        // Initialize locators with values from the config.properties file
        this.productitem1 = By.xpath(props.getProperty("product.item1"));
        this.productitem2 = By.xpath(props.getProperty("product.item2"));
        this.AddtoCart = By.xpath(props.getProperty("Add.to.Cart"));
    }

    public void addProducts(){

        driver.findElement(productitem1).click();
        driver.findElement(AddtoCart).click();
        driver.findElement(productitem2).click();
        driver.findElement(AddtoCart).click();
    }


    }

