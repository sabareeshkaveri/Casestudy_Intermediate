package Project_1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    // Read credentials or other parameters from a properties file
    public static String readProperty(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties");
        properties.load(inputStream);
        return properties.getProperty(key);
    }

    // Capture screenshot and save it
    public static void captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
    	String screenshort_loc = System.getProperty("user.dir") + "reports//screenshots/" + screenshotName + ".png";
    	File destinationFile = new File(screenshort_loc);
        File directory = destinationFile.getParentFile();
        if (!directory.exists()) {
            directory.mkdirs(); 
            System.out.println("Created directory: " + directory.getAbsolutePath());
        }
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile1 = new File(screenshort_loc);
        FileUtils.copyFile(screenshot, destinationFile1);

        System.out.println("Screenshot saved to " + screenshort_loc);
    }
}
