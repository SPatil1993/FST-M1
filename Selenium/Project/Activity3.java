import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverWait wait;

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");


        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));

        //Enter values
        usernameField.sendKeys("orange");
        passwordField.sendKeys("orangepassword123");

        //Click Log in
        driver.findElement(By.name("Submit")).click();

        //        String loginMessage = driver.findElement(By.className("panelTrigger")).getText();
        String loginMessage = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1")).getText();
        System.out.println(loginMessage);
        driver.close();
    }
}