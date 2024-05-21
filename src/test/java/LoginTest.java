import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class LoginTest {
    @Test
    public void test() {
        // Initiate webdriver
        WebDriver driver;
        driver = new EdgeDriver();

        // Set property untuk versi 4.11 kebawah
        // System.setProperty("webdriver.chrome.driver", "~/msedgedriver");

        // Maximize windows browser
        driver.manage().window().maximize();

        // Navigate to google homepage
        driver.get("https://www.saucedemo.com");

        WebElement username = driver.findElement(By.id("user-name")); // Input username in username field.
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password")); // Input password in password field
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button")); // Click login button
        login.click();

        String expectedUrl = "https://www.saucedemo.com/inventory.html"; // Validate if actual URL is same with expected URL
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        WebElement text = driver.findElement(By.xpath("//*[contains(text(), 'Products')]")); // Validate if the “Products” text is shown.
        text.isDisplayed();

    }
}