package Exercise;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class E01_actions extends TestBase {

    @Test

    public void test (){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu ");
        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan= driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlan).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        bekle(3);

        //5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();
        bekle(3);

        //6- Elemental Selenium linkine tiklayalim
        String herokuappWhd= driver.getWindowHandle();

        driver.findElement(By.linkText("Elemental Selenium")).click();
        bekle(3);

        Set<String> whseti= driver.getWindowHandles();
        String elementalWhd="";

        for (String each:whseti
             ) {
            if (!herokuappWhd.equals(whseti)){
                elementalWhd=each;
            }


        }


        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        driver.switchTo().window(elementalWhd);

        String expectedh1Yazi="Make sure your code lands";
        String actualh1Yazi=driver.findElement(By.xpath("//h1[@class='home-header']")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);



    }
}
