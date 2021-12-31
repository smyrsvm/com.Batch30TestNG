package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
public abstract class TestBase {

    //abstract yaparak bu class'dan obje olusturulmasinin onune geceriz
    protected WebDriver driver;

    //biz test base class'i sadece extends ile inherit ederek kullanacagiz
    //dolayisiyla olusturdugumuz driver variable'i icin
    //protected access modifier'i seciyoruz.
    //projelerimizde mumkun oldugunca variablelarimizin access modifierlarini
    //dusuk tutmaya calisiriz, bu bakimdan public yapmaya gerek yok.
    //protected ideal burada.ayni package ve child classlar erisim sagliyordu protected da.

    // Burada BeforeClass kullandik mesela ama BeforeMethod da kullanmam gerekseydi
    // o zaman ayri bir class olusturabilirdim.baska ad verirsin ama islev olarak
    // testbase gibi olur

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}