import dev.failsafe.internal.util.Assert;
//import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.time.Duration;

public class Activity6 {
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
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("menu_directory_viewDirectory"))));

//        WebElement Directory = driver.findElement(By.id("menu_directory_viewDirectory"));
//        driver.findElement(By.id("menu_directory_viewDirectory")).isEnabled();
//
//        String d = driver.findElement(By.cssSelector("#menu_directory_viewDirectory > b:nth-child(1)")).getText();
//        System.out.println("Displayed :"+Directory.isDisplayed());
//        System.out.println("Selected :"+Directory.isEnabled());
//        driver.findElement(By.cssSelector("#menu_directory_viewDirectory > b:nth-child(1)")).click();
        try {

            WebElement Directory = driver.findElement(By.id("menu_directory_viewDirectory"));
            Directory.click();
            System.out.println("Displayed Clicked");

            WebElement vv = driver.findElement(By.cssSelector("#menu_directory_viewDirectory > b:nth-child(1)"));
//
            System.out.println("Displayed :" + vv.isDisplayed());
            System.out.println("Selected :" + vv.isEnabled());

            String header = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1")).getText();
            System.out.println("Header is :"+header.equals("Search Directory"));


//            driver.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
//        WebElement ty = driver.findElement((By.xpath("//a[contains(@class,'toggle')]")));
//        System.out.println(ty.getText());

        driver.close();
    }
}