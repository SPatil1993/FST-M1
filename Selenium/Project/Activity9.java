package LMS_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Activity9
{
    WebDriver wd;

    @BeforeClass
    public void openTheHomePage()
    {
        wd = new FirefoxDriver();
        wd.get("https://alchemy.hguy.co/lms");

        //Loggging in with root credentials
        wd.findElement(By.cssSelector("#menu-item-1507 > a:nth-child(1)")).click();
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.findElement(By.xpath("//*[@id=\"uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91\"]/div[2]/div[2]/a")).click();
        WebDriverWait wait1 = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.findElement(By.id("user_login")).sendKeys("root");
        wd.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        wd.findElement(By.id("wp-submit")).click();

    }
    @Test
    public void completingCourse()
    {
        //Now starting Activity 9 steps.
        //Since it already shows that training is 100% complete, verifying that status of the lesson shows "COMPLETE"
        wd.findElement(By.xpath("//*[@id=\"menu-item-1508\"]/a")).click();
        wd.findElement(By.cssSelector("#post-69 > div:nth-child(3) > p:nth-child(3) > a:nth-child(1)")).click();
        String courseTitle = wd.findElement(By.cssSelector("div.ld-item-list-item:nth-child(1)")).getText();
        wd.findElement(By.cssSelector("div.ld-item-list-item:nth-child(1) > div:nth-child(1) > a:nth-child(1)")).click();
        String lessonTitle = wd.findElement(By.cssSelector(".ld-focus-content > h1:nth-child(1)")).getText();
        Assert.assertEquals(lessonTitle,"Developing Strategy");
        String statusOfLesson = wd.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div[2]")).getText();
        Assert.assertEquals(statusOfLesson,"COMPLETE");
    }

    @AfterClass
    public void closeBrowser()
    {
        wd.quit();
    }
}
