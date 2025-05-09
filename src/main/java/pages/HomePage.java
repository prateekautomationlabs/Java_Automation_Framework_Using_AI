package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Locators
    private final By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By productsButton = By.xpath("//a[@href='/products']");
    private final By contactUsButton = By.xpath("//a[@href='/contact_us']");
    private final By testCasesButton = By.xpath("//a[@href='/test_cases']");
    private final By subscriptionEmailInput = By.id("susbscribe_email");
    private final By subscriptionButton = By.id("subscribe");
    private final By subscriptionSuccessMessage = By.xpath("//div[@class='alert-success']");

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void clickSignupLogin() {
        driver.findElement(signupLoginButton).click();
    }

    public void clickProducts() {
        driver.findElement(productsButton).click();
    }

    public void clickContactUs() {
        driver.findElement(contactUsButton).click();
    }

    public void clickTestCases() {
        driver.findElement(testCasesButton).click();
    }

    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionEmailInput).sendKeys(email);
    }

    public void clickSubscribe() {
        driver.findElement(subscriptionButton).click();
    }

    public String getSubscriptionSuccessMessage() {
        return driver.findElement(subscriptionSuccessMessage).getText();
    }
}
