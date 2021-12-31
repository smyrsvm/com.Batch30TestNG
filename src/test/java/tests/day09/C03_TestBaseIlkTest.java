package tests.day09;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseIlkTest extends TestBase {


    @Test
    public void test(){

        //iki yontem var ya obje olustur
        //ikinci yontem inheritance.
        //inheritance ile TestBase`deki public methodlara vs ulasabiliyoruz
        // yalniz driver burda yok, babanin evine bak,onu kullanman icin parenttaki driver
        // public olmasi lazim.onu gidip public veya protected yapmak lazimdi, yaptik.


        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());




    }




}
