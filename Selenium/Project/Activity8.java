import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Create the Wait object

        driver.get("http://alchemy.hguy.co/orangehrm");
        System.out.println("Page title is: " + driver.getTitle());

        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));

        //Enter values
        usernameField.sendKeys("orange");
        passwordField.sendKeys("orangepassword123");

        //Click Log in
        driver.findElement(By.name("Submit")).click();

        driver.findElement(By.linkText("Apply Leave")).click();
        System.out.println(driver.findElement(By.xpath("//a[@href='href='/orangehrm/symfony/web/index.php/leave/applyLeave']")).getText());
    }
}