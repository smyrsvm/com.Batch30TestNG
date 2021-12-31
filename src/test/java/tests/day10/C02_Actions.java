package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //amazon sayfasina gidin
        driver.get("https://amazon.com");

        // nutella icin arama yapin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        //9.urunu tiklayin
        //Burada 9.urun ekranda biraz asagida, onun icin sayfayi biraz elinle asagiya indirmen gerekiyor.
        //driver gozumuz gibidir, senin gorebildigini gorur.goremedigini goremez.NOsuch element veriyor
        //onun icin sayfayi asagiya elinle indirdiginde gorur.
        //tabii bunu elle indirmek yerine mouse actions ile de sayfa indirme "pagedown" olayini yapabiliriz
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@data-image-index='9']")).click();




    }








}
