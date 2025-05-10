package Project_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    // Test for positive case login (valid credentials)
    @Test
    @Parameters({"validUsername", "validPassword"})
    public void testValidLogin(String username, String password) throws Exception {
        driver.navigate().to(baseUrl);

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Assert that the user is redirected to the homepage
        String actualTitle = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(actualTitle, expectedTitle);
        
        // Capture screenshot after successful login
        Utils.captureScreenshot(driver, "validLogin");
        
    }

    // Test for negative case login (invalid credentials)
    @Test
    @Parameters({"invalidUsername", "invalidPassword"})
    public void testInvalidLogin(String username, String password) throws Exception {
        driver.get(baseUrl);

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Assert that the error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

        // Capture screenshot after failed login
        Utils.captureScreenshot(driver, "invalidLogin");
    }
}
