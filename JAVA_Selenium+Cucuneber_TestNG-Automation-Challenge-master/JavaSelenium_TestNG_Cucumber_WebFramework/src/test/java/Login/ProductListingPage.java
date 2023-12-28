package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListingPage {
    private WebDriver driver;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void selectProductByName(String productName) {
        List<WebElement> allProductsName = driver.findElements(By.className("inventory_item_name"));
        for (WebElement product : allProductsName) {
            if (product.getText().equals(productName)) {
                product.click();
                break;
            }
        }
    }
}
