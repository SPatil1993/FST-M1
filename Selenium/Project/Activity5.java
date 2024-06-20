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

public class Activity5 {
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

//        String tex = driver.findElement(By.cssSelector("a#menu_pim_viewMyDetails > b:nth-child(1)")).getText();
        Info.click();
//        System.out.println(tex);

        driver.findElement(By.xpath("//input[@value='Edit']")).click();
        driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).clear();
        driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).sendKeys("Yuvraj");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Singh");
        driver.findElement(By.id("personal_optGender_1")).click();

        WebElement dropdown = driver.findElement(By.id("personal_cmbNation"));

        // Pass the WebElement to the Select object
        Select singleSelect = new Select(dropdown);

        // Select the second option using visible text
        singleSelect.selectByValue("82");

        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("1998-02-11");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        driver.close();
    }
}