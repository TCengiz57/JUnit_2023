package day06_notations_assertions;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfterNotasyonlari {

      /*
        bir class'in icinde her Test Method'undan once calismasini istediginiz
        siradan bir method varsa
        o method'un basina @Before kullanirsak
        @Test method'larinda CAGIRMAYA GEREK OLMADAN
        o method her test method'undan once calisir
        Ayni sekilde her test Method'undan sonra calismasini istedigimiz
        siradan bir method varsa
        @After notasyonu ile isaretleyebiliriz
     */

    // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
    // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){

        ReusableMethods.bekle(2);
        driver.close();
    }

    @Test
    public void amazonTest() {
        // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
        setup();
        driver.get("https://www.amazon.com");
        String expectedUrlIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Amazon testi PASSED");
        } else {
            System.out.println("Amazon testi FAILED");
        }

    }

    @Test
    public void wiseTesti() {
        // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
        setup();
        driver.get("https://www.wisequarter.com");
        String expectedTitleIcerik = "Wise";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)) {
            System.out.println("Wisequarter testi PASSED");
        } else {
            System.out.println("Wisequarter testi FAILED");
        }
        driver.close();
    }

    @Test
    public void youtubeTesti() {
        // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin
        setup();
        driver.get("https://www.youtube.com");
        String unexpectedTitleIcerik = "best";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(unexpectedTitleIcerik)) {
            System.out.println("Wisequarter testi FAILED");
        } else {
            System.out.println("Wisequarter testi PASSED");
        }
        driver.close();
    }
}