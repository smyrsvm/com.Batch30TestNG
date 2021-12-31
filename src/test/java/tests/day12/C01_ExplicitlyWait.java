package tests.day12;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;
public class C01_ExplicitlyWait extends TestBase {

    @Test
    public void implicitlyWaitTest(){

        // metodunuza isim verirken javanin varolan hazir methodlarini kullanmayin.
        // Java da implicitlyWait diye method var mesela.Bunu kendi methodunuza isim
        // olarak kullandiginda daha sonra bu klassin icinde implicitlywait dediginde
        // java gidip senin yazdigin.Onun icin method ismimizin sonuna "test" kelimesini
        // ekledik

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        SoftAssert softAssert =new SoftAssert();
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed());
        softAssert.assertAll();

        // Assertequal da genellikle iki sey bakiyoruz.assertTrue da tek durum ile ilgili
        // Genel olarak sanki yukardaki durum

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 7. It’s back mesajinin gorundugunu test edin
        sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());
    }
    @Test
    public void explicitlyWaitTest(){

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini test edin.
        WebDriverWait wait=new WebDriverWait(driver,20);

        // expilcitlywait'i istersek locate islemi ile birlikte tek satirda yapabiliriz.
        // Bekleme ve locate i beraber yapiyor bu sekilde.
        // Locate ettigin element visible olana dek beklemis oluyor diyebiliriz.

        WebElement yaziLocateIleBirlikt= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(yaziLocateIleBirlikt.isDisplayed());

        // veya once locate edip uygun method kullanarak beklemeyi yaptirabiliriz
        // ancak bu test icin once webelement'i olusturmak anlamsiz olur
        // cunku biz wait islemini zaten o webelement olussun diye yapiyoruz
        // wait olmadan o element olmaz , o element olmadan da sectigimiz method calismaz

        /*
        Burada once locate ettik sonra bekledik. Yukrdakinde hem locate ettik hem bekledik gibi gibi
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
        Assert.assertTrue(sonucYazisi.isDisplayed());
        */

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        // 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackLocateIle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackLocateIle.isDisplayed());

    }
}
