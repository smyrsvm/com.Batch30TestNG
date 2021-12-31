package tests.day08;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;
public class C02_SoftAssertion {

    //3 asama
    //SoftAssert classindan obje olustur.-->  SoftAssert softAssert =new SoftAssert();
    //Obje ile testlerini yap. softAssert. ....
    // softAssert.assertAll();
    //soft assert objesi olusturdugunda hemen altina assertAll 3.asamayi yaz ki  sonra unutma.
    //verify diyorsa soft assertion kullaniriz.
    //test et veya assert diyorsa hard assert kullaniriz.
    //-----------------------------------------------------------------------------------
    // amazon sayfasina gidin
    // url'in amazon icerdigini test edin
    // title'in amazon icerdigini test edin
    // java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin
    // testleri soft assertion ile yapin

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test(){

        SoftAssert softAssert =new SoftAssert();
        driver.get("https://www.amazon.com");
        // url'in amazon icerdigini test edin
        softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"),"url amazon icermiyor");

        // title'in amazon icerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("amazon"),"title amazon icermiyor");
        System.out.println("assertion failed oldugu halde bu satir calisir");

        // java kelimesi aratin ve listedeki ilk urunun java kelimesi icerdigini test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        softAssert.assertTrue(ilkUrun.getText().contains("java"),"ilk urun java icermiyor");
        softAssert.assertAll();// bunu yazmazsan tests failed olsa bile kendisi bir kenara yazar ama
        // rapor etmez ve sana da tests passed der.

        // assertion'lar pass olsa da olmasa da assertAll'u gorene kadar tum satirlar calistir
        // ama eger testlerden bir tanesi bile failed ise assertAll'dan sonra execution stops
        System.out.println("assertion failed oldugunda bu satir calismaz");
        //Bu methodun calismasi durur ama siradaki method olan After class methoduna gecer ve calistirir.
        //Genel bir kuraldir bu.sadece soft assertlar ile ilglil bir sey olmamasi lazim.
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
