package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_UploadFile extends TestBase {

    @Test
    public void test () throws InterruptedException {

        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // chooseFile butonuna basalim
        // Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu= System.getProperty("user.home")+"/Desktop";
        WebElement dosyaYukle =driver.findElement(By.id("file-upload"));
        dosyaYukle.sendKeys(dosyaYolu);

        // aslinda normalde choose file dedigimizde dosyayi getirmiyor,
        // yolu bu sayfaya gosteriyor. upload a bastigimizdan
        // bu web sayfasi o yoldaki seyi yukluyor.
        // Burada klasor yapisi icerisinde gezinerek dosyayi yuklemis olmuyoruz.
        // Dosyanin yolunu bu websitesine göstermis oluyoruz.

        // Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);
        // “File Uploaded!” textinin goruntulendigini test edelim.

        WebElement sonucYazisiElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonucYazisiElementi.isDisplayed());





    }





}
