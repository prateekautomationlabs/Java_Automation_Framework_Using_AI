package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import tests.base.BaseTest;

public class ContactUsPageTest extends BaseTest {

    @Test
    public void testSubmitContactForm() {
        HomePage home = new HomePage(driver);
        home.clickContactUs();

        ContactUsPage contact = new ContactUsPage(driver);
        contact.enterName("QA Tester");
        contact.enterEmail("tester@example.com");
        contact.enterSubject("Test Subject");
        contact.enterMessage("This is a test message.");
        contact.clickSubmitButton();

        String msg = contact.getSuccessMessage();
        Assert.assertTrue(msg.contains("Success"), "Contact form submission failed.");
    }
}
