package Exercise;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class E03_MoveToElement extends TestBase {

    @Test
    public void move(){

        //1- https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //   mouse’u bu menunun ustune getirin
        WebElement listMenusu= driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(listMenusu).perform();
        bekle(3);

        //3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        String expectedlistYazisi="Your Lists";
        String actualListYazisi=driver.findElement(By.id("my-lists-tab")).getText();

        Assert.assertEquals(expectedlistYazisi,actualListYazisi);



    }
}
