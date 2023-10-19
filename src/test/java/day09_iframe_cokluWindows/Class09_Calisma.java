package day09_iframe_cokluWindows;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class Class09_Calisma extends TestBase {


    @Test
    public  void odev(){

        //https://www.btkakademi.gov.tr/adresine gidin

        driver.get("https://www.btkakademi.gov.tr/");


        // Sayfa basliginin "BTK Akademi" icerdigini test edin

        String expectedBaslikIcerik="BTK Akademi";
        String actualBaslikIcerik=driver.getTitle();

        Assert.assertTrue(actualBaslikIcerik.contains(expectedBaslikIcerik));

        String btkWnh=driver.getWindowHandle();

        // Yeni bir window'da http://demo.guru99.com/test/guru99home/ adresine gidin

        driver.switchTo().newWindow(WindowType.TAB);//Kontrollu çoklu pencere
        driver.get("http://demo.guru99.com/test/guru99home/");


        // Sayfanın alt tarafındaki ilk iframedeki (youtube) paylaş butonunun görünürlüğünü test edin ve yazdırın

        WebElement youtube= driver.findElement(By.xpath("//iframe[@wmode='transparent']")); //iframe locate
        driver.switchTo().frame(youtube);//iframe Sayfasına geçiş driver'ı

        WebElement paylasButonu= driver.findElement(By.xpath("//div[@class='ytp-share-title']"));//Paylaş buton locate

        Assert.assertTrue(paylasButonu.isDisplayed());

        System.out.println(paylasButonu.getText());

       //paylaş butonunu tıklayın ana sayfaya dönün

        paylasButonu.click();
        bekle(2);
        driver.switchTo().defaultContent();



        // BTK sayfasına geri dönüp "Facebook Logosuna "  tiklayin

        driver.switchTo().window(btkWnh);

        driver.findElement(By.xpath("(//a[@class='hlink-text mr-3'])[1]")).click();//Kontrolsuz çoklu pencere olduğu için Set yapmamız gerekiyor

        Set<String> whdSeti = driver.getWindowHandles();

        String faceWhd="";

        for (String each: whdSeti
        ) {
            if (!each.equals(btkWnh)){
                faceWhd = each;
            }
        }
        driver.switchTo().window(faceWhd);

        //e postayı gir ve temizle

        WebElement email= driver.findElement(By.xpath("//input[@type='text']"));
        email.sendKeys("abc@gmail.com");
        bekle(2);

        email.clear();//Bende calismadi
        bekle(2);

        // BTK anasayfaya dönüp sayfayı kapatalım
        driver.switchTo().window(btkWnh);


        bekle(2);



    }

}
