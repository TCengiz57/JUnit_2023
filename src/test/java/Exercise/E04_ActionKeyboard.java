package Exercise;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class E04_ActionKeyboard extends TestBase {

    @Test

    public void test(){

        //2- https://www.amazon.com sayfasina gidelim

        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larini kullanarak

        //   Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        bekle(2);
        Actions actions=new Actions(driver);
        actions
                .click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71"+Keys.ENTER)
                .perform();


        //4- aramanin gerceklestigini test edin
        String expectedIcerik = "samsung a71";
        String actualSonucYazisi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        bekle(3);




    }

}