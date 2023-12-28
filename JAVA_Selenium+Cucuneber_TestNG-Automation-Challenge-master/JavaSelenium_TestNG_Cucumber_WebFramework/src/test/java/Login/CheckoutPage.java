package Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutPage {
    private WebDriver driver;

    
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.cssSelector("input[name='continue']");

    private By finishbutton = By.cssSelector("button[id='finish']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void clickFinishButton() {
        driver.findElement(finishbutton).click();
//        WebElement buttonFinish = driver.findElement(By.id("finish"));
//        buttonFinish.click();

    }
}

