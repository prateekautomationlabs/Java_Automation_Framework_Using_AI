package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotDir = "test-output/screenshots/";
        String screenshotPath = screenshotDir + testName + ".png";

        try {
            Files.createDirectories(Paths.get(screenshotDir)); // Ensure directory exists
            Files.copy(srcFile.toPath(),
                    Paths.get(screenshotPath),
                    StandardCopyOption.REPLACE_EXISTING); // Overwrite if file exists
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
