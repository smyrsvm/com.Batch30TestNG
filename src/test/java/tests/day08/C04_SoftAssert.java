package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C04_SoftAssert {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {

        //1.“https://www.hepsiburada.com/” Adresine gidin
        driver.get("https://www.hepsiburada.com/");

        //2.Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin

        SoftAssert softAssert = new SoftAssert();
        System.out.println(driver.getTitle());
        softAssert.assertTrue(driver.getTitle().contains("Türkiye'nin En Büyük Online Alışveriş Sitesi"),
                "title istenen cumleyi icermiyor");

        //3.search kutusuna araba yazip arattirin
        driver.findElement(By.xpath("//input[@autocomplete=\"off\"]")).sendKeys("araba"+ Keys.ENTER);

        //4.bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.className("category-suggestion-title"));
        Thread.sleep(2000);
        System.out.println(sonucYazisi.getText());

        //5.sonuc yazisinin "araba" icerdigini dogrulayin
        softAssert.assertTrue(sonucYazisi.getText().contains("araba"), "sonuc yazisi araba icermiyor");


        //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        softAssert.assertFalse(sonucYazisi.getText().contains("oto"),"sonuc yazisi oto kelimesini iceriyor");

        softAssert.assertAll();

    }

    @AfterClass
    public void teardown (){
        driver.close();

    }


}
