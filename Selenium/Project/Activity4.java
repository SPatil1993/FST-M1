import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity4 {
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
        driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")).click();

        driver.findElement(By.xpath("//*[@id='menu_pim_viewEmployeeList']")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Amy Jackson");
        driver.findElement(By.cssSelector("#searchBtn")).click();

        String  firstName = driver.findElement(By.xpath("//table/tbody/tr/td[3]")).getText();
        String  lastName = driver.findElement(By.xpath("//table/tbody/tr/td[4]")).getText();
        System.out.println(firstName+" "+lastName);

        if (firstName.equals("Amy") && lastName.equals("Jackson")) {
            System.out.println("Data is found");
        } else {
            System.out.println("Data is not present");
        }
        driver.close();
    }
}