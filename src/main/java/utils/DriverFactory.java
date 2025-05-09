package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.UUID;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initializes the WebDriver instance based on the specified browser and mode.
     *
     * @param browser The browser type (e.g., "chrome", "firefox").
     * @param headless Whether to run in headless mode.
     */
    public static void initDriver(String browser, boolean headless) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();

            if (headless) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }

// Hardened arguments for CI Linux containers:
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-background-networking");
            options.addArguments("--disable-default-apps");
            options.addArguments("--disable-sync");
            options.addArguments("--metrics-recording-only");
            options.addArguments("--disable-gl-drawing-for-tests");
            options.addArguments("--mute-audio");
            options.addArguments("--remote-allow-origins=*");

// 💡 Temporary unique user data dir (safe even in parallel CI)
            String tempProfile = "/tmp/chrome-profile-" + UUID.randomUUID();
            options.addArguments("--user-data-dir=" + tempProfile);

            driver.set(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (headless) {
                options.addArguments("--headless");
            }
            driver.set(new FirefoxDriver(options));

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    /**
     * Retrieves the current WebDriver instance.
     *
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Quits the WebDriver instance and removes it from ThreadLocal storage.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
