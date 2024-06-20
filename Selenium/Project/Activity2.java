import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity2 {
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



        String HeaderURL = driver.findElement(By.tagName("img")).getAttribute("src");
        System.out.println("Header Image URL: " + HeaderURL);
        driver.close();
    }
}