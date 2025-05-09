package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    // Locators
    private final By nameInput = By.xpath("//input[@data-qa='name']");
    private final By emailInput = By.xpath("//input[@data-qa='email']");
    private final By subjectInput = By.xpath("//input[@data-qa='subject']");
    private final By messageTextarea = By.xpath("//textarea[@data-qa='message']");
    private final By submitButton = By.xpath("//input[@data-qa='submit-button']");
    private final By successMessage = By.xpath("//div[@class='status alert alert-success']");

    // Constructor
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectInput).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(messageTextarea).sendKeys(message);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
