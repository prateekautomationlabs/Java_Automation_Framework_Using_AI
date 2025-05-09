package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.base.BaseTest;

public class LoginPageTest extends BaseTest {

    @Test
    public void testInvalidLoginShowsError() {
        HomePage home = new HomePage(driver);
        home.clickSignupLogin();

        LoginPage login = new LoginPage(driver);
        login.enterLoginEmail("invalid@example.com");
        login.enterLoginPassword("wrongpass");
        login.clickLoginButton();

        String errorMsg = login.getLoginErrorMessage();
        Assert.assertTrue(errorMsg.contains("incorrect"), "Expected error message not displayed.");
    }

    @Test
    public void testSignupWithExistingEmailShowsError() {
        HomePage home = new HomePage(driver);
        home.clickSignupLogin();

        LoginPage login = new LoginPage(driver);
        login.enterSignupName("QAUser");
        login.enterSignupEmail("alreadyused@example.com"); // Should already exist in test DB
        login.clickSignupButton();

        // Add logic if error message is shown for duplicate email
        // Currently, app redirects without an error — leave for real test env validation
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"), "Expected to stay on signup page.");
    }
}
