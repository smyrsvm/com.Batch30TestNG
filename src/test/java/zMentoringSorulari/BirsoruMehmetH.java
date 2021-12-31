package zMentoringSorulari;

public class BirsoruMehmetH {

    /*


    Yeni Class olusturun ActionsClassHomeWork
1- "http://webdriveruniversity.com/Actions" sayfasina gidin
2- Hover over Me First" kutusunun ustune gelin
3- Link 1" e tiklayin
4- Popup mesajini yazdirin
5- Popup'i tamam diyerek kapatin
6- “Click and hold" kutusuna basili tutun
7-“Click and hold" kutusunda cikan yaziyi yazdirin
8- “Double click me" butonunu cift tiklayin

    public WebDriver driver;
    public SoftAssert softAssert = new SoftAssert();
    //public WebDriverWait wait=new WebDriverWait(driver,10);
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void popUp() throws InterruptedException {
        driver.navigate().to("http://webdriveruniversity.com/Actions");
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"))).build().perform();
        actions.click(driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"))).build().perform();
        System.out.println("Alert mesaji: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        actions.clickAndHold(driver.findElement(By.xpath("//div[@id='click-box']"))).build().perform();
        System.out.println("Click and hold text: "+driver.findElement(By.xpath("//div[@id='click-box']")).getText());
        actions.doubleClick(driver.findElement(By.xpath("//div[@id='double-click']"))).build().perform();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        softAssert.assertAll();
    }


   */









}
