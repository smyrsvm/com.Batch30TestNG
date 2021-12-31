package tests.day10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.util.Set;
public class C03_MouseActions extends TestBase {
    @Test
    public void test(){

        // 1-Obje olustur.parametre olarak driver yaz.
        // Actions actions= new Actions(driver);
        // 2-Uzerinde calismak istediginiz Webelement ogesini bul
        // 3-sonra bu web element uzerinde action gerceklestirilir.Ornegin sag tiklamak icin
        // actions.contextClick(element).perform(); Burada element olusturdugum WebElementin ismi.
        // burada perform yazmak onemli

        //mouse ile doubleclick--cift tiklama
        //clickandHOld fareyi serbest birakmadan uzun tiklama yapar
        // drag and drop
        //move to element --yazinin uzerine gelme
        //contextclick-- sag tiklama yapar farede
        //bunlar method tabi yanlarinda parantez var.


        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement ciziliAlan= driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAllertYazisi="You selected a context menu";
        String actualAllertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(actualAllertYazisi,expectedAllertYazisi,"allert yazisi beklenenden farkli");

        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tiklayalim

        driver.findElement(By.linkText("Elemental Selenium")).click();

        String ilkSayfaHandle=driver.getWindowHandle();

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> windowTumHandlelar=driver.getWindowHandles();

        String ikinciSayfaHandle="";
        for (String each:windowTumHandlelar
        ) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=each;
            }
        }

        driver.switchTo().window(ikinciSayfaHandle);

        String expectedIkinciSayfaYazi="Elemental Selenium";
        String actualIkinciSayfaYazisi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualIkinciSayfaYazisi,expectedIkinciSayfaYazi,"ikinci sayfadaki yai istenenden farkli");
    }

}