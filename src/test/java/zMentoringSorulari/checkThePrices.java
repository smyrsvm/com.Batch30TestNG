package zMentoringSorulari;

public class checkThePrices {
    /*
    package extraProject;
​
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
​
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Proje01 {
   //Navigate to "https://react-shopping-cart-67954.firebaseapp.com/"
// List all the elements on the website
// Create a String Arraylist and put Product Names into the ArrayList
// Choose 5 items randomly, add to cart and print the names of items
// (Each product cannot be added more then 1 time!)

// CHECK THE PRICES!
// Sum each item's price and compare your result with the website
// If results are matching print success message
// Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
// Click Checkout

    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    @Test
    public void fullItem() throws InterruptedException {

        List<WebElement> item=driver.findElements(By.className("shelf-item__title"));
        int i=1;
        for (WebElement w:item) {

            System.out.println(i+++". item: "+w.getText());

        }
        ArrayList<String>allItem=new ArrayList<>();
        for (WebElement each:item) {
            allItem.add(each.getText());
        }

        List<String> hamper=new ArrayList<>();
        String money[]=new String[5];

        int y=0;
        Random rand=new Random();
        do {

        int randomlyHamper=rand.nextInt(15)+1;
        if (!hamper.contains(allItem.get(randomlyHamper-1))) {
            hamper.add(allItem.get(randomlyHamper-1));
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//div[@class='shelf-item__buy-btn'])["+randomlyHamper+"]")).click();
            Thread.sleep(1000);
            WebElement price= driver.findElement(By.xpath("(//div[@class='val'])["+randomlyHamper+"]"));

            money[y++]=price.getText();

        }
        }

        while(hamper.size()<5);
        System.out.println("5 tane sizin icin sectigimiz ve sepetinize ekledigimiz random urunler: "+hamper);
        System.out.println("secilen urunlerin sirasi ile fiyatlari: "+Arrays.toString(money));

        double totaly=0;
        for(int j=0;j<5;j++){

            totaly+=Double.parseDouble(money[j].replace("$",""));
        }
        System.out.print("Sepetinizdeki urunlerin toplam fiyati: $");
        System.out.println(new DecimalFormat("##.##").format(totaly).replace(",", "."));

        WebElement webTotaly=driver.findElement(By.className("sub-price__val"));
        String webTotal=webTotaly.getText();
        double price=Double.parseDouble(webTotal.replace("$",""));

      DecimalFormat df = new DecimalFormat("##.##");
      df.format(totaly);

      Assert.assertEquals("difference between the expected totaly and the actual price",totaly,price,0.01);

        System.out.println("Hesaplanan urun fiyati ile sepetinizdeki fiyat eslesiyor!!!");

        ArrayList<Double> pay=new ArrayList<Double>();
        System.out.print("fiyat Listesi: ");
        for(int k=0;k<5;k++){

            pay.add(Double.parseDouble(money[k].replace("$","")));
            System.out.print(pay.get(k)+"$  ");
        }

        driver.findElement(By.xpath("//div[@class='buy-btn']")).click();

        WebDriverWait w = new WebDriverWait(driver, 10);
        Alert alert = w.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        alert.accept();

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }


}
     */



    /**
    Yusuf Hoca cozumu:


    chromedriver.exe de kendi path inizi yazmayi unutmayin..

    package practiceLessons;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ReactShoppingTest {

    Navigate to "https://react-shopping-cart-67954.firebaseapp.com/"
//// List all the elements on the website
//// Create a String Arraylist and put Product Names into the ArrayList
//// Choose 5 items randomly, add to cart and print the names of items
//// (Each product cannot be added more then 1 time!)
//
//// CHECK THE PRICES!
//// Sum each item's price and compare your result with the website
//// If results are matching print success message
//// Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
//// Click Checkout

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver",
                "C:/Users/asus/Documents/selenium dependencies/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");

        Thread.sleep(5000); // Don't create this first wait for the exception //

        // List all the elements on the website
        List<WebElement> allProducts = driver.findElements(By.className("shelf-item__title"));

        // Create a String Arraylist and put Product Names into the ArrayList
        List<String> allProductsStringList = new ArrayList<>();

        for (int i = 0; i < allProducts.size(); i++) {

            allProductsStringList.add(allProducts.get(i).getText());

        }
        System.out.println("All product list -->" + allProductsStringList);


        System.out.println("----------------------");
        System.out.println("CHOSEN ITEMS:");



        // Choose 5 items randomly, add to cart and print the names of items
        // Each product cannot be added more then 1 time!
        List<Integer> itemsAddedToCart = new ArrayList<>();

        while (itemsAddedToCart.size() < 5) {

            Random rnd = new Random();

            int a = rnd.nextInt(allProducts.size());

            if (!itemsAddedToCart.contains(a)) {

                itemsAddedToCart.add(a);

                allProducts.get(a).click();

                Thread.sleep(1000);

                driver.findElement(By.xpath("//div[@class='float-cart__close-btn']")).click();

                Thread.sleep(1000);
            }
        }

        driver.findElement(By.xpath("//span[@class='bag bag--float-cart-closed']")).click();

        Thread.sleep(1000);

//        // CHECK THE PRICES
//        // Sum each item's price and compare your result with the website
//        // If results are matching print success message
//
        List<WebElement> eachItemPrice = driver.findElements(By.xpath("//div[@class='float-cart__content']//div[@class='shelf-item__price']"));

        List<Double> eachPriceDouble = new ArrayList<>();

        double total = 0;

        // Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
        for (int k = 0; k < eachItemPrice.size(); k++) {

            String myString = eachItemPrice.get(k).getText();

            myString = myString.replaceAll("[^\\d]", ""); // remove all the non numeric char (letter or special character)

            double myD = Double.parseDouble(myString);

            eachPriceDouble.add(myD);

            total += myD;
        }

        System.out.println("Price List -->" + eachPriceDouble);


        String totalPriceWebSite = driver.findElement(By.xpath("//p[@class='sub-price__val']")).getText();

        totalPriceWebSite = totalPriceWebSite.replaceAll("[^\\d]", "");

        double totalPriceFromWebsite = Double.parseDouble(totalPriceWebSite);

        System.out.println("Result of our calculation for the total price --> " + total);
        System.out.println("Reslt of Website for the total price --> " + totalPriceFromWebsite);
        System.out.println("--> " + totalPriceWebSite);

        Thread.sleep(4000);

        Assert.assertTrue(total == totalPriceFromWebsite);
        System.out.println("Expected result and your result is matching");


        // Click Checkout
        driver.findElement(By.xpath("//div[text()='Checkout']")).click();


        // Handle Alerts
        driver.switchTo().alert().accept();
    }
}


     */





}
