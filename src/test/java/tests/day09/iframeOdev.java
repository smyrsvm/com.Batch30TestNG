package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iframeOdev {

    /** http:demo.guru99.com/test/guru99home/ sitesine gidiniz
     * sayfadaki ifrma sayisini bulunuz
     * ilk framedeki (youtube) play butonuna tiklayiniz
     * ilk frameden cikip ana sayfaya donunuz
     * ikinci framedeki (Jmeter Made Easy) linke
     * (https://www.guru99.com/live-selenium-project.html) tiklayiniz
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
    public void test() throws InterruptedException {
        //http:demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http:demo.guru99.com/test/guru99home/");

        //sayfadaki ifrma sayisini bulunuz --2 adet var

/*
        //  2) sayfadaki iframe sayısını bulunuz.
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Sayfadaki IFrame sayisi : " + size);

        //    //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeSayisi=driver.findElements(By.tagName("iframe"));
        System.out.println("iframe sayisi : "+iframeSayisi.size());

 */

        //ilk framedeki (youtube) play butonuna tiklayiniz
        WebElement iframe1 = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframe1);
        WebElement button= driver.findElement(By.xpath("//button[@class=\"ytp-large-play-button ytp-button\"]"));
        button.click();

        //ilk frameden cikip ana sayfaya donunuz.
        driver.switchTo().defaultContent();

        //ikinci framedeki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tiklayiniz.

        driver.switchTo().frame("a077aa5e");
        WebElement link= driver.findElement(By.xpath("//img[@src=\"Jmeter720.png\"]"));
        link.click();

    }










}
