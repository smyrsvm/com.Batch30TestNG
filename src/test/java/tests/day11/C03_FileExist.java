package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist  {

    @Test
    public void test (){

        // burada selenium kullanmiyoruz,selenium sadece web uygulamalari icin kullanilir.
        // java kullaniyoruz.Driver hic kullanmiyoruz.
        // Masaustundeki bir dosya yolunun tum bilgisayarlarda sorunsuz calismasi icin
        // dosya yolunu ikiye ayiracagiz.
        // 1. herkesin bilglsayarinda farkli olan kisim
        // bu kismi bilgisayardan kodu ile alabiliriz
        // 2.herkes icin ayni olan kisim.
        // BU kisim, 1. maddedeki yolun devami seklinde olur.
        // -----------------------------------------------------------------------------

        // Ornek: Masaustundeki picture dosyasi icin yol kaydedelim

        // picture dosya yolumuz-->    /Users/heaveninmyheart/Desktop


        // System.getProperty("user.home") ---> Kullanici klasörunu verir
        System.out.println("kullanici klasorunu verir "+System.getProperty("user.home")); //  sonuc-->  /Users/heaveninmyheart
        // /Users/heaveninmyheart Bu kisim herkeste farkli olan kisimdir ve bilglsayardan yukaridaki kod ile aliriz.

        String dosyaYoluDinamik= System.getProperty("user.home")+ "/Desktop";
        String dosyaYoluManuel="/Users/heaveninmyheart/Desktop";

        System.out.println("Dosya yolumuz "+dosyaYoluDinamik);

        // Files.exists(Paths.get(dosyaYoluManuel))--> Bilglsayarinizda dosyanin olup olmadigini kontrol eder
        System.out.println(Files.exists(Paths.get(dosyaYoluDinamik))); // true Dosya yolu varmis bilglsayarda
        Assert.assertTrue(Files.exists(Paths.get(dosyaYoluManuel))); // test passed


        System.out.println(System.getProperty("user.dir")); // Cevap: /Users/heaveninmyheart/IdeaProjects/com.Batch30TestNG
        // Icinde oldugumuz dosyanin yolunu verir. Bulunulan klasorun yolunu (path) verir.
        // Testlerimizi calistirdigimiz klasörün dosya yolunu alabiliriz.

        // Dosya Yolu dinamik herkeste calisir ama manuel calismaz.

    }



}
