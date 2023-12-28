package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        ProductListingPage productListingPage = new ProductListingPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Thread.sleep(100);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        String productName = "Sauce Labs Backpack";
        productListingPage.selectProductByName(productName);

        String productTitle = productDetailPage.getProductTitle();
        if (productTitle.equals(productName)) {
            System.out.println("Product Details: Product matched.");
        } else {
            System.out.println("Product Details: Wrong item.");
        }

        Thread.sleep(100);


        productDetailPage.clickAddToCartButton();


        driver.get("https://www.saucedemo.com/cart.html");


        cartPage.clickCheckoutButton();

        String firstName = "MyName";
        String lastName = "Testing";
        String zipCode = "775500";

        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterZipCode(zipCode);

        checkoutPage.clickContinueButton();



        Thread.sleep(1000);
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        Thread.sleep(1000);
        checkoutPage.clickFinishButton();

        Thread.sleep(1000);
        String productTitleOnCheckout = confirmationPage.getCompleteMessage();

        if (productTitleOnCheckout.equals("THANK YOU FOR YOUR ORDER")) {
            System.out.println("Checkout: Product matched.");
        } else {
            System.out.println("Checkout: Wrong item.");
        }

        driver.quit();
    }
}
















