package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {
    private WebDriver driver;

    
    private By productTitleLabel = By.className("inventory_details_name");
    private By addToCartButton = By.cssSelector("button[id^='add-to-cart']");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    
    public String getProductTitle() {
        return driver.findElement(productTitleLabel).getText();
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }
}
