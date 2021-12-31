package tests.day11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownLoad extends TestBase {

    @Test
    public void downloadTest () throws InterruptedException {

        // Bu test metodunun ismini degistirip zdownloadTest yaparsak, fail olur.
        // TestNG isim sirasina gore test ettiginden, önce isExist metodunu calistirir.
        // Dolayisiyla download olmadan test yapmis olur ki, tabii ki is not exist, test fails
        // Bu durumda depends on veya prioroty yapabilirim.

        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        // logo.png  dosyasını indirelim

        driver.findElement(By.xpath("//a[text()=\"logo.png\"]")).click();

        // download oldugundan indirmesi icin zaman vermem gerekiyor.
        Thread.sleep(5000);
    }

    @Test
    public void isExist () { // burada tum classi calistirmayalim.Mesela sadece bunu calistiralim. Yoksa tekrar tekrar
                            // indirme olur.

        // Ardından isExist() methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        //  /Users/heaveninmyheart/Downloads --- dosyamin yolu bu

       String dosyaYolu= System.getProperty("user.home") +"/Downloads";
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }




}
