import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7 {
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

        WebElement Info= driver.findElement(By.cssSelector("a#menu_pim_viewMyDetails > b:nth-child(1)"));
        wait.until(ExpectedConditions.visibilityOf(Info));
        driver.findElement(By.cssSelector("a#menu_pim_viewMyDetails > b:nth-child(1)")).click();

        String tex = driver.findElement(By.cssSelector("a#menu_pim_viewMyDetails > b:nth-child(1)")).getText();
        driver.findElement(By.cssSelector("a#menu_pim_viewMyDetails > b:nth-child(1)")).click();
        System.out.println(tex);

        driver.findElement(By.linkText("Qualifications")).click();
        driver.findElement(By.id("addWorkExperience")).click();

        driver.findElement(By.id("experience_employer")).sendKeys("XYZ");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        driver.close();
    }
}