package tests.base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String headlessProperty = System.getProperty("headless", "false");
        boolean headless = Boolean.parseBoolean(headlessProperty);
        DriverFactory.initDriver("chrome", headless);
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
