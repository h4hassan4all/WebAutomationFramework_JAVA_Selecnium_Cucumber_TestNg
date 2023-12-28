package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    public WebDriver driver;


    private By checkoutButton = By.id("checkout");

    private By cartButton = By.cssSelector("div[id='shopping_cart_container']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    
    public void clickCheckoutButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(checkoutButton).click();
    }
    public void setCartButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(cartButton).click();
    }
}
