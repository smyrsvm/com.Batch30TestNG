package zMentoringSorulari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class softAssert {
    /**
     *  Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */
    WebDriver driver;

    @BeforeClass
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }


    @Test
    public void test () throws InterruptedException {
        //Navigate to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

         //Enter the user name as standard_user

       WebElement userName =   driver.findElement(By.id("user-name"));
       userName.sendKeys("standard_user");

    // Enter the password as   secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

    //   * Click on login button
        driver.findElement(By.id("login-button")).click();

        // Choose price low to high


    WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropDown);
        select.selectByValue("lohi");

        //Verify item prices are sorted from low to high

        SoftAssert softassert = new SoftAssert();
        WebElement kontrol= driver.findElement(By.xpath("//option[@value=\"lohi\"]"));

        System.out.println(kontrol.getText());
        String expectedYazi= "Price (low to high)";
        softassert.assertTrue(kontrol.getText().contains(expectedYazi));
        Thread.sleep(2000);
        softassert.assertAll();








    }





}
