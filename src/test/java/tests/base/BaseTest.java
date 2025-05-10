package tests.base;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(Method method) {
        ExtentTest test = ExtentManager.getInstance().createTest(method.getName());
        ExtentTestManager.setTest(test);
        String headlessProperty = System.getProperty("headless", "false");
        boolean headless = Boolean.parseBoolean(headlessProperty);
        DriverFactory.initDriver("chrome", headless);
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getName());
            ExtentTestManager.getTest().fail(result.getThrowable());
            ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().pass("Test passed");
        }
        DriverFactory.quitDriver();
    }
}
