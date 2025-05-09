package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.base.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    public void testNavigateToLoginPage() {
        HomePage home = new HomePage(driver);
        home.clickSignupLogin();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"), "Did not navigate to login page.");
    }

    @Test
    public void testSubscriptionSuccess() {
        HomePage home = new HomePage(driver);
        home.enterSubscriptionEmail("qauser@example.com");
        home.clickSubscribe();
        String msg = home.getSubscriptionSuccessMessage();
        Assert.assertTrue(msg.contains("You have been successfully subscribed"), "Subscription failed.");
    }
}
