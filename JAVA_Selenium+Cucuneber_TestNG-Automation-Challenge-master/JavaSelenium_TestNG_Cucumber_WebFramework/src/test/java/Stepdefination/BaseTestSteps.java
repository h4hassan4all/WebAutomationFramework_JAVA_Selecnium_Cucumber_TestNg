package Stepdefination;

import Login.*;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class BaseTestSteps {
    public WebDriver driver;
    private LoginPage loginPage;
    private ProductListingPage productListingPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;


    @Given("I open the SauceDemo website")
    public void iOpenTheSauceDemoWebsite(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);

        productListingPage = new ProductListingPage(driver);

        productDetailPage = new ProductDetailPage(driver);

        cartPage = new CartPage(driver);

        checkoutPage = new CheckoutPage(driver);

        confirmationPage = new ConfirmationPage(driver);
    }

    @When("I log in as a standard user")
    public void iLogInAsAStandardUser() {

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @When("I select a product named {string}")
    public void iSelectAProductNamed(String productName) {

        productListingPage.selectProductByName(productName);
    }

    @Then("I should see the product details matching {string}")
    public void iShouldSeeTheProductDetailsMatching(String productName) {
        String productTitle = productDetailPage.getProductTitle();
    }

    @And("I add the product to the cart")
    public void iAddTheProductToTheCart() {
        productDetailPage.clickAddToCartButton();
    }

    @When("I go to the cart")
    public void iGoToTheCart() throws InterruptedException {

        cartPage.setCartButton();

    }
    @And("I proceed to checkout")
    public void iProceedToCheckout() throws InterruptedException {
        cartPage.clickCheckoutButton();
    }
    @And("I enter the following checkout information:")
    public void iEnterTheFollowingCheckoutInformation(io.cucumber.datatable.DataTable dataTable) {
        checkoutPage.enterFirstName("MyName");
        checkoutPage.enterLastName("testing");
        checkoutPage.enterZipCode("123456");
    }

    @And("I continue with the checkout")
    public void iContinueWithTheCheckout() {
        checkoutPage.clickContinueButton();
    }

    @And("I complete the order")
    public void iCompleteTheOrder() {
        // Add code to complete the order, e.g., clicking Finish button
        checkoutPage.clickFinishButton();
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String expectedMessage) {
        String actualMessage = confirmationPage.getCompleteMessage();

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
    }
}
